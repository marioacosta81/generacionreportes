package com.davivienda.generarReporte.reporte.config.wsServicios.impl;

import co.com.davivienda.consultaRentabilidades.ARRFondosRespType;
import co.com.davivienda.consultaRentabilidades.ARRParticipacionesType;
import co.com.davivienda.consultaRentabilidades.ARRRentabilidadesRespType;
import co.com.davivienda.consultaRentabilidades.ARRRentabilidadesType;
import co.com.davivienda.consultaRentabilidades.ConsultaRentabilidadesHTTPService;
import co.com.davivienda.consultaRentabilidades.ConsultaRentabilidadesPortType;
import co.com.davivienda.consultaRentabilidades.DataHeaderReqType;
import co.com.davivienda.consultaRentabilidades.DataReqType;
import co.com.davivienda.consultaRentabilidades.RequestType;
import co.com.davivienda.consultaRentabilidades.ResponseType;
import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.reporte.config.wsServicios.DataHeaderComunESB;
import com.davivienda.generarReporte.reporte.config.wsServicios.HandlerGeneracionReportes;
import com.davivienda.generarReporte.reporte.config.wsServicios.IClienteServicios;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Columna;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.MsjSolOpGeneracionReporte;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.ParametroTabla;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Parametros;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Registro;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Registros;
import com.davivienda.generarReporte.service.srvscngeneracionreporte.v1.Valor;
import com.ibm.cache.bo.particular.DataEndPoint;
import com.ibm.cache.bo.particular.EndPoint;
import com.ibm.cache.bo.particular.ParametrosSoapServicio;
import com.ibm.comunes.log.Logger;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;

public class ClienteConsultaRentabilidadesImpl
        extends ClienteServiciosAbstract
        implements IClienteServicios<ResponseType> {

    public static final String NOMBRE_CLIENTWS_CONSULTA_RENTABILIDAD = "clienteSOAPConsultaRentabilidad";
    public static final String NOMBRE_ESB_SERV_CONSULTA_RENTABILIDAD = "ConsultaRentabilidades";
    private final DataHeaderComunESB headerComunESB;
    private final ParametrosSoapServicio paramSoapService;
    private RequestType request;
    private final String nombre;
    private static final String CARACTER_ACEPTACION_OK = "B";
    private MsjSolOpGeneracionReporte solicitudReporte;
    private int  valTerminalAsig = 0;

    public ClienteConsultaRentabilidadesImpl(Logger logger, String nom) throws ErrorExternServiceException {
        super(logger);
        this.headerComunESB = obtenerHeaderDelServicio("clienteSOAPConsultaRentabilidad");
        this.paramSoapService = obtenerServicioDelConfig("clienteSOAPConsultaRentabilidad");
        this.nombre = nom;
    }

    public String getNombre() throws ErrorExternServiceException {
        return this.nombre;
    }

    public void nuevo(short idCanal) throws ErrorExternServiceException {
        setRequest(null);
        verificarCanal(this.paramSoapService, idCanal);
        if (this.service == null) {
            this.service = (Service) new ConsultaRentabilidadesHTTPService();
        }
    }

    public void asignarInformacion(MsjSolOpGeneracionReporte infoRequestMsg, BigDecimal valor) throws ErrorExternServiceException {
        this.request = new RequestType();
        this.solicitudReporte = infoRequestMsg;
        DataHeaderReqType header = new DataHeaderReqType();
        DataReqType dataReq = new DataReqType();
        try {
            header.setCanal(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
            header.setJornada(Short.valueOf(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getValJornada()).shortValue());
            header.setModoDeOperacion(this.headerComunESB.getModoDeOperacion());
            header.setNombreOperacion(this.headerComunESB.getNombreOperacion());
            header.setPerfil(Short.valueOf(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getValPerfil()).shortValue());
            header.setTotal(this.headerComunESB.getTotal());
            header.setUsuario(infoRequestMsg.getContextoSolicitud().getConsumidor().getTerminal().getCodUsuario());
            header.setIdTransaccion(infoRequestMsg.getContextoSolicitud().getOperacionCanal().getIdTransaccion());

            valTerminalAsig = header.getTotal();
            for (int index = 0; index < this.paramSoapService.getEndPointsPorCanal().size(); index++) {
                DataEndPoint dataEndPoint = ((EndPoint) this.paramSoapService.getEndPointsPorCanal().get(index)).getEndPoint();
                String canal = dataEndPoint.getCanal();
                Short canalOrigen = Short.valueOf(infoRequestMsg.getContextoSolicitud().getConsumidor().getCanal().getIdCanal());
                if (canalOrigen.shortValue() == Short.parseShort(canal)) {
                    header.setVersionServicio(dataEndPoint.getVersion());

                    break;
                }
            }
            String fecha_corte_consulta = null;
            List<Valor> listaParametros = infoRequestMsg.getListaParametros().getValParametro();

            for (Valor v : listaParametros) {
                if ("fecha_corte".equals(v.getId()) && v.getValor().size() > 0) {
                    fecha_corte_consulta = v.getValor().get(0);
                }
            }

            if (fecha_corte_consulta == null || "".equals(fecha_corte_consulta)) {
                this.logger.info("Error formato fecha corte ");
                throw new ErrorExternServiceException("Error fecha corte nula o vacia", "5005");
            }

            dataReq.setValCodigoOficina(Integer.valueOf(0));
            dataReq.setValNitNegocio(Long.valueOf(infoRequestMsg.getProducto().getCodigoTipoProducto()));
            dataReq.setValTalon(Integer.valueOf(0));

            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date dateInicio = format.parse(fecha_corte_consulta);
                GregorianCalendar gcal = (GregorianCalendar) GregorianCalendar.getInstance();
                gcal.setTime(dateInicio);
                XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
                dataReq.setFecConsulta(xgcal);
            } catch (Exception ex) {
                this.logger.error("Error formato fecha corte ", ex);
                throw new ErrorExternServiceException("Error formato fecha corte ", "5005");
            }

            this.request.setData(dataReq);
            this.request.setDataHeader(header);
        } catch (NumberFormatException ex) {
            this.logger.error("Error al convertir una cadena a Numerico.", ex);
            throw new ErrorExternServiceException("45", "Error al convertir una cadena a Numerico.", ex);
        }
    }

    public Object invocar() throws ErrorExternServiceException {
        this.logger.info("Inicio invocar: ConsultaRentabilidades con terminal = " + valTerminalAsig);
        ConsultaRentabilidadesPortType proxy = ((ConsultaRentabilidadesHTTPService) this.service).getConsultaRentabilidadesSOAPHTTPPort();

        BindingProvider mBinding = (BindingProvider) proxy;
        this.logger.debug("BindingProviderProperties.REQUEST_TIMEOUT = " + this.paramSoapService.getTimeOut());
        mBinding.getRequestContext().put("javax.xml.ws.service.endpoint.address", this.paramSoapService.getEndpoint());
        mBinding.getRequestContext().put("com.sun.xml.ws.request.timeout", Integer.valueOf(this.paramSoapService.getTimeOut()));
        mBinding.getRequestContext().put("com.sun.xml.ws.connect.timeout", Integer.valueOf(this.paramSoapService.getTimeOut()));
        HandlerGeneracionReportes handlerGeneracionReportes = new HandlerGeneracionReportes(this.logger, "UTF-8");

        List<Handler> handlerChain = mBinding.getBinding().getHandlerChain();
        handlerChain.add(handlerGeneracionReportes);
        mBinding.getBinding().setHandlerChain(handlerChain);
        ResponseType response = null;
        String errorMsj = null;
        long ini = 0L, fin = 0L;

        try {
            this.logger.debug("Se consumirservicio al endpoint: " + this.paramSoapService.getEndpoint());
            ini = System.currentTimeMillis();
            response = proxy.consultaRentabilidades(this.request);
            if (response != null) {
                if (response.getDataHeader() != null) {

                    this.logger.info("Respuesta del servicio ConsultaRentabilidades " + response.getDataHeader().getCaracterAceptacion());
                    if (response.getDataHeader().getCaracterAceptacion().equalsIgnoreCase("B") && !"N".equals(response.getData().getValExisteRenta())) {
                        if (response.getData() != null) {
                            errorMsj = "OK";

                            Parametros parametros = this.solicitudReporte.getListaParametros();
                            List<ParametroTabla> listaParametrosTabla = parametros.getParametroTabla();

                            ParametroTabla parametroTabla = new ParametroTabla();
                            parametroTabla.setValIdTabla("DATOS_FONDO_INVERSION");
                            Columna columnas = new Columna();
                            parametroTabla.setColumnas(columnas);
                            List<String> listaColumnas = columnas.getValNombreColumna();

                            listaColumnas.add("Tipo de departicipación");
                            listaColumnas.add("Valor del fondo");
                            listaColumnas.add("Valor de la unidad");
                            //listaColumnas.add("Diaria");
                            listaColumnas.add("Mensual");
                            listaColumnas.add("Semestral");
                            listaColumnas.add("Año corrido");
                            listaColumnas.add("Último año");

                            Registros registros = new Registros();
                            parametroTabla.setRegistros(registros);
                            List<Registro> listaRegistros = registros.getRegistro();

                            List<ARRFondosRespType> listaESBFondos = response.getData().getFondos().getFondo();

                            Registro registro = new Registro();
                            List<Valor> listaValueColumnas = registro.getValParametro();
                            for (ARRFondosRespType fondo : listaESBFondos) {

                                Valor valor = new Valor();
                                valor.setId("Tipo departicipación");
                                List<String> listaValores = valor.getValor();
                                listaValores.add("Consolidado");
                                listaValueColumnas.add(valor);
                                listaRegistros.add(registro);

                                valor = new Valor();
                                valor.setId("Valor del fondo");
                                listaValores = valor.getValor();
                                listaValores.add(formatNumber(fondo.getValFondo()));
                                listaValueColumnas.add(valor);

                                valor = new Valor();
                                valor.setId("Valor de la unidad");
                                listaValores = valor.getValor();
                                listaValores.add(formatNumber(fondo.getValUnidad()));
                                listaValueColumnas.add(valor);

                                List<ARRRentabilidadesType> listaRentabilidades = fondo.getRentabilidadesFondo().getRentabilidades();
                                for (ARRRentabilidadesType rentabilidad : listaRentabilidades) {
                                    String nombreColumna = rentabilidad.getValEtiqueta();

                                    valor = new Valor();
                                    /*if ("Diaria".equalsIgnoreCase(nombreColumna)) {
                                        valor.setId("Diaria");
                                    } else if ("Mensual".equalsIgnoreCase(nombreColumna)) {
                                        valor.setId("Mensual");
                                    } else if ("Semestral".equalsIgnoreCase(nombreColumna)) {
                                        valor.setId("Semestral");
                                    } else if ("Anual".equalsIgnoreCase(nombreColumna)) {
                                        valor.setId("Año corrido");
                                    } else if ("Ultimo_Ano".equalsIgnoreCase(nombreColumna)) {
                                        valor.setId("Último año");
                                    }

                                    listaValores = valor.getValor();
                                    listaValores.add(formatNumberPorcentaje(rentabilidad.getValPresentacionRent(), false));
                                    listaValueColumnas.add(valor);*/
                                    
                                    if (!"Diaria".equalsIgnoreCase(nombreColumna)) {
                                        if ("Mensual".equalsIgnoreCase(nombreColumna)) {
                                          valor.setId("Mensual");
                                        } else if ("Semestral".equalsIgnoreCase(nombreColumna)) {
                                          valor.setId("Semestral");
                                        } else if ("Anual".equalsIgnoreCase(nombreColumna)) {
                                          valor.setId("Año Acorrido");
                                        } else if ("Ultimo_Ano".equalsIgnoreCase(nombreColumna)) {
                                          valor.setId("Último año");
                                        } 
                                        listaValores = valor.getValor();
                                        listaValores.add(formatNumberPorcentaje(rentabilidad.getValPresentacionRent(), false));
                                        listaValueColumnas.add(valor);
                                    } 
                                }

                                if (fondo.getParticipaciones() != null) {
                                    List<ARRParticipacionesType> listaParticipaciones = fondo.getParticipaciones().getParticipacion();
                                    registro = new Registro();
                                    listaRegistros.add(registro);
                                    listaValueColumnas = registro.getValParametro();
                                    for (ARRParticipacionesType participacion : listaParticipaciones) {

                                        valor = new Valor();
                                        valor.setId("Tipo departicipación");
                                        listaValores = valor.getValor();
                                        listaValores.add(participacion.getCodParticipacion());
                                        listaValueColumnas.add(valor);

                                        valor = new Valor();
                                        valor.setId("Valor del fondo");
                                        listaValores = valor.getValor();
                                        listaValores.add(formatNumber(participacion.getValParticipacion()));
                                        listaValueColumnas.add(valor);

                                        valor = new Valor();
                                        valor.setId("Valor de la unidad");
                                        listaValores = valor.getValor();
                                        listaValores.add(formatNumber(participacion.getValUnidadParticipacion()));
                                        listaValueColumnas.add(valor);

                                        List<ARRRentabilidadesRespType> listaParticipacionesRentabilidad = participacion.getRentaParticipaciones().getRentaParticipacion();
                                        for (ARRRentabilidadesRespType participacionRentabilidad : listaParticipacionesRentabilidad) {
                                            String nombreColumna = participacionRentabilidad.getValEtiqueta();

                                            valor = new Valor();
                                            /*if ("Diaria".equalsIgnoreCase(nombreColumna)) {
                                                valor.setId("Diaria");
                                            } else if ("Mensual".equalsIgnoreCase(nombreColumna)) {
                                                valor.setId("Mensual");
                                            } else if ("Semestral".equalsIgnoreCase(nombreColumna)) {
                                                valor.setId("Semestral");
                                            } else if ("Anual".equalsIgnoreCase(nombreColumna)) {
                                                valor.setId("Año corrido");
                                            } else if ("Ultimo_Ano".equalsIgnoreCase(nombreColumna)) {
                                                valor.setId("Último año");
                                            }

                                            listaValores = valor.getValor();
                                            listaValores.add(formatNumberPorcentaje(participacionRentabilidad.getValPresentacionRent(), false));
                                            listaValueColumnas.add(valor);*/
                                            if (!"Diaria".equalsIgnoreCase(nombreColumna)) {
                                                if ("Mensual".equalsIgnoreCase(nombreColumna)) {
                                                  valor.setId("Mensual");
                                                } else if ("Semestral".equalsIgnoreCase(nombreColumna)) {
                                                  valor.setId("Semestral");
                                                } else if ("Anual".equalsIgnoreCase(nombreColumna)) {
                                                  valor.setId("Año corrido");
                                                } else if ("Ultimo_Ano".equalsIgnoreCase(nombreColumna)) {
                                                  valor.setId("Último año");
                                                } 
                                                listaValores = valor.getValor();
                                                listaValores.add(formatNumberPorcentaje(participacionRentabilidad.getValPresentacionRent(), false));
                                                listaValueColumnas.add(valor);
                                            } 
                                        }

                                        registro = new Registro();
                                        listaRegistros.add(registro);
                                        listaValueColumnas = registro.getValParametro();
                                    }

                                    if (listaRegistros != null && registro != null) {
                                        listaRegistros.remove(registro);
                                    }
                                }
                            }

                            listaParametrosTabla.add(parametroTabla);
                        } else {

                            errorMsj = "ConsultaRentabilidades: Data de consulta de rentabilidades es null";
                        }

                    } else if (response != null && response.getData() != null && "N".equals(response.getData().getValExisteRenta())) {
                        errorMsj = "ConsultaRentabilidades: La consulta no entrego resultados ";
                    } else {
                        errorMsj = "ConsultaRentabilidades: " + response.getDataHeader().getMsgRespuesta();
                    }
                } else {

                    errorMsj = "ConsultaRentabilidades: Dataheader de consulta de rentabilidades es null";
                }
            } else {
                errorMsj = "ConsultaRentabilidades: Error al consumir el servicio del BUS";
            }
            fin = System.currentTimeMillis();
        } catch (Exception ex) {
            fin = System.currentTimeMillis();
            this.logger.error(ex.getMessage(), ex);
            String mensaje = "Error al consumir el servicio ConsultaRentabilidades";
            if (ex.getMessage() != null) {
                mensaje = mensaje + ", Mensaje: " + ex.getMessage();
            }
            if (ex.getCause() != null) {
                mensaje = mensaje + ", Causa: " + ex.getCause().toString();
            }

            throw new ErrorExternServiceException("42", mensaje, ex);
        } finally {
            long total = fin - ini;
            this.logger.debug("Tiempo de consumo de servicio ConsultaRentabilidades : " + total + " MS");
        }
        this.logger.info("fin invocar: ConsultaRentabilidades");
        if (errorMsj.equals("OK")) {
            return response;
        }
        return errorMsj;
    }

    private String formatNumber(BigDecimal oldValue) {
        String valueNew = "0.00";
        if (oldValue != null) {
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);
            valueNew = numberFormat.format(oldValue);
            valueNew = valueNew.substring(0, 1) + " " + valueNew.substring(1);
        } else {
            valueNew = "$ " + valueNew;
        }

        return valueNew;
    }

    private String formatNumberPorcentaje(String oldValue, boolean signopesos) {
        String valueNew = "0";
        if (oldValue == null || oldValue.indexOf('*') >= 0) {
            return valueNew;
        }
        if (oldValue.charAt(0) == '.') {
            oldValue = "0" + oldValue;
        }

        int i = oldValue.indexOf('.');
        int f = oldValue.indexOf('%');
        if (i >= 0 && f > 0) {
            Float fl = Float.valueOf(Float.parseFloat(oldValue.substring(0, f).trim()));

            NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(Locale.US);
            numberFormat2.setMaximumFractionDigits(2);
            numberFormat2.setMinimumFractionDigits(2);
            String format2 = numberFormat2.format(fl);
            if (format2.charAt(0) == '$') {
                format2 = format2.substring(1);
            }
            oldValue = format2 + oldValue.substring(f);
        }
        return oldValue;
    }

    public RequestType getRequest() {
        return this.request;
    }

    public void setRequest(RequestType request) {
        this.request = request;
    }
}
