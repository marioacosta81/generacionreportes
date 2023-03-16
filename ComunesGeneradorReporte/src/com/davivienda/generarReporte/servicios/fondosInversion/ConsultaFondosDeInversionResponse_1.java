package com.davivienda.generarReporte.servicios.fondosInversion;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaFondosDeInversionResponse_1", propOrder = {"response"})
public class ConsultaFondosDeInversionResponse_1
        implements Serializable {

    @XmlElement(name = "Response", required = true)
    protected ResponseConsultaFondosDeInversion response;

    public ResponseConsultaFondosDeInversion getResponse() {
        return this.response;
    }

    public void setResponse(ResponseConsultaFondosDeInversion value) {
        this.response = value;
    }
}
