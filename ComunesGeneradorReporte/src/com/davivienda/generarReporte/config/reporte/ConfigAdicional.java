package com.davivienda.generarReporte.config.reporte;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "configParticular")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"listaPlantillas", "listaCertificados", "listaTiposIdentificacion", "listaCodigosProducto", "listaUnidades", "listaHomologar"})
public class ConfigAdicional
        implements Serializable {

    private Plantillas listaPlantillas;
    private Certificados listaCertificados;
    private TiposIdentificacion listaTiposIdentificacion;
    private CodigosProducto listaCodigosProducto;
    private Unidades listaUnidades;
    private Homologos listaHomologar;

    public Plantillas getListaPlantillas() {
        return this.listaPlantillas;
    }

    public void setListaPlantillas(Plantillas listaPlantillas) {
        this.listaPlantillas = listaPlantillas;
    }

    public Certificados getListaCertificados() {
        return this.listaCertificados;
    }

    public void setListaCertificados(Certificados listaCertificados) {
        this.listaCertificados = listaCertificados;
    }

    public TiposIdentificacion getListaTiposIdentificacion() {
        return this.listaTiposIdentificacion;
    }

    public void setListaTiposIdentificacion(TiposIdentificacion listaTiposIdentificacion) {
        this.listaTiposIdentificacion = listaTiposIdentificacion;
    }

    public CodigosProducto getListaCodigosProducto() {
        return this.listaCodigosProducto;
    }

    public void setListaCodigosProducto(CodigosProducto listaCodigosProducto) {
        this.listaCodigosProducto = listaCodigosProducto;
    }

    public Unidades getListaUnidades() {
        return this.listaUnidades;
    }

    public void setListaUnidades(Unidades listaUnidades) {
        this.listaUnidades = listaUnidades;
    }

    public Homologos getListaHomologos() {
        return this.listaHomologar;
    }

    public void setListaHomologos(Homologos listaHomologar) {
        this.listaHomologar = listaHomologar;
    }
}
