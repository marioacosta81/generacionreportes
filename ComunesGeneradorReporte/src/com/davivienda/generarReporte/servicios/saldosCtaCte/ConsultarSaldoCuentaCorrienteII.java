package com.davivienda.generarReporte.servicios.saldosCtaCte;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ConsultarSaldoCuentaCorrienteII", targetNamespace = "http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/")
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultarSaldoCuentaCorrienteII {

    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultaSaldoCuentaCorriente", targetNamespace = "http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/", className = "com.davivienda.generarReporte.servicios.saldosCtaCte.ConsultaSaldoCuentaCorriente")
    @ResponseWrapper(localName = "consultaSaldoCuentaCorrienteResponse", targetNamespace = "http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/", className = "com.davivienda.generarReporte.servicios.saldosCtaCte.ConsultaSaldoCuentaCorrienteResponse")
    RespuestaConsultaSaldoCuentaCorrienteIIDto consultaSaldoCuentaCorriente(@WebParam(name = "dto", targetNamespace = "") ConsultaSaldoCuentaCorrienteIIDto paramConsultaSaldoCuentaCorrienteIIDto) throws ServicioException_Exception;
}
