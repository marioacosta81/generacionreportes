// Decompiled using: fernflower
// Took: 36ms

package com.davivienda.generarReporte.reporte.config.wsServicios;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dataHeaderComunESB")
@XmlType(propOrder = { "nombre", "modoDeOperacion", "nombreOperacion", "total", "versionServicio" })
public class DataHeaderComunESB {
    private String nombre;
    private short modoDeOperacion;
    private String nombreOperacion;
    private int total;
    private String versionServicio;
    
    public DataHeaderComunESB() {
        super();
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public short getModoDeOperacion() {
        return this.modoDeOperacion;
    }
    
    public void setModoDeOperacion(final short modoDeOperacion) {
        this.modoDeOperacion = modoDeOperacion;
    }
    
    public String getNombreOperacion() {
        return this.nombreOperacion;
    }
    
    public void setNombreOperacion(final String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
    
    public String getVersionServicio() {
        return this.versionServicio;
    }
    
    public void setVersionServicio(final String versionServicio) {
        this.versionServicio = versionServicio;
    }
    
    @Override
    public String toString() {
        return "DataHeaderComunESB [nombre=" + this.nombre + ", modoDeOperacion=" + this.modoDeOperacion + ", nombreOperacion=" + this.nombreOperacion + ", total=" + this.total + ", versionServicio=" + this.versionServicio + "]";
    }
}
