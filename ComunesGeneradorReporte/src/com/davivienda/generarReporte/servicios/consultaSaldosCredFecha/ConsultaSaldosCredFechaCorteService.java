package com.davivienda.generarReporte.servicios.consultaSaldosCredFecha;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "ConsultaSaldosCredFechaCorte_Service", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosCredFechaCorte")
public class ConsultaSaldosCredFechaCorteService
        extends Service {

    private static final QName CONSULTASALDOSCREDFECHACORTESERVICE_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldosCredFechaCorte", "ConsultaSaldosCredFechaCorte_Service");

    public ConsultaSaldosCredFechaCorteService() {
        super(ConsultaSaldosCredFechaCorteService.class.getResource("ConsultaSaldosCredFechaCorte_1.wsdl"), CONSULTASALDOSCREDFECHACORTESERVICE_QNAME);
    }

    public ConsultaSaldosCredFechaCorteService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    @WebEndpoint(name = "ConsultaSaldosCredFechaCorte_Port")
    public ConsultaSaldosCredFechaCortePortType getConsultaSaldosCredFechaCortePort() {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaSaldosCredFechaCorte", "ConsultaSaldosCredFechaCorte_Port"), ConsultaSaldosCredFechaCortePortType.class);
    }

    @WebEndpoint(name = "ConsultaSaldosCredFechaCorte_Port")
    public ConsultaSaldosCredFechaCortePortType getConsultaSaldosCredFechaCortePort(WebServiceFeature... features) {
        return getPort(new QName("http://www.davivienda.com/xml/ConsultaSaldosCredFechaCorte", "ConsultaSaldosCredFechaCorte_Port"), ConsultaSaldosCredFechaCortePortType.class, features);
    }
}
