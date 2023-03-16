package co.com.davivienda.consultaRentabilidades;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "EtiquetasRentaRespType",
        propOrder = {"etiquetas"}
)
public class EtiquetasRentaRespType {

    @XmlElement(
            name = "Etiquetas",
            required = true
    )
    protected List<EtiquetasType> etiquetas;

    public List<EtiquetasType> getEtiquetas() {
        if (this.etiquetas == null) {
            this.etiquetas = new ArrayList();
        }

        return this.etiquetas;
    }
}
