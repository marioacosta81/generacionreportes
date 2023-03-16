package com.davivienda.filenet.srvscngestorfilenet.v1;

import com.davivienda.esquemas.framework.contextosolicitudtipo.v1.ContextoSolicitudTipo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsjSolOpLinkearDocumento", propOrder = {"contextoSolicitud", "valIdDocumento", "valRuta"})
public class MsjSolOpLinkearDocumento {

    @XmlElement(required = true)
    protected ContextoSolicitudTipo contextoSolicitud;
    @XmlElement(required = true)
    protected String valIdDocumento;
    @XmlElement(required = true)
    protected String valRuta;

    public ContextoSolicitudTipo getContextoSolicitud() {
        return this.contextoSolicitud;
    }

    public void setContextoSolicitud(ContextoSolicitudTipo value) {
        this.contextoSolicitud = value;
    }

    public String getValIdDocumento() {
        return this.valIdDocumento;
    }

    public void setValIdDocumento(String value) {
        this.valIdDocumento = value;
    }

    public String getValRuta() {
        return this.valRuta;
    }

    public void setValRuta(String value) {
        this.valRuta = value;
    }
}
