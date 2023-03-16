package com.davivienda.generarReporte.servicios.saldosCtaCte;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "ConsultarSaldoCuentaCorrienteIIService", targetNamespace = "http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/")
public class ConsultarSaldoCuentaCorrienteIIService
        extends Service {

    private static final QName CONSULTARSALDOCUENTACORRIENTEIISERVICE_QNAME = new QName("http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/", "ConsultarSaldoCuentaCorrienteIIService");

    public ConsultarSaldoCuentaCorrienteIIService() {
        super(ConsultarSaldoCuentaCorrienteIIService.class.getResource("ConsultarSaldoCuentaCorrienteII_1.wsdl"), CONSULTARSALDOCUENTACORRIENTEIISERVICE_QNAME);
    }

    public ConsultarSaldoCuentaCorrienteIIService(URL wsdlLocation) {
        super(wsdlLocation, CONSULTARSALDOCUENTACORRIENTEIISERVICE_QNAME);
    }

    public ConsultarSaldoCuentaCorrienteIIService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONSULTARSALDOCUENTACORRIENTEIISERVICE_QNAME, features);
    }

    public ConsultarSaldoCuentaCorrienteIIService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConsultarSaldoCuentaCorrienteIIService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "ConsultarSaldoCuentaCorrienteIIPort")
    public ConsultarSaldoCuentaCorrienteII getConsultarSaldoCuentaCorrienteIIPort() {
        return getPort(new QName("http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/", "ConsultarSaldoCuentaCorrienteIIPort"), ConsultarSaldoCuentaCorrienteII.class);
    }

    @WebEndpoint(name = "ConsultarSaldoCuentaCorrienteIIPort")
    public ConsultarSaldoCuentaCorrienteII getConsultarSaldoCuentaCorrienteIIPort(WebServiceFeature... features) {
        return getPort(new QName("http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/", "ConsultarSaldoCuentaCorrienteIIPort"), ConsultarSaldoCuentaCorrienteII.class, features);
    }
}
