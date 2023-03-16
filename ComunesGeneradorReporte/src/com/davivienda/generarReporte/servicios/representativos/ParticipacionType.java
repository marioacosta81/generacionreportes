package com.davivienda.generarReporte.servicios.representativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParticipacionType", propOrder = {"codParticipacion", "valNombreParticipacion", "codTipoPersona", "valRangoSaldoPromedio", "valPorcentajeComisionAdmon"})
public class ParticipacionType {

    @XmlElement(required = true)
    protected String codParticipacion;
    @XmlElement(required = true)
    protected String valNombreParticipacion;
    @XmlElement(required = true)
    protected String codTipoPersona;
    @XmlElement(required = true)
    protected String valRangoSaldoPromedio;
    @XmlElement(required = true)
    protected String valPorcentajeComisionAdmon;

    public String getCodParticipacion() {
        return this.codParticipacion;
    }

    public void setCodParticipacion(String value) {
        this.codParticipacion = value;
    }

    public String getValNombreParticipacion() {
        return this.valNombreParticipacion;
    }

    public void setValNombreParticipacion(String value) {
        this.valNombreParticipacion = value;
    }

    public String getCodTipoPersona() {
        return this.codTipoPersona;
    }

    public void setCodTipoPersona(String value) {
        this.codTipoPersona = value;
    }

    public String getValRangoSaldoPromedio() {
        return this.valRangoSaldoPromedio;
    }

    public void setValRangoSaldoPromedio(String value) {
        this.valRangoSaldoPromedio = value;
    }

    public String getValPorcentajeComisionAdmon() {
        return this.valPorcentajeComisionAdmon;
    }

    public void setValPorcentajeComisionAdmon(String value) {
        this.valPorcentajeComisionAdmon = value;
    }
}
