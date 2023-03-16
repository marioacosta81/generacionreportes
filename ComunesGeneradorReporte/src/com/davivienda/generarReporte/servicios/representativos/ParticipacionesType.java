package com.davivienda.generarReporte.servicios.representativos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParticipacionesType", propOrder = {"participacion"})
public class ParticipacionesType {

    @XmlElement(name = "Participacion")
    protected List<ParticipacionType> participacion;

    public List<ParticipacionType> getParticipacion() {
        if (this.participacion == null) {
            this.participacion = new ArrayList<ParticipacionType>();
        }
        return this.participacion;
    }
}
