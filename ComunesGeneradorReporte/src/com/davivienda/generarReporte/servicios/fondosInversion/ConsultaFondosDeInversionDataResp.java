package com.davivienda.generarReporte.servicios.fondosInversion;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaFondosDeInversionDataResp", propOrder = {"cuentaDebito", "fechaPrimerAporte", "fechaPrimerApertura", "saldoTotal", "saldoRetOficina", "valorPignorado", "valorCanje", "valorContingente", "cuentaRetiros", "entidadRetiros", "valorProgramar", "saldoCancelacion", "fechaVencimiento", "saldoDispRetAfc", "valorCancTransfer", "tipoPlan", "objetivo", "valorApertura", "valorAportePeriodico", "periodicidad", "fechaAportePeriodico", "rentabilidadMes", "rentabilidadAno", "rentabilidad3Anos", "tipoIdentificacion", "numeroIdentificacion", "codigoSubproducto", "nombrePlan", "nitEmpleador", "fechaPago", "saldoSinAfectar", "saldoConsolidado", "saldoNoConsolidado", "saldoInmovilizado", "saldoAportesPdteApl", "saldoProgPdteApl", "saldoRetirosPdtePag", "saldoRetirosProg", "indicadorMensaje", "tipoCuentaRetiros", "saldoSinCuentaCont", "saldoConCuentaCont", "senalCommit"})
public class ConsultaFondosDeInversionDataResp
        implements Serializable {

    @XmlElement(required = true)
    protected String cuentaDebito;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPrimerAporte;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPrimerApertura;
    @XmlElement(required = true)
    protected BigDecimal saldoTotal;
    @XmlElement(required = true)
    protected BigDecimal saldoRetOficina;
    @XmlElement(required = true)
    protected BigDecimal valorPignorado;
    @XmlElement(required = true)
    protected BigDecimal valorCanje;
    @XmlElement(required = true)
    protected BigDecimal valorContingente;
    @XmlElement(required = true)
    protected String cuentaRetiros;
    protected short entidadRetiros;
    @XmlElement(required = true)
    protected BigDecimal valorProgramar;
    @XmlElement(required = true)
    protected BigDecimal saldoCancelacion;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaVencimiento;
    @XmlElement(required = true)
    protected BigDecimal saldoDispRetAfc;
    @XmlElement(required = true)
    protected BigDecimal valorCancTransfer;
    protected short tipoPlan;
    protected short objetivo;
    @XmlElement(required = true)
    protected BigDecimal valorApertura;
    @XmlElement(required = true)
    protected BigDecimal valorAportePeriodico;
    protected short periodicidad;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAportePeriodico;
    @XmlElement(required = true)
    protected BigDecimal rentabilidadMes;
    @XmlElement(required = true)
    protected BigDecimal rentabilidadAno;
    @XmlElement(name = "rentabilidad3anos", required = true)
    protected BigDecimal rentabilidad3Anos;
    protected short tipoIdentificacion;
    @XmlElement(required = true)
    protected String numeroIdentificacion;
    protected short codigoSubproducto;
    @XmlElement(required = true)
    protected String nombrePlan;
    @XmlElement(required = true)
    protected String nitEmpleador;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPago;
    @XmlElement(required = true)
    protected BigDecimal saldoSinAfectar;
    @XmlElement(required = true)
    protected BigDecimal saldoConsolidado;
    @XmlElement(required = true)
    protected BigDecimal saldoNoConsolidado;
    @XmlElement(required = true)
    protected BigDecimal saldoInmovilizado;
    @XmlElement(required = true)
    protected BigDecimal saldoAportesPdteApl;
    @XmlElement(required = true)
    protected BigDecimal saldoProgPdteApl;
    @XmlElement(required = true)
    protected BigDecimal saldoRetirosPdtePag;
    @XmlElement(required = true)
    protected BigDecimal saldoRetirosProg;
    @XmlElement(required = true)
    protected String indicadorMensaje;
    protected Integer tipoCuentaRetiros;
    protected BigDecimal saldoSinCuentaCont;
    protected BigDecimal saldoConCuentaCont;
    @XmlElement(required = true)
    protected String senalCommit;

    public String getCuentaDebito() {
        return this.cuentaDebito;
    }

    public void setCuentaDebito(String value) {
        this.cuentaDebito = value;
    }

    public XMLGregorianCalendar getFechaPrimerAporte() {
        return this.fechaPrimerAporte;
    }

    public void setFechaPrimerAporte(XMLGregorianCalendar value) {
        this.fechaPrimerAporte = value;
    }

    public XMLGregorianCalendar getFechaPrimerApertura() {
        return this.fechaPrimerApertura;
    }

    public void setFechaPrimerApertura(XMLGregorianCalendar value) {
        this.fechaPrimerApertura = value;
    }

    public BigDecimal getSaldoTotal() {
        return this.saldoTotal;
    }

    public void setSaldoTotal(BigDecimal value) {
        this.saldoTotal = value;
    }

    public BigDecimal getSaldoRetOficina() {
        return this.saldoRetOficina;
    }

    public void setSaldoRetOficina(BigDecimal value) {
        this.saldoRetOficina = value;
    }

    public BigDecimal getValorPignorado() {
        return this.valorPignorado;
    }

    public void setValorPignorado(BigDecimal value) {
        this.valorPignorado = value;
    }

    public BigDecimal getValorCanje() {
        return this.valorCanje;
    }

    public void setValorCanje(BigDecimal value) {
        this.valorCanje = value;
    }

    public BigDecimal getValorContingente() {
        return this.valorContingente;
    }

    public void setValorContingente(BigDecimal value) {
        this.valorContingente = value;
    }

    public String getCuentaRetiros() {
        return this.cuentaRetiros;
    }

    public void setCuentaRetiros(String value) {
        this.cuentaRetiros = value;
    }

    public short getEntidadRetiros() {
        return this.entidadRetiros;
    }

    public void setEntidadRetiros(short value) {
        this.entidadRetiros = value;
    }

    public BigDecimal getValorProgramar() {
        return this.valorProgramar;
    }

    public void setValorProgramar(BigDecimal value) {
        this.valorProgramar = value;
    }

    public BigDecimal getSaldoCancelacion() {
        return this.saldoCancelacion;
    }

    public void setSaldoCancelacion(BigDecimal value) {
        this.saldoCancelacion = value;
    }

    public XMLGregorianCalendar getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(XMLGregorianCalendar value) {
        this.fechaVencimiento = value;
    }

    public BigDecimal getSaldoDispRetAfc() {
        return this.saldoDispRetAfc;
    }

    public void setSaldoDispRetAfc(BigDecimal value) {
        this.saldoDispRetAfc = value;
    }

    public BigDecimal getValorCancTransfer() {
        return this.valorCancTransfer;
    }

    public void setValorCancTransfer(BigDecimal value) {
        this.valorCancTransfer = value;
    }

    public short getTipoPlan() {
        return this.tipoPlan;
    }

    public void setTipoPlan(short value) {
        this.tipoPlan = value;
    }

    public short getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(short value) {
        this.objetivo = value;
    }

    public BigDecimal getValorApertura() {
        return this.valorApertura;
    }

    public void setValorApertura(BigDecimal value) {
        this.valorApertura = value;
    }

    public BigDecimal getValorAportePeriodico() {
        return this.valorAportePeriodico;
    }

    public void setValorAportePeriodico(BigDecimal value) {
        this.valorAportePeriodico = value;
    }

    public short getPeriodicidad() {
        return this.periodicidad;
    }

    public void setPeriodicidad(short value) {
        this.periodicidad = value;
    }

    public XMLGregorianCalendar getFechaAportePeriodico() {
        return this.fechaAportePeriodico;
    }

    public void setFechaAportePeriodico(XMLGregorianCalendar value) {
        this.fechaAportePeriodico = value;
    }

    public BigDecimal getRentabilidadMes() {
        return this.rentabilidadMes;
    }

    public void setRentabilidadMes(BigDecimal value) {
        this.rentabilidadMes = value;
    }

    public BigDecimal getRentabilidadAno() {
        return this.rentabilidadAno;
    }

    public void setRentabilidadAno(BigDecimal value) {
        this.rentabilidadAno = value;
    }

    public BigDecimal getRentabilidad3Anos() {
        return this.rentabilidad3Anos;
    }

    public void setRentabilidad3Anos(BigDecimal value) {
        this.rentabilidad3Anos = value;
    }

    public short getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }

    public void setTipoIdentificacion(short value) {
        this.tipoIdentificacion = value;
    }

    public String getNumeroIdentificacion() {
        return this.numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String value) {
        this.numeroIdentificacion = value;
    }

    public short getCodigoSubproducto() {
        return this.codigoSubproducto;
    }

    public void setCodigoSubproducto(short value) {
        this.codigoSubproducto = value;
    }

    public String getNombrePlan() {
        return this.nombrePlan;
    }

    public void setNombrePlan(String value) {
        this.nombrePlan = value;
    }

    public String getNitEmpleador() {
        return this.nitEmpleador;
    }

    public void setNitEmpleador(String value) {
        this.nitEmpleador = value;
    }

    public XMLGregorianCalendar getFechaPago() {
        return this.fechaPago;
    }

    public void setFechaPago(XMLGregorianCalendar value) {
        this.fechaPago = value;
    }

    public BigDecimal getSaldoSinAfectar() {
        return this.saldoSinAfectar;
    }

    public void setSaldoSinAfectar(BigDecimal value) {
        this.saldoSinAfectar = value;
    }

    public BigDecimal getSaldoConsolidado() {
        return this.saldoConsolidado;
    }

    public void setSaldoConsolidado(BigDecimal value) {
        this.saldoConsolidado = value;
    }

    public BigDecimal getSaldoNoConsolidado() {
        return this.saldoNoConsolidado;
    }

    public void setSaldoNoConsolidado(BigDecimal value) {
        this.saldoNoConsolidado = value;
    }

    public BigDecimal getSaldoInmovilizado() {
        return this.saldoInmovilizado;
    }

    public void setSaldoInmovilizado(BigDecimal value) {
        this.saldoInmovilizado = value;
    }

    public BigDecimal getSaldoAportesPdteApl() {
        return this.saldoAportesPdteApl;
    }

    public void setSaldoAportesPdteApl(BigDecimal value) {
        this.saldoAportesPdteApl = value;
    }

    public BigDecimal getSaldoProgPdteApl() {
        return this.saldoProgPdteApl;
    }

    public void setSaldoProgPdteApl(BigDecimal value) {
        this.saldoProgPdteApl = value;
    }

    public BigDecimal getSaldoRetirosPdtePag() {
        return this.saldoRetirosPdtePag;
    }

    public void setSaldoRetirosPdtePag(BigDecimal value) {
        this.saldoRetirosPdtePag = value;
    }

    public BigDecimal getSaldoRetirosProg() {
        return this.saldoRetirosProg;
    }

    public void setSaldoRetirosProg(BigDecimal value) {
        this.saldoRetirosProg = value;
    }

    public String getIndicadorMensaje() {
        return this.indicadorMensaje;
    }

    public void setIndicadorMensaje(String value) {
        this.indicadorMensaje = value;
    }

    public Integer getTipoCuentaRetiros() {
        return this.tipoCuentaRetiros;
    }

    public void setTipoCuentaRetiros(Integer value) {
        this.tipoCuentaRetiros = value;
    }

    public BigDecimal getSaldoSinCuentaCont() {
        return this.saldoSinCuentaCont;
    }

    public void setSaldoSinCuentaCont(BigDecimal value) {
        this.saldoSinCuentaCont = value;
    }

    public BigDecimal getSaldoConCuentaCont() {
        return this.saldoConCuentaCont;
    }

    public void setSaldoConCuentaCont(BigDecimal value) {
        this.saldoConCuentaCont = value;
    }

    public String getSenalCommit() {
        return this.senalCommit;
    }

    public void setSenalCommit(String value) {
        this.senalCommit = value;
    }

    public String toString() {
        return "ConsultaFondosDeInversionDataResp{cuentaDebito=" + this.cuentaDebito + ", fechaPrimerAporte=" + this.fechaPrimerAporte + ", fechaPrimerApertura=" + this.fechaPrimerApertura + ", saldoTotal=" + this.saldoTotal + ", saldoRetOficina=" + this.saldoRetOficina + ", valorPignorado=" + this.valorPignorado + ", valorCanje=" + this.valorCanje + ", valorContingente=" + this.valorContingente + ", cuentaRetiros=" + this.cuentaRetiros + ", entidadRetiros=" + this.entidadRetiros + ", valorProgramar=" + this.valorProgramar + ", saldoCancelacion=" + this.saldoCancelacion + ", fechaVencimiento=" + this.fechaVencimiento + ", saldoDispRetAfc=" + this.saldoDispRetAfc + ", valorCancTransfer=" + this.valorCancTransfer + ", tipoPlan=" + this.tipoPlan + ", objetivo=" + this.objetivo + ", valorApertura=" + this.valorApertura + ", valorAportePeriodico=" + this.valorAportePeriodico + ", periodicidad=" + this.periodicidad + ", fechaAportePeriodico=" + this.fechaAportePeriodico + ", rentabilidadMes=" + this.rentabilidadMes + ", rentabilidadAno=" + this.rentabilidadAno + ", rentabilidad3Anos=" + this.rentabilidad3Anos + ", tipoIdentificacion=" + this.tipoIdentificacion + ", numeroIdentificacion=" + this.numeroIdentificacion + ", codigoSubproducto=" + this.codigoSubproducto + ", nombrePlan=" + this.nombrePlan + ", nitEmpleador=" + this.nitEmpleador + ", fechaPago=" + this.fechaPago + ", saldoSinAfectar=" + this.saldoSinAfectar + ", saldoConsolidado=" + this.saldoConsolidado + ", saldoNoConsolidado=" + this.saldoNoConsolidado + ", saldoInmovilizado=" + this.saldoInmovilizado + ", saldoAportesPdteApl=" + this.saldoAportesPdteApl + ", saldoProgPdteApl=" + this.saldoProgPdteApl + ", saldoRetirosPdtePag=" + this.saldoRetirosPdtePag + ", saldoRetirosProg=" + this.saldoRetirosProg + ", indicadorMensaje=" + this.indicadorMensaje + ", tipoCuentaRetiros=" + this.tipoCuentaRetiros + ", saldoSinCuentaCont=" + this.saldoSinCuentaCont + ", saldoConCuentaCont=" + this.saldoConCuentaCont + ", senalCommit=" + this.senalCommit + '}';
    }
}
