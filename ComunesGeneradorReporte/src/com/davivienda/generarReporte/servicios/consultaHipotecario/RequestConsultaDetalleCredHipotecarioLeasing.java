package com.davivienda.generarReporte.servicios.consultaHipotecario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestConsultaDetalleCredHipotecarioLeasing", propOrder = {"dataHeader", "data"})
public class RequestConsultaDetalleCredHipotecarioLeasing {

    @XmlElement(name = "DataHeader", required = true)
    protected ConsultaDetalleCredHipotecarioLeasingDataHeaderType dataHeader;
    @XmlElement(name = "Data", required = true)
    protected ConsultaDetalleCredHipotecarioLeasingDataType data;

    public ConsultaDetalleCredHipotecarioLeasingDataHeaderType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(ConsultaDetalleCredHipotecarioLeasingDataHeaderType value) {
        this.dataHeader = value;
    }

    public ConsultaDetalleCredHipotecarioLeasingDataType getData() {
        return this.data;
    }

    public void setData(ConsultaDetalleCredHipotecarioLeasingDataType value) {
        this.data = value;
    }
}
