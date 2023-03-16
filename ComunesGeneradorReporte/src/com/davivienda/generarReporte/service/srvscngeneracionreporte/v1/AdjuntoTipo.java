package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdjuntoTipo", propOrder = {"valNombre", "valContenido", "valTipo"})
public class AdjuntoTipo
        implements Serializable {

    @XmlElement(namespace = "", required = true)
    protected String valNombre;
    @XmlElement(namespace = "", required = true)
    protected String valContenido;
    @XmlElement(namespace = "", required = true)
    protected String valTipo;

    public String getValNombre() {
        return this.valNombre;
    }

    public void setValNombre(String value) {
        this.valNombre = value;
    }

    public String getValContenido() {
        return this.valContenido;
    }

    public void setValContenido(String value) {
        this.valContenido = value;
    }

    public String getValTipo() {
        return this.valTipo;
    }

    public void setValTipo(String value) {
        this.valTipo = value;
    }
}
