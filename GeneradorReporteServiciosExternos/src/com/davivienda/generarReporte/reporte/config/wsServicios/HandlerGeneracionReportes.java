package com.davivienda.generarReporte.reporte.config.wsServicios;

import com.ibm.comunes.log.Logger;
import java.io.ByteArrayOutputStream;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class HandlerGeneracionReportes
        implements SOAPHandler<SOAPMessageContext> {

    private Logger logger;
    private String encoding;
    private String msginbound = null;
    private String msgoutbound = null;

    public HandlerGeneracionReportes(Logger logger, String encoding) {
        this.logger = logger;
        this.encoding = encoding;
    }

    public boolean handleMessage(SOAPMessageContext context) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            context.getMessage().writeTo(out);

            String strMsg = new String(out.toByteArray());
            Boolean outbound = (Boolean) context.get("javax.xml.ws.handler.message.outbound");

            if (outbound.booleanValue()) {
                this.msgoutbound = strMsg;
                context.getMessage().setProperty("javax.xml.soap.character-set-encoding", this.encoding);
            } else {
                this.msginbound = strMsg;
            }

            this.logger.debug("Mensaje SOAP GENERACION_REPORTES: " + strMsg);
        } catch (SOAPException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            this.logger.error("Ha ocurrido un error capturando el mensaje en el handler de GENERACION_REPORTES", e);
        }
        return true;
    }

    public boolean handleFault(SOAPMessageContext context) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            context.getMessage().writeTo(out);
            String strMsg = new String(out.toByteArray());

            this.logger.info("Mensaje FAULT SOAP GENERACION_REPORTES: " + strMsg);
        } catch (SOAPException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            this.logger.error("Ha ocurrido un error capturando el mensaje en el handler de GENERACION_REPORTES", e);
        }
        return true;
    }

    public void close(MessageContext context) {
    }

    public String getMsgInbound() {
        return this.msginbound;
    }

    public String getMsgOutbound() {
        return this.msgoutbound;
    }

    public Set<QName> getHeaders() {
        return null;
    }
}
