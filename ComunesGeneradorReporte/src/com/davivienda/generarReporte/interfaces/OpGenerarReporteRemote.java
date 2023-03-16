package com.davivienda.generarReporte.interfaces;

import com.ibm.comunes.servicios.OperacionSCNRemote;
import com.ibm.comunes.servicios.SCNMensajeEntrada;
import com.ibm.comunes.servicios.SCNMensajeSalida;
import javax.ejb.Remote;

@Remote
public interface OpGenerarReporteRemote <REQ extends SCNMensajeEntrada, RESP extends SCNMensajeSalida> extends OperacionSCNRemote<REQ, RESP>{
    
}
