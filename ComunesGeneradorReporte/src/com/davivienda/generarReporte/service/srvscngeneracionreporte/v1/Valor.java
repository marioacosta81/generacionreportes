package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Valor")
public class Valor
        implements Serializable {

    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "unidad", required = false)
    protected String unidad;
    @XmlElement
    protected List<String> valor;

    public String getId() {
        return this.id;
    }

    public void setId(String value) {
        this.id = value.replace("{", "").replace("}", "");
    }

    public List<String> getValor() {
        if (this.valor == null) {
            this.valor = new ArrayList<String>();
        }
        return this.valor;
    }

    public String getUnidad() {
        return this.unidad;
    }

    public void setUnidad(String value) {
        this.unidad = value;
    }
}
