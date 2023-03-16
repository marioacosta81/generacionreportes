package com.davivienda.generarReporte.servicios.certificacionCDT;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneracionDeCertificacionDeCDTsDataType", propOrder = {"serie", "numeroCertificado", "digitoDeChequeo"})
public class GeneracionDeCertificacionDeCDTsDataType
        implements Serializable {

    @XmlElement(required = true)
    protected String serie;
    protected int numeroCertificado;
    protected short digitoDeChequeo;

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String value) {
        this.serie = value;
    }

    public int getNumeroCertificado() {
        return this.numeroCertificado;
    }

    public void setNumeroCertificado(int value) {
        this.numeroCertificado = value;
    }

    public short getDigitoDeChequeo() {
        return this.digitoDeChequeo;
    }

    public void setDigitoDeChequeo(short value) {
        this.digitoDeChequeo = value;
    }

    public String toString() {
        return "GeneracionDeCertificacionDeCDTsDataType{serie=" + this.serie + ", numeroCertificado=" + this.numeroCertificado + ", digitoDeChequeo=" + this.digitoDeChequeo + '}';
    }
}
