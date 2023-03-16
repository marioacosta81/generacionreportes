package com.davivienda.generarReporte.servicios.cafeteraAgropecuaria;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataType", propOrder = {"nroTarjeta"})
public class DataType
        implements Serializable {

    @XmlElement(required = true)
    protected String nroTarjeta;

    public String getNroTarjeta() {
        return this.nroTarjeta;
    }

    public void setNroTarjeta(String value) {
        this.nroTarjeta = value;
    }
}
