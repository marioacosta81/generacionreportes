package com.davivienda.generarReporte.config.reporte;

import com.ibm.comunes.log.Logger;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"plantilla"})
public class Plantillas
        implements Serializable {

    private static HashMap<String, Plantilla> mapPlantillas;
    private List<Plantilla> plantilla;

    public List<Plantilla> getPlantilla() {
        return this.plantilla;
    }

    public void setPlantilla(List<Plantilla> plantilla) {
        this.plantilla = plantilla;
    }

    public void cargarMapPlantillas(Logger logger) {
//        System.out.println("Se carga cache de plantillas");
        printLogPlantillas(logger, "Se carga cache de plantillas");
        mapPlantillas = new HashMap<>();
        if (this.plantilla != null) {
            if (!this.plantilla.isEmpty()) {
                for (Plantilla cert : this.plantilla) {
                    if (cert.getVersion() == null) {
                        mapPlantillas.put(cert.getNombre(), cert);
                        //System.out.println("Se agrega a cache Plantilla: " + cert.getNombre());
                        printLogPlantillas(logger, "Se agrega a cache Plantilla: " + cert.getNombre());
                        continue;
                    }
                    mapPlantillas.put(cert.getNombre() + "_" + cert.getVersion(), cert);
//                    System.out.println("Se agrega a cache Plantilla: " + cert.getNombre() + " - Version: " + cert.getVersion());
                    printLogPlantillas(logger, "Se agrega a cache Plantilla: " + cert.getNombre() + " - Version: " + cert.getVersion());

                }
            } else {
                printLogPlantillas(logger, "Lista de Plantillas esta vacía");
//                System.out.println("Lista de Plantillas esta vacía");
            }
        } else {
            printLogPlantillas(logger, "Lista de Plantillas es null");
//            System.out.println("Lista de Plantillas es null");
        }
    }

    public Plantilla obtenerPlantillaCache(String nombrePlantilla) {
        Plantilla certResp = null;
        if (mapPlantillas == null) {
            cargarMapPlantillas(null);
        }
        certResp = mapPlantillas.get(nombrePlantilla);
        // System.out.println("Plantillas cache = " +certResp);
        return certResp;
    }

    private void printLogPlantillas(Logger logger, String msg) {
        if (logger != null) {
            logger.info(msg);
        } else {
            System.out.println("Lista de Plantillas esta vacía");
        }
    }
}
