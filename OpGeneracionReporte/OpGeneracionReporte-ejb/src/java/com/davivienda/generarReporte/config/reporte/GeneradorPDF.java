package com.davivienda.generarReporte.config.reporte;

import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.exception.GenerarReporteException;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.AdjuntoTipo;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.ParametroTabla;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Registro;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Valor;
import com.davivienda.generarReporte.servicios.InvocarServicios;
import com.davivienda.generarReporte.servicios.ProductoCartera;
import com.davivienda.generarReporte.servicios.RespuestaServicios;
import com.davivienda.generarReporte.util.FuncionesTransformacion;
import com.davivienda.generarReporte.util.GenerarReporteComunesUtil;
import com.ibm.cache.bo.servicio.ConfiguracionServicio;
import com.ibm.comunes.log.Logger;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.XMLConstants;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.pdf.PDFEncryptionParams;
import org.jnbis.UtilsWsq;

public class GeneradorPDF
        implements IGeneradorReporte {

    private static FopFactory fopFactory = null;
    private FOUserAgent foUserAgent = null;
    private final ConfiguracionServicio configuracionServicio;
    private final ConfigAdicional ca;
    private final String rutaPlantillas;
    private final Logger log;
    private static HashMap<String, String> mapCertificados = new HashMap<String, String>();
    private String mime = null;

    public GeneradorPDF(ConfiguracionServicio cs, ConfigAdicional cadicional, Logger logger) {
        this.log = logger;
        this.ca = cadicional;
        this.configuracionServicio = cs;
        this.rutaPlantillas = this.configuracionServicio.getParticular().getValorParametroAdicional("RUTA_PLANTILLAS");
        System.out.println("La ruta de acceso a las palntillas es = " + this.rutaPlantillas);
        this.log.debug("La ruta de acceso a las palntillas es =  " + this.rutaPlantillas);
        if (this.fopFactory == null) {
            this.fopFactory = FopFactory.newInstance((new File(this.rutaPlantillas + "fop.xconf")).toURI());
        }
    }

    @Override
    public String inicializar(Plantilla mReporte) throws GenerarReporteException {
        
        String plantilla = mapCertificados.get(mReporte.getPlantilla());
        
        if( plantilla  == null ) {
            try {
                byte[] file = Files.readAllBytes(Paths.get(this.rutaPlantillas + mReporte.getPlantilla()));
                String encoding = this.configuracionServicio.getParticular().getValorParametroAdicional("PARAM_ENCODIG_FILE");
                plantilla = new String(file, encoding);
                mapCertificados.put(mReporte.getPlantilla(), plantilla);
            } catch (IOException ex) {
                throw new GenerarReporteException("709", "Archivo FO no existe - Archivo imposible de leer.");
            }
        }
        
        return plantilla;
    }

    private String homologarNombreProducto(ProductoCartera producto) throws GenerarReporteException {
        String codProducto = "";
        String nombreProductoHomologado = null;
        if (producto.getCodigoProducto() != null) {
            codProducto = producto.getCodigoProducto().toString();
        }
        if (producto.getCodSubProducto() != null) {
            codProducto = codProducto + "-" + producto.getCodSubProducto();
        }
        nombreProductoHomologado = this.ca.getListaCodigosProducto().obtenerCodigoProductoCache(codProducto);
        if (nombreProductoHomologado != null && !nombreProductoHomologado.isEmpty()) {
            return nombreProductoHomologado;
        }
        if (producto.getCodigoProducto() != null) {
            codProducto = producto.getCodigoProducto().toString();
        }
        nombreProductoHomologado = this.ca.getListaCodigosProducto().obtenerCodigoProductoCache(codProducto);
        if (nombreProductoHomologado != null) {
            return nombreProductoHomologado;
        }
        throw new GenerarReporteException("711", "No se encuentra en la configuracion el producto enviado: " + producto.getCodigoProducto());
    }

    private String homologarDateFromString(String fecha) {
        String cadenaResult = null;

        if (fecha != null) {
            Date fechaFormateada = GenerarReporteComunesUtil.formatearFecha_yyyyMMdd(fecha, this.log);
            if (fechaFormateada != null) {
                cadenaResult = GenerarReporteComunesUtil.formatearFecha(fechaFormateada);
            } else {
                cadenaResult = "";
            }
        } else {
            cadenaResult = "";
        }

        return cadenaResult;
    }

    private String transformarSaldoPesos(String saldo) {
        String cadenaResult = null;

        long monto = Long.parseLong(saldo);
        Locale locale = new Locale("es", "CO");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        cadenaResult = nf.format(monto);

        return cadenaResult;
    }

    private String transformarEstadoProd(String estado) {
        String[] arrayCadena = estado.split(" ");
        if (arrayCadena.length > 1) {
            try {
                arrayCadena[2] = String.valueOf(Long.parseLong(arrayCadena[2]));
            } catch (Exception exception) {
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayCadena.length; i++) {
            sb.append(arrayCadena[i]);
            sb.append(" ");
        }

        return sb.toString().replaceAll("dia", "día");
  }

    @Override
    public byte[] transformarDinamico(String str, RespuestaServicios respuestaServicios, MsjSolOpGeneracionReporte request) throws GenerarReporteException {
        byte[] mByte = null;
        List<String> adjuntos = null;

        try {
            if (null != request.getReporte() && request.getReporte().getTipoCertificacion().equals("CERTCARTERA_TODOS_ES")) {

                if (respuestaServicios != null) {

                    List<ProductoCartera> listaProd = respuestaServicios.getListProductosCartera();
                    if (listaProd != null) {
                        if (!listaProd.isEmpty()) {
                            for (ProductoCartera prod : listaProd) {
                                prod.setNombreProducto(homologarNombreProducto(prod));
                                prod.setFechaInicial(homologarDateFromString(prod.getFechaInicial()));
                                prod.setFechaCancelacion(homologarDateFromString(prod.getFechaCancelacion()));
                                prod.setSaldo(transformarSaldoPesos(prod.getSaldo()));
                                prod.setEstado(transformarEstadoProd(prod.getEstado()));
                            }
                        } else {
                            throw new GenerarReporteException("714", "respuesta del esb con mapa y lista de productos esta vacia");
                        }
                    } else {
                        throw new GenerarReporteException("714", "respuesta del esb con mapa y lista de productos esta vacia");
                    }

                    respuestaServicios.setListProductosCartera(listaProd);

                    ByteArrayOutputStream streamSource = null;
                    try {
                        streamSource = GenerarReporteComunesUtil.getXMLSource(respuestaServicios);
                    } catch (Exception ex) {
                        throw new GenerarReporteException("Error haciendo parsing del objeto respuesta ESB", ex);
                    }
                    StreamSource source = new StreamSource(new ByteArrayInputStream(streamSource.toByteArray()));

                    if (null != respuestaServicios) {
                        str = reemplazarCampos(str, request, respuestaServicios.getMapRespuestaDinamico());
                    } else {
                        str = reemplazarCampos(str, request, null);
                    }

                    FOUserAgent foUserAgent = this.fopFactory.newFOUserAgent();
                    TransformerFactory factory = TransformerFactory.newInstance();
                    factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); 
                    factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
                    
                    Source src = new StreamSource(new StringReader(str));
                    Transformer transformer = factory.newTransformer(src);

                    ByteArrayOutputStream outByteArray = new ByteArrayOutputStream(100);

                    OutputStream out = new BufferedOutputStream(outByteArray);
                    Fop fop = this.fopFactory.newFop("application/pdf", foUserAgent, out);

                    Result res = new SAXResult(fop.getDefaultHandler());

                    transformer.transform(source, res);
                    out.close();
                    mByte = outByteArray.toByteArray();
                } else {
                    throw new GenerarReporteException("714", "respuesta del esb con mapa y lista de productos esta vacia");
                }
            } else {

                if (null != respuestaServicios) {
                    str = reemplazarCampos(str, request, respuestaServicios.getMapRespuestaDinamico());
                } else {
                    str = reemplazarCampos(str, request, null);
                }

                if (null != request.getListaParametros()) {
                    if (request.getListaParametros().getParametroTabla() != null) {
                        str = reemplazarCamposTablas(str, request);
                    }

                    if (request.getListaParametros().getAdjunto() != null) {
                        str = reemplazarCamposAdjuntos(str, request.getListaParametros().getAdjunto());
                    }
                }

                str = verificarDefault(str, request);

                if (this.mime == null) {
                    this.mime = this.configuracionServicio.getParticular().getValorParametroAdicional("MIME_TYPE");
                }

                this.foUserAgent = this.fopFactory.newFOUserAgent();

                TransformerFactory factory = TransformerFactory.newInstance();
                factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); 
                
                Transformer transformer = factory.newTransformer();

                ByteArrayOutputStream outByteArray = new ByteArrayOutputStream(100);

                if (request.isRequiereClave() != request.isRequiereClaveFileNet() || request.isRequiereClave()) {

                    OutputStream out = new BufferedOutputStream(outByteArray);
                    Fop fop = this.fopFactory.newFop(this.mime, this.foUserAgent, out);
                    Source src = new StreamSource(new StringReader(str));

                    Result res = new SAXResult(fop.getDefaultHandler());

                    transformer.transform(src, res);
                    out.close();

                    String pswd = request.getValClaveDocumento();
                    this.foUserAgent.getRendererOptions().put("encryption-params", new PDFEncryptionParams(pswd, pswd,
                            Boolean.parseBoolean(this.configuracionServicio.getParticular().getValorParametroAdicional("allowPrint")),
                            Boolean.parseBoolean(this.configuracionServicio.getParticular().getValorParametroAdicional("allowCopy")),
                            Boolean.parseBoolean(this.configuracionServicio.getParticular().getValorParametroAdicional("allowEdit")),
                            Boolean.parseBoolean(this.configuracionServicio.getParticular().getValorParametroAdicional("allowEditAnnotations")),
                            Boolean.parseBoolean(this.configuracionServicio.getParticular().getValorParametroAdicional("encryptMetadata"))));
                }

                OutputStream out = new BufferedOutputStream(outByteArray);
                Fop fop = this.fopFactory.newFop(this.mime, this.foUserAgent, out);
                Source src = new StreamSource(new StringReader(str));

                Result res = new SAXResult(fop.getDefaultHandler());

                transformer.transform(src, res);
                out.close();
                mByte = outByteArray.toByteArray();
                this.log.debug("Documento PDF generado ");
            }
        } catch (TransformerConfigurationException ex) {
            throw new GenerarReporteException("710", ex.getMessage());
        } catch (FOPException ex) {
            throw new GenerarReporteException("710", ex.getMessage());
        } catch (TransformerException ex) {
            throw new GenerarReporteException("710", ex.getMessage());
        } catch (IOException ex) {
            throw new GenerarReporteException("710", ex.getMessage());
        }

        return mByte;
    }

    private String reemplazarCampos(String cadenaOriginal, MsjSolOpGeneracionReporte request, Map mapaDinamico) throws GenerarReporteException {
        String cadenaResult = cadenaOriginal;

        if (null != request.getListaParametros()) {
            for (Valor param : request.getListaParametros().getValParametro()) {

                if (param.getId().equals("MIME_TYPE")) {
                    this.mime = param.getValor().get(0);
                    continue;
                }
                String cadena = "";
                while (!cadena.equals("{}")) {

                    cadena = obtenerCadenaProcesar(cadenaResult, param.getId(), true);
                    if (cadena == null) {
                        String error = "La plantilla contiene un parametro mal delimitado. Id proc doc:" + request.getIdProcesoDocumento() + ", Id plantilla: " + request.getValIdPlantilla();
                        throw new GenerarReporteException("710", error);
                    }

                    if (!cadena.equals("{}")) {
                        cadenaResult = cadenaResult.replace(cadena, procesarCadena(cadena, param, request.getContextoSolicitud().getOperacionCanal().getCodIdioma(), null, request, null));
                    }
                }
            }
        }

        if (null != mapaDinamico) {
            for (Iterator it = mapaDinamico.keySet().iterator(); it.hasNext();) {
                Object obj = it.next();
                String key = (String) obj;

                if (cadenaOriginal.indexOf(key) > 0) {

                    Object value = mapaDinamico.get(key);
                    String cadena = "";
                    while (!cadena.equals("{}")) {
                        cadena = obtenerCadenaProcesar(cadenaResult, key, false);
                        if (cadena == null) {
                            String error = "La plantilla contiene un parametro mal delimitado. Id proc doc:" + request.getIdProcesoDocumento() + ", Id plantilla: " + request.getValIdPlantilla();
                            throw new GenerarReporteException("710", error);
                        }
                        if (!cadena.equals("{}")) {
                            cadenaResult = cadenaResult.replace(cadena, procesarCadena(cadena, value, request.getContextoSolicitud().getOperacionCanal().getCodIdioma(), key, request, mapaDinamico));
                        }
                    }
                }
            }
        }

        return cadenaResult;
    }

    private String obtenerCadenaProcesar(String cadenaOrigen, String etiqueta, boolean igual) {
        String cadena;
        int posIni = -1;

        try {
            if (etiqueta.isEmpty()) {
                posIni = cadenaOrigen.indexOf("{" + etiqueta);
            } else if (igual) {
                posIni = cadenaOrigen.indexOf("{" + etiqueta + ",");
            } else {
                posIni = cadenaOrigen.indexOf("{" + etiqueta);
            }

            if (-1 != posIni) {
                int posFin = cadenaOrigen.indexOf("}", posIni);
                if ( posFin == -1 ) {
                    return null;
                }
                cadena = cadenaOrigen.substring(posIni, posFin + 1);
            } else {
                cadena = "{}";
            }
        } catch (Exception e) {
            cadena = "{}";
        }
        return cadena;
    }

    private String procesarCadena(String cadena, Object obj, String idioma, String key, MsjSolOpGeneracionReporte request, Map mapaDinamico) throws GenerarReporteException {
        if (cadena.equals("{}")) {
            return "";
        }
        Valor param = new Valor();
        if (cadena.contains(",")) {
            String[] str = cadena.split(",");         
            String etiqueta = str[0].substring(1);
            if (obj instanceof Valor) {
                param = (Valor) obj;
            } else if (obj instanceof String) {
                param.setId(key);
                param.getValor().add((String) obj);
            } else if (obj instanceof Map) {
                Map<String, Object> elementos = (Map<String, Object>) obj;
                String indice = etiqueta.substring(etiqueta.indexOf("(") + 1, etiqueta.indexOf(")"));

                String campo = etiqueta.substring(0, etiqueta.indexOf("("));
                campo = campo.substring(campo.lastIndexOf("_") + 1);
                param.setId(etiqueta);
                if (indice.contains("=")) {
                    String condicion, str1[] = indice.split("=");

                    if (null != (String) mapaDinamico.get(str1[1])) {
                        condicion = (String) mapaDinamico.get(str1[1]);
                    } else {
                        condicion = str1[1];
                    }
                    for (int i = 0; i < elementos.size(); i++) {
                        Map<String, Object> elemento = (Map<String, Object>) elementos.get("elemento(" + i + ")");
                        if (condicion.equals(elemento.get(str1[0]))
                                || Long.parseLong(condicion) == Long.parseLong((String) elemento.get(str1[0]))) {
                            param.getValor().add((String) elemento.get(campo));
                        }
                    }
                } else if (indice.contains("!")) {
                    if (indice.charAt(0) == '!') {
                        int pos = Integer.valueOf(indice.substring(1)).intValue();
                        for (int i = 0; i < elementos.size(); i++) {
                            Map<String, Object> elemento = (Map<String, Object>) elementos.get("elemento(" + i + ")");
                            if (i != pos) {
                                param.getValor().add((String) elemento.get(campo));
                            }
                        }
                    } else {
                        String condicion, str1[] = indice.split("!");

                        if (null != (String) mapaDinamico.get(str1[1])) {
                            condicion = (String) mapaDinamico.get(str1[1]);
                        } else {
                            condicion = str1[1];
                        }
                        for (int i = 0; i < elementos.size(); i++) {
                            Map<String, Object> elemento = (Map<String, Object>) elementos.get("elemento(" + i + ")");
                            if (condicion.equals(elemento.get(str1[0]))
                                    || Long.parseLong(condicion) == Long.parseLong((String) elemento.get(str1[0]))) {
                                param.getValor().add((String) elemento.get(campo));
                            }
                        }
                    }
                } else if (indice.length() > 0) {
                    param.getValor().add((String) ((Map) elementos.get("elemento(" + indice + ")")).get(campo));
                } else {
                    for (int i = 0; i < elementos.size(); i++) {
                        Map<String, Object> elemento = (Map<String, Object>) elementos.get("elemento(" + i + ")");
                        param.getValor().add((String) elemento.get(campo));
                    }
                }
            }
            
            if (str.length > 2 && str[2].length() > 0 ) {
                String funciones = str[2].substring(0, str[2].length() - 1);
                String valor = transformarFunciones(funciones, param, idioma, request, etiqueta);
                if (valor != null) {
                    return valor;
                }
            } 
            
            if (str.length > 1) {
                String porDefecto = str[1];
                if (porDefecto.equals("VACIO")) {
                    return "";
                }
                return porDefecto;
            }
        }

        return param.getValor().get(0);
    }

    private String transformarFunciones(String funciones, Valor param, String idioma, MsjSolOpGeneracionReporte request, String etiqueta) throws GenerarReporteException {
        if (param.getValor().size() > 0) {
            if (funciones.length() > 0) {
                FuncionesTransformacion funcT = new FuncionesTransformacion();
                this.log.info("etiqueta: " + etiqueta + ", funciones: " + funciones);
                String[] func = funciones.split("&");
                String resultado = "";

                resultado = param.getValor().get(0);
                for (int i = 1; i < Array.getLength(func); i++) {

                    String funcion = func[i].substring(0, func[i].indexOf("("));
                    if (funcion.equals("transformarDivisa")) {
                        try {
                            String[] divisa;
                            List<String> listService = new ArrayList<String>();
                            listService.add("clienteSOAPDivisas");
                            InvocarServicios iS = new InvocarServicios(this.log, listService, this.configuracionServicio);

                            if (((String) param.getValor().get(0)).indexOf(".") > 0) {
                                divisa = iS.consumirServicioDivisas(request, this.log, ((String) param.getValor().get(0)).substring(0, ((String) param.getValor().get(0)).indexOf(".")), idioma, this.configuracionServicio);
                            } else {
                                divisa = iS.consumirServicioDivisas(request, this.log, param.getValor().get(0), idioma, this.configuracionServicio);
                            }
                            resultado = divisa[1];
                        } catch (ErrorExternServiceException e) {
                            throw new GenerarReporteException("725", "Error invocando al servicio de Divisas");
                        }
                    } else {
                        String parametro = func[i].substring(func[i].indexOf("(") + 1, func[i].length() - 1);
                        resultado = funcT.transformar(resultado, parametro, funcion, param, idioma, this.ca, request, etiqueta);
                    }
                }
                return resultado;
            }
            return param.getValor().get(0);
        }

        return null;
    }

    private String verificarDefault(String cadenaOrigen, MsjSolOpGeneracionReporte request) throws GenerarReporteException {
        String cadenaResult = cadenaOrigen;

        while (cadenaResult.contains("{")) {
            String cadena = obtenerCadenaProcesar(cadenaResult, "", true);
            if (cadena == null) {
                this.log.warn("El texto resultante de la plantilla contiene un corchete sin cerrar. Id proc doc:" + request.getIdProcesoDocumento() + ", Id plantilla: " + request.getValIdPlantilla() );
                break;
            }
            
            if (cadena.contains(",")) {
                String[] str = cadena.split(",");
                if (str[1].isEmpty()) {
                    throw new GenerarReporteException("724", "Error Valor DEFAULT no Definido - Campo: " + str[0].substring(1));
                }
                if (str[1].equals("VACIO")) {
                    cadenaResult = cadenaResult.replace(cadena, "");
                    continue;
                }
                cadenaResult = cadenaResult.replace(cadena, str[1]);

                continue;
            }
            cadenaResult = cadenaResult.replace(cadena, "");
        }

        return cadenaResult;
    }

    private String reemplazarCamposAdjuntos(String cadenaOriginal, List<AdjuntoTipo> adjuntos) throws GenerarReporteException {
        String cadenaResult = cadenaOriginal;

        for (AdjuntoTipo adj : adjuntos) {
            
            if ((adj.getValNombre() == null || adj.getValNombre().isEmpty()) && 
                (adj.getValContenido() == null || adj.getValContenido().isEmpty()) && 
                    (adj.getValTipo() == null || adj.getValTipo().isEmpty())) {
		  continue;
            }
	  
            //Se elimina validación de vacío porque ventas ya envia vacío en el paquete CUENTA_PORTAL_FIRMA_NIC_PJ_OTP y les falla.
            //Si se quiere adicionar la validación de vació primero ventas debe corregir la invocación.
            //if (adj.getValNombre() == null || adj.getValNombre().isEmpty() || 
            //    adj.getValContenido() == null || adj.getValContenido().isEmpty() || 
            //    adj.getValTipo() == null || adj.getValTipo().isEmpty()) {
            if (adj.getValNombre() == null ||
                adj.getValContenido() == null ||
                adj.getValTipo() == null) {
                    throw new GenerarReporteException("706", "El adjunto debe tener valTipo, valContenido y valNombre, falta uno o mas de ellos");
            }
            
            String src = "data:image/extension;base64,";
            src = src.replace("extension", adj.getValTipo().toLowerCase());

            String str = adj.getValContenido();

            if (adj.getValTipo().equalsIgnoreCase("WSQ")) {
                UtilsWsq util = new UtilsWsq();
                try {
                    str = util.wsq2png(adj.getValContenido());
                } catch (Exception e) {
                    throw new GenerarReporteException("706","Error en el formato WSQ del adjunto, no se puede leer: " + e.getMessage());
                }
            }

            src = src.concat(str);
            cadenaResult = cadenaResult.replace("{" + adj.getValNombre() + "}", src);
        }

        return cadenaResult;
    }

    private String reemplazarCamposTablas(String cadenaOriginal, MsjSolOpGeneracionReporte request) throws GenerarReporteException {
        String cadenaResult = cadenaOriginal;

        for (ParametroTabla param : request.getListaParametros().getParametroTabla()) {
            if (param.getValIdTabla() != null && ! param.getValIdTabla().isEmpty()) {
                String cadenaRemplazo = obtenerCadenaProcesar(cadenaResult, param.getValIdTabla(), true);
                if (cadenaRemplazo == null) {
                        String error = "La plantilla contiene un parametro mal delimitado. Id proc doc:" + request.getIdProcesoDocumento() + ", Id plantilla: " + request.getValIdPlantilla();
                        throw new GenerarReporteException("710", error);
                    }
                if (!cadenaRemplazo.equals("{}")) {
                    cadenaRemplazo = cadenaRemplazo.replace("{", "").replace("}", "");
                    String[] params = cadenaRemplazo.split(",");
                    int cantParams = params.length;
                    String cadenaTabla = "<fo:table table-layout=\"fixed\" width=\"100%\" >";
                    for (int i = 0; i < param.getColumnas().getValNombreColumna().size(); i++) {
                        if (cantParams > (i + 1) && null != params[1 + i]) {
                            if (params[1 + i].contains("#")) {
                                cadenaTabla = cadenaTabla + "<fo:table-column column-width=\"" + params[1 + i].substring(0, params[1 + i].indexOf('#')) + "mm\"/>";
                            } else {
                                cadenaTabla = cadenaTabla + "<fo:table-column column-width=\"" + params[1 + i] + "mm\"/>";
                            }
                        } else {
                            cadenaTabla = cadenaTabla + "<fo:table-column/>";
                        }
                    }

                    cadenaTabla = cadenaTabla + "<fo:table-body><fo:table-row>";

                    int i = 0;
                    for (String columna : param.getColumnas().getValNombreColumna()) {
                        if (cantParams > i && null != params[1 + i] && params[1 + i].contains("#")) {
                            cadenaTabla = cadenaTabla + "<fo:table-cell><fo:block text-align=\"" + params[1 + i].substring(params[1 + i].indexOf("#") + 1) + "\"><fo:inline font-weight=\"bold\" text-decoration=\"underline\">" + columna + "</fo:inline></fo:block></fo:table-cell>";
                        } else {
                            cadenaTabla = cadenaTabla + "<fo:table-cell><fo:block text-align=\"center\"><fo:inline font-weight=\"bold\" text-decoration=\"underline\">" + columna + "</fo:inline></fo:block></fo:table-cell>";
                        }
                        i++;
                    }

                    cadenaTabla = cadenaTabla + "</fo:table-row>";

                    for (Registro reg : param.getRegistros().getRegistro()) {
                        cadenaTabla = cadenaTabla + "<fo:table-row>";

                        i = 0;
                        for (Valor regVal : reg.getValParametro()) {
                            cadenaTabla = cadenaTabla + "<fo:table-cell><fo:block";
                            if (cantParams > i && null != params[1 + i] && params[1 + i].contains("#")) {
                                cadenaTabla = cadenaTabla + " text-align=\"" + params[1 + i].substring(params[1 + i].indexOf("#") + 1) + "\"";
                            } else {
                                cadenaTabla = cadenaTabla + " text-align=\"center\"";
                            }
                            cadenaTabla = cadenaTabla + ">" + (String) regVal.getValor().get(0) + "</fo:block></fo:table-cell>";
                            i++;
                        }

                        cadenaTabla = cadenaTabla + "</fo:table-row>";
                    }

                    cadenaTabla = cadenaTabla + "</fo:table-body></fo:table>";
                    cadenaResult = cadenaResult.replace("{" + cadenaRemplazo + "}", cadenaTabla);
                }
            }
        }

        return cadenaResult;
    }

}
