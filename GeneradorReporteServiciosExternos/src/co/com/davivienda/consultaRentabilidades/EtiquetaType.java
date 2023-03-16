package co.com.davivienda.consultaRentabilidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "EtiquetaType",
        propOrder = {"valEtiquetaRenta", "valNumeroEtiqueta"}
)
public class EtiquetaType {

    @XmlElement(
            required = true,
            nillable = true
    )
    protected String valEtiquetaRenta;
    @XmlElement(
            required = true,
            type = Short.class,
            nillable = true
    )
    protected Short valNumeroEtiqueta;

    public String getValEtiquetaRenta() {
        return this.valEtiquetaRenta;
    }

    public void setValEtiquetaRenta(String value) {
        this.valEtiquetaRenta = value;
    }

    public Short getValNumeroEtiqueta() {
        return this.valNumeroEtiqueta;
    }

    public void setValNumeroEtiqueta(Short value) {
        this.valNumeroEtiqueta = value;
    }
}
