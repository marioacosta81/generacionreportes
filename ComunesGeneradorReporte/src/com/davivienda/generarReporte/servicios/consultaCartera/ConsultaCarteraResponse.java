package com.davivienda.generarReporte.servicios.consultaCartera;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaCarteraResponse", propOrder = {"result"})
public class ConsultaCarteraResponse
        implements Serializable {

    @XmlElement(required = true, nillable = true)
    protected RespuestaConsultaCarteraDto result;

    public RespuestaConsultaCarteraDto getResult() {
        return this.result;
    }

    public void setResult(RespuestaConsultaCarteraDto value) {
        this.result = value;
    }
}
