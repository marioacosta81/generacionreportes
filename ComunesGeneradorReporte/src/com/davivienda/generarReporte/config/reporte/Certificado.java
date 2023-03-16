package com.davivienda.generarReporte.config.reporte;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"nombre", "servicios", "nombrePlantilla", "nombrePlantillaAlDia", "nombrePlantillaEnMora", "codigosProductoAceptados"})
public class Certificado
        implements Serializable {

    private String nombre;
    private Servicios servicios;
    private String nombrePlantilla;
    private String nombrePlantillaAlDia;
    private String nombrePlantillaEnMora;
    private String codigosProductoAceptados;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePlantilla() {
        return this.nombrePlantilla;
    }

    public void setNombrePlantilla(String nombrePlantilla) {
        this.nombrePlantilla = nombrePlantilla;
    }

    public Servicios getServicios() {
        return this.servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    public String getCodigosProductoAceptados() {
        return this.codigosProductoAceptados;
    }

    public void setCodigosProductoAceptados(String codigosProductoAceptados) {
        this.codigosProductoAceptados = codigosProductoAceptados;
    }

    public String getNombrePlantillaAlDia() {
        return this.nombrePlantillaAlDia;
    }

    public void setNombrePlantillaAlDia(String nombrePlantillaAlDia) {
        this.nombrePlantillaAlDia = nombrePlantillaAlDia;
    }

    public String getNombrePlantillaEnMora() {
        return this.nombrePlantillaEnMora;
    }

    public void setNombrePlantillaEnMora(String nombrePlantillaEnMora) {
        this.nombrePlantillaEnMora = nombrePlantillaEnMora;
    }
}
