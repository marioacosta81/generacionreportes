package com.davivienda.generarReporte.servicios.consultaDivisas;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaDeDivisasType", propOrder = {"request"})
public class ConsultaDeDivisasType
        implements Serializable {

    @XmlElement(name = "Request", required = true)
    protected RequestConsultaDeDivisas request;

    public RequestConsultaDeDivisas getRequest() {
        return this.request;
    }

    public void setRequest(RequestConsultaDeDivisas value) {
        this.request = value;
    }
}
