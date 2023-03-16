package com.davivienda.generarReporte.servicios.fondosInversion;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "SAFConsultaFondosDeInversion_HTTP_Service", targetNamespace = "http://www.davivienda.com/xml/ConsultaFondosDeInversion")
public class SAFConsultaFondosDeInversionHTTPService
        extends Service {

    private static final QName SAFCONSULTAFONDOSDEINVERSIONHTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/ConsultaFondosDeInversion", "SAFConsultaFondosDeInversion_HTTP_Service");

    public SAFConsultaFondosDeInversionHTTPService() {
        super(SAFConsultaFondosDeInversionHTTPService.class.getResource("ConsultaFondosDeInversion_1.wsdl"), SAFCONSULTAFONDOSDEINVERSIONHTTPSERVICE_QNAME);
    }

    public SAFConsultaFondosDeInversionHTTPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    @WebEndpoint(name = "SAFConsultaFondosDeInversion_HTTP_Port")
    public SAFMsgSetPortType getSAFConsultaFondosDeInversionHTTPPort() {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaFondosDeInversion", "SAFConsultaFondosDeInversion_HTTP_Port"), SAFMsgSetPortType.class);
    }

    @WebEndpoint(name = "SAFConsultaFondosDeInversion_HTTP_Port")
    public SAFMsgSetPortType getSAFConsultaFondosDeInversionHTTPPort(WebServiceFeature... features) {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaFondosDeInversion", "SAFConsultaFondosDeInversion_HTTP_Port"), SAFMsgSetPortType.class, features);
    }
}
