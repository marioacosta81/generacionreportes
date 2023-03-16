package com.davivienda.generarReporte.reporte.config.wsServicios.impl;

import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.reporte.config.wsServicios.DataHeaderComunESB;
import com.davivienda.generarReporte.reporte.config.wsServicios.ItemNumeroProducto;
import com.davivienda.generarReporte.reporte.config.wsServicios.ListaHeadersESB;
import com.ibm.cache.bo.particular.EndPoint;
import com.ibm.cache.bo.particular.Parametro;
import com.ibm.cache.bo.particular.ParametrosSoapServicio;
import com.ibm.cache.bo.servicio.ConfiguracionServicio;
import com.ibm.cache.scn.config.HelperCache;
import com.ibm.comunes.log.Logger;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public abstract class ClienteServiciosAbstract {

    protected static final String EXT_WSDL = "?wsdl";
    private ConfiguracionServicio configuracionServicio;
    protected Logger logger;
    protected Service service;
    private static ListaHeadersESB listaHeadersESB;

    public ClienteServiciosAbstract(Logger logger) throws ErrorExternServiceException {
        try {
            this.logger = logger;
            this.configuracionServicio = HelperCache.getConfiguracionServicio(System.getProperty("SCN.NOM.SER.GENERAR.REPORTE"));
            this.obtenerListaHeadersESB();
        } catch (Exception var3) {
            throw new ErrorExternServiceException(var3.getMessage());
        }
    }

    private void obtenerListaHeadersESB() throws ErrorExternServiceException {
        try {
            String valParam = "";
            if (this.configuracionServicio != null && this.configuracionServicio.getParticular().getParametrosAdicionales() != null) {
                for (int i = 0; i < this.configuracionServicio.getParticular().getParametrosAdicionales().getParametro().size(); ++i) {
                    Parametro parametro = (Parametro) this.configuracionServicio.getParticular().getParametrosAdicionales().getParametro().get(i);
                    if (parametro.getNombre().equals("headersESB")) {
                        valParam = parametro.getValor();
                        break;
                    }
                }
            }

            if (valParam.equals("")) {
                throw new ErrorExternServiceException("No se pudo obtener ningun parametro de configuracion con base al key: headersESB");
            } else {
                JAXBContext context = JAXBContext.newInstance(ListaHeadersESB.class);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
                dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
                dbf.setExpandEntityReferences(false);
                DocumentBuilder db = dbf.newDocumentBuilder();
                InputSource is = new InputSource(new StringReader(valParam));
                Document document = db.parse(is);
                Unmarshaller um = context.createUnmarshaller();
                listaHeadersESB = (ListaHeadersESB) um.unmarshal(document);
            }
        } catch (ErrorExternServiceException var8) {
            throw new ErrorExternServiceException("45", "headersESB");
        } catch (IOException var9) {
            throw new ErrorExternServiceException("45", "headersESB");
        } catch (JAXBException var10) {
            throw new ErrorExternServiceException("45", "headersESB");
        } catch (ParserConfigurationException var11) {
            throw new ErrorExternServiceException("45", "headersESB");
        } catch (SAXException var12) {
            throw new ErrorExternServiceException("45", "headersESB");
        }
    }

    protected DataHeaderComunESB obtenerHeaderDelServicio(String strClienteSOAP) {
        this.logger.info("Inicio obtenerHeaderDelServicio {strClienteSOAP} " + strClienteSOAP);
        DataHeaderComunESB header = null;
        List<DataHeaderComunESB> listDataHeaders = listaHeadersESB.getListaHeaders();
        Iterator i$ = listDataHeaders.iterator();

        while (i$.hasNext()) {
            DataHeaderComunESB item = (DataHeaderComunESB) i$.next();
            if (item.getNombre().equals(strClienteSOAP)) {
                header = item;
                break;
            }
        }

        if (null != header) {
            this.logger.debug("Saliendo obtenerHeaderDelServicio:: " + header);
            return header;
        } else {
            this.logger.debug("Saliendo obtenerHeaderDelServicio:: null");
            return null;
        }
    }

    protected ParametrosSoapServicio obtenerServicioDelConfig(String strClienteSOAP) {
        this.logger.debug("Inicio obtenerServicioDelConfig {strClienteSOAP} " + strClienteSOAP);
        ParametrosSoapServicio pSoapSrv = this.configuracionServicio.getParticular().getParametrosSoapServicio(strClienteSOAP);
        this.logger.debug("Saliendo obtenerServicioDelConfig:: " + pSoapSrv);
        return pSoapSrv;
    }

    protected String obtenerParametroConfig(String param) throws ErrorExternServiceException {
        this.logger.debug("INICIO obtenerValorParametro:" + param);
        String valParam = "";
        if (this.configuracionServicio != null && this.configuracionServicio.getParticular().getParametrosAdicionales() != null) {
            for (int i = 0; i < this.configuracionServicio.getParticular().getParametrosAdicionales().getParametro().size(); ++i) {
                Parametro parametro = (Parametro) this.configuracionServicio.getParticular().getParametrosAdicionales().getParametro().get(i);
                if (parametro.getNombre().equals(param)) {
                    valParam = parametro.getValor();
                    break;
                }
            }
        }

        if (valParam.equals("")) {
            this.logger.debug("ERROR obtenerValorParametro Parametro en blanco.");
            throw new ErrorExternServiceException("No se pudo obtener ningun parametro de configuracion con base al key: " + param);
        } else {
            this.logger.debug("SALIENDO obtenerValorParametro." + valParam);
            return valParam;
        }
    }

    protected ItemNumeroProducto obtenerDatosNumProducto(String strProdDav) throws ErrorExternServiceException {
        try {
            ItemNumeroProducto item = null;
            String[] strMat = new String[]{"", "", ""};
            if (strProdDav != null && !strProdDav.isEmpty()) {
                if (strProdDav.length() < 16) {
                    strProdDav = this.rellenarCeros(strProdDav);
                } else if (strProdDav.length() > 16) {
                    this.truncarNumero(strProdDav);
                }

                strMat[0] = strProdDav.substring(4, 6);
                strMat[1] = strProdDav.substring(6, 15);
                strMat[2] = strProdDav.substring(15, 16);
                item = new ItemNumeroProducto(strMat[0], Integer.parseInt(strMat[1]), Short.parseShort(strMat[2]));
                return item;
            } else {
                return null;
            }
        } catch (NumberFormatException var4) {
            throw new ErrorExternServiceException("42", "Error formateando el numero de producto", var4);
        }
    }

    protected void verificarCanal(ParametrosSoapServicio pSoapSrv, short idCanal) throws ErrorExternServiceException {
        List<EndPoint> listEndPoint = pSoapSrv.getEndPointsPorCanal();
        if (listEndPoint == null) {
            throw new ErrorExternServiceException("999", "No se pudo obtener el WSDL del servicio del BUS.");
        } else {
            EndPoint mEndPoint = null;
            Iterator i$ = listEndPoint.iterator();

            while (i$.hasNext()) {
                EndPoint item = (EndPoint) i$.next();
                if (idCanal == Short.valueOf(item.getEndPoint().getCanal())) {
                    mEndPoint = item;
                    break;
                }
            }

            if (mEndPoint == null) {
                this.logger.debug("Endpoint no encontrado para el canal solicitado: " + idCanal);
                throw new ErrorExternServiceException("999", "El Canal para el consumo del servicio no corresponde.");
            } else {
                pSoapSrv.setEndpoint(mEndPoint.getEndPoint().getEndPointAddress());
            }
        }
    }

    private String rellenarCeros(String strProdDav) {
        String relleno = strProdDav;
        if (strProdDav == null) {
            relleno = "";
        }

        for (int var3 = 0; relleno.length() < 16; ++var3) {
            relleno = "0" + relleno;
        }

        return relleno;
    }

    private String truncarNumero(String strProdDav) {
        String truncamiento;
        if (strProdDav != null) {
            truncamiento = strProdDav.substring(strProdDav.length() - 16, strProdDav.length());
        } else {
            truncamiento = this.rellenarCeros(strProdDav);
        }

        return truncamiento;
    }
}
