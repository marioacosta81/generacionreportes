package co.com.davivienda.consultacertificacionPreventaContragarantia;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultaCertificadoProducto_QNAME = new QName("http://www.davivienda.com/xml/ConsultaCertificadoProducto", "ConsultaCertificadoProducto");
    private static final QName _ConsultaCertificadoProductoResponse_QNAME = new QName("http://www.davivienda.com/xml/ConsultaCertificadoProducto", "ConsultaCertificadoProductoResponse");

    public ConsultaCertificadoProductoResType createConsultaCertificadoProductoResType() {
        return new ConsultaCertificadoProductoResType();
    }

    public ConsultaCertificadoProductoType createConsultaCertificadoProductoType() {
        return new ConsultaCertificadoProductoType();
    }

    public DataHeaderReqType createDataHeaderReqType() {
        return new DataHeaderReqType();
    }

    public ConsultaCertificadoProductoResponseType createConsultaCertificadoProductoResponseType() {
        return new ConsultaCertificadoProductoResponseType();
    }

    public ConsultaCertificadoProductoRequestType createConsultaCertificadoProductoRequestType() {
        return new ConsultaCertificadoProductoRequestType();
    }

    public DataResType createDataResType() {
        return new DataResType();
    }

    public DataReqType createDataReqType() {
        return new DataReqType();
    }

    public DataHeaderResType createDataHeaderResType() {
        return new DataHeaderResType();
    }

    @XmlElementDecl(
            namespace = "http://www.davivienda.com/xml/ConsultaCertificadoProducto",
            name = "ConsultaCertificadoProducto"
    )
    public JAXBElement<ConsultaCertificadoProductoType> createConsultaCertificadoProducto(ConsultaCertificadoProductoType value) {
        return new JAXBElement(_ConsultaCertificadoProducto_QNAME, ConsultaCertificadoProductoType.class, (Class) null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.davivienda.com/xml/ConsultaCertificadoProducto",
            name = "ConsultaCertificadoProductoResponse"
    )
    public JAXBElement<ConsultaCertificadoProductoResType> createConsultaCertificadoProductoResponse(ConsultaCertificadoProductoResType value) {
        return new JAXBElement(_ConsultaCertificadoProductoResponse_QNAME, ConsultaCertificadoProductoResType.class, (Class) null, value);
    }
}
