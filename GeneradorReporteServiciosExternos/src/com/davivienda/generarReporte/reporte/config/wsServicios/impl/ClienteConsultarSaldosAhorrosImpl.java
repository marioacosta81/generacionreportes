package com.davivienda.generarReporte.reporte.config.wsServicios.impl;

import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.reporte.config.wsServicios.DataHeaderComunESB;
import com.davivienda.generarReporte.reporte.config.wsServicios.HandlerGeneracionReportes;
import com.davivienda.generarReporte.reporte.config.wsServicios.IClienteServicios;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.servicios.saldosAhorros.ConsultaSaldosAhorrosMsgSetPortType;
import com.davivienda.generarReporte.servicios.saldosAhorros.DataHeaderRequestType;
import com.davivienda.generarReporte.servicios.saldosAhorros.DataRequestType;
import com.davivienda.generarReporte.servicios.saldosAhorros.Operaciones07HTTPService;
import com.davivienda.generarReporte.servicios.saldosAhorros.RequestType;
import com.davivienda.generarReporte.servicios.saldosAhorros.ResponseType;
import com.ibm.cache.bo.particular.EndPoint;
import com.ibm.cache.bo.particular.ParametrosSoapServicio;
import com.ibm.comunes.log.Logger;
import java.math.BigDecimal;
import java.util.List;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

public class ClienteConsultarSaldosAhorrosImpl extends ClienteServiciosAbstract implements IClienteServicios<ResponseType> {

    private final DataHeaderComunESB headerComunESB = this.obtenerHeaderDelServicio("clienteSOAPSaldosAhorros");
    private final ParametrosSoapServicio paramSoapService = this.obtenerServicioDelConfig("clienteSOAPSaldosAhorros");
    private RequestType request;
    private final String nombre;
    private static final String CARACTER_ACEPTACION_OK = "B";
    private int  valTerminalAsig = 0;
    public ClienteConsultarSaldosAhorrosImpl(Logger logger, String nom) throws ErrorExternServiceException {
        super(logger);
        this.nombre = nom;
    }

    public String getNombre() throws ErrorExternServiceException {
        return this.nombre;
    }

    public void nuevo(short idCanal) throws ErrorExternServiceException {
        this.setRequest((RequestType) null);
        this.verificarCanal(this.paramSoapService, idCanal);
        if (this.service == null) {
            this.service = new Operaciones07HTTPService();
        }

    }

    public void asignarInformacion(MsjSolOpGeneracionReporte infoRequestMsg, BigDecimal valor) throws ErrorExternServiceException {
        DataRequestType data = new DataRequestType();
        DataHeaderRequestType header = new DataHeaderRequestType();

        try {
            header.setCanal(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
            header.setJornada(Short.valueOf(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getValJornada()));
            header.setModoDeOperacion(this.headerComunESB.getModoDeOperacion());
            header.setNombreOperacion(this.headerComunESB.getNombreOperacion());
            header.setPerfil(Short.valueOf(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getValPerfil()));
            header.setTotal(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getIdTerminal());
            header.setUsuario(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getCodUsuario());
            header.setVersionServicio(this.headerComunESB.getVersionServicio());
            data.setBanda("");
            data.setClave("0");
            data.setTipoDeCuenta(Short.parseShort(infoRequestMsg.getProducto().getCodigoTipoProducto()));
            data.setNroCuentaAhorros(Long.parseLong(infoRequestMsg.getProducto().getNumeroProducto()));
            valTerminalAsig = header.getTotal();
        } catch (NumberFormatException var6) {
            this.logger.error("Error al convertir una cadena a Numerico.", var6);
            throw new ErrorExternServiceException("45", "Error al convertir una cadena a Numerico.", var6);
        }

        this.request = new RequestType();
        this.request.setData(data);
        this.request.setDataHeader(header);
    }

    public Object invocar() throws ErrorExternServiceException {
        this.logger.info("inicio invocar: ConsultaSaldosAhorros con terminal = " + valTerminalAsig);
        ConsultaSaldosAhorrosMsgSetPortType proxy = ((Operaciones07HTTPService) this.service).getOperaciones07HTTPPort();
        BindingProvider mBinding = (BindingProvider) proxy;
        this.logger.debug("BindingProviderProperties.REQUEST_TIMEOUT = " + this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("javax.xml.ws.service.endpoint.address", this.paramSoapService.getEndpoint());
        mBinding.getRequestContext().put("com.sun.xml.ws.request.timeout", this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("com.sun.xml.ws.connect.timeout", this.paramSoapService.getTimeOut());
        Handler handler = new HandlerGeneracionReportes(this.logger, "UTF-8");
        List<Handler> handlerChain = mBinding.getBinding().getHandlerChain();
        handlerChain.add(handler);
        mBinding.getBinding().setHandlerChain(handlerChain);
        ResponseType response = null;
        long ini = 0L;
        long fin = 0L;
        String errorMsj = null;
        boolean var19 = false;

        try {
            var19 = true;

            for (int index = 0; index < this.paramSoapService.getEndPointsPorCanal().size(); ++index) {
                EndPoint endpoint = (EndPoint) this.paramSoapService.getEndPointsPorCanal().get(index);
                short canal = Short.parseShort(endpoint.getEndPoint().getCanal());
                if (this.request.getDataHeader().getCanal() == canal) {
                    this.request.getDataHeader().setVersionServicio(endpoint.getEndPoint().getVersion());
                }
            }

            this.logger.info("Version=" + this.request.getDataHeader().getVersionServicio());
            this.logger.info("Se consumirá servicio al endpoint: " + this.paramSoapService.getEndpoint());
            ini = System.currentTimeMillis();
            response = proxy.consultaSaldosAhorros(this.request);
            if (response != null) {
                if (response.getDataHeader() != null) {
                    if (response.getDataHeader().getCaracterAceptacion().equalsIgnoreCase("B")) {
                        if (response.getData() != null) {
                            errorMsj = "OK";
                        } else {
                            errorMsj = "ConsultaSaldosAhorros: Data de consulta de ahorros es null";
                        }
                    } else {
                        errorMsj = "ConsultaSaldosAhorros: " + response.getDataHeader().getMsgRespuesta();
                    }
                } else {
                    errorMsj = "ConsultaSaldosAhorros: Dataheader de consulta de ahorros es null";
                }
            } else {
                errorMsj = "ConsultaSaldosAhorros: Error al consumir el servicio del BUS";
            }

            fin = System.currentTimeMillis();
            var19 = false;
        } catch (Exception var20) {
            fin = System.currentTimeMillis();
            this.logger.error(var20.getMessage(), var20);
            String mensaje = "Error al consumir el servicio ConsultaSaldosAhorros";
            if (var20.getMessage() != null) {
                mensaje = mensaje + ", Mensaje: " + var20.getMessage();
            }

            if (var20.getCause() != null) {
                mensaje = mensaje + ", Causa: " + var20.getCause().toString();
            }

            throw new ErrorExternServiceException("42", mensaje, var20);
        } finally {
            if (var19) {
                long total = fin - ini;
                this.logger.debug("Tiempo de consumo de servicio ConsultaSaldosAhorros : " + total + " MS");
            }
        }

        long total = fin - ini;
        this.logger.debug("Tiempo de consumo de servicio ConsultaSaldosAhorros : " + total + " MS");
        this.logger.info("fin invocar: ConsultaSaldosAhorros");
        return errorMsj.equals("OK") ? response : errorMsj;
    }

    public RequestType getRequest() {
        return this.request;
    }

    public void setRequest(RequestType request) {
        this.request = request;
    }
}
