package co.com.davivienda.consultasproducto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "DataRespType",
        propOrder = {"valNombres", "valPrimerApellido", "valSegundoApellido", "valDireccion", "valTelefono", "valCiudad", "valNumeroIdentificacion", "valTipoIdentificacion", "valFechaNacimiento", "valNaturalezaJuridica", "valIndicadorClienteEspecial", "valTipoNoDeseado", "valRetefuente", "valTipoEmpresa", "valClaseEmpresa", "valIndMsgActualizacion", "valActividadEconomica", "valCuentaExcenta", "valLlaveCompania", "valLlaveVinculacion", "valLlaveCodigoProducto", "valLlaveCodigoSubProducto", "valLlaveNumeroProducto", "valCantidadRegistros", "registros"}
)
public class DataRespType {

    @XmlElement(
            required = true
    )
    protected String valNombres;
    @XmlElement(
            required = true
    )
    protected String valPrimerApellido;
    @XmlElement(
            required = true
    )
    protected String valSegundoApellido;
    @XmlElement(
            required = true
    )
    protected String valDireccion;
    @XmlElement(
            required = true
    )
    protected String valTelefono;
    protected long valCiudad;
    protected long valNumeroIdentificacion;
    protected short valTipoIdentificacion;
    @XmlElement(
            required = true
    )
    protected String valFechaNacimiento;
    @XmlElement(
            required = true
    )
    protected String valNaturalezaJuridica;
    protected short valIndicadorClienteEspecial;
    protected short valTipoNoDeseado;
    protected short valRetefuente;
    @XmlElement(
            required = true
    )
    protected String valTipoEmpresa;
    protected short valClaseEmpresa;
    protected short valIndMsgActualizacion;
    protected short valActividadEconomica;
    protected long valCuentaExcenta;
    protected short valLlaveCompania;
    protected short valLlaveVinculacion;
    protected short valLlaveCodigoProducto;
    protected short valLlaveCodigoSubProducto;
    @XmlElement(
            required = true
    )
    protected String valLlaveNumeroProducto;
    protected short valCantidadRegistros;
    @XmlElement(
            name = "Registros"
    )
    protected RegistrosType registros;

    public String getValNombres() {
        return this.valNombres;
    }

    public void setValNombres(String value) {
        this.valNombres = value;
    }

    public String getValPrimerApellido() {
        return this.valPrimerApellido;
    }

    public void setValPrimerApellido(String value) {
        this.valPrimerApellido = value;
    }

    public String getValSegundoApellido() {
        return this.valSegundoApellido;
    }

    public void setValSegundoApellido(String value) {
        this.valSegundoApellido = value;
    }

    public String getValDireccion() {
        return this.valDireccion;
    }

    public void setValDireccion(String value) {
        this.valDireccion = value;
    }

    public String getValTelefono() {
        return this.valTelefono;
    }

    public void setValTelefono(String value) {
        this.valTelefono = value;
    }

    public long getValCiudad() {
        return this.valCiudad;
    }

    public void setValCiudad(long value) {
        this.valCiudad = value;
    }

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

    public String getValFechaNacimiento() {
        return this.valFechaNacimiento;
    }

    public void setValFechaNacimiento(String value) {
        this.valFechaNacimiento = value;
    }

    public String getValNaturalezaJuridica() {
        return this.valNaturalezaJuridica;
    }

    public void setValNaturalezaJuridica(String value) {
        this.valNaturalezaJuridica = value;
    }

    public short getValIndicadorClienteEspecial() {
        return this.valIndicadorClienteEspecial;
    }

    public void setValIndicadorClienteEspecial(short value) {
        this.valIndicadorClienteEspecial = value;
    }

    public short getValTipoNoDeseado() {
        return this.valTipoNoDeseado;
    }

    public void setValTipoNoDeseado(short value) {
        this.valTipoNoDeseado = value;
    }

    public short getValRetefuente() {
        return this.valRetefuente;
    }

    public void setValRetefuente(short value) {
        this.valRetefuente = value;
    }

    public String getValTipoEmpresa() {
        return this.valTipoEmpresa;
    }

    public void setValTipoEmpresa(String value) {
        this.valTipoEmpresa = value;
    }

    public short getValClaseEmpresa() {
        return this.valClaseEmpresa;
    }

    public void setValClaseEmpresa(short value) {
        this.valClaseEmpresa = value;
    }

    public short getValIndMsgActualizacion() {
        return this.valIndMsgActualizacion;
    }

    public void setValIndMsgActualizacion(short value) {
        this.valIndMsgActualizacion = value;
    }

    public short getValActividadEconomica() {
        return this.valActividadEconomica;
    }

    public void setValActividadEconomica(short value) {
        this.valActividadEconomica = value;
    }

    public long getValCuentaExcenta() {
        return this.valCuentaExcenta;
    }

    public void setValCuentaExcenta(long value) {
        this.valCuentaExcenta = value;
    }

    public short getValLlaveCompania() {
        return this.valLlaveCompania;
    }

    public void setValLlaveCompania(short value) {
        this.valLlaveCompania = value;
    }

    public short getValLlaveVinculacion() {
        return this.valLlaveVinculacion;
    }

    public void setValLlaveVinculacion(short value) {
        this.valLlaveVinculacion = value;
    }

    public short getValLlaveCodigoProducto() {
        return this.valLlaveCodigoProducto;
    }

    public void setValLlaveCodigoProducto(short value) {
        this.valLlaveCodigoProducto = value;
    }

    public short getValLlaveCodigoSubProducto() {
        return this.valLlaveCodigoSubProducto;
    }

    public void setValLlaveCodigoSubProducto(short value) {
        this.valLlaveCodigoSubProducto = value;
    }

    public String getValLlaveNumeroProducto() {
        return this.valLlaveNumeroProducto;
    }

    public void setValLlaveNumeroProducto(String value) {
        this.valLlaveNumeroProducto = value;
    }

    public short getValCantidadRegistros() {
        return this.valCantidadRegistros;
    }

    public void setValCantidadRegistros(short value) {
        this.valCantidadRegistros = value;
    }

    public RegistrosType getRegistros() {
        return this.registros;
    }

    public void setRegistros(RegistrosType value) {
        this.registros = value;
    }
}
