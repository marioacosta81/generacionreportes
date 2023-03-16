package com.davivienda.generarReporte.servicios.saldosCtaCte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServicioException", propOrder = {"codMRespuesta", "mensaje", "message", "total"})
public class ServicioException {

    protected Short codMRespuesta;
    protected String mensaje;
    protected String message;
    protected Integer total;

    public Short getCodMRespuesta() {
        return this.codMRespuesta;
    }

    public void setCodMRespuesta(Short value) {
        this.codMRespuesta = value;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String value) {
        this.mensaje = value;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer value) {
        this.total = value;
    }
}
