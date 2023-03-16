package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Registro", propOrder = {"valParametro"})
public class Registro
        implements Serializable {

    protected List<Valor> valParametro;

    public List<Valor> getValParametro() {
        if (this.valParametro == null) {
            this.valParametro = new ArrayList<Valor>();
        }
        return this.valParametro;
    }

    public void setValParametro(List<Valor> valParametro) {
        this.valParametro = valParametro;
    }
}
