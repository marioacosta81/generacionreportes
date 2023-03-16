package com.davivienda.generarReporte.servicios.fondosInversion;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultaFondosDeInversionResponse_QNAME = new QName("http://www.davivienda.com/xml/ConsultaFondosDeInversion", "ConsultaFondosDeInversionResponse");
    private static final QName _ConsultaFondosDeInversion_QNAME = new QName("http://www.davivienda.com/xml/ConsultaFondosDeInversion", "ConsultaFondosDeInversion");

    public ConsultaFondosDeInversion_1 createConsultaFondosDeInversion() {
        return new ConsultaFondosDeInversion_1();
    }

    public ConsultaFondosDeInversionResponse_1 createConsultaFondosDeInversionResponse() {
        return new ConsultaFondosDeInversionResponse_1();
    }

    public DataConsultaFondosDeInversion createDataConsultaFondosDeInversion() {
        return new DataConsultaFondosDeInversion();
    }

    public DataHeaderRespType createDataHeaderRespType() {
        return new DataHeaderRespType();
    }

    public DataHeaderType createDataHeaderType() {
        return new DataHeaderType();
    }

    public ConsultaFondosDeInversionDataResp createConsultaFondosDeInversionDataResp() {
        return new ConsultaFondosDeInversionDataResp();
    }

    public ResponseConsultaFondosDeInversion createResponseConsultaFondosDeInversion() {
        return new ResponseConsultaFondosDeInversion();
    }

    public RequestConsultaFondosDeInversion createRequestConsultaFondosDeInversion() {
        return new RequestConsultaFondosDeInversion();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaFondosDeInversion", name = "ConsultaFondosDeInversionResponse")
    public JAXBElement<ConsultaFondosDeInversionResponse_1> createConsultaFondosDeInversionResponse(ConsultaFondosDeInversionResponse_1 value) {
        return new JAXBElement<ConsultaFondosDeInversionResponse_1>(_ConsultaFondosDeInversionResponse_QNAME, ConsultaFondosDeInversionResponse_1.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaFondosDeInversion", name = "ConsultaFondosDeInversion")
    public JAXBElement<ConsultaFondosDeInversion_1> createConsultaFondosDeInversion(ConsultaFondosDeInversion_1 value) {
        return new JAXBElement<ConsultaFondosDeInversion_1>(_ConsultaFondosDeInversion_QNAME, ConsultaFondosDeInversion_1.class, null, value);
    }
}
