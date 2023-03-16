package com.davivienda.generarReporte.config.reporte;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        propOrder = {"unidad"}
)
public class Unidades implements Serializable {

    private static HashMap<String, Unidad> mapUnidades;
    private List<Unidad> unidad;

    public List<Unidad> getUnidad() {
        return this.unidad;
    }

    public void setUnidad(List<Unidad> unidad) {
        this.unidad = unidad;
    }

    public void cargarMapUnidades() {
        System.out.println("Se cargará cache de unidades");
        mapUnidades = new HashMap();
        if (this.unidad != null) {
            if (!this.unidad.isEmpty()) {
                Iterator i$ = this.unidad.iterator();

                while (i$.hasNext()) {
                    Unidad cert = (Unidad) i$.next();
                    mapUnidades.put(cert.getId(), cert);
                    System.out.println("Se agrega a caché Unidad: " + cert.getId());
                }
            } else {
                System.out.println("Lista de Unidades está vacía");
            }
        } else {
            System.out.println("Lista de Unidades es null");
        }

    }

    public Unidad obtenerUnidadesCache(String id) {
        Unidad certResp = null;
        if (mapUnidades == null) {
            this.cargarMapUnidades();
        }

        certResp = (Unidad) mapUnidades.get(id);
        return certResp;
    }
}
