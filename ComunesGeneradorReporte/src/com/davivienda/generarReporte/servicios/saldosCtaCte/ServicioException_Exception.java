package com.davivienda.generarReporte.servicios.saldosCtaCte;

import javax.xml.ws.WebFault;

@WebFault(name = "ServicioException", targetNamespace = "http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/")
public class ServicioException_Exception
        extends Exception {

    private ServicioException faultInfo;

    public ServicioException_Exception(String message, ServicioException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public ServicioException_Exception(String message, ServicioException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    public ServicioException getFaultInfo() {
        return this.faultInfo;
    }
}
