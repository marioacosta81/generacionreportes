package com.davivienda.generarReporte.servicios.consultaDivisas;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultaDeDivisas_QNAME = new QName("http://www.davivienda.com/xml/ConsultaDeDivisas", "ConsultaDeDivisas");
    private static final QName _ConsultaDeDivisasResponse_QNAME = new QName("http://www.davivienda.com/xml/ConsultaDeDivisas", "ConsultaDeDivisasResponse");

    public ConsultaDeDivisasType createConsultaDeDivisasType() {
        return new ConsultaDeDivisasType();
    }

    public ConsultaDeDivisasResponseType createConsultaDeDivisasResponseType() {
        return new ConsultaDeDivisasResponseType();
    }

    public DataHeaderRespType createDataHeaderRespType() {
        return new DataHeaderRespType();
    }

    public DataResponseType createDataResponseType() {
        return new DataResponseType();
    }

    public ConsultaDeDivisasDataHeaderType createConsultaDeDivisasDataHeaderType() {
        return new ConsultaDeDivisasDataHeaderType();
    }

    public RequestConsultaDeDivisas createRequestConsultaDeDivisas() {
        return new RequestConsultaDeDivisas();
    }

    public ResponseType createResponseType() {
        return new ResponseType();
    }

    public ConsultaDeDivisasDataType createConsultaDeDivisasDataType() {
        return new ConsultaDeDivisasDataType();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaDeDivisas", name = "ConsultaDeDivisas")
    public JAXBElement<ConsultaDeDivisasType> createConsultaDeDivisas(ConsultaDeDivisasType value) {
        return new JAXBElement<ConsultaDeDivisasType>(_ConsultaDeDivisas_QNAME, ConsultaDeDivisasType.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaDeDivisas", name = "ConsultaDeDivisasResponse")
    public JAXBElement<ConsultaDeDivisasResponseType> createConsultaDeDivisasResponse(ConsultaDeDivisasResponseType value) {
        return new JAXBElement<ConsultaDeDivisasResponseType>(_ConsultaDeDivisasResponse_QNAME, ConsultaDeDivisasResponseType.class, null, value);
    }
}
