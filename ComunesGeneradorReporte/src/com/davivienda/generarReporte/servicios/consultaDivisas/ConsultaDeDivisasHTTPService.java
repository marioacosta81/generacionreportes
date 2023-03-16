package com.davivienda.generarReporte.servicios.consultaDivisas;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "ConsultaDeDivisas_HTTP_Service", targetNamespace = "http://www.davivienda.com/xml/ConsultaDeDivisas")
public class ConsultaDeDivisasHTTPService
        extends Service {

    private static final QName CONSULTADEDIVISASHTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/ConsultaDeDivisas", "ConsultaDeDivisas_HTTP_Service");

    public ConsultaDeDivisasHTTPService() {
        super(ConsultaDeDivisasHTTPService.class.getResource("ConsultaDeDivisas_1.wsdl"), CONSULTADEDIVISASHTTPSERVICE_QNAME);
    }

    public ConsultaDeDivisasHTTPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    @WebEndpoint(name = "ConsultaDeDivisas_HTTP_Port")
    public ConsultaDeDivisasPortType getConsultaDeDivisasHTTPPort() {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaDeDivisas", "ConsultaDeDivisas_HTTP_Port"), ConsultaDeDivisasPortType.class);
    }

    @WebEndpoint(name = "ConsultaDeDivisas_HTTP_Port")
    public ConsultaDeDivisasPortType getConsultaDeDivisasHTTPPort(WebServiceFeature... features) {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaDeDivisas", "ConsultaDeDivisas_HTTP_Port"), ConsultaDeDivisasPortType.class, features);
    }
}
