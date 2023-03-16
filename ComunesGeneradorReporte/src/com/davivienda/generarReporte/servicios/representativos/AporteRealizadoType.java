package com.davivienda.generarReporte.servicios.representativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AporteRealizadoType", propOrder = {"fecFecha", "valAporte", "valNumeroUnidades", "valUnidad"})
public class AporteRealizadoType {

    @XmlElement(required = true)
    protected String fecFecha;
    @XmlElement(required = true)
    protected String valAporte;
    @XmlElement(required = true)
    protected String valNumeroUnidades;
    @XmlElement(required = true)
    protected String valUnidad;

    public String getFecFecha() {
        return this.fecFecha;
    }

    public void setFecFecha(String value) {
        this.fecFecha = value;
    }

    public String getValAporte() {
        return this.valAporte;
    }

    public void setValAporte(String value) {
        this.valAporte = value;
    }

    public String getValNumeroUnidades() {
        return this.valNumeroUnidades;
    }

    public void setValNumeroUnidades(String value) {
        this.valNumeroUnidades = value;
    }

    public String getValUnidad() {
        return this.valUnidad;
    }

    public void setValUnidad(String value) {
        this.valUnidad = value;
    }
}
