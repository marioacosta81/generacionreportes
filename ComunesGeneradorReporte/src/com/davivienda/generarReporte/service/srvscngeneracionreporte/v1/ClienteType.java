package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClienteType", propOrder = {"nombres", "primerApellido", "segundoApellido", "tipoIdentificacion", "numeroIdentificacion", "ciudadExpedicionDocumento", "valMail", "valCCMail"})
public class ClienteType
        implements Serializable {

    protected String nombres;
    protected String primerApellido;
    protected String segundoApellido;
    protected String tipoIdentificacion;
    protected String numeroIdentificacion;
    protected String ciudadExpedicionDocumento;
    protected String valMail;
    protected String valCCMail;

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String value) {
        this.nombres = value;
    }

    public String getPrimerApellido() {
        return this.primerApellido;
    }

    public void setPrimerApellido(String value) {
        this.primerApellido = value;
    }

    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    public void setSegundoApellido(String value) {
        this.segundoApellido = value;
    }

    public String getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }

    public void setTipoIdentificacion(String value) {
        this.tipoIdentificacion = value;
    }

    public String getNumeroIdentificacion() {
        return this.numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String value) {
        this.numeroIdentificacion = value;
    }

    public String getCiudadExpedicionDocumento() {
        return this.ciudadExpedicionDocumento;
    }

    public void setCiudadExpedicionDocumento(String value) {
        this.ciudadExpedicionDocumento = value;
    }

    public String getValMail() {
        return this.valMail;
    }

    public void setValMail(String value) {
        this.valMail = value;
    }

    public String getValCCMail() {
        return this.valCCMail;
    }

    public void setValCCMail(String value) {
        this.valCCMail = value;
    }
}
