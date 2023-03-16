package com.davivienda.notificaciones.srvscnnotificacionesmail.v1;

import com.davivienda.esquemas.framework.contextosolicitudtipo.v1.ContextoSolicitudTipo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsjSolOpEnviarMail", propOrder = {"contextoSolicitud", "dataMail"})
public class MsjSolOpEnviarMail {

    
    @XmlElement(namespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", required = true)
    protected ContextoSolicitudTipo contextoSolicitud;
    @XmlElement(namespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", required = true)
    protected DataMail dataMail;

     @XmlElement(required = false)
    protected String idProcesoDocumento; 

    public ContextoSolicitudTipo getContextoSolicitud() {
        return this.contextoSolicitud;
    }

    public void setContextoSolicitud(ContextoSolicitudTipo value) {
        this.contextoSolicitud = value;
    }

    public DataMail getDataMail() {
        return this.dataMail;
    }

    public void setDataMail(DataMail value) {
        this.dataMail = value;
    }
    
        public String getIdProcesoDocumento() {
        return idProcesoDocumento;
    }

    public void setIdProcesoDocumento(String idProcesoDocumento) {
        this.idProcesoDocumento = idProcesoDocumento;
    }
}
