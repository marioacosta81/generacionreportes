package com.davivienda.generarReporte.util;

public class Municipio {

    private String nombre;
    private String alcalde;
    private int cantCiudadanos;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantCiudadanos() {
        return this.cantCiudadanos;
    }

    public void setCantCiudadanos(int cantCiudadanos) {
        this.cantCiudadanos = cantCiudadanos;
    }

    public String getAlcalde() {
        return this.alcalde;
    }

    public void setAlcalde(String alcalde) {
        this.alcalde = alcalde;
    }
}
