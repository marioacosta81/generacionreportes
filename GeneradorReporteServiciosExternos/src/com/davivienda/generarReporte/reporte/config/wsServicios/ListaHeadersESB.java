// Decompiled using: fernflower
// Took: 7ms

package com.davivienda.generarReporte.reporte.config.wsServicios;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(
   name = "listaHeadersESB"
)
@XmlType(
   propOrder = {"listaHeaders"}
)
public class ListaHeadersESB {
   private List<DataHeaderComunESB> listaHeaders;

   @XmlElement(
      name = "dataHeaderComunESB"
   )
   public List<DataHeaderComunESB> getListaHeaders() {
      return this.listaHeaders;
   }

   public void setListaHeaders(List<DataHeaderComunESB> listaHeaders) {
      this.listaHeaders = listaHeaders;
   }

   public String toString() {
      return "ListaHeadersESB [listaHeaders=" + this.listaHeaders + "]";
   }
}
