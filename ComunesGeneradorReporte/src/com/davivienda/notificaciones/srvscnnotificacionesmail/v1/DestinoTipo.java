package com.davivienda.notificaciones.srvscnnotificacionesmail.v1;

import com.davivienda.esquemas.persona.clientenaturaltipo.v1.ClienteNaturalTipo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DestinoTipo", propOrder = {"cliente", "valMail"})
public class DestinoTipo {

    @XmlElement(required = true)
    protected ClienteNaturalTipo cliente;
    protected String valMail;

    public ClienteNaturalTipo getCliente() {
        return this.cliente;
    }

    public void setCliente(ClienteNaturalTipo value) {
        this.cliente = value;
    }

    public String getValMail() {
        return this.valMail;
    }

    public void setValMail(String value) {
        this.valMail = value;
    }
}
