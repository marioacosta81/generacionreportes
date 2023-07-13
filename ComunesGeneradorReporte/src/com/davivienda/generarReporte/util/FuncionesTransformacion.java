package com.davivienda.generarReporte.util;

import com.davivienda.generarReporte.config.reporte.CodigosProducto;
import com.davivienda.generarReporte.config.reporte.ConfigAdicional;
import com.davivienda.generarReporte.config.reporte.Homologos;
import com.davivienda.generarReporte.config.reporte.TiposIdentificacion;
import com.davivienda.generarReporte.config.reporte.Unidades;
import com.davivienda.generarReporte.exception.GenerarReporteException;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Valor;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.text.WordUtils;

public class FuncionesTransformacion {

    private static HashMap<String, Integer> funciones;

    public FuncionesTransformacion() {
        funciones = new HashMap();
        funciones.put("mayusculas", 1);
        funciones.put("minusculas", 2);
        funciones.put("titulo", 3);
        funciones.put("truncar", 4);
        funciones.put("concatenar", 5);
        funciones.put("imagen", 6);
        funciones.put("formatearFecha", 7);
        funciones.put("formatearNumero", 8);
        funciones.put("numeroALetra", 9);
        funciones.put("item", 10);
        funciones.put("homologar", 11);
        funciones.put("formatoUnidad", 12);
        funciones.put("obtenerAntiguedad", 13);
        funciones.put("rellenar", 14);
        funciones.put("formatearFechaV2", 15);
        funciones.put("formatearNumeroV2", 16);
        funciones.put("formatear4Digitos", 17);
        funciones.put("validarValorRequerido", 18);
        
    }

    private int obtenerPos(String funcion) {
        return (Integer) funciones.get(funcion);
    }

    public String transformar(String entrada, String parametro, String funcion, Valor param, String idioma, ConfigAdicional cadicional, MsjSolOpGeneracionReporte request, String etiqueta) throws GenerarReporteException {
        String[] p;
        boolean flag;
        String[] pn;
        switch (this.obtenerPos(funcion)) {
            case 1:
                return this.mayusculas(entrada);
            case 2:
                return this.minusculas(entrada);
            case 3:
                if (parametro.length() > 0) {
                    return this.titulo(entrada, Boolean.valueOf(parametro));
                }

                return this.titulo(entrada, false);
            case 4:
                if (parametro.contains("#")) {
                    p = parametro.split("#");
                    return this.truncar(entrada, Integer.valueOf(p[0]), Integer.valueOf(p[1]));
                }

                return this.truncar(entrada, Integer.valueOf(parametro), 0);
            case 5:
                return this.concatenar(entrada, param.getValor(), parametro, request, param, idioma, cadicional, etiqueta);
            case 6:
                if (parametro.contains("#")) {
                    p = parametro.split("#");
                    return this.imagen(entrada, Boolean.parseBoolean(p[0]), p[1], p[2]);
                }

                return this.imagen(entrada, false, "_", "_");
            case 7:
                return this.formatearFecha(entrada, parametro, idioma);
            case 8:
                if (parametro.contains("#")) {
                    p = parametro.split("#");
                    if (p.length >= 5) {
                        flag = Boolean.parseBoolean(p[4]);
                    } else {
                        flag = true;
                    }

                    return formatearNumero(entrada, Integer.valueOf(p[0]), Integer.valueOf(p[1]), p[2], Boolean.parseBoolean(p[3]), flag);
                }

                return formatearNumero(entrada, 0, 2, "", true, true);
            case 9:
                if (parametro.contains("#")) {
                    p = parametro.split("#");
                    return this.numeroALetra(entrada, Boolean.parseBoolean(p[0]), Boolean.parseBoolean(p[1]));
                }

                return this.numeroALetra(entrada, Boolean.parseBoolean(parametro), false);
            case 10:
                return this.item(param.getValor(), Integer.valueOf(parametro), etiqueta);
            case 11:
                return this.homologar(entrada, cadicional.getListaHomologos(), cadicional.getListaTiposIdentificacion(), parametro, cadicional.getListaCodigosProducto());
            case 12:
                if (parametro.contains("#")) {
                    p = parametro.split("#");
                    return this.formatoUnidad(param.getUnidad(), cadicional.getListaUnidades(), Boolean.parseBoolean(p[0]), p[1]);
                }

                return this.formatoUnidad(param.getUnidad(), cadicional.getListaUnidades(), false, "COP");
            case 13:
                return this.obtenerAntiguedad(entrada);
            case 14:
                p = parametro.split("#");
                if (p.length >= 3) {
                    flag = Boolean.parseBoolean(p[2]);
                } else {
                    flag = false;
                }

                return this.rellenar(entrada, Integer.valueOf(p[0]), p[1], flag);
            case 15:
                if (parametro.contains("#")) {
                    pn = parametro.split("#");
                    return formatearFechaV2(entrada, pn[0], idioma, pn[1]);
                }

                return formatearFechaV2(entrada, parametro, idioma, "");
            case 16:
                if (parametro.contains("#")) {
                    pn = parametro.split("#");
                    boolean flag2;
                    if (pn.length >= 5) {
                        flag2 = Boolean.parseBoolean(pn[4]);
                    } else {
                        flag2 = true;
                    }

                    return formatearNumerov2(entrada, Integer.valueOf(pn[0]), Integer.valueOf(pn[1]), pn[2], Boolean.parseBoolean(pn[3]), flag2);
                }

                return formatearNumerov2(entrada, 0, 2, "", true, true);
            case 17: //&formatear4Digitos
                return this.formatear4Digitos(entrada);
            
            case 18: 
                this.validarValorRequerido(entrada);
                break;
            default:
        }
        return entrada;
    }

    private String mayusculas(String palabra) throws GenerarReporteException {
        try {
            return palabra.toUpperCase();
        } catch (Exception var3) {
            throw new GenerarReporteException("711", "No fue posible convertir palabra a mayusculas: " + palabra);
        }
    }

    private String minusculas(String palabra) throws GenerarReporteException {
        try {
            return palabra.toLowerCase();
        } catch (Exception var3) {
            throw new GenerarReporteException("712", "No fue posible convertir palabra a minusculas: " + palabra);
        }
    }

    private String titulo(String palabra, boolean flagSoloPrimera) throws GenerarReporteException {
        try {
            return flagSoloPrimera ? Character.toUpperCase(palabra.charAt(0)) + palabra.substring(1) : WordUtils.capitalize(palabra.toLowerCase());
        } catch (Exception var4) {
            throw new GenerarReporteException("713", "No fue posible convertir palabra a titulo: " + palabra);
        }
    }

    private String truncar(String palabra, int cantidad, int pos) throws GenerarReporteException {
        try {
            if (palabra.length() > cantidad) {
                return pos == 0 ? palabra.substring(0, cantidad) : palabra.substring(palabra.length() - cantidad);
            } else {
                return palabra;
            }
        } catch (Exception var5) {
            throw new GenerarReporteException("714", "No fue posible truncar palabra: " + palabra);
        }
    }

    private String concatenar(String entrada, List<String> palabras, String union, MsjSolOpGeneracionReporte request, Valor param, String idioma, ConfigAdicional ca, String etiqueta) throws GenerarReporteException {
        try {
            String palabra = "";
            String campo;
            if (union.contains("PALABRA")) {
                campo = union.substring("PALABRA".length());
                if (campo.equals("COMA")) {
                    campo = ", ";
                } else if (campo.equals("VACIO")) {
                    campo = "&#160;";
                }

                palabra = entrada.concat(campo);
            } else {
                Iterator i$;
                if (union.contains("ENLAZAR_")) {
                    palabra = entrada;
                    campo = union.substring("ENLAZAR_".length());
                    i$ = request.getListaParametros().getValParametro().iterator();

                    while (i$.hasNext()) {
                        Valor val = (Valor) i$.next();
                        if (val.getId().equals(campo) && !val.getValor().isEmpty() && !((String) val.getValor().get(0)).isEmpty()) {
                            palabra = palabra.concat(" ").concat((String) val.getValor().get(0));
                        }
                    }
                } else {
                    String pal;
                    if (union.contains("FUNCION_")) {
                        campo = union.substring("FUNCION_".length());
                        String funcion = campo.substring(0, campo.indexOf("("));
                        pal = campo.substring(campo.indexOf("(") + 1, campo.length() - 1);
                        palabra = entrada.concat(" ").concat(this.transformar((String) palabras.get(0), pal, funcion, param, idioma, ca, request, etiqueta));
                    } else {
                        if (union.equals("SL")) {
                            palabra = "<fo:block> ";
                        }

                        int i = 0;

                        for (i$ = palabras.iterator(); i$.hasNext(); ++i) {
                            pal = (String) i$.next();
                            if (!pal.isEmpty()) {
                                palabra = palabra.concat(pal);
                                if (!pal.equals(palabras.get(palabras.size() - 1)) && this.quedanPalabras(palabras, i)) {
                                    if (union.equals("SL")) {
                                        palabra = palabra.concat("</fo:block><fo:block> ");
                                    } else if (union.equals("COMA")) {
                                        palabra = palabra.concat(", ");
                                    } else {
                                        palabra = palabra.concat(union);
                                    }
                                }else {
                                    if (union.equals("COMA")){
                                       palabra = palabra.concat(", "); 
                                    }
                                }
                            }
                        }

                        if (union.equals("SL")) {
                            palabra = palabra.concat("</fo:block>");
                        }
                    }
                }
            }

            return palabra;
        } catch (Exception var13) {
            throw new GenerarReporteException("715", "No fue posible concatenar lista con union: " + union);
        }
    }

    private boolean quedanPalabras(List<String> palabras, int indice) {
        boolean result = false;
        int i = 0;

        for (Iterator i$ = palabras.iterator(); i$.hasNext(); ++i) {
            String pal = (String) i$.next();
            if (i > indice && !pal.isEmpty()) {
                result = true;
            }
        }

        return result;
    }

    private String imagen(String palabra, boolean flagCheck, String imagSi, String imagNo) throws GenerarReporteException {
        try {
            if (flagCheck) {
                if (palabra.length() > 0) {
                    return imagSi.equals("X") ? "X" : "<fo:external-graphic vertical-align=\"middle\" src=\"resources/" + imagSi + ".png\" content-height=\"scale-to-fit\" content-width=\"scale-to-fit\" scaling=\"uniform\"/>";
                } else {
                    return imagSi.equals("X") ? "&#160;" : "<fo:external-graphic vertical-align=\"middle\" src=\"resources/" + imagNo + ".png\" content-height=\"scale-to-fit\" content-width=\"scale-to-fit\" scaling=\"uniform\"/>";
                }
            } else {
                return "<fo:external-graphic vertical-align=\"middle\" src=\"resources/" + palabra + ".png\" content-height=\"scale-to-fit\" content-width=\"scale-to-fit\" scaling=\"uniform\"/>";
            }
        } catch (Exception var6) {
            throw new GenerarReporteException("716", "No fue posible cargar la imagen: " + palabra);
        }
    }

    private String formatearFecha(String palabra, String formato, String idioma) throws GenerarReporteException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");
        Locale loc = new Locale(idioma);

        try {
            Date date = dt.parse(palabra);
            SimpleDateFormat dt1 = new SimpleDateFormat(formato, loc);
            return dt1.format(date);
        } catch (ParseException var8) {
            throw new GenerarReporteException("717", "No fue posible formatear la Fecha: " + palabra + " - " + var8.getMessage());
        }
    }

    public static String formatearFechaV2(String palabra, String formato, String idioma, String formatoOrigen) throws GenerarReporteException {
        if ("".equals(formatoOrigen)) {
            formatoOrigen = "yyyyMMdd";
        }

        SimpleDateFormat dt = new SimpleDateFormat(formatoOrigen);
        Locale loc = new Locale(idioma);

        try {
            Date date = dt.parse(palabra);
            SimpleDateFormat dt1 = new SimpleDateFormat(formato, loc);
            return dt1.format(date);
        } catch (Exception var10) {
            formatoOrigen = "yyyyMMdd";
            dt = new SimpleDateFormat(formatoOrigen);
            loc = new Locale(idioma);

            try {
                Date date = dt.parse(palabra);
                SimpleDateFormat dt1 = new SimpleDateFormat(formato, loc);
                return dt1.format(date);
            } catch (Exception var9) {
                throw new GenerarReporteException("717", "No fue posible formatear la Fecha: " + palabra + " - " + var9.getMessage());
            }
        }
    }

    public static String formatearNumero(String palabra, int enteros, int decimales, String signoMoneda, boolean separadorMiles, boolean posicionSignoMoneda) throws GenerarReporteException {
        try {
            String formato = "";
            int i;
            if (decimales > 0) {
                for (i = 0; i < decimales; ++i) {
                    formato = formato.concat("0");
                }

                formato = formato.concat(".");
            }

            if (enteros > 0) {
                for (i = 1; i <= enteros; ++i) {
                    if (i == 1) {
                        formato = formato.concat("0");
                    } else {
                        formato = formato.concat("#");
                    }

                    if (i > 1 && i % 3 == 0 && separadorMiles) {
                        formato = formato.concat(",");
                    }
                }
            } else if (separadorMiles) {
                formato = formato.concat("0##,###,###,###,###,###");
            } else {
                formato = formato.concat("0#################");
            }

            StringBuilder str = new StringBuilder(formato);
            formato = str.reverse().toString();
            if (!signoMoneda.equals("N/A")) {
                if (posicionSignoMoneda) {
                    formato = signoMoneda.concat(formato);
                } else {
                    formato = formato.concat(signoMoneda);
                }
            }

            DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
            otherSymbols.setDecimalSeparator('.');
            otherSymbols.setGroupingSeparator(',');
            DecimalFormat myFormatter = new DecimalFormat(formato, otherSymbols);
            String numero = myFormatter.format(Double.parseDouble(palabra));
            return numero;
        } catch (NumberFormatException var11) {
            throw new GenerarReporteException("718", "No fue posible formatear el Numero: " + palabra + " - " + var11.getMessage());
        }
    }

    public static String formatearNumerov2(String palabra, int enteros, int decimales, String signoMoneda, boolean separadorMiles, boolean posicionSignoMoneda) throws GenerarReporteException {
        try {
            String formato = "";
            int i;
            if (decimales > 0) {
                for (i = 0; i < decimales; ++i) {
                    formato = formato.concat("0");
                }

                formato = formato.concat(".");
            }

            if (decimales > 0) {
                i = palabra.length();
                int nroEnterosReales = i - decimales;
                if (nroEnterosReales > 0) {
                    palabra = palabra.substring(0, nroEnterosReales).concat(".").concat(palabra.substring(nroEnterosReales));
                } else {
                    palabra = "0." + palabra;
                }
            }

            if (enteros > 0) {
                for (i = 1; i <= enteros; ++i) {
                    if (i == 1) {
                        formato = formato.concat("0");
                    } else {
                        formato = formato.concat("#");
                    }

                    if (i > 1 && i % 3 == 0 && separadorMiles) {
                        formato = formato.concat(",");
                    }
                }
            } else if (separadorMiles) {
                formato = formato.concat("0##,###,###,###,###,###");
            } else {
                formato = formato.concat("0#################");
            }

            StringBuilder str = new StringBuilder(formato);
            formato = str.reverse().toString();
            if (!signoMoneda.equals("N/A")) {
                if (posicionSignoMoneda) {
                    formato = signoMoneda.concat(formato);
                } else {
                    formato = formato.concat(signoMoneda);
                }
            }

            DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
            otherSymbols.setDecimalSeparator('.');
            otherSymbols.setGroupingSeparator(',');
            DecimalFormat myFormatter = new DecimalFormat(formato, otherSymbols);
            String numero = myFormatter.format(Double.parseDouble(palabra));
            return numero;
        } catch (NumberFormatException var11) {
            throw new GenerarReporteException("718", "No fue posible formatear el Numero: " + palabra + " - " + var11.getMessage());
        }
    }

    private String numeroALetra(String palabra, boolean flagFemenino, boolean flagPorcentaje) throws GenerarReporteException {
        try {
            N2T parteEntera;
            if (palabra.contains(".")) {
                String[] numeros = palabra.replace(".", ",").split(",");
                parteEntera = new N2T(Long.valueOf(numeros[0]), flagFemenino, numeros[0], flagPorcentaje);
                if (numeros[1] != null) {
                    N2T parteDecimal = new N2T(Long.valueOf(numeros[1]), flagFemenino, numeros[1], flagPorcentaje);
                    return flagPorcentaje ? parteEntera.convertirLetras().concat(" punto ").concat(parteDecimal.convertirLetras()) : parteEntera.convertirLetras().concat(" con ").concat(parteDecimal.convertirLetras()).concat(parteDecimal.unidadDecimal());
                } else {
                    return parteEntera.convertirLetras();
                }
            } else {
                parteEntera = new N2T(Long.valueOf(palabra), flagFemenino, palabra, flagPorcentaje);
                return parteEntera.convertirLetras();
            }
        } catch (NumberFormatException var7) {
            throw new GenerarReporteException("719", "No fue posible transformar numero a letra: " + palabra + " - " + var7.getMessage());
        }
    }

    private String item(List<String> palabras, int index, String etiqueta) throws GenerarReporteException {
        try {
            return (String) palabras.get(index - 1);
        } catch (Exception var5) {
            throw new GenerarReporteException("720", "Indice (" + index + ") invalido en Etiqueta " + etiqueta);
        }
    }

    private String homologar(String palabra, Homologos lista, TiposIdentificacion tipoIdentificacion, String parametro, CodigosProducto listaCodProd) throws GenerarReporteException {
        try {
            if (null != parametro) {
                if (parametro.equals("tipoIdentificacion")) {
                    return tipoIdentificacion.obtenerTipoIdentificacionCache(palabra);
                }

                if (parametro.equals("codigoProducto")) {
                    return listaCodProd.obtenerCodigoProductoCache(palabra);
                }
            }

            return lista.obtenerHomologosCache(palabra).getHomologo();
        } catch (Exception var7) {
            throw new GenerarReporteException("721", "Parametro a Homologar Invalido: " + palabra);
        }
    }

    private String formatoUnidad(String palabra, Unidades lista, boolean flagId, String porDefecto) throws GenerarReporteException {
        String id;
        if (palabra != null) {
            id = palabra;
        } else {
            id = porDefecto;
        }

        try {
            return flagId ? lista.obtenerUnidadesCache(id).getId() : lista.obtenerUnidadesCache(id).getDescripcion();
        } catch (Exception var7) {
            throw new GenerarReporteException("722", "Unidad Invalida: " + id);
        }
    }

    private String obtenerAntiguedad(String palabra) throws GenerarReporteException {
        try {
            SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");
            Date fechaInicio = dt.parse(palabra);
            Date fechaFin = new Date();
            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(fechaInicio);
            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(fechaFin);
            int startMes = startCalendar.get(1) * 12 + startCalendar.get(2);
            int endMes = endCalendar.get(1) * 12 + endCalendar.get(2);
            int diffMonth = endMes - startMes;
            return String.valueOf(diffMonth);
        } catch (ParseException var10) {
            throw new GenerarReporteException("723", "Error calculando meses de antiguedad");
        }
    }

    private String rellenar(String palabra, int longitud, String relleno, boolean condicionado) {
        if (condicionado && palabra.length() > 0) {
            relleno = "VACIO";
        }

        if (palabra.length() < longitud) {
            int dif = longitud - palabra.length();
            String salida = palabra;

            for (int i = 0; i < dif / 2; ++i) {
                if (relleno.equals("VACIO")) {
                    salida = salida.concat("&#160;").concat(" ");
                } else {
                    salida = salida.concat(String.valueOf(relleno.charAt(0))).concat(" ");
                }
            }

            return salida;
        } else {
            return palabra;
        }
    }
    
    private String formatear4Digitos(String cadena) {
        try {
            if (cadena != null && !cadena.isEmpty() && cadena.length() >=4) {

                switch (cadena.length()) {
                    case 4:
                        return "0,".concat(cadena.substring(0, 2));
                    case 5:
                        return cadena.substring(0, 1).concat(",").concat(cadena.substring(1, 3));
                    case 6:
                        return cadena.substring(0, 2).concat(",").concat(cadena.substring(2, 4));
                    default:
                        return cadena.substring(0, 2).concat(",").concat(cadena.substring(2, 4));
                }
            }
        } catch (Exception e) {

        }
        return cadena;
    }
    
    private void validarValorRequerido(String entrada) throws GenerarReporteException {
        if(null == entrada || entrada.isEmpty()  ){
            throw new GenerarReporteException("724", "El valor de entrada es requerido");
        }
    }
}
