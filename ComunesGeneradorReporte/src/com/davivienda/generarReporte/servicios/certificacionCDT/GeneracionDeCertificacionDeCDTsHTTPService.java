package com.davivienda.generarReporte.servicios.certificacionCDT;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "GeneracionDeCertificacionDeCDTs_HTTP_Service", targetNamespace = "http://www.davivienda.com/xml/GeneracionDeCertificacionDeCDTs")
public class GeneracionDeCertificacionDeCDTsHTTPService
        extends Service {

    private static final QName GENERACIONDECERTIFICACIONDECDTSHTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/GeneracionDeCertificacionDeCDTs", "GeneracionDeCertificacionDeCDTs_HTTP_Service");

    public GeneracionDeCertificacionDeCDTsHTTPService() {
        super(GeneracionDeCertificacionDeCDTsHTTPService.class.getResource("GeneracionDeCertificacionDeCDTs_1.wsdl"), GENERACIONDECERTIFICACIONDECDTSHTTPSERVICE_QNAME);
    }

    @WebEndpoint(name = "GeneracionDeCertificacionDeCDTs_HTTP_Port")
    public GeneracionDeCertificacionDeCDTsPortType getGeneracionDeCertificacionDeCDTsHTTPPort() {
        return getPort(new QName("http://www.davivienda.com/xml/GeneracionDeCertificacionDeCDTs", "GeneracionDeCertificacionDeCDTs_HTTP_Port"), GeneracionDeCertificacionDeCDTsPortType.class);
    }

    @WebEndpoint(name = "GeneracionDeCertificacionDeCDTs_HTTP_Port")
    public GeneracionDeCertificacionDeCDTsPortType getGeneracionDeCertificacionDeCDTsHTTPPort(WebServiceFeature... features) {
        return getPort(new QName("http://www.davivienda.com/xml/GeneracionDeCertificacionDeCDTs", "GeneracionDeCertificacionDeCDTs_HTTP_Port"), GeneracionDeCertificacionDeCDTsPortType.class, features);
    }
}
