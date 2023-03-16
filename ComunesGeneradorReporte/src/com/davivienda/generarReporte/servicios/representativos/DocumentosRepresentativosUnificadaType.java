package com.davivienda.generarReporte.servicios.representativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentosRepresentativosUnificadaType", propOrder = {"request"})
public class DocumentosRepresentativosUnificadaType {

    @XmlElement(name = "Request", required = true)
    protected RequestDocumentosRepresentativosUnificadaType request;

    public RequestDocumentosRepresentativosUnificadaType getRequest() {
        return this.request;
    }

    public void setRequest(RequestDocumentosRepresentativosUnificadaType value) {
        this.request = value;
    }
}
