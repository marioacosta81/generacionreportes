package com.davivienda.generarReporte.servicios.consultaHipotecario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaDetalleCredHipotecarioLeasingDataType", propOrder = {})
public class ConsultaDetalleCredHipotecarioLeasingDataType {

    protected long numeroProducto;

    public long getNumeroProducto() {
        return this.numeroProducto;
    }

    public void setNumeroProducto(long value) {
        this.numeroProducto = value;
    }
}
