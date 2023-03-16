package com.davivienda.generarReporte.servicios.consultaHipotecario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseType", propOrder = {"dataHeader", "data"})
public class ResponseType {

    @XmlElement(name = "DataHeader", required = true)
    protected DataHeaderRespType dataHeader;
    @XmlElement(name = "Data")
    protected DataResponseType data;

    public DataHeaderRespType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(DataHeaderRespType value) {
        this.dataHeader = value;
    }

    public DataResponseType getData() {
        return this.data;
    }

    public void setData(DataResponseType value) {
        this.data = value;
    }
}
