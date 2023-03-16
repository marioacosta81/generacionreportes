package com.davivienda.generarReporte.servicios.fondosInversion;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestConsultaFondosDeInversion", propOrder = {"dataHeader", "data"})
public class RequestConsultaFondosDeInversion
        implements Serializable {

    @XmlElement(name = "DataHeader", required = true)
    protected DataHeaderType dataHeader;
    @XmlElement(name = "Data", required = true)
    protected DataConsultaFondosDeInversion data;

    public DataHeaderType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(DataHeaderType value) {
        this.dataHeader = value;
    }

    public DataConsultaFondosDeInversion getData() {
        return this.data;
    }

    public void setData(DataConsultaFondosDeInversion value) {
        this.data = value;
    }

    public String toString() {
        return "RequestConsultaFondosDeInversion{dataHeader=" + this.dataHeader + ", data=" + this.data + '}';
    }
}
