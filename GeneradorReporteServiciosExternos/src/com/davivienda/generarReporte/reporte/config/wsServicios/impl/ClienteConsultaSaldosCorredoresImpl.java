package com.davivienda.generarReporte.reporte.config.wsServicios.impl;

import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.reporte.config.wsServicios.DataHeaderComunESB;
import com.davivienda.generarReporte.reporte.config.wsServicios.HandlerGeneracionReportes;
import com.davivienda.generarReporte.reporte.config.wsServicios.IClienteServicios;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Valor;
import com.davivienda.generarReporte.servicios.representativos.DataHeaderReqType;
import com.davivienda.generarReporte.servicios.representativos.DataReqType;
import com.davivienda.generarReporte.servicios.representativos.DocumentosRepresentativosUnificadaHTTPService;
import com.davivienda.generarReporte.servicios.representativos.DocumentosRepresentativosUnificadaPortType;
import com.davivienda.generarReporte.servicios.representativos.RequestDocumentosRepresentativosUnificadaType;
import com.davivienda.generarReporte.servicios.representativos.ResponseDocumentosRepresentativosUnificadaType;
import com.ibm.cache.bo.particular.DataEndPoint;
import com.ibm.cache.bo.particular.EndPoint;
import com.ibm.cache.bo.particular.ParametrosSoapServicio;
import com.ibm.comunes.log.Logger;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;

public class ClienteConsultaSaldosCorredoresImpl
        extends ClienteServiciosAbstract
        implements IClienteServicios<ResponseDocumentosRepresentativosUnificadaType> {

    private final DataHeaderComunESB headerComunESB;
    private final ParametrosSoapServicio paramSoapService;
    private RequestDocumentosRepresentativosUnificadaType request;
    private final String nombre;
    private static final String CARACTER_ACEPTACION_OK = "B";
    private int  valTerminalAsig = 0;
    public ClienteConsultaSaldosCorredoresImpl(Logger logger, String nom) throws ErrorExternServiceException {
        super(logger);
        this.headerComunESB = obtenerHeaderDelServicio("clienteSOAPSaldosCorredores");
        this.paramSoapService = obtenerServicioDelConfig("clienteSOAPSaldosCorredores");
        this.nombre = nom;
    }

    public String getNombre() throws ErrorExternServiceException {
        return this.nombre;
    }

    public void nuevo(short idCanal) throws ErrorExternServiceException {
        setRequest(null);
        verificarCanal(this.paramSoapService, idCanal);
        if (this.service == null) {
            this.service = (Service) new DocumentosRepresentativosUnificadaHTTPService();
        }
    }

    public void asignarInformacion(MsjSolOpGeneracionReporte infoRequestMsg, BigDecimal valor) throws ErrorExternServiceException {
        this.request = new RequestDocumentosRepresentativosUnificadaType();
        DataHeaderReqType header = new DataHeaderReqType();
        DataReqType dataReq = new DataReqType();
        try {
            header.setCanal(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
            header.setJornada(Short.valueOf(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getValJornada()).shortValue());
            header.setModoDeOperacion(this.headerComunESB.getModoDeOperacion());
            header.setNombreOperacion(this.headerComunESB.getNombreOperacion());
            header.setPerfil(Short.valueOf(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getValPerfil()).shortValue());
            header.setTotal(this.headerComunESB.getTotal());
            header.setUsuario(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getCodUsuario());
            header.setIdTransaccion(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getIdTransaccion());

            
            valTerminalAsig = header.getTotal();
            for (int index = 0; index < this.paramSoapService.getEndPointsPorCanal().size(); index++) {

                DataEndPoint dataEndPoint = ((EndPoint) this.paramSoapService.getEndPointsPorCanal().get(index)).getEndPoint();
                String canal = dataEndPoint.getCanal();
                Short canalOrigen = Short.valueOf(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
                if (canalOrigen.shortValue() == Short.parseShort(canal)) {

                    header.setVersionServicio(dataEndPoint.getVersion());

                    break;
                }
            }

            List<Valor> listaParametros = infoRequestMsg.getListaParametros().getValParametro();

            String secuencia = ((Valor) listaParametros.get(1)).getValor().get(0);
            if (secuencia == null || "".equals(secuencia)) {
                throw new ErrorExternServiceException("Error secuencia nula o vacia");
            }
            dataReq.setValSecuencia(secuencia);

            try {
                String fechaInicio = ((Valor) listaParametros.get(0)).getValor().get(0);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date dateInicio = format.parse(fechaInicio);
                GregorianCalendar gcal = (GregorianCalendar) GregorianCalendar.getInstance();
                gcal.setTime(dateInicio);
                XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
                dataReq.setFecFechaInicio(xgcal);
            } catch (Exception ex) {
                throw new ErrorExternServiceException("Error formato fecha inicio ");
            }

            try {
                String fechaFinal = ((Valor) listaParametros.get(0)).getValor().get(1);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date dateFinal = format.parse(fechaFinal);
                GregorianCalendar gcal = (GregorianCalendar) GregorianCalendar.getInstance();
                gcal.setTime(dateFinal);
                XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
                dataReq.setFecFechaFinal(xgcal);
            } catch (Exception ex) {
                throw new ErrorExternServiceException("Error formato fecha final");
            }

            dataReq.setValNumeroProducto(infoRequestMsg.getProducto().getNumeroProducto());
            dataReq.setValTalon(0);
            dataReq.setCodOficina(0);
            dataReq.setCodTipoProducto(Integer.parseInt(infoRequestMsg.getProducto().getCodigoTipoProducto()));

            this.request.setData(dataReq);
            this.request.setDataHeader(header);
        } catch (NumberFormatException ex) {
            this.logger.error("Error al convertir una cadena a Numerico.", ex);
            throw new ErrorExternServiceException("45", "Error al convertir una cadena a Numerico.", ex);
        }
    }

    public Object invocar() throws ErrorExternServiceException {
        this.logger.info("inicio invocar: DocumentosRepresentativosUnificada con terminal = " + valTerminalAsig);
        DocumentosRepresentativosUnificadaPortType proxy = ((DocumentosRepresentativosUnificadaHTTPService) this.service).getDocumentosRepresentativosUnificadaSOAPHTTPPort();

        BindingProvider mBinding = (BindingProvider) proxy;
        this.logger.debug("BindingProviderProperties.REQUEST_TIMEOUT = " + this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("javax.xml.ws.service.endpoint.address", this.paramSoapService.getEndpoint());
        mBinding.getRequestContext().put("com.sun.xml.ws.request.timeout", Integer.valueOf(this.paramSoapService.getTimeOut()));
        mBinding.getRequestContext().put("com.sun.xml.ws.connect.timeout", Integer.valueOf(this.paramSoapService.getTimeOut()));
        HandlerGeneracionReportes handlerGeneracionReportes = new HandlerGeneracionReportes(this.logger, "UTF-8");

        List<Handler> handlerChain = mBinding.getBinding().getHandlerChain();
        handlerChain.add(handlerGeneracionReportes);
        mBinding.getBinding().setHandlerChain(handlerChain);
        ResponseDocumentosRepresentativosUnificadaType response = null;
        String errorMsj = null;
        long ini = 0L, fin = 0L;

        try {
            this.logger.debug("Se consumirservicio al endpoint: " + this.paramSoapService.getEndpoint());
            ini = System.currentTimeMillis();
            response = proxy.documentosRepresentativosUnificada(this.request);
            if (response != null) {
                if (response.getDataHeader() != null) {
                    if (response.getDataHeader().getCaracterAceptacion().equalsIgnoreCase("B")) {
                        if (response.getData() != null) {
                            errorMsj = "OK";
                        } else {
                            errorMsj = "DocumentosRepresentativosUnificada: Data de consulta de representativos es null";
                        }
                    } else {
                        errorMsj = "DocumentosRepresentativosUnificada: " + response.getDataHeader().getMsgRespuesta();
                    }
                } else {
                    errorMsj = "DocumentosRepresentativosUnificada: Dataheader de consulta de ahorros es null";
                }
            } else {
                errorMsj = "DocumentosRepresentativosUnificada: Error al consumir el servicio del BUS";
            }
            fin = System.currentTimeMillis();
        } catch (Exception ex) {
            fin = System.currentTimeMillis();
            this.logger.error(ex.getMessage(), ex);
            String mensaje = "Error al consumir el servicio DocumentosRepresentativosUnificada";
            if (ex.getMessage() != null) {
                mensaje = mensaje + ", Mensaje: " + ex.getMessage();
            }
            if (ex.getCause() != null) {
                mensaje = mensaje + ", Causa: " + ex.getCause().toString();
            }

            throw new ErrorExternServiceException("42", mensaje, ex);
        } finally {
            long total = fin - ini;
            this.logger.debug("Tiempo de consumo de servicio DocumentosRepresentativosUnificada : " + total + " MS");
        }
        this.logger.info("fin invocar: DocumentosRepresentativosUnificada");
        if (errorMsj.equals("OK")) {
            return response;
        }
        return errorMsj;
    }

    public RequestDocumentosRepresentativosUnificadaType getRequest() {
        return this.request;
    }

    public void setRequest(RequestDocumentosRepresentativosUnificadaType request) {
        this.request = request;
    }
}
