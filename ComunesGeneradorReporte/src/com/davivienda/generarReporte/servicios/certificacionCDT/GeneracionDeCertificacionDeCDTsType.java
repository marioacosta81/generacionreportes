package com.davivienda.generarReporte.servicios.certificacionCDT;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneracionDeCertificacionDeCDTsType", propOrder = {"request"})
public class GeneracionDeCertificacionDeCDTsType
        implements Serializable {

    @XmlElement(name = "Request", required = true)
    protected RequestGeneracionDeCertificacionDeCDTs request;

    public RequestGeneracionDeCertificacionDeCDTs getRequest() {
        return this.request;
    }

    public void setRequest(RequestGeneracionDeCertificacionDeCDTs value) {
        this.request = value;
    }
}
