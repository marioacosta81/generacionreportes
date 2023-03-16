package com.davivienda.notificaciones.srvscnnotificacionesmail.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParametroPlantillaTipo", propOrder = {"valNombre", "valValor"})
public class ParametroPlantillaTipo
        implements Serializable {

    @XmlElement(required = true)
    protected String valNombre;
    @XmlElement(required = true)
    protected String valValor;

    public String getValNombre() {
        return this.valNombre;
    }

    public void setValNombre(String value) {
        this.valNombre = value;
    }

    public String getValValor() {
        return this.valValor;
    }

    public void setValValor(String value) {
        this.valValor = value;
    }
}
