package com.davivienda.generarReporte.servicios.saldosCtaCte;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaDeTransaccionBaseDTO", propOrder = {"caracterAcepta", "codMRespuesta", "consecutivo", "llaveRepetitivoSiguienteTrama", "mRespuesta", "numeroLineas", "respuestaOriginal", "tieneMasRegistros", "total", "ultimoMensaje"})
@XmlSeeAlso({RespuestaConsultaSaldoCuentaCorrienteIIDto.class})
public class RespuestaDeTransaccionBaseDTO {

    protected String caracterAcepta;
    protected Short codMRespuesta;
    protected Integer consecutivo;
    @XmlElement(nillable = true)
    protected List<CampoExtendidoDto> llaveRepetitivoSiguienteTrama;
    @XmlElement(name = "MRespuesta")
    protected String mRespuesta;
    protected Short numeroLineas;
    protected String respuestaOriginal;
    protected Boolean tieneMasRegistros;
    protected Integer total;
    protected Short ultimoMensaje;

    public String getCaracterAcepta() {
        return this.caracterAcepta;
    }

    public void setCaracterAcepta(String value) {
        this.caracterAcepta = value;
    }

    public Short getCodMRespuesta() {
        return this.codMRespuesta;
    }

    public void setCodMRespuesta(Short value) {
        this.codMRespuesta = value;
    }

    public Integer getConsecutivo() {
        return this.consecutivo;
    }

    public void setConsecutivo(Integer value) {
        this.consecutivo = value;
    }

    public List<CampoExtendidoDto> getLlaveRepetitivoSiguienteTrama() {
        if (this.llaveRepetitivoSiguienteTrama == null) {
            this.llaveRepetitivoSiguienteTrama = new ArrayList<CampoExtendidoDto>();
        }
        return this.llaveRepetitivoSiguienteTrama;
    }

    public String getMRespuesta() {
        return this.mRespuesta;
    }

    public void setMRespuesta(String value) {
        this.mRespuesta = value;
    }

    public Short getNumeroLineas() {
        return this.numeroLineas;
    }

    public void setNumeroLineas(Short value) {
        this.numeroLineas = value;
    }

    public String getRespuestaOriginal() {
        return this.respuestaOriginal;
    }

    public void setRespuestaOriginal(String value) {
        this.respuestaOriginal = value;
    }

    public Boolean isTieneMasRegistros() {
        return this.tieneMasRegistros;
    }

    public void setTieneMasRegistros(Boolean value) {
        this.tieneMasRegistros = value;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer value) {
        this.total = value;
    }

    public Short getUltimoMensaje() {
        return this.ultimoMensaje;
    }

    public void setUltimoMensaje(Short value) {
        this.ultimoMensaje = value;
    }
}
