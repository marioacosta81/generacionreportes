package com.davivienda.generarReporte.servicios.saldosCtaCteESB;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataResponseType", propOrder = {"cuentaCorriente"})
public class DataResponseType
        implements Serializable {

    @XmlElement(name = "CuentaCorriente", required = true)
    protected CuentaCorrienteType cuentaCorriente;

    public CuentaCorrienteType getCuentaCorriente() {
        return this.cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorrienteType value) {
        this.cuentaCorriente = value;
    }
}
