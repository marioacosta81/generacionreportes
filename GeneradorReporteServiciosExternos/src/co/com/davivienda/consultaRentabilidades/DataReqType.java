// Decompiled using: fernflower
// Took: 6ms

package co.com.davivienda.consultaRentabilidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
   name = "DataReqType",
   propOrder = {"valCodigoOficina", "valTalon", "fecConsulta", "valNitNegocio"}
)
public class DataReqType {
   @XmlElement(
      required = true,
      type = Integer.class,
      nillable = true
   )
   protected Integer valCodigoOficina;
   @XmlElement(
      required = true,
      type = Integer.class,
      nillable = true
   )
   protected Integer valTalon;
   @XmlElement(
      required = true,
      nillable = true
   )
   @XmlSchemaType(
      name = "date"
   )
   protected XMLGregorianCalendar fecConsulta;
   @XmlElement(
      required = true,
      type = Long.class,
      nillable = true
   )
   protected Long valNitNegocio;

   public Integer getValCodigoOficina() {
      return this.valCodigoOficina;
   }

   public void setValCodigoOficina(Integer value) {
      this.valCodigoOficina = value;
   }

   public Integer getValTalon() {
      return this.valTalon;
   }

   public void setValTalon(Integer value) {
      this.valTalon = value;
   }

   public XMLGregorianCalendar getFecConsulta() {
      return this.fecConsulta;
   }

   public void setFecConsulta(XMLGregorianCalendar value) {
      this.fecConsulta = value;
   }

   public Long getValNitNegocio() {
      return this.valNitNegocio;
   }

   public void setValNitNegocio(Long value) {
      this.valNitNegocio = value;
   }
}
