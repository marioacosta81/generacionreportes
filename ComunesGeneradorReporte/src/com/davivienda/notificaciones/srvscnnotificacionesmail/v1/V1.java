package com.davivienda.notificaciones.srvscnnotificacionesmail.v1;

import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.WebEndpoint;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;
import java.net.URL;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.Service;

@WebServiceClient(name = "v1", targetNamespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", wsdlLocation = "/META-INF/wsdl/SrvScnGestorFileNet/v1_1.wsdl")
public class V1 extends Service {

    private static final URL V1_WSDL_LOCATION;
    private static final WebServiceException V1_EXCEPTION;
    private static final QName V1_QNAME;

    public V1() {
        super(__getWsdlLocation(), V1.V1_QNAME);
    }

    public V1(final URL wsdlLocation) {
        super(wsdlLocation, V1.V1_QNAME);
    }

    @WebEndpoint(name = "portSrvScnNotificacionesMailSOAP")
    public PortSrvScnNotificacionesMailSOAP getPortSrvScnNotificacionesMailSOAP() {
        return super.getPort(new QName("http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", "portSrvScnNotificacionesMailSOAP"), PortSrvScnNotificacionesMailSOAP.class);
    }

    @WebEndpoint(name = "portSrvScnNotificacionesMailSOAP")
    public PortSrvScnNotificacionesMailSOAP getPortSrvScnNotificacionesMailSOAP(final WebServiceFeature... features) {
        return super.getPort(new QName("http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", "portSrvScnNotificacionesMailSOAP"), PortSrvScnNotificacionesMailSOAP.class, features);
    }

    private static URL __getWsdlLocation() {
        if (V1.V1_EXCEPTION != null) {
            throw V1.V1_EXCEPTION;
        }
        return V1.V1_WSDL_LOCATION;
    }

    static {
        V1_QNAME = new QName("http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", "v1");
        V1_WSDL_LOCATION = com.davivienda.filenet.srvscngestorfilenet.v1.V1.class.getResource("/META-INF/wsdl/SrvScnNotificacionesMail/v1_1.wsdl");
        WebServiceException e = null;
        if (V1.V1_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find '/META-INF/wsdl/SrvScnNotificacionesMail/v1_1.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        V1_EXCEPTION = e;
    }
}
