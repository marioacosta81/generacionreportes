package com.davivienda.generarReporte.reporte.config.wsServicios.impl;

import com.davivienda.generarReporte.exception.ErrorExternServiceException;
import com.davivienda.generarReporte.reporte.config.wsServicios.IClienteServicios;
import com.ibm.comunes.log.Logger;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class FabricaClientesServicio {

    private static HashMap<String, IClienteServicios> mapClientSrv;
    private static FabricaClientesServicio instance;

    private FabricaClientesServicio() throws ErrorExternServiceException {
        mapClientSrv = new HashMap(0);
    }

    public static FabricaClientesServicio getInstance() throws ErrorExternServiceException {
        if (instance == null) {
            instance = new FabricaClientesServicio();
        }

        return instance;
    }

    public IClienteServicios getInstanciaServicio(String nombreServicio, String nombreClase, Logger logger) throws ErrorExternServiceException {
        IClienteServicios clienteServicio = null;

        try {
            if (mapClientSrv.containsKey(nombreServicio)) {
                clienteServicio = (IClienteServicios) mapClientSrv.get(nombreServicio);
            } else {
                Class<?> c = Class.forName(nombreClase);
                Constructor<?> cons = c.getConstructor(Logger.class, String.class);
                clienteServicio = (IClienteServicios) cons.newInstance(logger, nombreServicio);
                if (clienteServicio == null) {
                    logger.debug("Error al crear el cliente del servicio.");
                    throw new ErrorExternServiceException("999", "Error al crear el cliente del servicio.");
                }

                mapClientSrv.put(nombreServicio, clienteServicio);
            }

            return clienteServicio;
        } catch (ErrorExternServiceException var7) {
            logger.error(var7.getMessage(), var7);
            throw new ErrorExternServiceException("999", "Error al crear el cliente del servicio. " + var7.getMessage());
        } catch (ClassNotFoundException var8) {
            logger.error(var8.getMessage(), var8);
            throw new ErrorExternServiceException("999", "Error al crear el cliente del servicio. " + var8.getMessage());
        } catch (IllegalAccessException var9) {
            logger.error(var9.getMessage(), var9);
            throw new ErrorExternServiceException("999", "Error al crear el cliente del servicio. " + var9.getMessage());
        } catch (IllegalArgumentException var10) {
            logger.error(var10.getMessage(), var10);
            throw new ErrorExternServiceException("999", "Error al crear el cliente del servicio. " + var10.getMessage());
        } catch (InstantiationException var11) {
            logger.error(var11.getMessage(), var11);
            throw new ErrorExternServiceException("999", "Error al crear el cliente del servicio. " + var11.getMessage());
        } catch (NoSuchMethodException var12) {
            logger.error(var12.getMessage(), var12);
            throw new ErrorExternServiceException("999", "Error al crear el cliente del servicio. " + var12.getMessage());
        } catch (SecurityException var13) {
            logger.error(var13.getMessage(), var13);
            throw new ErrorExternServiceException("999", "Error al crear el cliente del servicio. " + var13.getMessage());
        } catch (InvocationTargetException var14) {
            logger.error(var14.getMessage(), var14);
            throw new ErrorExternServiceException("999", "Error al crear el cliente del servicio. " + var14.getMessage());
        }
    }
}
