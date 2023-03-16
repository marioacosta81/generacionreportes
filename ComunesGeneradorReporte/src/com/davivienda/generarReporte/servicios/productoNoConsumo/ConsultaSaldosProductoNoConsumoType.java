package com.davivienda.generarReporte.servicios.productoNoConsumo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaSaldosProductoNoConsumoType", propOrder = {"request"})
public class ConsultaSaldosProductoNoConsumoType {

    @XmlElement(name = "Request", required = true)
    protected RequestConsultaSaldosProductoNoConsumo request;

    public RequestConsultaSaldosProductoNoConsumo getRequest() {
        return this.request;
    }

    public void setRequest(RequestConsultaSaldosProductoNoConsumo value) {
        this.request = value;
    }
}
