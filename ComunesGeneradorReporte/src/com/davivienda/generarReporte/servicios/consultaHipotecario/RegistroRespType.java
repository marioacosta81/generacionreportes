package com.davivienda.generarReporte.servicios.consultaHipotecario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistroRespType", propOrder = {})
public class RegistroRespType {

    @XmlElement(required = true)
    protected String titularidad;
    protected short tipoIdTitular;
    protected long noIdPropetario;
    @XmlElement(required = true)
    protected String nombresYApellidos;

    public String getTitularidad() {
        return this.titularidad;
    }

    public void setTitularidad(String value) {
        this.titularidad = value;
    }

    public short getTipoIdTitular() {
        return this.tipoIdTitular;
    }

    public void setTipoIdTitular(short value) {
        this.tipoIdTitular = value;
    }

    public long getNoIdPropetario() {
        return this.noIdPropetario;
    }

    public void setNoIdPropetario(long value) {
        this.noIdPropetario = value;
    }

    public String getNombresYApellidos() {
        return this.nombresYApellidos;
    }

    public void setNombresYApellidos(String value) {
        this.nombresYApellidos = value;
    }
}
