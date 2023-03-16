package com.davivienda.generarReporte.util;

import com.davivienda.esquemas.framework.aplicaciontipo.v1.AplicacionTipo;
import com.davivienda.esquemas.framework.canaltipo.v1.CanalTipo;
import com.davivienda.esquemas.framework.consumidortipo.v1.ConsumidorTipo;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBContext;
import java.io.ByteArrayOutputStream;
import com.davivienda.generarReporte.servicios.RespuestaServicios;
import com.ibm.comunes.util.ConstantesTAC;
import java.text.SimpleDateFormat;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.GregorianCalendar;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.davivienda.generarReporte.exception.ErrorNoEsperadoException;
import com.ibm.cache.bo.particular.Parametro;
import com.ibm.comunes.log.Logger;
import com.ibm.cache.bo.general.MensajeError;
import com.ibm.comunes.utilitarios.SCNComunesUtil;
import com.davivienda.generarReporte.constantes.ConstantesGenerarReporte;
import com.davivienda.esquemas.framework.contextorespuestatipo.v1.ContextoRespuestaTipo;
import com.ibm.comunes.utilitarios.ExceptionCodErrorMapper;
import com.davivienda.esquemas.framework.contextosolicitudtipo.v1.ContextoSolicitudTipo;
import com.davivienda.esquemas.framework.operacioncanaltipo.v1.OperacionCanalTipo;
import com.davivienda.esquemas.framework.terminaltipo.v1.TerminalTipo;
import com.ibm.cache.bo.servicio.ConfiguracionServicio;
import com.ibm.comunes.util.ComunesUtil;

public class GenerarReporteComunesUtil {

    public GenerarReporteComunesUtil() {
        super();
    }

    public static ContextoRespuestaTipo getContextoRespuestaMal(final ConfiguracionServicio configuracionServicio, final ContextoSolicitudTipo contextoSolicitud, final Throwable e, final ExceptionCodErrorMapper codErrorMapper) {
        return SCNComunesUtil.getContextoRespuestaMal(ConstantesGenerarReporte.ID_FRENTE, codErrorMapper.obtenerCodigoErrorConfiguracion(), configuracionServicio, contextoSolicitud, codErrorMapper.obtenerCodigoError(e), new Object[]{null});
    }

    public static ContextoRespuestaTipo getContextoRespuestaMal(final ConfiguracionServicio configuracionServicio, final ContextoSolicitudTipo contextoSolicitud, final String codError, final Object... paramsMensaje) {
        return SCNComunesUtil.getContextoRespuestaMal(ConstantesGenerarReporte.ID_FRENTE, "999", configuracionServicio, contextoSolicitud, codError, paramsMensaje);
    }

    public static ContextoRespuestaTipo getContextoRespuestaMal(final String ErrorConfig, final ConfiguracionServicio configuracionServicio, final ContextoSolicitudTipo contextoSolicitud, final String codErrorExterno, final String mensajeExterno, final Object... paramsMensaje) {
        String codMensaje = ErrorConfig;
        String mensaje = "Error de configuración del servicio";
        String codMensajeBackend = "";
        String mensajeBackend = "";
        if (configuracionServicio != null) {
            final MensajeError mensajeError = configuracionServicio.getGeneral().getMensajesErrorPorCodigo(ConstantesGenerarReporte.ID_FRENTE, configuracionServicio.getParticular().getNombreServicio(), ErrorConfig);
            codMensaje = mensajeError.getCodMensaje();
            mensaje = mensajeError.getMensaje();
            if (codErrorExterno != null) {
                codMensajeBackend = codErrorExterno;
            } else {
                codMensajeBackend = mensajeError.getCodMensajeBackend();
            }
            if (mensajeExterno != null) {
                mensajeBackend = mensajeExterno;
            } else {
                mensajeBackend = mensajeError.getMensajeBackend();
            }
        }
        return SCNComunesUtil.getContextoRespuesta(contextoSolicitud, "M", codMensaje, mensaje, codMensajeBackend, mensajeBackend, paramsMensaje);
    }

    public static ContextoRespuestaTipo getContextoRespuestBien(final ContextoSolicitudTipo contextoSolicitud) {
        return SCNComunesUtil.getContextoRespuestaBien(contextoSolicitud);
    }

    public static String obtenerParametroConfig(final ConfiguracionServicio configuracionServicio, final Logger logger, final String param) throws ErrorNoEsperadoException {
        logger.debug("INICIO obtenerValorParametro:" + param);
        String valParam = "";
        if (configuracionServicio != null && configuracionServicio.getParticular().getParametrosAdicionales() != null) {
            for (int i = 0; i < configuracionServicio.getParticular().getParametrosAdicionales().getParametro().size(); ++i) {
                final Parametro parametro = configuracionServicio.getParticular().getParametrosAdicionales().getParametro().get(i);
                if (parametro.getNombre().equals(param)) {
                    valParam = parametro.getValor();
                    break;
                }
            }
        }
        if (valParam.equals("")) {
            logger.debug("ERROR obtenerValorParametro Parametro en blanco.");
            throw new ErrorNoEsperadoException("No se pudo obtener ningun parametro de configuracion con base al key: " + param);
        }
        logger.debug("SALIENDO obtenerValorParametro." + valParam);
        return valParam;
    }

    public static boolean validarFormatoNumero(final String strNum, final int longitudNumero) {
        if (strNum == null || strNum.trim().isEmpty()) {
            return false;
        }
        final String strPat = "[0-9]" + ((longitudNumero > 0) ? ("{" + String.valueOf(longitudNumero) + "," + String.valueOf(longitudNumero) + "}") : "*");
        final Pattern pat = Pattern.compile(strPat);
        final Matcher mat = pat.matcher(strNum);
        return mat.matches();
    }

    public static XMLGregorianCalendar obtenerXMLGregorianCalendar(Date fecha) {
        final GregorianCalendar gcal = new GregorianCalendar();
        if (fecha == null) {
            fecha = new Date();
        }
        gcal.setTime(fecha);
        XMLGregorianCalendar xgcal = null;
        try {
            xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (DatatypeConfigurationException ex) {
        }
        return xgcal;
    }

    public static String formatearFecha(final Date date) {
        final SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        final String strFecha = formateador.format((date == null) ? new Date() : date);
        return strFecha;
    }

    public static Date formatearFecha_yyyyMMdd(final String date, final Logger log) {
        final SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
        Date strFecha = null;
        try {
            strFecha = formateador.parse((date == null) ? "" : date);
        } catch (Exception e) {
            log.error("Error formateando fecha a yyyyMMdd: " + date, (Throwable) e);
        }
        return strFecha;
    }

    public static String getUbicacionDirectorio(final String nombreServicio) {
        final StringBuilder ubicacionDirectorio = new StringBuilder();
        ubicacionDirectorio.append(ConstantesTAC.PATH_CONFIG).append(nombreServicio).append(ConstantesTAC.SEPARADOR);
        return ubicacionDirectorio.toString();
    }

    public static ByteArrayOutputStream getXMLSource(final RespuestaServicios data) throws Exception {
        final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        try {
            final JAXBContext context = JAXBContext.newInstance(RespuestaServicios.class);
            final Marshaller m = context.createMarshaller();
            m.setProperty("jaxb.formatted.output", Boolean.TRUE);
            m.marshal(data, outStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return outStream;
    }

    public static void responseToMap(final Object obj, final Map map, final String key) {
        responseToMap(obj, map, key, "");
    }

    public static void responseToMap(final Object obj, final Map map, final String key, String tabs) {
        final String tab = "\t";
        tabs += tab;
        if (obj != null) {
            final Class clazz = obj.getClass();
            try {
                final Field[] fields = clazz.getDeclaredFields();
                final String puntoYcoma = ";";
                if (clazz.getName().startsWith("java.") || clazz.getName().startsWith("javax.") || clazz.getName().startsWith("org.")) {
                    if (clazz.getName().equals("java.util.ArrayList")) {
                        final Method[] mets = clazz.getMethods();
                        int index = 0;
                        int indexGet = 0;
                        for (final Method met : mets) {
                            if ("get".equals(met.getName())) {
                                indexGet = index;
                                System.out.println("Metodo get " + mets[indexGet].getName());
                            }
                            ++index;
                        }
                        final Method m1 = clazz.getDeclaredMethod("size", (Class[]) new Class[0]);
                        final Object sizeObj = m1.invoke(obj, new Object[0]);
                        if (sizeObj != null) {
                            final int size = (Integer) sizeObj;
                            if (size > 0) {
                                final Map<String, Object> mapArray = new HashMap<String, Object>();
                                for (int i = 0; i < size; ++i) {
                                    final Map<String, Object> mapElemento = new HashMap<String, Object>();
                                    final Object elementObj = mets[indexGet].invoke(obj, i);
                                    if (elementObj != null) {
                                        final Class clazz2 = elementObj.getClass();
                                        responseToMap(elementObj, mapElemento, "", tabs);
                                    }
                                    mapArray.put("elemento(" + i + ")", mapElemento);
                                }
                                if (key.charAt(0) == '_') {
                                    map.put(key.substring(1), mapArray);
                                } else {
                                    map.put(key, mapArray);
                                }
                            }
                        }
                    } else if (clazz.getName().equals("java.util.Date")) {
                        final Date fechaRecibida = (Date) obj;
                        final SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
                        final String strFecha = formateador.format(fechaRecibida);
                        if (key.charAt(0) == '_') {
                            map.put(key.substring(1), strFecha);
                        } else {
                            map.put(key, strFecha);
                        }
                    } else if (key.charAt(0) == '_') {
                        map.put(key.substring(1), obj.toString());
                    } else {
                        map.put(key, obj.toString());
                    }
                } else {
                    for (final Field f : fields) {
                        if (!f.isAccessible()) {
                            try {
                                final StringBuilder methodName = new StringBuilder();
                                methodName.append("get");
                                methodName.append(f.getName().substring(0, 1).toUpperCase());
                                methodName.append(f.getName().substring(1));
                                final Method k = clazz.getDeclaredMethod(methodName.toString(), (Class[]) new Class[0]);
                                final Object methodObj = k.invoke(obj, new Object[0]);
                                if (methodObj != null) {
                                    responseToMap(methodObj, map, key.concat("_" + f.getName()), tabs);
                                }
                            } catch (NoSuchMethodException e2) {
                                try {
                                    final StringBuilder methodName2 = new StringBuilder();
                                    methodName2.append("is");
                                    methodName2.append(f.getName().substring(0, 1).toUpperCase());
                                    methodName2.append(f.getName().substring(1));
                                    final Method l = clazz.getDeclaredMethod(methodName2.toString(), (Class[]) new Class[0]);
                                    final Object methodObj2 = l.invoke(obj, new Object[0]);
                                    if (methodObj2 != null) {
                                        responseToMap(methodObj2, map, key.concat("_" + f.getName()), tabs);
                                    }
                                } catch (NoSuchMethodException ex) {
                                }
                            }
                        } else if (f.get(obj) != null) {
                            responseToMap(f.get(obj), map, key.concat("_" + f.getName()), tabs);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("No se genera string del objeto " + clazz.getName() + " Mensaje: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static ContextoSolicitudTipo getContextoSolicitudLogger() {
        ContextoSolicitudTipo contextSol = new ContextoSolicitudTipo();
        contextSol.setConsumidor(new ConsumidorTipo());
        contextSol.getConsumidor().setCanal(new CanalTipo());
        contextSol.getConsumidor().getCanal().setIdCanal(Short.valueOf(ConstantesGenerarReporte.CONSTANTE_CTXSOLTIPO_IDCANAL));
        contextSol.getConsumidor().getCanal().setIdHost(ConstantesGenerarReporte.CONSTANTE_CTXSOLTIPO_IDHOST);
        contextSol.getConsumidor().setTerminal(new TerminalTipo());
        contextSol.getConsumidor().getTerminal().setValOrigenPeticion(ConstantesGenerarReporte.CONSTANTE_CTXSOLTIPO_ORIGENPETICCION);
        contextSol.getConsumidor().getTerminal().setCodUsuario(ConstantesGenerarReporte.CONSTANTE_CTXSOLTIPO_CODUSUARIO);
        contextSol.getConsumidor().getTerminal().setValPerfil(ConstantesGenerarReporte.CONSTANTE_CTXSOLTIPO_VALPERFIL);
        contextSol.getConsumidor().setAplicacion(new AplicacionTipo());
        contextSol.getConsumidor().getAplicacion().setIdAplicacion(ConstantesGenerarReporte.CONSTANTE_CTXSOLTIPO_IDAPLICACION);
        contextSol.setOperacionCanal(new OperacionCanalTipo());
        contextSol.getOperacionCanal().setIdTransaccion(ConstantesGenerarReporte.CONSTANTE_CTXSOLTIPO_IDTRANSACCION);
        contextSol.getOperacionCanal().setIdSesion(ComunesUtil.getIdProceso());
        contextSol.getOperacionCanal().setCodPais(ConstantesGenerarReporte.CONSTANTE_CTXSOLTIPO_CODPAIS);
        return contextSol;
    }

}
