package com.davivienda.generarReporte.util;

import com.ibm.adaptadorws.exception.AdaptadorWSException;
import com.ibm.adaptadorws.exception.AdaptadorWSIOException;
import com.ibm.adaptadorws.exception.AdaptadorWSTimeOutException;
import com.ibm.comunes.exception.ConfiguracionException;
import com.ibm.comunes.servicios.exception.ServicioESBException;
import com.ibm.comunes.util.ComunesUtil;
import com.ibm.comunes.utilitarios.ExceptionCodErrorMapper;

public class GenerarReporteErrorMapper
        implements ExceptionCodErrorMapper {

    private static GenerarReporteErrorMapper instance;

    public static GenerarReporteErrorMapper getInstance() {
        if (instance == null) {
            instance = new GenerarReporteErrorMapper();
        }
        return instance;
    }

    public String obtenerCodigoError(Throwable thrwbl) {
        if (ComunesUtil.isExceptionOrContains(AdaptadorWSTimeOutException.class.getSimpleName(), thrwbl)) {
            return "22";
        }
        if (ComunesUtil.isExceptionOrContains(AdaptadorWSIOException.class.getSimpleName(), thrwbl)) {
            return "20";
        }
        if (ComunesUtil.isExceptionOrContains(AdaptadorWSException.class.getSimpleName(), thrwbl)) {
            return "20";
        }
        if (ComunesUtil.isExceptionOrContains(ServicioESBException.class.getSimpleName(), thrwbl)) {
            return "20";
        }
        if (ComunesUtil.isExceptionOrContains(ConfiguracionException.class.getSimpleName(), thrwbl)) {
            return "999";
        }
        return "43";
    }

    public String obtenerCodigoErrorConfiguracion() {
        return "999";
    }
}
