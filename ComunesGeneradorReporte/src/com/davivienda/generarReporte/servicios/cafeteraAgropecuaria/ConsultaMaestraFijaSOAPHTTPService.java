package com.davivienda.generarReporte.servicios.cafeteraAgropecuaria;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "ConsultaMaestraFijaSOAP_HTTP_Service", targetNamespace = "http://www.davivienda.com/xml/ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria", wsdlLocation = "WEB-INF/wsdl/ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria.wsdl")
public class ConsultaMaestraFijaSOAPHTTPService
        extends Service {

    private static final QName CONSULTAMAESTRAFIJASOAPHTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria", "ConsultaMaestraFijaSOAP_HTTP_Service");

    public ConsultaMaestraFijaSOAPHTTPService() {
        super(ConsultaMaestraFijaSOAPHTTPService.class.getResource("ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria_1.wsdl"), CONSULTAMAESTRAFIJASOAPHTTPSERVICE_QNAME);
    }

    public ConsultaMaestraFijaSOAPHTTPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    @WebEndpoint(name = "ConsultaMaestraFijaSOAP_HTTP_Port")
    public ConsultaMaestraFijaPortType getConsultaMaestraFijaSOAPHTTPPort() {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria", "ConsultaMaestraFijaSOAP_HTTP_Port"), ConsultaMaestraFijaPortType.class);
    }

    @WebEndpoint(name = "ConsultaMaestraFijaSOAP_HTTP_Port")
    public ConsultaMaestraFijaPortType getConsultaMaestraFijaSOAPHTTPPort(WebServiceFeature... features) {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria", "ConsultaMaestraFijaSOAP_HTTP_Port"), ConsultaMaestraFijaPortType.class, features);
    }
}
