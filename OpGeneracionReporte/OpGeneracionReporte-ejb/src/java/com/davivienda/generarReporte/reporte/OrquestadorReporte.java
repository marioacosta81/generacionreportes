package com.davivienda.generarReporte.reporte;

import com.davivienda.generarReporte.config.reporte.Certificado;
import com.davivienda.generarReporte.config.reporte.ConfigAdicional;
import com.davivienda.generarReporte.config.reporte.FabricaGenerarReporte;
import com.davivienda.generarReporte.config.reporte.IGeneradorReporte;
import com.davivienda.generarReporte.config.reporte.Plantilla;
import com.davivienda.generarReporte.constantes.ConstantesGenerarReporte;
import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.exception.GenerarReporteException;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.ProductoType;
import com.davivienda.generarReporte.servicios.InvocarServicios;
import com.davivienda.generarReporte.servicios.ProductoCartera;
import com.davivienda.generarReporte.servicios.RespuestaServicios;
import com.davivienda.generarReporte.util.GenerarReporteComunesUtil;
import com.ibm.cache.bo.servicio.ConfiguracionServicio;
import com.ibm.comunes.log.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrquestadorReporte {

    private static OrquestadorReporte instance;
    public static final String CERTCARTERA_ESTADO_PROD_PJ_ES = "CERTCARTERA_ESTADO_PROD_PJ_ES";
    public static final String CERTCARTERA_TODOS_PJ_ES = "CERTCARTERA_TODOS_PJ_ES";
    public static final String CERTCARTERA_INF_BASICANOROTATIVO_PJ_ES = "CERTCARTERA_INF_BASICANOROTATIVO_PJ_ES";
    public static final String CERTCARTERA_INF_BASICA_TC_PJ_ES = "CERTCARTERA_INF_BASICA_TC_PJ_ES";
    public static final String CERTCARTERA_INF_BASICAROTATIVO_PJ_ES = "CERTCARTERA_INF_BASICAROTATIVO_PJ_ES";
    public static final String CERTCARTERA_ESTADO_PROD_TC_PJ_ES = "CERTCARTERA_ESTADO_PROD_TC_PJ_ES";
    public static final String CERTCARTERA_ESTADO_PROD_HIPOTECARIO_PJ_ES = "CERTCARTERA_ESTADO_PROD_HIPOTECARIO_PJ_ES";

    public static OrquestadorReporte getInstance() {
        if (instance == null) {
            instance = new OrquestadorReporte();
        }
        return instance;
    }

    public byte[] crearReporte(MsjSolOpGeneracionReporte request, ConfiguracionServicio configuracionServicio, ConfigAdicional ca, Logger logger, Plantilla plantilla) throws GenerarReporteException, ErrorExternServiceException {
        byte[] mByte = null;
        byte[] mByteDinamico = null;

        String moneda = request.getContextoSolicitud().getOperacionCanal().getCodMoneda();
        String idioma = request.getContextoSolicitud().getOperacionCanal().getCodIdioma();

        if (null != plantilla) {
            String nomDocumento = request.getValIdPlantilla();
            IGeneradorReporte reportePDF = FabricaGenerarReporte.getInstance().getInstanciaReporte(nomDocumento, configuracionServicio, ca, logger);
            String sbFO = reportePDF.inicializar(plantilla);
            mByteDinamico = reportePDF.transformarDinamico(sbFO, null, request);
        } else {

            String nomReporte = request.getReporte().getTipoCertificacion();
            Certificado certificado = buscarCertificado(ca, nomReporte, moneda, request.getProducto());
            InvocarServicios invocarServicios = new InvocarServicios(logger, certificado.getServicios().getServicio(), configuracionServicio);
            RespuestaServicios respuestaServicios = invocarServicios.invocarServicios(request, configuracionServicio);
            if (null != request.getReporte()) {
                GenerarReporteComunesUtil.responseToMap(request.getReporte(), respuestaServicios.getMapRespuestaDinamico(), "Reporte");
            }
            if (null != request.getCliente()) {
                GenerarReporteComunesUtil.responseToMap(request.getCliente(), respuestaServicios.getMapRespuestaDinamico(), "Cliente");
            }
            if (null != request.getProducto()) {
                GenerarReporteComunesUtil.responseToMap(request.getProducto(), respuestaServicios.getMapRespuestaDinamico(), "Producto");
                String codProd = (String) respuestaServicios.getMapRespuestaDinamico().get(configuracionServicio.getParticular().getParametroAdicional("ETIQUETA_PRODUCTO").getValor());
                String codSubProd = (String) respuestaServicios.getMapRespuestaDinamico().get(configuracionServicio.getParticular().getParametroAdicional("ETIQUETA_SUBPRODUCTO").getValor());
                if (codProd != null && codSubProd != null) {

                    String codProdSubProd = codProd.concat("-").concat(codSubProd);
                    respuestaServicios.getMapRespuestaDinamico().put(configuracionServicio.getParticular().getParametroAdicional("ETIQUETA_PRODUCTOSUBPRODUCTO").getValor(), codProdSubProd);
                }
            }
            Date fechaActual = new Date();
            SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
            String strFecha = formateador.format(fechaActual);
            respuestaServicios.getMapRespuestaDinamico().put(configuracionServicio.getParticular().getParametroAdicional("ETIQUETA_FECHAACTUAL").getValor(), strFecha);
            String rutaConfig = configuracionServicio.getParticular().getValorParametroAdicional("RUTA_RECURSOS_PLANTILLAS_PDF");
            respuestaServicios.getMapRespuestaDinamico().put("RUTA_RECURSOS_PLANTILLAS_PDF", rutaConfig);
            logger.info("rutaConfig = " + rutaConfig);
            boolean existeError = respuestaServicios.getMapRespuestaDinamico().containsKey("Error");
            if (existeError) {
                throw new ErrorExternServiceException("42", (String) respuestaServicios
                        .getMapRespuestaDinamico().get("Error"));
            }

            Plantilla reporte = null;
            ProductoCartera productoCartera = null;
            if (nomReporte.equals("CERTCARTERA_ESTADO_PROD_ES") || nomReporte
                    .equals("CERTCARTERA_ESTADO_PROD_TC_ES") || nomReporte
                    .equals("CERTCARTERA_ESTADO_PROD_HIPOTECARIO_ES") || nomReporte
                    .equals("CERTCARTERA_INF_BASICANOROTATIVO_ES") || nomReporte
                    .equals("CERTCARTERA_INF_BASICAROTATIVO_ES") || nomReporte
                    .equals("CERTCARTERA_INF_BASICA_TC_ES") || nomReporte
                    .equals("CERTCARTERA_ESTADO_PROD_PJ_ES") || nomReporte
                    .equals("CERTCARTERA_ESTADO_PROD_TC_PJ_ES") || nomReporte
                    .equals("CERTCARTERA_ESTADO_PROD_HIPOTECARIO_PJ_ES") || nomReporte
                    .equals("CERTCARTERA_INF_BASICANOROTATIVO_PJ_ES") || nomReporte
                    .equals("CERTCARTERA_INF_BASICAROTATIVO_PJ_ES") || nomReporte
                    .equals("CERTCARTERA_INF_BASICA_TC_PJ_ES")) {

                productoCartera = buscarProductoCartera(respuestaServicios, request);
                if (productoCartera == null) {
                    throw new GenerarReporteException("712", "Numero de producto no concuerda con ningun producto de cartera del cliente");
                }
                String nombrePlantilla = null;
                if (productoCartera.getEstado() != null) {
                    logger.info("Producto tiene estado: " + productoCartera.getEstado());
                    if (productoCartera.getEstado().equalsIgnoreCase("Al dia")) {
                        nombrePlantilla = certificado.getNombrePlantillaAlDia();
                    } else {
                        nombrePlantilla = certificado.getNombrePlantillaEnMora();
                    }
                } else {
                    throw new GenerarReporteException("713", "Numero de producto no tiene estado de cartera");
                }

                IGeneradorReporte reportePDF = FabricaGenerarReporte.getInstance().getInstanciaReporte(nomReporte, configuracionServicio, ca, logger);
                reporte = obtenerReportePlantilla(ca, nombrePlantilla);
                String sbFO = reportePDF.inicializar(reporte);
                mByteDinamico = reportePDF.transformarDinamico(sbFO, respuestaServicios, request);
            } else if (nomReporte.equals("CERTCARTERA_TODOS_ES") || nomReporte.equals("CERTCARTERA_TODOS_PJ_ES")) {

                IGeneradorReporte reportePDF = FabricaGenerarReporte.getInstance().getInstanciaReporte(nomReporte, configuracionServicio, ca, logger);
                reporte = obtenerReportePlantilla(ca, certificado.getNombrePlantilla());
                String sbFO = reportePDF.inicializar(reporte);
                mByteDinamico = reportePDF.transformarDinamico(sbFO, respuestaServicios, request);
            } else {

                IGeneradorReporte reportePDF = FabricaGenerarReporte.getInstance().getInstanciaReporte(nomReporte, configuracionServicio, ca, logger);
                reporte = obtenerReportePlantilla(ca, certificado.getNombrePlantilla());
                String sbFO = reportePDF.inicializar(reporte);
                mByteDinamico = reportePDF.transformarDinamico(sbFO, respuestaServicios, request);
            }
        }

        return mByteDinamico;
    }

    private ProductoCartera buscarProductoCartera(RespuestaServicios respuestaServicios, MsjSolOpGeneracionReporte request) throws ErrorExternServiceException {
        ProductoCartera productoCartera = null;
        List<ProductoCartera> listaProdESB = respuestaServicios.getListProductosCartera();
        if (listaProdESB != null) {
            if (!listaProdESB.isEmpty()) {
                for (ProductoCartera prodESB : listaProdESB) {
                    String numProdReq = null;
                    String numProdBus = null;
                    try {
                        Long numlong = Long.valueOf(Long.parseLong(request.getProducto().getNumeroProducto()));
                        numProdReq = numlong.toString();
                        numProdBus = prodESB.getNumeroProducto().toString();
                    } catch (Exception e) {
                        numProdReq = request.getProducto().getNumeroProducto();
                        numProdBus = prodESB.getNumeroProducto().toString();
                    }
                    if (numProdBus.equals(numProdReq)) {
                        productoCartera = prodESB;
                    }
                }
            } else {
                throw new ErrorExternServiceException("42", "Lista de productos cartera esta vacia");
            }
        } else {
            throw new ErrorExternServiceException("42", "Lista de productos cartera es null");
        }

        return productoCartera;
    }

    private Plantilla obtenerReportePlantilla(ConfigAdicional ca, String nombrePlantilla) throws GenerarReporteException {
        Plantilla plantillaResp = null;
        if (ca != null) {
            if (nombrePlantilla == null) {
                throw new GenerarReporteException("705", "Nombre de plantilla es null");
            }
            plantillaResp = ca.getListaPlantillas().obtenerPlantillaCache(nombrePlantilla);
            if (plantillaResp == null) {
                throw new GenerarReporteException("703", "Plantilla no configurada: " + nombrePlantilla);
            }
        } else {
            throw new GenerarReporteException("999", "Configuracion Adicional es null");
        }
        return plantillaResp;
    }

    private Certificado buscarCertificado(ConfigAdicional ca, String nomReporte, String moneda, ProductoType producto) throws GenerarReporteException {
        Certificado certResp = null;
        if (ca != null) {
            if (nomReporte == null) {
                throw new GenerarReporteException("704", "Nombre de reporte es null");
            }
            certResp = ca.getListaCertificados().obtenerCertificadoCache(nomReporte);
            if (certResp == null) {
                throw new GenerarReporteException("702", "Reporte no soportado: " + nomReporte);
            }
        } else {
            throw new GenerarReporteException("999", "Configuracion Adicional es null");
        }
        if (certResp.getNombre().contains("CON_SALDO")
                && !moneda.equals(ConstantesGenerarReporte.MONEDAS.COP.name())
                && !moneda.equals(ConstantesGenerarReporte.MONEDAS.USD.name())) {
            throw new GenerarReporteException("706", "Tipo de moneda para generacion de reporte no corresponde." + moneda);
        }

        if (producto != null) {
            String productosAceptados = certResp.getCodigosProductoAceptados();
            if (!productosAceptados.contains("SIN_RESTRICCION")
                    && producto.getCodigoTipoProducto() != null) {
                String[] splitProd = productosAceptados.split(",");
                boolean siesta = false;
                for (String prodPermitido : splitProd) {
                    if (prodPermitido.trim().equals(producto.getCodigoTipoProducto())) {
                        siesta = true;
                    }
                }
                if (!siesta) {
                    throw new GenerarReporteException("707", "Cde producto no soportado para certificado, cod: " + producto.getCodigoTipoProducto());
                }
            }
        }

        return certResp;
    }
}
