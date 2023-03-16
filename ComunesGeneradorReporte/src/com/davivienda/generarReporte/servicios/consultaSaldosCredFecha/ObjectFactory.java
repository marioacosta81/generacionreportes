package com.davivienda.generarReporte.servicios.consultaSaldosCredFecha;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultaSaldosCredFechaCorteResponse_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldosCredFechaCorte", "ConsultaSaldosCredFechaCorteResponse");
    private static final QName _ConsultaSaldosCredFechaCorte_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldosCredFechaCorte", "ConsultaSaldosCredFechaCorte");

    public ConsultaSaldosCredFechaCorteType createConsultaSaldosCredFechaCorteType() {
        return new ConsultaSaldosCredFechaCorteType();
    }

    public ConsultaSaldosCredFechaCorteResponseType createConsultaSaldosCredFechaCorteResponseType() {
        return new ConsultaSaldosCredFechaCorteResponseType();
    }

    public DataHeaderRespType createDataHeaderRespType() {
        return new DataHeaderRespType();
    }

    public DataResponseType createDataResponseType() {
        return new DataResponseType();
    }

    public RequestConsultaSaldosCredFechaCorte createRequestConsultaSaldosCredFechaCorte() {
        return new RequestConsultaSaldosCredFechaCorte();
    }

    public ConsultaSaldosCredFechaCorteDataHeaderType createConsultaSaldosCredFechaCorteDataHeaderType() {
        return new ConsultaSaldosCredFechaCorteDataHeaderType();
    }

    public ResponseType createResponseType() {
        return new ResponseType();
    }

    public ConsultaSaldosCredFechaCorteDataType createConsultaSaldosCredFechaCorteDataType() {
        return new ConsultaSaldosCredFechaCorteDataType();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaSaldosCredFechaCorte", name = "ConsultaSaldosCredFechaCorteResponse")
    public JAXBElement<ConsultaSaldosCredFechaCorteResponseType> createConsultaSaldosCredFechaCorteResponse(ConsultaSaldosCredFechaCorteResponseType value) {
        return new JAXBElement<ConsultaSaldosCredFechaCorteResponseType>(_ConsultaSaldosCredFechaCorteResponse_QNAME, ConsultaSaldosCredFechaCorteResponseType.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaSaldosCredFechaCorte", name = "ConsultaSaldosCredFechaCorte")
    public JAXBElement<ConsultaSaldosCredFechaCorteType> createConsultaSaldosCredFechaCorte(ConsultaSaldosCredFechaCorteType value) {
        return new JAXBElement<ConsultaSaldosCredFechaCorteType>(_ConsultaSaldosCredFechaCorte_QNAME, ConsultaSaldosCredFechaCorteType.class, null, value);
    }
}
