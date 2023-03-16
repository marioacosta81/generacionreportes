package com.davivienda.generarReporte.servicios.cafeteraAgropecuaria;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataRespType", propOrder = {"cupoDisponible", "disponibleAvance", "pagTotCarteraEnPesos", "pagMinCarteraEnPesos", "fechaPagoMinimo", "diasDeMora", "pagTotCartUSDEnPesos", "pagMinCartUSDEnPesos", "pagTotCartUSDEnUSD", "pagMinCartUSDEnUSD", "davipuntos", "indicadorDeCartera", "compania", "estado", "fechaDeCorte", "suproducto", "codConvenioLibranza", "nitEmpresaDeLibranza", "nombEmpresaDeLibranza", "valrsPagPorAnticipado", "davipuntosProxAVencer", "fechaVencimientoPuntos", "fechaVencimientoCupo", "franquicia", "fechaVencPlastico", "valorEnMora", "tasaDeCambio", "frecuenciaInteres", "frecuenciaCapital", "plazo", "fechaProxFactCapital", "fechaProxFactInteres", "indSistAmortFlexible"})
public class DataRespType
        implements Serializable {

    @XmlElement(required = true)
    protected BigDecimal cupoDisponible;
    @XmlElement(required = true)
    protected BigDecimal disponibleAvance;
    @XmlElement(required = true)
    protected BigDecimal pagTotCarteraEnPesos;
    @XmlElement(required = true)
    protected BigDecimal pagMinCarteraEnPesos;
    @XmlElement(required = true)
    protected String fechaPagoMinimo;
    protected short diasDeMora;
    @XmlElement(required = true)
    protected BigDecimal pagTotCartUSDEnPesos;
    @XmlElement(required = true)
    protected BigDecimal pagMinCartUSDEnPesos;
    @XmlElement(required = true)
    protected BigDecimal pagTotCartUSDEnUSD;
    @XmlElement(required = true)
    protected BigDecimal pagMinCartUSDEnUSD;
    protected int davipuntos;
    protected short indicadorDeCartera;
    protected short compania;
    protected long estado;
    @XmlElement(required = true)
    protected String fechaDeCorte;
    protected short suproducto;
    @XmlElement(required = true)
    protected String codConvenioLibranza;
    @XmlElement(name = "NITEmpresaDeLibranza")
    protected long nitEmpresaDeLibranza;
    @XmlElement(required = true)
    protected String nombEmpresaDeLibranza;
    @XmlElement(required = true)
    protected BigDecimal valrsPagPorAnticipado;
    protected int davipuntosProxAVencer;
    @XmlElement(required = true)
    protected String fechaVencimientoPuntos;
    @XmlElement(required = true)
    protected String fechaVencimientoCupo;
    protected short franquicia;
    @XmlElement(required = true)
    protected String fechaVencPlastico;
    @XmlElement(required = true)
    protected BigDecimal valorEnMora;
    @XmlElement(required = true)
    protected BigDecimal tasaDeCambio;
    @XmlElement(required = true)
    protected String frecuenciaInteres;
    @XmlElement(required = true)
    protected String frecuenciaCapital;
    protected short plazo;
    @XmlElement(required = true)
    protected String fechaProxFactCapital;
    @XmlElement(required = true)
    protected String fechaProxFactInteres;
    protected short indSistAmortFlexible;

    public BigDecimal getCupoDisponible() {
        return this.cupoDisponible;
    }

    public void setCupoDisponible(BigDecimal value) {
        this.cupoDisponible = value;
    }

    public BigDecimal getDisponibleAvance() {
        return this.disponibleAvance;
    }

    public void setDisponibleAvance(BigDecimal value) {
        this.disponibleAvance = value;
    }

    public BigDecimal getPagTotCarteraEnPesos() {
        return this.pagTotCarteraEnPesos;
    }

    public void setPagTotCarteraEnPesos(BigDecimal value) {
        this.pagTotCarteraEnPesos = value;
    }

    public BigDecimal getPagMinCarteraEnPesos() {
        return this.pagMinCarteraEnPesos;
    }

    public void setPagMinCarteraEnPesos(BigDecimal value) {
        this.pagMinCarteraEnPesos = value;
    }

    public String getFechaPagoMinimo() {
        return this.fechaPagoMinimo;
    }

    public void setFechaPagoMinimo(String value) {
        this.fechaPagoMinimo = value;
    }

    public short getDiasDeMora() {
        return this.diasDeMora;
    }

    public void setDiasDeMora(short value) {
        this.diasDeMora = value;
    }

    public BigDecimal getPagTotCartUSDEnPesos() {
        return this.pagTotCartUSDEnPesos;
    }

    public void setPagTotCartUSDEnPesos(BigDecimal value) {
        this.pagTotCartUSDEnPesos = value;
    }

    public BigDecimal getPagMinCartUSDEnPesos() {
        return this.pagMinCartUSDEnPesos;
    }

    public void setPagMinCartUSDEnPesos(BigDecimal value) {
        this.pagMinCartUSDEnPesos = value;
    }

    public BigDecimal getPagTotCartUSDEnUSD() {
        return this.pagTotCartUSDEnUSD;
    }

    public void setPagTotCartUSDEnUSD(BigDecimal value) {
        this.pagTotCartUSDEnUSD = value;
    }

    public BigDecimal getPagMinCartUSDEnUSD() {
        return this.pagMinCartUSDEnUSD;
    }

    public void setPagMinCartUSDEnUSD(BigDecimal value) {
        this.pagMinCartUSDEnUSD = value;
    }

    public int getDavipuntos() {
        return this.davipuntos;
    }

    public void setDavipuntos(int value) {
        this.davipuntos = value;
    }

    public short getIndicadorDeCartera() {
        return this.indicadorDeCartera;
    }

    public void setIndicadorDeCartera(short value) {
        this.indicadorDeCartera = value;
    }

    public short getCompania() {
        return this.compania;
    }

    public void setCompania(short value) {
        this.compania = value;
    }

    public long getEstado() {
        return this.estado;
    }

    public void setEstado(long value) {
        this.estado = value;
    }

    public String getFechaDeCorte() {
        return this.fechaDeCorte;
    }

    public void setFechaDeCorte(String value) {
        this.fechaDeCorte = value;
    }

    public short getSuproducto() {
        return this.suproducto;
    }

    public void setSuproducto(short value) {
        this.suproducto = value;
    }

    public String getCodConvenioLibranza() {
        return this.codConvenioLibranza;
    }

    public void setCodConvenioLibranza(String value) {
        this.codConvenioLibranza = value;
    }

    public long getNITEmpresaDeLibranza() {
        return this.nitEmpresaDeLibranza;
    }

    public void setNITEmpresaDeLibranza(long value) {
        this.nitEmpresaDeLibranza = value;
    }

    public String getNombEmpresaDeLibranza() {
        return this.nombEmpresaDeLibranza;
    }

    public void setNombEmpresaDeLibranza(String value) {
        this.nombEmpresaDeLibranza = value;
    }

    public BigDecimal getValrsPagPorAnticipado() {
        return this.valrsPagPorAnticipado;
    }

    public void setValrsPagPorAnticipado(BigDecimal value) {
        this.valrsPagPorAnticipado = value;
    }

    public int getDavipuntosProxAVencer() {
        return this.davipuntosProxAVencer;
    }

    public void setDavipuntosProxAVencer(int value) {
        this.davipuntosProxAVencer = value;
    }

    public String getFechaVencimientoPuntos() {
        return this.fechaVencimientoPuntos;
    }

    public void setFechaVencimientoPuntos(String value) {
        this.fechaVencimientoPuntos = value;
    }

    public String getFechaVencimientoCupo() {
        return this.fechaVencimientoCupo;
    }

    public void setFechaVencimientoCupo(String value) {
        this.fechaVencimientoCupo = value;
    }

    public short getFranquicia() {
        return this.franquicia;
    }

    public void setFranquicia(short value) {
        this.franquicia = value;
    }

    public String getFechaVencPlastico() {
        return this.fechaVencPlastico;
    }

    public void setFechaVencPlastico(String value) {
        this.fechaVencPlastico = value;
    }

    public BigDecimal getValorEnMora() {
        return this.valorEnMora;
    }

    public void setValorEnMora(BigDecimal value) {
        this.valorEnMora = value;
    }

    public BigDecimal getTasaDeCambio() {
        return this.tasaDeCambio;
    }

    public void setTasaDeCambio(BigDecimal value) {
        this.tasaDeCambio = value;
    }

    public String getFrecuenciaInteres() {
        return this.frecuenciaInteres;
    }

    public void setFrecuenciaInteres(String value) {
        this.frecuenciaInteres = value;
    }

    public String getFrecuenciaCapital() {
        return this.frecuenciaCapital;
    }

    public void setFrecuenciaCapital(String value) {
        this.frecuenciaCapital = value;
    }

    public short getPlazo() {
        return this.plazo;
    }

    public void setPlazo(short value) {
        this.plazo = value;
    }

    public String getFechaProxFactCapital() {
        return this.fechaProxFactCapital;
    }

    public void setFechaProxFactCapital(String value) {
        this.fechaProxFactCapital = value;
    }

    public String getFechaProxFactInteres() {
        return this.fechaProxFactInteres;
    }

    public void setFechaProxFactInteres(String value) {
        this.fechaProxFactInteres = value;
    }

    public short getIndSistAmortFlexible() {
        return this.indSistAmortFlexible;
    }

    public void setIndSistAmortFlexible(short value) {
        this.indSistAmortFlexible = value;
    }
}
