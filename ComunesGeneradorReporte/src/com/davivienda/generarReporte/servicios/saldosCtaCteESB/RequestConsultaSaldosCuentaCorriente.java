package com.davivienda.generarReporte.servicios.saldosCtaCteESB;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestConsultaSaldosCuentaCorriente", propOrder = {"dataHeader", "data"})
public class RequestConsultaSaldosCuentaCorriente
        implements Serializable {

    @XmlElement(name = "DataHeader", required = true)
    protected ConsultaSaldosCuentaCorrienteDataHeaderType dataHeader;
    @XmlElement(name = "Data", required = true)
    protected ConsultaSaldosCuentaCorrienteDataType data;

    public ConsultaSaldosCuentaCorrienteDataHeaderType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(ConsultaSaldosCuentaCorrienteDataHeaderType value) {
        this.dataHeader = value;
    }

    public ConsultaSaldosCuentaCorrienteDataType getData() {
        return this.data;
    }

    public void setData(ConsultaSaldosCuentaCorrienteDataType value) {
        this.data = value;
    }
}
