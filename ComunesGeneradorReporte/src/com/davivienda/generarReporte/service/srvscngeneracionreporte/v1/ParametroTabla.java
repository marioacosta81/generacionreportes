package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParametroTabla", propOrder = {"valIdTabla", "columnas", "registros"})
public class ParametroTabla
        implements Serializable {

    @XmlElement(required = true)
    protected String valIdTabla;
    @XmlElement(required = true)
    protected Columna columnas;
    protected Registros registros;

    public String getValIdTabla() {
        return this.valIdTabla;
    }

    public void setValIdTabla(String value) {
        this.valIdTabla = value;
    }

    public Columna getColumnas() {
        return this.columnas;
    }

    public void setColumnas(Columna value) {
        this.columnas = value;
    }

    public Registros getRegistros() {
        return this.registros;
    }

    public void setRegistros(Registros value) {
        this.registros = value;
    }
}
