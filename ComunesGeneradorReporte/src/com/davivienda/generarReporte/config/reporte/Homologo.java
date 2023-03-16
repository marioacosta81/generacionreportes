package com.davivienda.generarReporte.config.reporte;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"valor", "homologo"})
public class Homologo
        implements Serializable {

    private String valor;
    private String homologo;

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getHomologo() {
        return this.homologo;
    }

    public void setHomologo(String homologo) {
        this.homologo = homologo;
    }
}
