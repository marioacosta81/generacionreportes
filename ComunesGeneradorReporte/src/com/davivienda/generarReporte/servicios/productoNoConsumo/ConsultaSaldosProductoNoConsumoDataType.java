package com.davivienda.generarReporte.servicios.productoNoConsumo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaSaldosProductoNoConsumoDataType", propOrder = {})
public class ConsultaSaldosProductoNoConsumoDataType {

    protected long numeroDeProducto;
    protected Short indicadorConsulta;

    public long getNumeroDeProducto() {
        return this.numeroDeProducto;
    }

    public void setNumeroDeProducto(long value) {
        this.numeroDeProducto = value;
    }

    public Short getIndicadorConsulta() {
        return this.indicadorConsulta;
    }

    public void setIndicadorConsulta(Short value) {
        this.indicadorConsulta = value;
    }

    public String toString() {
        return "ConsultaSaldosProductoNoConsumoDataType{numeroDeProducto=" + this.numeroDeProducto + ", indicadorConsulta=" + this.indicadorConsulta + '}';
    }
}
