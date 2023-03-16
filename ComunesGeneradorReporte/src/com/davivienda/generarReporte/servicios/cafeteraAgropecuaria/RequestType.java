package com.davivienda.generarReporte.servicios.cafeteraAgropecuaria;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestType", propOrder = {"dataHeader", "data"})
public class RequestType
        implements Serializable {

    @XmlElement(name = "DataHeader", required = true)
    protected DataHeaderType dataHeader;
    @XmlElement(name = "Data", required = true)
    protected DataType data;

    public DataHeaderType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(DataHeaderType value) {
        this.dataHeader = value;
    }

    public DataType getData() {
        return this.data;
    }

    public void setData(DataType value) {
        this.data = value;
    }
}
