package com.davivienda.generarReporte.exception;

import com.ibm.comunes.servicios.exception.SCNException;

public class GenerarReporteException
        extends SCNException {

    private String codError;

    public GenerarReporteException() {
    }

    public GenerarReporteException(int codError) {
        this.codError = Integer.toString(codError);
    }

    public GenerarReporteException(String codError, String message) {
        super(message);
        this.codError = codError;
    }

    public GenerarReporteException(String message) {
        super(message);
    }

    public GenerarReporteException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getCodError() {
        return this.codError;
    }

    public void setCodError(String codError) {
        this.codError = codError;
    }
}
