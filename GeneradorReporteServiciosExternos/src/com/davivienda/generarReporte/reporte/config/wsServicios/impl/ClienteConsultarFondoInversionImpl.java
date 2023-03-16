package com.davivienda.generarReporte.reporte.config.wsServicios.impl;

import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.reporte.config.wsServicios.DataHeaderComunESB;
import com.davivienda.generarReporte.reporte.config.wsServicios.HandlerGeneracionReportes;
import com.davivienda.generarReporte.reporte.config.wsServicios.IClienteServicios;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.servicios.fondosInversion.DataConsultaFondosDeInversion;
import com.davivienda.generarReporte.servicios.fondosInversion.DataHeaderType;
import com.davivienda.generarReporte.servicios.fondosInversion.RequestConsultaFondosDeInversion;
import com.davivienda.generarReporte.servicios.fondosInversion.ResponseConsultaFondosDeInversion;
import com.davivienda.generarReporte.servicios.fondosInversion.SAFConsultaFondosDeInversionHTTPService;
import com.davivienda.generarReporte.servicios.fondosInversion.SAFMsgSetPortType;
import com.ibm.cache.bo.particular.ParametrosSoapServicio;
import com.ibm.comunes.log.Logger;
import java.math.BigDecimal;
import java.util.List;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

public class ClienteConsultarFondoInversionImpl extends ClienteServiciosAbstract implements IClienteServicios<ResponseConsultaFondosDeInversion> {

    private final DataHeaderComunESB headerComunESB = this.obtenerHeaderDelServicio("clienteSOAPFondoInvers");
    private final ParametrosSoapServicio paramSoapService = this.obtenerServicioDelConfig("clienteSOAPFondoInvers");
    private RequestConsultaFondosDeInversion request;
    private final String nombre;
    private static final String CARACTER_ACEPTACION_OK = "B";
    private int  valTerminalAsig = 0;
    public ClienteConsultarFondoInversionImpl(Logger logger, String nom) throws ErrorExternServiceException {
        super(logger);
        this.nombre = nom;
    }

    public String getNombre() throws ErrorExternServiceException {
        return this.nombre;
    }

    public void nuevo(short idCanal) throws ErrorExternServiceException {
        this.setRequest((RequestConsultaFondosDeInversion) null);
        this.verificarCanal(this.paramSoapService, idCanal);
        if (this.service == null) {
            this.service = new SAFConsultaFondosDeInversionHTTPService();
        }

    }

    public void asignarInformacion(MsjSolOpGeneracionReporte infoRequestMsg, BigDecimal valor) throws ErrorExternServiceException {
        DataConsultaFondosDeInversion data = new DataConsultaFondosDeInversion();
        DataHeaderType header = new DataHeaderType();

        try {
            header.setCanal(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
            header.setJornada(Short.valueOf(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getValJornada()));
            header.setModoDeOperacion(this.headerComunESB.getModoDeOperacion());
            header.setNombreOperacion(this.headerComunESB.getNombreOperacion());
            header.setPerfil(Short.valueOf(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getValPerfil()));
            header.setTotal(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getIdTerminal());
            header.setUsuario(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getCodUsuario());
            header.setVersionServicio(this.headerComunESB.getVersionServicio());
            data.setNumeroProducto(Long.parseLong(infoRequestMsg.getProducto().getNumeroProducto()));
            valTerminalAsig = header.getTotal();
        } catch (NumberFormatException var6) {
            this.logger.error("Error al convertir una cadena a Numerico.", var6);
            throw new ErrorExternServiceException("45", "Error al convertir una cadena a Numerico.", var6);
        }

        this.request = new RequestConsultaFondosDeInversion();
        this.request.setData(data);
        this.request.setDataHeader(header);
    }

    public Object invocar() throws ErrorExternServiceException {
        this.logger.info("inicio invocar ConsultaFondosDeInversion con terminal = " + valTerminalAsig);
        SAFMsgSetPortType proxy = ((SAFConsultaFondosDeInversionHTTPService) this.service).getSAFConsultaFondosDeInversionHTTPPort();
        BindingProvider mBinding = (BindingProvider) proxy;
        this.logger.debug("BindingProviderProperties.REQUEST_TIMEOUT = " + this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("javax.xml.ws.service.endpoint.address", this.paramSoapService.getEndpoint());
        mBinding.getRequestContext().put("com.sun.xml.ws.request.timeout", this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("com.sun.xml.ws.connect.timeout", this.paramSoapService.getTimeOut());
        Handler handler = new HandlerGeneracionReportes(this.logger, "UTF-8");
        List<Handler> handlerChain = mBinding.getBinding().getHandlerChain();
        handlerChain.add(handler);
        mBinding.getBinding().setHandlerChain(handlerChain);
        this.logger.debug("Se consumirá servicio al endpoint: " + this.paramSoapService.getEndpoint());
        ResponseConsultaFondosDeInversion response = null;
        long ini = 0L;
        long fin = 0L;
        String errorMsj = null;
        boolean var18 = false;

        try {
            var18 = true;
            ini = System.currentTimeMillis();
            response = proxy.consultaFondosDeInversion(this.getRequest());
            if (response != null) {
                if (response.getDataHeader() != null) {
                    if (response.getDataHeader().getCaracterAceptacion().equalsIgnoreCase("B")) {
                        if (response.getData() != null) {
                            errorMsj = "OK";
                        } else {
                            errorMsj = "ConsultaFondosDeInversion: Data de consulta de fondos de inversion es null";
                        }
                    } else {
                        errorMsj = "ConsultaFondosDeInversion: " + response.getDataHeader().getMsgRespuesta();
                    }
                } else {
                    errorMsj = "ConsultaFondosDeInversion: Dataheader de consulta de fondos de inversion es null";
                }
            } else {
                errorMsj = "ConsultaFondosDeInversion: Error al consumir el servicio del BUS";
            }

            fin = System.currentTimeMillis();
            var18 = false;
        } catch (Exception var19) {
            fin = System.currentTimeMillis();
            this.logger.error(var19.getMessage(), var19);
            String mensaje = "Error al consumir el servicio ConsultaFondosDeInversion";
            if (var19.getMessage() != null) {
                mensaje = mensaje + ", Mensaje: " + var19.getMessage();
            }

            if (var19.getCause() != null) {
                mensaje = mensaje + ", Causa: " + var19.getCause().toString();
            }

            throw new ErrorExternServiceException("42", mensaje, var19);
        } finally {
            if (var18) {
                long total = fin - ini;
                this.logger.debug("Tiempo de consumo de servicio ConsultaFondosDeInversion : " + total + " MS");
            }
        }

        long total = fin - ini;
        this.logger.debug("Tiempo de consumo de servicio ConsultaFondosDeInversion : " + total + " MS");
        this.logger.debug("fin invocar ConsultaFondosDeInversion");
        return errorMsj.equals("OK") ? response : errorMsj;
    }

    public RequestConsultaFondosDeInversion getRequest() {
        return this.request;
    }

    public void setRequest(RequestConsultaFondosDeInversion request) {
        this.request = request;
    }
}
