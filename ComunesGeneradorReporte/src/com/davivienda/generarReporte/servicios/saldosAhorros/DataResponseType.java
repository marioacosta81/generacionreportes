package com.davivienda.generarReporte.servicios.saldosAhorros;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataResponseType", propOrder = {"numeroCuenta", "tipoIdentificacion", "numeroIdentificacion", "saldoTotal", "saldoDisponible", "saldoCanjeLocal", "saldoCanjePlaza", "saldoContingente", "saldoEmbargos", "saldoBolsillos"})
public class DataResponseType
        implements Serializable {

    protected long numeroCuenta;
    protected short tipoIdentificacion;
    protected long numeroIdentificacion;
    @XmlElement(required = true)
    protected BigDecimal saldoTotal;
    @XmlElement(required = true)
    protected BigDecimal saldoDisponible;
    @XmlElement(required = true)
    protected BigDecimal saldoCanjeLocal;
    @XmlElement(required = true)
    protected BigDecimal saldoCanjePlaza;
    @XmlElement(required = true)
    protected BigDecimal saldoContingente;
    @XmlElement(required = true)
    protected BigDecimal saldoEmbargos;
    @XmlElement(required = true)
    protected BigDecimal saldoBolsillos;

    public long getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(long value) {
        this.numeroCuenta = value;
    }

    public short getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }

    public void setTipoIdentificacion(short value) {
        this.tipoIdentificacion = value;
    }

    public long getNumeroIdentificacion() {
        return this.numeroIdentificacion;
    }

    public void setNumeroIdentificacion(long value) {
        this.numeroIdentificacion = value;
    }

    public BigDecimal getSaldoTotal() {
        return this.saldoTotal;
    }

    public void setSaldoTotal(BigDecimal value) {
        this.saldoTotal = value;
    }

    public BigDecimal getSaldoDisponible() {
        return this.saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal value) {
        this.saldoDisponible = value;
    }

    public BigDecimal getSaldoCanjeLocal() {
        return this.saldoCanjeLocal;
    }

    public void setSaldoCanjeLocal(BigDecimal value) {
        this.saldoCanjeLocal = value;
    }

    public BigDecimal getSaldoCanjePlaza() {
        return this.saldoCanjePlaza;
    }

    public void setSaldoCanjePlaza(BigDecimal value) {
        this.saldoCanjePlaza = value;
    }

    public BigDecimal getSaldoContingente() {
        return this.saldoContingente;
    }

    public void setSaldoContingente(BigDecimal value) {
        this.saldoContingente = value;
    }

    public BigDecimal getSaldoEmbargos() {
        return this.saldoEmbargos;
    }

    public void setSaldoEmbargos(BigDecimal value) {
        this.saldoEmbargos = value;
    }

    public BigDecimal getSaldoBolsillos() {
        return this.saldoBolsillos;
    }

    public void setSaldoBolsillos(BigDecimal value) {
        this.saldoBolsillos = value;
    }

    public String toString() {
        return "DataResponseType{numeroCuenta=" + this.numeroCuenta + ", tipoIdentificacion=" + this.tipoIdentificacion + ", numeroIdentificacion=" + this.numeroIdentificacion + ", saldoTotal=" + this.saldoTotal + ", saldoDisponible=" + this.saldoDisponible + ", saldoCanjeLocal=" + this.saldoCanjeLocal + ", saldoCanjePlaza=" + this.saldoCanjePlaza + ", saldoContingente=" + this.saldoContingente + ", saldoEmbargos=" + this.saldoEmbargos + ", saldoBolsillos=" + this.saldoBolsillos + '}';
    }
}
