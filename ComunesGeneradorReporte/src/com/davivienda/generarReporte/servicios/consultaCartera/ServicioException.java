package com.davivienda.generarReporte.servicios.consultaCartera;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServicioException", propOrder = {"codMRespuesta", "mensaje", "total"})
public class ServicioException
        implements Serializable {

    @XmlElement(required = true, type = Short.class, nillable = true)
    protected Short codMRespuesta;
    @XmlElement(required = true, nillable = true)
    protected String mensaje;
    @XmlElement(required = true, type = Integer.class, nillable = true)
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

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer value) {
        this.total = value;
    }
}
