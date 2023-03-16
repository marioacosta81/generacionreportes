// Decompiled using: fernflower
// Took: 10ms

package com.davivienda.generarReporte.reporte.config.wsServicios;

public class ItemNumeroProducto {
   private String series;
   private Integer numProducto;
   private Short digitoChequeo;

   public ItemNumeroProducto(String series, Integer numProducto, Short digitoChequeo) {
      this.series = series;
      this.numProducto = numProducto;
      this.digitoChequeo = digitoChequeo;
   }

   public String getSeries() {
      return this.series;
   }

   public void setSeries(String series) {
      this.series = series;
   }

   public Integer getNumProducto() {
      return this.numProducto;
   }

   public void setNumProducto(Integer numProducto) {
      this.numProducto = numProducto;
   }

   public Short getDigitoChequeo() {
      return this.digitoChequeo;
   }

   public void setDigitoChequeo(Short digitoChequeo) {
      this.digitoChequeo = digitoChequeo;
   }

   public String toString() {
      return "ItemNumeroProducto{series=" + this.series + ", numProducto=" + this.numProducto + ", digitoChequeo=" + this.digitoChequeo + '}';
   }
}
