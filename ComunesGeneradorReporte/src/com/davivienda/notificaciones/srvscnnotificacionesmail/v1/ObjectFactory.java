package com.davivienda.notificaciones.srvscnnotificacionesmail.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _MsjSolOpEnviarMail_QNAME = new QName("http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", "msjSolOpEnviarMail");
    private static final QName _MsjRespOpEnviarMail_QNAME = new QName("http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", "msjRespOpEnviarMail");

    public MsjSolOpEnviarMail createMsjSolOpEnviarMail() {
        return new MsjSolOpEnviarMail();
    }

    public MsjRespOpEnviarMail createMsjRespOpEnviarMail() {
        return new MsjRespOpEnviarMail();
    }

    public ParametroPlantillaTipo createParametroPlantillaTipo() {
        return new ParametroPlantillaTipo();
    }

    public MensajeTipo createMensajeTipo() {
        return new MensajeTipo();
    }

    public PlantillaTipo createPlantillaTipo() {
        return new PlantillaTipo();
    }

    public DataMail createDataMail() {
        return new DataMail();
    }

    public DestinoTipo createDestinoTipo() {
        return new DestinoTipo();
    }

    public AdjuntoTipo createAdjuntoTipo() {
        return new AdjuntoTipo();
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", name = "msjSolOpEnviarMail")
    public JAXBElement<MsjSolOpEnviarMail> createMsjSolOpEnviarMail(MsjSolOpEnviarMail value) {
        return new JAXBElement<MsjSolOpEnviarMail>(_MsjSolOpEnviarMail_QNAME, MsjSolOpEnviarMail.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.davivienda.com/Notificaciones/SrvScnNotificacionesMail/v1", name = "msjRespOpEnviarMail")
    public JAXBElement<MsjRespOpEnviarMail> createMsjRespOpEnviarMail(MsjRespOpEnviarMail value) {
        return new JAXBElement<MsjRespOpEnviarMail>(_MsjRespOpEnviarMail_QNAME, MsjRespOpEnviarMail.class, null, value);
    }
}
