package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import com.davivienda.esquemas.framework.contextosolicitudtipo.v1.ContextoSolicitudTipo;
import com.davivienda.generarReporte.config.reporte.Notificacion;
import com.ibm.comunes.servicios.SCNMensajeEntrada;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsjSolOpGeneracionReporte", propOrder = {"contextoSolicitud", "reporte", "cliente", "producto", "valIdPlantilla", "valVersionPlantilla", "listaParametros", "listaLlaveFileNet", "enviarCopiaCorreo", "requiereClave", "valClaveDocumento", "retornaDocumento", "enviarFileNet", "requiereClaveFileNet", "notificacion","idProcesoDocumento"})
public class MsjSolOpGeneracionReporte
        implements Serializable, SCNMensajeEntrada {

    @XmlElement(required = false)
    protected String idProcesoDocumento;      
    
    @XmlElement(required = true)
    protected ContextoSolicitudTipo contextoSolicitud;
    protected ReporteType reporte;
    protected ClienteType cliente;
    protected ProductoType producto;
    protected String valIdPlantilla;
    protected String valVersionPlantilla;
    protected Parametros listaParametros;
    protected ListaLlaveFileNet listaLlaveFileNet;
    protected boolean enviarCopiaCorreo;
    protected boolean requiereClave;
    protected String valClaveDocumento;
    protected boolean retornaDocumento;
    protected boolean enviarFileNet;
    protected boolean requiereClaveFileNet;
    protected Notificacion notificacion;

    
    public String getIdProcesoDocumento() {
        return idProcesoDocumento;
    }

    public void setIdProcesoDocumento(String idProcesoDocumento) {
        this.idProcesoDocumento = idProcesoDocumento;
    }

    public ContextoSolicitudTipo getContextoSolicitud() {
        return this.contextoSolicitud;
    }

    public void setContextoSolicitud(ContextoSolicitudTipo value) {
        this.contextoSolicitud = value;
    }

    public ReporteType getReporte() {
        return this.reporte;
    }

    public void setReporte(ReporteType value) {
        this.reporte = value;
    }

    public ClienteType getCliente() {
        return this.cliente;
    }

    public void setCliente(ClienteType value) {
        this.cliente = value;
    }

    public ProductoType getProducto() {
        return this.producto;
    }

    public void setProducto(ProductoType value) {
        this.producto = value;
    }

    public String getValIdPlantilla() {
        return this.valIdPlantilla;
    }

    public void setValIdPlantilla(String value) {
        this.valIdPlantilla = value;
    }

    public String getValVersionPlantilla() {
        return this.valVersionPlantilla;
    }

    public void setValVersionPlantilla(String value) {
        this.valVersionPlantilla = value;
    }

    public Parametros getListaParametros() {
        return this.listaParametros;
    }

    public void setListaParametros(Parametros value) {
        this.listaParametros = value;
    }

    public boolean isEnviarCopiaCorreo() {
        return this.enviarCopiaCorreo;
    }

    public void setEnviarCopiaCorreo(boolean value) {
        this.enviarCopiaCorreo = value;
    }

    public boolean isRequiereClave() {
        return this.requiereClave;
    }

    public void setRequiereClave(boolean value) {
        this.requiereClave = value;
    }

    public String getValClaveDocumento() {
        return this.valClaveDocumento;
    }

    public void setValClaveDocumento(String value) {
        this.valClaveDocumento = value;
    }

    public boolean isRetornaDocumento() {
        return this.retornaDocumento;
    }

    public void setRetornaDocumento(boolean value) {
        this.retornaDocumento = value;
    }

    public boolean isEnviarFileNet() {
        return this.enviarFileNet;
    }

    public void setEnviarFileNet(boolean value) {
        this.enviarFileNet = value;
    }

    public boolean isRequiereClaveFileNet() {
        return this.requiereClaveFileNet;
    }

    public void setRequiereClaveFileNet(boolean value) {
        this.requiereClaveFileNet = value;
    }

    public Notificacion getNotificacion() {
        return this.notificacion;
    }

    public void setNotificacion(Notificacion value) {
        this.notificacion = value;
    }

    public ListaLlaveFileNet getListaLlaveFileNet() {
        return this.listaLlaveFileNet;
    }

    public void setListaLlaveFileNet(ListaLlaveFileNet listaLlaveFileNet) {
        this.listaLlaveFileNet = listaLlaveFileNet;
    }
}
