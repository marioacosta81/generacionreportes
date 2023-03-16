package com.davivienda.generarReporte.servicios.dabuenavida;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "FabricaCredito03_HTTP_Service", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldoTituloDabuenavida")
public class FabricaCredito03HTTPService
        extends Service {

    private static final QName FABRICACREDITO03HTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldoTituloDabuenavida", "FabricaCredito03_HTTP_Service");

    public FabricaCredito03HTTPService() {
        super(FabricaCredito03HTTPService.class.getResource("ConsultaSaldoTituloDabuenavida_1.wsdl"), FABRICACREDITO03HTTPSERVICE_QNAME);
    }

    public FabricaCredito03HTTPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    @WebEndpoint(name = "FabricaCredito03_HTTP_Port")
    public ConsultaSaldoTituloDabuenavidaPortType getFabricaCredito03HTTPPort() {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaSaldoTituloDabuenavida", "FabricaCredito03_HTTP_Port"), ConsultaSaldoTituloDabuenavidaPortType.class);
    }

    @WebEndpoint(name = "FabricaCredito03_HTTP_Port")
    public ConsultaSaldoTituloDabuenavidaPortType getFabricaCredito03HTTPPort(WebServiceFeature... features) {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaSaldoTituloDabuenavida", "FabricaCredito03_HTTP_Port"), ConsultaSaldoTituloDabuenavidaPortType.class, features);
    }
}
