package com.davivienda.generarReporte.servicios.productoNoConsumo;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "FabricaCredito04_HTTP_Service", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosProductoNoConsumo")
public class FabricaCredito04HTTPService
        extends Service {

    private static final QName FABRICACREDITO04HTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldosProductoNoConsumo", "FabricaCredito04_HTTP_Service");

    public FabricaCredito04HTTPService() {
        super(FabricaCredito04HTTPService.class.getResource("ConsultaSaldosProductoNoConsumo_1.wsdl"), FABRICACREDITO04HTTPSERVICE_QNAME);
    }

    public FabricaCredito04HTTPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    @WebEndpoint(name = "FabricaCredito04_HTTP_Port")
    public ConsultaSaldosProductoNoConsumoPortType getFabricaCredito04HTTPPort() {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaSaldosProductoNoConsumo", "FabricaCredito04_HTTP_Port"), ConsultaSaldosProductoNoConsumoPortType.class);
    }

    @WebEndpoint(name = "FabricaCredito04_HTTP_Port")
    public ConsultaSaldosProductoNoConsumoPortType getFabricaCredito04HTTPPort(WebServiceFeature... features) {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaSaldosProductoNoConsumo", "FabricaCredito04_HTTP_Port"), ConsultaSaldosProductoNoConsumoPortType.class, features);
    }
}
