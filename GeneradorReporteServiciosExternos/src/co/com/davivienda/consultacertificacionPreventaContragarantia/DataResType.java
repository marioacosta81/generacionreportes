package co.com.davivienda.consultacertificacionPreventaContragarantia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "DataResType",
        propOrder = {"valNitFiduciaria", "valNombreFiduciaria", "codTipoIdentificacion", "valTipoIdentificacionLetras", "valIdentificacionCliente", "valNombreCliente", "valNombreProducto", "codObjetivoProducto", "valNombreObjetivo", "fecApertura", "valNitCompania2", "valNombreCompania2", "codProyecto", "valNombreCodigoProyecto", "valFechaCertificacionLetras", "valDatoInformativoCuenta1", "valDatoInformativoCuenta2", "valSaldoTotal", "valSaldoAportes", "valRendimientos", "valSaldoCuenta1", "valSaldoCuenta2"}
)
public class DataResType {

    @XmlElement(
            required = true
    )
    protected String valNitFiduciaria;
    @XmlElement(
            required = true
    )
    protected String valNombreFiduciaria;
    @XmlElement(
            required = true
    )
    protected String codTipoIdentificacion;
    @XmlElement(
            required = true
    )
    protected String valTipoIdentificacionLetras;
    @XmlElement(
            required = true
    )
    protected String valIdentificacionCliente;
    @XmlElement(
            required = true
    )
    protected String valNombreCliente;
    @XmlElement(
            required = true
    )
    protected String valNombreProducto;
    @XmlElement(
            required = true
    )
    protected String codObjetivoProducto;
    @XmlElement(
            required = true
    )
    protected String valNombreObjetivo;
    @XmlElement(
            required = true
    )
    protected String fecApertura;
    protected String valNitCompania2;
    protected String valNombreCompania2;
    protected String codProyecto;
    protected String valNombreCodigoProyecto;
    @XmlElement(
            required = true
    )
    protected String valFechaCertificacionLetras;
    protected String valDatoInformativoCuenta1;
    protected String valDatoInformativoCuenta2;
    protected String valSaldoTotal;
    protected String valSaldoAportes;
    protected String valRendimientos;
    protected String valSaldoCuenta1;
    protected String valSaldoCuenta2;

    public String getValNitFiduciaria() {
        return this.valNitFiduciaria;
    }

    public void setValNitFiduciaria(String value) {
        this.valNitFiduciaria = value;
    }

    public String getValNombreFiduciaria() {
        return this.valNombreFiduciaria;
    }

    public void setValNombreFiduciaria(String value) {
        this.valNombreFiduciaria = value;
    }

    public String getCodTipoIdentificacion() {
        return this.codTipoIdentificacion;
    }

    public void setCodTipoIdentificacion(String value) {
        this.codTipoIdentificacion = value;
    }

    public String getValTipoIdentificacionLetras() {
        return this.valTipoIdentificacionLetras;
    }

    public void setValTipoIdentificacionLetras(String value) {
        this.valTipoIdentificacionLetras = value;
    }

    public String getValIdentificacionCliente() {
        return this.valIdentificacionCliente;
    }

    public void setValIdentificacionCliente(String value) {
        this.valIdentificacionCliente = value;
    }

    public String getValNombreCliente() {
        return this.valNombreCliente;
    }

    public void setValNombreCliente(String value) {
        this.valNombreCliente = value;
    }

    public String getValNombreProducto() {
        return this.valNombreProducto;
    }

    public void setValNombreProducto(String value) {
        this.valNombreProducto = value;
    }

    public String getCodObjetivoProducto() {
        return this.codObjetivoProducto;
    }

    public void setCodObjetivoProducto(String value) {
        this.codObjetivoProducto = value;
    }

    public String getValNombreObjetivo() {
        return this.valNombreObjetivo;
    }

    public void setValNombreObjetivo(String value) {
        this.valNombreObjetivo = value;
    }

    public String getFecApertura() {
        return this.fecApertura;
    }

    public void setFecApertura(String value) {
        this.fecApertura = value;
    }

    public String getValNitCompania2() {
        return this.valNitCompania2;
    }

    public void setValNitCompania2(String value) {
        this.valNitCompania2 = value;
    }

    public String getValNombreCompania2() {
        return this.valNombreCompania2;
    }

    public void setValNombreCompania2(String value) {
        this.valNombreCompania2 = value;
    }

    public String getCodProyecto() {
        return this.codProyecto;
    }

    public void setCodProyecto(String value) {
        this.codProyecto = value;
    }

    public String getValNombreCodigoProyecto() {
        return this.valNombreCodigoProyecto;
    }

    public void setValNombreCodigoProyecto(String value) {
        this.valNombreCodigoProyecto = value;
    }

    public String getValFechaCertificacionLetras() {
        return this.valFechaCertificacionLetras;
    }

    public void setValFechaCertificacionLetras(String value) {
        this.valFechaCertificacionLetras = value;
    }

    public String getValDatoInformativoCuenta1() {
        return this.valDatoInformativoCuenta1;
    }

    public void setValDatoInformativoCuenta1(String value) {
        this.valDatoInformativoCuenta1 = value;
    }

    public String getValDatoInformativoCuenta2() {
        return this.valDatoInformativoCuenta2;
    }

    public void setValDatoInformativoCuenta2(String value) {
        this.valDatoInformativoCuenta2 = value;
    }

    public String getValSaldoTotal() {
        return this.valSaldoTotal;
    }

    public void setValSaldoTotal(String value) {
        this.valSaldoTotal = value;
    }

    public String getValSaldoAportes() {
        return this.valSaldoAportes;
    }

    public void setValSaldoAportes(String value) {
        this.valSaldoAportes = value;
    }

    public String getValRendimientos() {
        return this.valRendimientos;
    }

    public void setValRendimientos(String value) {
        this.valRendimientos = value;
    }

    public String getValSaldoCuenta1() {
        return this.valSaldoCuenta1;
    }

    public void setValSaldoCuenta1(String value) {
        this.valSaldoCuenta1 = value;
    }

    public String getValSaldoCuenta2() {
        return this.valSaldoCuenta2;
    }

    public void setValSaldoCuenta2(String value) {
        this.valSaldoCuenta2 = value;
    }
}
