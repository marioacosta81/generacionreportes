package com.davivienda.generarReporte.servicios.consultaSaldosCredFecha;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaSaldosCredFechaCorteType", propOrder = {"request"})
public class ConsultaSaldosCredFechaCorteType
        implements Serializable {

    @XmlElement(name = "Request", required = true)
    protected RequestConsultaSaldosCredFechaCorte request;

    public RequestConsultaSaldosCredFechaCorte getRequest() {
        return this.request;
    }

    public void setRequest(RequestConsultaSaldosCredFechaCorte value) {
        this.request = value;
    }
}
