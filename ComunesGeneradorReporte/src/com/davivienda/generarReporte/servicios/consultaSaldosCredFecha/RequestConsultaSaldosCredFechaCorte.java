package com.davivienda.generarReporte.servicios.consultaSaldosCredFecha;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestConsultaSaldosCredFechaCorte", propOrder = {"dataHeader", "data"})
public class RequestConsultaSaldosCredFechaCorte
        implements Serializable {

    @XmlElement(name = "DataHeader", required = true)
    protected ConsultaSaldosCredFechaCorteDataHeaderType dataHeader;
    @XmlElement(name = "Data", required = true)
    protected ConsultaSaldosCredFechaCorteDataType data;

    public ConsultaSaldosCredFechaCorteDataHeaderType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(ConsultaSaldosCredFechaCorteDataHeaderType value) {
        this.dataHeader = value;
    }

    public ConsultaSaldosCredFechaCorteDataType getData() {
        return this.data;
    }

    public void setData(ConsultaSaldosCredFechaCorteDataType value) {
        this.data = value;
    }

    public String toString() {
        return "RequestConsultaSaldosCredFechaCorte{dataHeader=" + this.dataHeader + ", data=" + this.data + '}';
    }
}
