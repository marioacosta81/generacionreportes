package com.davivienda.notificaciones.srvscnnotificacionesmail.v1;

import com.davivienda.esquemas.framework.contextorespuestatipo.v1.ContextoRespuestaTipo;
import com.davivienda.esquemas.persona.clientenaturaltipo.v1.ClienteNaturalTipo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsjRespOpEnviarMail", propOrder = {"contextoRespuesta", "clienteNatural", "codActivacion", "codTipoToken", "tipoAutenticacion", "estadoClaveVirtual", "notificarAlCorreo"})
public class MsjRespOpEnviarMail {

    @XmlElement(namespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", required = true)
    protected ContextoRespuestaTipo contextoRespuesta;
    @XmlElement(namespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", required = true)
    protected ClienteNaturalTipo clienteNatural;
    @XmlElement(namespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1")
    protected String codActivacion;
    @XmlElement(namespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", required = true)
    protected String codTipoToken;
    @XmlElement(namespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1")
    protected String tipoAutenticacion;
    @XmlElement(namespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1")
    protected String estadoClaveVirtual;
    @XmlElement(namespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1")
    protected Boolean notificarAlCorreo;

    public ContextoRespuestaTipo getContextoRespuesta() {
        return this.contextoRespuesta;
    }

    public void setContextoRespuesta(ContextoRespuestaTipo value) {
        this.contextoRespuesta = value;
    }

    public ClienteNaturalTipo getClienteNatural() {
        return this.clienteNatural;
    }

    public void setClienteNatural(ClienteNaturalTipo value) {
        this.clienteNatural = value;
    }

    public String getCodActivacion() {
        return this.codActivacion;
    }

    public void setCodActivacion(String value) {
        this.codActivacion = value;
    }

    public String getCodTipoToken() {
        return this.codTipoToken;
    }

    public void setCodTipoToken(String value) {
        this.codTipoToken = value;
    }

    public String getTipoAutenticacion() {
        return this.tipoAutenticacion;
    }

    public void setTipoAutenticacion(String value) {
        this.tipoAutenticacion = value;
    }

    public String getEstadoClaveVirtual() {
        return this.estadoClaveVirtual;
    }

    public void setEstadoClaveVirtual(String value) {
        this.estadoClaveVirtual = value;
    }

    public Boolean isNotificarAlCorreo() {
        return this.notificarAlCorreo;
    }

    public void setNotificarAlCorreo(Boolean value) {
        this.notificarAlCorreo = value;
    }
}
