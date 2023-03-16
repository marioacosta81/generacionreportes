// Decompiled using: fernflower
// Took: 3ms

package co.com.davivienda.consultaRentabilidades;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
   name = "ParticipacionesRespType",
   propOrder = {"participacion"}
)
public class ParticipacionesRespType {
   @XmlElement(
      name = "Participacion",
      required = true
   )
   protected List<ARRParticipacionesType> participacion;

   public List<ARRParticipacionesType> getParticipacion() {
      if (this.participacion == null) {
         this.participacion = new ArrayList();
      }

      return this.participacion;
   }
}
