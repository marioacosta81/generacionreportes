package com.davivienda.generarReporte.config.reporte;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"nombre", "version", "plantillaFO", "tipoDocumento", "valClaseDocumento", "notificacion"})
public class Plantilla
        implements Serializable {

    private String nombre;
    private String version;
    private String plantillaFO;
    private String tipoDocumento;
    private String valClaseDocumento;
    private Notificacion notificacion;

    public String getNombre() {
        return this.nombre;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getValClaseDocumento() {
        return this.valClaseDocumento;
    }

    public void setValClaseDocumento(String valClaseDocumento) {
        this.valClaseDocumento = valClaseDocumento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlantilla() {
        return this.plantillaFO;
    }

    public void setPlantilla(String plantilla) {
        this.plantillaFO = plantilla;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Notificacion getNotificacion() {
        return this.notificacion;
    }

    public void setNotificacion(Notificacion plantilla) {
        this.notificacion = plantilla;
    }
}
