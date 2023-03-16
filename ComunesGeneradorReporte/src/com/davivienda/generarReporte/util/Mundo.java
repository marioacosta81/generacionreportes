package com.davivienda.generarReporte.util;

import java.util.ArrayList;
import java.util.List;

public class Mundo {

    private String nombre;
    private List<Pais> paises;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pais> getPaises() {
        if (this.paises == null) {
            this.paises = new ArrayList<Pais>();
        }
        return this.paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }
}
