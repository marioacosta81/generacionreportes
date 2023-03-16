package com.davivienda.esquemas.generarreporte.respuestacertificadotipo.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaCertificadoTipo", propOrder = {"contenido", "mimeType"})
public class RespuestaCertificadoTipo
        implements Serializable {

    @XmlElement(required = true)
    @XmlMimeType("application/octet-stream")
    protected byte[] contenido;
    @XmlElement(required = true)
    protected String mimeType;

    public byte[] getContenido() {
        return this.contenido;
    }

    public void setContenido(byte[] value) {
        this.contenido = value;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String value) {
        this.mimeType = value;
    }
}
