package com.davivienda.generarReporte.servicios.saldosCtaCteESB;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaSaldosCuentaCorrienteDataType", propOrder = {"origen", "cuenta", "talon"})
public class ConsultaSaldosCuentaCorrienteDataType
        implements Serializable {

    @XmlElement(required = true)
    protected String origen;
    protected long cuenta;
    protected int talon;

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String value) {
        this.origen = value;
    }

    public long getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(long value) {
        this.cuenta = value;
    }

    public int getTalon() {
        return this.talon;
    }

    public void setTalon(int value) {
        this.talon = value;
    }
}
