package com.davivienda.generarReporte.servicios.consultaCartera;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParametrosSeguridadDTO", propOrder = {"debeRevalidarToken", "debeValidarSegundaClave", "idSesionToken", "usaToken"})
public class ParametrosSeguridadDTO
        implements Serializable {

    protected boolean debeRevalidarToken;
    protected boolean debeValidarSegundaClave;
    @XmlElement(required = true, nillable = true)
    protected String idSesionToken;
    protected boolean usaToken;

    public boolean isDebeRevalidarToken() {
        return this.debeRevalidarToken;
    }

    public void setDebeRevalidarToken(boolean value) {
        this.debeRevalidarToken = value;
    }

    public boolean isDebeValidarSegundaClave() {
        return this.debeValidarSegundaClave;
    }

    public void setDebeValidarSegundaClave(boolean value) {
        this.debeValidarSegundaClave = value;
    }

    public String getIdSesionToken() {
        return this.idSesionToken;
    }

    public void setIdSesionToken(String value) {
        this.idSesionToken = value;
    }

    public boolean isUsaToken() {
        return this.usaToken;
    }

    public void setUsaToken(boolean value) {
        this.usaToken = value;
    }
}
