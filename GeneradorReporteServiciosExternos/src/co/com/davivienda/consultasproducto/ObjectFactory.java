package co.com.davivienda.consultasproducto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultasProductos_QNAME = new QName("http://www.davivienda.com/xml/ConsultasProductos", "ConsultasProductos");
    private static final QName _ConsultasProductosResponse_QNAME = new QName("http://www.davivienda.com/xml/ConsultasProductos", "ConsultasProductosResponse");

    public ConsultasProductosResponseType createConsultasProductosResponseType() {
        return new ConsultasProductosResponseType();
    }

    public ConsultasProductosType createConsultasProductosType() {
        return new ConsultasProductosType();
    }

    public DataHeaderReqType createDataHeaderReqType() {
        return new DataHeaderReqType();
    }

    public ResponseType createResponseType() {
        return new ResponseType();
    }

    public DataHeaderRespType createDataHeaderRespType() {
        return new DataHeaderRespType();
    }

    public RegistrosType createRegistrosType() {
        return new RegistrosType();
    }

    public DataReqType createDataReqType() {
        return new DataReqType();
    }

    public RegistroType createRegistroType() {
        return new RegistroType();
    }

    public RequestType createRequestType() {
        return new RequestType();
    }

    public DataRespType createDataRespType() {
        return new DataRespType();
    }

    @XmlElementDecl(
            namespace = "http://www.davivienda.com/xml/ConsultasProductos",
            name = "ConsultasProductos"
    )
    public JAXBElement<ConsultasProductosType> createConsultasProductos(ConsultasProductosType value) {
        return new JAXBElement(_ConsultasProductos_QNAME, ConsultasProductosType.class, (Class) null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.davivienda.com/xml/ConsultasProductos",
            name = "ConsultasProductosResponse"
    )
    public JAXBElement<ConsultasProductosResponseType> createConsultasProductosResponse(ConsultasProductosResponseType value) {
        return new JAXBElement(_ConsultasProductosResponse_QNAME, ConsultasProductosResponseType.class, (Class) null, value);
    }
}
