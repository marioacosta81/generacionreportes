package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import com.davivienda.esquemas.framework.contextosolicitudtipo.v1.ObjectFactory;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

@WebService(
        name = "portSrvScnGeneracionReporteSOAP",
        targetNamespace = "http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1"
)
@SOAPBinding(
        parameterStyle = ParameterStyle.BARE
)
@XmlSeeAlso({
    ObjectFactory.class,
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
    com.davivienda.esquemas.generarreporte.respuestacertificadotipo.v1.ObjectFactory.class,
    com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.ObjectFactory.class
})
public interface PortSrvScnGeneracionReporteSOAP {

    @WebMethod(
            operationName = "OpGeneracionReporte",
            action = "http://www.davivienda.com/GenerarReporte/SrvScnConsultarPagare/v1/OpGeneracionReporte"
    )
    @WebResult(
            name = "msjRespOpGeneracionReporte",
            targetNamespace = "http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1",
            partName = "msjRespOpGeneracionReporte"
    )
    @Action(
            input = "http://www.davivienda.com/GenerarReporte/SrvScnConsultarPagare/v1/OpGeneracionReporte",
            output = "http://www.davivienda.com/GenerarReporte/SrvScnConsultarPagare/v1/portSrvScnGeneracionReporteSOAP/OpGeneracionReporteResponse"
    )
    MsjRespOpGeneracionReporte opGeneracionReporte(@WebParam(name = "msjSolOpGeneracionReporte", targetNamespace = "http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1", partName = "msjSolOpGeneracionReporte") MsjSolOpGeneracionReporte var1);
}
