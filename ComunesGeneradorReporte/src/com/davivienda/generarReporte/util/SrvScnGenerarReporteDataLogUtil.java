package com.davivienda.generarReporte.util;

import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.ClienteType;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.ProductoType;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.ReporteType;
import java.util.HashMap;

public class SrvScnGenerarReporteDataLogUtil {

    public static HashMap construirMapaParaMensaje(Object data) {
        if (data != null
                && data instanceof MsjSolOpGeneracionReporte) {
            return datosMsjSolOpGeneracionReporte((MsjSolOpGeneracionReporte) data);
        }

        return null;
    }

    private static HashMap datosMsjSolOpGeneracionReporte(MsjSolOpGeneracionReporte request) {
        HashMap<String, String> data = new HashMap<String, String>();

        ClienteType clienteType = request.getCliente();
        ProductoType productoType = request.getProducto();
        ReporteType reporteType = request.getReporte();

        if (clienteType != null) {
            if (clienteType.getCiudadExpedicionDocumento() != null) {
                data.put("cliente.CiudadExpedicionDocumento", clienteType.getCiudadExpedicionDocumento());
            }
            if (clienteType.getNombres() != null) {
                data.put("cliente.Nombres", clienteType.getNombres());
            }
            if (clienteType.getNumeroIdentificacion() != null) {
                data.put("cliente.NumeroIdentificacion", clienteType.getNumeroIdentificacion());
            }
            if (clienteType.getPrimerApellido() != null) {
                data.put("cliente.PrimerApellido", clienteType.getPrimerApellido());
            }
            if (clienteType.getSegundoApellido() != null) {
                data.put("cliente.CiudadExpedicionDocumento", clienteType.getSegundoApellido());
            }
            data.put("cliente.TipoIdentificacion", String.valueOf(clienteType.getTipoIdentificacion()));
        }

        if (productoType != null) {
            if (productoType.getCodigoTipoProducto() != null) {
                data.put("producto.CodigoTipoProducto", productoType.getCodigoTipoProducto());
            }
            if (productoType.getCodigoSubProducto() != null) {
                data.put("producto.CodigoSubProducto", productoType.getCodigoSubProducto());
            }
        }

        if (reporteType != null) {
            if (reporteType.getCiudadEmision() != null) {
                data.put("reporte.CiudadEmision", reporteType.getCiudadEmision());
            }
            if (reporteType.getDirigidoA() != null) {
                data.put("reporte.DirigidoA", reporteType.getDirigidoA());
            }
            if (reporteType.getFormato() != null) {
                data.put("reporte.CiudadEmision", reporteType.getFormato());
            }
            if (reporteType.getTipoCertificacion() != null) {
                data.put("reporte.CiudadEmision", reporteType.getTipoCertificacion());
            }
            if (reporteType.getTituloPersonal() != null) {
                data.put("reporte.CiudadEmision", reporteType.getTituloPersonal());
            }
        }

        return data;
    }
}
