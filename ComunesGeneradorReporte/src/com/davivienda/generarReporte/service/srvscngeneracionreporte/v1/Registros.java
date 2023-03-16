package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Registros",
        propOrder = {"registro"}
)
public class Registros implements Serializable {

    @XmlElement(
            required = true
    )
    protected List<Registro> registro;

    public List<Registro> getRegistro() {
        if (this.registro == null) {
            this.registro = new ArrayList();
        }

        return this.registro;
    }

    public void setRegistro(List<Registro> registro) {
        this.registro = registro;
    }
}
