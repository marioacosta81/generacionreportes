package com.davivienda.generarReporte.config.reporte;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"codTipoIdentificacion", "valDescripcion"})
public class TipoIdentificacion
        implements Serializable {

    private String codTipoIdentificacion;
    private String valDescripcion;

    public String getCodTipoIdentificacion() {
        return this.codTipoIdentificacion;
    }

    public void setCodTipoIdentificacion(String codTipoIdentificacion) {
        this.codTipoIdentificacion = codTipoIdentificacion;
    }

    public String getValDescripcion() {
        return this.valDescripcion;
    }

    public void setValDescripcion(String valDescripcion) {
        this.valDescripcion = valDescripcion;
    }
}
