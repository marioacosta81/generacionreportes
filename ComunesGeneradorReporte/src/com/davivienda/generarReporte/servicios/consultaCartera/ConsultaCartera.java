package com.davivienda.generarReporte.servicios.consultaCartera;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaCartera", propOrder = {"consultaCarteraDto1"})
public class ConsultaCartera
        implements Serializable {

    @XmlElement(name = "ConsultaCarteraDto_1", required = true, nillable = true)
    protected ConsultaCarteraDto consultaCarteraDto1;

    public ConsultaCarteraDto getConsultaCarteraDto1() {
        return this.consultaCarteraDto1;
    }

    public void setConsultaCarteraDto1(ConsultaCarteraDto value) {
        this.consultaCarteraDto1 = value;
    }
}
