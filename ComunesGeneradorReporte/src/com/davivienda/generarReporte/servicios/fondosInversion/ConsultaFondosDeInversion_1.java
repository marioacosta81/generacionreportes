package com.davivienda.generarReporte.servicios.fondosInversion;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaFondosDeInversion_1", propOrder = {"request"})
public class ConsultaFondosDeInversion_1
        implements Serializable {

    @XmlElement(name = "Request", required = true)
    protected RequestConsultaFondosDeInversion request;

    public RequestConsultaFondosDeInversion getRequest() {
        return this.request;
    }

    public void setRequest(RequestConsultaFondosDeInversion value) {
        this.request = value;
    }
}
