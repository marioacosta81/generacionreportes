package com.davivienda.generarReporte.servicios.productoNoConsumo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataResponseType", propOrder = {"productoNoConsumo"})
public class DataResponseType {

    @XmlElement(name = "ProductoNoConsumo", required = true)
    protected ProductoNoConsumoType productoNoConsumo;

    public ProductoNoConsumoType getProductoNoConsumo() {
        return this.productoNoConsumo;
    }

    public void setProductoNoConsumo(ProductoNoConsumoType value) {
        this.productoNoConsumo = value;
    }
}
