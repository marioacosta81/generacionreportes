package com.davivienda.generarReporte.servicios.cafeteraAgropecuaria;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsTotTCCafAgrResponse_QNAME = new QName("http://www.davivienda.com/xml/ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria", "ConsTotTCCafAgrResponse");
    private static final QName _ConsTotTCCafAgrRequest_QNAME = new QName("http://www.davivienda.com/xml/ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria", "ConsTotTCCafAgrRequest");

    public ConsTotTCCafAgrRequestType createConsTotTCCafAgrRequestType() {
        return new ConsTotTCCafAgrRequestType();
    }

    public ConsTotTCCafAgrResponseType createConsTotTCCafAgrResponseType() {
        return new ConsTotTCCafAgrResponseType();
    }

    public DataHeaderRespType createDataHeaderRespType() {
        return new DataHeaderRespType();
    }

    public DataHeaderType createDataHeaderType() {
        return new DataHeaderType();
    }

    public DataRespType createDataRespType() {
        return new DataRespType();
    }

    public DataType createDataType() {
        return new DataType();
    }

    public RequestType createRequestType() {
        return new RequestType();
    }

    public ComplexType createComplexType() {
        return new ComplexType();
    }

    public ResponseType createResponseType() {
        return new ResponseType();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria", name = "ConsTotTCCafAgrResponse")
    public JAXBElement<ConsTotTCCafAgrResponseType> createConsTotTCCafAgrResponse(ConsTotTCCafAgrResponseType value) {
        return new JAXBElement<ConsTotTCCafAgrResponseType>(_ConsTotTCCafAgrResponse_QNAME, ConsTotTCCafAgrResponseType.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria", name = "ConsTotTCCafAgrRequest")
    public JAXBElement<ConsTotTCCafAgrRequestType> createConsTotTCCafAgrRequest(ConsTotTCCafAgrRequestType value) {
        return new JAXBElement<ConsTotTCCafAgrRequestType>(_ConsTotTCCafAgrRequest_QNAME, ConsTotTCCafAgrRequestType.class, null, value);
    }
}
