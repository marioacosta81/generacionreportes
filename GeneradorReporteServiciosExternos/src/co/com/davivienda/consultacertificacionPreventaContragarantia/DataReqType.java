package co.com.davivienda.consultacertificacionPreventaContragarantia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "DataReqType",
        propOrder = {"valCodigoOficina", "valTalon", "fecCertificacion", "valNumeroProducto"}
)
public class DataReqType {

    @XmlElement(
            required = true
    )
    protected String valCodigoOficina;
    @XmlElement(
            required = true
    )
    protected String valTalon;
    @XmlElement(
            required = true
    )
    @XmlSchemaType(
            name = "date"
    )
    protected XMLGregorianCalendar fecCertificacion;
    @XmlElement(
            required = true
    )
    protected String valNumeroProducto;

    public String getValCodigoOficina() {
        return this.valCodigoOficina;
    }

    public void setValCodigoOficina(String value) {
        this.valCodigoOficina = value;
    }

    public String getValTalon() {
        return this.valTalon;
    }

    public void setValTalon(String value) {
        this.valTalon = value;
    }

    public XMLGregorianCalendar getFecCertificacion() {
        return this.fecCertificacion;
    }

    public void setFecCertificacion(XMLGregorianCalendar value) {
        this.fecCertificacion = value;
    }

    public String getValNumeroProducto() {
        return this.valNumeroProducto;
    }

    public void setValNumeroProducto(String value) {
        this.valNumeroProducto = value;
    }
}
