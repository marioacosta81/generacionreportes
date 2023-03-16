package com.davivienda.generarReporte.servicios.cafeteraAgropecuaria;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsTotTCCafAgrRequestType", propOrder = {"request"})
public class ConsTotTCCafAgrRequestType
        implements Serializable {

    @XmlElement(name = "Request", required = true)
    protected RequestType request;

    public RequestType getRequest() {
        return this.request;
    }

    public void setRequest(RequestType value) {
        this.request = value;
    }
}
