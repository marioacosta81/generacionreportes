package com.davivienda.generarReporte.servicios;

import com.davivienda.esquemas.filenet.documentotipo.v1.DocumentoTipo;
import com.davivienda.esquemas.filenet.otraspropiedadtipo.v1.OtrasPropiedadTipo;
import com.davivienda.esquemas.filenet.propiedadtipo.v1.PropiedadTipo;
import com.davivienda.esquemas.framework.aplicaciontipo.v1.AplicacionTipo;
import com.davivienda.esquemas.framework.canaltipo.v1.CanalTipo;
import com.davivienda.esquemas.framework.consumidortipo.v1.ConsumidorTipo;
import com.davivienda.esquemas.framework.contextorespuestatipo.v1.ContextoRespuestaTipo;
import com.davivienda.esquemas.framework.contextosolicitudtipo.v1.ContextoSolicitudTipo;
import com.davivienda.esquemas.framework.operacioncanaltipo.v1.OperacionCanalTipo;
import com.davivienda.esquemas.framework.resultadotransacciontipo.v1.ResultadoTransaccionTipo;
import com.davivienda.esquemas.framework.serviciotipo.v1.ServicioTipo;
import com.davivienda.esquemas.framework.terminaltipo.v1.TerminalTipo;
import com.davivienda.filenet.srvscngestorfilenet.v1.MsjRespOpCargarDocumento;
import com.davivienda.filenet.srvscngestorfilenet.v1.MsjSolOpCargarDocumento;
import com.davivienda.filenet.srvscngestorfilenet.v1.PortSrvScnGestorFileNetSOAP;
import com.davivienda.generarReporte.config.reporte.Plantilla;
import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.exception.GenerarReporteException;
import com.davivienda.generarReporte.reporte.config.wsServicios.IClienteServicios;
import com.davivienda.generarReporte.reporte.config.wsServicios.impl.FabricaClientesServicio;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Llave;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Valor;
import com.davivienda.generarReporte.servicios.consultaCartera.RespConsultaCarteraRepDto;
import com.davivienda.generarReporte.servicios.consultaCartera.RespuestaConsultaCarteraDto;
import com.davivienda.generarReporte.servicios.consultaDivisas.ResponseType;
import com.davivienda.generarReporte.util.FuncionesTransformacion;
import com.davivienda.generarReporte.util.GenerarReporteComunesUtil;
import com.davivienda.generarReporte.util.MimeTypeConstants;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.AdjuntoTipo;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.DataMail;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.DestinoTipo;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.MensajeTipo;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.MsjRespOpEnviarMail;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.MsjSolOpEnviarMail;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.ParametroPlantillaTipo;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.PlantillaTipo;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.PortSrvScnNotificacionesMailSOAP;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.V1;
import com.ibm.cache.bo.particular.Parametro;
import com.ibm.cache.bo.servicio.ConfiguracionServicio;
import com.ibm.comunes.log.Logger;
import com.sun.xml.ws.util.ByteArrayDataSource;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.xml.ws.BindingProvider;

public class InvocarServicios {

    public static MsjSolOpEnviarMail requestCorreo;
    private static final String CARACTER_ACEPTACION_OK = "B";
    private static final String CODIGO_STATUS_OK = "0000";
    private Logger logger;
    private List<IClienteServicios> listaClientesSrv;
    public static MsjSolOpCargarDocumento requestFileNet;
    

    public InvocarServicios(Logger log, List<String> listaNombresSrv, ConfiguracionServicio cs) throws ErrorExternServiceException {
        this.logger = log;
        this.listaClientesSrv = new ArrayList<IClienteServicios>(0);
        if (listaNombresSrv != null) {
            try {
                for (String servicioList : listaNombresSrv) {
                    IClienteServicios servicio = FabricaClientesServicio.getInstance().getInstanciaServicio(servicioList, cs.getParticular().getValorParametroAdicional(servicioList.concat("_clienteClass")), this.logger);
                    this.listaClientesSrv.add(servicio);
                }
            } catch (ErrorExternServiceException ex) {
                this.logger.error(ex.getCodError(), (Throwable) ex);
                throw new ErrorExternServiceException(ex.getMessage());
            }
        }
    }

    public RespuestaServicios invocarServicios(MsjSolOpGeneracionReporte request, ConfiguracionServicio cs) throws ErrorExternServiceException {
        RespuestaServicios respuestaServicios = new RespuestaServicios();
        Map<String, Object> mapParamRespuestasDinamico = new HashMap<String, Object>();
        respuestaServicios.setMapRespuestaDinamico(mapParamRespuestasDinamico);
        short idCanal = request.getContextoSolicitud().getConsumidor().getCanal().getIdCanal();

        if (this.listaClientesSrv != null) {

            for (IClienteServicios servicio : this.listaClientesSrv) {
                servicio.nuevo(idCanal);
                servicio.asignarInformacion(request, null);

                Object res = servicio.invocar();
                if (res instanceof String) {
                    mapParamRespuestasDinamico.put("Error", res);
                    continue;
                }
                GenerarReporteComunesUtil.responseToMap(res, mapParamRespuestasDinamico, cs.getParticular().getValorParametroAdicional(servicio.getNombre().concat("_mapPrefix")));
                if (servicio instanceof com.davivienda.generarReporte.reporte.config.wsServicios.impl.ClienteConsultarCartereaImpl) {
                    RespuestaConsultaCarteraDto response = (RespuestaConsultaCarteraDto) res;
                    List<RespConsultaCarteraRepDto> listProdsCarteraESB = response.getRegistrosRepetitivos();
                    llenarListaRespuestCartera(respuestaServicios, listProdsCarteraESB);
                }

            }
        } else {

            this.logger.debug("Lista de servicios vacno se consultara ningun servicio en el ESB");
        }
        return respuestaServicios;
    }

    private void llenarListaRespuestCartera(RespuestaServicios respuestaServicios, List<RespConsultaCarteraRepDto> listProdsCarteraESB) {
        List<ProductoCartera> listProdCartResp = new ArrayList<ProductoCartera>();
        respuestaServicios.setListProductosCartera(listProdCartResp);
        for (RespConsultaCarteraRepDto prodCarteraESB : listProdsCarteraESB) {
            ProductoCartera prodCarteraResp = new ProductoCartera();
            prodCarteraResp.setCodSubProducto(prodCarteraESB.getCodSubProducto());
            prodCarteraResp.setCodigoProducto(prodCarteraESB.getCodigoProducto());
            prodCarteraResp.setCupo(Long.valueOf(prodCarteraESB.getCupo().longValue()));
            prodCarteraResp.setEstado(prodCarteraESB.getEstado());
            prodCarteraResp.setFechaCancelacion(prodCarteraESB.getFechaCancelacion());
            prodCarteraResp.setFechaInicial(prodCarteraESB.getFechaInicial());
            prodCarteraResp.setMensaje(prodCarteraESB.getMensaje());
            prodCarteraResp.setNumeroProducto(prodCarteraESB.getNumeroProducto());
            prodCarteraResp.setSaldo(String.valueOf(prodCarteraESB.getSaldo().longValue()));
            prodCarteraResp.setTitularidad(prodCarteraESB.getTitularidad());
            listProdCartResp.add(prodCarteraResp);
        }
    }

    public String[] consumirServicioDivisas(MsjSolOpGeneracionReporte request, Logger logger, String valorMonetario, String valorMap, ConfiguracionServicio cs) throws ErrorExternServiceException {
        String[] strResult = {"", ""};

        IClienteServicios servicio = FabricaClientesServicio.getInstance().getInstanciaServicio("clienteSOAPDivisas", cs
                .getParticular().getValorParametroAdicional("clienteSOAPDivisas".concat("_clienteClass")), logger);

        servicio.nuevo(request.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());

        BigDecimal montoAConvertir = new BigDecimal(valorMonetario.replaceAll(",", ""));

        if (montoAConvertir.compareTo(BigDecimal.ZERO) < 0) {

            String montoPositivo = montoAConvertir.toString();
            montoPositivo = montoPositivo.replace("-", "");
            servicio.asignarInformacion(request, new BigDecimal(montoPositivo));

            ResponseType response = (ResponseType) servicio.invocar();
            if (response != null) {
                if (response.getDataHeader().getCaracterAceptacion().equalsIgnoreCase("B")) {
                    strResult[0] = valorMap + "_{valorDolares}";
                    String monto = response.getData().getValorDolares();
                    monto = monto.replace(" ", "");
                    monto = monto.replace("$", "$ -");
                    strResult[1] = monto;
                } else {
                    strResult[0] = "Error";
                    strResult[1] = "ConsultaDeDivisas: " + response.getDataHeader().getMsgRespuesta();
                }
            } else {
                strResult[0] = "Error";
                strResult[1] = "ConsultaDeDivisas: Error al consumir el servicio del BUS";
            }
        } else if (montoAConvertir.compareTo(BigDecimal.ZERO) > 0) {
            servicio.asignarInformacion(request, montoAConvertir);

            ResponseType response = (ResponseType) servicio.invocar();
            if (response != null) {
                if (response.getDataHeader().getCaracterAceptacion().equalsIgnoreCase("B")) {
                    strResult[0] = valorMap + "_{valorDolares}";
                    strResult[1] = response.getData().getValorDolares();
                } else {
                    strResult[0] = "Error";
                    strResult[1] = "ConsultaDeDivisas: " + response.getDataHeader().getMsgRespuesta();
                }
            } else {
                strResult[0] = "Error";
                strResult[1] = "ConsultaDeDivisas: Error al consumir el servicio del BUS";
            }
        } else {
            long monto = Long.parseLong("0");
            Locale locale = new Locale("es", "CO");
            NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
            strResult[0] = valorMap + "_{valorDolares}";
            strResult[1] = nf.format(monto);
        }

        return strResult;
    }

    public static void gestorFileNet(ConfiguracionServicio cs, byte[] mByte, String formatoDoc, MsjSolOpGeneracionReporte request, Plantilla plantilla) throws MalformedURLException {                
        String url = cs.getParticular().getValorParametroAdicional("URL_FILE_NET");
        String plantillaDoc = request.getValIdPlantilla();
        com.davivienda.filenet.srvscngestorfilenet.v1.V1 service = new com.davivienda.filenet.srvscngestorfilenet.v1.V1();

//        PortSrvScnGestorFileNetSOAP port = (PortSrvScnGestorFileNetSOAP) service.getPort(PortSrvScnGestorFileNetSOAP.class);
//        BindingProvider bp = (BindingProvider) port;
//        bp.getRequestContext().put("javax.xml.ws.service.endpoint.address", url);
//        bp.getRequestContext().put("com.sun.xml.ws.request.timeout", Integer.valueOf(Integer.parseInt(cs.getParticular().getValorParametroAdicional("FN_TIMEOUT"))));
//        bp.getRequestContext().put("com.sun.xml.ws.connect.timeout", Integer.valueOf(Integer.parseInt(cs.getParticular().getValorParametroAdicional("FN_TIMEOUT"))));

        MsjSolOpCargarDocumento requestCargarDocumento = new MsjSolOpCargarDocumento();
        ContextoSolicitudTipo ctx = new ContextoSolicitudTipo();
        ServicioTipo servicioTipo = new ServicioTipo();
        servicioTipo.setIdServicio(cs.getParticular().getValorParametroAdicional("FN_IdServicio"));
        OperacionCanalTipo opCanalTipo = new OperacionCanalTipo();
        opCanalTipo.setIdSesion(request.getContextoSolicitud().getOperacionCanal().getIdSesion());
        opCanalTipo.setIdTransaccion(request.getContextoSolicitud().getOperacionCanal().getIdTransaccion());
        opCanalTipo.setFecOperacion(new Date());
        opCanalTipo.setValJornada(request.getContextoSolicitud().getOperacionCanal().getValJornada());
        opCanalTipo.setCodMoneda(request.getContextoSolicitud().getOperacionCanal().getCodMoneda());
        opCanalTipo.setCodPais(request.getContextoSolicitud().getOperacionCanal().getCodPais());
        opCanalTipo.setCodIdioma(request.getContextoSolicitud().getOperacionCanal().getCodIdioma());
        ConsumidorTipo consumidorTipo = new ConsumidorTipo();
        consumidorTipo.setIdConsumidor(request.getContextoSolicitud().getConsumidor().getIdConsumidor());
        AplicacionTipo appTipo = new AplicacionTipo();
        appTipo.setIdAplicacion(request.getContextoSolicitud().getConsumidor().getAplicacion().getIdAplicacion());
        consumidorTipo.setAplicacion(appTipo);
        CanalTipo canalTipo = new CanalTipo();
        canalTipo.setIdCanal(request.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
        canalTipo.setIdHost(request.getContextoSolicitud().getConsumidor().getCanal().getIdHost());
        consumidorTipo.setCanal(canalTipo);
        TerminalTipo terminalTipo = new TerminalTipo();
        terminalTipo.setIdTerminal(request.getContextoSolicitud().getConsumidor().getTerminal().getIdTerminal());
        terminalTipo.setValOrigenPeticion(request.getContextoSolicitud().getConsumidor().getTerminal().getValOrigenPeticion());
        terminalTipo.setCodUsuario(request.getContextoSolicitud().getConsumidor().getTerminal().getCodUsuario());
        terminalTipo.setValPerfil(request.getContextoSolicitud().getConsumidor().getTerminal().getValPerfil());
        consumidorTipo.setTerminal(terminalTipo);

        ctx.setConsumidor(consumidorTipo);
        ctx.setOperacionCanal(opCanalTipo);
        ctx.setServicio(servicioTipo);
        requestCargarDocumento.setContextoSolicitud(ctx);

        DocumentoTipo documento = new DocumentoTipo();
        documento.setValClaseDocumento(plantilla.getValClaseDocumento());

        ByteArrayDataSource byteArrayDataSource = new ByteArrayDataSource(mByte, formatoDoc);
        DataHandler dataHandler = new DataHandler((DataSource) byteArrayDataSource);

        
        documento.setValContenido(dataHandler.toString().getBytes());

        documento.setValMimeType(formatoDoc);

        OtrasPropiedadTipo otrasProp = new OtrasPropiedadTipo();
        PropiedadTipo prop = new PropiedadTipo();
        prop.setValLlave("DocumentTitle");

        String nombreAdjunto = cs.getParticular().getValorParametroAdicional(plantillaDoc);

        if (nombreAdjunto != null && nombreAdjunto.contains("_yyyyMMddhhmmss")) {
            Date date = request.getContextoSolicitud().getOperacionCanal().getFecOperacion();
            SimpleDateFormat dt = new SimpleDateFormat("yyyyMMddhhmmss");
            nombreAdjunto = nombreAdjunto.replaceAll("yyyyMMddhhmmss", dt.format(date));
        }

        if (nombreAdjunto != null && nombreAdjunto.contains("[Nro_cuenta_desembolso]")) {
            boolean find = false;
            List<Valor> listaParametros = request.getListaParametros().getValParametro();
            for (Valor v : listaParametros) {
                if ("Nro_cuenta_desembolso".equals(v.getId())
                        && v.getValor().size() > 0) {
                    String valorParametro = v.getValor().get(0);
                    nombreAdjunto = nombreAdjunto.replaceAll("\\[Nro_cuenta_desembolso\\]", valorParametro);
                    find = true;

                    break;
                }
            }
            if (!find) {
                nombreAdjunto = nombreAdjunto.replaceAll("_\\[Nro_cuenta_desembolso\\]", "");
            }
        }

        prop.setValValor(request.getCliente().getNumeroIdentificacion() + nombreAdjunto);
        otrasProp.getPropiedad().add(prop);

        prop = new PropiedadTipo();
        prop.setValLlave("tipoIdentificacion");
        prop.setValValor(homologarTipoIdentificacion(String.valueOf(request.getCliente().getTipoIdentificacion()), cs));
        otrasProp.getPropiedad().add(prop);

        prop = new PropiedadTipo();
        prop.setValLlave("numeroIdentificacion");
        prop.setValValor(request.getCliente().getNumeroIdentificacion());
        otrasProp.getPropiedad().add(prop);

        prop = new PropiedadTipo();
        prop.setValLlave("tipoDocumento");
        prop.setValValor(plantilla.getTipoDocumento());
        otrasProp.getPropiedad().add(prop);

        prop = new PropiedadTipo();
        prop.setValLlave("fechaExpedicion");
        String fechaExpedicion = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(request.getContextoSolicitud().getOperacionCanal().getFecOperacion());
        prop.setValValor(fechaExpedicion.replace(' ', 'T'));
        otrasProp.getPropiedad().add(prop);

        if (null != request.getListaLlaveFileNet() && null != request.getListaLlaveFileNet().getLlave()) {
            for (Llave llave : request.getListaLlaveFileNet().getLlave()) {
                prop = new PropiedadTipo();
                prop.setValLlave(llave.getNombreLlave());
                prop.setValValor(llave.getValorLlave());
                otrasProp.getPropiedad().add(prop);
            }
        }

        documento.setOtrasPropiedades(otrasProp);
        requestCargarDocumento.setDocumento(documento);
        
        //alamcenar información dle request para usar esta variable en la op para setear el request a enviar al maestro
        requestFileNet = requestCargarDocumento;
        
        //MsjRespOpCargarDocumento response = port.opCargarDocumento(requestCargarDocumento);
        
        

        //return response;
    }

    public static void enviarCopiaCorreo(ConfiguracionServicio cs, byte[] mByte, String formatoDoc, MsjSolOpGeneracionReporte requestEntrada, Plantilla plantilla) throws GenerarReporteException {
        
    
        String formato, url = cs.getParticular().getValorParametroAdicional("URL_NOTIFICACIONES_MAIL");

        V1 service = new V1();
//        PortSrvScnNotificacionesMailSOAP port = (PortSrvScnNotificacionesMailSOAP) service.getPort(PortSrvScnNotificacionesMailSOAP.class);
//        BindingProvider bp = (BindingProvider) port;
//        bp.getRequestContext().put("javax.xml.ws.service.endpoint.address", url);
//        bp.getRequestContext().put("com.sun.xml.ws.request.timeout", Integer.valueOf(Integer.parseInt(cs.getParticular().getValorParametroAdicional("NM_TIMEOUT"))));
//        bp.getRequestContext().put("com.sun.xml.ws.connect.timeout", Integer.valueOf(Integer.parseInt(cs.getParticular().getValorParametroAdicional("NM_TIMEOUT"))));

        MsjSolOpEnviarMail request = new MsjSolOpEnviarMail();
        ContextoSolicitudTipo ctx = new ContextoSolicitudTipo();
        ServicioTipo servicioTipo = new ServicioTipo();
        servicioTipo.setIdServicio(cs.getParticular().getValorParametroAdicional("NM_IdServicio"));
        OperacionCanalTipo opCanalTipo = new OperacionCanalTipo();
        opCanalTipo.setIdSesion(requestEntrada.getContextoSolicitud().getOperacionCanal().getIdSesion());
        opCanalTipo.setIdTransaccion(requestEntrada.getContextoSolicitud().getOperacionCanal().getIdTransaccion());
        opCanalTipo.setFecOperacion(new Date());
        opCanalTipo.setValJornada(requestEntrada.getContextoSolicitud().getOperacionCanal().getValJornada());
        opCanalTipo.setCodMoneda(requestEntrada.getContextoSolicitud().getOperacionCanal().getCodMoneda());
        opCanalTipo.setCodPais(requestEntrada.getContextoSolicitud().getOperacionCanal().getCodPais());
        opCanalTipo.setCodIdioma(requestEntrada.getContextoSolicitud().getOperacionCanal().getCodIdioma());
        ConsumidorTipo consumidorTipo = new ConsumidorTipo();
        consumidorTipo.setIdConsumidor(requestEntrada.getContextoSolicitud().getConsumidor().getIdConsumidor());
        AplicacionTipo appTipo = new AplicacionTipo();
        appTipo.setIdAplicacion(requestEntrada.getContextoSolicitud().getConsumidor().getAplicacion().getIdAplicacion());
        consumidorTipo.setAplicacion(appTipo);
        CanalTipo canalTipo = new CanalTipo();
        canalTipo.setIdCanal(requestEntrada.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
        canalTipo.setIdHost(requestEntrada.getContextoSolicitud().getConsumidor().getCanal().getIdHost());
        consumidorTipo.setCanal(canalTipo);
        TerminalTipo terminalTipo = new TerminalTipo();
        terminalTipo.setIdTerminal(requestEntrada.getContextoSolicitud().getConsumidor().getTerminal().getIdTerminal());
        terminalTipo.setValOrigenPeticion(requestEntrada.getContextoSolicitud().getConsumidor().getTerminal().getValOrigenPeticion());
        terminalTipo.setCodUsuario(requestEntrada.getContextoSolicitud().getConsumidor().getTerminal().getCodUsuario());
        terminalTipo.setValPerfil(requestEntrada.getContextoSolicitud().getConsumidor().getTerminal().getValPerfil());
        consumidorTipo.setTerminal(terminalTipo);

        ctx.setConsumidor(consumidorTipo);
        ctx.setOperacionCanal(opCanalTipo);
        ctx.setServicio(servicioTipo);

        request.setContextoSolicitud(ctx);

        DataMail dataMail = new DataMail();
        if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getTipoNotificacion() != null) {
            dataMail.setTipoNotificacion(requestEntrada.getNotificacion().getTipoNotificacion());
        } else {
            dataMail.setTipoNotificacion(plantilla.getNotificacion().getTipoNotificacion());
        }
        DestinoTipo destinoTipo = new DestinoTipo();

        String destinatarios = requestEntrada.getCliente().getValMail();
        if (requestEntrada.getCliente().getValCCMail() != null && !"".equals(requestEntrada.getCliente().getValCCMail())) {
            if (destinatarios != null) {
                destinatarios = destinatarios + ";" + requestEntrada.getCliente().getValCCMail();
            } else {
                destinatarios = requestEntrada.getCliente().getValCCMail();
            }
        }
        destinoTipo.setValMail(destinatarios);

        dataMail.setDestino(destinoTipo);
        MensajeTipo mensajeTipo = new MensajeTipo();

        if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje().getValAsunto() != null) {
            mensajeTipo.setValAsunto(requestEntrada.getNotificacion().getMensaje().getValAsunto());
        } else {
            mensajeTipo.setValAsunto(plantilla.getNotificacion().getMensaje().getValAsunto());
        }

        if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje().getFormato() != null) {
            formato = requestEntrada.getNotificacion().getMensaje().getFormato();
        } else {
            formato = plantilla.getNotificacion().getMensaje().getFormato();
        }
        mensajeTipo.setFormato(formato);

        if (formato.equals("html")) {
            PlantillaTipo plant;
            if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje().getPlantilla() != null) {
                plant = requestEntrada.getNotificacion().getMensaje().getPlantilla();
            } else {
                plant = plantilla.getNotificacion().getMensaje().getPlantilla();
            }
            List<ParametroPlantillaTipo> listaParam = new ArrayList<ParametroPlantillaTipo>();

            for (ParametroPlantillaTipo param : plant.getParametrosPlantilla()) {
                for (Valor valor : requestEntrada.getListaParametros().getValParametro()) {

                    String valValorParamMail = param.getValValor();
                    if (valValorParamMail != null) {
                        int i = valValorParamMail.indexOf("#");
                        String valValorPareMailSinFunciones = valValorParamMail;
                        if (i > 0) {
                            valValorPareMailSinFunciones = valValorParamMail.substring(0, i);
                        }

                        if (valor.getId().equals(valValorPareMailSinFunciones)) {

                            if (valValorParamMail.endsWith("#transformarFecha")) {
                                String valorParametroPlantilla = valor.getValor().get(0);

                                String valorFechaFormato = FuncionesTransformacion.formatearFechaV2(valorParametroPlantilla, "dd", requestEntrada.getContextoSolicitud().getOperacionCanal().getCodIdioma(), "yyyyMMdd");
                                valorFechaFormato = valorFechaFormato + " de " + FuncionesTransformacion.formatearFechaV2(valorParametroPlantilla, "MMMM", requestEntrada.getContextoSolicitud().getOperacionCanal().getCodIdioma(), "yyyyMMdd");
                                valorFechaFormato = valorFechaFormato + " de " + FuncionesTransformacion.formatearFechaV2(valorParametroPlantilla, "yyyy", requestEntrada.getContextoSolicitud().getOperacionCanal().getCodIdioma(), "yyyyMMdd");
                                param.setValValor(valorFechaFormato);
                            } else if (valValorParamMail.endsWith("#transformarNumero")) {

                                String valorParametroPlantilla = valor.getValor().get(0);

                                String valorNumeroFormato = FuncionesTransformacion.formatearNumero(valorParametroPlantilla, 9, 2, "  ", true, false);
                                param.setValValor(valorNumeroFormato);
                            } else {

                                param.setValValor(valor.getValor().get(0));
                            }

                            listaParam.add(param);
                        }
                    }
                }

                plant.setParametrosPlantilla(listaParam);
                mensajeTipo.setPlantilla(plant);
            }

        } else if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje().getValContenido() != null) {
            mensajeTipo.setValContenido(requestEntrada.getNotificacion().getMensaje().getValContenido());
        } else {
            mensajeTipo.setValContenido(plantilla.getNotificacion().getMensaje().getValContenido());
        }

        dataMail.setMensaje(mensajeTipo);
        String isEsperaRespuestaEmail = cs.getParticular().getValorParametroAdicional("ESPERA_RESPUESTA_MAIL");
        if (isEsperaRespuestaEmail != null) {
            dataMail.setIsEsperaRespuesta(Boolean.parseBoolean(isEsperaRespuestaEmail));
        } else {
            dataMail.setIsEsperaRespuesta(false);
        }

        String extension = MimeTypeConstants.getExtension(cs.getParticular().getValorParametroAdicional("MIME_TYPE"));

        AdjuntoTipo adjunto = new AdjuntoTipo();

        String nombreAdjunto = cs.getParticular().getValorParametroAdicional(requestEntrada.getValIdPlantilla());

        if (nombreAdjunto != null && nombreAdjunto.contains("yyyyMMddhhmmss")) {
            Date date = requestEntrada.getContextoSolicitud().getOperacionCanal().getFecOperacion();
            SimpleDateFormat dt = new SimpleDateFormat("yyyyMMddhhmmss");
            nombreAdjunto = nombreAdjunto.replaceAll("yyyyMMddhhmmss", dt.format(date));
        }

        if (nombreAdjunto != null && nombreAdjunto.contains("[Nro_cuenta_desembolso]")) {
            boolean find = false;
            List<Valor> listaParametros = requestEntrada.getListaParametros().getValParametro();
            for (Valor v : listaParametros) {
                if ("Nro_cuenta_desembolso".equals(v.getId())
                        && v.getValor().size() > 0) {
                    String valorParametro = v.getValor().get(0);
                    nombreAdjunto = nombreAdjunto.replaceAll("\\[Nro_cuenta_desembolso\\]", valorParametro);
                    find = true;

                    break;
                }
            }
            if (!find) {
                nombreAdjunto = nombreAdjunto.replaceAll("_\\[Nro_cuenta_desembolso\\]", "");
            }
        }

        if (nombreAdjunto != null && nombreAdjunto.startsWith("_")) {
            adjunto.setValNombre(requestEntrada.getCliente().getNumeroIdentificacion() + nombreAdjunto + "." + extension);
        } else if (nombreAdjunto != null) {
            adjunto.setValNombre(nombreAdjunto + "." + extension);
        } else {
            adjunto.setValNombre("DocumentoAdjunto." + extension);
        }

        adjunto.setValContenido(mByte);
        adjunto.setValTipo(formatoDoc);
        dataMail.getAdjuntos().add(adjunto);

        request.setDataMail(dataMail);
        MsjRespOpEnviarMail response = null;
//        try {
//            response = port.opEnviarMail(request);
//        } catch (Exception ex) {
//            response = new MsjRespOpEnviarMail();
//            ContextoRespuestaTipo contextoRespuesta = new ContextoRespuestaTipo();
//            response.setContextoRespuesta(contextoRespuesta);
//            ResultadoTransaccionTipo resulta = new ResultadoTransaccionTipo();
//            contextoRespuesta.setResultadoTransaccion(resulta);
//            resulta.setValCaracterAceptacion("M");
//
//            return response;
//        }
        
        requestCorreo = request;
       // return response;
    }

    public static void enviarCopiaCorreo(ConfiguracionServicio cs, byte[] mByte, String formatoDoc, MsjSolOpGeneracionReporte requestEntrada) {
        String formato, url = cs.getParticular().getValorParametroAdicional("URL_NOTIFICACIONES_MAIL");

        V1 service = new V1();
//        PortSrvScnNotificacionesMailSOAP port = (PortSrvScnNotificacionesMailSOAP) service.getPort(PortSrvScnNotificacionesMailSOAP.class);
//        BindingProvider bp = (BindingProvider) port;
//        bp.getRequestContext().put("javax.xml.ws.service.endpoint.address", url);
//        bp.getRequestContext().put("com.sun.xml.ws.request.timeout", Integer.valueOf(Integer.parseInt(cs.getParticular().getValorParametroAdicional("NM_TIMEOUT"))));
//        bp.getRequestContext().put("com.sun.xml.ws.connect.timeout", Integer.valueOf(Integer.parseInt(cs.getParticular().getValorParametroAdicional("NM_TIMEOUT"))));

        MsjSolOpEnviarMail request = new MsjSolOpEnviarMail();
        ContextoSolicitudTipo ctx = new ContextoSolicitudTipo();
        ServicioTipo servicioTipo = new ServicioTipo();
        servicioTipo.setIdServicio(cs.getParticular().getValorParametroAdicional("NM_IdServicio"));
        OperacionCanalTipo opCanalTipo = new OperacionCanalTipo();
        opCanalTipo.setIdSesion(requestEntrada.getContextoSolicitud().getOperacionCanal().getIdSesion());
        opCanalTipo.setIdTransaccion(requestEntrada.getContextoSolicitud().getOperacionCanal().getIdTransaccion());
        opCanalTipo.setFecOperacion(new Date());
        opCanalTipo.setValJornada(requestEntrada.getContextoSolicitud().getOperacionCanal().getValJornada());
        opCanalTipo.setCodMoneda(requestEntrada.getContextoSolicitud().getOperacionCanal().getCodMoneda());
        opCanalTipo.setCodPais(requestEntrada.getContextoSolicitud().getOperacionCanal().getCodPais());
        opCanalTipo.setCodIdioma(requestEntrada.getContextoSolicitud().getOperacionCanal().getCodIdioma());
        ConsumidorTipo consumidorTipo = new ConsumidorTipo();
        consumidorTipo.setIdConsumidor(requestEntrada.getContextoSolicitud().getConsumidor().getIdConsumidor());
        AplicacionTipo appTipo = new AplicacionTipo();
        appTipo.setIdAplicacion(requestEntrada.getContextoSolicitud().getConsumidor().getAplicacion().getIdAplicacion());
        consumidorTipo.setAplicacion(appTipo);
        CanalTipo canalTipo = new CanalTipo();
        canalTipo.setIdCanal(requestEntrada.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
        canalTipo.setIdHost(requestEntrada.getContextoSolicitud().getConsumidor().getCanal().getIdHost());
        consumidorTipo.setCanal(canalTipo);
        TerminalTipo terminalTipo = new TerminalTipo();
        terminalTipo.setIdTerminal(requestEntrada.getContextoSolicitud().getConsumidor().getTerminal().getIdTerminal());
        terminalTipo.setValOrigenPeticion(requestEntrada.getContextoSolicitud().getConsumidor().getTerminal().getValOrigenPeticion());
        terminalTipo.setCodUsuario(requestEntrada.getContextoSolicitud().getConsumidor().getTerminal().getCodUsuario());
        terminalTipo.setValPerfil(requestEntrada.getContextoSolicitud().getConsumidor().getTerminal().getValPerfil());
        consumidorTipo.setTerminal(terminalTipo);

        ctx.setConsumidor(consumidorTipo);
        ctx.setOperacionCanal(opCanalTipo);
        ctx.setServicio(servicioTipo);

        request.setContextoSolicitud(ctx);

        DataMail dataMail = new DataMail();
        if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getTipoNotificacion() != null) {
            dataMail.setTipoNotificacion(requestEntrada.getNotificacion().getTipoNotificacion());
        } else {
            dataMail.setTipoNotificacion(requestEntrada.getNotificacion().getTipoNotificacion());
        }
        DestinoTipo destinoTipo = new DestinoTipo();

        String destinatarios = requestEntrada.getCliente().getValMail();
        if (requestEntrada.getCliente().getValCCMail() != null && !"".equals(requestEntrada.getCliente().getValCCMail())) {
            if (destinatarios != null) {
                destinatarios = destinatarios + ";" + requestEntrada.getCliente().getValCCMail();
            } else {
                destinatarios = requestEntrada.getCliente().getValCCMail();
            }
        }
        destinoTipo.setValMail(destinatarios);

        dataMail.setDestino(destinoTipo);
        MensajeTipo mensajeTipo = new MensajeTipo();

        if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje().getValAsunto() != null) {
            mensajeTipo.setValAsunto(requestEntrada.getNotificacion().getMensaje().getValAsunto());
        } else {
            mensajeTipo.setValAsunto(requestEntrada.getNotificacion().getMensaje().getValAsunto());
        }

        if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje().getFormato() != null) {
            formato = requestEntrada.getNotificacion().getMensaje().getFormato();
        } else {
            formato = requestEntrada.getNotificacion().getMensaje().getFormato();
        }
        mensajeTipo.setFormato(formato);

        if (formato.equals("html")) {
            PlantillaTipo plant = null;
            if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje().getPlantilla() != null) {
                plant = requestEntrada.getNotificacion().getMensaje().getPlantilla();
                mensajeTipo.setPlantilla(plant);
            }

        } else if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje().getValContenido() != null) {
            mensajeTipo.setValContenido(requestEntrada.getNotificacion().getMensaje().getValContenido());
        } else {
            mensajeTipo.setValContenido(requestEntrada.getNotificacion().getMensaje().getValContenido());
        }

        dataMail.setMensaje(mensajeTipo);
        String isEsperaRespuestaEmail = cs.getParticular().getValorParametroAdicional("ESPERA_RESPUESTA_MAIL");
        if (isEsperaRespuestaEmail != null) {
            dataMail.setIsEsperaRespuesta(Boolean.parseBoolean(isEsperaRespuestaEmail));
        } else {
            dataMail.setIsEsperaRespuesta(false);
        }

        String extension = MimeTypeConstants.getExtension(cs.getParticular().getValorParametroAdicional("MIME_TYPE"));

        AdjuntoTipo adjunto = new AdjuntoTipo();
        String nombreAdjunto = cs.getParticular().getValorParametroAdicional(requestEntrada.getReporte().getTipoCertificacion());

        if (nombreAdjunto != null && nombreAdjunto.contains("_yyyyMMddhhmmss")) {
            Date date = requestEntrada.getContextoSolicitud().getOperacionCanal().getFecOperacion();
            SimpleDateFormat dt = new SimpleDateFormat("yyyyMMddhhmmss");
            nombreAdjunto = nombreAdjunto.replaceAll("yyyyMMddhhmmss", dt.format(date));
        }

        if (nombreAdjunto != null && nombreAdjunto.contains("[Nro_cuenta_desembolso]")) {
            boolean find = false;
            List<Valor> listaParametros = requestEntrada.getListaParametros().getValParametro();
            for (Valor v : listaParametros) {
                if ("Nro_cuenta_desembolso".equals(v.getId())
                        && v.getValor().size() > 0) {
                    String valorParametro = v.getValor().get(0);
                    nombreAdjunto = nombreAdjunto.replaceAll("\\[Nro_cuenta_desembolso\\]", valorParametro);
                    find = true;

                    break;
                }
            }
            if (!find) {
                nombreAdjunto = nombreAdjunto.replaceAll("_\\[Nro_cuenta_desembolso\\]", "");
            }
        }

        if (nombreAdjunto != null && nombreAdjunto.startsWith("_")) {
            adjunto.setValNombre(requestEntrada.getCliente().getNumeroIdentificacion() + nombreAdjunto + "." + extension);
        } else if (nombreAdjunto != null) {
            adjunto.setValNombre(nombreAdjunto + "." + extension);
        } else {
            adjunto.setValNombre("DocumentoAdjunto." + extension);
        }

        adjunto.setValContenido(mByte);
        adjunto.setValTipo(formatoDoc);
        dataMail.getAdjuntos().add(adjunto);

        request.setDataMail(dataMail);
        MsjRespOpEnviarMail response = null;
//        try {
//            response = port.opEnviarMail(request);
//        } catch (Exception ex) {
//            response = new MsjRespOpEnviarMail();
//            ContextoRespuestaTipo contextoRespuesta = new ContextoRespuestaTipo();
//            response.setContextoRespuesta(contextoRespuesta);
//            ResultadoTransaccionTipo resulta = new ResultadoTransaccionTipo();
//            contextoRespuesta.setResultadoTransaccion(resulta);
//            resulta.setValCaracterAceptacion("M");
//
//            return response;
//        }
        
        requestCorreo = request;
      //  return response;
    }

    private static String homologarTipoIdentificacion(String original, ConfiguracionServicio cs) {
        Parametro nuevoValor = cs.getParticular().getParametroAdicional(original);
        if (nuevoValor != null) {
            return nuevoValor.getValor();
        }
        return original;
    }
}
