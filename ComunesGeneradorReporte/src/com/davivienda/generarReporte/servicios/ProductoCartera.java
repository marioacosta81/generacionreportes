package com.davivienda.generarReporte.servicios;

public class ProductoCartera {

    protected Integer codSubProducto;
    protected Integer codigoProducto;
    protected Long cupo;
    protected String estado;
    protected String fechaCancelacion;
    protected String fechaInicial;
    protected Long numeroProducto;
    protected String saldo;
    protected String mensaje;
    protected String titularidad;
    protected String nombreProducto;

    public Integer getCodSubProducto() {
        return this.codSubProducto;
    }

    public void setCodSubProducto(Integer codSubProducto) {
        this.codSubProducto = codSubProducto;
    }

    public Integer getCodigoProducto() {
        return this.codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Long getCupo() {
        return this.cupo;
    }

    public void setCupo(Long cupo) {
        this.cupo = cupo;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCancelacion() {
        return this.fechaCancelacion;
    }

    public void setFechaCancelacion(String fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public String getFechaInicial() {
        return this.fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Long getNumeroProducto() {
        return this.numeroProducto;
    }

    public void setNumeroProducto(Long numeroProducto) {
        this.numeroProducto = numeroProducto;
    }

    public String getSaldo() {
        return this.saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTitularidad() {
        return this.titularidad;
    }

    public void setTitularidad(String titularidad) {
        this.titularidad = titularidad;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
