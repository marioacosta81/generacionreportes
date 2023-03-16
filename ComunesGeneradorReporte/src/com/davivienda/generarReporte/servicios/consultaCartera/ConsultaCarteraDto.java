package com.davivienda.generarReporte.servicios.consultaCartera;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaCarteraDto", propOrder = {"identificadorOperacion", "identificadorSesion", "origenLog", "canal", "host", "idTarea", "jornada", "llaveRepetitivaConsulta", "modoDeOperacion", "parametrosSeguridad", "perfil", "segundaClave", "total", "usuario", "indicador", "numeroId", "tipoId"})
public class ConsultaCarteraDto
        implements Serializable {

    @XmlElement(required = true, nillable = true)
    protected String identificadorOperacion;
    @XmlElement(required = true, nillable = true)
    protected String identificadorSesion;
    @XmlElement(required = true, nillable = true)
    protected String origenLog;
    @XmlElement(required = true, type = Short.class, nillable = true)
    protected Short canal;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer host;
    @XmlElement(required = true, nillable = true)
    protected String idTarea;
    @XmlElement(required = true, type = Short.class, nillable = true)
    protected Short jornada;
    @XmlElement(nillable = true)
    protected List<CampoExtendidoDto> llaveRepetitivaConsulta;
    @XmlElement(required = true, type = Short.class, nillable = true)
    protected Short modoDeOperacion;
    @XmlElement(required = true, nillable = true)
    protected ParametrosSeguridadDTO parametrosSeguridad;
    @XmlElement(required = true, type = Short.class, nillable = true)
    protected Short perfil;
    @XmlElement(required = true, nillable = true)
    protected String segundaClave;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer total;
    @XmlElement(required = true, nillable = true)
    protected String usuario;
    @XmlElement(required = true, type = Short.class, nillable = true)
    protected Short indicador;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long numeroId;
    @XmlElement(required = true, type = Short.class, nillable = true)
    protected Short tipoId;

    public String getIdentificadorOperacion() {
        return this.identificadorOperacion;
    }

    public void setIdentificadorOperacion(String value) {
        this.identificadorOperacion = value;
    }

    public String getIdentificadorSesion() {
        return this.identificadorSesion;
    }

    public void setIdentificadorSesion(String value) {
        this.identificadorSesion = value;
    }

    public String getOrigenLog() {
        return this.origenLog;
    }

    public void setOrigenLog(String value) {
        this.origenLog = value;
    }

    public Short getCanal() {
        return this.canal;
    }

    public void setCanal(Short value) {
        this.canal = value;
    }

    public Integer getHost() {
        return this.host;
    }

    public void setHost(Integer value) {
        this.host = value;
    }

    public String getIdTarea() {
        return this.idTarea;
    }

    public void setIdTarea(String value) {
        this.idTarea = value;
    }

    public Short getJornada() {
        return this.jornada;
    }

    public void setJornada(Short value) {
        this.jornada = value;
    }

    public List<CampoExtendidoDto> getLlaveRepetitivaConsulta() {
        if (this.llaveRepetitivaConsulta == null) {
            this.llaveRepetitivaConsulta = new ArrayList<CampoExtendidoDto>();
        }
        return this.llaveRepetitivaConsulta;
    }

    public Short getModoDeOperacion() {
        return this.modoDeOperacion;
    }

    public void setModoDeOperacion(Short value) {
        this.modoDeOperacion = value;
    }

    public ParametrosSeguridadDTO getParametrosSeguridad() {
        return this.parametrosSeguridad;
    }

    public void setParametrosSeguridad(ParametrosSeguridadDTO value) {
        this.parametrosSeguridad = value;
    }

    public Short getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Short value) {
        this.perfil = value;
    }

    public String getSegundaClave() {
        return this.segundaClave;
    }

    public void setSegundaClave(String value) {
        this.segundaClave = value;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer value) {
        this.total = value;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String value) {
        this.usuario = value;
    }

    public Short getIndicador() {
        return this.indicador;
    }

    public void setIndicador(Short value) {
        this.indicador = value;
    }

    public Long getNumeroId() {
        return this.numeroId;
    }

    public void setNumeroId(Long value) {
        this.numeroId = value;
    }

    public Short getTipoId() {
        return this.tipoId;
    }

    public void setTipoId(Short value) {
        this.tipoId = value;
    }

    public String toString() {
        return "ConsultaCarteraDto{identificadorOperacion=" + this.identificadorOperacion + ", identificadorSesion=" + this.identificadorSesion + ", origenLog=" + this.origenLog + ", canal=" + this.canal + ", host=" + this.host + ", idTarea=" + this.idTarea + ", jornada=" + this.jornada + ", modoDeOperacion=" + this.modoDeOperacion + ", parametrosSeguridad=" + this.parametrosSeguridad + ", perfil=" + this.perfil + ", segundaClave=" + this.segundaClave + ", total=" + this.total + ", usuario=" + this.usuario + ", indicador=" + this.indicador + ", numeroId=" + this.numeroId + ", tipoId=" + this.tipoId + '}';
    }
}
