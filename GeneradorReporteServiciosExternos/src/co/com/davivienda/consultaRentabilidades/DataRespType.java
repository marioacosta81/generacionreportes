package co.com.davivienda.consultaRentabilidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "DataRespType",
        propOrder = {"valExisteRenta", "fondos", "etiquetasRenta"}
)
public class DataRespType {

    @XmlElement(
            required = true,
            nillable = true
    )
    protected String valExisteRenta;
    @XmlElement(
            name = "Fondos"
    )
    protected FondoSRespType fondos;
    @XmlElement(
            name = "EtiquetasRenta"
    )
    protected EtiquetasRentaRespType etiquetasRenta;

    public String getValExisteRenta() {
        return this.valExisteRenta;
    }

    public void setValExisteRenta(String value) {
        this.valExisteRenta = value;
    }

    public FondoSRespType getFondos() {
        return this.fondos;
    }

    public void setFondos(FondoSRespType value) {
        this.fondos = value;
    }

    public EtiquetasRentaRespType getEtiquetasRenta() {
        return this.etiquetasRenta;
    }

    public void setEtiquetasRenta(EtiquetasRentaRespType value) {
        this.etiquetasRenta = value;
    }
}
