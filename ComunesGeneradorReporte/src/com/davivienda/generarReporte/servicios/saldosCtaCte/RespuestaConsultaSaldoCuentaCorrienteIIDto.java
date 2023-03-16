package com.davivienda.generarReporte.servicios.saldosCtaCte;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaConsultaSaldoCuentaCorrienteIIDto", propOrder = {"cuenta", "diasSobregiro", "disponible", "disponibleRemesas", "disponibleSobregiro", "indicadorMulticuenta", "interesSobregiro", "numeroCupoSobregiro", "numeroDiasMoraSobregiro", "saldoCanje", "saldoCanjePlaza", "saldoCongeladoPorEmbargo", "saldoTotal", "signoDisponible", "signoSaldoTotal", "usadoRemesas"})
public class RespuestaConsultaSaldoCuentaCorrienteIIDto
        extends RespuestaDeTransaccionBaseDTO {

    protected String cuenta;
    protected Integer diasSobregiro;
    protected BigDecimal disponible;
    protected BigDecimal disponibleRemesas;
    protected BigDecimal disponibleSobregiro;
    protected Short indicadorMulticuenta;
    protected BigDecimal interesSobregiro;
    protected Long numeroCupoSobregiro;
    protected Short numeroDiasMoraSobregiro;
    protected BigDecimal saldoCanje;
    protected BigDecimal saldoCanjePlaza;
    protected BigDecimal saldoCongeladoPorEmbargo;
    protected BigDecimal saldoTotal;
    protected String signoDisponible;
    protected String signoSaldoTotal;
    protected BigDecimal usadoRemesas;

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String value) {
        this.cuenta = value;
    }

    public Integer getDiasSobregiro() {
        return this.diasSobregiro;
    }

    public void setDiasSobregiro(Integer value) {
        this.diasSobregiro = value;
    }

    public BigDecimal getDisponible() {
        return this.disponible;
    }

    public void setDisponible(BigDecimal value) {
        this.disponible = value;
    }

    public BigDecimal getDisponibleRemesas() {
        return this.disponibleRemesas;
    }

    public void setDisponibleRemesas(BigDecimal value) {
        this.disponibleRemesas = value;
    }

    public BigDecimal getDisponibleSobregiro() {
        return this.disponibleSobregiro;
    }

    public void setDisponibleSobregiro(BigDecimal value) {
        this.disponibleSobregiro = value;
    }

    public Short getIndicadorMulticuenta() {
        return this.indicadorMulticuenta;
    }

    public void setIndicadorMulticuenta(Short value) {
        this.indicadorMulticuenta = value;
    }

    public BigDecimal getInteresSobregiro() {
        return this.interesSobregiro;
    }

    public void setInteresSobregiro(BigDecimal value) {
        this.interesSobregiro = value;
    }

    public Long getNumeroCupoSobregiro() {
        return this.numeroCupoSobregiro;
    }

    public void setNumeroCupoSobregiro(Long value) {
        this.numeroCupoSobregiro = value;
    }

    public Short getNumeroDiasMoraSobregiro() {
        return this.numeroDiasMoraSobregiro;
    }

    public void setNumeroDiasMoraSobregiro(Short value) {
        this.numeroDiasMoraSobregiro = value;
    }

    public BigDecimal getSaldoCanje() {
        return this.saldoCanje;
    }

    public void setSaldoCanje(BigDecimal value) {
        this.saldoCanje = value;
    }

    public BigDecimal getSaldoCanjePlaza() {
        return this.saldoCanjePlaza;
    }

    public void setSaldoCanjePlaza(BigDecimal value) {
        this.saldoCanjePlaza = value;
    }

    public BigDecimal getSaldoCongeladoPorEmbargo() {
        return this.saldoCongeladoPorEmbargo;
    }

    public void setSaldoCongeladoPorEmbargo(BigDecimal value) {
        this.saldoCongeladoPorEmbargo = value;
    }

    public BigDecimal getSaldoTotal() {
        return this.saldoTotal;
    }

    public void setSaldoTotal(BigDecimal value) {
        this.saldoTotal = value;
    }

    public String getSignoDisponible() {
        return this.signoDisponible;
    }

    public void setSignoDisponible(String value) {
        this.signoDisponible = value;
    }

    public String getSignoSaldoTotal() {
        return this.signoSaldoTotal;
    }

    public void setSignoSaldoTotal(String value) {
        this.signoSaldoTotal = value;
    }

    public BigDecimal getUsadoRemesas() {
        return this.usadoRemesas;
    }

    public void setUsadoRemesas(BigDecimal value) {
        this.usadoRemesas = value;
    }
}
