package com.davivienda.filenet.srvscngestorfilenet.v1;

import com.davivienda.esquemas.filenet.documentotipo.v1.DocumentoTipo;
import com.davivienda.esquemas.framework.contextosolicitudtipo.v1.ContextoSolicitudTipo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsjSolOpCargarDocumento", propOrder = {"contextoSolicitud", "documento"})
public class MsjSolOpCargarDocumento {

    @XmlElement(required = true)
    protected ContextoSolicitudTipo contextoSolicitud;
    @XmlElement(required = true)
    protected DocumentoTipo documento;
    @XmlElement(required = false)
    protected String idProcesoDocumento; 
   
    public ContextoSolicitudTipo getContextoSolicitud() {
        return this.contextoSolicitud;
    }

    public void setContextoSolicitud(ContextoSolicitudTipo value) {
        this.contextoSolicitud = value;
    }

    public DocumentoTipo getDocumento() {
        return this.documento;
    }

    public void setDocumento(DocumentoTipo value) {
        this.documento = value;
    }

    public String getIdProcesoDocumento() {
        return idProcesoDocumento;
    }

    public void setIdProcesoDocumento(String idProcesoDocumento) {
        this.idProcesoDocumento = idProcesoDocumento;
    }
}
