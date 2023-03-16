package com.davivienda.generarReporte.servicios.saldosCtaCte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "campoExtendidoDto", propOrder = {"jMascara", "pMascara", "valor"})
public class CampoExtendidoDto
        extends CampoDto {

    @XmlElement(name = "JMascara")
    protected String jMascara;
    @XmlElement(name = "PMascara")
    protected String pMascara;
    protected String valor;

    public String getJMascara() {
        return this.jMascara;
    }

    public void setJMascara(String value) {
        this.jMascara = value;
    }

    public String getPMascara() {
        return this.pMascara;
    }

    public void setPMascara(String value) {
        this.pMascara = value;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String value) {
        this.valor = value;
    }
}
