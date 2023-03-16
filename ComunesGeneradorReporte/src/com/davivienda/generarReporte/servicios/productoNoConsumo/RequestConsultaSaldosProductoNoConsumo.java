package com.davivienda.generarReporte.servicios.productoNoConsumo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestConsultaSaldosProductoNoConsumo", propOrder = {"dataHeader", "data"})
public class RequestConsultaSaldosProductoNoConsumo {

    @XmlElement(name = "DataHeader", required = true)
    protected ConsultaSaldosProductoNoConsumoDataHeaderType dataHeader;
    @XmlElement(name = "Data", required = true)
    protected ConsultaSaldosProductoNoConsumoDataType data;

    public ConsultaSaldosProductoNoConsumoDataHeaderType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(ConsultaSaldosProductoNoConsumoDataHeaderType value) {
        this.dataHeader = value;
    }

    public ConsultaSaldosProductoNoConsumoDataType getData() {
        return this.data;
    }

    public void setData(ConsultaSaldosProductoNoConsumoDataType value) {
        this.data = value;
    }

    public String toString() {
        return "RequestConsultaSaldosProductoNoConsumo{dataHeader=" + this.dataHeader + ", data=" + this.data + '}';
    }
}
