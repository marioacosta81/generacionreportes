package com.davivienda.generarReporte.servicios.saldosCtaCteESB;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaSaldosCuentaCorrienteType", propOrder = {"request"})
public class ConsultaSaldosCuentaCorrienteType
        implements Serializable {

    @XmlElement(name = "Request", required = true)
    protected RequestConsultaSaldosCuentaCorriente request;

    public RequestConsultaSaldosCuentaCorriente getRequest() {
        return this.request;
    }

    public void setRequest(RequestConsultaSaldosCuentaCorriente value) {
        this.request = value;
    }
}
