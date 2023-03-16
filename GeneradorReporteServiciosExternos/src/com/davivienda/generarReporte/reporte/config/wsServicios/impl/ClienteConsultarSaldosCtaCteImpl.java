package com.davivienda.generarReporte.reporte.config.wsServicios.impl;

import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.reporte.config.wsServicios.DataHeaderComunESB;
import com.davivienda.generarReporte.reporte.config.wsServicios.HandlerGeneracionReportes;
import com.davivienda.generarReporte.reporte.config.wsServicios.IClienteServicios;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.servicios.saldosCtaCte.ConsultaSaldoCuentaCorrienteIIDto;
import com.davivienda.generarReporte.servicios.saldosCtaCte.ConsultarSaldoCuentaCorrienteII;
import com.davivienda.generarReporte.servicios.saldosCtaCte.ConsultarSaldoCuentaCorrienteIIService;
import com.davivienda.generarReporte.servicios.saldosCtaCte.RespuestaConsultaSaldoCuentaCorrienteIIDto;
import com.ibm.cache.bo.particular.ParametrosSoapServicio;
import com.ibm.comunes.log.Logger;
import java.math.BigDecimal;
import java.util.List;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

public class ClienteConsultarSaldosCtaCteImpl extends ClienteServiciosAbstract implements IClienteServicios<RespuestaConsultaSaldoCuentaCorrienteIIDto> {

    private final DataHeaderComunESB headerComunESB = this.obtenerHeaderDelServicio("clienteSOAPSaldosCtaCte");
    private final ParametrosSoapServicio paramSoapService = this.obtenerServicioDelConfig("clienteSOAPSaldosCtaCte");
    private ConsultaSaldoCuentaCorrienteIIDto request;
    private final String nombre;
    private static final String CARACTER_ACEPTACION_OK = "B";
    private int  valTerminalAsig = 0;
    public ClienteConsultarSaldosCtaCteImpl(Logger logger, String nom) throws ErrorExternServiceException {
        super(logger);
        this.nombre = nom;
    }

    public String getNombre() throws ErrorExternServiceException {
        return this.nombre;
    }

    public void nuevo(short idCanal) throws ErrorExternServiceException {
        this.setRequest((ConsultaSaldoCuentaCorrienteIIDto) null);
        this.verificarCanal(this.paramSoapService, idCanal);
        if (this.service == null) {
            this.service = new ConsultarSaldoCuentaCorrienteIIService();
        }

    }

    public void asignarInformacion(MsjSolOpGeneracionReporte infoRequestMsg, BigDecimal valor) throws ErrorExternServiceException {
        this.request = new ConsultaSaldoCuentaCorrienteIIDto();

        try {
            this.request.setCanal(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());

            try {
                this.request.setHost(Integer.valueOf(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdHost()));
            } catch (Exception var4) {
                this.logger.error("Error seteando host a integer: " + infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdHost(), var4);
                this.request.setHost(0);
            }

            this.request.setIdTarea(this.obtenerParametroConfig("idTarea_CtaCte"));
            this.request.setIdentificadorOperacion(this.headerComunESB.getNombreOperacion());
            this.request.setIdentificadorSesion(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getIdSesion());
            this.request.setJornada(Short.valueOf(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getValJornada()));
            this.request.setModoDeOperacion(this.headerComunESB.getModoDeOperacion());
            this.request.setOrigenLog(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getValOrigenPeticion());
            this.request.setPerfil(Short.valueOf(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getValPerfil()));
            this.request.setTotal(this.headerComunESB.getTotal());
            this.request.setUsuario(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getCodUsuario());
            this.request.setNumeroCuenta(infoRequestMsg.getProducto().getNumeroProducto());
            valTerminalAsig = this.request.getTotal();
        } catch (Exception var5) {
            this.logger.error("Error al convertir una cadena a Numerico.", var5);
            throw new ErrorExternServiceException("45", "Error al convertir una cadena a Numerico.", var5);
        }
    }

    public Object invocar() throws ErrorExternServiceException {
        this.logger.info("inicio invocar: ConsultarSaldoCuentaCorrienteII con terminal = " + valTerminalAsig);
        ConsultarSaldoCuentaCorrienteII proxy = ((ConsultarSaldoCuentaCorrienteIIService) this.service).getConsultarSaldoCuentaCorrienteIIPort();
        BindingProvider mBinding = (BindingProvider) proxy;
        this.logger.debug("BindingProviderProperties.REQUEST_TIMEOUT = " + this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("javax.xml.ws.service.endpoint.address", this.paramSoapService.getEndpoint());
        mBinding.getRequestContext().put("com.sun.xml.ws.request.timeout", this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("com.sun.xml.ws.connect.timeout", this.paramSoapService.getTimeOut());
        Handler handler = new HandlerGeneracionReportes(this.logger, "UTF-8");
        List<Handler> handlerChain = mBinding.getBinding().getHandlerChain();
        handlerChain.add(handler);
        mBinding.getBinding().setHandlerChain(handlerChain);
        RespuestaConsultaSaldoCuentaCorrienteIIDto response = null;
        long ini = 0L;
        long fin = 0L;
        String errorMsj = null;
        boolean var18 = false;

        try {
            var18 = true;
            this.logger.debug("Se consumirá servicio al endpoint: " + this.paramSoapService.getEndpoint());
            ini = System.currentTimeMillis();
            response = proxy.consultaSaldoCuentaCorriente(this.request);
            if (response != null) {
                if (response.getCaracterAcepta().equalsIgnoreCase("B")) {
                    errorMsj = "OK";
                } else {
                    errorMsj = "ConsultarSaldoCuentaCorrienteII: " + response.getMRespuesta();
                }
            } else {
                errorMsj = "ConsultarSaldoCuentaCorrienteII: Response es null";
            }

            fin = System.currentTimeMillis();
            var18 = false;
        } catch (Exception var19) {
            fin = System.currentTimeMillis();
            this.logger.error(var19.getMessage(), var19);
            String mensaje = "Error al consumir el servicio ConsultarSaldoCuentaCorrienteII";
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
                this.logger.debug("Tiempo de consumo de servicio ConsultarSaldoCuentaCorrienteII : " + total + " MS");
            }
        }

        long total = fin - ini;
        this.logger.debug("Tiempo de consumo de servicio ConsultarSaldoCuentaCorrienteII : " + total + " MS");
        this.logger.info("fin invocar: ConsultarSaldoCuentaCorrienteII");
        return errorMsj.equals("OK") ? response : errorMsj;
    }

    public ConsultaSaldoCuentaCorrienteIIDto getRequest() {
        return this.request;
    }

    public void setRequest(ConsultaSaldoCuentaCorrienteIIDto request) {
        this.request = request;
    }
}
