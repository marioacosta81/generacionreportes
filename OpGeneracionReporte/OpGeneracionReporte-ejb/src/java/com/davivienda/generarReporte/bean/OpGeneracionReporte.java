package com.davivienda.generarReporte.bean;

import com.davivienda.esquemas.filenet.documentotipo.v1.DocumentoTipo;
import com.davivienda.esquemas.filenet.propiedadtipo.v1.PropiedadTipo;
import com.davivienda.esquemas.framework.aplicaciontipo.v1.AplicacionTipo;
import com.davivienda.esquemas.framework.canaltipo.v1.CanalTipo;
import com.davivienda.esquemas.framework.consumidortipo.v1.ConsumidorTipo;
import com.davivienda.esquemas.framework.contextosolicitudtipo.v1.ContextoSolicitudTipo;
import com.davivienda.esquemas.framework.operacioncanaltipo.v1.OperacionCanalTipo;
import com.davivienda.esquemas.framework.serviciotipo.v1.ServicioTipo;
import com.davivienda.esquemas.framework.terminaltipo.v1.TerminalTipo;
import com.davivienda.esquemas.generarreporte.respuestacertificadotipo.v1.RespuestaCertificadoTipo;
import com.davivienda.esquemas.persona.clientenaturaltipo.v1.ClienteNaturalTipo;
import com.davivienda.filenet.srvscngestorfilenet.v1.MsjSolOpCargarDocumento;
import com.davivienda.generacion.documentos.persistence.dto.ControlErrorDTO;
import com.davivienda.generacion.documentos.persistence.dto.ControlSolicitudDTO;
import com.davivienda.generacion.documentos.persistence.interfaces.GeneracionDocumentosPersistenceFacadeRemote;
import com.davivienda.generacion.documentos.util.ConstantesGeneracionDocumentos;
import com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.ListaLlaveFileNet;
import com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.config.reporte.Notificacion;
import com.davivienda.generacion.documentos.ws.srvscngestorfilenet.otraspropiedadtipo.v1.OtrasPropiedadTipo;
import com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.datamail.v1.MensajeTipo;
import com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.datamail.v1.ParametroPlantillaTipo;
import com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.datamail.v1.PlantillaTipo;
import com.davivienda.generarReporte.config.reporte.ConfigAdicional;
import com.davivienda.generarReporte.config.reporte.Plantilla;
import com.davivienda.generarReporte.constantes.ConstantesGenerarReporte;
import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.exception.ErrorNoEsperadoException;
import com.davivienda.generarReporte.exception.GenerarReporteException;
import com.davivienda.generarReporte.interfaces.OpGenerarReporteLocal;
import com.davivienda.generarReporte.interfaces.OpGenerarReporteRemote;
import com.davivienda.generarReporte.reporte.OrquestadorReporte;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.ClienteType;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Llave;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjRespOpGeneracionReporte;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.ProductoType;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Registro;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.ReporteType;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Valor;
import com.davivienda.generarReporte.servicios.InvocarServicios;
import com.davivienda.generarReporte.util.FuncionesTransformacion;
import com.davivienda.generarReporte.util.GenerarReporteComunesUtil;
import com.davivienda.generarReporte.util.MimeTypeConstants;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.AdjuntoTipo;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.DataMail;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.DestinoTipo;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.MsjRespOpEnviarMail;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.MsjSolOpEnviarMail;
import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.V1;
import com.ibm.cache.bo.particular.Parametro;
import com.ibm.cache.bo.servicio.ConfiguracionServicio;
import com.ibm.cache.exception.XmlToDtoException;
import com.ibm.cache.scn.config.HelperCache;
import com.ibm.cache.scn.servicios.EJBCycleCache;
import com.ibm.cache.scn.servicios.OpActualizarCache;
import com.ibm.cache.util.XmlToDto;
import com.ibm.comunes.exception.ConfiguracionException;
import com.ibm.comunes.log.ContextoTransaccion;
import com.ibm.comunes.log.Logger;
import com.ibm.comunes.servicios.SCNMensajeEntrada;
import com.ibm.comunes.servicios.exception.SCNException;
import com.ibm.comunes.utilitarios.SCNComunesUtil;
import static com.ibm.comunes.utilitarios.SCNComunesUtil.getContextoTransaccion;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.xml.bind.DatatypeConverter;

@Stateless(name = "OpGeneracionReporte", mappedName = "OpGeneracionReporte")
@Remote(value = {OpActualizarCache.class, OpGenerarReporteRemote.class})
@Local(value = {OpGenerarReporteLocal.class})
public class OpGeneracionReporte extends EJBCycleCache implements OpGenerarReporteRemote<MsjSolOpGeneracionReporte, MsjRespOpGeneracionReporte>, OpGenerarReporteLocal<MsjSolOpGeneracionReporte, MsjRespOpGeneracionReporte> {

    private GeneracionDocumentosPersistenceFacadeRemote generacionDocumentosFacade;
    private static final OrquestadorReporte orquestadorReporte = OrquestadorReporte.getInstance();

    private final String nombreOperacion = "OpGeneracionReporte";
    private ContextoSolicitudTipo contextoSolicitud;
    private ContextoTransaccion contextoTransaccion;
    private ConfigAdicional ca;
    private String mime = null;
    private boolean esPlantilla = false;
    public byte[] documentoSinClave = null;
    private Logger logger;
    public MsjSolOpCargarDocumento requestFileNet;
    public MsjSolOpEnviarMail requestCorreo;

    public MsjRespOpGeneracionReporte procesar(MsjSolOpGeneracionReporte request, ContextoTransaccion contextoTx) throws SCNException {

        //tipo de invocación (directo - maestro)
        boolean directo = true;
        try {
            this.contextoTransaccion = contextoTx;
            this.contextoSolicitud = request.getContextoSolicitud();
            logger = new Logger(this.getClass().getName());

            logger.init(this.configuracionServicio.getParticular().getConfigLog(), contextoTransaccion);
            logger.info("INICIO - Operación " + nombreOperacion);
        } catch (Exception ex) {
            this.logger.warn("No es posible inicializar logger: " + ex.getMessage());
        }

        request = validarXML(request);

        if (null != request.getListaParametros() && null != request.getListaParametros().getValParametro()) {
            for (Valor param : request.getListaParametros().getValParametro()) {
                if (param.getId().equals("MIME_TYPE")) {
                    this.mime = param.getValor().get(0);
                }
            }
        }

        MsjRespOpGeneracionReporte response = new MsjRespOpGeneracionReporte();
        String nombreServicio = System.getProperty("SCN.NOM.SER.GENERAR.REPORTE");
        try {

            this.configuracionServicio = HelperCache.getConfiguracionServicio(nombreServicio);
            this.ca = (ConfigAdicional) HelperCache.getObjectCache("SCN_" + nombreServicio, "ALTERNA");

            if (request.getValIdPlantilla() != null) {
                this.logger.info("IdPlantilla " + request.getValIdPlantilla());
            } else if (request.getReporte() != null && request.getReporte().getTipoCertificacion() != null) {
                this.logger.info("TipoCertificacion " + request.getReporte().getTipoCertificacion());
            }
            if (this.configuracionServicio == null || this.ca == null) {
                throw new GenerarReporteException("999", "Configuracion no ha sido cargada correctamente");
            }

            if (this.mime == null) {
                this.mime = this.configuracionServicio.getParticular().getValorParametroAdicional("MIME_TYPE");
            }

            String nombrePlantilla = null;
            String versionPlantilla = null;
            Plantilla plantilla = null;

            List<String> invalidos = validarParametros((SCNMensajeEntrada) request);
            if (invalidos.isEmpty()) {

                logger.debug("Validación de parámetros de entrada exitosa");

                byte[] mByte;

                if (this.esPlantilla) {
                    nombrePlantilla = request.getValIdPlantilla();
                    versionPlantilla = request.getValVersionPlantilla();
                    plantilla = obtenerDocumentoPlantilla(this.ca, nombrePlantilla, versionPlantilla);

                    long startInsert = System.currentTimeMillis();
                    mByte = orquestadorReporte.crearReporte(request, this.configuracionServicio, this.ca, this.logger, plantilla);
                    long endInsert = System.currentTimeMillis();
                    logger.info("Duración de crear documento con IdPlantilla - inicio: " + startInsert + "ms" + " fin: " + endInsert + "ms" + " tiempo:" + (endInsert - startInsert) + "ms" + " IdTransacción:" + request.getContextoSolicitud().getOperacionCanal().getIdTransaccion());

                } else {
                    request.setRetornaDocumento(true);
                    request.setEnviarFileNet(false);
                    if (request.getCliente() == null || request.getCliente().getValMail() == null || "".equals(request.getCliente().getValMail().trim())) {
                        request.setEnviarCopiaCorreo(false);
                    }

                    long startInsert = System.currentTimeMillis();
                    mByte = orquestadorReporte.crearReporte(request, this.configuracionServicio, this.ca, this.logger, null);
                    long endInsert = System.currentTimeMillis();
                    logger.info("Duración de crear documento con Reporte - inicio: " + startInsert + "ms" + " fin: " + endInsert + "ms" + " tiempo:" + (endInsert - startInsert) + "ms" + " IdTransacción:" + request.getContextoSolicitud().getOperacionCanal().getIdTransaccion());

                }

                byte[] mByteFN = null;
                byte[] mByteMail = null;

                if (request.isRequiereClave() != request.isRequiereClaveFileNet()) {
                    if (request.isRequiereClaveFileNet()) {
                        mByteFN = mByte;
                    } else {
                        mByteFN = documentoSinClave;
                    }
                    if (request.isRequiereClave()) {
                        mByteMail = mByte;
                    } else {
                        mByteMail = documentoSinClave;
                    }
                } else {
                    mByteFN = mByte;
                    mByteMail = mByte;
                }
                boolean fileNetResp = true;

                if (request.isEnviarFileNet()) {
                    //sendEnviarFileNet(request, plantilla, mByteFN);
                    gestorFileNet(configuracionServicio, mByte, mime, request, plantilla);
                }

                if (request.isEnviarCopiaCorreo()) {
                    //sendCorreo(fileNetResp, request, plantilla, mByteMail, invalidos, mByte);
                    if (plantilla != null) {//si se envia mail para plantilla o certificado
                        enviarCopiaCorreo(configuracionServicio, mByte, mime, request, plantilla);
                    } else {
                        enviarCopiaCorreo(configuracionServicio, mByte, mime, request);
                    }
                }

                response = armarRespuestaBien(mByte, request.isRetornaDocumento());
            } else {

                response.setContextoRespuesta(GenerarReporteComunesUtil.getContextoRespuestaMal(this.configuracionServicio, this.contextoSolicitud, "44", new Object[]{invalidos}));
                response.setRespuestaCertificado(new RespuestaCertificadoTipo());
            }

        } catch (ErrorExternServiceException e) {
            if (this.logger != null) {
                this.logger.warn("Error de consumo de servicios " + e.getMessage());
            }

            response.setContextoRespuesta(GenerarReporteComunesUtil.getContextoRespuestaMal("20", this.configuracionServicio, this.contextoSolicitud, e
                    .getCodError(), e.getMessage(), new Object[0]));
        } catch (ErrorNoEsperadoException e) {
            if (this.logger != null) {
                this.logger.error("Ha ocurrido un error inesperado, idProceso: " + request.getIdProcesoDocumento() + ", pantilla: " + request.getValIdPlantilla() + ", error: " + e.getMessage(), (Throwable) e);
            } else {
                e.printStackTrace(System.out);
            }
            response.setContextoRespuesta(GenerarReporteComunesUtil.getContextoRespuestaMal(this.configuracionServicio, this.contextoSolicitud, e
                    .getCodError(), new Object[]{e.getMessage()}));
        } catch (GenerarReporteException e) {
            if (this.logger != null) {
                this.logger.error("Error de generacion de reporte, idProceso: " + request.getIdProcesoDocumento() + ", pantilla: " + request.getValIdPlantilla() + ", error: " + e.getMessage(), (Throwable) e);
            } else {
                e.printStackTrace(System.out);
            }
            response.setContextoRespuesta(GenerarReporteComunesUtil.getContextoRespuestaMal(this.configuracionServicio, this.contextoSolicitud, e
                    .getCodError(), new Object[]{e.getMessage()}));
        } catch (Exception e) {
            if (this.logger != null) {
                this.logger.error("Error general, idProceso: " + request.getIdProcesoDocumento() + ", pantilla: " + request.getValIdPlantilla() + ", error: " + e.getMessage(), e);
            } else {
                e.printStackTrace(System.out);
            }
            response.setContextoRespuesta(GenerarReporteComunesUtil.getContextoRespuestaMal(this.configuracionServicio, this.contextoSolicitud, "43", new Object[]{e
                .getMessage()}));
        }
        /*
        //viene por maestro
        if (request.getIdProcesoDocumento() != null && !request.getIdProcesoDocumento().isEmpty()) {
            directo = false;
        }

        this.logger.info("Invocado directa: " + directo);

        //sí fue consumo directo y respondio por bien        
        if (directo && response.getContextoRespuesta().getResultadoTransaccion().getValCaracterAceptacion().equals("B")
                && (request.isEnviarCopiaCorreo() || request.isEnviarFileNet())) {
            try {
                this.logger.info("Invocación directa y proceso por bien");
                ControlSolicitudDTO csdto = insertarBD(request, response);
                if (csdto != null) {
                    if (csdto.getIdConsecutivo() != 0 || csdto.getCodigoError() != 0) {
                        this.logger.info("Nuevo registro insertado exitosamente");
                    } else {
                        this.logger.error("Error al tratar de insertar el nuevo registro", null);
                    }
                }
            } catch (Exception ex) {
                this.logger.error("Error al tratar de insertar el nuevo registro", ex);
            }
        }

        //sí fue consumo directo y respondio por mal
        if (directo && response.getContextoRespuesta().getResultadoTransaccion().getValCaracterAceptacion().equals("M")) {
            try {
                this.logger.info("Invocación directa y proceso por mal");
                tablaErrores(response, request);
            } catch (Exception ex) {
                this.logger.error("Error al tratar de guardar registro en tabla de errores", ex);
            }
        }

        //sí fue consumo desde un maestro y respondio por bien
        if (!directo && response.getContextoRespuesta().getResultadoTransaccion().getValCaracterAceptacion().equals("B")) {
            try {
                this.logger.info("Invocación maestro y proceso por bien");
                if (request.getIdProcesoDocumento() != null && !request.getIdProcesoDocumento().isEmpty()) {
                    actualizarExitoso(request, response);
                    this.logger.info("Registro actualizado exitosamente");
                }

            } catch (Exception ex) {
                this.logger.error("Error al tratar de actualizar el registro", ex);
            }
        } //sí fue consumo desde un maestro y respondio por mal
        else if (!directo && response.getContextoRespuesta().getResultadoTransaccion().getValCaracterAceptacion().equals("M")) {
            try {
                this.logger.info("Invocación maestro y proceso por mal");
                if (request.getIdProcesoDocumento() != null && !request.getIdProcesoDocumento().isEmpty()) {
                    actualizarFallo(request, response);
                }
                tablaErrores(response, request);
                this.logger.info("Fallo intento, se realizo la actualizacion correspondiente a fallos en la bd ");
            } catch (Exception ex) {
                this.logger.error("Error al tratar de actualizar(actualizarFallo()) el registro de errores en la bd", ex);
            }
        }*/
        return response;
    }

    public void sendEnviarFileNet(MsjSolOpGeneracionReporte request, Plantilla plantilla, byte[] mByteFN) throws MalformedURLException {
        if (request.isEnviarFileNet()) {
            if (this.configuracionServicio.getParticular().getConfigLog().getActivacionLogs().isDebug()) {
                this.logger.debug("Invocando servicio Gestor FileNet");
            }
            InvocarServicios.gestorFileNet(this.configuracionServicio, mByteFN, this.mime, request, plantilla);
        }
    }

    public void gestorFileNet(ConfiguracionServicio cs, byte[] mByte, String formatoDoc, MsjSolOpGeneracionReporte request, Plantilla plantilla) throws MalformedURLException {
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

        documento.setValContenido(mByte);

        documento.setValMimeType(formatoDoc);

        com.davivienda.esquemas.filenet.otraspropiedadtipo.v1.OtrasPropiedadTipo otrasProp = new com.davivienda.esquemas.filenet.otraspropiedadtipo.v1.OtrasPropiedadTipo();
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

    public void sendCorreo(boolean fileNetResp, MsjSolOpGeneracionReporte request, Plantilla plantilla, byte[] mByteMail, Object invalidos, byte[] mByte) {
        if (request.isEnviarCopiaCorreo()) {
            if (this.configuracionServicio.getParticular().getConfigLog().getActivacionLogs().isDebug()) {
                this.logger.debug("Invocando servicio Notificaciones Mail");
            }
            if (plantilla != null) {
                try {
                    InvocarServicios.enviarCopiaCorreo(this.configuracionServicio, mByteMail, this.mime, request, plantilla);
                } catch (GenerarReporteException ex) {
                    this.logger.error("Error al construir request de envio correo", ex);
                }
            } else {
                InvocarServicios.enviarCopiaCorreo(this.configuracionServicio, mByteMail, this.mime, request);
            }
        }
    }

    public void enviarCopiaCorreo(ConfiguracionServicio cs, byte[] mByte, String formatoDoc, MsjSolOpGeneracionReporte requestEntrada, Plantilla plantilla) throws GenerarReporteException {

        String url = cs.getParticular().getValorParametroAdicional("URL_NOTIFICACIONES_MAIL");

        V1 service = new V1();
        /*PortSrvScnNotificacionesMailSOAP port = service.getPort(PortSrvScnNotificacionesMailSOAP.class);
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
        bp.getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, Integer.parseInt(cs.getParticular().getValorParametroAdicional("NM_TIMEOUT")));
        bp.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, Integer.parseInt(cs.getParticular().getValorParametroAdicional("NM_TIMEOUT")));*/

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
        com.davivienda.notificaciones.srvscnnotificacionesmail.v1.MensajeTipo mensajeTipo = new com.davivienda.notificaciones.srvscnnotificacionesmail.v1.MensajeTipo();

        if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje() != null && requestEntrada.getNotificacion().getMensaje().getValAsunto() != null) {
            mensajeTipo.setValAsunto(requestEntrada.getNotificacion().getMensaje().getValAsunto());
        } else {
            mensajeTipo.setValAsunto(plantilla.getNotificacion().getMensaje().getValAsunto());
        }

        String formato;
        if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje() != null && requestEntrada.getNotificacion().getMensaje().getFormato() != null) {
            formato = requestEntrada.getNotificacion().getMensaje().getFormato();
        } else {
            formato = plantilla.getNotificacion().getMensaje().getFormato();
        }
        mensajeTipo.setFormato(formato);

        if (formato.equals("html")) {//plantilla
            com.davivienda.notificaciones.srvscnnotificacionesmail.v1.PlantillaTipo plant = new com.davivienda.notificaciones.srvscnnotificacionesmail.v1.PlantillaTipo();
            if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje().getPlantilla() != null) {
                plant.setIdPlantilla(requestEntrada.getNotificacion().getMensaje().getPlantilla().getIdPlantilla());

                for (com.davivienda.notificaciones.srvscnnotificacionesmail.v1.ParametroPlantillaTipo notifPlantillaParam : requestEntrada.getNotificacion().getMensaje().getPlantilla().getParametrosPlantilla()) {
                    com.davivienda.notificaciones.srvscnnotificacionesmail.v1.ParametroPlantillaTipo parametroPlantillaTipo = new com.davivienda.notificaciones.srvscnnotificacionesmail.v1.ParametroPlantillaTipo();
                    parametroPlantillaTipo.setValNombre(notifPlantillaParam.getValNombre());
                    parametroPlantillaTipo.setValValor(notifPlantillaParam.getValValor());
                    plant.getParametrosPlantilla().add(parametroPlantillaTipo);
                }

            } else {
                plant.setIdPlantilla(plantilla.getNotificacion().getMensaje().getPlantilla().getIdPlantilla());

                for (com.davivienda.notificaciones.srvscnnotificacionesmail.v1.ParametroPlantillaTipo notifPlantillaParam : plantilla.getNotificacion().getMensaje().getPlantilla().getParametrosPlantilla()) {
                    com.davivienda.notificaciones.srvscnnotificacionesmail.v1.ParametroPlantillaTipo parametroPlantillaTipo = new com.davivienda.notificaciones.srvscnnotificacionesmail.v1.ParametroPlantillaTipo();
                    parametroPlantillaTipo.setValNombre(notifPlantillaParam.getValNombre());
                    parametroPlantillaTipo.setValValor(notifPlantillaParam.getValValor());
                    plant.getParametrosPlantilla().add(parametroPlantillaTipo);
                }
            }
            List<com.davivienda.notificaciones.srvscnnotificacionesmail.v1.ParametroPlantillaTipo> listaParam = new ArrayList<com.davivienda.notificaciones.srvscnnotificacionesmail.v1.ParametroPlantillaTipo>();

            /*
            <valValor>FECHA_CARTA#transformarFecha</valValor>
             <valValor>VALOR#transformarNumero</valValor>
             */
            for (com.davivienda.notificaciones.srvscnnotificacionesmail.v1.ParametroPlantillaTipo param : plant.getParametrosPlantilla()) { //son los parametros definidos en la configuracion
                //      System.out.println(param.getValNombre() + " " + param.getValValor());
                for (Valor valor : requestEntrada.getListaParametros().getValParametro()) { // son los parametros request
                    //  System.out.println(valor.getId());
                    String valValorParamMail = param.getValValor();
                    if (valValorParamMail != null) {
                        int i = valValorParamMail.indexOf("#");
                        String valValorPareMailSinFunciones = valValorParamMail;
                        if (i > 0) {
                            valValorPareMailSinFunciones = valValorParamMail.substring(0, i);
                        }

                        if (valor.getId().equals(valValorPareMailSinFunciones)) {//se va a transformar

                            if (valValorParamMail.endsWith("#transformarFecha")) {
                                String valorParametroPlantilla = valor.getValor().get(0);
                                // {FECHA_CARTA,,&formatearFecha(dd)} de {FECHA_CARTA,,&formatearFecha(MMMM)} de {FECHA_CARTA,,&formatearFecha(yyyy)}      
                                String valorFechaFormato = FuncionesTransformacion.formatearFechaV2(valorParametroPlantilla, "dd", requestEntrada.getContextoSolicitud().getOperacionCanal().getCodIdioma(), "yyyyMMdd");
                                valorFechaFormato = valorFechaFormato + " de " + FuncionesTransformacion.formatearFechaV2(valorParametroPlantilla, "MMMM", requestEntrada.getContextoSolicitud().getOperacionCanal().getCodIdioma(), "yyyyMMdd");
                                valorFechaFormato = valorFechaFormato + " de " + FuncionesTransformacion.formatearFechaV2(valorParametroPlantilla, "yyyy", requestEntrada.getContextoSolicitud().getOperacionCanal().getCodIdioma(), "yyyyMMdd");
                                param.setValValor(valorFechaFormato);
                            } else if (valValorParamMail.endsWith("#transformarNumero")) {

                                String valorParametroPlantilla = valor.getValor().get(0);
                                //&formatearNumero(9#2#  #true#false
                                //   public static String formatearNumero(String palabra, int enteros, int decimales, String signoMoneda, boolean separadorMiles, boolean posicionSignoMoneda) throws GenerarReporteException {   
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
        } else {//texto
            if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje() != null && requestEntrada.getNotificacion().getMensaje().getValContenido() != null) {
                mensajeTipo.setValContenido(requestEntrada.getNotificacion().getMensaje().getValContenido());
            } else {
                mensajeTipo.setValContenido(plantilla.getNotificacion().getMensaje().getValContenido());
            }
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

        if (nombreAdjunto != null && nombreAdjunto.contains("yyyyMMddhhmmss")) {//endsWith("_yyyyMMddhhmmss")) {
            Date date = requestEntrada.getContextoSolicitud().getOperacionCanal().getFecOperacion();
            SimpleDateFormat dt = new SimpleDateFormat("yyyyMMddhhmmss");
            nombreAdjunto = nombreAdjunto.replaceAll("yyyyMMddhhmmss", dt.format(date));

        }

        //_[Nro_cuenta_desembolso]{Nro_cuenta_desembolso}
        if (nombreAdjunto != null && nombreAdjunto.contains("[Nro_cuenta_desembolso]")) {
            boolean find = false;
            List<Valor> listaParametros = requestEntrada.getListaParametros().getValParametro();
            for (Valor v : listaParametros) {
                if ("Nro_cuenta_desembolso".equals(v.getId())) {
                    if (v.getValor().size() > 0) {
                        String valorParametro = v.getValor().get(0);
                        nombreAdjunto = nombreAdjunto.replaceAll("\\[Nro_cuenta_desembolso\\]", valorParametro);
                        find = true;
                        break;
                    }
                }
            }
            if (!find) {
                nombreAdjunto = nombreAdjunto.replaceAll("_\\[Nro_cuenta_desembolso\\]", "");
            }

        }

        if (nombreAdjunto != null && nombreAdjunto.startsWith("_")) {
            adjunto.setValNombre(requestEntrada.getCliente().getNumeroIdentificacion() + nombreAdjunto + "." + extension);
        } else {
            if (nombreAdjunto != null) {
                adjunto.setValNombre(nombreAdjunto + "." + extension);
            } else {
                adjunto.setValNombre("DocumentoAdjunto." + extension);
            }

        }

        adjunto.setValContenido(mByte);
        adjunto.setValTipo(formatoDoc);
        dataMail.getAdjuntos().add(adjunto);

        request.setDataMail(dataMail);
        MsjRespOpEnviarMail response = null;
        /*try {
            response = port.opEnviarMail(request);

        } catch (Exception ex) {
            response = new MsjRespOpEnviarMail();
            ContextoRespuestaTipo contextoRespuesta = new ContextoRespuestaTipo();
            response.setContextoRespuesta(contextoRespuesta);
            ResultadoTransaccionTipo resulta = new ResultadoTransaccionTipo();
            contextoRespuesta.setResultadoTransaccion(resulta);
            resulta.setValCaracterAceptacion("M");

            return response;
        }
        return response;*/

        requestCorreo = request;
    }

    public void enviarCopiaCorreo(ConfiguracionServicio cs, byte[] mByte, String formatoDoc, MsjSolOpGeneracionReporte requestEntrada) throws GenerarReporteException {
        String url = cs.getParticular().getValorParametroAdicional("URL_NOTIFICACIONES_MAIL");

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
        com.davivienda.notificaciones.srvscnnotificacionesmail.v1.MensajeTipo mensajeTipo = new com.davivienda.notificaciones.srvscnnotificacionesmail.v1.MensajeTipo();

        if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje() != null && requestEntrada.getNotificacion().getMensaje().getValAsunto() != null) {
            mensajeTipo.setValAsunto(requestEntrada.getNotificacion().getMensaje().getValAsunto());
        } else {
            throw new GenerarReporteException("706", "Campo valAsunto no recibido, tampoco esta configurado en ninguna plantilla");
        }

        String formato;
        if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje() != null && requestEntrada.getNotificacion().getMensaje().getFormato() != null) {
            formato = requestEntrada.getNotificacion().getMensaje().getFormato();
        } else {
            formato = "txt";
        }
        mensajeTipo.setFormato(formato);

        if (formato.equals("html")) {
            com.davivienda.notificaciones.srvscnnotificacionesmail.v1.PlantillaTipo plant = null;
            if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje() != null && requestEntrada.getNotificacion().getMensaje().getPlantilla() != null) {
                plant = requestEntrada.getNotificacion().getMensaje().getPlantilla();
                mensajeTipo.setPlantilla(plant);
            }

        } else if (requestEntrada.getNotificacion() != null && requestEntrada.getNotificacion().getMensaje() != null && requestEntrada.getNotificacion().getMensaje().getValContenido() != null) {
            mensajeTipo.setValContenido(requestEntrada.getNotificacion().getMensaje().getValContenido());
        } else {
            throw new GenerarReporteException("706", "Campo valContenido no recibido, tampoco esta configurado en ninguna plantilla");
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

    public ControlSolicitudDTO insertarBD(MsjSolOpGeneracionReporte request, MsjRespOpGeneracionReporte response) throws Exception {

        generacionDocumentosFacade = SCNComunesUtil.buscarEjb(configuracionServicio, ConstantesGeneracionDocumentos.GENERACION_DOCUMENTOS_PERSISTENCE_FACADE);

        ControlSolicitudDTO controlSolicitudDTO = new ControlSolicitudDTO();
        controlSolicitudDTO.setCodigoPaquete(null);
        if (request.getValIdPlantilla() != null) {
            controlSolicitudDTO.setCodigoPlantilla(request.getValIdPlantilla());
        } else if (request.getReporte() != null && request.getReporte().getTipoCertificacion() != null) {
            controlSolicitudDTO.setCodigoPlantilla(request.getReporte().getTipoCertificacion());
        }

        controlSolicitudDTO.setRequiereGeneracion(ConstantesGeneracionDocumentos.TRUE);
        if (request.isEnviarFileNet()) {
            controlSolicitudDTO.setRequiereEnviarFilenet(ConstantesGeneracionDocumentos.TRUE);
        } else {
            controlSolicitudDTO.setRequiereEnviarFilenet(ConstantesGeneracionDocumentos.FALSE);
        }
        if (request.isEnviarCopiaCorreo()) {
            controlSolicitudDTO.setRequiereEnviarCorreo(ConstantesGeneracionDocumentos.TRUE);
        } else {
            controlSolicitudDTO.setRequiereEnviarCorreo(ConstantesGeneracionDocumentos.FALSE);
        }

        if (this.configuracionServicio.getParticular() != null) {
            if (this.configuracionServicio.getParticular().getValorParametroAdicional("IntentosGeneracion") != null) {
                controlSolicitudDTO.setIntentosGeneracion(Integer.parseInt(this.configuracionServicio.getParticular().getValorParametroAdicional("IntentosGeneracion")));
            }
            if (this.configuracionServicio.getParticular().getValorParametroAdicional("IntentosCorreo") != null) {
                controlSolicitudDTO.setIntentosCorreo(Integer.parseInt(this.configuracionServicio.getParticular().getValorParametroAdicional("IntentosCorreo")));
            }
            if (this.configuracionServicio.getParticular().getValorParametroAdicional("IntentosFileNet") != null) {
                controlSolicitudDTO.setIntentosFileNet(Integer.parseInt(this.configuracionServicio.getParticular().getValorParametroAdicional("IntentosFileNet")));
            }
        }

        if (request.getCliente() != null) {
            if (request.getCliente().getTipoIdentificacion() != null) {
                controlSolicitudDTO.setTipoIdentificacion(request.getCliente().getTipoIdentificacion());
            }
            if (request.getCliente().getNumeroIdentificacion() != null) {
                controlSolicitudDTO.setNumIdentificacion(request.getCliente().getNumeroIdentificacion());
            }
        }

        if (request.getContextoSolicitud() != null) {
            if (request.getContextoSolicitud().getConsumidor() != null) {
                if (request.getContextoSolicitud().getConsumidor().getCanal() != null) {
                    controlSolicitudDTO.setCanal(String.valueOf(request.getContextoSolicitud().getConsumidor().getCanal().getIdCanal()));
                }
            }
        }


        /*sí se solicito envío a filnet, se debe crear un objeto java usado por el comunes que posteriormenete lo usara el maetro; por tal motivo no se
        envia la variable requestFileNet que es un objeto de la misma clase que  que va a usar el maestro, pero de diferente paquete sino que se envía
        la variable requestFilenetParaMaestro que es la aceptada por el maestro*/
        com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte requestReporteMaestro = getRequestReporteMaestro(request);
        if (requestReporteMaestro != null) {
            controlSolicitudDTO.setRequestGeneracion(requestReporteMaestro);
        } else {
            controlSolicitudDTO.setRequiereGeneracion(ConstantesGeneracionDocumentos.FALSE);
        }
        com.davivienda.generacion.documentos.ws.srvscngestorfilenet.v1.MsjSolOpCargarDocumento requestFilenetParaMaestro = getRequestFileNetMaestro(request);
        if (requestFilenetParaMaestro != null) {
            controlSolicitudDTO.setRequestFileNet(requestFilenetParaMaestro);
        } else {
            controlSolicitudDTO.setRequiereEnviarFilenet(ConstantesGeneracionDocumentos.FALSE);
        }

        com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.v1.MsjSolOpEnviarMail requestCorreoMaestro = getRequestCorreoMaestro(request);
        if (requestCorreoMaestro != null) {
            controlSolicitudDTO.setRequestCorreo(requestCorreoMaestro);
        } else {
            controlSolicitudDTO.setRequiereEnviarCorreo(ConstantesGeneracionDocumentos.FALSE);
        }

        controlSolicitudDTO.setResultadoGeneracion(ConstantesGeneracionDocumentos.TRUE);

        if (response.getValDocumentoGenerado() != null) {
            controlSolicitudDTO.setDocumentoGenerado(response.getValDocumentoGenerado());
        }

        long startInsert = System.currentTimeMillis();
        this.logger.info("Se va a ejecutar insertarRegistroGeneracionReporte");
        ControlSolicitudDTO csdto = generacionDocumentosFacade.insertarRegistroGeneracionReporte(controlSolicitudDTO);
        long endInsert = System.currentTimeMillis();
        logger.info("Duración de insertar Registro en BD - inicio: " + startInsert + "ms" + " fin: " + endInsert + "ms" + " tiempo:" + (endInsert - startInsert) + "ms" + " IdTransacción:" + request.getContextoSolicitud().getOperacionCanal().getIdTransaccion());

        return csdto;
    }

    public void actualizarExitoso(MsjSolOpGeneracionReporte request, MsjRespOpGeneracionReporte response) throws ConfiguracionException, Exception {
        generacionDocumentosFacade = SCNComunesUtil.buscarEjb(configuracionServicio, ConstantesGeneracionDocumentos.GENERACION_DOCUMENTOS_PERSISTENCE_FACADE);

        ControlSolicitudDTO controlSolicitudDTO = new ControlSolicitudDTO();
        controlSolicitudDTO.setResultadoGeneracion(ConstantesGeneracionDocumentos.TRUE);

        com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte requestReporteMaestro = getRequestReporteMaestro(request);
        if (requestReporteMaestro != null) {
            controlSolicitudDTO.setRequestGeneracion(requestReporteMaestro);
        }
        com.davivienda.generacion.documentos.ws.srvscngestorfilenet.v1.MsjSolOpCargarDocumento requestFilenetParaMaestro = getRequestFileNetMaestro(request);
        if (requestFilenetParaMaestro != null) {
            controlSolicitudDTO.setRequestFileNet(requestFilenetParaMaestro);
        } else {
            controlSolicitudDTO.setRequiereEnviarFilenet(ConstantesGeneracionDocumentos.FALSE);
        }
        com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.v1.MsjSolOpEnviarMail requestCorreoMaestro = getRequestCorreoMaestro(request);
        if (requestCorreoMaestro != null) {
            controlSolicitudDTO.setRequestCorreo(requestCorreoMaestro);
        } else {
            controlSolicitudDTO.setRequiereEnviarCorreo(ConstantesGeneracionDocumentos.FALSE);
        }

        controlSolicitudDTO.setIdConsecutivo(Integer.parseInt(request.getIdProcesoDocumento()));
        controlSolicitudDTO.setDocumentoGenerado(response.getValDocumentoGenerado());

        long startInsert = System.currentTimeMillis();
        this.logger.info("Se va a ejecutar actualizarRegistroGeneracionReporte-Exitoso");
        generacionDocumentosFacade.actualizarRegistroGeneracionReporte(controlSolicitudDTO);
        long endInsert = System.currentTimeMillis();
        logger.info("Duración de actualizar Registro exitoso en BD - inicio: " + startInsert + "ms" + " fin: " + endInsert + "ms" + " tiempo:" + (endInsert - startInsert) + "ms" + " IdTransacción:" + request.getContextoSolicitud().getOperacionCanal().getIdTransaccion());

    }

    public void actualizarFallo(MsjSolOpGeneracionReporte request, MsjRespOpGeneracionReporte response) throws ConfiguracionException, Exception {
        //Actualizar en caso que el documento NO fue generado exitosamente
        generacionDocumentosFacade = SCNComunesUtil.buscarEjb(configuracionServicio, ConstantesGeneracionDocumentos.GENERACION_DOCUMENTOS_PERSISTENCE_FACADE);
        ControlSolicitudDTO controlSolicitudDTO = new ControlSolicitudDTO();
        controlSolicitudDTO.setResultadoGeneracion(ConstantesGeneracionDocumentos.FALSE);

        controlSolicitudDTO.setIdConsecutivo(Integer.parseInt(request.getIdProcesoDocumento()));

        com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte requestReporteMaestro = getRequestReporteMaestro(request);
        if (requestReporteMaestro != null) {
            controlSolicitudDTO.setRequestGeneracion(requestReporteMaestro);
        } else {
            controlSolicitudDTO.setRequiereGeneracion(ConstantesGeneracionDocumentos.FALSE);
        }
        com.davivienda.generacion.documentos.ws.srvscngestorfilenet.v1.MsjSolOpCargarDocumento requestFilenetParaMaestro = getRequestFileNetMaestro(request);
        if (requestFilenetParaMaestro != null) {
            controlSolicitudDTO.setRequestFileNet(requestFilenetParaMaestro);
        } else {
            controlSolicitudDTO.setRequiereEnviarFilenet(ConstantesGeneracionDocumentos.FALSE);
        }
        com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.v1.MsjSolOpEnviarMail requestCorreoMaestro = getRequestCorreoMaestro(request);
        if (requestCorreoMaestro != null) {
            controlSolicitudDTO.setRequestCorreo(requestCorreoMaestro);
        } else {
            controlSolicitudDTO.setRequiereEnviarCorreo(ConstantesGeneracionDocumentos.FALSE);
        }

        long startInsert = System.currentTimeMillis();
        this.logger.info("Se va a ejecutar actualizarRegistroGeneracionReporte-Fallido");
        generacionDocumentosFacade.actualizarRegistroGeneracionReporte(controlSolicitudDTO);
        long endInsert = System.currentTimeMillis();
        logger.info("Duración de actualizar Registro fallido en BD - inicio: " + startInsert + "ms" + " fin: " + endInsert + "ms" + " tiempo:" + (endInsert - startInsert) + "ms" + " IdTransacción:" + request.getContextoSolicitud().getOperacionCanal().getIdTransaccion());

    }

    public com.davivienda.generacion.documentos.ws.srvscngestorfilenet.v1.MsjSolOpCargarDocumento getRequestFileNetMaestro(MsjSolOpGeneracionReporte request) {
        com.davivienda.generacion.documentos.ws.srvscngestorfilenet.v1.MsjSolOpCargarDocumento requestFilenetParaMaestro = null;

        if (request != null) {
            //INICIA REQUEST fILENET
            if (request.isEnviarFileNet()) {

                if (requestFileNet != null) {

                    requestFilenetParaMaestro = new com.davivienda.generacion.documentos.ws.srvscngestorfilenet.v1.MsjSolOpCargarDocumento();

                    if (requestFileNet.getContextoSolicitud() != null) {
                        requestFilenetParaMaestro.setContextoSolicitud(requestFileNet.getContextoSolicitud());
                    }

                    if (null != requestFileNet.getDocumento()) {
                        DocumentoTipo documento = requestFileNet.getDocumento();
                        com.davivienda.generacion.documentos.ws.srvscngestorfilenet.documentotipo.v1.DocumentoTipo documentoTipo = new com.davivienda.generacion.documentos.ws.srvscngestorfilenet.documentotipo.v1.DocumentoTipo();

                        if (documento.getValClaseDocumento() != null) {
                            documentoTipo.setValClaseDocumento(documento.getValClaseDocumento());
                        }
                        if (documento.getValMimeType() != null) {
                            documentoTipo.setValMimeType(documento.getValMimeType());
                        }
                        if (documento.getContenidoByte() != null) {
                            documentoTipo.setContenidoByte(documento.getContenidoByte());
                        }

                        if (null != documento.getOtrasPropiedades()) {
                            List<com.davivienda.generacion.documentos.ws.srvscngestorfilenet.propiedadtipo.v1.PropiedadTipo> lstPropiedad = new ArrayList<>(0);

                            List<PropiedadTipo> rqPropiedadTipo = documento.getOtrasPropiedades().getPropiedad();

                            for (PropiedadTipo propiedadTipo : rqPropiedadTipo) {
                                com.davivienda.generacion.documentos.ws.srvscngestorfilenet.propiedadtipo.v1.PropiedadTipo item = new com.davivienda.generacion.documentos.ws.srvscngestorfilenet.propiedadtipo.v1.PropiedadTipo();
                                item.setValLlave(propiedadTipo.getValLlave());
                                item.setValValor(propiedadTipo.getValValor());
                                lstPropiedad.add(item);
                            }

                            OtrasPropiedadTipo otrasPropiedadTipo = new OtrasPropiedadTipo();
                            otrasPropiedadTipo.getPropiedad().addAll(lstPropiedad);
                            documentoTipo.setOtrasPropiedades(otrasPropiedadTipo);

                        }
                        requestFilenetParaMaestro.setDocumento(documentoTipo);
                    }

                    if (requestFileNet.getIdProcesoDocumento() != null && isNumeric(requestFileNet.getIdProcesoDocumento())) {
                        requestFilenetParaMaestro.setIdProcesoDocumento(requestFileNet.getIdProcesoDocumento());
                    }
                }
            }
        }

        return requestFilenetParaMaestro;

    }

    public com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.v1.MsjSolOpEnviarMail getRequestCorreoMaestro(MsjSolOpGeneracionReporte request) {

        com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.v1.MsjSolOpEnviarMail requestCorreoMaestro = null;

        int dias = 3;
        String diasStr = this.configuracionServicio.getParticular().getValorParametroAdicional("DIAS_ENVIO_CORREO_POST_SOLICITUD");
        try {
            dias = Integer.parseInt(diasStr);
        } catch (NumberFormatException e) {
            this.logger.warn("No se encontró parametro adicional DIAS_ENVIO_CORREO_POST_SOLICITUD o no es numérico, se tomará " + dias + " por default.");
        }

        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaLimite = Calendar.getInstance();
        fechaLimite.setTime(request.getContextoSolicitud().getOperacionCanal().getFecOperacion());
        fechaLimite.add(Calendar.DATE, (dias + 1));

        //INICIA REQUEST CORREO
        if (request.isEnviarCopiaCorreo() && fechaActual.before(fechaLimite)) {

            if (requestCorreo != null) {
                requestCorreoMaestro = new com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.v1.MsjSolOpEnviarMail();

                if (requestCorreo.getContextoSolicitud() != null) {
                    requestCorreoMaestro.setContextoSolicitud(requestCorreo.getContextoSolicitud());
                }

                if (requestCorreo.getDataMail() != null) {
                    com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.datamail.v1.DataMail dataMail = new com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.datamail.v1.DataMail();

                    if (requestCorreo.getDataMail().getTipoNotificacion() != null) {
                        dataMail.setTipoNotificacion(requestCorreo.getDataMail().getTipoNotificacion());
                    }

                    if (requestCorreo.getDataMail().getDestino() != null) {
                        com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.datamail.v1.DestinoTipo destino = new com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.datamail.v1.DestinoTipo();

                        if (requestCorreo.getDataMail().getDestino().getCliente() != null) {
                            ClienteNaturalTipo clienteNaturalTipo = new ClienteNaturalTipo();
                            ClienteNaturalTipo clienteRqCorreo = requestCorreo.getDataMail().getDestino().getCliente();

                            if (clienteRqCorreo.getCodTipoIdentificacion() != null) {
                                clienteNaturalTipo.setCodTipoIdentificacion(clienteRqCorreo.getCodTipoIdentificacion());
                            }
                            if (clienteRqCorreo.getValNumeroIdentificacion() != null) {
                                clienteNaturalTipo.setValNumeroIdentificacion(clienteRqCorreo.getValNumeroIdentificacion());
                            }
                            if (clienteRqCorreo.getValNombre() != null) {
                                clienteNaturalTipo.setValNombre(clienteRqCorreo.getValNombre());
                            }
                            if (null != clienteRqCorreo.getContacto()) {
                                clienteNaturalTipo.setContacto(clienteNaturalTipo.getContacto());
                            }
                            if (clienteRqCorreo.getValNaturaleza() != null) {
                                clienteNaturalTipo.setValNaturaleza(clienteRqCorreo.getValNaturaleza());
                            }
                            if (clienteRqCorreo.getValPrimerNombre() != null) {
                                clienteNaturalTipo.setValPrimerNombre(clienteRqCorreo.getValPrimerNombre());
                            }
                            if (clienteRqCorreo.getValSegundoNombre() != null) {
                                clienteNaturalTipo.setValSegundoNombre(clienteRqCorreo.getValSegundoNombre());
                            }
                            if (clienteRqCorreo.getValPrimerApellido() != null) {
                                clienteNaturalTipo.setValPrimerApellido(clienteRqCorreo.getValPrimerApellido());
                            }
                            if (clienteRqCorreo.getValSegundoApellido() != null) {
                                clienteNaturalTipo.setValSegundoApellido(clienteRqCorreo.getValSegundoApellido());
                            }
                            if (clienteRqCorreo.getCodSexo() != null) {
                                clienteNaturalTipo.setCodSexo(clienteRqCorreo.getCodSexo());
                            }
                            if (clienteRqCorreo.getCodEstadoCivil() != null) {
                                clienteNaturalTipo.setCodEstadoCivil(clienteRqCorreo.getCodEstadoCivil());
                            }
                            if (clienteRqCorreo.getValLoginAutoservicio() != null) {
                                clienteNaturalTipo.setValLoginAutoservicio(clienteRqCorreo.getValLoginAutoservicio());
                            }
                            if (clienteRqCorreo.getCodNivelEducativo() != null) {
                                clienteNaturalTipo.setCodNivelEducativo(clienteRqCorreo.getCodNivelEducativo());
                            }
                            if (clienteRqCorreo.getValFechaNacimiento() != null) {
                                clienteNaturalTipo.setValFechaNacimiento(clienteRqCorreo.getValFechaNacimiento());
                            }
                            if (clienteRqCorreo.getCodEmpresaAsociada() != null) {
                                clienteNaturalTipo.setCodEmpresaAsociada(clienteRqCorreo.getCodEmpresaAsociada());
                            }
                            if (clienteRqCorreo.getValNombreEmpresaAsociada() != null) {
                                clienteNaturalTipo.setValNombreEmpresaAsociada(clienteRqCorreo.getValNombreEmpresaAsociada());
                            }

                            destino.setCliente(clienteNaturalTipo);
                        }

                        if (requestCorreo.getDataMail().getDestino().getValMail() != null) {
                            destino.setValMail(requestCorreo.getDataMail().getDestino().getValMail());
                        }

                        dataMail.setDestino(destino);
                    }

                    if (requestCorreo.getDataMail().getMensaje() != null) {
                        MensajeTipo mensajeTipo = new MensajeTipo();

                        if (requestCorreo.getDataMail().getMensaje().getValAsunto() != null) {
                            mensajeTipo.setValAsunto(requestCorreo.getDataMail().getMensaje().getValAsunto());
                        }
                        if (requestCorreo.getDataMail().getMensaje().getValContenido() != null) {
                            mensajeTipo.setValContenido(requestCorreo.getDataMail().getMensaje().getValContenido());
                        }

                        if (requestCorreo.getDataMail().getMensaje().getPlantilla() != null) {
                            PlantillaTipo plantillaTipo = new PlantillaTipo();
                            if (requestCorreo.getDataMail().getMensaje().getPlantilla().getIdPlantilla() != null) {
                                plantillaTipo.setIdPlantilla(requestCorreo.getDataMail().getMensaje().getPlantilla().getIdPlantilla());
                            }

                            if (requestCorreo.getDataMail().getMensaje().getPlantilla().getParametrosPlantilla() != null) {
                                List<ParametroPlantillaTipo> listaParametroPlantillaTipo = new ArrayList<>();
                                for (com.davivienda.notificaciones.srvscnnotificacionesmail.v1.ParametroPlantillaTipo parametroPlantilla : requestCorreo.getDataMail().getMensaje().getPlantilla().getParametrosPlantilla()) {
                                    ParametroPlantillaTipo parametroPlantillaTipo = new ParametroPlantillaTipo();
                                    parametroPlantillaTipo.setValNombre(parametroPlantilla.getValNombre());
                                    parametroPlantillaTipo.setValValor(parametroPlantilla.getValValor());
                                    listaParametroPlantillaTipo.add(parametroPlantillaTipo);
                                }

                                plantillaTipo.setParametrosPlantilla(listaParametroPlantillaTipo);
                            }

                            mensajeTipo.setPlantilla(plantillaTipo);
                        }

                        if (requestCorreo.getDataMail().getMensaje().getFormato() != null) {
                            mensajeTipo.setFormato(requestCorreo.getDataMail().getMensaje().getFormato());
                        }

                        dataMail.setMensaje(mensajeTipo);
                    }

                    if (!requestCorreo.getDataMail().getAdjuntos().isEmpty()) {

                        List<com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.datamail.v1.AdjuntoTipo> listaAdjuntos = new ArrayList<com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.datamail.v1.AdjuntoTipo>();
                        for (AdjuntoTipo adjunto : requestCorreo.getDataMail().getAdjuntos()) {
                            com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.datamail.v1.AdjuntoTipo item = new com.davivienda.generacion.documentos.ws.srvscnnotificacionesmail.datamail.v1.AdjuntoTipo();
                            item.setValContenido(adjunto.getValContenido());
                            item.setValNombre(adjunto.getValNombre());
                            item.setValTipo(adjunto.getValTipo());
                            listaAdjuntos.add(item);
                        }
                        dataMail.setAdjuntos(listaAdjuntos);
                    }

                    dataMail.setIsEsperaRespuesta(requestCorreo.getDataMail().isIsEsperaRespuesta());

                    requestCorreoMaestro.setDataMail(dataMail);
                }

                if (requestCorreo.getIdProcesoDocumento() != null && isNumeric(requestCorreo.getIdProcesoDocumento())) {
                    requestCorreoMaestro.setIdProcesoDocumento(requestCorreo.getIdProcesoDocumento());
                }
            }

        } else {
            if (request.isEnviarCopiaCorreo()) {
                this.logger.info("No se enviará mail por superar límite del parametro DIAS_ENVIO_CORREO_POST_SOLICITUD");
            }
        }

        return requestCorreoMaestro;

    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte getRequestReporteMaestro(MsjSolOpGeneracionReporte request) {

        com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte requestReporteMaestro = null;

        if (request != null) {

            requestReporteMaestro = new com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte();

            //inicia request reporte            
            if (request.getContextoSolicitud() != null) {
                requestReporteMaestro.setContextoSolicitud(request.getContextoSolicitud());
            }

            if (request.getReporte() != null) {
                com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.ReporteType reporteType = new com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.ReporteType();

                if (request.getReporte().getTipoCertificacion() != null) {
                    reporteType.setTipoCertificacion(request.getReporte().getTipoCertificacion());
                }
                if (request.getReporte().getCiudadEmision() != null) {
                    reporteType.setCiudadEmision(request.getReporte().getCiudadEmision());
                }
                if (request.getReporte().getTituloPersonal() != null) {
                    reporteType.setTituloPersonal(request.getReporte().getTituloPersonal());
                }
                if (request.getReporte().getDirigidoA() != null) {
                    reporteType.setDirigidoA(request.getReporte().getDirigidoA());
                }

                if (request.getReporte().getFormato() != null) {
                    reporteType.setFormato(request.getReporte().getFormato());
                }
                requestReporteMaestro.setReporte(reporteType);
            }

            if (null != request.getCliente()) {
                com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.ClienteType clienteType = new com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.ClienteType();

                if (request.getCliente().getNombres() != null) {
                    clienteType.setNombres(request.getCliente().getNombres());
                }
                if (request.getCliente().getPrimerApellido() != null) {
                    clienteType.setPrimerApellido(request.getCliente().getPrimerApellido());
                }
                if (request.getCliente().getSegundoApellido() != null) {
                    clienteType.setSegundoApellido(request.getCliente().getSegundoApellido());
                }
                if (request.getCliente().getTipoIdentificacion() != null) {
                    clienteType.setTipoIdentificacion(request.getCliente().getTipoIdentificacion());
                }
                if (request.getCliente().getNumeroIdentificacion() != null) {
                    clienteType.setNumeroIdentificacion(request.getCliente().getNumeroIdentificacion());
                }
                if (request.getCliente().getCiudadExpedicionDocumento() != null) {
                    clienteType.setCiudadExpedicionDocumento(request.getCliente().getCiudadExpedicionDocumento());
                }
                if (request.getCliente().getValMail() != null) {
                    clienteType.setValMail(request.getCliente().getValMail());
                }
                if (request.getCliente().getValCCMail() != null) {
                    clienteType.setValCCMail(request.getCliente().getValCCMail());
                }
                requestReporteMaestro.setCliente(clienteType);
            }

            if (request.getProducto() != null) {
                com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.ProductoType productoType = new com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.ProductoType();

                if (request.getProducto().getCodigoTipoProducto() != null) {
                    productoType.setCodigoTipoProducto(request.getProducto().getCodigoTipoProducto());
                }
                if (request.getProducto().getCodigoSubProducto() != null) {
                    productoType.setCodigoSubProducto(request.getProducto().getCodigoSubProducto());
                }
                if (request.getProducto().getFechaApertura() != null) {
                    productoType.setFechaApertura(request.getProducto().getFechaApertura());
                }
                if (request.getProducto().getNumeroProducto() != null) {
                    productoType.setNumeroProducto(request.getProducto().getNumeroProducto());
                }

                requestReporteMaestro.setProducto(productoType);
            }

            if (request.getValIdPlantilla() != null) {
                requestReporteMaestro.setValIdPlantilla(request.getValIdPlantilla());
            }
            if (request.getValVersionPlantilla() != null) {
                requestReporteMaestro.setValVersionPlantilla(request.getValVersionPlantilla());
            }

            if (request.getListaParametros() != null) {
                com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Parametros parametrosReporte = new com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Parametros();

                if (null != request.getListaParametros().getValParametro()) {
                    List<com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Valor> listaValParametroReporte = new ArrayList<>(0);

                    for (com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Valor parametroReporte : request.getListaParametros().getValParametro()) {
                        com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Valor paramValReporte = new com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Valor();
                        paramValReporte.setId(parametroReporte.getId());
                        paramValReporte.setUnidad(parametroReporte.getUnidad());
                        paramValReporte.getValor().addAll(parametroReporte.getValor());
                        listaValParametroReporte.add(paramValReporte);
                    }

                    parametrosReporte.setValParametro(listaValParametroReporte);
                }

                if (null != request.getListaParametros().getParametroTabla()) {
                    List<com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.ParametroTabla> listaParametroTablaReporte = new ArrayList<>(0);

                    for (com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.ParametroTabla parametroTabla : request.getListaParametros().getParametroTabla()) {
                        com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.ParametroTabla valParametroTabla = new com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.ParametroTabla();

                        valParametroTabla.setValIdTabla(parametroTabla.getValIdTabla());

                        if (null != parametroTabla.getColumnas()) {
                            com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Columna valColumna = new com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Columna();
                            valColumna.setValNombreColumna(parametroTabla.getColumnas().getValNombreColumna());
                            valParametroTabla.setColumnas(valColumna);
                        }

                        if (null != parametroTabla.getRegistros()) {
                            com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Registros valRegistros = new com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Registros();
                            List<com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Registro> listaRegistros = new ArrayList<>(0);
                            for (Registro registro : parametroTabla.getRegistros().getRegistro()) {

                                com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Registro registroReporte = new com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Registro();
                                List<com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Valor> listaValParametro = new ArrayList<>(0);

                                for (Valor valor : registro.getValParametro()) {
                                    com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Valor valorReporte = new com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Valor();
                                    valorReporte.setId(valor.getId());
                                    valorReporte.setUnidad(valor.getUnidad());
                                    valorReporte.getValor().addAll(valor.getValor());
                                    listaValParametro.add(valorReporte);
                                }

                                registroReporte.setValParametro(listaValParametro);
                                listaRegistros.add(registroReporte);
                            }

                            valRegistros.setRegistro(listaRegistros);
                            valParametroTabla.setRegistros(valRegistros);
                        }
                        listaParametroTablaReporte.add(valParametroTabla);
                    }

                    parametrosReporte.setParametroTabla(listaParametroTablaReporte);
                }

                if (request.getListaParametros().getAdjunto() != null) {
                    List<com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.AdjuntoTipo> listaAdjuntoTipoReporte = new ArrayList<com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.AdjuntoTipo>();

                    for (com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.AdjuntoTipo adjuntoTipoReporte : request.getListaParametros().getAdjunto()) {
                        com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.AdjuntoTipo adjuntoTipoReporteMaestro = new com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.AdjuntoTipo();
                        adjuntoTipoReporteMaestro.setValContenido(adjuntoTipoReporte.getValContenido());
                        adjuntoTipoReporteMaestro.setValNombre(adjuntoTipoReporte.getValNombre());
                        adjuntoTipoReporteMaestro.setValTipo(adjuntoTipoReporte.getValTipo());
                        listaAdjuntoTipoReporte.add(adjuntoTipoReporteMaestro);
                    }
                    parametrosReporte.setAdjunto(listaAdjuntoTipoReporte);
                }

                requestReporteMaestro.setListaParametros(parametrosReporte);
            }

            if (request.getListaLlaveFileNet() != null) {
                ListaLlaveFileNet listaLlaveFileNet = new ListaLlaveFileNet();
                if (request.getListaLlaveFileNet().getLlave() != null) {
                    List<com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Llave> listaLlave = new ArrayList<>();
                    for (int i = 0; i < request.getListaLlaveFileNet().getLlave().size(); i++) {
                        com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Llave llave = new com.davivienda.generacion.documentos.ws.srvscngeneracionreporte.v1.Llave();
                        llave.setNombreLlave(request.getListaLlaveFileNet().getLlave().get(i).getNombreLlave());
                        llave.setValorLlave(request.getListaLlaveFileNet().getLlave().get(i).getValorLlave());
                        listaLlave.add(llave);
                    }
                    if (listaLlave.size() > 0) {
                        listaLlaveFileNet.setLlave(listaLlave);
                        requestReporteMaestro.setListaLlaveFileNet(listaLlaveFileNet);
                    }

                }
            }

            requestReporteMaestro.setEnviarCopiaCorreo(request.isEnviarCopiaCorreo());
            requestReporteMaestro.setRequiereClave(request.isRequiereClave());

            if (request.getValClaveDocumento() != null) {
                requestReporteMaestro.setValClaveDocumento(request.getValClaveDocumento());
            }
            requestReporteMaestro.setRetornaDocumento(request.isRetornaDocumento());
            requestReporteMaestro.setEnviarFileNet(request.isEnviarFileNet());
            requestReporteMaestro.setRequiereClaveFileNet(request.isRequiereClaveFileNet());

            if (request.getNotificacion() != null) {
                Notificacion notificacion = new Notificacion();

                if (request.getNotificacion().getTipoNotificacion() != null) {
                    notificacion.setTipoNotificacion(request.getNotificacion().getTipoNotificacion());
                }

                if (request.getNotificacion().getMensaje() != null) {

                    MensajeTipo mensajeTipo = new MensajeTipo();

                    if (request.getNotificacion().getMensaje().getValAsunto() != null) {
                        mensajeTipo.setValAsunto(request.getNotificacion().getMensaje().getValAsunto());
                    }
                    if (request.getNotificacion().getMensaje().getValContenido() != null) {
                        mensajeTipo.setValContenido(request.getNotificacion().getMensaje().getValContenido());
                    }

                    if (request.getNotificacion().getMensaje().getPlantilla() != null) {

                        PlantillaTipo plantillaTipo = new PlantillaTipo();
                        plantillaTipo.setIdPlantilla(request.getNotificacion().getMensaje().getPlantilla().getIdPlantilla());

                        List<ParametroPlantillaTipo> ListaParametroPlantillaTipo = new ArrayList<>();
                        if (request.getNotificacion() != null) {
                            if (request.getNotificacion().getMensaje() != null) {
                                if (request.getNotificacion().getMensaje().getPlantilla() != null) {
                                    if (request.getNotificacion().getMensaje().getPlantilla().getParametrosPlantilla() != null) {
                                        for (com.davivienda.notificaciones.srvscnnotificacionesmail.v1.ParametroPlantillaTipo paraetroPlantilla : request.getNotificacion().getMensaje().getPlantilla().getParametrosPlantilla()) {
                                            ParametroPlantillaTipo parametroPlantillaTipo = new ParametroPlantillaTipo();
                                            parametroPlantillaTipo.setValNombre(paraetroPlantilla.getValNombre());
                                            parametroPlantillaTipo.setValValor(paraetroPlantilla.getValValor());
                                            ListaParametroPlantillaTipo.add(parametroPlantillaTipo);
                                        }
                                    }
                                }
                            }
                        }

                        plantillaTipo.setParametrosPlantilla(ListaParametroPlantillaTipo);
                        mensajeTipo.setPlantilla(plantillaTipo);

                    }

                    if (request.getNotificacion().getMensaje().getFormato() != null) {
                        mensajeTipo.setFormato(request.getNotificacion().getMensaje().getFormato());
                    }

                    notificacion.setMensaje(mensajeTipo);
                }

                requestReporteMaestro.setNotificacion(notificacion);
            }

            if (request.getIdProcesoDocumento() != null && isNumeric(request.getIdProcesoDocumento())) {
                requestReporteMaestro.setIdProcesoDocumento(request.getIdProcesoDocumento());
            }
        }
        return requestReporteMaestro;
    }

    public void tablaErrores(MsjRespOpGeneracionReporte response, MsjSolOpGeneracionReporte request) throws ConfiguracionException, Exception {

        String msg = "";
        if (request.getContextoSolicitud().getConsumidor() != null && request.getContextoSolicitud().getConsumidor().getCanal() != null) {
            msg = "Canal: " + request.getContextoSolicitud().getConsumidor().getCanal().getIdCanal() + "; ";
        }
        if (request.getValIdPlantilla() != null) {
            msg += "Plantilla: " + request.getValIdPlantilla() + "; ";
        }
        generacionDocumentosFacade = SCNComunesUtil.buscarEjb(configuracionServicio, ConstantesGeneracionDocumentos.GENERACION_DOCUMENTOS_PERSISTENCE_FACADE);
        ControlErrorDTO cedto = new ControlErrorDTO();
        if (response != null) {
            if (response.getContextoRespuesta() != null) {
                if (response.getContextoRespuesta().getError() != null) {
                    if (response.getContextoRespuesta().getError().getCodMsjRespuesta() != null) {
                        cedto.setCodigoError(Integer.parseInt(response.getContextoRespuesta().getError().getCodMsjRespuesta()));
                    }
                    if (response.getContextoRespuesta().getError().getValMsjRespuesta() != null) {
                        cedto.setMensajeError(msg + response.getContextoRespuesta().getError().getValMsjRespuestaBackend());
                    }
                }
            }

            cedto.setComponente("Servicio SrvScnGeneracioReportes-OpGeneracionReporte");

            java.util.Date fecha = new Date();
            cedto.setFechaCreacion(fecha);

            if (request.getIdProcesoDocumento() != null && !request.getIdProcesoDocumento().isEmpty() && isNumeric(request.getIdProcesoDocumento())) {
                cedto.setIdConsecutivo(Integer.parseInt(request.getIdProcesoDocumento()));
            }

            long startInsert = System.currentTimeMillis();
            this.logger.info("Se va a ejecutar insertarControlError");
            //Procedimiento encargado de guardar información sobre los errores
            generacionDocumentosFacade.insertarControlError(cedto);
            long endInsert = System.currentTimeMillis();
            logger.info("Duración de insetar Registro de Error en BD - inicio: " + startInsert + "ms" + " fin: " + endInsert + "ms" + " tiempo:" + (endInsert - startInsert) + "ms" + " IdTransacción:" + request.getContextoSolicitud().getOperacionCanal().getIdTransaccion());

        }

    }

    private List<String> validarParametros(SCNMensajeEntrada input) {
        List<String> result = new ArrayList<>();
        result.addAll(SCNComunesUtil.validarContextoSolicitud(input.getContextoSolicitud()));

        MsjSolOpGeneracionReporte request = (MsjSolOpGeneracionReporte) input;
        ReporteType reporteType = request.getReporte();
        ClienteType clienteType = request.getCliente();
        ProductoType productoType = request.getProducto();
        String tipoCertificacion = null;
        String valIdPlantilla = request.getValIdPlantilla();

        if (input.getContextoSolicitud() != null
                && input.getContextoSolicitud().getOperacionCanal() != null
                && input.getContextoSolicitud().getOperacionCanal().getCodIdioma() != null
                && input.getContextoSolicitud().getOperacionCanal().getCodIdioma() != null) {
            String idioma = input.getContextoSolicitud().getOperacionCanal().getCodIdioma();
            if (!idioma.equals(ConstantesGenerarReporte.IDIOMAS.EN.name())
                    && !idioma.equals(ConstantesGenerarReporte.IDIOMAS.ES.name())) {
                result.add("CodIdioma debe ser EN o ES");
            }
        }

        if (reporteType != null) {

            if (reporteType.getTipoCertificacion() == null || reporteType.getTipoCertificacion().isEmpty()) {
                result.add("TipoCertificacion");
            } else {
                tipoCertificacion = reporteType.getTipoCertificacion();
            }

            if (tipoCertificacion != null
                    && !tipoCertificacion.equals("CERTCARTERA_TODOS_ES")) {
                if (productoType != null) {

                    if (productoType.getCodigoTipoProducto() == null || productoType.getCodigoTipoProducto().isEmpty()) {
                        result.add("CodigoTipoProducto");
                    }
                    if (productoType.getNumeroProducto() == null || productoType.getNumeroProducto().isEmpty()) {
                        result.add("NumeroProducto");
                    }

                    if (productoType.getFechaApertura() != null) {
                        Date fechaActual = new Date();
                        int comparacion = fechaActual.compareTo(productoType.getFechaApertura());
                        if (comparacion == 0) {
                            result.add("Fecha de apertura del producto no debe ser igual a la fecha actual");
                        } else if (comparacion < 0) {
                            result.add("Fecha de apertura del producto no debe ser mayor a la fecha actual");
                        }
                    }
                } else {

                    result.add("productoType");
                }
            }

            if (clienteType != null) {

                if (clienteType.getNombres() == null || clienteType.getNombres().isEmpty()) {
                    result.add("Nombres");
                }

                if (!"03".equals(clienteType.getTipoIdentificacion()) && !"3".equals(clienteType.getTipoIdentificacion())) {
                    if (clienteType.getPrimerApellido() == null || clienteType.getPrimerApellido().isEmpty()) {
                        result.add("PrimerApellido");
                    }
                }

                if (clienteType.getNumeroIdentificacion() == null || clienteType.getNumeroIdentificacion().isEmpty()) {
                    result.add("NumeroIdentificacion");
                }

                String tipoIdReq = String.valueOf(Integer.valueOf(clienteType.getTipoIdentificacion()));
                String tipoIdHomologado = this.ca.getListaTiposIdentificacion().obtenerTipoIdentificacionCache(tipoIdReq);

                if (tipoIdHomologado == null || tipoIdHomologado.isEmpty()) {
                    result.add("TipoIdentificacion: " + tipoIdReq + " no encontrado");
                }
                request.getCliente().setTipoIdentificacion(String.valueOf(Integer.valueOf(clienteType.getTipoIdentificacion())));
            } else {

                result.add("clienteType");
            }
            this.esPlantilla = false;
        } else if (valIdPlantilla != null) {

            if ((request.isRequiereClave() || request.isRequiereClaveFileNet())
                    && request.getValClaveDocumento() == null) {
                result.add("valClaveDocumento");
            }

            if (request.isEnviarCopiaCorreo()
                    && request.getCliente().getValMail() == null) {
                this.logger.info("No se podra enviar el correo de este documento por que el canal no envio mail ");
            }

            this.esPlantilla = true;
        } else {

            result.add("reporte");
            result.add("valIdPlantilla");
        }
        return result;
    }

    public MsjRespOpGeneracionReporte armarRespuestaBien(byte[] mByte, boolean retornaDoc) {
        MsjRespOpGeneracionReporte response = new MsjRespOpGeneracionReporte();
        response.setContextoRespuesta(GenerarReporteComunesUtil.getContextoRespuestBien(this.contextoSolicitud));

        if (retornaDoc) {
            if (this.esPlantilla) {
                String s = DatatypeConverter.printBase64Binary(mByte);
                response.setValDocumentoGenerado(s);
                response.setValFormatoDocumentoGenerado(this.mime);
            } else {
                RespuestaCertificadoTipo rct = new RespuestaCertificadoTipo();
                rct.setContenido(mByte);
                rct.setMimeType("application/pdf");
                response.setRespuestaCertificado(rct);
            }
        }

        return response;
    }

    private Plantilla obtenerDocumentoPlantilla(ConfigAdicional ca, String nombrePlantilla, String versionPlantilla) throws GenerarReporteException {
        Plantilla plantillaResp = null;
        if (ca != null) {
            if (nombrePlantilla == null) {
                throw new GenerarReporteException("705", "Nombre de plantilla es null");
            }
            if (versionPlantilla == null) {
                throw new GenerarReporteException("706", "Version de plantilla es null");
            }
            plantillaResp = ca.getListaPlantillas().obtenerPlantillaCache(nombrePlantilla + "_" + versionPlantilla);
            //plantillaResp = ca.getListaPlantillas().obtenerPlantillaCache(nombrePlantilla);
            if (plantillaResp == null) {
                throw new GenerarReporteException("703", "Plantilla no configurada: <" + nombrePlantilla + "> - Version: " + versionPlantilla);
            }
        } else {
            throw new GenerarReporteException("999", "Configuracion Adicional es null");
        }
        return plantillaResp;
    }

    public MsjSolOpGeneracionReporte validarXML(MsjSolOpGeneracionReporte request) {

        if (request.getCliente() != null && request.getCliente().getNombres() != null) {
            request.getCliente().setNombres(escaparAmpersand(request.getCliente().getNombres()));
        }

        if (request.getReporte() != null && request.getReporte().getDirigidoA() != null) {
            request.getReporte().setDirigidoA(escaparAmpersand(request.getReporte().getDirigidoA()));
        }

        if (null != request.getListaParametros() && null != request.getListaParametros().getValParametro()) {
            for (Valor param : request.getListaParametros().getValParametro()) {
                for (int i = 0; i < param.getValor().size(); i++) {
                    param.getValor().set(i, escaparAmpersand(param.getValor().get(i)));
                }
            }
        }

        return request;
    }

    public String escaparAmpersand(String campo) {

        if (campo != null && campo.contains("&")) {
            String ampersand = "--amp--";
            String ampersandN = "--ampN--";
            campo = campo.replaceAll("&amp;amp;", ampersand);
            campo = campo.replaceAll("&amp;", ampersand);
            campo = campo.replaceAll("&amp;#", ampersandN);
            campo = campo.replaceAll("&#", ampersandN);
            campo = campo.replaceAll("&", ampersand);
            campo = campo.replaceAll(ampersandN, "&#");
            campo = campo.replaceAll(ampersand, "&amp;");
        }

        return campo;
    }

    @Override
    public void destroyCacheAlterno() {
        try {
            HelperCache.destroyObjectCache("SCN_" + nombreServicio, "ALTERNA");
            System.out.println("Se elimino cache alterno de " + nombreServicio);

        } catch (Exception ex) {
            System.out.println("Error eliminando la configuracion alterna de " + nombreServicio);
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void initCacheAlterno() {
        Boolean cargado;
        ConfigAdicional configAlterna;// = new ConfigAdicional();
        String nombreCache = "SCN_" + this.nombreServicio;

        try {

            try {
                configAlterna = (ConfigAdicional) HelperCache.getObjectCache(nombreCache, "ALTERNA");
                cargado = configAlterna != null;
            } catch (Exception e) {
                configAlterna = new ConfigAdicional();
                cargado = false;
            }

            if (!cargado) {

                String rutaConfigService = GenerarReporteComunesUtil.getUbicacionDirectorio(this.nombreServicio);
                File archivoConfiguracion = null;
                ContextoSolicitudTipo contextSol = GenerarReporteComunesUtil.getContextoSolicitudLogger();
                ContextoTransaccion contextoTx;
                contextoTx = getContextoTransaccion(configuracionServicio, contextSol, contextSol.getOperacionCanal().getIdSesion(), null);
                logger = new com.ibm.comunes.log.Logger(this.getClass().getName());
                logger.init(configuracionServicio.getParticular().getConfigLog(), contextoTx);
                logger.info("INICIO - initCacheAlterno " + nombreOperacion);

                archivoConfiguracion = new File(rutaConfigService + this.nombreServicio + "_scn_config.xml");

                if (archivoConfiguracion.exists()) {
                    configAlterna = (ConfigAdicional) (new XmlToDto()).getDto(configAlterna, archivoConfiguracion);
                } else {
                    throw new FileNotFoundException("NO SE ENCONTRO ARCHIVO DE CONFIGURACION DEL SERVICIO " + archivoConfiguracion.getAbsolutePath());
                }

                configAlterna.getListaCertificados().cargarMapCertificados();
                configAlterna.getListaPlantillas().cargarMapPlantillas(logger);
                this.logger.debug("Se cargan un total de: " + configAlterna.getListaPlantillas().getPlantilla().size());
                configAlterna.getListaTiposIdentificacion().cargarMapTipoIdentificacions();
                configAlterna.getListaCodigosProducto().cargarMapCodigoProductos();
                configAlterna.getListaUnidades().cargarMapUnidades();
                configAlterna.getListaHomologos().cargarMapHomologos();
                HelperCache.setObjectCache(nombreCache, "ALTERNA", configAlterna);
            }

        } catch (XmlToDtoException | FileNotFoundException | ConfiguracionException e) {
            if (logger != null && logger.isIniciado()) {
                logger.error("Error cargando cache alterna del servicio: " + e.getMessage(), e);
            } else {
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public String updateCacheAlterno() throws ConfiguracionException {
        String response = "OK";
        ConfigAdicional configAlterna = new ConfigAdicional();
        String rutaConfigServicio = System.getProperty("SCN.PATH.CONFIG") + nombreServicio + File.separatorChar + nombreServicio + "_scn_config.xml";
        String nombreCache = "SCN_" + this.nombreServicio;
        File archivoConfigFuncional = new File(rutaConfigServicio);
        if (archivoConfigFuncional.exists()) {
            try {
                configAlterna = (ConfigAdicional) new XmlToDto().getDto(configAlterna, archivoConfigFuncional);
                configAlterna.getListaCertificados().cargarMapCertificados();
                configAlterna.getListaPlantillas().cargarMapPlantillas(logger != null && logger.isIniciado() ? logger : null);
                configAlterna.getListaTiposIdentificacion().cargarMapTipoIdentificacions();
                configAlterna.getListaCodigosProducto().cargarMapCodigoProductos();
                configAlterna.getListaUnidades().cargarMapUnidades();
                configAlterna.getListaHomologos().cargarMapHomologos();
                HelperCache.setObjectCache(nombreCache, "ALTERNA", configAlterna);

            } catch (Exception ex) {
                response = "Error actualizando configuracion alterna de servicio mail " + ex.getMessage();
                if (logger != null) {
                    if (logger.isIniciado()) {
                        logger.error(response, ex);
                    } else {
                        ex.printStackTrace(System.out);
                    }
                } else {
                    ex.printStackTrace(System.out);
                }
                throw new ConfiguracionException(response);
            }
        } else {
            throw new ConfiguracionException("NO SE ENCONTRO ARCHIVO PARTICULAR DE CONFIGURACION DEL SERVICIO " + archivoConfigFuncional.getAbsolutePath());
        }

        return response;
    }
}
