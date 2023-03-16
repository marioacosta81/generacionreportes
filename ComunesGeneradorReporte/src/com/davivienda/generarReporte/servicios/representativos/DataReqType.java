package com.davivienda.generarReporte.servicios.representativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataReqType", propOrder = {"codOficina", "valTalon", "fecFechaInicio", "fecFechaFinal", "codTipoProducto", "valNumeroProducto", "valSecuencia"})
public class DataReqType {

    protected int codOficina;
    protected int valTalon;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecFechaInicio;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecFechaFinal;
    protected int codTipoProducto;
    @XmlElement(required = true)
    protected String valNumeroProducto;
    protected String valSecuencia;

    public int getCodOficina() {
        return this.codOficina;
    }

    public void setCodOficina(int value) {
        this.codOficina = value;
    }

    public int getValTalon() {
        return this.valTalon;
    }

    public void setValTalon(int value) {
        this.valTalon = value;
    }

    public XMLGregorianCalendar getFecFechaInicio() {
        return this.fecFechaInicio;
    }

    public void setFecFechaInicio(XMLGregorianCalendar value) {
        this.fecFechaInicio = value;
    }

    public XMLGregorianCalendar getFecFechaFinal() {
        return this.fecFechaFinal;
    }

    public void setFecFechaFinal(XMLGregorianCalendar value) {
        this.fecFechaFinal = value;
    }

    public int getCodTipoProducto() {
        return this.codTipoProducto;
    }

    public void setCodTipoProducto(int value) {
        this.codTipoProducto = value;
    }

    public String getValNumeroProducto() {
        return this.valNumeroProducto;
    }

    public void setValNumeroProducto(String value) {
        this.valNumeroProducto = value;
    }

    public String getValSecuencia() {
        return this.valSecuencia;
    }

    public void setValSecuencia(String value) {
        this.valSecuencia = value;
    }
}
