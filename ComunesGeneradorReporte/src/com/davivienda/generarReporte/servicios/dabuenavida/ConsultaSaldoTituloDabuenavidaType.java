package com.davivienda.generarReporte.servicios.dabuenavida;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaSaldoTituloDabuenavidaType", propOrder = {"request"})
public class ConsultaSaldoTituloDabuenavidaType
        implements Serializable {

    @XmlElement(name = "Request", required = true)
    protected RequestConsultaSaldoTituloDabuenavida request;

    public RequestConsultaSaldoTituloDabuenavida getRequest() {
        return this.request;
    }

    public void setRequest(RequestConsultaSaldoTituloDabuenavida value) {
        this.request = value;
    }
}
