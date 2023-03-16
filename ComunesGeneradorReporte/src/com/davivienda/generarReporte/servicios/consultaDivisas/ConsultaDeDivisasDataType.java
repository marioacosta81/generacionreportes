package com.davivienda.generarReporte.servicios.consultaDivisas;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaDeDivisasDataType", propOrder = {"valor", "indicadorDeMoneda"})
public class ConsultaDeDivisasDataType
        implements Serializable {

    @XmlElement(required = true)
    protected BigDecimal valor;
    protected short indicadorDeMoneda;

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal value) {
        this.valor = value;
    }

    public short getIndicadorDeMoneda() {
        return this.indicadorDeMoneda;
    }

    public void setIndicadorDeMoneda(short value) {
        this.indicadorDeMoneda = value;
    }
}
