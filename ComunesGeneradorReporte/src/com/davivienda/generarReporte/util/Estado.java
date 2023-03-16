package com.davivienda.generarReporte.util;

import java.util.ArrayList;
import java.util.List;

public class Estado {

    private String nombre;
    private String gobernador;
    private List<Municipio> municipios;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGobernador() {
        return this.gobernador;
    }

    public void setGobernador(String gobernador) {
        this.gobernador = gobernador;
    }

    public List<Municipio> getMunicipios() {
        if (this.municipios == null) {
            this.municipios = new ArrayList<Municipio>();
        }
        return this.municipios;
    }
}
