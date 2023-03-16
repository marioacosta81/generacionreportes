package com.davivienda.generarReporte.config.reporte;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"servicio"})
public class Servicios
        implements Serializable {

    private List<String> servicio;

    public List<String> getServicio() {
        return this.servicio;
    }

    public void setServicio(List<String> servicio) {
        this.servicio = servicio;
    }
}
