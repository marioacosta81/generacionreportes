package com.davivienda.generarReporte.servicios.consultaDetalleTarjeta;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaDetalleTarjetaCreditoDataType", propOrder = {"numeroDeProducto", "compania"})
public class ConsultaDetalleTarjetaCreditoDataType
        implements Serializable {

    protected long numeroDeProducto;
    protected Integer compania;

    public long getNumeroDeProducto() {
        return this.numeroDeProducto;
    }

    public void setNumeroDeProducto(long value) {
        this.numeroDeProducto = value;
    }

    public Integer getCompania() {
        return this.compania;
    }

    public void setCompania(Integer value) {
        this.compania = value;
    }

    public String toString() {
        return "ConsultaDetalleTarjetaCreditoDataType{numeroDeProducto=" + this.numeroDeProducto + ", compania=" + this.compania + '}';
    }
}
