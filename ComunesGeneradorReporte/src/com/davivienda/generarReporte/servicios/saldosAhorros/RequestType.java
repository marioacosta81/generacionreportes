package com.davivienda.generarReporte.servicios.saldosAhorros;

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
    protected DataHeaderRequestType dataHeader;
    @XmlElement(name = "Data", required = true)
    protected DataRequestType data;

    public DataHeaderRequestType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(DataHeaderRequestType value) {
        this.dataHeader = value;
    }

    public DataRequestType getData() {
        return this.data;
    }

    public void setData(DataRequestType value) {
        this.data = value;
    }

    public String toString() {
        return "RequestType{dataHeader=" + this.dataHeader + ", data=" + this.data + '}';
    }
}
