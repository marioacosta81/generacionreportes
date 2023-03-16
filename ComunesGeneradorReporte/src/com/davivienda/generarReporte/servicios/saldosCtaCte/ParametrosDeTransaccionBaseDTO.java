package com.davivienda.generarReporte.servicios.saldosCtaCte;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parametrosDeTransaccionBaseDTO", propOrder = {"canal", "host", "idTarea", "identificadorOperacion", "identificadorSesion", "jornada", "llaveRepetitivaConsulta", "modoDeOperacion", "origenLog", "parametrosSeguridad", "perfil", "segundaClave", "total", "usuario"})
@XmlSeeAlso({ConsultaSaldoCuentaCorrienteIIDto.class})
public class ParametrosDeTransaccionBaseDTO {

    protected Short canal;
    protected Integer host;
    protected String idTarea;
    protected String identificadorOperacion;
    protected String identificadorSesion;
    protected Short jornada;
    @XmlElement(nillable = true)
    protected List<CampoExtendidoDto> llaveRepetitivaConsulta;
    protected Short modoDeOperacion;
    protected String origenLog;
    protected ParametrosSeguridadDTO parametrosSeguridad;
    protected Short perfil;
    protected String segundaClave;
    protected Integer total;
    protected String usuario;

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

    public String getOrigenLog() {
        return this.origenLog;
    }

    public void setOrigenLog(String value) {
        this.origenLog = value;
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
}
