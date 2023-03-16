package co.com.davivienda.consultasproducto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "DataReqType",
        propOrder = {"valNumeroIdentificacion", "valTipoIdentificacion", "valCompania", "valVinculacion", "codProducto", "codSubProducto", "valNumeroProducto", "valIndicadorConsultarCuentasAhorros", "valIndicadorConsultarCuentasCorrientes", "valIndicadorConsultarCreditosFM", "valIndicadorConsultarTarjetasCreditoPropias", "valIndicadorConsultarTarjetasCreditoAmparadas", "valIndicadorConsultarDabuenvida", "valIndicadorConsultarCertificadoCDTS", "valIndicadorConsultarEstablecimientos", "valIndicadorConsultarFondosInversion"}
)
public class DataReqType {

    protected long valNumeroIdentificacion;
    protected short valTipoIdentificacion;
    @XmlElement(
            required = true
    )
    protected String valCompania;
    protected short valVinculacion;
    protected short codProducto;
    protected short codSubProducto;
    @XmlElement(
            required = true
    )
    protected String valNumeroProducto;
    protected short valIndicadorConsultarCuentasAhorros;
    protected short valIndicadorConsultarCuentasCorrientes;
    protected short valIndicadorConsultarCreditosFM;
    protected short valIndicadorConsultarTarjetasCreditoPropias;
    protected short valIndicadorConsultarTarjetasCreditoAmparadas;
    protected short valIndicadorConsultarDabuenvida;
    protected short valIndicadorConsultarCertificadoCDTS;
    protected short valIndicadorConsultarEstablecimientos;
    protected short valIndicadorConsultarFondosInversion;

    public long getValNumeroIdentificacion() {
        return this.valNumeroIdentificacion;
    }

    public void setValNumeroIdentificacion(long value) {
        this.valNumeroIdentificacion = value;
    }

    public short getValTipoIdentificacion() {
        return this.valTipoIdentificacion;
    }

    public void setValTipoIdentificacion(short value) {
        this.valTipoIdentificacion = value;
    }

    public String getValCompania() {
        return this.valCompania;
    }

    public void setValCompania(String value) {
        this.valCompania = value;
    }

    public short getValVinculacion() {
        return this.valVinculacion;
    }

    public void setValVinculacion(short value) {
        this.valVinculacion = value;
    }

    public short getCodProducto() {
        return this.codProducto;
    }

    public void setCodProducto(short value) {
        this.codProducto = value;
    }

    public short getCodSubProducto() {
        return this.codSubProducto;
    }

    public void setCodSubProducto(short value) {
        this.codSubProducto = value;
    }

    public String getValNumeroProducto() {
        return this.valNumeroProducto;
    }

    public void setValNumeroProducto(String value) {
        this.valNumeroProducto = value;
    }

    public short getValIndicadorConsultarCuentasAhorros() {
        return this.valIndicadorConsultarCuentasAhorros;
    }

    public void setValIndicadorConsultarCuentasAhorros(short value) {
        this.valIndicadorConsultarCuentasAhorros = value;
    }

    public short getValIndicadorConsultarCuentasCorrientes() {
        return this.valIndicadorConsultarCuentasCorrientes;
    }

    public void setValIndicadorConsultarCuentasCorrientes(short value) {
        this.valIndicadorConsultarCuentasCorrientes = value;
    }

    public short getValIndicadorConsultarCreditosFM() {
        return this.valIndicadorConsultarCreditosFM;
    }

    public void setValIndicadorConsultarCreditosFM(short value) {
        this.valIndicadorConsultarCreditosFM = value;
    }

    public short getValIndicadorConsultarTarjetasCreditoPropias() {
        return this.valIndicadorConsultarTarjetasCreditoPropias;
    }

    public void setValIndicadorConsultarTarjetasCreditoPropias(short value) {
        this.valIndicadorConsultarTarjetasCreditoPropias = value;
    }

    public short getValIndicadorConsultarTarjetasCreditoAmparadas() {
        return this.valIndicadorConsultarTarjetasCreditoAmparadas;
    }

    public void setValIndicadorConsultarTarjetasCreditoAmparadas(short value) {
        this.valIndicadorConsultarTarjetasCreditoAmparadas = value;
    }

    public short getValIndicadorConsultarDabuenvida() {
        return this.valIndicadorConsultarDabuenvida;
    }

    public void setValIndicadorConsultarDabuenvida(short value) {
        this.valIndicadorConsultarDabuenvida = value;
    }

    public short getValIndicadorConsultarCertificadoCDTS() {
        return this.valIndicadorConsultarCertificadoCDTS;
    }

    public void setValIndicadorConsultarCertificadoCDTS(short value) {
        this.valIndicadorConsultarCertificadoCDTS = value;
    }

    public short getValIndicadorConsultarEstablecimientos() {
        return this.valIndicadorConsultarEstablecimientos;
    }

    public void setValIndicadorConsultarEstablecimientos(short value) {
        this.valIndicadorConsultarEstablecimientos = value;
    }

    public short getValIndicadorConsultarFondosInversion() {
        return this.valIndicadorConsultarFondosInversion;
    }

    public void setValIndicadorConsultarFondosInversion(short value) {
        this.valIndicadorConsultarFondosInversion = value;
    }
}
