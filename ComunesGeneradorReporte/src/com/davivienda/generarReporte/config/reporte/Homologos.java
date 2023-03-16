package com.davivienda.generarReporte.config.reporte;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"homologar"})
public class Homologos
        implements Serializable {

    private static HashMap<String, Homologo> mapHomologos;
    private List<Homologo> homologar;

    public List<Homologo> getHomologo() {
        return this.homologar;
    }

    public void setHomologo(List<Homologo> homologar) {
        this.homologar = homologar;
    }

    public void cargarMapHomologos() {
        System.out.println("Se cargarcache de homologos");
        mapHomologos = new HashMap<String, Homologo>();
        if (this.homologar != null) {
            if (!this.homologar.isEmpty()) {
                for (Homologo cert : this.homologar) {
                    mapHomologos.put(cert.getValor(), cert);
                    System.out.println("Se agrega a cachHomologo: " + cert.getValor());
                }
            } else {
                System.out.println("Lista de Homologos esta vacía");
      } 
    } else {
      System.out.println("Lista de Homologos es null");
        }
    }

    public Homologo obtenerHomologosCache(String valor) {
        Homologo certResp = null;
        if (mapHomologos == null) {
            cargarMapHomologos();
        }
        certResp = mapHomologos.get(valor);
        return certResp;
    }
}
