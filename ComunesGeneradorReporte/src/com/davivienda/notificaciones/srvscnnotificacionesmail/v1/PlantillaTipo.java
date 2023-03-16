package com.davivienda.notificaciones.srvscnnotificacionesmail.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlantillaTipo", propOrder = {"idPlantilla", "parametrosPlantilla"})
public class PlantillaTipo
        implements Serializable {

    @XmlElement(required = true)
    protected String idPlantilla;
    @XmlElement(required = true)
    protected List<ParametroPlantillaTipo> parametrosPlantilla;

    public String getIdPlantilla() {
        return this.idPlantilla;
    }

    public void setIdPlantilla(String value) {
        this.idPlantilla = value;
    }

    public List<ParametroPlantillaTipo> getParametrosPlantilla() {
        if (this.parametrosPlantilla == null) {
            this.parametrosPlantilla = new ArrayList<ParametroPlantillaTipo>();
        }
        return this.parametrosPlantilla;
    }

    public void setParametrosPlantilla(List<ParametroPlantillaTipo> value) {
        this.parametrosPlantilla = value;
    }
}
