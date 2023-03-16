package com.davivienda.generarReporte.servicios.consultaHipotecario;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultaDetalleCredHipotecarioLeasing_QNAME = new QName("http://www.davivienda.com/xml/ConsultaDetalleCredHipotecarioLeasing", "ConsultaDetalleCredHipotecarioLeasing");
    private static final QName _ConsultaDetalleCredHipotecarioLeasingResponse_QNAME = new QName("http://www.davivienda.com/xml/ConsultaDetalleCredHipotecarioLeasing", "ConsultaDetalleCredHipotecarioLeasingResponse");

    public ConsultaDetalleCredHipotecarioLeasingType createConsultaDetalleCredHipotecarioLeasingType() {
        return new ConsultaDetalleCredHipotecarioLeasingType();
    }

    public ConsultaDetalleCredHipotecarioLeasingResponseType createConsultaDetalleCredHipotecarioLeasingResponseType() {
        return new ConsultaDetalleCredHipotecarioLeasingResponseType();
    }

    public ConsultaDetalleCredHipotecarioLeasingDataHeaderType createConsultaDetalleCredHipotecarioLeasingDataHeaderType() {
        return new ConsultaDetalleCredHipotecarioLeasingDataHeaderType();
    }

    public DataHeaderRespType createDataHeaderRespType() {
        return new DataHeaderRespType();
    }

    public RegistroRespType createRegistroRespType() {
        return new RegistroRespType();
    }

    public DataResponseType createDataResponseType() {
        return new DataResponseType();
    }

    public RequestConsultaDetalleCredHipotecarioLeasing createRequestConsultaDetalleCredHipotecarioLeasing() {
        return new RequestConsultaDetalleCredHipotecarioLeasing();
    }

    public ConsultaDetalleCredHipotecarioLeasingDataType createConsultaDetalleCredHipotecarioLeasingDataType() {
        return new ConsultaDetalleCredHipotecarioLeasingDataType();
    }

    public ResponseType createResponseType() {
        return new ResponseType();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaDetalleCredHipotecarioLeasing", name = "ConsultaDetalleCredHipotecarioLeasing")
    public JAXBElement<ConsultaDetalleCredHipotecarioLeasingType> createConsultaDetalleCredHipotecarioLeasing(ConsultaDetalleCredHipotecarioLeasingType value) {
        return new JAXBElement<ConsultaDetalleCredHipotecarioLeasingType>(_ConsultaDetalleCredHipotecarioLeasing_QNAME, ConsultaDetalleCredHipotecarioLeasingType.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaDetalleCredHipotecarioLeasing", name = "ConsultaDetalleCredHipotecarioLeasingResponse")
    public JAXBElement<ConsultaDetalleCredHipotecarioLeasingResponseType> createConsultaDetalleCredHipotecarioLeasingResponse(ConsultaDetalleCredHipotecarioLeasingResponseType value) {
        return new JAXBElement<ConsultaDetalleCredHipotecarioLeasingResponseType>(_ConsultaDetalleCredHipotecarioLeasingResponse_QNAME, ConsultaDetalleCredHipotecarioLeasingResponseType.class, null, value);
    }
}
