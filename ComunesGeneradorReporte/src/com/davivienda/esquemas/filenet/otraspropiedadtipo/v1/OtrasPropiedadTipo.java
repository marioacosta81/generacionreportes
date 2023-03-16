package com.davivienda.esquemas.filenet.otraspropiedadtipo.v1;

import com.davivienda.esquemas.filenet.propiedadtipo.v1.PropiedadTipo;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtrasPropiedadTipo", propOrder = {"propiedad"})
public class OtrasPropiedadTipo {

    @XmlElement(required = true)
    protected List<PropiedadTipo> propiedad;

    public List<PropiedadTipo> getPropiedad() {
        if (this.propiedad == null) {
            this.propiedad = new ArrayList<PropiedadTipo>();
        }
        return this.propiedad;
    }
}
