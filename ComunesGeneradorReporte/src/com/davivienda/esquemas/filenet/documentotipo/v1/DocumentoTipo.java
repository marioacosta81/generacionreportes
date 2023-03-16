package com.davivienda.esquemas.filenet.documentotipo.v1;

import com.davivienda.esquemas.filenet.otraspropiedadtipo.v1.OtrasPropiedadTipo;
import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentoTipo", propOrder = {"valClaseDocumento", "valMimeType", "valContenido", "otrasPropiedades"})
public class DocumentoTipo {

    protected String valClaseDocumento;
    protected String valMimeType;
    @XmlMimeType("application/octet-stream")
    protected byte[]  valContenido;
    protected OtrasPropiedadTipo otrasPropiedades;

    public byte[] getValContenido() {
        return valContenido;
    }

    public void setValContenido(byte[] valContenido) {
        this.valContenido = valContenido;
    }

    public String getValClaseDocumento() {
        return this.valClaseDocumento;
    }

    public void setValClaseDocumento(String value) {
        this.valClaseDocumento = value;
    }

    public String getValMimeType() {
        return this.valMimeType;
    }

    public void setValMimeType(String value) {
        this.valMimeType = value;
    }



    public OtrasPropiedadTipo getOtrasPropiedades() {
        return this.otrasPropiedades;
    }

    public void setOtrasPropiedades(OtrasPropiedadTipo value) {
        this.otrasPropiedades = value;
    }
      public byte[] getContenidoByte() {
        return valContenido;
    }

    public void setContenidoByte(byte[] contenidoByte) {
        this.valContenido = contenidoByte;
    }
}
