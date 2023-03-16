package com.davivienda.generarReporte.config.reporte;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"tipoIdentificacion"})
public class TiposIdentificacion
        implements Serializable {

    private static HashMap<String, String> mapParamTipoIdentificacions;
    private List<TipoIdentificacion> tipoIdentificacion;

    public List<TipoIdentificacion> getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }

    public void setTipoIdentificacion(List<TipoIdentificacion> tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public void cargarMapTipoIdentificacions() {
        System.out.println("Se cargarcache de tipoIdentificacions");
        mapParamTipoIdentificacions = new HashMap<String, String>();
        if (this.tipoIdentificacion != null) {
            if (!this.tipoIdentificacion.isEmpty()) {
                for (TipoIdentificacion cert : this.tipoIdentificacion) {
                    mapParamTipoIdentificacions.put(cert.getCodTipoIdentificacion(), cert.getValDescripcion());
                    System.out.println("Se agrega a cachtipoIdentificacion: " + cert.getCodTipoIdentificacion());
                }
            } else {
                System.out.println("Lista de tipoIdentificacions esta vacía");
            }
        } else {
            System.out.println("Lista de tipoIdentificacions es null");
        }
    }

    public String obtenerTipoIdentificacionCache(String nombreTipoIdentificacion) {
        String certResp = null;
        if (mapParamTipoIdentificacions == null) {
            cargarMapTipoIdentificacions();
        }
        certResp = mapParamTipoIdentificacions.get(nombreTipoIdentificacion);
        return certResp;
    }
}
