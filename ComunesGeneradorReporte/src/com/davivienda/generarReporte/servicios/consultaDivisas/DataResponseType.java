package com.davivienda.generarReporte.servicios.consultaDivisas;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataResponseType", propOrder = {})
public class DataResponseType
        implements Serializable {

    @XmlElement(required = true)
    protected String valorPesos;
    @XmlElement(required = true)
    protected String valorDolares;
    @XmlElement(required = true)
    protected String comision;
    @XmlElement(required = true)
    protected String valorTasaCambio;
    @XmlElement(required = true)
    protected String tasaPromedioCompra;
    @XmlElement(required = true)
    protected String tasaRepMercado;

    public String getValorPesos() {
        return this.valorPesos;
    }

    public void setValorPesos(String value) {
        this.valorPesos = value;
    }

    public String getValorDolares() {
        return this.valorDolares;
    }

    public void setValorDolares(String value) {
        this.valorDolares = value;
    }

    public String getComision() {
        return this.comision;
    }

    public void setComision(String value) {
        this.comision = value;
    }

    public String getValorTasaCambio() {
        return this.valorTasaCambio;
    }

    public void setValorTasaCambio(String value) {
        this.valorTasaCambio = value;
    }

    public String getTasaPromedioCompra() {
        return this.tasaPromedioCompra;
    }

    public void setTasaPromedioCompra(String value) {
        this.tasaPromedioCompra = value;
    }

    public String getTasaRepMercado() {
        return this.tasaRepMercado;
    }

    public void setTasaRepMercado(String value) {
        this.tasaRepMercado = value;
    }
}
