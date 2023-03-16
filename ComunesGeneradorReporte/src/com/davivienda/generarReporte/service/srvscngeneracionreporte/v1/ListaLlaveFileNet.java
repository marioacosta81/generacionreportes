package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaLlaveFileNet", propOrder = {"llave"})
public class ListaLlaveFileNet
        implements Serializable {

    @XmlElement(required = true)
    protected List<Llave> llave;

    public List<Llave> getLlave() {
        if (this.llave == null) {
            this.llave = new ArrayList<Llave>();
        }
        return this.llave;
    }

    public void setLlave(List<Llave> llave) {
        this.llave = llave;
    }
}
