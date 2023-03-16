package co.com.davivienda.consultasproducto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "RegistrosType",
        propOrder = {"registro"}
)
public class RegistrosType {

    @XmlElement(
            name = "Registro",
            required = true
    )
    protected List<RegistroType> registro;

    public List<RegistroType> getRegistro() {
        if (this.registro == null) {
            this.registro = new ArrayList();
        }

        return this.registro;
    }
}
