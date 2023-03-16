package com.davivienda.generarReporte.servicios.representativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataHeaderReqType", propOrder = {"nombreOperacion", "total", "jornada", "canal", "modoDeOperacion", "usuario", "perfil", "versionServicio", "idTransaccion"})
public class DataHeaderReqType {

    @XmlElement(required = true, defaultValue = "DocumentosRepresentativosUnificada")
    protected String nombreOperacion;
    protected int total;
    protected short jornada;
    protected short canal;
    protected short modoDeOperacion;
    @XmlElement(required = true)
    protected String usuario;
    protected short perfil;
    @XmlElement(required = true, defaultValue = "1.0.0")
    protected String versionServicio;
    @XmlElement(required = true)
    protected String idTransaccion;

    public String getNombreOperacion() {
        return this.nombreOperacion;
    }

    public void setNombreOperacion(String value) {
        this.nombreOperacion = value;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int value) {
        this.total = value;
    }

    public short getJornada() {
        return this.jornada;
    }

    public void setJornada(short value) {
        this.jornada = value;
    }

    public short getCanal() {
        return this.canal;
    }

    public void setCanal(short value) {
        this.canal = value;
    }

    public short getModoDeOperacion() {
        return this.modoDeOperacion;
    }

    public void setModoDeOperacion(short value) {
        this.modoDeOperacion = value;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String value) {
        this.usuario = value;
    }

    public short getPerfil() {
        return this.perfil;
    }

    public void setPerfil(short value) {
        this.perfil = value;
    }

    public String getVersionServicio() {
        return this.versionServicio;
    }

    public void setVersionServicio(String value) {
        this.versionServicio = value;
    }

    public String getIdTransaccion() {
        return this.idTransaccion;
    }

    public void setIdTransaccion(String value) {
        this.idTransaccion = value;
    }
}
