package com.davivienda.generarReporte.servicios.consultaHipotecario;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataResponseType", propOrder = {"producto", "estadoCartera", "valorOriginal", "fechaDesembolso", "tasaDeInteresPactada", "tasaDeInteresCobrada", "tasaDeMora", "planDeAmortizacion", "tipoDeInmueble", "fechaAvaluo", "valorAvaluo", "valorComercial", "fechaVtoGarantia", "usoGarantia", "fechaVtoSeguro", "fechaProximoVencimiento", "ctaDebitoAutomatico", "valorMora", "moraDesde", "noCtaAbogado", "nombreAbogado", "registro"})
public class DataResponseType {

    @XmlElement(required = true)
    protected String producto;
    @XmlElement(required = true)
    protected String estadoCartera;
    protected long valorOriginal;
    protected int fechaDesembolso;
    protected int tasaDeInteresPactada;
    protected int tasaDeInteresCobrada;
    protected int tasaDeMora;
    @XmlElement(required = true)
    protected String planDeAmortizacion;
    @XmlElement(required = true)
    protected String tipoDeInmueble;
    protected int fechaAvaluo;
    protected long valorAvaluo;
    protected long valorComercial;
    protected int fechaVtoGarantia;
    @XmlElement(required = true)
    protected String usoGarantia;
    protected int fechaVtoSeguro;
    protected int fechaProximoVencimiento;
    protected long ctaDebitoAutomatico;
    protected long valorMora;
    protected int moraDesde;
    protected long noCtaAbogado;
    @XmlElement(required = true)
    protected String nombreAbogado;
    @XmlElement(name = "Registro", required = true)
    protected List<RegistroRespType> registro;

    public String getProducto() {
        return this.producto;
    }

    public void setProducto(String value) {
        this.producto = value;
    }

    public String getEstadoCartera() {
        return this.estadoCartera;
    }

    public void setEstadoCartera(String value) {
        this.estadoCartera = value;
    }

    public long getValorOriginal() {
        return this.valorOriginal;
    }

    public void setValorOriginal(long value) {
        this.valorOriginal = value;
    }

    public int getFechaDesembolso() {
        return this.fechaDesembolso;
    }

    public void setFechaDesembolso(int value) {
        this.fechaDesembolso = value;
    }

    public int getTasaDeInteresPactada() {
        return this.tasaDeInteresPactada;
    }

    public void setTasaDeInteresPactada(int value) {
        this.tasaDeInteresPactada = value;
    }

    public int getTasaDeInteresCobrada() {
        return this.tasaDeInteresCobrada;
    }

    public void setTasaDeInteresCobrada(int value) {
        this.tasaDeInteresCobrada = value;
    }

    public int getTasaDeMora() {
        return this.tasaDeMora;
    }

    public void setTasaDeMora(int value) {
        this.tasaDeMora = value;
    }

    public String getPlanDeAmortizacion() {
        return this.planDeAmortizacion;
    }

    public void setPlanDeAmortizacion(String value) {
        this.planDeAmortizacion = value;
    }

    public String getTipoDeInmueble() {
        return this.tipoDeInmueble;
    }

    public void setTipoDeInmueble(String value) {
        this.tipoDeInmueble = value;
    }

    public int getFechaAvaluo() {
        return this.fechaAvaluo;
    }

    public void setFechaAvaluo(int value) {
        this.fechaAvaluo = value;
    }

    public long getValorAvaluo() {
        return this.valorAvaluo;
    }

    public void setValorAvaluo(long value) {
        this.valorAvaluo = value;
    }

    public long getValorComercial() {
        return this.valorComercial;
    }

    public void setValorComercial(long value) {
        this.valorComercial = value;
    }

    public int getFechaVtoGarantia() {
        return this.fechaVtoGarantia;
    }

    public void setFechaVtoGarantia(int value) {
        this.fechaVtoGarantia = value;
    }

    public String getUsoGarantia() {
        return this.usoGarantia;
    }

    public void setUsoGarantia(String value) {
        this.usoGarantia = value;
    }

    public int getFechaVtoSeguro() {
        return this.fechaVtoSeguro;
    }

    public void setFechaVtoSeguro(int value) {
        this.fechaVtoSeguro = value;
    }

    public int getFechaProximoVencimiento() {
        return this.fechaProximoVencimiento;
    }

    public void setFechaProximoVencimiento(int value) {
        this.fechaProximoVencimiento = value;
    }

    public long getCtaDebitoAutomatico() {
        return this.ctaDebitoAutomatico;
    }

    public void setCtaDebitoAutomatico(long value) {
        this.ctaDebitoAutomatico = value;
    }

    public long getValorMora() {
        return this.valorMora;
    }

    public void setValorMora(long value) {
        this.valorMora = value;
    }

    public int getMoraDesde() {
        return this.moraDesde;
    }

    public void setMoraDesde(int value) {
        this.moraDesde = value;
    }

    public long getNoCtaAbogado() {
        return this.noCtaAbogado;
    }

    public void setNoCtaAbogado(long value) {
        this.noCtaAbogado = value;
    }

    public String getNombreAbogado() {
        return this.nombreAbogado;
    }

    public void setNombreAbogado(String value) {
        this.nombreAbogado = value;
    }

    public List<RegistroRespType> getRegistro() {
        if (this.registro == null) {
            this.registro = new ArrayList<RegistroRespType>();
        }
        return this.registro;
    }
}
