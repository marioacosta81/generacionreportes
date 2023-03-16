package co.com.davivienda.consultaRentabilidades;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ARRParticipacionesType", propOrder = {"codParticipacion", "valNombreParticipacion", "fecInicio", "valParticipacion", "valUnidadParticipacion", "valCambioUniParticipacion", "rentaParticipaciones"})
public class ARRParticipacionesType {

    @XmlElement(required = true, nillable = true)
    protected String codParticipacion;
    @XmlElement(required = true, nillable = true)
    protected String valNombreParticipacion;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecInicio;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal valParticipacion;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal valUnidadParticipacion;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal valCambioUniParticipacion;
    @XmlElement(name = "RentaParticipaciones")
    protected RentaParticipacionRespType rentaParticipaciones;

    public ARRParticipacionesType() {
        super();
    }

    public String getCodParticipacion() {
        return this.codParticipacion;
    }

    public void setCodParticipacion(final String value) {
        this.codParticipacion = value;
    }

    public String getValNombreParticipacion() {
        return this.valNombreParticipacion;
    }

    public void setValNombreParticipacion(final String value) {
        this.valNombreParticipacion = value;
    }

    public XMLGregorianCalendar getFecInicio() {
        return this.fecInicio;
    }

    public void setFecInicio(final XMLGregorianCalendar value) {
        this.fecInicio = value;
    }

    public BigDecimal getValParticipacion() {
        return this.valParticipacion;
    }

    public void setValParticipacion(final BigDecimal value) {
        this.valParticipacion = value;
    }

    public BigDecimal getValUnidadParticipacion() {
        return this.valUnidadParticipacion;
    }

    public void setValUnidadParticipacion(final BigDecimal value) {
        this.valUnidadParticipacion = value;
    }

    public BigDecimal getValCambioUniParticipacion() {
        return this.valCambioUniParticipacion;
    }

    public void setValCambioUniParticipacion(final BigDecimal value) {
        this.valCambioUniParticipacion = value;
    }

    public RentaParticipacionRespType getRentaParticipaciones() {
        return this.rentaParticipaciones;
    }

    public void setRentaParticipaciones(final RentaParticipacionRespType value) {
        this.rentaParticipaciones = value;
    }
}
