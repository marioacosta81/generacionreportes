package com.davivienda.generarReporte.servicios.dabuenavida;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaSaldoTituloDabuenavidaDataType", propOrder = {"tipoDeProducto", "numeroDeProducto"})
public class ConsultaSaldoTituloDabuenavidaDataType
        implements Serializable {

    protected short tipoDeProducto;
    protected long numeroDeProducto;

    public short getTipoDeProducto() {
        return this.tipoDeProducto;
    }

    public void setTipoDeProducto(short value) {
        this.tipoDeProducto = value;
    }

    public long getNumeroDeProducto() {
        return this.numeroDeProducto;
    }

    public void setNumeroDeProducto(long value) {
        this.numeroDeProducto = value;
    }

    public String toString() {
        return "ConsultaSaldoTituloDabuenavidaDataType{tipoDeProducto=" + this.tipoDeProducto + ", numeroDeProducto=" + this.numeroDeProducto + '}';
    }
}
