package com.davivienda.generarReporte.web.listener;

import com.ibm.cache.bo.servicio.ConfiguracionServicio;
import com.ibm.cache.scn.config.Cache;
import com.ibm.cache.scn.config.HelperCache;
import com.ibm.comunes.log.Logger;
import com.ibm.comunes.utilitarios.SCNComunesUtil;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServiceServletContextListener
        implements ServletContextListener {

    private String nombreServicio;
    private static Logger logger;

    public void contextInitialized(ServletContextEvent sce) {
        try {
            System.setProperty("SCN.NOM.SER.GENERAR.REPORTE", sce.getServletContext().getInitParameter("SCN.NOM.SER"));            
            this.nombreServicio = System.getProperty("SCN.NOM.SER.GENERAR.REPORTE");
            Cache.IniciarCache(System.getProperty("SCN.PATH.CONFIG") + this.nombreServicio + System.getProperty("file.separator"), this.nombreServicio);
            ConfiguracionServicio configuracionServicio = HelperCache.getConfiguracionServicio(this.nombreServicio);
            logger = new Logger(getClass().getName());
            logger.init(configuracionServicio.getParticular().getConfigLog(), SCNComunesUtil.getContextoJmx(configuracionServicio));
            logger.startJmx();
        } catch (Exception ex) {
            if (logger != null) {
                logger.error("Error construyendo contexto", ex);
            } else {
                ex.printStackTrace(System.out);
            }
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        try {
            ConfiguracionServicio configuracionServicio = HelperCache.getConfiguracionServicio(this.nombreServicio);
            logger = new Logger(getClass().getName());
            logger.init(configuracionServicio.getParticular().getConfigLog(), SCNComunesUtil.getContextoJmx(configuracionServicio));
            Cache.EliminarCache(this.nombreServicio);
            logger.stoptJmx();
        } catch (Exception e) {
            if (logger != null) {
                logger.error("Error deteniendo la cache", e);
            } else {
                e.printStackTrace(System.out);
            }
        }
    }
}
