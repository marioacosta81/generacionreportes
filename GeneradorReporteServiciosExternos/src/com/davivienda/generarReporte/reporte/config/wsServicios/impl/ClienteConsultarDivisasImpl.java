package com.davivienda.generarReporte.reporte.config.wsServicios.impl;

import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.reporte.config.wsServicios.DataHeaderComunESB;
import com.davivienda.generarReporte.reporte.config.wsServicios.HandlerGeneracionReportes;
import com.davivienda.generarReporte.reporte.config.wsServicios.IClienteServicios;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.servicios.consultaDivisas.ConsultaDeDivisasDataHeaderType;
import com.davivienda.generarReporte.servicios.consultaDivisas.ConsultaDeDivisasDataType;
import com.davivienda.generarReporte.servicios.consultaDivisas.ConsultaDeDivisasHTTPService;
import com.davivienda.generarReporte.servicios.consultaDivisas.ConsultaDeDivisasPortType;
import com.davivienda.generarReporte.servicios.consultaDivisas.RequestConsultaDeDivisas;
import com.davivienda.generarReporte.servicios.consultaDivisas.ResponseType;
import com.ibm.cache.bo.particular.ParametrosSoapServicio;
import com.ibm.comunes.log.Logger;
import java.math.BigDecimal;
import java.util.List;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;

public class ClienteConsultarDivisasImpl
        extends ClienteServiciosAbstract
        implements IClienteServicios<ResponseType> {

    private static final String PARAM_WS_COD_DOLLARES = "PARAM_WS_COD_DOLLARES";
    private DataHeaderComunESB headerComunESB;
    private final ParametrosSoapServicio paramSoapService;
    private RequestConsultaDeDivisas request;
    private final String nombre;
    private int  valTerminalAsig = 0;
    public ClienteConsultarDivisasImpl(Logger logger, String nom) throws ErrorExternServiceException {
        super(logger);
        this.headerComunESB = obtenerHeaderDelServicio("clienteSOAPDivisas");
        this.paramSoapService = obtenerServicioDelConfig("clienteSOAPDivisas");
        this.nombre = nom;
    }

    public String getNombre() throws ErrorExternServiceException {
        return this.nombre;
    }

    public void nuevo(short idCanal) throws ErrorExternServiceException {
        setRequest(null);
        verificarCanal(this.paramSoapService, idCanal);
        if (this.service == null) {
            this.service = (Service) new ConsultaDeDivisasHTTPService();
        }
    }

    public void asignarInformacion(MsjSolOpGeneracionReporte infoRequestMsg, BigDecimal valor) throws ErrorExternServiceException {
        ConsultaDeDivisasDataType data = new ConsultaDeDivisasDataType();
        ConsultaDeDivisasDataHeaderType header = new ConsultaDeDivisasDataHeaderType();

        try {
            header.setCanal(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
            header.setJornada(Short.valueOf(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getValJornada()).shortValue());
            header.setModoDeOperacion(this.headerComunESB.getModoDeOperacion());
            header.setNombreOperacion(this.headerComunESB.getNombreOperacion());
            header.setPerfil(Short.valueOf(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getValPerfil()).shortValue());
            header.setTotal(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getIdTerminal());
            header.setUsuario(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getCodUsuario());
            header.setVersionServicio(this.headerComunESB.getVersionServicio());

            data.setIndicadorDeMoneda(Short.valueOf(obtenerParametroConfig("PARAM_WS_COD_DOLLARES")).shortValue());
            data.setValor(valor);
            
            valTerminalAsig = header.getTotal();
            
        } catch (NumberFormatException ex) {
            throw new ErrorExternServiceException("45", "Error al convertir una cadena a Numerico.", ex);
        }

        this.request = new RequestConsultaDeDivisas();
        this.request.setData(data);
        this.request.setDataHeader(header);
    }

    public ResponseType invocar() throws ErrorExternServiceException {
        this.logger.info("inicio invocar ConsultaDeDivisas con terminal = " + valTerminalAsig);
        ConsultaDeDivisasPortType proxy = ((ConsultaDeDivisasHTTPService) this.service).getConsultaDeDivisasHTTPPort();

        BindingProvider mBinding = (BindingProvider) proxy;
        this.logger.debug("BindingProviderProperties.REQUEST_TIMEOUT = " + this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("javax.xml.ws.service.endpoint.address", this.paramSoapService.getEndpoint());
        mBinding.getRequestContext().put("com.sun.xml.ws.request.timeout", Integer.valueOf(this.paramSoapService.getTimeOut()));
        mBinding.getRequestContext().put("com.sun.xml.ws.connect.timeout", Integer.valueOf(this.paramSoapService.getTimeOut()));
        HandlerGeneracionReportes handlerGeneracionReportes = new HandlerGeneracionReportes(this.logger, "UTF-8");

        List<Handler> handlerChain = mBinding.getBinding().getHandlerChain();
        handlerChain.add(handlerGeneracionReportes);
        mBinding.getBinding().setHandlerChain(handlerChain);
        this.logger.debug("Se consumirservicio al endpoint: " + this.paramSoapService.getEndpoint());
        ResponseType response = null;
        long ini = 0L, fin = 0L;
        try {
            ini = System.currentTimeMillis();
            response = proxy.consultaDeDivisas(getRequest());
            fin = System.currentTimeMillis();
        } catch (Exception ex) {
            fin = System.currentTimeMillis();
            this.logger.error(ex.getMessage(), ex);
            String mensaje = "Error al consumir el servicio ConsultaDeDivisas";
            if (ex.getMessage() != null) {
                mensaje = mensaje + ", Mensaje: " + ex.getMessage();
            }
            if (ex.getCause() != null) {
                mensaje = mensaje + ", Causa: " + ex.getCause().toString();
            }

            throw new ErrorExternServiceException("42", mensaje, ex);
        } finally {
            long total = fin - ini;
            this.logger.debug("Tiempo de consumo de servicio ConsultaDeDivisas : " + total + " MS");
        }
        this.logger.debug("fin invocar ConsultaDeDivisas");
        return response;
    }

    public RequestConsultaDeDivisas getRequest() {
        return this.request;
    }

    public void setRequest(RequestConsultaDeDivisas request) {
        this.request = request;
    }
}
