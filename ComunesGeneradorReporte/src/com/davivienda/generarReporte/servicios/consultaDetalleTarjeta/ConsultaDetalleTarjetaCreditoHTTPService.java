package com.davivienda.generarReporte.servicios.consultaDetalleTarjeta;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "ConsultaDetalleTarjetaCredito_HTTP_Service", targetNamespace = "http://www.davivienda.com/xml/ConsultaDetalleTarjetaCredito")
public class ConsultaDetalleTarjetaCreditoHTTPService
        extends Service {

    private static final QName CONSULTADETALLETARJETACREDITOHTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/ConsultaDetalleTarjetaCredito", "ConsultaDetalleTarjetaCredito_HTTP_Service");

    public ConsultaDetalleTarjetaCreditoHTTPService() {
        super(ConsultaDetalleTarjetaCreditoHTTPService.class.getResource("ConsultaDetalleTarjetaCredito_1.wsdl"), CONSULTADETALLETARJETACREDITOHTTPSERVICE_QNAME);
    }

    public ConsultaDetalleTarjetaCreditoHTTPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    @WebEndpoint(name = "ConsultaDetalleTarjetaCredito_HTTP_Port")
    public ConsultaDetalleTarjetaCreditoPortType getConsultaDetalleTarjetaCreditoHTTPPort() {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaDetalleTarjetaCredito", "ConsultaDetalleTarjetaCredito_HTTP_Port"), ConsultaDetalleTarjetaCreditoPortType.class);
    }

    @WebEndpoint(name = "ConsultaDetalleTarjetaCredito_HTTP_Port")
    public ConsultaDetalleTarjetaCreditoPortType getConsultaDetalleTarjetaCreditoHTTPPort(WebServiceFeature... features) {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaDetalleTarjetaCredito", "ConsultaDetalleTarjetaCredito_HTTP_Port"), ConsultaDetalleTarjetaCreditoPortType.class, features);
    }
}
