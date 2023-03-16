package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import com.davivienda.esquemas.framework.contextorespuestatipo.v1.ContextoRespuestaTipo;
import com.davivienda.esquemas.generarreporte.respuestacertificadotipo.v1.RespuestaCertificadoTipo;
import com.ibm.comunes.servicios.SCNMensajeSalida;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsjRespOpGeneracionReporte", propOrder = {"contextoRespuesta", "respuestaCertificado", "valDocumentoGenerado", "valFormatoDocumentoGenerado"})
public class MsjRespOpGeneracionReporte
        implements Serializable, SCNMensajeSalida {

    @XmlElement(required = true)
    protected ContextoRespuestaTipo contextoRespuesta;
    @XmlElement(required = true)
    protected RespuestaCertificadoTipo respuestaCertificado;
    @XmlElement(namespace = "")
    protected String valDocumentoGenerado;
    protected String valFormatoDocumentoGenerado;

    public ContextoRespuestaTipo getContextoRespuesta() {
        return this.contextoRespuesta;
    }

    public void setContextoRespuesta(ContextoRespuestaTipo value) {
        this.contextoRespuesta = value;
    }

    public RespuestaCertificadoTipo getRespuestaCertificado() {
        return this.respuestaCertificado;
    }

    public void setRespuestaCertificado(RespuestaCertificadoTipo value) {
        this.respuestaCertificado = value;
    }

    public String getValDocumentoGenerado() {
        return this.valDocumentoGenerado;
    }

    public void setValDocumentoGenerado(String value) {
        this.valDocumentoGenerado = value;
    }

    public String getValFormatoDocumentoGenerado() {
        return this.valFormatoDocumentoGenerado;
    }

    public void setValFormatoDocumentoGenerado(String value) {
        this.valFormatoDocumentoGenerado = value;
    }
}
