package com.davivienda.generarReporte.reporte.config.wsServicios.impl;

import co.com.davivienda.consultasproducto.ConsultasProductosHTTPService;
import co.com.davivienda.consultasproducto.ConsultasProductosPortType;
import co.com.davivienda.consultasproducto.DataHeaderReqType;
import co.com.davivienda.consultasproducto.DataReqType;
import co.com.davivienda.consultasproducto.RequestType;
import co.com.davivienda.consultasproducto.ResponseType;
import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.reporte.config.wsServicios.DataHeaderComunESB;
import com.davivienda.generarReporte.reporte.config.wsServicios.HandlerGeneracionReportes;
import com.davivienda.generarReporte.reporte.config.wsServicios.IClienteServicios;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.ibm.cache.bo.particular.ParametrosSoapServicio;
import com.ibm.comunes.log.Logger;
import java.math.BigDecimal;
import java.util.List;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;

public class ClienteConsultaProductosImpl
        extends ClienteServiciosAbstract
        implements IClienteServicios<ResponseType> {

    private static final String NOMBRE_CLIENTWS_CONSULTA_PRODUCTOS = "clienteSOAPProductos";
    private static final String CARACTER_ACEPTACION_OK = "B";
    private final DataHeaderComunESB headerComunESB;
    private final ParametrosSoapServicio paramSoapService;
    private RequestType request;
    private final String nombre;
    private static final String CODIGO_STATUS_OK = "0000";
    private int  valTerminalAsig = 0;

    public ClienteConsultaProductosImpl(Logger logger, String nom) throws ErrorExternServiceException {
        super(logger);
        this.headerComunESB = obtenerHeaderDelServicio("clienteSOAPProductos");
        this.paramSoapService = obtenerServicioDelConfig("clienteSOAPProductos");
        this.nombre = nom;
    }

    public String getNombre() throws ErrorExternServiceException {
        return this.nombre;
    }

    public void nuevo(short idCanal) throws ErrorExternServiceException {
        setRequest(null);
        verificarCanal(this.paramSoapService, idCanal);
        if (this.service == null) {
            this.service = (Service) new ConsultasProductosHTTPService();
        }
    }

    public void asignarInformacion(MsjSolOpGeneracionReporte infoRequestMsg, BigDecimal valor) throws ErrorExternServiceException {
        try {
            this.request = new RequestType();
            DataHeaderReqType header = new DataHeaderReqType();
            header.setCanal(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
            header.setModoDeOperacion(this.headerComunESB.getModoDeOperacion());
            header.setNombreOperacion("ConsultasProductos");
            header.setJornada(Short.valueOf(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getValJornada()).shortValue());
            header.setPerfil(Short.valueOf(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getValPerfil()).shortValue());
            header.setTotal(this.headerComunESB.getTotal());
            header.setUsuario(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getCodUsuario());
            header.setVersionServicio(this.headerComunESB.getVersionServicio());
            header.setIdTransaccion(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getIdTransaccion());

            DataReqType data = new DataReqType();
            data.setValNumeroProducto("0");
            data.setCodProducto((short) 0);
            data.setCodSubProducto((short) 0);
            data.setValCompania("0");
            data.setValVinculacion((short) 0);
            data.setValIndicadorConsultarCertificadoCDTS((short) 0);
            data.setValIndicadorConsultarCreditosFM((short) 0);
            data.setValIndicadorConsultarCuentasAhorros((short) 1);
            data.setValIndicadorConsultarCuentasCorrientes((short) 1);
            data.setValIndicadorConsultarDabuenvida((short) 0);
            data.setValIndicadorConsultarEstablecimientos((short) 0);
            data.setValIndicadorConsultarFondosInversion((short) 0);
            data.setValIndicadorConsultarTarjetasCreditoAmparadas((short) 0);
            data.setValIndicadorConsultarTarjetasCreditoPropias((short) 0);
            data.setValNumeroIdentificacion(Long.parseLong(infoRequestMsg.getCliente().getNumeroIdentificacion()));
            data.setValTipoIdentificacion(Short.parseShort(String.valueOf(infoRequestMsg.getCliente().getTipoIdentificacion())));
            this.request.setDataHeader(header);
            this.request.setData(data);
            
            valTerminalAsig = header.getTotal();
        } catch (NumberFormatException ex) {
            this.logger.error(ex.getMessage(), ex);
            throw new ErrorExternServiceException("45", "Error al convertir una cadena a Numerico.", ex);
        }
    }

    public Object invocar() throws ErrorExternServiceException {
        this.logger.info("inicio invocar clienteSOAPProductos con terminal = " + valTerminalAsig);
        ConsultasProductosPortType proxy = ((ConsultasProductosHTTPService) this.service).getConsultasProductosSOAPHTTPPort();

        BindingProvider mBinding = (BindingProvider) proxy;
        this.logger.debug("BindingProviderProperties.REQUEST_TIMEOUT = " + this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("javax.xml.ws.service.endpoint.address", this.paramSoapService.getEndpoint());
        mBinding.getRequestContext().put("com.sun.xml.ws.request.timeout", Integer.valueOf(this.paramSoapService.getTimeOut()));
        mBinding.getRequestContext().put("com.sun.xml.ws.connect.timeout", Integer.valueOf(this.paramSoapService.getTimeOut()));
        HandlerGeneracionReportes handlerGeneracionReportes = new HandlerGeneracionReportes(this.logger, "UTF-8");

        List<Handler> handlerChain = mBinding.getBinding().getHandlerChain();
        handlerChain.add(handlerGeneracionReportes);
        mBinding.getBinding().setHandlerChain(handlerChain);

        ResponseType response = null;
        long ini = 0L, fin = 0L;
        String errorMsj = null;
        try {
            this.logger.debug("Se consumirservicio al endpoint: " + this.paramSoapService.getEndpoint());
            ini = System.currentTimeMillis();
            response = proxy.consultasProductos(getRequest());
            if (response != null) {
                if (response.getDataHeader() != null) {
                    if (response.getDataHeader().getCaracterAceptacion().equalsIgnoreCase("B")) {
                        if (response.getData() != null) {
                            errorMsj = "OK";
                        } else {
                            errorMsj = "clienteSOAPProductos: Data de consulta de ahorros es null";
                        }
                    } else {
                        errorMsj = "clienteSOAPProductos: " + response.getDataHeader().getMsgRespuesta();
                    }
                } else {
                    errorMsj = "clienteSOAPProductos: Dataheader de consulta de ahorros es null";
                }
            } else {
                errorMsj = "clienteSOAPProductos: Error al consumir el servicio del BUS";
            }

        } catch (Exception ex) {
            fin = System.currentTimeMillis();
            response = new ResponseType();
            this.logger.error(ex.getMessage(), ex);
            String mensaje = "Error al consumir el servicio clienteSOAPProductos " + ex.getMessage();

            throw new ErrorExternServiceException("42", mensaje, ex);
        } finally {

            long total = fin - ini;
            this.logger.debug("Tiempo de consumo de servicio clienteSOAPProductos : " + total + " MS");
        }

        this.logger.debug("fin invocar clienteSOAPProductos");
        if (errorMsj.equals("OK")) {
            return response;
        }
        return errorMsj;
    }

    public RequestType getRequest() {
        return this.request;
    }

    public void setRequest(RequestType request) {
        this.request = request;
    }
}
