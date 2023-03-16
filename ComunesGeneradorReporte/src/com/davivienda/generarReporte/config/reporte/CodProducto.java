package com.davivienda.generarReporte.config.reporte;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CodProducto
        implements Serializable {

    @XmlAttribute
    protected int cod;
    @XmlAttribute
    protected String nombre;
    @XmlAttribute
    protected String nombreIngles;
    @XmlElement
    protected List<Subproducto> subProducto;

    public int getCod() {
        return this.cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public List<Subproducto> getSubProducto() {
        return this.subProducto;
    }

    public void setSubProducto(List<Subproducto> subProducto) {
        this.subProducto = subProducto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreIngles() {
        return this.nombreIngles;
    }

    public void setNombreIngles(String nombreIngles) {
        this.nombreIngles = nombreIngles;
    }
}
