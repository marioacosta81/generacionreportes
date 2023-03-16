package com.davivienda.notificaciones.srvscnnotificacionesmail.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataMail", propOrder = {"tipoNotificacion", "destino", "mensaje", "adjuntos", "isEsperaRespuesta"})
public class DataMail {

    @XmlElement(required = true)
    protected String tipoNotificacion;
    @XmlElement(required = true)
    protected DestinoTipo destino;
    @XmlElement(required = true)
    protected MensajeTipo mensaje;
    @XmlElement(nillable = true)
    protected List<AdjuntoTipo> adjuntos;
    protected boolean isEsperaRespuesta;

    public String getTipoNotificacion() {
        return this.tipoNotificacion;
    }

    public void setTipoNotificacion(String value) {
        this.tipoNotificacion = value;
    }

    public DestinoTipo getDestino() {
        return this.destino;
    }

    public void setDestino(DestinoTipo value) {
        this.destino = value;
    }

    public MensajeTipo getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(MensajeTipo value) {
        this.mensaje = value;
    }

    public List<AdjuntoTipo> getAdjuntos() {
        if (this.adjuntos == null) {
            this.adjuntos = new ArrayList<AdjuntoTipo>();
        }
        return this.adjuntos;
    }

    public boolean isIsEsperaRespuesta() {
        return this.isEsperaRespuesta;
    }

    public void setIsEsperaRespuesta(boolean value) {
        this.isEsperaRespuesta = value;
    }
}
