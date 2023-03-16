package com.davivienda.generarReporte.servicios.consultaCartera;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "ConsultaCarteraService", targetNamespace = "http://servicios.davivienda.com/consultaCarteraService")
public class ConsultaCarteraService
        extends Service {

    private static final QName CONSULTACARTERASERVICE_QNAME = new QName("http://servicios.davivienda.com/consultaCarteraService", "ConsultaCarteraService");

    public ConsultaCarteraService() {
        super(ConsultaCarteraService.class.getResource("ConsultaCarteraService_1.wsdl"), CONSULTACARTERASERVICE_QNAME);
    }

    public ConsultaCarteraService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    @WebEndpoint(name = "ConsultaCarteraServiceInterfacePort")
    public ConsultaCarteraServiceInterface getConsultaCarteraServiceInterfacePort() {
        return getPort(new QName("http://servicios.davivienda.com/consultaCarteraService", "ConsultaCarteraServiceInterfacePort"), ConsultaCarteraServiceInterface.class);
    }

    @WebEndpoint(name = "ConsultaCarteraServiceInterfacePort")
    public ConsultaCarteraServiceInterface getConsultaCarteraServiceInterfacePort(WebServiceFeature... features) {
        return getPort(new QName("http://servicios.davivienda.com/consultaCarteraService", "ConsultaCarteraServiceInterfacePort"), ConsultaCarteraServiceInterface.class, features);
    }
}
