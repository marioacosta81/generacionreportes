package com.davivienda.generarReporte.servicios;

import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DataProductosCarteraESB")
public class RespuestaServicios {

    private List<ProductoCartera> listProductosCartera;
    private Map<String, Object> mapRespuestaDinamico;

    public Map<String, Object> getMapRespuestaDinamico() {
        return this.mapRespuestaDinamico;
    }

    public void setMapRespuestaDinamico(Map<String, Object> mapRespuestaDinamico) {
        this.mapRespuestaDinamico = mapRespuestaDinamico;
    }

    @XmlElementWrapper(name = "productosCarteraESBList")
    @XmlElement(name = "productoCartera")
    public List<ProductoCartera> getListProductosCartera() {
        return this.listProductosCartera;
    }

    public void setListProductosCartera(List<ProductoCartera> listProductosCartera) {
        this.listProductosCartera = listProductosCartera;
    }
}
