package com.davivienda.generarReporte.servicios.dabuenavida;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultaSaldoTituloDabuenavidaResponse_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldoTituloDabuenavida", "ConsultaSaldoTituloDabuenavidaResponse");
    private static final QName _ConsultaSaldoTituloDabuenavida_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldoTituloDabuenavida", "ConsultaSaldoTituloDabuenavida");

    public ConsultaSaldoTituloDabuenavidaType createConsultaSaldoTituloDabuenavidaType() {
        return new ConsultaSaldoTituloDabuenavidaType();
    }

    public ConsultaSaldoTituloDabuenavidaResponseType createConsultaSaldoTituloDabuenavidaResponseType() {
        return new ConsultaSaldoTituloDabuenavidaResponseType();
    }

    public DataHeaderRespType createDataHeaderRespType() {
        return new DataHeaderRespType();
    }

    public DataResponseType createDataResponseType() {
        return new DataResponseType();
    }

    public TituloDabuenavidaType createTituloDabuenavidaType() {
        return new TituloDabuenavidaType();
    }

    public RequestConsultaSaldoTituloDabuenavida createRequestConsultaSaldoTituloDabuenavida() {
        return new RequestConsultaSaldoTituloDabuenavida();
    }

    public ResponseType createResponseType() {
        return new ResponseType();
    }

    public ConsultaSaldoTituloDabuenavidaDataHeaderType createConsultaSaldoTituloDabuenavidaDataHeaderType() {
        return new ConsultaSaldoTituloDabuenavidaDataHeaderType();
    }

    public ConsultaSaldoTituloDabuenavidaDataType createConsultaSaldoTituloDabuenavidaDataType() {
        return new ConsultaSaldoTituloDabuenavidaDataType();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaSaldoTituloDabuenavida", name = "ConsultaSaldoTituloDabuenavidaResponse")
    public JAXBElement<ConsultaSaldoTituloDabuenavidaResponseType> createConsultaSaldoTituloDabuenavidaResponse(ConsultaSaldoTituloDabuenavidaResponseType value) {
        return new JAXBElement<ConsultaSaldoTituloDabuenavidaResponseType>(_ConsultaSaldoTituloDabuenavidaResponse_QNAME, ConsultaSaldoTituloDabuenavidaResponseType.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaSaldoTituloDabuenavida", name = "ConsultaSaldoTituloDabuenavida")
    public JAXBElement<ConsultaSaldoTituloDabuenavidaType> createConsultaSaldoTituloDabuenavida(ConsultaSaldoTituloDabuenavidaType value) {
        return new JAXBElement<ConsultaSaldoTituloDabuenavidaType>(_ConsultaSaldoTituloDabuenavida_QNAME, ConsultaSaldoTituloDabuenavidaType.class, null, value);
    }
}
