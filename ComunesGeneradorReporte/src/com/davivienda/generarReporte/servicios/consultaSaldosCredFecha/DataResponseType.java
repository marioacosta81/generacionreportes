package com.davivienda.generarReporte.servicios.consultaSaldosCredFecha;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataResponseType", propOrder = {})
public class DataResponseType
        implements Serializable {

    @XmlElement(required = true)
    protected String numeroDeProducto;
    protected short tipoIdentificacion;
    protected long numeroIdentificacion;
    protected int fechaCorte;
    @XmlElement(required = true)
    protected String valor1;
    protected int fechaInicio;
    @XmlElement(required = true)
    protected String valor2;
    protected int plazo;
    @XmlElement(required = true)
    protected BigDecimal tasaInteres;
    @XmlElement(required = true)
    protected BigDecimal tasaIntMora;
    protected short vigencia;
    @XmlElement(required = true)
    protected String estado;
    @XmlElement(required = true)
    protected String tipoCredito;

    public String getNumeroDeProducto() {
        return this.numeroDeProducto;
    }

    public void setNumeroDeProducto(String value) {
        this.numeroDeProducto = value;
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

    public int getFechaCorte() {
        return this.fechaCorte;
    }

    public void setFechaCorte(int value) {
        this.fechaCorte = value;
    }

    public String getValor1() {
        return this.valor1;
    }

    public void setValor1(String value) {
        this.valor1 = value;
    }

    public int getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(int value) {
        this.fechaInicio = value;
    }

    public String getValor2() {
        return this.valor2;
    }

    public void setValor2(String value) {
        this.valor2 = value;
    }

    public int getPlazo() {
        return this.plazo;
    }

    public void setPlazo(int value) {
        this.plazo = value;
    }

    public BigDecimal getTasaInteres() {
        return this.tasaInteres;
    }

    public void setTasaInteres(BigDecimal value) {
        this.tasaInteres = value;
    }

    public BigDecimal getTasaIntMora() {
        return this.tasaIntMora;
    }

    public void setTasaIntMora(BigDecimal value) {
        this.tasaIntMora = value;
    }

    public short getVigencia() {
        return this.vigencia;
    }

    public void setVigencia(short value) {
        this.vigencia = value;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String value) {
        this.estado = value;
    }

    public String getTipoCredito() {
        return this.tipoCredito;
    }

    public void setTipoCredito(String value) {
        this.tipoCredito = value;
    }

    public String toString() {
        return "DataResponseType{numeroDeProducto=" + this.numeroDeProducto + ", tipoIdentificacion=" + this.tipoIdentificacion + ", numeroIdentificacion=" + this.numeroIdentificacion + ", fechaCorte=" + this.fechaCorte + ", valor1=" + this.valor1 + ", fechaInicio=" + this.fechaInicio + ", valor2=" + this.valor2 + ", plazo=" + this.plazo + ", tasaInteres=" + this.tasaInteres + ", tasaIntMora=" + this.tasaIntMora + ", vigencia=" + this.vigencia + ", estado=" + this.estado + ", tipoCredito=" + this.tipoCredito + '}';
    }
}
