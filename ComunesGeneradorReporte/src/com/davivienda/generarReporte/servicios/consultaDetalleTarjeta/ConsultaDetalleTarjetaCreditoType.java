package com.davivienda.generarReporte.servicios.consultaDetalleTarjeta;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaDetalleTarjetaCreditoType", propOrder = {"request"})
public class ConsultaDetalleTarjetaCreditoType
        implements Serializable {

    @XmlElement(name = "Request", required = true)
    protected RequestConsultaDetalleTarjetaCredito request;

    public RequestConsultaDetalleTarjetaCredito getRequest() {
        return this.request;
    }

    public void setRequest(RequestConsultaDetalleTarjetaCredito value) {
        this.request = value;
    }
}
