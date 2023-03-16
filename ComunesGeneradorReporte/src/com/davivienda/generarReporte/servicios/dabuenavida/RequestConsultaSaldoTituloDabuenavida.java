package com.davivienda.generarReporte.servicios.dabuenavida;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestConsultaSaldoTituloDabuenavida", propOrder = {"dataHeader", "data"})
public class RequestConsultaSaldoTituloDabuenavida
        implements Serializable {

    @XmlElement(name = "DataHeader", required = true)
    protected ConsultaSaldoTituloDabuenavidaDataHeaderType dataHeader;
    @XmlElement(name = "Data", required = true)
    protected ConsultaSaldoTituloDabuenavidaDataType data;

    public ConsultaSaldoTituloDabuenavidaDataHeaderType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(ConsultaSaldoTituloDabuenavidaDataHeaderType value) {
        this.dataHeader = value;
    }

    public ConsultaSaldoTituloDabuenavidaDataType getData() {
        return this.data;
    }

    public void setData(ConsultaSaldoTituloDabuenavidaDataType value) {
        this.data = value;
    }

    public String toString() {
        return "RequestConsultaSaldoTituloDabuenavida{dataHeader=" + this.dataHeader + ", data=" + this.data + '}';
    }
}
