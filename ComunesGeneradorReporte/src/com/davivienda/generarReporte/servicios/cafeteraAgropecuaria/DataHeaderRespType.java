package com.davivienda.generarReporte.servicios.cafeteraAgropecuaria;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataHeaderRespType", propOrder = {"nombreOperacion", "total", "caracterAceptacion", "ultimoMensaje", "codMsgRespuesta", "msgRespuesta"})
public class DataHeaderRespType
        implements Serializable {

    @XmlElement(required = true)
    protected String nombreOperacion;
    protected int total;
    @XmlElement(required = true)
    protected String caracterAceptacion;
    protected short ultimoMensaje;
    protected short codMsgRespuesta;
    protected String msgRespuesta;

    public String getNombreOperacion() {
        return this.nombreOperacion;
    }

    public void setNombreOperacion(String value) {
        this.nombreOperacion = value;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int value) {
        this.total = value;
    }

    public String getCaracterAceptacion() {
        return this.caracterAceptacion;
    }

    public void setCaracterAceptacion(String value) {
        this.caracterAceptacion = value;
    }

    public short getUltimoMensaje() {
        return this.ultimoMensaje;
    }

    public void setUltimoMensaje(short value) {
        this.ultimoMensaje = value;
    }

    public short getCodMsgRespuesta() {
        return this.codMsgRespuesta;
    }

    public void setCodMsgRespuesta(short value) {
        this.codMsgRespuesta = value;
    }

    public String getMsgRespuesta() {
        return this.msgRespuesta;
    }

    public void setMsgRespuesta(String value) {
        this.msgRespuesta = value;
    }
}
