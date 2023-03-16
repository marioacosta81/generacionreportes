package com.davivienda.generarReporte.util;

import java.util.ArrayList;
import java.util.List;

public class Pais {

    private String nombre;
    private String continente;
    private String presidente;
    private List<Estado> estados;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return this.continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPresidente() {
        return this.presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public List<Estado> getEstados() {
        if (this.estados == null) {
            this.estados = new ArrayList();
        }

        return this.estados;
    }
}
