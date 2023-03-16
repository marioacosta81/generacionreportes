package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;


import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "v1", targetNamespace = "http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1", wsdlLocation = "/META-INF/wsdl/SrvScnGeneracionReporte/v1_1.wsdl")
public class V1 extends Service {

    private static final URL V1_WSDL_LOCATION;
    private static final WebServiceException V1_EXCEPTION;
    private static final QName V1_QNAME = new QName("http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1", "v1");

    static {
        V1_WSDL_LOCATION = V1.class.getResource("/META-INF/wsdl/SrvScnGeneracionReporte/v1_1.wsdl");
        WebServiceException e = null;
        if (V1_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find '/META-INF/wsdl/SrvScnGeneracionReporte/v1_1.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        V1_EXCEPTION = e;
    }

    public V1() {
        super(__getWsdlLocation(), V1_QNAME);
    }

    public V1(URL wsdlLocation) {
        super(wsdlLocation, V1_QNAME);
    }

    @WebEndpoint(name = "portSrvScnGeneracionReporteSOAP")
    public PortSrvScnGeneracionReporteSOAP getPortSrvScnGeneracionReporteSOAP() {
        return getPort(new QName("http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1", "portSrvScnGeneracionReporteSOAP"), PortSrvScnGeneracionReporteSOAP.class);
    }

    @WebEndpoint(name = "portSrvScnGeneracionReporteSOAP")
    public PortSrvScnGeneracionReporteSOAP getPortSrvScnGeneracionReporteSOAP(WebServiceFeature... features) {
        return getPort(new QName("http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1", "portSrvScnGeneracionReporteSOAP"), PortSrvScnGeneracionReporteSOAP.class, features);
    }

    private static URL __getWsdlLocation() {
        if (V1_EXCEPTION != null) {
            throw V1_EXCEPTION;
        }
        return V1_WSDL_LOCATION;
    }
}
