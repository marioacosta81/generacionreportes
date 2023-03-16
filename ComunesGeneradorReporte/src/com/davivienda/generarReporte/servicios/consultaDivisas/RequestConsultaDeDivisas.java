package com.davivienda.generarReporte.servicios.consultaDivisas;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestConsultaDeDivisas", propOrder = {"dataHeader", "data"})
public class RequestConsultaDeDivisas
        implements Serializable {

    @XmlElement(name = "DataHeader", required = true)
    protected ConsultaDeDivisasDataHeaderType dataHeader;
    @XmlElement(name = "Data", required = true)
    protected ConsultaDeDivisasDataType data;

    public ConsultaDeDivisasDataHeaderType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(ConsultaDeDivisasDataHeaderType value) {
        this.dataHeader = value;
    }

    public ConsultaDeDivisasDataType getData() {
        return this.data;
    }

    public void setData(ConsultaDeDivisasDataType value) {
        this.data = value;
    }
}
