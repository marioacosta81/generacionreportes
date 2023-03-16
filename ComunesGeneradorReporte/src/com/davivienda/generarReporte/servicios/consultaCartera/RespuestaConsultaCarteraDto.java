package com.davivienda.generarReporte.servicios.consultaCartera;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaConsultaCarteraDto", propOrder = {"codigoStatus", "descripcionStatus", "total", "indicador", "nombre", "numeroId", "registrosRepetitivos", "tipoId"})
public class RespuestaConsultaCarteraDto
        implements Serializable {

    @XmlElement(required = true, nillable = true)
    protected String codigoStatus;
    @XmlElement(required = true, nillable = true)
    protected String descripcionStatus;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer total;
    @XmlElement(required = true, type = Short.class, nillable = true)
    protected Short indicador;
    @XmlElement(required = true, nillable = true)
    protected String nombre;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long numeroId;
    @XmlElement(nillable = true)
    protected List<RespConsultaCarteraRepDto> registrosRepetitivos;
    @XmlElement(required = true, type = Short.class, nillable = true)
    protected Short tipoId;

    public String getCodigoStatus() {
        return this.codigoStatus;
    }

    public void setCodigoStatus(String value) {
        this.codigoStatus = value;
    }

    public String getDescripcionStatus() {
        return this.descripcionStatus;
    }

    public void setDescripcionStatus(String value) {
        this.descripcionStatus = value;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer value) {
        this.total = value;
    }

    public Short getIndicador() {
        return this.indicador;
    }

    public void setIndicador(Short value) {
        this.indicador = value;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String value) {
        this.nombre = value;
    }

    public Long getNumeroId() {
        return this.numeroId;
    }

    public void setNumeroId(Long value) {
        this.numeroId = value;
    }

    public List<RespConsultaCarteraRepDto> getRegistrosRepetitivos() {
        if (this.registrosRepetitivos == null) {
            this.registrosRepetitivos = new ArrayList<RespConsultaCarteraRepDto>();
        }
        return this.registrosRepetitivos;
    }

    public Short getTipoId() {
        return this.tipoId;
    }

    public void setTipoId(Short value) {
        this.tipoId = value;
    }

    public String toString() {
        return "RespuestaConsultaCarteraDto{codigoStatus=" + this.codigoStatus + ", descripcionStatus=" + this.descripcionStatus + ", total=" + this.total + ", indicador=" + this.indicador + ", nombre=" + this.nombre + ", numeroId=" + this.numeroId + ", registrosRepetitivos=" + this.registrosRepetitivos + ", tipoId=" + this.tipoId + '}';
    }
}
