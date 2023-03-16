package com.davivienda.notificaciones.srvscnnotificacionesmail.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MensajeTipo", propOrder = {"valAsunto", "valContenido", "plantilla", "formato"})
public class MensajeTipo
        implements Serializable {

    @XmlElement(required = true)
    protected String valAsunto;
    protected String valContenido;
    protected PlantillaTipo plantilla;
    protected String formato;

    public String getValAsunto() {
        return this.valAsunto;
    }

    public void setValAsunto(String value) {
        this.valAsunto = value;
    }

    public String getValContenido() {
        return this.valContenido;
    }

    public void setValContenido(String value) {
        this.valContenido = value;
    }

    public PlantillaTipo getPlantilla() {
        return this.plantilla;
    }

    public void setPlantilla(PlantillaTipo value) {
        this.plantilla = value;
    }

    public String getFormato() {
        return this.formato;
    }

    public void setFormato(String value) {
        this.formato = value;
    }
}
