package com.davivienda.generarReporte.servicios.saldosAhorros;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultaSaldosAhorros_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldosAhorros", "ConsultaSaldosAhorros");
    private static final QName _ConsultaSaldosAhorrosResponse_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldosAhorros", "ConsultaSaldosAhorrosResponse");

    public ConsultaSaldosAhorrosType createConsultaSaldosAhorrosType() {
        return new ConsultaSaldosAhorrosType();
    }

    public ConsultaSaldosAhorrosResponseType createConsultaSaldosAhorrosResponseType() {
        return new ConsultaSaldosAhorrosResponseType();
    }

    public DataHeaderResponseType createDataHeaderResponseType() {
        return new DataHeaderResponseType();
    }

    public DataHeaderRequestType createDataHeaderRequestType() {
        return new DataHeaderRequestType();
    }

    public DataResponseType createDataResponseType() {
        return new DataResponseType();
    }

    public RequestType createRequestType() {
        return new RequestType();
    }

    public ResponseType createResponseType() {
        return new ResponseType();
    }

    public DataRequestType createDataRequestType() {
        return new DataRequestType();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaSaldosAhorros", name = "ConsultaSaldosAhorros")
    public JAXBElement<ConsultaSaldosAhorrosType> createConsultaSaldosAhorros(ConsultaSaldosAhorrosType value) {
        return new JAXBElement<ConsultaSaldosAhorrosType>(_ConsultaSaldosAhorros_QNAME, ConsultaSaldosAhorrosType.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaSaldosAhorros", name = "ConsultaSaldosAhorrosResponse")
    public JAXBElement<ConsultaSaldosAhorrosResponseType> createConsultaSaldosAhorrosResponse(ConsultaSaldosAhorrosResponseType value) {
        return new JAXBElement<ConsultaSaldosAhorrosResponseType>(_ConsultaSaldosAhorrosResponse_QNAME, ConsultaSaldosAhorrosResponseType.class, null, value);
    }
}
