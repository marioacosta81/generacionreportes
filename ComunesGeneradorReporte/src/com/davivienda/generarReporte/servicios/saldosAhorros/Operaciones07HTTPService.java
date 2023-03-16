package com.davivienda.generarReporte.servicios.saldosAhorros;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "Operaciones07_HTTP_Service", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosAhorros")
public class Operaciones07HTTPService
        extends Service {

    private static final QName OPERACIONES07HTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldosAhorros", "Operaciones07_HTTP_Service");

    public Operaciones07HTTPService() {
        super(Operaciones07HTTPService.class.getResource("ConsultaSaldosAhorros_1.wsdl"), OPERACIONES07HTTPSERVICE_QNAME);
    }

    public Operaciones07HTTPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    @WebEndpoint(name = "Operaciones07_HTTP_Port")
    public ConsultaSaldosAhorrosMsgSetPortType getOperaciones07HTTPPort() {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaSaldosAhorros", "Operaciones07_HTTP_Port"), ConsultaSaldosAhorrosMsgSetPortType.class);
    }

    @WebEndpoint(name = "Operaciones07_HTTP_Port")
    public ConsultaSaldosAhorrosMsgSetPortType getOperaciones07HTTPPort(WebServiceFeature... features) {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaSaldosAhorros", "Operaciones07_HTTP_Port"), ConsultaSaldosAhorrosMsgSetPortType.class, features);
    }
}
