package com.davivienda.generarReporte.servicios.saldosCtaCteESB;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultaSaldosCuentaCorrienteResponse_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldosCuentaCorriente", "ConsultaSaldosCuentaCorrienteResponse");
    private static final QName _ConsultaSaldosCuentaCorriente_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldosCuentaCorriente", "ConsultaSaldosCuentaCorriente");

    public ConsultaSaldosCuentaCorrienteType createConsultaSaldosCuentaCorrienteType() {
        return new ConsultaSaldosCuentaCorrienteType();
    }

    public ConsultaSaldosCuentaCorrienteResponseType createConsultaSaldosCuentaCorrienteResponseType() {
        return new ConsultaSaldosCuentaCorrienteResponseType();
    }

    public ResponseType createResponseType() {
        return new ResponseType();
    }

    public CuentaCorrienteType createCuentaCorrienteType() {
        return new CuentaCorrienteType();
    }

    public DataHeaderRespType createDataHeaderRespType() {
        return new DataHeaderRespType();
    }

    public RequestConsultaSaldosCuentaCorriente createRequestConsultaSaldosCuentaCorriente() {
        return new RequestConsultaSaldosCuentaCorriente();
    }

    public ConsultaSaldosCuentaCorrienteDataType createConsultaSaldosCuentaCorrienteDataType() {
        return new ConsultaSaldosCuentaCorrienteDataType();
    }

    public ConsultaSaldosCuentaCorrienteDataHeaderType createConsultaSaldosCuentaCorrienteDataHeaderType() {
        return new ConsultaSaldosCuentaCorrienteDataHeaderType();
    }

    public DataResponseType createDataResponseType() {
        return new DataResponseType();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaSaldosCuentaCorriente", name = "ConsultaSaldosCuentaCorrienteResponse")
    public JAXBElement<ConsultaSaldosCuentaCorrienteResponseType> createConsultaSaldosCuentaCorrienteResponse(ConsultaSaldosCuentaCorrienteResponseType value) {
        return new JAXBElement<ConsultaSaldosCuentaCorrienteResponseType>(_ConsultaSaldosCuentaCorrienteResponse_QNAME, ConsultaSaldosCuentaCorrienteResponseType.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaSaldosCuentaCorriente", name = "ConsultaSaldosCuentaCorriente")
    public JAXBElement<ConsultaSaldosCuentaCorrienteType> createConsultaSaldosCuentaCorriente(ConsultaSaldosCuentaCorrienteType value) {
        return new JAXBElement<ConsultaSaldosCuentaCorrienteType>(_ConsultaSaldosCuentaCorriente_QNAME, ConsultaSaldosCuentaCorrienteType.class, null, value);
    }
}
