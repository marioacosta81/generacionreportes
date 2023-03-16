package com.davivienda.generarReporte.servicios.representativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestDocumentosRepresentativosUnificadaType", propOrder = {"dataHeader", "data"})
public class RequestDocumentosRepresentativosUnificadaType {

    @XmlElement(name = "DataHeader", required = true)
    protected DataHeaderReqType dataHeader;
    @XmlElement(name = "Data", required = true)
    protected DataReqType data;

    public DataHeaderReqType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(DataHeaderReqType value) {
        this.dataHeader = value;
    }

    public DataReqType getData() {
        return this.data;
    }

    public void setData(DataReqType value) {
        this.data = value;
    }
}
