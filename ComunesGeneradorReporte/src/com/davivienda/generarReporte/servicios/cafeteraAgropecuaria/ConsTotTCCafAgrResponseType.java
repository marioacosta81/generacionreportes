package com.davivienda.generarReporte.servicios.cafeteraAgropecuaria;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsTotTCCafAgrResponseType", propOrder = {"response"})
public class ConsTotTCCafAgrResponseType
        implements Serializable {

    @XmlElement(name = "Response", required = true)
    protected ResponseType response;

    public ResponseType getResponse() {
        return this.response;
    }

    public void setResponse(ResponseType value) {
        this.response = value;
    }
}
