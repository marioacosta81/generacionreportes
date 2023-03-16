package com.davivienda.generarReporte.servicios.representativos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _DocumentosRepresentativosUnificadaResponse_QNAME = new QName("http://www.davivienda.com/xml/DocumentosRepresentativosUnificada", "DocumentosRepresentativosUnificadaResponse");
    private static final QName _DocumentosRepresentativosUnificada_QNAME = new QName("http://www.davivienda.com/xml/DocumentosRepresentativosUnificada", "DocumentosRepresentativosUnificada");

    public DocumentosRepresentativosUnificadaResponseType createDocumentosRepresentativosUnificadaResponseType() {
        return new DocumentosRepresentativosUnificadaResponseType();
    }

    public DocumentosRepresentativosUnificadaType createDocumentosRepresentativosUnificadaType() {
        return new DocumentosRepresentativosUnificadaType();
    }

    public DataHeaderReqType createDataHeaderReqType() {
        return new DataHeaderReqType();
    }

    public AporteRealizadoType createAporteRealizadoType() {
        return new AporteRealizadoType();
    }

    public ParticipacionType createParticipacionType() {
        return new ParticipacionType();
    }

    public RequestDocumentosRepresentativosUnificadaType createRequestDocumentosRepresentativosUnificadaType() {
        return new RequestDocumentosRepresentativosUnificadaType();
    }

    public ResponseDocumentosRepresentativosUnificadaType createResponseDocumentosRepresentativosUnificadaType() {
        return new ResponseDocumentosRepresentativosUnificadaType();
    }

    public DataHeaderRespType createDataHeaderRespType() {
        return new DataHeaderRespType();
    }

    public DataReqType createDataReqType() {
        return new DataReqType();
    }

    public ParticipacionesType createParticipacionesType() {
        return new ParticipacionesType();
    }

    public AportesRealizadosType createAportesRealizadosType() {
        return new AportesRealizadosType();
    }

    public DataRespType createDataRespType() {
        return new DataRespType();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/DocumentosRepresentativosUnificada", name = "DocumentosRepresentativosUnificadaResponse")
    public JAXBElement<DocumentosRepresentativosUnificadaResponseType> createDocumentosRepresentativosUnificadaResponse(DocumentosRepresentativosUnificadaResponseType value) {
        return new JAXBElement<DocumentosRepresentativosUnificadaResponseType>(_DocumentosRepresentativosUnificadaResponse_QNAME, DocumentosRepresentativosUnificadaResponseType.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/xml/DocumentosRepresentativosUnificada", name = "DocumentosRepresentativosUnificada")
    public JAXBElement<DocumentosRepresentativosUnificadaType> createDocumentosRepresentativosUnificada(DocumentosRepresentativosUnificadaType value) {
        return new JAXBElement<DocumentosRepresentativosUnificadaType>(_DocumentosRepresentativosUnificada_QNAME, DocumentosRepresentativosUnificadaType.class, null, value);
    }
}
