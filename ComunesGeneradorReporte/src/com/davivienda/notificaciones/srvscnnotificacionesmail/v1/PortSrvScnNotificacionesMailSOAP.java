package com.davivienda.notificaciones.srvscnnotificacionesmail.v1;

import javax.xml.ws.Action;
import javax.jws.WebResult;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.davivienda.esquemas.framework.contactotipo.v1.ObjectFactory;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebService;

@WebService(name = "portSrvScnNotificacionesMailSOAP", targetNamespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class,
    com.davivienda.esquemas.framework.contextosolicitudtipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.aplicaciontipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.canaltipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.consumidortipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.contextorespuestatipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.criterioordenamientotipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.departamentotipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.errortipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.huelladigitaldispositivotipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.municipiotipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.operacioncanaltipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.paginaciontipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.personatipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.preguntaseguridadtipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.resultadotransacciontipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.serviciotipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.telefonotipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.terminaltipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.tokentipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.framework.ubicacionpersonatipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.persona.clientenaturaltipo.v1.ObjectFactory.class,
    com.davivienda.esquemas.persona.personanaturaltipo.v1.ObjectFactory.class,
    com.davivienda.notificaciones.srvscnnotificacionesmail.v1.ObjectFactory.class
})
public interface PortSrvScnNotificacionesMailSOAP {

    @WebMethod(action = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1/opEnviarMail")
    @WebResult(name = "msjRespOpEnviarMail", targetNamespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", partName = "msjRespOpEnviarMail")
    @Action(input = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1/opEnviarMail", output = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1/portSrvScnNotificacionesMailSOAP/opEnviarMailResponse")
    MsjRespOpEnviarMail opEnviarMail(@WebParam(name = "msjSolOpEnviarMail", targetNamespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", partName = "msjSolOpEnviarMail") final MsjSolOpEnviarMail p0);
}
