package com.davivienda.generarReporte.servicios.representativos;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "DocumentosRepresentativosUnificada_HTTP_Service", targetNamespace = "http://www.davivienda.com/xml/DocumentosRepresentativosUnificada")
public class DocumentosRepresentativosUnificadaHTTPService
        extends Service {

    private static final URL DOCUMENTOSREPRESENTATIVOSUNIFICADAHTTPSERVICE_WSDL_LOCATION;
    private static final WebServiceException DOCUMENTOSREPRESENTATIVOSUNIFICADAHTTPSERVICE_EXCEPTION;
    private static final QName DOCUMENTOSREPRESENTATIVOSUNIFICADAHTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/DocumentosRepresentativosUnificada", "DocumentosRepresentativosUnificada_HTTP_Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = DocumentosRepresentativosUnificadaHTTPService.class.getResource("DocumentosRepresentativosUnificada.wsdl");
        } catch (Exception ex) {
            e = new WebServiceException(ex);
        }
        DOCUMENTOSREPRESENTATIVOSUNIFICADAHTTPSERVICE_WSDL_LOCATION = url;
        DOCUMENTOSREPRESENTATIVOSUNIFICADAHTTPSERVICE_EXCEPTION = e;
    }

    public DocumentosRepresentativosUnificadaHTTPService() {
        super(__getWsdlLocation(), DOCUMENTOSREPRESENTATIVOSUNIFICADAHTTPSERVICE_QNAME);
    }

    public DocumentosRepresentativosUnificadaHTTPService(WebServiceFeature... features) {
        super(__getWsdlLocation(), DOCUMENTOSREPRESENTATIVOSUNIFICADAHTTPSERVICE_QNAME, features);
    }

    public DocumentosRepresentativosUnificadaHTTPService(URL wsdlLocation) {
        super(wsdlLocation, DOCUMENTOSREPRESENTATIVOSUNIFICADAHTTPSERVICE_QNAME);
    }

    public DocumentosRepresentativosUnificadaHTTPService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DOCUMENTOSREPRESENTATIVOSUNIFICADAHTTPSERVICE_QNAME, features);
    }

    public DocumentosRepresentativosUnificadaHTTPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DocumentosRepresentativosUnificadaHTTPService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "DocumentosRepresentativosUnificadaSOAP_HTTP_Port")
    public DocumentosRepresentativosUnificadaPortType getDocumentosRepresentativosUnificadaSOAPHTTPPort() {
        return getPort(new QName("http://www.davivienda.com/xml/DocumentosRepresentativosUnificada", "DocumentosRepresentativosUnificadaSOAP_HTTP_Port"), DocumentosRepresentativosUnificadaPortType.class);
    }

    @WebEndpoint(name = "DocumentosRepresentativosUnificadaSOAP_HTTP_Port")
    public DocumentosRepresentativosUnificadaPortType getDocumentosRepresentativosUnificadaSOAPHTTPPort(WebServiceFeature... features) {
        return getPort(new QName("http://www.davivienda.com/xml/DocumentosRepresentativosUnificada", "DocumentosRepresentativosUnificadaSOAP_HTTP_Port"), DocumentosRepresentativosUnificadaPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DOCUMENTOSREPRESENTATIVOSUNIFICADAHTTPSERVICE_EXCEPTION != null) {
            throw DOCUMENTOSREPRESENTATIVOSUNIFICADAHTTPSERVICE_EXCEPTION;
        }
        return DOCUMENTOSREPRESENTATIVOSUNIFICADAHTTPSERVICE_WSDL_LOCATION;
    }
}
