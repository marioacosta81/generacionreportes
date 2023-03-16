package com.davivienda.generarReporte.reporte.config.wsServicios.impl;

import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.reporte.config.wsServicios.DataHeaderComunESB;
import com.davivienda.generarReporte.reporte.config.wsServicios.HandlerGeneracionReportes;
import com.davivienda.generarReporte.reporte.config.wsServicios.IClienteServicios;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.servicios.cafeteraAgropecuaria.ConsTotTCCafAgrRequestType;
import com.davivienda.generarReporte.servicios.cafeteraAgropecuaria.ConsTotTCCafAgrResponseType;
import com.davivienda.generarReporte.servicios.cafeteraAgropecuaria.ConsultaMaestraFijaPortType;
import com.davivienda.generarReporte.servicios.cafeteraAgropecuaria.ConsultaMaestraFijaSOAPHTTPService;
import com.davivienda.generarReporte.servicios.cafeteraAgropecuaria.DataHeaderType;
import com.davivienda.generarReporte.servicios.cafeteraAgropecuaria.DataType;
import com.davivienda.generarReporte.servicios.cafeteraAgropecuaria.RequestType;
import com.ibm.cache.bo.particular.ParametrosSoapServicio;
import com.ibm.comunes.log.Logger;
import java.math.BigDecimal;
import java.util.List;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

public class ClienteConsultarCafeteraAgropecuariaImpl extends ClienteServiciosAbstract implements IClienteServicios<ConsTotTCCafAgrResponseType> {

    private final DataHeaderComunESB headerComunESB = this.obtenerHeaderDelServicio("clienteSOAPAgropecuaria");
    private final ParametrosSoapServicio paramSoapService = this.obtenerServicioDelConfig("clienteSOAPAgropecuaria");
    private ConsTotTCCafAgrRequestType request;
    private final String nombre;
    private static final String CARACTER_ACEPTACION_OK = "B";
    private int  valTerminalAsig = 0;
    public ClienteConsultarCafeteraAgropecuariaImpl(Logger logger, String nom) throws ErrorExternServiceException {
        super(logger);
        this.nombre = nom;
    }

    public String getNombre() throws ErrorExternServiceException {
        return this.nombre;
    }

    public void nuevo(short idCanal) throws ErrorExternServiceException {
        this.setRequest((ConsTotTCCafAgrRequestType) null);
        this.verificarCanal(this.paramSoapService, idCanal);
        if (this.service == null) {
            this.service = new ConsultaMaestraFijaSOAPHTTPService();
        }

    }

    public void asignarInformacion(MsjSolOpGeneracionReporte infoRequestMsg, BigDecimal valor) throws ErrorExternServiceException {
        DataType data = new DataType();
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
            data.setNroTarjeta(infoRequestMsg.getProducto().getNumeroProducto());
            
            valTerminalAsig = header.getTotal();
        } catch (NumberFormatException var6) {
            this.logger.error("Error conversion de numeros", var6);
            throw new ErrorExternServiceException("45", "Error al convertir una cadena a Numerico.", var6);
        }

        RequestType mReq = new RequestType();
        mReq.setData(data);
        mReq.setDataHeader(header);
        this.request = new ConsTotTCCafAgrRequestType();
        this.request.setRequest(mReq);
    }

    public Object invocar() throws ErrorExternServiceException {
        this.logger.info("inicio invocar: ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria con terminal = " + valTerminalAsig);
        ConsultaMaestraFijaPortType port = ((ConsultaMaestraFijaSOAPHTTPService) this.service).getConsultaMaestraFijaSOAPHTTPPort();
        BindingProvider mBinding = (BindingProvider) port;
        this.logger.debug("BindingProviderProperties.REQUEST_TIMEOUT = " + this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("javax.xml.ws.service.endpoint.address", this.paramSoapService.getEndpoint());
        mBinding.getRequestContext().put("com.sun.xml.ws.request.timeout", this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("com.sun.xml.ws.connect.timeout", this.paramSoapService.getTimeOut());
        Handler handler = new HandlerGeneracionReportes(this.logger, "UTF-8");
        List<Handler> handlerChain = mBinding.getBinding().getHandlerChain();
        handlerChain.add(handler);
        mBinding.getBinding().setHandlerChain(handlerChain);
        this.logger.debug("Se consumirá servicio al endpoint: " + this.paramSoapService.getEndpoint());
        ConsTotTCCafAgrResponseType response = null;
        String errorMsj = null;
        long ini = 0L;
        long fin = 0L;
        boolean var18 = false;

        try {
            var18 = true;
            ini = System.currentTimeMillis();
            response = port.consultaMaestraFija(this.getRequest());
            if (response != null) {
                if (response.getResponse() != null) {
                    if (response.getResponse().getDataHeader() != null) {
                        if (response.getResponse().getDataHeader().getCaracterAceptacion().equalsIgnoreCase("B")) {
                            if (response.getResponse().getData() != null) {
                                errorMsj = "OK";
                            } else {
                                errorMsj = "ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria: Data de consulta cafetera agro es null";
                            }
                        } else {
                            errorMsj = "ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria: " + response.getResponse().getDataHeader().getMsgRespuesta();
                        }
                    } else {
                        errorMsj = "ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria: Dataheader de consulta cafetera agro es null";
                    }
                } else {
                    errorMsj = "ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria: Response de consulta cafetera agro es null";
                }
            } else {
                errorMsj = "ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria: Error al consumir el servicio del BUS";
            }

            fin = System.currentTimeMillis();
            var18 = false;
        } catch (Exception var19) {
            fin = System.currentTimeMillis();
            this.logger.error(var19.getMessage(), var19);
            String mensaje = "Error al consumir el servicio ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria";
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
                this.logger.debug("Tiempo de consumo de servicio ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria : " + total + " MS");
            }
        }

        long total = fin - ini;
        this.logger.debug("Tiempo de consumo de servicio ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria : " + total + " MS");
        this.logger.info("fin invocar: ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria");
        return errorMsj.equals("OK") ? response.getResponse() : errorMsj;
    }

    public ConsTotTCCafAgrRequestType getRequest() {
        return this.request;
    }

    public void setRequest(ConsTotTCCafAgrRequestType request) {
        this.request = request;
    }
}
