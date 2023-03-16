package com.davivienda.generarReporte.config.reporte;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Subproducto
        implements Serializable {

    @XmlAttribute
    protected String cod;
    @XmlElement
    protected String descProducto;
    @XmlElement
    protected String descProductoIngles;

    public String getCod() {
        return this.cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescProducto() {
        return this.descProducto;
    }

    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    public String getDescProductoIngles() {
        return this.descProductoIngles;
    }

    public void setDescProductoIngles(String descProductoIngles) {
        this.descProductoIngles = descProductoIngles;
    }
}
