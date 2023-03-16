package com.davivienda.generarReporte.servicios.saldosCtaCte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaSaldoCuentaCorrienteResponse", propOrder = {"_return"})
public class ConsultaSaldoCuentaCorrienteResponse {

    @XmlElement(name = "return")
    protected RespuestaConsultaSaldoCuentaCorrienteIIDto _return;

    public RespuestaConsultaSaldoCuentaCorrienteIIDto getReturn() {
        return this._return;
    }

    public void setReturn(RespuestaConsultaSaldoCuentaCorrienteIIDto value) {
        this._return = value;
    }
}
