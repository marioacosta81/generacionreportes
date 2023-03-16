package com.davivienda.generarReporte.servicios.saldosCtaCte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaSaldoCuentaCorrienteIIDto", propOrder = {"indicadorProducto", "numeroCuenta", "talon"})
public class ConsultaSaldoCuentaCorrienteIIDto
        extends ParametrosDeTransaccionBaseDTO {

    protected Short indicadorProducto;
    protected String numeroCuenta;
    protected String talon;

    public Short getIndicadorProducto() {
        return this.indicadorProducto;
    }

    public void setIndicadorProducto(Short value) {
        this.indicadorProducto = value;
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(String value) {
        this.numeroCuenta = value;
    }

    public String getTalon() {
        return this.talon;
    }

    public void setTalon(String value) {
        this.talon = value;
    }
}
