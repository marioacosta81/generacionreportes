package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReporteType", propOrder = {"tipoCertificacion", "ciudadEmision", "tituloPersonal", "dirigidoA", "formato"})
public class ReporteType
        implements Serializable {

    @XmlElement(required = true)
    protected String tipoCertificacion;
    @XmlElement(required = true)
    protected String ciudadEmision;
    @XmlElement(required = true)
    protected String tituloPersonal;
    @XmlElement(required = true)
    protected String dirigidoA;
    @XmlElement(required = true)
    protected String formato;

    public String getTipoCertificacion() {
        return this.tipoCertificacion;
    }

    public void setTipoCertificacion(String value) {
        this.tipoCertificacion = value;
    }

    public String getCiudadEmision() {
        return this.ciudadEmision;
    }

    public void setCiudadEmision(String value) {
        this.ciudadEmision = value;
    }

    public String getTituloPersonal() {
        return this.tituloPersonal;
    }

    public void setTituloPersonal(String value) {
        this.tituloPersonal = value;
    }

    public String getDirigidoA() {
        return this.dirigidoA;
    }

    public void setDirigidoA(String value) {
        this.dirigidoA = value;
    }

    public String getFormato() {
        return this.formato;
    }

    public void setFormato(String value) {
        this.formato = value;
    }
}
