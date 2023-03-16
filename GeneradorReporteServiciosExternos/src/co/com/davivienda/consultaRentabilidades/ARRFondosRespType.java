package co.com.davivienda.consultaRentabilidades;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ARRFondosRespType", propOrder = {"valCodigoFondo", "valNombreDelFondo", "fecInicio", "valFondo", "valUnidad", "valCambioUnidad", "rentabilidadesFondo", "participaciones"})
public class ARRFondosRespType {

    @XmlElement(required = true, nillable = true)
    protected String valCodigoFondo;
    @XmlElement(required = true, nillable = true)
    protected String valNombreDelFondo;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecInicio;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal valFondo;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal valUnidad;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal valCambioUnidad;
    @XmlElement(name = "RentabilidadesFondo")
    protected RentabilidadesRespType rentabilidadesFondo;
    @XmlElement(name = "Participaciones")
    protected ParticipacionesRespType participaciones;

    public ARRFondosRespType() {
        super();
    }

    public String getValCodigoFondo() {
        return this.valCodigoFondo;
    }

    public void setValCodigoFondo(final String value) {
        this.valCodigoFondo = value;
    }

    public String getValNombreDelFondo() {
        return this.valNombreDelFondo;
    }

    public void setValNombreDelFondo(final String value) {
        this.valNombreDelFondo = value;
    }

    public XMLGregorianCalendar getFecInicio() {
        return this.fecInicio;
    }

    public void setFecInicio(final XMLGregorianCalendar value) {
        this.fecInicio = value;
    }

    public BigDecimal getValFondo() {
        return this.valFondo;
    }

    public void setValFondo(final BigDecimal value) {
        this.valFondo = value;
    }

    public BigDecimal getValUnidad() {
        return this.valUnidad;
    }

    public void setValUnidad(final BigDecimal value) {
        this.valUnidad = value;
    }

    public BigDecimal getValCambioUnidad() {
        return this.valCambioUnidad;
    }

    public void setValCambioUnidad(final BigDecimal value) {
        this.valCambioUnidad = value;
    }

    public RentabilidadesRespType getRentabilidadesFondo() {
        return this.rentabilidadesFondo;
    }

    public void setRentabilidadesFondo(final RentabilidadesRespType value) {
        this.rentabilidadesFondo = value;
    }

    public ParticipacionesRespType getParticipaciones() {
        return this.participaciones;
    }

    public void setParticipaciones(final ParticipacionesRespType value) {
        this.participaciones = value;
    }
}
