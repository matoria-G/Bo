package com.bo.jobs;

import com.bo.bean.DispatcherConfigBean;
import com.bo.job.core.QuartzJob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class GenericDispatcherJob extends QuartzJob {
	
public void executeJob(JobExecutionContext context)throws JobExecutionException {
		
		DispatcherConfigBean dispatcherConfigBean = null;		
		String systemCode = "";
		
		try {						
			
			dispatcherConfigBean = (DispatcherConfigBean) context.getJobDetail().getJobDataMap().get("JOB_CONFIG");										
			
			systemCode = dispatcherConfigBean.getSystemCode();
			
			
			if(systemCode.equalsIgnoreCase("EMAIL")) {
				//MailDispatcher dispatcher = new MailDispatcher();
				//dispatcher.dispatchMails(dispatcherConfigBean);
			}
			else{/*
			MessageDispatcher dispatcher = new MessageDispatcher();
			dispatcher.dispatchMessages(dispatcherConfigBean);
			*/}
			
			//threadGroup = new ThreadGroup("test");
			
			/*for(int li=0;li<maxParallelInstances;li++) {
				
				jobThreads[li] = new Thread(threadGroup,new Event(eventsConfigBean));
				jobThreads[li].start();
				
			}
			
			for(int li=0;li<jobThreads.length;li++) {
				jobThreads[li].join();
			}*/			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
