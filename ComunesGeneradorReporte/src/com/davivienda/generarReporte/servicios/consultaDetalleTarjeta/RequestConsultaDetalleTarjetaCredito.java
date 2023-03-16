package com.davivienda.generarReporte.servicios.consultaDetalleTarjeta;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestConsultaDetalleTarjetaCredito", propOrder = {"dataHeader", "data"})
public class RequestConsultaDetalleTarjetaCredito
        implements Serializable {

    @XmlElement(name = "DataHeader", required = true)
    protected ConsultaDetalleTarjetaCreditoDataHeaderType dataHeader;
    @XmlElement(name = "Data", required = true)
    protected ConsultaDetalleTarjetaCreditoDataType data;

    public ConsultaDetalleTarjetaCreditoDataHeaderType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(ConsultaDetalleTarjetaCreditoDataHeaderType value) {
        this.dataHeader = value;
    }

    public ConsultaDetalleTarjetaCreditoDataType getData() {
        return this.data;
    }

    public void setData(ConsultaDetalleTarjetaCreditoDataType value) {
        this.data = value;
    }

    public String toString() {
        return "RequestConsultaDetalleTarjetaCredito{dataHeader=" + this.dataHeader + ", data=" + this.data + '}';
    }
}
