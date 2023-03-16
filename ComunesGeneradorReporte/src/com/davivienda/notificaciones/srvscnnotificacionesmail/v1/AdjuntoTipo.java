package com.davivienda.notificaciones.srvscnnotificacionesmail.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdjuntoTipo", propOrder = {"valNombre", "valContenido", "valTipo"})
public class AdjuntoTipo {

    @XmlElement(required = true)
    protected String valNombre;
    @XmlElement(required = true)
    protected byte[] valContenido;
    @XmlElement(required = true)
    protected String valTipo;

    public String getValNombre() {
        return this.valNombre;
    }

    public void setValNombre(String value) {
        this.valNombre = value;
    }

    public byte[] getValContenido() {
        return this.valContenido;
    }

    public void setValContenido(byte[] value) {
        this.valContenido = value;
    }

    public String getValTipo() {
        return this.valTipo;
    }

    public void setValTipo(String value) {
        this.valTipo = value;
    }
}
