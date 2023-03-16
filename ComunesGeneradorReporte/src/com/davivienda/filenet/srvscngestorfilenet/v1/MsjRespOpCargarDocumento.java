package com.davivienda.filenet.srvscngestorfilenet.v1;

import com.davivienda.esquemas.framework.contextorespuestatipo.v1.ContextoRespuestaTipo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsjRespOpCargarDocumento", propOrder = {"contextoRespuesta", "valIdDocumento"})
public class MsjRespOpCargarDocumento {

    @XmlElement(required = true)
    protected ContextoRespuestaTipo contextoRespuesta;
    @XmlElement(required = true)
    protected String valIdDocumento;

    public ContextoRespuestaTipo getContextoRespuesta() {
        return this.contextoRespuesta;
    }

    public void setContextoRespuesta(ContextoRespuestaTipo value) {
        this.contextoRespuesta = value;
    }

    public String getValIdDocumento() {
        return this.valIdDocumento;
    }

    public void setValIdDocumento(String value) {
        this.valIdDocumento = value;
    }
}
