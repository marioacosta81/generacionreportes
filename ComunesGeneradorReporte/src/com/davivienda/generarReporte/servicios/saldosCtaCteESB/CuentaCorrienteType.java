package com.davivienda.generarReporte.servicios.saldosCtaCteESB;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CuentaCorrienteType", propOrder = {})
public class CuentaCorrienteType
        implements Serializable {

    @XmlElement(required = true)
    protected BigDecimal saldoDisponible;
    @XmlElement(required = true)
    protected BigDecimal saldoEnCanje;
    @XmlElement(required = true)
    protected BigDecimal saldoEnCanjePlaza;
    @XmlElement(required = true)
    protected BigDecimal disponibleSobregiro;
    @XmlElement(required = true)
    protected BigDecimal interesSobregiro;
    protected int diasSobregiro;
    @XmlElement(required = true, nillable = true)
    protected String cuenta;
    @XmlElement(required = true)
    protected BigDecimal saldoTotal;
    @XmlElement(required = true)
    protected BigDecimal usadoRemesas;
    @XmlElement(required = true)
    protected BigDecimal disponibleRemesas;
    @XmlElement(required = true)
    protected BigDecimal saldoCongeladoPorEmbargo;
    protected long numeroDeCupoDeSobregiro;
    protected int numeroDiasMoraSobregiro;
    protected short indicadorDeMulticuenta;

    public BigDecimal getSaldoDisponible() {
        return this.saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal value) {
        this.saldoDisponible = value;
    }

    public BigDecimal getSaldoEnCanje() {
        return this.saldoEnCanje;
    }

    public void setSaldoEnCanje(BigDecimal value) {
        this.saldoEnCanje = value;
    }

    public BigDecimal getSaldoEnCanjePlaza() {
        return this.saldoEnCanjePlaza;
    }

    public void setSaldoEnCanjePlaza(BigDecimal value) {
        this.saldoEnCanjePlaza = value;
    }

    public BigDecimal getDisponibleSobregiro() {
        return this.disponibleSobregiro;
    }

    public void setDisponibleSobregiro(BigDecimal value) {
        this.disponibleSobregiro = value;
    }

    public BigDecimal getInteresSobregiro() {
        return this.interesSobregiro;
    }

    public void setInteresSobregiro(BigDecimal value) {
        this.interesSobregiro = value;
    }

    public int getDiasSobregiro() {
        return this.diasSobregiro;
    }

    public void setDiasSobregiro(int value) {
        this.diasSobregiro = value;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String value) {
        this.cuenta = value;
    }

    public BigDecimal getSaldoTotal() {
        return this.saldoTotal;
    }

    public void setSaldoTotal(BigDecimal value) {
        this.saldoTotal = value;
    }

    public BigDecimal getUsadoRemesas() {
        return this.usadoRemesas;
    }

    public void setUsadoRemesas(BigDecimal value) {
        this.usadoRemesas = value;
    }

    public BigDecimal getDisponibleRemesas() {
        return this.disponibleRemesas;
    }

    public void setDisponibleRemesas(BigDecimal value) {
        this.disponibleRemesas = value;
    }

    public BigDecimal getSaldoCongeladoPorEmbargo() {
        return this.saldoCongeladoPorEmbargo;
    }

    public void setSaldoCongeladoPorEmbargo(BigDecimal value) {
        this.saldoCongeladoPorEmbargo = value;
    }

    public long getNumeroDeCupoDeSobregiro() {
        return this.numeroDeCupoDeSobregiro;
    }

    public void setNumeroDeCupoDeSobregiro(long value) {
        this.numeroDeCupoDeSobregiro = value;
    }

    public int getNumeroDiasMoraSobregiro() {
        return this.numeroDiasMoraSobregiro;
    }

    public void setNumeroDiasMoraSobregiro(int value) {
        this.numeroDiasMoraSobregiro = value;
    }

    public short getIndicadorDeMulticuenta() {
        return this.indicadorDeMulticuenta;
    }

    public void setIndicadorDeMulticuenta(short value) {
        this.indicadorDeMulticuenta = value;
    }
}
