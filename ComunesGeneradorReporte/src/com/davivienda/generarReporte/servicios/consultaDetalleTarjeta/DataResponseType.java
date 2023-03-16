package com.davivienda.generarReporte.servicios.consultaDetalleTarjeta;

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
    protected String nombreProducto;
    protected int oficinaRadicacion;
    protected int fechaEmision;
    @XmlElement(required = true)
    protected String convenio;
    @XmlElement(required = true)
    protected String cicloFacturacion;
    protected int fechaFacturacion;
    protected int fechaUltimoBloqueo;
    protected long amparadaPor;
    @XmlElement(required = true)
    protected String codigoBloqueo;
    protected short indDebitoAutomatico;
    protected long ctaDebitoAutomatico;
    protected long vrAutorizacionesPend;
    protected long cupoGlobal;
    protected long saldoHoy;
    protected long saldoMora;
    protected long saldoFavor;
    protected long valorSobrecupo;
    protected short diasRealesMora;
    protected int fechaUltimoPago;
    protected long valorCupoTotal;
    protected long valorTotal;

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String value) {
        this.nombreProducto = value;
    }

    public int getOficinaRadicacion() {
        return this.oficinaRadicacion;
    }

    public void setOficinaRadicacion(int value) {
        this.oficinaRadicacion = value;
    }

    public int getFechaEmision() {
        return this.fechaEmision;
    }

    public void setFechaEmision(int value) {
        this.fechaEmision = value;
    }

    public String getConvenio() {
        return this.convenio;
    }

    public void setConvenio(String value) {
        this.convenio = value;
    }

    public String getCicloFacturacion() {
        return this.cicloFacturacion;
    }

    public void setCicloFacturacion(String value) {
        this.cicloFacturacion = value;
    }

    public int getFechaFacturacion() {
        return this.fechaFacturacion;
    }

    public void setFechaFacturacion(int value) {
        this.fechaFacturacion = value;
    }

    public int getFechaUltimoBloqueo() {
        return this.fechaUltimoBloqueo;
    }

    public void setFechaUltimoBloqueo(int value) {
        this.fechaUltimoBloqueo = value;
    }

    public long getAmparadaPor() {
        return this.amparadaPor;
    }

    public void setAmparadaPor(long value) {
        this.amparadaPor = value;
    }

    public String getCodigoBloqueo() {
        return this.codigoBloqueo;
    }

    public void setCodigoBloqueo(String value) {
        this.codigoBloqueo = value;
    }

    public short getIndDebitoAutomatico() {
        return this.indDebitoAutomatico;
    }

    public void setIndDebitoAutomatico(short value) {
        this.indDebitoAutomatico = value;
    }

    public long getCtaDebitoAutomatico() {
        return this.ctaDebitoAutomatico;
    }

    public void setCtaDebitoAutomatico(long value) {
        this.ctaDebitoAutomatico = value;
    }

    public long getVrAutorizacionesPend() {
        return this.vrAutorizacionesPend;
    }

    public void setVrAutorizacionesPend(long value) {
        this.vrAutorizacionesPend = value;
    }

    public long getCupoGlobal() {
        return this.cupoGlobal;
    }

    public void setCupoGlobal(long value) {
        this.cupoGlobal = value;
    }

    public long getSaldoHoy() {
        return this.saldoHoy;
    }

    public void setSaldoHoy(long value) {
        this.saldoHoy = value;
    }

    public long getSaldoMora() {
        return this.saldoMora;
    }

    public void setSaldoMora(long value) {
        this.saldoMora = value;
    }

    public long getSaldoFavor() {
        return this.saldoFavor;
    }

    public void setSaldoFavor(long value) {
        this.saldoFavor = value;
    }

    public long getValorSobrecupo() {
        return this.valorSobrecupo;
    }

    public void setValorSobrecupo(long value) {
        this.valorSobrecupo = value;
    }

    public short getDiasRealesMora() {
        return this.diasRealesMora;
    }

    public void setDiasRealesMora(short value) {
        this.diasRealesMora = value;
    }

    public int getFechaUltimoPago() {
        return this.fechaUltimoPago;
    }

    public void setFechaUltimoPago(int value) {
        this.fechaUltimoPago = value;
    }

    public long getValorCupoTotal() {
        return this.valorCupoTotal;
    }

    public void setValorCupoTotal(long value) {
        this.valorCupoTotal = value;
    }

    public long getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(long value) {
        this.valorTotal = value;
    }

    public String toString() {
        return "DataResponseType{nombreProducto=" + this.nombreProducto + ", oficinaRadicacion=" + this.oficinaRadicacion + ", fechaEmision=" + this.fechaEmision + ", convenio=" + this.convenio + ", cicloFacturacion=" + this.cicloFacturacion + ", fechaFacturacion=" + this.fechaFacturacion + ", fechaUltimoBloqueo=" + this.fechaUltimoBloqueo + ", amparadaPor=" + this.amparadaPor + ", codigoBloqueo=" + this.codigoBloqueo + ", indDebitoAutomatico=" + this.indDebitoAutomatico + ", ctaDebitoAutomatico=" + this.ctaDebitoAutomatico + ", vrAutorizacionesPend=" + this.vrAutorizacionesPend + ", cupoGlobal=" + this.cupoGlobal + ", saldoHoy=" + this.saldoHoy + ", saldoMora=" + this.saldoMora + ", saldoFavor=" + this.saldoFavor + ", valorSobrecupo=" + this.valorSobrecupo + ", diasRealesMora=" + this.diasRealesMora + ", fechaUltimoPago=" + this.fechaUltimoPago + ", valorCupoTotal=" + this.valorCupoTotal + ", valorTotal=" + this.valorTotal + '}';
    }
}
