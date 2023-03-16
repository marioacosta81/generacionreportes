package co.com.davivienda.consultaRentabilidades;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "EtiquetasType",
        propOrder = {"etiquetaRenta"}
)
public class EtiquetasType {

    @XmlElement(
            name = "EtiquetaRenta",
            required = true
    )
    protected List<EtiquetaType> etiquetaRenta;

    public List<EtiquetaType> getEtiquetaRenta() {
        if (this.etiquetaRenta == null) {
            this.etiquetaRenta = new ArrayList();
        }

        return this.etiquetaRenta;
    }
}
