package com.davivienda.generarReporte.servicios.certificacionCDT;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneracionDeCertificacionDeCDTsResponseType", propOrder = {"response"})
public class GeneracionDeCertificacionDeCDTsResponseType
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
