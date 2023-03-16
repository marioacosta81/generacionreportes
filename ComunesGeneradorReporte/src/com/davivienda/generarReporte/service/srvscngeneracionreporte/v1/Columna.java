package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Columna", propOrder = {"valNombreColumna"})
public class Columna
        implements Serializable {

    @XmlElement(required = true)
    protected List<String> valNombreColumna;

    public List<String> getValNombreColumna() {
        if (this.valNombreColumna == null) {
            this.valNombreColumna = new ArrayList<String>();
        }
        return this.valNombreColumna;
    }

    public void setValNombreColumna(List<String> valNombreColumna) {
        this.valNombreColumna = valNombreColumna;
    }
}
