package co.com.davivienda.consultaRentabilidades;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "RentaParticipacionRespType",
        propOrder = {"rentaParticipacion"}
)
public class RentaParticipacionRespType {

    @XmlElement(
            name = "RentaParticipacion",
            required = true
    )
    protected List<ARRRentabilidadesRespType> rentaParticipacion;

    public List<ARRRentabilidadesRespType> getRentaParticipacion() {
        if (this.rentaParticipacion == null) {
            this.rentaParticipacion = new ArrayList();
        }

        return this.rentaParticipacion;
    }
}
