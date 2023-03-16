package com.davivienda.generarReporte.servicios.fondosInversion;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseConsultaFondosDeInversion", propOrder = {"dataHeader", "data"})
public class ResponseConsultaFondosDeInversion
        implements Serializable {

    @XmlElement(name = "DataHeader", required = true)
    protected DataHeaderRespType dataHeader;
    @XmlElement(name = "Data")
    protected ConsultaFondosDeInversionDataResp data;

    public DataHeaderRespType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(DataHeaderRespType value) {
        this.dataHeader = value;
    }

    public ConsultaFondosDeInversionDataResp getData() {
        return this.data;
    }

    public void setData(ConsultaFondosDeInversionDataResp value) {
        this.data = value;
    }

    public String toString() {
        return "ResponseConsultaFondosDeInversion{dataHeader=" + this.dataHeader + ", data=" + this.data + '}';
    }
}
