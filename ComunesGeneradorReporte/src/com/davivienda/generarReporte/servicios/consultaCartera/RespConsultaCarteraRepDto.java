package com.davivienda.generarReporte.servicios.consultaCartera;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespConsultaCarteraRepDto", propOrder = {"codSubProducto", "codigoProducto", "cupo", "estado", "fechaCancelacion", "fechaInicial", "numeroProducto", "saldo", "mensaje", "filler1", "filler2", "filler3", "titularidad"})
public class RespConsultaCarteraRepDto
        implements Serializable {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codSubProducto;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codigoProducto;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal cupo;
    @XmlElement(required = true, nillable = true)
    protected String estado;
    @XmlElement(required = true, nillable = true)
    protected String fechaCancelacion;
    @XmlElement(required = true, nillable = true)
    protected String fechaInicial;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long numeroProducto;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal saldo;
    @XmlElement(required = true, nillable = true)
    protected String mensaje;
    @XmlElement(required = true, nillable = true)
    protected String filler1;
    @XmlElement(required = true, nillable = true)
    protected String filler2;
    @XmlElement(required = true, nillable = true)
    protected String filler3;
    @XmlElement(required = true, nillable = true)
    protected String titularidad;

    public Integer getCodSubProducto() {
        return this.codSubProducto;
    }

    public void setCodSubProducto(Integer value) {
        this.codSubProducto = value;
    }

    public Integer getCodigoProducto() {
        return this.codigoProducto;
    }

    public void setCodigoProducto(Integer value) {
        this.codigoProducto = value;
    }

    public BigDecimal getCupo() {
        return this.cupo;
    }

    public void setCupo(BigDecimal value) {
        this.cupo = value;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String value) {
        this.estado = value;
    }

    public String getFechaCancelacion() {
        return this.fechaCancelacion;
    }

    public void setFechaCancelacion(String value) {
        this.fechaCancelacion = value;
    }

    public String getFechaInicial() {
        return this.fechaInicial;
    }

    public void setFechaInicial(String value) {
        this.fechaInicial = value;
    }

    public Long getNumeroProducto() {
        return this.numeroProducto;
    }

    public void setNumeroProducto(Long value) {
        this.numeroProducto = value;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public void setSaldo(BigDecimal value) {
        this.saldo = value;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String value) {
        this.mensaje = value;
    }

    public String getFiller1() {
        return this.filler1;
    }

    public void setFiller1(String value) {
        this.filler1 = value;
    }

    public String getFiller2() {
        return this.filler2;
    }

    public void setFiller2(String value) {
        this.filler2 = value;
    }

    public String getFiller3() {
        return this.filler3;
    }

    public void setFiller3(String value) {
        this.filler3 = value;
    }

    public String getTitularidad() {
        return this.titularidad;
    }

    public void setTitularidad(String value) {
        this.titularidad = value;
    }
}
