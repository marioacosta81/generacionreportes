package com.davivienda.generarReporte.servicios.consultaSaldosCredFecha;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaSaldosCredFechaCorteDataType", propOrder = {})
public class ConsultaSaldosCredFechaCorteDataType
        implements Serializable {

    protected long numeroProducto;

    public long getNumeroProducto() {
        return this.numeroProducto;
    }

    public void setNumeroProducto(long value) {
        this.numeroProducto = value;
    }

    public String toString() {
        return "ConsultaSaldosCredFechaCorteDataType{numeroProducto=" + this.numeroProducto + '}';
    }
}
