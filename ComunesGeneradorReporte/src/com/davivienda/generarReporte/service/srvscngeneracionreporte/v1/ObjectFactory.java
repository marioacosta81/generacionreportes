package com.davivienda.generarReporte.service.srvscngeneracionreporte.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _MsjSolOpGeneracionReporte_QNAME = new QName("http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1", "msjSolOpGeneracionReporte");
    private static final QName _MsjRespOpGeneracionReporte_QNAME = new QName("http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1", "msjRespOpGeneracionReporte");

    public MsjSolOpGeneracionReporte createMsjSolOpGeneracionReporte() {
        return new MsjSolOpGeneracionReporte();
    }

    public MsjRespOpGeneracionReporte createMsjRespOpGeneracionReporte() {
        return new MsjRespOpGeneracionReporte();
    }

    public ClienteType createClienteType() {
        return new ClienteType();
    }

    public ReporteType createReporteType() {
        return new ReporteType();
    }

    public ProductoType createProductoType() {
        return new ProductoType();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1", name = "msjSolOpGeneracionReporte")
    public JAXBElement<MsjSolOpGeneracionReporte> createMsjSolOpGeneracionReporte(MsjSolOpGeneracionReporte value) {
        return new JAXBElement<MsjSolOpGeneracionReporte>(_MsjSolOpGeneracionReporte_QNAME, MsjSolOpGeneracionReporte.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1", name = "msjRespOpGeneracionReporte")
    public JAXBElement<MsjRespOpGeneracionReporte> createMsjRespOpGeneracionReporte(MsjRespOpGeneracionReporte value) {
        return new JAXBElement<MsjRespOpGeneracionReporte>(_MsjRespOpGeneracionReporte_QNAME, MsjRespOpGeneracionReporte.class, null, value);
    }
}
