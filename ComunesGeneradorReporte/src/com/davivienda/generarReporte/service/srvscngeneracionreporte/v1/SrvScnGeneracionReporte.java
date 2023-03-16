package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "srvScnGeneracionReporte", targetNamespace = "http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1", wsdlLocation = "file:/C:/$user/F/JSWFP/Test/TestWebService/src/conf/xml-resources/web-services/SrvScnGeneracionReporte/wsdl/SrvScnGeneracionReporte.wsdl")
public class SrvScnGeneracionReporte
        extends Service {

    private static final URL SRVSCNGENERACIONREPORTE_WSDL_LOCATION;
    private static final WebServiceException SRVSCNGENERACIONREPORTE_EXCEPTION;
    private static final QName SRVSCNGENERACIONREPORTE_QNAME = new QName("http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1", "srvScnGeneracionReporte");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/$user/F/JSWFP/Test/TestWebService/src/conf/xml-resources/web-services/SrvScnGeneracionReporte/wsdl/SrvScnGeneracionReporte.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SRVSCNGENERACIONREPORTE_WSDL_LOCATION = url;
        SRVSCNGENERACIONREPORTE_EXCEPTION = e;
    }

    public SrvScnGeneracionReporte() {
        super(__getWsdlLocation(), SRVSCNGENERACIONREPORTE_QNAME);
    }

    public SrvScnGeneracionReporte(WebServiceFeature... features) {
        super(__getWsdlLocation(), SRVSCNGENERACIONREPORTE_QNAME, features);
    }

    public SrvScnGeneracionReporte(URL wsdlLocation) {
        super(wsdlLocation, SRVSCNGENERACIONREPORTE_QNAME);
    }

    public SrvScnGeneracionReporte(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SRVSCNGENERACIONREPORTE_QNAME, features);
    }

    public SrvScnGeneracionReporte(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SrvScnGeneracionReporte(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
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
        if (SRVSCNGENERACIONREPORTE_EXCEPTION != null) {
            throw SRVSCNGENERACIONREPORTE_EXCEPTION;
        }
        return SRVSCNGENERACIONREPORTE_WSDL_LOCATION;
    }
}
