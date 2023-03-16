package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Llave", propOrder = {"nombreLlave", "valorLlave"})
public class Llave
        implements Serializable {

    @XmlElement(required = true)
    protected String nombreLlave;
    @XmlElement(required = true)
    protected String valorLlave;

    public String getNombreLlave() {
        return this.nombreLlave;
    }

    public void setNombreLlave(String nombreLlave) {
        this.nombreLlave = nombreLlave;
    }

    public String getValorLlave() {
        return this.valorLlave;
    }

    public void setValorLlave(String valorLlave) {
        this.valorLlave = valorLlave;
    }
}
