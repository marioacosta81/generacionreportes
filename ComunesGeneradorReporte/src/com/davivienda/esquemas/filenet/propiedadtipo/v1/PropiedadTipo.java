package com.davivienda.esquemas.filenet.propiedadtipo.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropiedadTipo", propOrder = {"valLlave", "valValor"})
public class PropiedadTipo {

    @XmlElement(required = true)
    protected String valLlave;
    @XmlElement(required = true)
    protected String valValor;

    public String getValLlave() {
        return this.valLlave;
    }

    public void setValLlave(String value) {
        this.valLlave = value;
    }

    public String getValValor() {
        return this.valValor;
    }

    public void setValValor(String value) {
        this.valValor = value;
    }
}
