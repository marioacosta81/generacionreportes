package com.davivienda.generarReporte.reporte.config.wsServicios.impl;

import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.reporte.config.wsServicios.DataHeaderComunESB;
import com.davivienda.generarReporte.reporte.config.wsServicios.HandlerGeneracionReportes;
import com.davivienda.generarReporte.reporte.config.wsServicios.IClienteServicios;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.servicios.saldosCtaCteESB.ConsultaSaldosCuentaCorrienteDataHeaderType;
import com.davivienda.generarReporte.servicios.saldosCtaCteESB.ConsultaSaldosCuentaCorrienteDataType;
import com.davivienda.generarReporte.servicios.saldosCtaCteESB.ConsultaSaldosCuentaCorrientePortType;
import com.davivienda.generarReporte.servicios.saldosCtaCteESB.FabricaCredito05HTTPService;
import com.davivienda.generarReporte.servicios.saldosCtaCteESB.RequestConsultaSaldosCuentaCorriente;
import com.davivienda.generarReporte.servicios.saldosCtaCteESB.ResponseType;
import com.ibm.cache.bo.particular.DataEndPoint;
import com.ibm.cache.bo.particular.EndPoint;
import com.ibm.cache.bo.particular.ParametrosSoapServicio;
import com.ibm.comunes.log.Logger;
import java.math.BigDecimal;
import java.util.List;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

public class ClienteConsultarSaldosCtaCteImplESB extends ClienteServiciosAbstract implements IClienteServicios<ResponseType> {

    private final DataHeaderComunESB headerComunESB = this.obtenerHeaderDelServicio("clienteSOAPSaldosCtaCteESB");
    private final ParametrosSoapServicio paramSoapService = this.obtenerServicioDelConfig("clienteSOAPSaldosCtaCteESB");
    private RequestConsultaSaldosCuentaCorriente request;
    private final String nombre;
    private static final String CARACTER_ACEPTACION_OK = "B";
    private int  valTerminalAsig = 0;
    
    public ClienteConsultarSaldosCtaCteImplESB(Logger logger, String nom) throws ErrorExternServiceException {
        super(logger);
        this.nombre = nom;
    }

    public String getNombre() throws ErrorExternServiceException {
        return this.nombre;
    }

    public void nuevo(short idCanal) throws ErrorExternServiceException {
        this.setRequest((RequestConsultaSaldosCuentaCorriente) null);
        this.verificarCanal(this.paramSoapService, idCanal);
        if (this.service == null) {
            this.service = new FabricaCredito05HTTPService();
        }

    }

    public void asignarInformacion(MsjSolOpGeneracionReporte infoRequestMsg, BigDecimal valor) throws ErrorExternServiceException {
        this.request = new RequestConsultaSaldosCuentaCorriente();
        ConsultaSaldosCuentaCorrienteDataType dataRequest = new ConsultaSaldosCuentaCorrienteDataType();
        this.request.setData(dataRequest);
        ConsultaSaldosCuentaCorrienteDataHeaderType headerRequest = new ConsultaSaldosCuentaCorrienteDataHeaderType();
        this.request.setDataHeader(headerRequest);

        try {
            this.request.getDataHeader().setCanal(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
            this.request.getDataHeader().setNombreOperacion(this.headerComunESB.getNombreOperacion());
            this.request.getDataHeader().setJornada(Short.valueOf(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getValJornada()));
            this.request.getDataHeader().setModoDeOperacion(this.headerComunESB.getModoDeOperacion());
            this.request.getDataHeader().setPerfil(Short.valueOf(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getValPerfil()));
            this.request.getDataHeader().setTotal(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getIdTerminal());
            this.request.getDataHeader().setUsuario(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getCodUsuario());

            valTerminalAsig = this.request.getDataHeader().getTotal();
            
            for (int index = 0; index < this.paramSoapService.getEndPointsPorCanal().size(); ++index) {
                DataEndPoint dataEndPoint = ((EndPoint) this.paramSoapService.getEndPointsPorCanal().get(index)).getEndPoint();
                String canal = dataEndPoint.getCanal();
                Short canalOrigen = infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal();
                if (canalOrigen == Short.parseShort(canal)) {
                    this.request.getDataHeader().setVersionServicio(dataEndPoint.getVersion());
                    break;
                }
            }

            this.request.getData().setCuenta(Long.parseLong(infoRequestMsg.getProducto().getNumeroProducto().trim()));
            this.request.getData().setOrigen("0");
            this.request.getData().setTalon(0);
        } catch (Exception var9) {
            this.logger.error("Error al convertir una cadena a Numerico.", var9);
            throw new ErrorExternServiceException("45", "Error al convertir una cadena a Numerico.", var9);
        }
    }

    public Object invocar() throws ErrorExternServiceException {
        this.logger.info("inicio invocar: ConsultaSaldosCuentaCorrienteESB con terminal = " +valTerminalAsig );
        ConsultaSaldosCuentaCorrientePortType proxy = ((FabricaCredito05HTTPService) this.service).getFabricaCredito05HTTPPort();
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
            response = proxy.consultaSaldosCuentaCorriente(this.request);
            if (response != null && response.getDataHeader() != null) {
                if (response.getDataHeader().getCaracterAceptacion().equalsIgnoreCase("B")) {
                    errorMsj = "OK";
                } else {
                    errorMsj = "ConsultaSaldosCuentaCorrienteESB: " + response.getDataHeader().getMsgRespuesta();
                }
            } else {
                errorMsj = "ConsultaSaldosCuentaCorrienteESB: Response es null";
            }

            fin = System.currentTimeMillis();
            var19 = false;
        } catch (Exception var20) {
            fin = System.currentTimeMillis();
            this.logger.error(var20.getMessage(), var20);
            String mensaje = "Error al consumir el servicio ConsultaSaldosCuentaCorrienteESB";
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
                this.logger.debug("Tiempo de consumo de servicio ConsultaSaldosCuentaCorrienteESB : " + total + " MS");
            }
        }

        long total = fin - ini;
        this.logger.debug("Tiempo de consumo de servicio ConsultaSaldosCuentaCorrienteESB : " + total + " MS");
        this.logger.info("fin invocar: ConsultaSaldosCuentaCorrienteESB");
        return errorMsj.equals("OK") ? response : errorMsj;
    }

    public RequestConsultaSaldosCuentaCorriente getRequest() {
        return this.request;
    }

    public void setRequest(RequestConsultaSaldosCuentaCorriente request) {
        this.request = request;
    }
}
