package com.davivienda.filenet.srvscngestorfilenet.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _MsjSolOpCargarDocumento_QNAME = new QName("http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1", "msjSolOpCargarDocumento");
    private static final QName _MsjRespOpCargarDocumento_QNAME = new QName("http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1", "msjRespOpCargarDocumento");
    private static final QName _MsjSolOpLinkearDocumento_QNAME = new QName("http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1", "msjSolOpLinkearDocumento");
    private static final QName _MsjRespOpLinkearDocumento_QNAME = new QName("http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1", "msjRespOpLinkearDocumento");

    public MsjRespOpLinkearDocumento createMsjRespOpLinkearDocumento() {
        return new MsjRespOpLinkearDocumento();
    }

    public MsjSolOpCargarDocumento createMsjSolOpCargarDocumento() {
        return new MsjSolOpCargarDocumento();
    }

    public MsjRespOpCargarDocumento createMsjRespOpCargarDocumento() {
        return new MsjRespOpCargarDocumento();
    }

    public MsjSolOpLinkearDocumento createMsjSolOpLinkearDocumento() {
        return new MsjSolOpLinkearDocumento();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1", name = "msjSolOpCargarDocumento")
    public JAXBElement<MsjSolOpCargarDocumento> createMsjSolOpCargarDocumento(MsjSolOpCargarDocumento value) {
        return new JAXBElement<MsjSolOpCargarDocumento>(_MsjSolOpCargarDocumento_QNAME, MsjSolOpCargarDocumento.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1", name = "msjRespOpCargarDocumento")
    public JAXBElement<MsjRespOpCargarDocumento> createMsjRespOpCargarDocumento(MsjRespOpCargarDocumento value) {
        return new JAXBElement<MsjRespOpCargarDocumento>(_MsjRespOpCargarDocumento_QNAME, MsjRespOpCargarDocumento.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1", name = "msjSolOpLinkearDocumento")
    public JAXBElement<MsjSolOpLinkearDocumento> createMsjSolOpLinkearDocumento(MsjSolOpLinkearDocumento value) {
        return new JAXBElement<MsjSolOpLinkearDocumento>(_MsjSolOpLinkearDocumento_QNAME, MsjSolOpLinkearDocumento.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/FileNet/SrvScnGestorFileNet/v1", name = "msjRespOpLinkearDocumento")
    public JAXBElement<MsjRespOpLinkearDocumento> createMsjRespOpLinkearDocumento(MsjRespOpLinkearDocumento value) {
        return new JAXBElement<MsjRespOpLinkearDocumento>(_MsjRespOpLinkearDocumento_QNAME, MsjRespOpLinkearDocumento.class, null, value);
    }
}
