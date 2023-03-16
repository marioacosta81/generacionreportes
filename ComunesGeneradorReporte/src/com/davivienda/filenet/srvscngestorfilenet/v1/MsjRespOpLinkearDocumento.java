package com.davivienda.filenet.srvscngestorfilenet.v1;

import com.davivienda.esquemas.framework.contextorespuestatipo.v1.ContextoRespuestaTipo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsjRespOpLinkearDocumento", propOrder = {"contextoRespuesta"})
public class MsjRespOpLinkearDocumento {

    @XmlElement(required = true)
    protected ContextoRespuestaTipo contextoRespuesta;

    public ContextoRespuestaTipo getContextoRespuesta() {
        return this.contextoRespuesta;
    }

    public void setContextoRespuesta(ContextoRespuestaTipo value) {
        this.contextoRespuesta = value;
    }
}
