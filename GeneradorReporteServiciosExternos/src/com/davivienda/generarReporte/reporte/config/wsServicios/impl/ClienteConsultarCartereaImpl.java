package com.davivienda.generarReporte.reporte.config.wsServicios.impl;

import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.reporte.config.wsServicios.DataHeaderComunESB;
import com.davivienda.generarReporte.reporte.config.wsServicios.HandlerGeneracionReportes;
import com.davivienda.generarReporte.reporte.config.wsServicios.IClienteServicios;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.servicios.consultaCartera.ConsultaCarteraDto;
import com.davivienda.generarReporte.servicios.consultaCartera.ConsultaCarteraService;
import com.davivienda.generarReporte.servicios.consultaCartera.ConsultaCarteraServiceInterface;
import com.davivienda.generarReporte.servicios.consultaCartera.ParametrosSeguridadDTO;
import com.davivienda.generarReporte.servicios.consultaCartera.RespConsultaCarteraRepDto;
import com.davivienda.generarReporte.servicios.consultaCartera.RespuestaConsultaCarteraDto;
import com.davivienda.generarReporte.servicios.consultaCartera.ServicioException_Exception;
import com.ibm.cache.bo.particular.ParametrosSoapServicio;
import com.ibm.comunes.log.Logger;
import java.math.BigDecimal;
import java.util.List;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

public class ClienteConsultarCartereaImpl extends ClienteServiciosAbstract implements IClienteServicios<RespuestaConsultaCarteraDto> {

    private static final String PARAM_WS_IDOPERADOR = "identificadorOperacion";
    private static final String PARAM_WS_IDTAREA = "idTarea";
    private static final String PARAM_WS_IDSESION = "identificadorSesion";
    private static final String PARAM_WS_ORIGENLOG = "origenLog";
    private static final String PARAM_WS_MODOOPERACION = "modoDeOperacion";
    private static final String PARAM_WS_SEGUNDACLAVE = "segundaClave";
    private static final String PARAM_WS_VALIDARTOKEN = "debeRevalidarToken";
    private static final String PARAM_WS_VALIDAR2CLAVE = "debeValidarSegundaClave";
    private static final String PARAM_WS_IDSESIONTOKEN = "idSesionToken";
    private static final String PARAM_WS_USATOKEN = "usaToken";
    private final DataHeaderComunESB headerComunESB = this.obtenerHeaderDelServicio("clienteSOAPCartera");
    private final ParametrosSoapServicio paramSoapService = this.obtenerServicioDelConfig("clienteSOAPCartera");
    private ConsultaCarteraDto request;
    private final String nombre;
    private static final String CODIGO_STATUS_OK = "0000";
    private int  valTerminalAsig = 0;
    public ClienteConsultarCartereaImpl(Logger logger, String nom) throws ErrorExternServiceException {
        super(logger);
        this.nombre = nom;
    }

    public String getNombre() throws ErrorExternServiceException {
        return this.nombre;
    }

    public void nuevo(short idCanal) throws ErrorExternServiceException {
        this.setRequest((ConsultaCarteraDto) null);
        this.verificarCanal(this.paramSoapService, idCanal);
        if (this.service == null) {
            this.service = new ConsultaCarteraService();
        }

    }

    public void asignarInformacion(MsjSolOpGeneracionReporte infoRequestMsg, BigDecimal valor) throws ErrorExternServiceException {
        try {
            this.request = new ConsultaCarteraDto();
            this.request.setCanal(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
            this.request.setHost(Integer.parseInt(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdHost()));
            this.request.setIdTarea(this.obtenerParametroConfig("idTarea"));
            this.request.setModoDeOperacion(Short.valueOf(this.obtenerParametroConfig("modoDeOperacion")));
            this.request.setIdentificadorOperacion("identificadorOperacion");
            this.request.setIdentificadorSesion(this.obtenerParametroConfig("identificadorSesion"));
            this.request.setIndicador(Short.valueOf((short) 1));
            this.request.setJornada(Short.valueOf(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getValJornada()));
            String numeroId = infoRequestMsg.getCliente().getNumeroIdentificacion();
            String temp = null;
            long numeroIdLong = 0L;
            temp = numeroId.replaceAll("\\.", "");
            temp = temp.replaceAll("-", "");
            numeroIdLong = Long.valueOf(temp);
            this.request.setNumeroId(numeroIdLong);
            this.request.setOrigenLog(this.obtenerParametroConfig("origenLog"));
            this.request.setPerfil(Short.valueOf(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getValPerfil()));
            this.request.setSegundaClave(this.obtenerParametroConfig("segundaClave"));
            this.request.setTipoId(Short.valueOf(String.valueOf(infoRequestMsg.getCliente().getTipoIdentificacion())));
            this.request.setTotal(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getIdTerminal());
            this.request.setUsuario(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getCodUsuario());
            ParametrosSeguridadDTO paramSegDto = new ParametrosSeguridadDTO();
            paramSegDto.setDebeRevalidarToken(Boolean.valueOf(this.obtenerParametroConfig("debeRevalidarToken")));
            paramSegDto.setDebeValidarSegundaClave(Boolean.valueOf(this.obtenerParametroConfig("debeValidarSegundaClave")));
            paramSegDto.setIdSesionToken(this.obtenerParametroConfig("idSesionToken"));
            paramSegDto.setUsaToken(Boolean.valueOf("usaToken"));
            this.request.setParametrosSeguridad(paramSegDto);
            
            valTerminalAsig = this.request.getTotal();
        } catch (NumberFormatException var8) {
            this.logger.error(var8.getMessage(), var8);
            throw new ErrorExternServiceException("45", "Error al convertir una cadena a Numerico.", var8);
        } catch (ErrorExternServiceException var9) {
            this.logger.error(var9.getMessage(), var9);
            throw new ErrorExternServiceException(var9.getCodError(), var9.getMessage(), var9);
        }
    }

    public Object invocar() throws ErrorExternServiceException {
        this.logger.info("inicio invocar ConsultaCarteraService con terminal = " + valTerminalAsig);
        ConsultaCarteraServiceInterface proxy = ((ConsultaCarteraService) this.service).getConsultaCarteraServiceInterfacePort();
        BindingProvider mBinding = (BindingProvider) proxy;
        this.logger.debug("BindingProviderProperties.REQUEST_TIMEOUT = " + this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("javax.xml.ws.service.endpoint.address", this.paramSoapService.getEndpoint());
        mBinding.getRequestContext().put("com.sun.xml.ws.request.timeout", this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("com.sun.xml.ws.connect.timeout", this.paramSoapService.getTimeOut());
        Handler handler = new HandlerGeneracionReportes(this.logger, "UTF-8");
        List<Handler> handlerChain = mBinding.getBinding().getHandlerChain();
        handlerChain.add(handler);
        mBinding.getBinding().setHandlerChain(handlerChain);
        RespuestaConsultaCarteraDto response = null;
        long ini = 0L;
        long fin = 0L;
        String errorMsj = null;
        boolean var19 = false;

        try {
            String mensaje;
            try {
                var19 = true;
                this.logger.debug("Se consumirá servicio al endpoint: " + this.paramSoapService.getEndpoint());
                ini = System.currentTimeMillis();
                response = proxy.consultaCartera(this.getRequest());
                if (response != null) {
                    if (response.getCodigoStatus().equalsIgnoreCase("0000")) {
                        List<RespConsultaCarteraRepDto> listProdsCarteraESB = response.getRegistrosRepetitivos();
                        if (listProdsCarteraESB != null) {
                            if (!listProdsCarteraESB.isEmpty()) {
                                errorMsj = "OK";
                                var19 = false;
                            } else {
                                errorMsj = "ConsultaCarteraService: Lista de productos de cartera está vacía";
                                var19 = false;
                            }
                        } else {
                            errorMsj = "ConsultaCarteraService: Lista de productos de cartera es null";
                            var19 = false;
                        }
                    } else {
                        errorMsj = "ConsultaCarteraService: " + response.getDescripcionStatus();
                        var19 = false;
                    }
                } else {
                    errorMsj = "ConsultaCarteraService: Response es null";
                    var19 = false;
                }
            } catch (ServicioException_Exception var20) {
                fin = System.currentTimeMillis();
                new RespuestaConsultaCarteraDto();
                this.logger.error(var20.getMessage(), var20);
                mensaje = "Error al consumir el servicio ConsultaCarteraService";
                if (var20.getFaultInfo() != null) {
                    if (var20.getFaultInfo().getMensaje() != null) {
                        mensaje = mensaje + ", Mensaje: " + var20.getFaultInfo().getMensaje();
                    } else {
                        if (var20.getMessage() != null) {
                            mensaje = mensaje + ", Mensaje: " + var20.getMessage();
                        }

                        if (var20.getCause() != null) {
                            mensaje = mensaje + ", Causa: " + var20.getCause().toString();
                        }
                    }
                } else {
                    if (var20.getMessage() != null) {
                        mensaje = mensaje + ", Mensaje: " + var20.getMessage();
                    }

                    if (var20.getCause() != null) {
                        mensaje = mensaje + ", Causa: " + var20.getCause().toString();
                    }
                }

                throw new ErrorExternServiceException("42", mensaje, var20);
            } catch (Exception var21) {
                fin = System.currentTimeMillis();
                new RespuestaConsultaCarteraDto();
                this.logger.error(var21.getMessage(), var21);
                mensaje = "Error al consumir el servicio ConsultaCarteraService";
                if (var21.getMessage() != null) {
                    mensaje = mensaje + ", Mensaje: " + var21.getMessage();
                }

                if (var21.getCause() != null) {
                    mensaje = mensaje + ", Causa: " + var21.getCause().toString();
                }

                throw new ErrorExternServiceException("42", mensaje, var21);
            }
        } finally {
            if (var19) {
                long total = fin - ini;
                this.logger.debug("Tiempo de consumo de servicio ConsultaCarteraService : " + total + " MS");
            }
        }

        long total = fin - ini;
        this.logger.debug("Tiempo de consumo de servicio ConsultaCarteraService : " + total + " MS");
        this.logger.debug("fin invocar ConsultaCarteraService");
        return errorMsj.equals("OK") ? response : errorMsj;
    }

    public ConsultaCarteraDto getRequest() {
        return this.request;
    }

    public void setRequest(ConsultaCarteraDto request) {
        this.request = request;
    }
}
