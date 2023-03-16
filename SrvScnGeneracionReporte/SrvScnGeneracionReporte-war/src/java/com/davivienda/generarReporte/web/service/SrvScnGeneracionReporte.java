package com.davivienda.generarReporte.web.service;

import com.davivienda.generarReporte.constantes.ConstantesGenerarReporte;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjRespOpGeneracionReporte;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.util.GenerarReporteErrorMapper;
import com.davivienda.generarReporte.util.SrvScnGenerarReporteDataLogUtil;
import com.ibm.comunes.servicios.SCNMensajeEntrada;
import com.ibm.comunes.servicios.SCNMensajeSalida;
import com.ibm.comunes.utilitarios.ExceptionCodErrorMapper;
import com.ibm.comunes.utilitarios.SCNComunesUtil;
import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService(serviceName = "v1", portName = "portSrvScnGeneracionReporteSOAP", endpointInterface = "com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.PortSrvScnGeneracionReporteSOAP", targetNamespace = "http://www.davivienda.com/GenerarReporte/SrvScnGeneracionReporte/v1", wsdlLocation = "WEB-INF/wsdl/SrvScnGeneracionReporte/SrvScnGeneracionReporte.wsdl")
@HandlerChain(file = "SrvScnGeneracionReporte_handler.xml")
public class SrvScnGeneracionReporte {

    @Resource
    private WebServiceContext wsCtx;
    private static final String nombreServicio = System.getProperty("SCN.NOM.SER.GENERAR.REPORTE");

    private final GenerarReporteErrorMapper errorMapper = GenerarReporteErrorMapper.getInstance();

    public MsjRespOpGeneracionReporte opGeneracionReporte(MsjSolOpGeneracionReporte request) {
        
        request.getContextoSolicitud().getOperacionCanal().setIdTransaccion(this.validarIdTransaccion(request));
        return (MsjRespOpGeneracionReporte) SCNComunesUtil.procesarMensajeServicios((SCNMensajeEntrada) request, (SCNMensajeSalida) new MsjRespOpGeneracionReporte(), ConstantesGenerarReporte.ID_FRENTE, nombreServicio, Thread.currentThread().getStackTrace()[1].getMethodName(), (ExceptionCodErrorMapper) this.errorMapper, this.wsCtx, SrvScnGenerarReporteDataLogUtil.construirMapaParaMensaje(request));
    }
    
    private String validarIdTransaccion(MsjSolOpGeneracionReporte request){
        String id = request.getContextoSolicitud().getOperacionCanal().getIdTransaccion();
        if (id.length() > 18) {
            id = id.substring(0,18);
        }
        return id;
    }
}
