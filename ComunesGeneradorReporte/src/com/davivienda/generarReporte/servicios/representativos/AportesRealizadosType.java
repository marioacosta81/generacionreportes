package com.davivienda.generarReporte.servicios.representativos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AportesRealizadosType", propOrder = {"aporteRealizado"})
public class AportesRealizadosType {

    @XmlElement(name = "AporteRealizado")
    protected List<AporteRealizadoType> aporteRealizado;

    public List<AporteRealizadoType> getAporteRealizado() {
        if (this.aporteRealizado == null) {
            this.aporteRealizado = new ArrayList<AporteRealizadoType>();
        }
        return this.aporteRealizado;
    }
}
