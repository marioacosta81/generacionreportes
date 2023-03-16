package com.davivienda.generarReporte.servicios.saldosCtaCte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaSaldoCuentaCorriente", propOrder = {"dto"})
public class ConsultaSaldoCuentaCorriente {

    protected ConsultaSaldoCuentaCorrienteIIDto dto;

    public ConsultaSaldoCuentaCorrienteIIDto getDto() {
        return this.dto;
    }

    public void setDto(ConsultaSaldoCuentaCorrienteIIDto value) {
        this.dto = value;
    }
}
