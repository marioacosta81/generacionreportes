package com.davivienda.generarReporte.servicios.certificacionCDT;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataResponseType", propOrder = {})
public class DataResponseType
        implements Serializable {

    @XmlElement(required = true)
    protected String serie;
    protected int numeroCertificado;
    protected short digitoDeChequeo;
    protected long numIdPrimerTitular;
    protected long numIdSegundoTitular;
    protected long numIdTercerTitular;
    protected short estadoCDT;
    protected short manejo;
    @XmlElement(required = true)
    protected String fechaDeExpedicion;
    @XmlElement(required = true)
    protected String fechaDeVencimiento;
    @XmlElement(required = true)
    protected String valorNominalInicial;
    protected short plazo;
    protected short tipoDePlazo;
    protected short periodicidadPagoIntereses;
    protected short modalidad;
    @XmlElement(required = true)
    protected String tasaEA;
    @XmlElement(required = true)
    protected String tasaNominal;
    protected short base;
    @XmlElement(required = true)
    protected String fechaInicioPeriodo;
    @XmlElement(required = true)
    protected String fechaProximoVencimiento;
    @XmlElement(required = true)
    protected String tasaDelPeriodo;
    @XmlElement(required = true)
    protected String tasaNominal1;
    @XmlElement(required = true)
    protected String intereses;
    @XmlElement(required = true)
    protected String rteFteCausada;
    @XmlElement(required = true)
    protected String valorNetoActual;
    @XmlElement(required = true)
    protected String observacion;
    protected long consecutivo;

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

    public long getNumIdPrimerTitular() {
        return this.numIdPrimerTitular;
    }

    public void setNumIdPrimerTitular(long value) {
        this.numIdPrimerTitular = value;
    }

    public long getNumIdSegundoTitular() {
        return this.numIdSegundoTitular;
    }

    public void setNumIdSegundoTitular(long value) {
        this.numIdSegundoTitular = value;
    }

    public long getNumIdTercerTitular() {
        return this.numIdTercerTitular;
    }

    public void setNumIdTercerTitular(long value) {
        this.numIdTercerTitular = value;
    }

    public short getEstadoCDT() {
        return this.estadoCDT;
    }

    public void setEstadoCDT(short value) {
        this.estadoCDT = value;
    }

    public short getManejo() {
        return this.manejo;
    }

    public void setManejo(short value) {
        this.manejo = value;
    }

    public String getFechaDeExpedicion() {
        return this.fechaDeExpedicion;
    }

    public void setFechaDeExpedicion(String value) {
        this.fechaDeExpedicion = value;
    }

    public String getFechaDeVencimiento() {
        return this.fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(String value) {
        this.fechaDeVencimiento = value;
    }

    public String getValorNominalInicial() {
        return this.valorNominalInicial;
    }

    public void setValorNominalInicial(String value) {
        this.valorNominalInicial = value;
    }

    public short getPlazo() {
        return this.plazo;
    }

    public void setPlazo(short value) {
        this.plazo = value;
    }

    public short getTipoDePlazo() {
        return this.tipoDePlazo;
    }

    public void setTipoDePlazo(short value) {
        this.tipoDePlazo = value;
    }

    public short getPeriodicidadPagoIntereses() {
        return this.periodicidadPagoIntereses;
    }

    public void setPeriodicidadPagoIntereses(short value) {
        this.periodicidadPagoIntereses = value;
    }

    public short getModalidad() {
        return this.modalidad;
    }

    public void setModalidad(short value) {
        this.modalidad = value;
    }

    public String getTasaEA() {
        return this.tasaEA;
    }

    public void setTasaEA(String value) {
        this.tasaEA = value;
    }

    public String getTasaNominal() {
        return this.tasaNominal;
    }

    public void setTasaNominal(String value) {
        this.tasaNominal = value;
    }

    public short getBase() {
        return this.base;
    }

    public void setBase(short value) {
        this.base = value;
    }

    public String getFechaInicioPeriodo() {
        return this.fechaInicioPeriodo;
    }

    public void setFechaInicioPeriodo(String value) {
        this.fechaInicioPeriodo = value;
    }

    public String getFechaProximoVencimiento() {
        return this.fechaProximoVencimiento;
    }

    public void setFechaProximoVencimiento(String value) {
        this.fechaProximoVencimiento = value;
    }

    public String getTasaDelPeriodo() {
        return this.tasaDelPeriodo;
    }

    public void setTasaDelPeriodo(String value) {
        this.tasaDelPeriodo = value;
    }

    public String getTasaNominal1() {
        return this.tasaNominal1;
    }

    public void setTasaNominal1(String value) {
        this.tasaNominal1 = value;
    }

    public String getIntereses() {
        return this.intereses;
    }

    public void setIntereses(String value) {
        this.intereses = value;
    }

    public String getRteFteCausada() {
        return this.rteFteCausada;
    }

    public void setRteFteCausada(String value) {
        this.rteFteCausada = value;
    }

    public String getValorNetoActual() {
        return this.valorNetoActual;
    }

    public void setValorNetoActual(String value) {
        this.valorNetoActual = value;
    }

    public String getObservacion() {
        return this.observacion;
    }

    public void setObservacion(String value) {
        this.observacion = value;
    }

    public long getConsecutivo() {
        return this.consecutivo;
    }

    public void setConsecutivo(long value) {
        this.consecutivo = value;
    }

    public String toString() {
        return "DataResponseType{serie=" + this.serie + ", numeroCertificado=" + this.numeroCertificado + ", digitoDeChequeo=" + this.digitoDeChequeo + ", numIdPrimerTitular=" + this.numIdPrimerTitular + ", numIdSegundoTitular=" + this.numIdSegundoTitular + ", numIdTercerTitular=" + this.numIdTercerTitular + ", estadoCDT=" + this.estadoCDT + ", manejo=" + this.manejo + ", fechaDeExpedicion=" + this.fechaDeExpedicion + ", fechaDeVencimiento=" + this.fechaDeVencimiento + ", valorNominalInicial=" + this.valorNominalInicial + ", plazo=" + this.plazo + ", tipoDePlazo=" + this.tipoDePlazo + ", periodicidadPagoIntereses=" + this.periodicidadPagoIntereses + ", modalidad=" + this.modalidad + ", tasaEA=" + this.tasaEA + ", tasaNominal=" + this.tasaNominal + ", base=" + this.base + ", fechaInicioPeriodo=" + this.fechaInicioPeriodo + ", fechaProximoVencimiento=" + this.fechaProximoVencimiento + ", tasaDelPeriodo=" + this.tasaDelPeriodo + ", tasaNominal1=" + this.tasaNominal1 + ", intereses=" + this.intereses + ", rteFteCausada=" + this.rteFteCausada + ", valorNetoActual=" + this.valorNetoActual + ", observacion=" + this.observacion + ", consecutivo=" + this.consecutivo + '}';
    }
}
