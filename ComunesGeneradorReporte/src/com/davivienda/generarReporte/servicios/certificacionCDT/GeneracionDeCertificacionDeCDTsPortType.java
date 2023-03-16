package com.davivienda.generarReporte.servicios.certificacionCDT;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "GeneracionDeCertificacionDeCDTsPortType", targetNamespace = "http://www.davivienda.com/xml/GeneracionDeCertificacionDeCDTs")
@XmlSeeAlso({ObjectFactory.class})
public interface GeneracionDeCertificacionDeCDTsPortType {

    @WebMethod(operationName = "GeneracionDeCertificacionDeCDTs")
    @WebResult(name = "Response", targetNamespace = "")
    @RequestWrapper(localName = "GeneracionDeCertificacionDeCDTs", targetNamespace = "http://www.davivienda.com/xml/GeneracionDeCertificacionDeCDTs", className = "com.davivienda.generarReporte.servicios.certificacionCDT.GeneracionDeCertificacionDeCDTsType")
    @ResponseWrapper(localName = "GeneracionDeCertificacionDeCDTsResponse", targetNamespace = "http://www.davivienda.com/xml/GeneracionDeCertificacionDeCDTs", className = "com.davivienda.generarReporte.servicios.certificacionCDT.GeneracionDeCertificacionDeCDTsResponseType")
    ResponseType generacionDeCertificacionDeCDTs(@WebParam(name = "Request", targetNamespace = "") RequestGeneracionDeCertificacionDeCDTs paramRequestGeneracionDeCertificacionDeCDTs);
}
