package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Parametros", propOrder = {"valParametro", "parametroTabla", "adjunto"})
public class Parametros
        implements Serializable {

    @XmlElement(required = true)
    protected List<Valor> valParametro;
    @XmlElement(required = true)
    protected List<ParametroTabla> parametroTabla;
    @XmlElement(required = true)
    protected List<AdjuntoTipo> adjunto;

    public List<Valor> getValParametro() {
        if (this.valParametro == null) {
            this.valParametro = new ArrayList<Valor>();
        }
        return this.valParametro;
    }

    public List<ParametroTabla> getParametroTabla() {
        if (this.parametroTabla == null) {
            this.parametroTabla = new ArrayList<ParametroTabla>();
        }
        return this.parametroTabla;
    }

    public List<AdjuntoTipo> getAdjunto() {
        if (this.adjunto == null) {
            this.adjunto = new ArrayList<AdjuntoTipo>();
        }
        return this.adjunto;
    }

    public void setValParametro(List<Valor> valParametro) {
        this.valParametro = valParametro;
    }

    public void setParametroTabla(List<ParametroTabla> parametroTabla) {
        this.parametroTabla = parametroTabla;
    }

    public void setAdjunto(List<AdjuntoTipo> adjunto) {
        this.adjunto = adjunto;
    }
}
