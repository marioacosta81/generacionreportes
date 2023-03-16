package com.davivienda.generarReporte.servicios.dabuenavida;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataResponseType", propOrder = {"tituloDabuenavida"})
public class DataResponseType
        implements Serializable {

    @XmlElement(name = "TituloDabuenavida", required = true)
    protected TituloDabuenavidaType tituloDabuenavida;

    public TituloDabuenavidaType getTituloDabuenavida() {
        return this.tituloDabuenavida;
    }

    public void setTituloDabuenavida(TituloDabuenavidaType value) {
        this.tituloDabuenavida = value;
    }

    public String toString() {
        return "DataResponseType{tituloDabuenavida=" + this.tituloDabuenavida + '}';
    }
}
