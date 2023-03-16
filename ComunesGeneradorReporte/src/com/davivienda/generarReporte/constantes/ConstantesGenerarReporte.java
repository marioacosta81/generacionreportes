package com.davivienda.generarReporte.constantes;

public class ConstantesGenerarReporte {

    public static String ID_FRENTE = "GENERAR_REPORTE";

    /**
     * Constantes para objeto ContextoSolicitudTipo para logger
     */
    public static final String CONSTANTE_CTXSOLTIPO_IDCANAL = "0";
    public static final String CONSTANTE_CTXSOLTIPO_IDHOST = "16001";
    public static final String CONSTANTE_CTXSOLTIPO_ORIGENPETICCION = "127.0.0.1";
    public static final String CONSTANTE_CTXSOLTIPO_CODUSUARIO = "0";
    public static final String CONSTANTE_CTXSOLTIPO_VALPERFIL = "0";
    public static final String CONSTANTE_CTXSOLTIPO_IDAPLICACION = "1";
    public static final String CONSTANTE_CTXSOLTIPO_IDTRANSACCION = "0";
    public static final String CONSTANTE_CTXSOLTIPO_CODPAIS = "CO";

    /*
    public static final String NOMBRE_SERVICIO = "SCN.NOM.SER.GENERAR.REPORTE";


    public static final String PARAM_URL_WSDL = "";

    public static final String PARAM_TIMEOUT = "TIMEOUT_SRV";

    public static final String PARAM_ENCODIG_FILE = "PARAM_ENCODIG_FILE";

    public static final String PARAM_HEADERS_ESB = "headersESB";

    public static final String PARAM_HEADER_ID_TAREA_CTA_CTE = "idTarea_CtaCte";

    public static final String ERROR_SRV_ESB = "Error";*/
 /*
    public static final String NOMBRE_OPERACION_OP_GENERAR_REPORTE = "OpGeneracionReporte";
    public static final String MSG_ERROR_INVOCACION_SERV = "HA OCURRIDO UN ERROR DE COMUNICACIONES";
    public static final String RESP_ERROR_DESCMSG_VALIDATION = "Error en la validacion de la estructura (mensaje de entrada).";
    public static final String MSG_ERROR_PARAMETROS_REPORTE = "Ha ocurrido un error al obtener la parametrizacidel reporte";
    public static final String MSG_ERROR_CONVERSION_PARAMETROS = "Error al convertir una cadena a Numerico.";
    public static final String MSG_ERROR_CREACION_CLIENTESWS = "Error al crear el cliente del servicio.";
    public static final String MSG_ERROR_CONSUMO_CLIENTSWS = "Error al consumir el servicio del BUS";
    public static final String CODERROR_BUS = "20";
    public static final String CODERROR_CONEXION_DB = "21";
    public static final String CODERROR_TIMEOUT = "22";
    public static final String CODERROR_CLIENTES_BUS = "42";
    public static final String CODERROR_NO_CONTROLADO = "43";
    public static final String CODERROR_PARAMETROS_INSUFICIENTES = "44";
    public static final String CODERROR_CONVERSION_PARAMETROS = "45";
    public static final String CODERROR_CONFIGURACION = "999";
    public static final String EXCEPTION_PARAMETRO_NO_ENCONTRADO = "No se pudo obtener ningun parametro de configuracion con base al key: ";
    public static final String EXCEPTION_WSDL_NO_ENCONTRADO = "No se pudo obtener el WSDL del servicio del BUS.";
    public static final String EXCEPTION_CANAL_NO_CORRESPONDE = "El Canal para el consumo del servicio no corresponde.";
    public static final String EXCEPTION_ARCHIVO_FO = "Archivo FO no existe - Archivo imposible de leer.";
    public static final String NOMBRE_CLIENTWS_CONSULTAR_CERTIFICACION_CDT = "clienteSOAPCertifCDT";
    public static final String NOMBRE_CLIENTWS_CAFETERA_AGROPECUARIA = "clienteSOAPAgropecuaria";
    public static final String NOMBRE_CLIENTWS_CONSULTA_CARTERA = "clienteSOAPCartera";
    public static final String NOMBRE_CLIENTWS_DETALLE_TARJETA_CREDITO = "clienteSOAPDetalleTarjCredito";
    public static final String NOMBRE_CLIENTWS_CONSULTA_DIVISAS = "clienteSOAPDivisas";
    public static final String NOMBRE_CLIENTWS_CONSULTA_DABUENAVIDA = "clienteSOAPDabuenavida";
    public static final String NOMBRE_CLIENTWS_CONSULTA_FONDO_INVERS = "clienteSOAPFondoInvers";
    public static final String NOMBRE_CLIENTWS_CONSULTA_PRODUCT_NOCONSUMO = "clienteSOAPProdNoConsumo";
    public static final String NOMBRE_CLIENTWS_CONSULTA_SALDOS_AHORROS = "clienteSOAPSaldosAhorros";
    public static final String NOMBRE_CLIENTWS_CONSULTA_SALDOS_CRED_FECHA = "clienteSOAPSaldosCredFecha";
    public static final String NOMBRE_CLIENTWS_CONSULTA_DETALLE_HIPOTECARIO = "clienteSOAPConsultaHipotecario";
    public static final String NOMBRE_CLIENTWS_CONSULTA_SALDO_CTA_CTE = "clienteSOAPSaldosCtaCte";
    public static final String NOMBRE_CLIENTWS_CONSULTA_SALDO_CTA_CTE_ESB = "clienteSOAPSaldosCtaCteESB";
    public static final String NOMBRE_CLIENTWS_CONSULTA_SALDO_CORREDORES = "clienteSOAPSaldosCorredores";
    public static final String NOMBRE_ESB_SERV_CONSULTAR_CERTIFICACION_CDT = "GeneracionDeCertificacionDeCDTs";
    public static final String NOMBRE_ESB_SERV_CAFETERA_AGROPECUARIA = "ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria";
    public static final String NOMBRE_ESB_SERV_CONSULTA_CARTERA = "ConsultaCarteraService";
    public static final String NOMBRE_ESB_SERV_DETALLE_TARJETA_CREDITO = "ConsultaDetalleTarjetaCredito";
    public static final String NOMBRE_ESB_SERV_CONSULTA_DIVISAS = "ConsultaDeDivisas";
    public static final String NOMBRE_ESB_SERV_CONSULTA_DABUENAVIDA = "ConsultaSaldoTituloDabuenavida";
    public static final String NOMBRE_ESB_SERV_CONSULTA_FONDO_INVERS = "ConsultaFondosDeInversion";
    public static final String NOMBRE_ESB_SERV_CONSULTA_PRODUCT_NOCONSUMO = "ConsultaSaldosProductoNoConsumo";
    public static final String NOMBRE_ESB_SERV_CONSULTA_SALDOS_AHORROS = "ConsultaSaldosAhorros";
    public static final String NOMBRE_ESB_SERV_CONSULTA_SALDOS_CRED_FECHA = "ConsultaSaldosCredFechaCorte";
    public static final String NOMBRE_ESB_SERV_CONSULTA_DETALLE_HIPOTECARIO = "ConsultaDetalleCredHipotecarioLeasing";
    public static final String NOMBRE_ESB_SERV_CONSULTA_SALDOS_CTA_CTE = "ConsultarSaldoCuentaCorrienteII";
    public static final String NOMBRE_ESB_SERV_CONSULTA_SALDOS_CTA_CTE_ESB = "ConsultaSaldosCuentaCorrienteESB";
    public static final String NOMBRE_ESB_SERV_CONSULTA_SALDOS_REPRESNTATIVOS = "DocumentosRepresentativosUnificada";
    public static final String CERTCARTERA_ESTADO_PROD_ES = "CERTCARTERA_ESTADO_PROD_ES";
    public static final String CERTCARTERA_TODOS_ES = "CERTCARTERA_TODOS_ES";
    public static final String CERTCARTERA_INF_BASICANOROTATIVO_ES = "CERTCARTERA_INF_BASICANOROTATIVO_ES";
    public static final String CERTCARTERA_INF_BASICA_TC_ES = "CERTCARTERA_INF_BASICA_TC_ES";
    public static final String CERTCARTERA_INF_BASICAROTATIVO_ES = "CERTCARTERA_INF_BASICAROTATIVO_ES";
    public static final String CERTCARTERA_ESTADO_PROD_TC_ES = "CERTCARTERA_ESTADO_PROD_TC_ES";
    public static final String CERTCARTERA_ESTADO_PROD_HIPOTECARIO_ES = "CERTCARTERA_ESTADO_PROD_HIPOTECARIO_ES";
    public static final String AL_DIA = "Al dia";
    public static final String PREFIJO_CACHE = "SCN_";
    public static final String CACHE_ALTERNA = "ALTERNA";
    public static final String PATH_CONFIG = "PATH_CONFIG";
    public static final String RUTA_RECURSOS_PLANTILLAS_PDF = "RUTA_RECURSOS_PLANTILLAS_PDF";
    public static final String RUTA_PLANTILLAS = "RUTA_PLANTILLAS";
    public static final String CON_SALDO = "CON_SALDO";
    public static final String SIN_RESTRICCION = "SIN_RESTRICCION";
    public static final String MONEDA_DEFAULT = "MONEDA_DEFAULT";
    public static final String TIPO_IDENTIFICACION_DEFAULT = "TIPO_IDENTIFICACION_DEFAULT";
    public static final String MONEDA_IDIOMA = "{moneda_idioma}";
    public static final String MONEDA = "MONEDA";
    public static final String REEMP_EXT_DOLARES = "_{valorDolares}";
    public static final String URL_FILE_NET = "URL_FILE_NET";
    public static final String URL_NOTIFICACIONES_MAIL = "URL_NOTIFICACIONES_MAIL";
    public static final String CODERROR_SERVICIO_FILENET = "50";
    public static final String CODERROR_SERVICIO_NOTIFICACIONES = "52";
    public static final String EXT_CLIENTE_CLASS = "_clienteClass";
    public static final String PREFIX_MAP = "_mapPrefix";
    public static final String PREFIX_MAP_REPORTE = "Reporte";
    public static final String PREFIX_MAP_CLIENTE = "Cliente";
    public static final String PREFIX_MAP_PRODUCTO = "Producto";
    public static final String ETIQUETA_PRODUCTO = "ETIQUETA_PRODUCTO";
    public static final String ETIQUETA_PRODUCTOSUBPRODUCTO = "ETIQUETA_PRODUCTOSUBPRODUCTO";
    public static final String ETIQUETA_SUBPRODUCTO = "ETIQUETA_SUBPRODUCTO";
    public static final String ETIQUETA_FECHAACTUAL = "ETIQUETA_FECHAACTUAL";*/
    public enum MONEDAS {
        COP, USD;
    }

    public enum IDIOMAS {
        EN, ES;
    }
}
