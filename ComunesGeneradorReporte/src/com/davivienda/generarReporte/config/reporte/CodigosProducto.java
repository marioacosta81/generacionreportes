package com.davivienda.generarReporte.config.reporte;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"codProducto"})
public class CodigosProducto
        implements Serializable {

    private static HashMap<String, String> mapParamCodigosProducto;
    private List<CodProducto> codProducto;

    public List<CodProducto> getCodigoProducto() {
        return this.codProducto;
    }

    public void setCodigoProducto(List<CodProducto> codigoProducto) {
        this.codProducto = codigoProducto;
    }

    public void cargarMapCodigoProductos() {
        System.out.println("Se cargarcache de codigoProductos");
        mapParamCodigosProducto = new HashMap<String, String>();
        if (this.codProducto != null) {
            if (!this.codProducto.isEmpty()) {
                for (CodProducto cert : this.codProducto) {

                    String codProdConfig = String.valueOf(cert.getCod());

                    if (codProdConfig != null && cert.getNombre() != null) {
                        mapParamCodigosProducto.put(codProdConfig, cert.getNombre());
                        System.out.println("Se agrega a cachcodigoProducto: " + codProdConfig);
                    }
                    if (codProdConfig != null && cert.getNombreIngles() != null) {
                        mapParamCodigosProducto.put(codProdConfig + "-EN", cert.getNombreIngles());
                        System.out.println("Se agrega a cachcodigoProducto: " + codProdConfig);
                    }

                    if (cert.subProducto != null
                            && !cert.subProducto.isEmpty()) {
                        for (Subproducto subProducto : cert.subProducto) {
                            String subprodmap = String.valueOf(cert.getCod()) + "-" + String.valueOf(subProducto.getCod());
                            mapParamCodigosProducto.put(subprodmap, subProducto.getDescProducto());
                            System.out.println("Se agrega a cachcodigoSubProducto: " + subprodmap);
                            if (cert.getNombreIngles() != null) {
                                subprodmap = subprodmap + "-EN";
                                mapParamCodigosProducto.put(subprodmap, subProducto.getDescProductoIngles());
                                System.out.println("Se agrega a cachcodigoSubProducto: " + subprodmap);
                            }
                        }
                    }
                }
            } else {

                System.out.println("Lista de codigoProductos está vacía");
      } 
    } else {
      System.out.println("Lista de codigoProductos es null");
        }
    }

    public String obtenerCodigoProductoCache(String nombreCodigoProducto) {
        String certResp = null;
        if (mapParamCodigosProducto == null) {
            cargarMapCodigoProductos();
        }
        certResp = mapParamCodigosProducto.get(nombreCodigoProducto);
        return certResp;
    }
}
