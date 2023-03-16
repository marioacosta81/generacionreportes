package com.davivienda.generarReporte.servicios.productoNoConsumo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultaSaldosProductoNoConsumo_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldosProductoNoConsumo", "ConsultaSaldosProductoNoConsumo");
    private static final QName _ConsultaSaldosProductoNoConsumoResponse_QNAME = new QName("http://www.davivienda.com/xml/ConsultaSaldosProductoNoConsumo", "ConsultaSaldosProductoNoConsumoResponse");

    public ConsultaSaldosProductoNoConsumoType createConsultaSaldosProductoNoConsumoType() {
        return new ConsultaSaldosProductoNoConsumoType();
    }

    public ConsultaSaldosProductoNoConsumoResponseType createConsultaSaldosProductoNoConsumoResponseType() {
        return new ConsultaSaldosProductoNoConsumoResponseType();
    }

    public DataHeaderRespType createDataHeaderRespType() {
        return new DataHeaderRespType();
    }

    public DataResponseType createDataResponseType() {
        return new DataResponseType();
    }

    public ConsultaSaldosProductoNoConsumoDataHeaderType createConsultaSaldosProductoNoConsumoDataHeaderType() {
        return new ConsultaSaldosProductoNoConsumoDataHeaderType();
    }

    public RequestConsultaSaldosProductoNoConsumo createRequestConsultaSaldosProductoNoConsumo() {
        return new RequestConsultaSaldosProductoNoConsumo();
    }

    public ConsultaSaldosProductoNoConsumoDataType createConsultaSaldosProductoNoConsumoDataType() {
        return new ConsultaSaldosProductoNoConsumoDataType();
    }

    public ResponseType createResponseType() {
        return new ResponseType();
    }

    public ProductoNoConsumoType createProductoNoConsumoType() {
        return new ProductoNoConsumoType();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaSaldosProductoNoConsumo", name = "ConsultaSaldosProductoNoConsumo")
    public JAXBElement<ConsultaSaldosProductoNoConsumoType> createConsultaSaldosProductoNoConsumo(ConsultaSaldosProductoNoConsumoType value) {
        return new JAXBElement<ConsultaSaldosProductoNoConsumoType>(_ConsultaSaldosProductoNoConsumo_QNAME, ConsultaSaldosProductoNoConsumoType.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/ConsultaSaldosProductoNoConsumo", name = "ConsultaSaldosProductoNoConsumoResponse")
    public JAXBElement<ConsultaSaldosProductoNoConsumoResponseType> createConsultaSaldosProductoNoConsumoResponse(ConsultaSaldosProductoNoConsumoResponseType value) {
        return new JAXBElement<ConsultaSaldosProductoNoConsumoResponseType>(_ConsultaSaldosProductoNoConsumoResponse_QNAME, ConsultaSaldosProductoNoConsumoResponseType.class, null, value);
    }
}
