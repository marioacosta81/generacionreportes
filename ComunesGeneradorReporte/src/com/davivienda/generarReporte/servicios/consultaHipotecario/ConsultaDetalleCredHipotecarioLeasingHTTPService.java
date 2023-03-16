package com.davivienda.generarReporte.servicios.consultaHipotecario;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "ConsultaDetalleCredHipotecarioLeasing_HTTP_Service", targetNamespace = "http://www.davivienda.com/xml/ConsultaDetalleCredHipotecarioLeasing")
public class ConsultaDetalleCredHipotecarioLeasingHTTPService
        extends Service {

    private static final QName CONSULTADETALLECREDHIPOTECARIOLEASINGHTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/ConsultaDetalleCredHipotecarioLeasing", "ConsultaDetalleCredHipotecarioLeasing_HTTP_Service");

    public ConsultaDetalleCredHipotecarioLeasingHTTPService() {
        super(ConsultaDetalleCredHipotecarioLeasingHTTPService.class.getResource("ConsultaDetalleCredHipotecarioLeasing.wsdl"), CONSULTADETALLECREDHIPOTECARIOLEASINGHTTPSERVICE_QNAME);
    }

    public ConsultaDetalleCredHipotecarioLeasingHTTPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    @WebEndpoint(name = "ConsultaDetalleCredHipotecarioLeasing_HTTP_Port")
    public ConsultaDetalleCredHipotecarioLeasingPortType getConsultaDetalleCredHipotecarioLeasingHTTPPort() {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaDetalleCredHipotecarioLeasing", "ConsultaDetalleCredHipotecarioLeasing_HTTP_Port"), ConsultaDetalleCredHipotecarioLeasingPortType.class);
    }

    @WebEndpoint(name = "ConsultaDetalleCredHipotecarioLeasing_HTTP_Port")
    public ConsultaDetalleCredHipotecarioLeasingPortType getConsultaDetalleCredHipotecarioLeasingHTTPPort(WebServiceFeature... features) {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaDetalleCredHipotecarioLeasing", "ConsultaDetalleCredHipotecarioLeasing_HTTP_Port"), ConsultaDetalleCredHipotecarioLeasingPortType.class, features);
    }
}
