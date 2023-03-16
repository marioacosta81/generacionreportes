package com.davivienda.generarReporte.servicios.saldosAhorros;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataRequestType", propOrder = {"nroCuentaAhorros", "tipoDeCuenta", "banda", "clave"})
public class DataRequestType
        implements Serializable {

    protected long nroCuentaAhorros;
    protected short tipoDeCuenta;
    @XmlElement(required = true)
    protected String banda;
    @XmlElement(required = true)
    protected String clave;

    public long getNroCuentaAhorros() {
        return this.nroCuentaAhorros;
    }

    public void setNroCuentaAhorros(long value) {
        this.nroCuentaAhorros = value;
    }

    public short getTipoDeCuenta() {
        return this.tipoDeCuenta;
    }

    public void setTipoDeCuenta(short value) {
        this.tipoDeCuenta = value;
    }

    public String getBanda() {
        return this.banda;
    }

    public void setBanda(String value) {
        this.banda = value;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String value) {
        this.clave = value;
    }

    public String toString() {
        return "DataRequestType{nroCuentaAhorros=" + this.nroCuentaAhorros + ", tipoDeCuenta=" + this.tipoDeCuenta + ", banda=" + this.banda + ", clave=" + this.clave + '}';
    }
}
