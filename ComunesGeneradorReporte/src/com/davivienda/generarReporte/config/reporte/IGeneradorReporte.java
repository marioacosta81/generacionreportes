package com.davivienda.generarReporte.config.reporte;

import com.davivienda.generarReporte.exception.GenerarReporteException;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.servicios.RespuestaServicios;

public interface IGeneradorReporte {

    String inicializar(Plantilla paramPlantilla) throws GenerarReporteException;

    byte[] transformarDinamico(String fileContent, RespuestaServicios paramRespuestaServicios, MsjSolOpGeneracionReporte paramMsjSolOpGeneracionReporte) throws GenerarReporteException;
}
