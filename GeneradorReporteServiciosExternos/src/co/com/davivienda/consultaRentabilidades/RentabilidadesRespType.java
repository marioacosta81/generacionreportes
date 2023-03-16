package co.com.davivienda.consultaRentabilidades;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "RentabilidadesRespType",
        propOrder = {"rentabilidades"}
)
public class RentabilidadesRespType {

    @XmlElement(
            name = "Rentabilidades",
            required = true
    )
    protected List<ARRRentabilidadesType> rentabilidades;

    public List<ARRRentabilidadesType> getRentabilidades() {
        if (this.rentabilidades == null) {
            this.rentabilidades = new ArrayList();
        }

        return this.rentabilidades;
    }
}
