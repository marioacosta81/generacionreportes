package com.davivienda.generarReporte.servicios.dabuenavida;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TituloDabuenavidaType", propOrder = {})
public class TituloDabuenavidaType
        implements Serializable {

    @XmlElement(required = true)
    protected BigDecimal saldoTotal;
    @XmlElement(required = true)
    protected BigDecimal saldoDisponibleParaRetiroParcial;
    @XmlElement(required = true)
    protected BigDecimal saldoParaCancelacion;
    @XmlElement(required = true, nillable = true)
    protected String indicadorDeClausula;
    @XmlElement(required = true, nillable = true)
    protected String nombres;
    @XmlElement(required = true, nillable = true)
    protected String primerApellido;
    @XmlElement(required = true, nillable = true)
    protected String segundoApellido;
    protected long numeroIdentificacion;
    protected short tipoIdentificacion;
    @XmlElement(required = true)
    protected BigDecimal valorCuotaMensual;
    @XmlElement(required = true)
    protected BigDecimal premioPorElQueJugo;
    @XmlElement(required = true, nillable = true)
    protected String posicionEnLaQueJugo;
    @XmlElement(required = true, nillable = true)
    protected String posicionGanadora;
    protected short numeroDeMesesTranscurridos;
    protected short vigencia;
    @XmlElement(required = true)
    protected BigDecimal upacMonto;
    @XmlElement(required = true)
    protected BigDecimal costoAdministracion;
    @XmlElement(required = true)
    protected BigDecimal cuotaInicial;
    @XmlElement(required = true, nillable = true)
    protected String fechaDeVenta;
    @XmlElement(required = true, nillable = true)
    protected String fechaDeApertura;
    protected long cuenta;
    @XmlElement(required = true, nillable = true)
    protected String fechaPosicionCliente;
    @XmlElement(required = true, nillable = true)
    protected String fechaPosicionGanadora;

    public BigDecimal getSaldoTotal() {
        return this.saldoTotal;
    }

    public void setSaldoTotal(BigDecimal value) {
        this.saldoTotal = value;
    }

    public BigDecimal getSaldoDisponibleParaRetiroParcial() {
        return this.saldoDisponibleParaRetiroParcial;
    }

    public void setSaldoDisponibleParaRetiroParcial(BigDecimal value) {
        this.saldoDisponibleParaRetiroParcial = value;
    }

    public BigDecimal getSaldoParaCancelacion() {
        return this.saldoParaCancelacion;
    }

    public void setSaldoParaCancelacion(BigDecimal value) {
        this.saldoParaCancelacion = value;
    }

    public String getIndicadorDeClausula() {
        return this.indicadorDeClausula;
    }

    public void setIndicadorDeClausula(String value) {
        this.indicadorDeClausula = value;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String value) {
        this.nombres = value;
    }

    public String getPrimerApellido() {
        return this.primerApellido;
    }

    public void setPrimerApellido(String value) {
        this.primerApellido = value;
    }

    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    public void setSegundoApellido(String value) {
        this.segundoApellido = value;
    }

    public long getNumeroIdentificacion() {
        return this.numeroIdentificacion;
    }

    public void setNumeroIdentificacion(long value) {
        this.numeroIdentificacion = value;
    }

    public short getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }

    public void setTipoIdentificacion(short value) {
        this.tipoIdentificacion = value;
    }

    public BigDecimal getValorCuotaMensual() {
        return this.valorCuotaMensual;
    }

    public void setValorCuotaMensual(BigDecimal value) {
        this.valorCuotaMensual = value;
    }

    public BigDecimal getPremioPorElQueJugo() {
        return this.premioPorElQueJugo;
    }

    public void setPremioPorElQueJugo(BigDecimal value) {
        this.premioPorElQueJugo = value;
    }

    public String getPosicionEnLaQueJugo() {
        return this.posicionEnLaQueJugo;
    }

    public void setPosicionEnLaQueJugo(String value) {
        this.posicionEnLaQueJugo = value;
    }

    public String getPosicionGanadora() {
        return this.posicionGanadora;
    }

    public void setPosicionGanadora(String value) {
        this.posicionGanadora = value;
    }

    public short getNumeroDeMesesTranscurridos() {
        return this.numeroDeMesesTranscurridos;
    }

    public void setNumeroDeMesesTranscurridos(short value) {
        this.numeroDeMesesTranscurridos = value;
    }

    public short getVigencia() {
        return this.vigencia;
    }

    public void setVigencia(short value) {
        this.vigencia = value;
    }

    public BigDecimal getUpacMonto() {
        return this.upacMonto;
    }

    public void setUpacMonto(BigDecimal value) {
        this.upacMonto = value;
    }

    public BigDecimal getCostoAdministracion() {
        return this.costoAdministracion;
    }

    public void setCostoAdministracion(BigDecimal value) {
        this.costoAdministracion = value;
    }

    public BigDecimal getCuotaInicial() {
        return this.cuotaInicial;
    }

    public void setCuotaInicial(BigDecimal value) {
        this.cuotaInicial = value;
    }

    public String getFechaDeVenta() {
        return this.fechaDeVenta;
    }

    public void setFechaDeVenta(String value) {
        this.fechaDeVenta = value;
    }

    public String getFechaDeApertura() {
        return this.fechaDeApertura;
    }

    public void setFechaDeApertura(String value) {
        this.fechaDeApertura = value;
    }

    public long getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(long value) {
        this.cuenta = value;
    }

    public String getFechaPosicionCliente() {
        return this.fechaPosicionCliente;
    }

    public void setFechaPosicionCliente(String value) {
        this.fechaPosicionCliente = value;
    }

    public String getFechaPosicionGanadora() {
        return this.fechaPosicionGanadora;
    }

    public void setFechaPosicionGanadora(String value) {
        this.fechaPosicionGanadora = value;
    }

    public String toString() {
        return "TituloDabuenavidaType{saldoTotal=" + this.saldoTotal + ", saldoDisponibleParaRetiroParcial=" + this.saldoDisponibleParaRetiroParcial + ", saldoParaCancelacion=" + this.saldoParaCancelacion + ", indicadorDeClausula=" + this.indicadorDeClausula + ", nombres=" + this.nombres + ", primerApellido=" + this.primerApellido + ", segundoApellido=" + this.segundoApellido + ", numeroIdentificacion=" + this.numeroIdentificacion + ", tipoIdentificacion=" + this.tipoIdentificacion + ", valorCuotaMensual=" + this.valorCuotaMensual + ", premioPorElQueJugo=" + this.premioPorElQueJugo + ", posicionEnLaQueJugo=" + this.posicionEnLaQueJugo + ", posicionGanadora=" + this.posicionGanadora + ", numeroDeMesesTranscurridos=" + this.numeroDeMesesTranscurridos + ", vigencia=" + this.vigencia + ", upacMonto=" + this.upacMonto + ", costoAdministracion=" + this.costoAdministracion + ", cuotaInicial=" + this.cuotaInicial + ", fechaDeVenta=" + this.fechaDeVenta + ", fechaDeApertura=" + this.fechaDeApertura + ", cuenta=" + this.cuenta + ", fechaPosicionCliente=" + this.fechaPosicionCliente + ", fechaPosicionGanadora=" + this.fechaPosicionGanadora + '}';
    }
}
