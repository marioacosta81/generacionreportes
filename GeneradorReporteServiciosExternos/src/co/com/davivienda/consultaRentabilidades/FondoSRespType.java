package co.com.davivienda.consultaRentabilidades;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "FondoSRespType",
        propOrder = {"fondo"}
)
public class FondoSRespType {

    @XmlElement(
            name = "Fondo",
            required = true
    )
    protected List<ARRFondosRespType> fondo;

    public List<ARRFondosRespType> getFondo() {
        if (this.fondo == null) {
            this.fondo = new ArrayList();
        }

        return this.fondo;
    }
}
