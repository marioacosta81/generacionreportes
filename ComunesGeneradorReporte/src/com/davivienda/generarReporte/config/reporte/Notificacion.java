package com.davivienda.generarReporte.config.reporte;

import com.davivienda.notificaciones.srvscnnotificacionesmail.v1.MensajeTipo;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"tipoNotificacion", "mensaje"})
public class Notificacion
        implements Serializable {

    private String tipoNotificacion;
    private MensajeTipo mensaje;

    public String getTipoNotificacion() {
        return this.tipoNotificacion;
    }

    public void setTipoNotificacion(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public MensajeTipo getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(MensajeTipo mensaje) {
        this.mensaje = mensaje;
    }
}
