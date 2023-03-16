package com.davivienda.generarReporte.reporte.config.wsServicios.impl;

import co.com.davivienda.consultacertificacionPreventaContragarantia.ConsultaCertificadoProductoHTTPService;
import co.com.davivienda.consultacertificacionPreventaContragarantia.ConsultaCertificadoProductoPortType;
import co.com.davivienda.consultacertificacionPreventaContragarantia.ConsultaCertificadoProductoRequestType;
import co.com.davivienda.consultacertificacionPreventaContragarantia.ConsultaCertificadoProductoResponseType;
import co.com.davivienda.consultacertificacionPreventaContragarantia.DataHeaderReqType;
import co.com.davivienda.consultacertificacionPreventaContragarantia.DataReqType;
import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.reporte.config.wsServicios.DataHeaderComunESB;
import com.davivienda.generarReporte.reporte.config.wsServicios.HandlerDhcp;
import com.davivienda.generarReporte.reporte.config.wsServicios.IClienteServicios;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.ibm.cache.bo.particular.DataEndPoint;
import com.ibm.cache.bo.particular.EndPoint;
import com.ibm.cache.bo.particular.ParametrosSoapServicio;
import com.ibm.comunes.log.Logger;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

public class ClienteConsultaCertificadoPreventaContragarantiaImpl extends ClienteServiciosAbstract implements IClienteServicios<ConsultaCertificadoProductoResponseType> {

    private static final String NOMBRE_CLIENTWS_CONSULTA_PRODUCTOS = "clienteSOAPPreventaContragarantias";
    private static final String CARACTER_ACEPTACION_OK = "B";
    private final DataHeaderComunESB headerComunESB = this.obtenerHeaderDelServicio("clienteSOAPPreventaContragarantias");
    private final ParametrosSoapServicio paramSoapService = this.obtenerServicioDelConfig("clienteSOAPPreventaContragarantias");
    private ConsultaCertificadoProductoRequestType request;
    private final String nombre;
    private int  valTerminalAsig = 0;
    private static final String CODIGO_STATUS_OK = "0000";

    public ClienteConsultaCertificadoPreventaContragarantiaImpl(Logger logger, String nom) throws ErrorExternServiceException {
        super(logger);
        this.nombre = nom;
    }

    public String getNombre() throws ErrorExternServiceException {
        return this.nombre;
    }

    public void nuevo(short idCanal) throws ErrorExternServiceException {
        this.setRequest((ConsultaCertificadoProductoRequestType) null);
        this.verificarCanal(this.paramSoapService, idCanal);
        if (this.service == null) {
            this.service = new ConsultaCertificadoProductoHTTPService();
        }

    }

    public void asignarInformacion(MsjSolOpGeneracionReporte infoRequestMsg, BigDecimal valor) throws ErrorExternServiceException {
        try {
            this.request = new ConsultaCertificadoProductoRequestType();
            DataHeaderReqType header = new DataHeaderReqType();
            header.setCanal(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
            header.setModoDeOperacion(this.headerComunESB.getModoDeOperacion());
            header.setNombreOperacion("ConsultaCertificadoProducto");
            header.setJornada(Short.valueOf(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getValJornada()));
            header.setPerfil(Short.valueOf(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getValPerfil()));
            header.setTotal(this.headerComunESB.getTotal());
            header.setUsuario(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getCodUsuario());
            header.setIdTransaccion(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getIdTransaccion());

            
            valTerminalAsig = header.getTotal();
            for (int index = 0; index < this.paramSoapService.getEndPointsPorCanal().size(); ++index) {
                DataEndPoint dataEndPoint = ((EndPoint) this.paramSoapService.getEndPointsPorCanal().get(index)).getEndPoint();
                String canal = dataEndPoint.getCanal();
                Short canalOrigen = infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal();
                if (canalOrigen == Short.parseShort(canal)) {
                    header.setVersionServicio(dataEndPoint.getVersion());
                    break;
                }
            }

            DataReqType data = new DataReqType();
            data.setValNumeroProducto(infoRequestMsg.getProducto().getNumeroProducto());
            infoRequestMsg.getProducto().getFechaApertura();
            Date dateInicio = infoRequestMsg.getProducto().getFechaApertura();
            GregorianCalendar gcal = (GregorianCalendar) GregorianCalendar.getInstance();
            gcal.setTime(dateInicio);
            XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            data.setFecCertificacion(xgcal);
            data.setValCodigoOficina("0");
            data.setValTalon("0");
            this.request.setDataHeader(header);
            this.request.setData(data);
        } catch (NumberFormatException var8) {
            this.logger.error(var8.getMessage(), var8);
            throw new ErrorExternServiceException("45", "Error al convertir una cadena a Numerico.", var8);
        } catch (DatatypeConfigurationException var9) {
            this.logger.error(var9.getMessage(), var9);
            throw new ErrorExternServiceException("45", "Error al convertir una cadena a Numerico.", var9);
        }
    }

    public Object invocar() throws ErrorExternServiceException {
        this.logger.info("inicio invocar certificacion de garantias con terminal = " + valTerminalAsig);
        ConsultaCertificadoProductoPortType proxy = ((ConsultaCertificadoProductoHTTPService) this.service).getConsultaCertificadoProductoHTTPPort();
        BindingProvider mBinding = (BindingProvider) proxy;
        this.logger.debug("BindingProviderProperties.REQUEST_TIMEOUT = " + this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("javax.xml.ws.service.endpoint.address", this.paramSoapService.getEndpoint());
        mBinding.getRequestContext().put("com.sun.xml.ws.request.timeout", this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("com.sun.xml.ws.connect.timeout", this.paramSoapService.getTimeOut());
        String dhcp = "lPXwbqWSwVTyGftsoxTWBLxsflRyFd0EYEhaDdNb+/FUReyN8xLWDtNDKwY7k4s/";
        HandlerDhcp handler = new HandlerDhcp(this.logger, "UTF-8", dhcp);
        List<Handler> handlerChain = mBinding.getBinding().getHandlerChain();
        handlerChain.add(handler);
        mBinding.getBinding().setHandlerChain(handlerChain);
        ConsultaCertificadoProductoResponseType response = null;
        long ini = 0L;
        long fin = 0L;
        String errorMsj = null;
        boolean var19 = false;

        try {
            var19 = true;
            this.logger.info("Se consumirá servicio al endpoint: " + this.paramSoapService.getEndpoint());
            ini = System.currentTimeMillis();
            response = proxy.consultaCertificadoProducto(this.getRequest());
            if (response != null) {
                if (response.getDataHeader() != null) {
                    if (response.getDataHeader().getCaracterAceptacion().equalsIgnoreCase("B")) {
                        if (response.getData() != null) {
                            errorMsj = "OK";
                            var19 = false;
                        } else {
                            errorMsj = "clienteSOAPPreventaContragarantias: Data de consulta de ahorros es null";
                            var19 = false;
                        }
                    } else {
                        errorMsj = "clienteSOAPPreventaContragarantias: " + response.getDataHeader().getMsgRespuesta();
                        var19 = false;
                    }
                } else {
                    errorMsj = "clienteSOAPPreventaContragarantias: Dataheader de consulta de ahorros es null";
                    var19 = false;
                }
            } else {
                errorMsj = "clienteSOAPPreventaContragarantias: Error al consumir el servicio del BUS";
                var19 = false;
            }
        } catch (Exception var20) {
            fin = System.currentTimeMillis();
            new ConsultaCertificadoProductoResponseType();
            this.logger.error(var20.getMessage(), var20);
            String mensaje = "Error al consumir el servicio clienteSOAPPreventaContragarantias " + var20.getMessage();
            throw new ErrorExternServiceException("42", mensaje, var20);
        } finally {
            if (var19) {
                long total = fin - ini;
                this.logger.info("Tiempo de consumo de servicio clienteSOAPPreventaContragarantias : " + total + " MS");
            }
        }

        long total = fin - ini;
        this.logger.info("Tiempo de consumo de servicio clienteSOAPPreventaContragarantias : " + total + " MS");
        return errorMsj.equals("OK") ? response : errorMsj;
    }

    public ConsultaCertificadoProductoRequestType getRequest() {
        return this.request;
    }

    public void setRequest(ConsultaCertificadoProductoRequestType request) {
        this.request = request;
    }
}
