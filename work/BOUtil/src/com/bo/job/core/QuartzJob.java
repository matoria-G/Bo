package com.bo.job.core;
/*
 * Created on Mar 6, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

/**
 * @author admin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class QuartzJob implements StatefulJob{
	
	public void execute(JobExecutionContext context)throws JobExecutionException {
        
		   try {
		   	 		   	   		   	   		   	  		   	   	   	 
			   executeJob(context);			   
			   
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
        
	   }
	   
	   public abstract void executeJob(JobExecutionContext context)throws JobExecutionException;
	   	

}
