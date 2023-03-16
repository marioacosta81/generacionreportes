package com.davivienda.generarReporte.config.reporte;

import com.davivienda.generarReporte.exception.GenerarReporteException;
import com.ibm.cache.bo.servicio.ConfiguracionServicio;
import com.ibm.comunes.log.Logger;
import java.util.HashMap;

public class FabricaGenerarReporte {

    private static HashMap<String, IGeneradorReporte> listReportes;
    private static FabricaGenerarReporte instance;

    private FabricaGenerarReporte() {
        listReportes = new HashMap<String, IGeneradorReporte>(0);
    }

    public static FabricaGenerarReporte getInstance() {
        if (instance == null) {
            instance = new FabricaGenerarReporte();
        }
        return instance;
    }

    public IGeneradorReporte getInstanciaReporte(String nombreReporte, ConfiguracionServicio cs, ConfigAdicional ca, Logger log) throws GenerarReporteException {
        IGeneradorReporte reporte = null;
        if (listReportes.containsKey(nombreReporte)) {
            reporte = listReportes.get(nombreReporte);
        } else {
            reporte = new GeneradorPDF(cs, ca, log);
            listReportes.put(nombreReporte, reporte);
        }
        return reporte;
    }
}
