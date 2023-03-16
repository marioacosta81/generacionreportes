package com.davivienda.generarReporte.servicios.certificacionCDT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _GeneracionDeCertificacionDeCDTsResponse_QNAME = new QName("http://www.davivienda.com/xml/GeneracionDeCertificacionDeCDTs", "GeneracionDeCertificacionDeCDTsResponse");
    private static final QName _GeneracionDeCertificacionDeCDTs_QNAME = new QName("http://www.davivienda.com/xml/GeneracionDeCertificacionDeCDTs", "GeneracionDeCertificacionDeCDTs");

    public GeneracionDeCertificacionDeCDTsType createGeneracionDeCertificacionDeCDTsType() {
        return new GeneracionDeCertificacionDeCDTsType();
    }

    public GeneracionDeCertificacionDeCDTsResponseType createGeneracionDeCertificacionDeCDTsResponseType() {
        return new GeneracionDeCertificacionDeCDTsResponseType();
    }

    public DataHeaderRespType createDataHeaderRespType() {
        return new DataHeaderRespType();
    }

    public GeneracionDeCertificacionDeCDTsDataHeaderType createGeneracionDeCertificacionDeCDTsDataHeaderType() {
        return new GeneracionDeCertificacionDeCDTsDataHeaderType();
    }

    public RequestGeneracionDeCertificacionDeCDTs createRequestGeneracionDeCertificacionDeCDTs() {
        return new RequestGeneracionDeCertificacionDeCDTs();
    }

    public DataResponseType createDataResponseType() {
        return new DataResponseType();
    }

    public GeneracionDeCertificacionDeCDTsDataType createGeneracionDeCertificacionDeCDTsDataType() {
        return new GeneracionDeCertificacionDeCDTsDataType();
    }

    public ResponseType createResponseType() {
        return new ResponseType();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/GeneracionDeCertificacionDeCDTs", name = "GeneracionDeCertificacionDeCDTsResponse")
    public JAXBElement<GeneracionDeCertificacionDeCDTsResponseType> createGeneracionDeCertificacionDeCDTsResponse(GeneracionDeCertificacionDeCDTsResponseType value) {
        return new JAXBElement<GeneracionDeCertificacionDeCDTsResponseType>(_GeneracionDeCertificacionDeCDTsResponse_QNAME, GeneracionDeCertificacionDeCDTsResponseType.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/GeneracionDeCertificacionDeCDTs", name = "GeneracionDeCertificacionDeCDTs")
    public JAXBElement<GeneracionDeCertificacionDeCDTsType> createGeneracionDeCertificacionDeCDTs(GeneracionDeCertificacionDeCDTsType value) {
        return new JAXBElement<GeneracionDeCertificacionDeCDTsType>(_GeneracionDeCertificacionDeCDTs_QNAME, GeneracionDeCertificacionDeCDTsType.class, null, value);
    }
}
