package com.davivienda.generarReporte.servicios.saldosCtaCte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "campoDto", propOrder = {"caracterRelleno", "esAuditable", "esEncabezado", "esLlaveDeRepetitivo", "esParametro", "esRepetitivo", "idCampo", "idCampoLlaveRepetitiva", "idFormato", "iniciaEnCeros", "justificacion", "longitud", "nombre", "nombreAtributoDto", "posicionInicial", "tipoDato", "valorActual", "valorPorDefecto"})
@XmlSeeAlso({CampoExtendidoDto.class})
public class CampoDto {

    protected String caracterRelleno;
    protected Boolean esAuditable;
    protected Boolean esEncabezado;
    protected Boolean esLlaveDeRepetitivo;
    protected Boolean esParametro;
    protected Boolean esRepetitivo;
    protected Long idCampo;
    protected Long idCampoLlaveRepetitiva;
    protected Long idFormato;
    protected Boolean iniciaEnCeros;
    protected Short justificacion;
    protected Integer longitud;
    protected String nombre;
    protected String nombreAtributoDto;
    protected Integer posicionInicial;
    protected String tipoDato;
    protected String valorActual;
    protected String valorPorDefecto;

    public String getCaracterRelleno() {
        return this.caracterRelleno;
    }

    public void setCaracterRelleno(String value) {
        this.caracterRelleno = value;
    }

    public Boolean isEsAuditable() {
        return this.esAuditable;
    }

    public void setEsAuditable(Boolean value) {
        this.esAuditable = value;
    }

    public Boolean isEsEncabezado() {
        return this.esEncabezado;
    }

    public void setEsEncabezado(Boolean value) {
        this.esEncabezado = value;
    }

    public Boolean isEsLlaveDeRepetitivo() {
        return this.esLlaveDeRepetitivo;
    }

    public void setEsLlaveDeRepetitivo(Boolean value) {
        this.esLlaveDeRepetitivo = value;
    }

    public Boolean isEsParametro() {
        return this.esParametro;
    }

    public void setEsParametro(Boolean value) {
        this.esParametro = value;
    }

    public Boolean isEsRepetitivo() {
        return this.esRepetitivo;
    }

    public void setEsRepetitivo(Boolean value) {
        this.esRepetitivo = value;
    }

    public Long getIdCampo() {
        return this.idCampo;
    }

    public void setIdCampo(Long value) {
        this.idCampo = value;
    }

    public Long getIdCampoLlaveRepetitiva() {
        return this.idCampoLlaveRepetitiva;
    }

    public void setIdCampoLlaveRepetitiva(Long value) {
        this.idCampoLlaveRepetitiva = value;
    }

    public Long getIdFormato() {
        return this.idFormato;
    }

    public void setIdFormato(Long value) {
        this.idFormato = value;
    }

    public Boolean isIniciaEnCeros() {
        return this.iniciaEnCeros;
    }

    public void setIniciaEnCeros(Boolean value) {
        this.iniciaEnCeros = value;
    }

    public Short getJustificacion() {
        return this.justificacion;
    }

    public void setJustificacion(Short value) {
        this.justificacion = value;
    }

    public Integer getLongitud() {
        return this.longitud;
    }

    public void setLongitud(Integer value) {
        this.longitud = value;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String value) {
        this.nombre = value;
    }

    public String getNombreAtributoDto() {
        return this.nombreAtributoDto;
    }

    public void setNombreAtributoDto(String value) {
        this.nombreAtributoDto = value;
    }

    public Integer getPosicionInicial() {
        return this.posicionInicial;
    }

    public void setPosicionInicial(Integer value) {
        this.posicionInicial = value;
    }

    public String getTipoDato() {
        return this.tipoDato;
    }

    public void setTipoDato(String value) {
        this.tipoDato = value;
    }

    public String getValorActual() {
        return this.valorActual;
    }

    public void setValorActual(String value) {
        this.valorActual = value;
    }

    public String getValorPorDefecto() {
        return this.valorPorDefecto;
    }

    public void setValorPorDefecto(String value) {
        this.valorPorDefecto = value;
    }
}
