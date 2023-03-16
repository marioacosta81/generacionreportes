package com.davivienda.generarReporte.servicios.consultaCartera;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampoExtendidoDto", propOrder = {"caracterRelleno", "esAuditable", "esEncabezado", "esLlaveDeRepetitivo", "esParametro", "esRepetitivo", "idCampo", "idCampoLlaveRepetitiva", "idFormato", "iniciaEnCeros", "justificacion", "longitud", "nombre", "nombreAtributoDto", "posicionInicial", "tipoDato", "valorActual", "valorPorDefecto", "jMascara", "pMascara", "valor"})
public class CampoExtendidoDto
        implements Serializable {

    @XmlElement(required = true, nillable = true)
    protected String caracterRelleno;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean esAuditable;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean esEncabezado;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean esLlaveDeRepetitivo;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean esParametro;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean esRepetitivo;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long idCampo;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long idCampoLlaveRepetitiva;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long idFormato;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean iniciaEnCeros;
    @XmlElement(required = true, type = Short.class, nillable = true)
    protected Short justificacion;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer longitud;
    @XmlElement(required = true, nillable = true)
    protected String nombre;
    @XmlElement(required = true, nillable = true)
    protected String nombreAtributoDto;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer posicionInicial;
    @XmlElement(required = true, nillable = true)
    protected String tipoDato;
    @XmlElement(required = true, nillable = true)
    protected String valorActual;
    @XmlElement(required = true, nillable = true)
    protected String valorPorDefecto;
    @XmlElement(name = "JMascara", required = true, nillable = true)
    protected String jMascara;
    @XmlElement(name = "PMascara", required = true, nillable = true)
    protected String pMascara;
    @XmlElement(required = true, nillable = true)
    protected String valor;

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

    public String getJMascara() {
        return this.jMascara;
    }

    public void setJMascara(String value) {
        this.jMascara = value;
    }

    public String getPMascara() {
        return this.pMascara;
    }

    public void setPMascara(String value) {
        this.pMascara = value;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String value) {
        this.valor = value;
    }
}
