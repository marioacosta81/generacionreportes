package com.davivienda.generarReporte.servicios.representativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentosRepresentativosUnificadaResponseType", propOrder = {"response"})
public class DocumentosRepresentativosUnificadaResponseType {

    @XmlElement(name = "Response", required = true)
    protected ResponseDocumentosRepresentativosUnificadaType response;

    public ResponseDocumentosRepresentativosUnificadaType getResponse() {
        return this.response;
    }

    public void setResponse(ResponseDocumentosRepresentativosUnificadaType value) {
        this.response = value;
    }
}
