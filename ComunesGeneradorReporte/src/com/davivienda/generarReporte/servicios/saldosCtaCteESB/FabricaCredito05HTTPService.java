package com.davivienda.generarReporte.servicios.saldosCtaCteESB;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "FabricaCredito05_HTTP_Service", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosCuentaCorriente")
public class FabricaCredito05HTTPService
        extends Service {

    private static final URL FABRICACREDITO05HTTPSERVICE_WSDL_LOCATION;
    private static final WebServiceException FABRICACREDITO05HTTPSERVICE_EXCEPTION;
    private static final QName FABRICACREDITO05HTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldosCuentaCorriente", "FabricaCredito05_HTTP_Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = FabricaCredito05HTTPService.class.getResource("ConsultaSaldosCuentaCorriente.wsdl");
        } catch (Exception ex) {
            e = new WebServiceException(ex);
        }
        FABRICACREDITO05HTTPSERVICE_WSDL_LOCATION = url;
        FABRICACREDITO05HTTPSERVICE_EXCEPTION = e;
    }

    public FabricaCredito05HTTPService() {
        super(__getWsdlLocation(), FABRICACREDITO05HTTPSERVICE_QNAME);
    }

    public FabricaCredito05HTTPService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FABRICACREDITO05HTTPSERVICE_QNAME, features);
    }

    public FabricaCredito05HTTPService(URL wsdlLocation) {
        super(wsdlLocation, FABRICACREDITO05HTTPSERVICE_QNAME);
    }

    public FabricaCredito05HTTPService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FABRICACREDITO05HTTPSERVICE_QNAME, features);
    }

    public FabricaCredito05HTTPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FabricaCredito05HTTPService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "FabricaCredito05_HTTP_Port")
    public ConsultaSaldosCuentaCorrientePortType getFabricaCredito05HTTPPort() {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaSaldosCuentaCorriente", "FabricaCredito05_HTTP_Port"), ConsultaSaldosCuentaCorrientePortType.class);
    }

    @WebEndpoint(name = "FabricaCredito05_HTTP_Port")
    public ConsultaSaldosCuentaCorrientePortType getFabricaCredito05HTTPPort(WebServiceFeature... features) {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaSaldosCuentaCorriente", "FabricaCredito05_HTTP_Port"), ConsultaSaldosCuentaCorrientePortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FABRICACREDITO05HTTPSERVICE_EXCEPTION != null) {
            throw FABRICACREDITO05HTTPSERVICE_EXCEPTION;
        }
        return FABRICACREDITO05HTTPSERVICE_WSDL_LOCATION;
    }
}
