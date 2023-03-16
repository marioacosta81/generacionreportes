/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davivienda.generarReporte.interfaces;

import com.ibm.comunes.servicios.OperacionSCNRemote;
import com.ibm.comunes.servicios.SCNMensajeEntrada;
import com.ibm.comunes.servicios.SCNMensajeSalida;
import javax.ejb.Local;

/**
 *
 * @author FRANARE
 */
@Local
public interface OpGenerarReporteLocal <REQ extends SCNMensajeEntrada, RESP extends SCNMensajeSalida> extends OperacionSCNRemote<REQ, RESP>{

}
   