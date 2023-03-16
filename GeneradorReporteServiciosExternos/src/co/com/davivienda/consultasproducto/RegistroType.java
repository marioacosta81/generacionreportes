package co.com.davivienda.consultasproducto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "RegistroType",
        propOrder = {"valCompania", "valVinculacion", "valCodigoProducto", "valCodigoSubProducto", "valNumeroProducto", "valNumeroPortafolio", "valTipoPortafolio", "valIndicadorCliente", "valClaseManejo", "valTarjeta", "valIndicadorSegundaClave", "valIndicadorTarjetaDebito", "valFechaApertura", "valVigencia", "valIndicadorBloqueTradicional", "valIndicadorBloqueoProducto", "valIndicadorEmbargo", "valIndicadorFondosCongeladosEmbargo", "valIndicadorBolsillo", "valCantidadBolsillos", "valIndicadorTarjetaCreditoAmparada"}
)
public class RegistroType {

    @XmlElement(
            required = true
    )
    protected String valCompania;
    protected short valVinculacion;
    protected short valCodigoProducto;
    @XmlElement(
            required = true
    )
    protected String valCodigoSubProducto;
    @XmlElement(
            required = true
    )
    protected String valNumeroProducto;
    @XmlElement(
            required = true
    )
    protected String valNumeroPortafolio;
    @XmlElement(
            required = true
    )
    protected String valTipoPortafolio;
    protected short valIndicadorCliente;
    protected short valClaseManejo;
    @XmlElement(
            required = true
    )
    protected String valTarjeta;
    protected short valIndicadorSegundaClave;
    protected short valIndicadorTarjetaDebito;
    @XmlElement(
            required = true
    )
    protected String valFechaApertura;
    protected short valVigencia;
    protected short valIndicadorBloqueTradicional;
    @XmlElement(
            required = true
    )
    protected String valIndicadorBloqueoProducto;
    protected short valIndicadorEmbargo;
    protected short valIndicadorFondosCongeladosEmbargo;
    protected short valIndicadorBolsillo;
    protected short valCantidadBolsillos;
    protected short valIndicadorTarjetaCreditoAmparada;

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

    public short getValCodigoProducto() {
        return this.valCodigoProducto;
    }

    public void setValCodigoProducto(short value) {
        this.valCodigoProducto = value;
    }

    public String getValCodigoSubProducto() {
        return this.valCodigoSubProducto;
    }

    public void setValCodigoSubProducto(String value) {
        this.valCodigoSubProducto = value;
    }

    public String getValNumeroProducto() {
        return this.valNumeroProducto;
    }

    public void setValNumeroProducto(String value) {
        this.valNumeroProducto = value;
    }

    public String getValNumeroPortafolio() {
        return this.valNumeroPortafolio;
    }

    public void setValNumeroPortafolio(String value) {
        this.valNumeroPortafolio = value;
    }

    public String getValTipoPortafolio() {
        return this.valTipoPortafolio;
    }

    public void setValTipoPortafolio(String value) {
        this.valTipoPortafolio = value;
    }

    public short getValIndicadorCliente() {
        return this.valIndicadorCliente;
    }

    public void setValIndicadorCliente(short value) {
        this.valIndicadorCliente = value;
    }

    public short getValClaseManejo() {
        return this.valClaseManejo;
    }

    public void setValClaseManejo(short value) {
        this.valClaseManejo = value;
    }

    public String getValTarjeta() {
        return this.valTarjeta;
    }

    public void setValTarjeta(String value) {
        this.valTarjeta = value;
    }

    public short getValIndicadorSegundaClave() {
        return this.valIndicadorSegundaClave;
    }

    public void setValIndicadorSegundaClave(short value) {
        this.valIndicadorSegundaClave = value;
    }

    public short getValIndicadorTarjetaDebito() {
        return this.valIndicadorTarjetaDebito;
    }

    public void setValIndicadorTarjetaDebito(short value) {
        this.valIndicadorTarjetaDebito = value;
    }

    public String getValFechaApertura() {
        return this.valFechaApertura;
    }

    public void setValFechaApertura(String value) {
        this.valFechaApertura = value;
    }

    public short getValVigencia() {
        return this.valVigencia;
    }

    public void setValVigencia(short value) {
        this.valVigencia = value;
    }

    public short getValIndicadorBloqueTradicional() {
        return this.valIndicadorBloqueTradicional;
    }

    public void setValIndicadorBloqueTradicional(short value) {
        this.valIndicadorBloqueTradicional = value;
    }

    public String getValIndicadorBloqueoProducto() {
        return this.valIndicadorBloqueoProducto;
    }

    public void setValIndicadorBloqueoProducto(String value) {
        this.valIndicadorBloqueoProducto = value;
    }

    public short getValIndicadorEmbargo() {
        return this.valIndicadorEmbargo;
    }

    public void setValIndicadorEmbargo(short value) {
        this.valIndicadorEmbargo = value;
    }

    public short getValIndicadorFondosCongeladosEmbargo() {
        return this.valIndicadorFondosCongeladosEmbargo;
    }

    public void setValIndicadorFondosCongeladosEmbargo(short value) {
        this.valIndicadorFondosCongeladosEmbargo = value;
    }

    public short getValIndicadorBolsillo() {
        return this.valIndicadorBolsillo;
    }

    public void setValIndicadorBolsillo(short value) {
        this.valIndicadorBolsillo = value;
    }

    public short getValCantidadBolsillos() {
        return this.valCantidadBolsillos;
    }

    public void setValCantidadBolsillos(short value) {
        this.valCantidadBolsillos = value;
    }

    public short getValIndicadorTarjetaCreditoAmparada() {
        return this.valIndicadorTarjetaCreditoAmparada;
    }

    public void setValIndicadorTarjetaCreditoAmparada(short value) {
        this.valIndicadorTarjetaCreditoAmparada = value;
    }
}
