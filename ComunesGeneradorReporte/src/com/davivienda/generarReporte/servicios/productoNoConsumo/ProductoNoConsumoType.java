package com.davivienda.generarReporte.servicios.productoNoConsumo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductoNoConsumoType", propOrder = {})
public class ProductoNoConsumoType {

    @XmlElement(required = true, nillable = true)
    protected String numeroDeProducto;
    protected int diasMora;
    protected int fechaSaldo;
    @XmlElement(required = true)
    protected BigDecimal valorSaldo;
    protected int fechaMora;
    @XmlElement(required = true)
    protected BigDecimal valorMora;
    protected int fechaCuota;
    @XmlElement(required = true)
    protected BigDecimal valorCuota;
    @XmlElement(required = true)
    protected BigDecimal valorPorAplicar;
    @XmlElement(required = true)
    protected BigDecimal valorCanje;
    @XmlElement(required = true, nillable = true)
    protected String indicadorLink;
    @XmlElement(required = true)
    protected BigDecimal valorCupoDisponibleCx;
    @XmlElement(required = true)
    protected BigDecimal valorAprobado;

    public String getNumeroDeProducto() {
        return this.numeroDeProducto;
    }

    public void setNumeroDeProducto(String value) {
        this.numeroDeProducto = value;
    }

    public int getDiasMora() {
        return this.diasMora;
    }

    public void setDiasMora(int value) {
        this.diasMora = value;
    }

    public int getFechaSaldo() {
        return this.fechaSaldo;
    }

    public void setFechaSaldo(int value) {
        this.fechaSaldo = value;
    }

    public BigDecimal getValorSaldo() {
        return this.valorSaldo;
    }

    public void setValorSaldo(BigDecimal value) {
        this.valorSaldo = value;
    }

    public int getFechaMora() {
        return this.fechaMora;
    }

    public void setFechaMora(int value) {
        this.fechaMora = value;
    }

    public BigDecimal getValorMora() {
        return this.valorMora;
    }

    public void setValorMora(BigDecimal value) {
        this.valorMora = value;
    }

    public int getFechaCuota() {
        return this.fechaCuota;
    }

    public void setFechaCuota(int value) {
        this.fechaCuota = value;
    }

    public BigDecimal getValorCuota() {
        return this.valorCuota;
    }

    public void setValorCuota(BigDecimal value) {
        this.valorCuota = value;
    }

    public BigDecimal getValorPorAplicar() {
        return this.valorPorAplicar;
    }

    public void setValorPorAplicar(BigDecimal value) {
        this.valorPorAplicar = value;
    }

    public BigDecimal getValorCanje() {
        return this.valorCanje;
    }

    public void setValorCanje(BigDecimal value) {
        this.valorCanje = value;
    }

    public String getIndicadorLink() {
        return this.indicadorLink;
    }

    public void setIndicadorLink(String value) {
        this.indicadorLink = value;
    }

    public BigDecimal getValorCupoDisponibleCx() {
        return this.valorCupoDisponibleCx;
    }

    public void setValorCupoDisponibleCx(BigDecimal value) {
        this.valorCupoDisponibleCx = value;
    }

    public BigDecimal getValorAprobado() {
        return this.valorAprobado;
    }

    public void setValorAprobado(BigDecimal value) {
        this.valorAprobado = value;
    }
}
