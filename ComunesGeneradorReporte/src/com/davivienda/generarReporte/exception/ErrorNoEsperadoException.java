package com.davivienda.generarReporte.exception;

public class ErrorNoEsperadoException
        extends Exception {

    private String codError;

    public ErrorNoEsperadoException(String message) {
        super(message);
    }

    public ErrorNoEsperadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorNoEsperadoException(Throwable cause) {
        super(cause);
    }

    public ErrorNoEsperadoException(String codError, String message) {
        super(message);
        this.codError = codError;
    }

    public String getCodError() {
        return this.codError;
    }

    public void setCodError(String codError) {
        this.codError = codError;
    }
}
