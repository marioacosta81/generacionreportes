package com.davivienda.generarReporte.reporte.config.wsServicios;

import com.davivienda.generarReporte.reporte.config.wsServicios.HandlerDhcp;
import com.ibm.comunes.log.Logger;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class HandlerDhcp
        implements SOAPHandler<SOAPMessageContext> {

    private final Logger logger;
    private final String encoding;
    private String msginbound = null;
    private String msgoutbound = null;
    private String dhcp = null;

    public HandlerDhcp(Logger logger, String encodin, String dhcp) {
        this.logger = logger;
        this.encoding = encodin;
        this.dhcp = dhcp;
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

                Map<String, List<String>> requestHeaders = (Map<String, List<String>>) context.get("javax.xml.ws.http.request.headers");
                if (requestHeaders == null) {
                    requestHeaders = new HashMap<String, List<String>>();
                    context.put("javax.xml.ws.http.request.headers", requestHeaders);
                }
                List<String> headerValue = new ArrayList<String>();

                headerValue.add(this.dhcp);
                requestHeaders.put("DPRCH", headerValue);
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
