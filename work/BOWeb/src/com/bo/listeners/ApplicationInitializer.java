package com.bo.listeners;

import javax.servlet.ServletContextEvent;

import com.bo.job.core.ContextReference;
import com.bo.job.core.QuartzUtil;
/**
 * Application Lifecycle Listener implementation class ServletContextListener
 *
 */
public class ApplicationInitializer implements javax.servlet.ServletContextListener {

    /**
     * Default constructor. 
     */
    public ApplicationInitializer() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
    	
    	QuartzUtil.getQuartzUtil().initializeScheduler();
    	QuartzUtil.getQuartzUtil().scheduleJobManager();
    	ContextReference.setContext(event.getServletContext());    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    	    	
    	QuartzUtil.getQuartzUtil().unscheduleJobManager();
    	QuartzUtil.getQuartzUtil().destroyScheduler();
    	
    }
	
}
