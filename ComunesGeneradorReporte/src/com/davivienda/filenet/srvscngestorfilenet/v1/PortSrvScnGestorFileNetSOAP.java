package com.davivienda.filenet.srvscngestorfilenet.v1;

import javax.xml.ws.Action;
import javax.jws.WebResult;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.davivienda.esquemas.framework.contextosolicitudtipo.v1.ObjectFactory;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebService;

@WebService(name = "portSrvScnGestorFileNetSOAP", targetNamespace = "http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class,
    com.davivienda.esquemas.filenet.documentotipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.filenet.otraspropiedadtipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.filenet.propiedadtipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.aplicaciontipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.canaltipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.consumidortipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.contextorespuestatipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.criterioordenamientotipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.errortipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.huelladigitaldispositivotipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.operacioncanaltipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.paginaciontipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.resultadotransacciontipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.serviciotipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.terminaltipo.v1.ObjectFactory.class,
    com.davivienda.filenet.srvscngestorfilenet.v1.ObjectFactory.class})
public interface PortSrvScnGestorFileNetSOAP {

    @WebMethod(operationName = "OpCargarDocumento", action = "http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1/OpCargarDocumento")
    @WebResult(name = "msjRespOpCargarDocumento", targetNamespace = "http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1", partName = "msjRespOpCargarDocumento")
    @Action(input = "http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1/OpCargarDocumento", output = "http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1/portSrvScnGestorFileNetSOAP/OpCargarDocumentoResponse")
    MsjRespOpCargarDocumento opCargarDocumento(@WebParam(name = "msjSolOpCargarDocumento", targetNamespace = "http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1", partName = "msjSolOpCargarDocumento") final MsjSolOpCargarDocumento p0);
}
