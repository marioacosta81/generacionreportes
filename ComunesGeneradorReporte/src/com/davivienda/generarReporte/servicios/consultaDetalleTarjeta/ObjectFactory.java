package com.davivienda.generarReporte.servicios.consultaDetalleTarjeta;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultaDetalleTarjetaCreditoResponse_QNAME = new QName("http://www.davivienda.com/xml/ConsultaDetalleTarjetaCredito", "ConsultaDetalleTarjetaCreditoResponse");
    private static final QName _ConsultaDetalleTarjetaCredito_QNAME = new QName("http://www.davivienda.com/xml/ConsultaDetalleTarjetaCredito", "ConsultaDetalleTarjetaCredito");

    public ConsultaDetalleTarjetaCreditoType createConsultaDetalleTarjetaCreditoType() {
        return new ConsultaDetalleTarjetaCreditoType();
    }

    public ConsultaDetalleTarjetaCreditoResponseType createConsultaDetalleTarjetaCreditoResponseType() {
        return new ConsultaDetalleTarjetaCreditoResponseType();
    }

    public DataHeaderRespType createDataHeaderRespType() {
        return new DataHeaderRespType();
    }

    public DataResponseType createDataResponseType() {
        return new DataResponseType();
    }

    public ResponseType createResponseType() {
        return new ResponseType();
    }

    public ConsultaDetalleTarjetaCreditoDataHeaderType createConsultaDetalleTarjetaCreditoDataHeaderType() {
        return new ConsultaDetalleTarjetaCreditoDataHeaderType();
    }

    public RequestConsultaDetalleTarjetaCredito createRequestConsultaDetalleTarjetaCredito() {
        return new RequestConsultaDetalleTarjetaCredito();
    }

    public ConsultaDetalleTarjetaCreditoDataType createConsultaDetalleTarjetaCreditoDataType() {
        return new ConsultaDetalleTarjetaCreditoDataType();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaDetalleTarjetaCredito", name = "ConsultaDetalleTarjetaCreditoResponse")
    public JAXBElement<ConsultaDetalleTarjetaCreditoResponseType> createConsultaDetalleTarjetaCreditoResponse(ConsultaDetalleTarjetaCreditoResponseType value) {
        return new JAXBElement<ConsultaDetalleTarjetaCreditoResponseType>(_ConsultaDetalleTarjetaCreditoResponse_QNAME, ConsultaDetalleTarjetaCreditoResponseType.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaDetalleTarjetaCredito", name = "ConsultaDetalleTarjetaCredito")
    public JAXBElement<ConsultaDetalleTarjetaCreditoType> createConsultaDetalleTarjetaCredito(ConsultaDetalleTarjetaCreditoType value) {
        return new JAXBElement<ConsultaDetalleTarjetaCreditoType>(_ConsultaDetalleTarjetaCredito_QNAME, ConsultaDetalleTarjetaCreditoType.class, null, value);
    }
}
