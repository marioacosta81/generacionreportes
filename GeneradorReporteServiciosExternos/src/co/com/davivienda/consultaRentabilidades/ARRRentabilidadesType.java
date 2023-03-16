package co.com.davivienda.consultaRentabilidades;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "ARRRentabilidadesType",
        propOrder = {"valNombreRentabilidad", "valRentabilidad", "codTipoRenta", "valPresentacionRent", "valEtiqueta"}
)
public class ARRRentabilidadesType {

    @XmlElement(
            required = true,
            nillable = true
    )
    protected String valNombreRentabilidad;
    @XmlElement(
            required = true,
            nillable = true
    )
    protected BigDecimal valRentabilidad;
    @XmlElement(
            required = true,
            nillable = true
    )
    protected String codTipoRenta;
    @XmlElement(
            required = true,
            nillable = true
    )
    protected String valPresentacionRent;
    @XmlElement(
            required = true,
            nillable = true
    )
    protected String valEtiqueta;

    public String getValNombreRentabilidad() {
        return this.valNombreRentabilidad;
    }

    public void setValNombreRentabilidad(String value) {
        this.valNombreRentabilidad = value;
    }

    public BigDecimal getValRentabilidad() {
        return this.valRentabilidad;
    }

    public void setValRentabilidad(BigDecimal value) {
        this.valRentabilidad = value;
    }

    public String getCodTipoRenta() {
        return this.codTipoRenta;
    }

    public void setCodTipoRenta(String value) {
        this.codTipoRenta = value;
    }

    public String getValPresentacionRent() {
        return this.valPresentacionRent;
    }

    public void setValPresentacionRent(String value) {
        this.valPresentacionRent = value;
    }

    public String getValEtiqueta() {
        return this.valEtiqueta;
    }

    public void setValEtiqueta(String value) {
        this.valEtiqueta = value;
    }
}
