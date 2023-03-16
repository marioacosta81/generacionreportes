// Decompiled using: fernflower
// Took: 9ms

package com.davivienda.generarReporte.reporte.config.wsServicios;

import java.math.BigDecimal;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.exception.ErrorExternServiceException;

public interface IClienteServicios<T>
{
    void nuevo(final short p0) throws ErrorExternServiceException;
    
    void asignarInformacion(final MsjSolOpGeneracionReporte p0, final BigDecimal p1) throws ErrorExternServiceException;
    
    Object invocar() throws ErrorExternServiceException;
    
    String getNombre() throws ErrorExternServiceException;
}
