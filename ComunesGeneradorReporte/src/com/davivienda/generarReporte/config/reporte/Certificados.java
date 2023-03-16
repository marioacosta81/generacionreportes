package com.davivienda.generarReporte.config.reporte;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"certificado"})
public class Certificados
        implements Serializable {

    private static HashMap<String, Certificado> mapParamCertificados;
    private List<Certificado> certificado;

    public List<Certificado> getCertificado() {
        return this.certificado;
    }

    public void setCertificado(List<Certificado> certificado) {
        this.certificado = certificado;
    }

    public void cargarMapCertificados() {
        System.out.println("Se carga cache de certificados");
        mapParamCertificados = new HashMap<String, Certificado>();
        if (this.certificado != null) {
            if (!this.certificado.isEmpty()) {
                for (Certificado cert : this.certificado) {
                    mapParamCertificados.put(cert.getNombre(), cert);
                    System.out.println("Se agrega a cachcertificado: " + cert.getNombre());
                }
            } else {
                System.out.println("Lista de certificados está vacía");
      } 
    } else {
      System.out.println("Lista de certificados es null");
        }
    }

    public Certificado obtenerCertificadoCache(String nombreCertificado) {
        Certificado certResp = null;
        if (mapParamCertificados == null) {
            cargarMapCertificados();
        }
        certResp = mapParamCertificados.get(nombreCertificado);
        return certResp;
    }
}
