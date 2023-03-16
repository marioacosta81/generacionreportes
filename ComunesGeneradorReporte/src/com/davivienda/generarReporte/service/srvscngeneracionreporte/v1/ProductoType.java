package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductoType", propOrder = {"codigoTipoProducto", "codigoSubProducto", "numeroProducto", "fechaApertura"})
public class ProductoType
        implements Serializable {

    @XmlElement(required = true)
    protected String codigoTipoProducto;
    @XmlElement(required = true)
    protected String codigoSubProducto;
    @XmlElement(required = true)
    protected String numeroProducto;
    @XmlSchemaType(name = "date")
    protected Date fechaApertura;

    public String getCodigoTipoProducto() {
        return this.codigoTipoProducto;
    }

    public void setCodigoTipoProducto(String value) {
        this.codigoTipoProducto = value;
    }

    public String getCodigoSubProducto() {
        return this.codigoSubProducto;
    }

    public void setCodigoSubProducto(String value) {
        this.codigoSubProducto = value;
    }

    public String getNumeroProducto() {
        return this.numeroProducto;
    }

    public void setNumeroProducto(String value) {
        this.numeroProducto = value;
    }

    public Date getFechaApertura() {
        return this.fechaApertura;
    }

    public void setFechaApertura(Date value) {
        this.fechaApertura = value;
    }
}
