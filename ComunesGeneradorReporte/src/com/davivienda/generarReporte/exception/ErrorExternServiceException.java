package com.davivienda.generarReporte.exception;

public class ErrorExternServiceException
        extends Exception {

    private String codError;

    public String getCodError() {
        return this.codError;
    }

    public void setCodError(String codError) {
        this.codError = codError;
    }

    public ErrorExternServiceException(String codError) {
        this.codError = codError;
    }

    public ErrorExternServiceException(String codError, String message) {
        super(message);
        this.codError = codError;
    }

    public ErrorExternServiceException(String codError, String message, Throwable cause) {
        super(message, cause);
        this.codError = codError;
    }

    public ErrorExternServiceException(String codError, Throwable cause) {
        super(cause);
        this.codError = codError;
    }
}
