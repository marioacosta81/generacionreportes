package com.davivienda.generarReporte.servicios.fondosInversion;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataConsultaFondosDeInversion", propOrder = {"numeroProducto"})
public class DataConsultaFondosDeInversion
        implements Serializable {

    protected long numeroProducto;

    public long getNumeroProducto() {
        return this.numeroProducto;
    }

    public void setNumeroProducto(long value) {
        this.numeroProducto = value;
    }

    public String toString() {
        return "DataConsultaFondosDeInversion{numeroProducto=" + this.numeroProducto + '}';
    }
}
