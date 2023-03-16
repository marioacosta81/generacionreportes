package com.davivienda.generarReporte.servicios.certificacionCDT;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestGeneracionDeCertificacionDeCDTs", propOrder = {"dataHeader", "data"})
public class RequestGeneracionDeCertificacionDeCDTs
        implements Serializable {

    @XmlElement(name = "DataHeader", required = true)
    protected GeneracionDeCertificacionDeCDTsDataHeaderType dataHeader;
    @XmlElement(name = "Data", required = true)
    protected GeneracionDeCertificacionDeCDTsDataType data;

    public GeneracionDeCertificacionDeCDTsDataHeaderType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(GeneracionDeCertificacionDeCDTsDataHeaderType value) {
        this.dataHeader = value;
    }

    public GeneracionDeCertificacionDeCDTsDataType getData() {
        return this.data;
    }

    public void setData(GeneracionDeCertificacionDeCDTsDataType value) {
        this.data = value;
    }

    public String toString() {
        return "RequestGeneracionDeCertificacionDeCDTs{dataHeader=" + this.dataHeader + ", data=" + this.data + '}';
    }
}
