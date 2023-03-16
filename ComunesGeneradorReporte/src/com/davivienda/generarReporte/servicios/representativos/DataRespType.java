package com.davivienda.generarReporte.servicios.representativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataRespType", propOrder = {"valEtiquetaFecha", "valSociedadAdministradora", "valNombreDocumento", "valNombreFondo", "valEtiquetaEncabezado", "valEtiquetaContenido", "valEtiquetaNombreInversorista", "valNombreCliente", "valEtiquetaIdentificacionInversionista", "valNumeroIdentificacionCliente", "valSenalPrensentaParticipacion", "valEtiquetaNombreParticipacionFondo", "valEtiquetaFechaTablaAportes", "valEtiquetaValorAporteTabla", "valEtiquetaValorUnidad", "valEtiquetaNumeroUnidades", "fecFechaAporte", "valValorMovimiento", "valValorUnidad", "valNumeroUnidades", "aportesRealizados", "valEtiquetaFechaFormatoB", "fecFechaAperturaProducto", "valEtiquetaFechaFormatoC", "fecFechaVencimientoProducto", "valEtiquetaPermanencia", "valPlazoMinimo", "valEtiquetaRetiro", "valValorComisionRetiroAnticipado", "valEtiquetaTablaParticipacion", "valEtiquetaParticipacion", "valEtiquetaTipoPersona", "valEtiquetaRangoSaldoPromedio", "valEtiquetaPorcentajeComision", "participaciones", "valPaginaTablaParticipaciones", "valEtiquetaPiePaginaA", "valEtiquetaPiePaginaB", "valEtiquetaPiePaginaC", "valEtiquetaPiePaginaD", "valEtiquetaPiePaginaE", "valEtiquetaPiePaginaF", "codTipoIdentificacion", "valNombreCiudad", "valDireccionCliente", "valOficina", "valCuentaCorredores"})
public class DataRespType {

    @XmlElement(required = true)
    protected String valEtiquetaFecha;
    @XmlElement(required = true)
    protected String valSociedadAdministradora;
    @XmlElement(required = true)
    protected String valNombreDocumento;
    @XmlElement(required = true)
    protected String valNombreFondo;
    @XmlElement(required = true)
    protected String valEtiquetaEncabezado;
    @XmlElement(required = true)
    protected String valEtiquetaContenido;
    @XmlElement(required = true)
    protected String valEtiquetaNombreInversorista;
    @XmlElement(required = true)
    protected String valNombreCliente;
    @XmlElement(required = true)
    protected String valEtiquetaIdentificacionInversionista;
    protected String valNumeroIdentificacionCliente;
    @XmlElement(required = true)
    protected String valSenalPrensentaParticipacion;
    protected String valEtiquetaNombreParticipacionFondo;
    @XmlElement(required = true)
    protected String valEtiquetaFechaTablaAportes;
    @XmlElement(required = true)
    protected String valEtiquetaValorAporteTabla;
    @XmlElement(required = true)
    protected String valEtiquetaValorUnidad;
    @XmlElement(required = true)
    protected String valEtiquetaNumeroUnidades;
    protected String fecFechaAporte;
    protected String valValorMovimiento;
    protected String valValorUnidad;
    protected String valNumeroUnidades;
    @XmlElement(name = "AportesRealizados")
    protected AportesRealizadosType aportesRealizados;
    @XmlElement(required = true)
    protected String valEtiquetaFechaFormatoB;
    @XmlElement(required = true)
    protected String fecFechaAperturaProducto;
    @XmlElement(required = true)
    protected String valEtiquetaFechaFormatoC;
    @XmlElement(required = true)
    protected String fecFechaVencimientoProducto;
    @XmlElement(required = true)
    protected String valEtiquetaPermanencia;
    @XmlElement(required = true)
    protected String valPlazoMinimo;
    @XmlElement(required = true)
    protected String valEtiquetaRetiro;
    @XmlElement(required = true)
    protected String valValorComisionRetiroAnticipado;
    @XmlElement(required = true)
    protected String valEtiquetaTablaParticipacion;
    @XmlElement(required = true)
    protected String valEtiquetaParticipacion;
    @XmlElement(required = true)
    protected String valEtiquetaTipoPersona;
    @XmlElement(required = true)
    protected String valEtiquetaRangoSaldoPromedio;
    @XmlElement(required = true)
    protected String valEtiquetaPorcentajeComision;
    @XmlElement(name = "Participaciones")
    protected ParticipacionesType participaciones;
    @XmlElement(required = true)
    protected String valPaginaTablaParticipaciones;
    @XmlElement(required = true)
    protected String valEtiquetaPiePaginaA;
    protected String valEtiquetaPiePaginaB;
    protected String valEtiquetaPiePaginaC;
    protected String valEtiquetaPiePaginaD;
    protected String valEtiquetaPiePaginaE;
    protected String valEtiquetaPiePaginaF;
    protected String codTipoIdentificacion;
    protected String valNombreCiudad;
    protected String valDireccionCliente;
    protected String valOficina;
    protected String valCuentaCorredores;

    public String getValEtiquetaFecha() {
        return this.valEtiquetaFecha;
    }

    public void setValEtiquetaFecha(String value) {
        this.valEtiquetaFecha = value;
    }

    public String getValSociedadAdministradora() {
        return this.valSociedadAdministradora;
    }

    public void setValSociedadAdministradora(String value) {
        this.valSociedadAdministradora = value;
    }

    public String getValNombreDocumento() {
        return this.valNombreDocumento;
    }

    public void setValNombreDocumento(String value) {
        this.valNombreDocumento = value;
    }

    public String getValNombreFondo() {
        return this.valNombreFondo;
    }

    public void setValNombreFondo(String value) {
        this.valNombreFondo = value;
    }

    public String getValEtiquetaEncabezado() {
        return this.valEtiquetaEncabezado;
    }

    public void setValEtiquetaEncabezado(String value) {
        this.valEtiquetaEncabezado = value;
    }

    public String getValEtiquetaContenido() {
        return this.valEtiquetaContenido;
    }

    public void setValEtiquetaContenido(String value) {
        this.valEtiquetaContenido = value;
    }

    public String getValEtiquetaNombreInversorista() {
        return this.valEtiquetaNombreInversorista;
    }

    public void setValEtiquetaNombreInversorista(String value) {
        this.valEtiquetaNombreInversorista = value;
    }

    public String getValNombreCliente() {
        return this.valNombreCliente;
    }

    public void setValNombreCliente(String value) {
        this.valNombreCliente = value;
    }

    public String getValEtiquetaIdentificacionInversionista() {
        return this.valEtiquetaIdentificacionInversionista;
    }

    public void setValEtiquetaIdentificacionInversionista(String value) {
        this.valEtiquetaIdentificacionInversionista = value;
    }

    public String getValNumeroIdentificacionCliente() {
        return this.valNumeroIdentificacionCliente;
    }

    public void setValNumeroIdentificacionCliente(String value) {
        this.valNumeroIdentificacionCliente = value;
    }

    public String getValSenalPrensentaParticipacion() {
        return this.valSenalPrensentaParticipacion;
    }

    public void setValSenalPrensentaParticipacion(String value) {
        this.valSenalPrensentaParticipacion = value;
    }

    public String getValEtiquetaNombreParticipacionFondo() {
        return this.valEtiquetaNombreParticipacionFondo;
    }

    public void setValEtiquetaNombreParticipacionFondo(String value) {
        this.valEtiquetaNombreParticipacionFondo = value;
    }

    public String getValEtiquetaFechaTablaAportes() {
        return this.valEtiquetaFechaTablaAportes;
    }

    public void setValEtiquetaFechaTablaAportes(String value) {
        this.valEtiquetaFechaTablaAportes = value;
    }

    public String getValEtiquetaValorAporteTabla() {
        return this.valEtiquetaValorAporteTabla;
    }

    public void setValEtiquetaValorAporteTabla(String value) {
        this.valEtiquetaValorAporteTabla = value;
    }

    public String getValEtiquetaValorUnidad() {
        return this.valEtiquetaValorUnidad;
    }

    public void setValEtiquetaValorUnidad(String value) {
        this.valEtiquetaValorUnidad = value;
    }

    public String getValEtiquetaNumeroUnidades() {
        return this.valEtiquetaNumeroUnidades;
    }

    public void setValEtiquetaNumeroUnidades(String value) {
        this.valEtiquetaNumeroUnidades = value;
    }

    public String getFecFechaAporte() {
        return this.fecFechaAporte;
    }

    public void setFecFechaAporte(String value) {
        this.fecFechaAporte = value;
    }

    public String getValValorMovimiento() {
        return this.valValorMovimiento;
    }

    public void setValValorMovimiento(String value) {
        this.valValorMovimiento = value;
    }

    public String getValValorUnidad() {
        return this.valValorUnidad;
    }

    public void setValValorUnidad(String value) {
        this.valValorUnidad = value;
    }

    public String getValNumeroUnidades() {
        return this.valNumeroUnidades;
    }

    public void setValNumeroUnidades(String value) {
        this.valNumeroUnidades = value;
    }

    public AportesRealizadosType getAportesRealizados() {
        return this.aportesRealizados;
    }

    public void setAportesRealizados(AportesRealizadosType value) {
        this.aportesRealizados = value;
    }

    public String getValEtiquetaFechaFormatoB() {
        return this.valEtiquetaFechaFormatoB;
    }

    public void setValEtiquetaFechaFormatoB(String value) {
        this.valEtiquetaFechaFormatoB = value;
    }

    public String getFecFechaAperturaProducto() {
        return this.fecFechaAperturaProducto;
    }

    public void setFecFechaAperturaProducto(String value) {
        this.fecFechaAperturaProducto = value;
    }

    public String getValEtiquetaFechaFormatoC() {
        return this.valEtiquetaFechaFormatoC;
    }

    public void setValEtiquetaFechaFormatoC(String value) {
        this.valEtiquetaFechaFormatoC = value;
    }

    public String getFecFechaVencimientoProducto() {
        return this.fecFechaVencimientoProducto;
    }

    public void setFecFechaVencimientoProducto(String value) {
        this.fecFechaVencimientoProducto = value;
    }

    public String getValEtiquetaPermanencia() {
        return this.valEtiquetaPermanencia;
    }

    public void setValEtiquetaPermanencia(String value) {
        this.valEtiquetaPermanencia = value;
    }

    public String getValPlazoMinimo() {
        return this.valPlazoMinimo;
    }

    public void setValPlazoMinimo(String value) {
        this.valPlazoMinimo = value;
    }

    public String getValEtiquetaRetiro() {
        return this.valEtiquetaRetiro;
    }

    public void setValEtiquetaRetiro(String value) {
        this.valEtiquetaRetiro = value;
    }

    public String getValValorComisionRetiroAnticipado() {
        return this.valValorComisionRetiroAnticipado;
    }

    public void setValValorComisionRetiroAnticipado(String value) {
        this.valValorComisionRetiroAnticipado = value;
    }

    public String getValEtiquetaTablaParticipacion() {
        return this.valEtiquetaTablaParticipacion;
    }

    public void setValEtiquetaTablaParticipacion(String value) {
        this.valEtiquetaTablaParticipacion = value;
    }

    public String getValEtiquetaParticipacion() {
        return this.valEtiquetaParticipacion;
    }

    public void setValEtiquetaParticipacion(String value) {
        this.valEtiquetaParticipacion = value;
    }

    public String getValEtiquetaTipoPersona() {
        return this.valEtiquetaTipoPersona;
    }

    public void setValEtiquetaTipoPersona(String value) {
        this.valEtiquetaTipoPersona = value;
    }

    public String getValEtiquetaRangoSaldoPromedio() {
        return this.valEtiquetaRangoSaldoPromedio;
    }

    public void setValEtiquetaRangoSaldoPromedio(String value) {
        this.valEtiquetaRangoSaldoPromedio = value;
    }

    public String getValEtiquetaPorcentajeComision() {
        return this.valEtiquetaPorcentajeComision;
    }

    public void setValEtiquetaPorcentajeComision(String value) {
        this.valEtiquetaPorcentajeComision = value;
    }

    public ParticipacionesType getParticipaciones() {
        return this.participaciones;
    }

    public void setParticipaciones(ParticipacionesType value) {
        this.participaciones = value;
    }

    public String getValPaginaTablaParticipaciones() {
        return this.valPaginaTablaParticipaciones;
    }

    public void setValPaginaTablaParticipaciones(String value) {
        this.valPaginaTablaParticipaciones = value;
    }

    public String getValEtiquetaPiePaginaA() {
        return this.valEtiquetaPiePaginaA;
    }

    public void setValEtiquetaPiePaginaA(String value) {
        this.valEtiquetaPiePaginaA = value;
    }

    public String getValEtiquetaPiePaginaB() {
        return this.valEtiquetaPiePaginaB;
    }

    public void setValEtiquetaPiePaginaB(String value) {
        this.valEtiquetaPiePaginaB = value;
    }

    public String getValEtiquetaPiePaginaC() {
        return this.valEtiquetaPiePaginaC;
    }

    public void setValEtiquetaPiePaginaC(String value) {
        this.valEtiquetaPiePaginaC = value;
    }

    public String getValEtiquetaPiePaginaD() {
        return this.valEtiquetaPiePaginaD;
    }

    public void setValEtiquetaPiePaginaD(String value) {
        this.valEtiquetaPiePaginaD = value;
    }

    public String getValEtiquetaPiePaginaE() {
        return this.valEtiquetaPiePaginaE;
    }

    public void setValEtiquetaPiePaginaE(String value) {
        this.valEtiquetaPiePaginaE = value;
    }

    public String getValEtiquetaPiePaginaF() {
        return this.valEtiquetaPiePaginaF;
    }

    public void setValEtiquetaPiePaginaF(String value) {
        this.valEtiquetaPiePaginaF = value;
    }

    public String getCodTipoIdentificacion() {
        return this.codTipoIdentificacion;
    }

    public void setCodTipoIdentificacion(String value) {
        this.codTipoIdentificacion = value;
    }

    public String getValNombreCiudad() {
        return this.valNombreCiudad;
    }

    public void setValNombreCiudad(String value) {
        this.valNombreCiudad = value;
    }

    public String getValDireccionCliente() {
        return this.valDireccionCliente;
    }

    public void setValDireccionCliente(String value) {
        this.valDireccionCliente = value;
    }

    public String getValOficina() {
        return this.valOficina;
    }

    public void setValOficina(String value) {
        this.valOficina = value;
    }

    public String getValCuentaCorredores() {
        return this.valCuentaCorredores;
    }

    public void setValCuentaCorredores(String value) {
        this.valCuentaCorredores = value;
    }
}
