package com.bo.jobs;

import com.bo.bean.EventsConfigBean;


import com.bo.job.core.PooledEventsProcessor;
import com.bo.job.core.QuartzJob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class GenericEventsJob extends QuartzJob{
		
	public void executeJob(JobExecutionContext context)throws JobExecutionException {
		
		EventsConfigBean eventsConfigBean = null;		
		
		try {						
			
			eventsConfigBean = (EventsConfigBean) context.getJobDetail().getJobDataMap().get("JOB_CONFIG");
			
			//if(eventsConfigBean.getChannelCode()!=null&&eventsConfigBean.getChannelCode().equalsIgnoreCase("RPT")){
			if(eventsConfigBean.getSystemCode()!=null&&eventsConfigBean.getSystemCode().equalsIgnoreCase("RPT")){
				//ReportEventScheduler reportEventScheduler = new ReportEventScheduler();
				//reportEventScheduler.scheduleRptEvents(eventsConfigBean);
				
			}else if(eventsConfigBean.getJobCategory().equalsIgnoreCase("8")){
				PooledEventsProcessor eventsPoolProcessor = new PooledEventsProcessor();
				eventsPoolProcessor.processEvents(eventsConfigBean);
			}
			else{
				
				/*EventsProcessor eventsProcessor = new EventsProcessor();
				eventsProcessor.processEvents(eventsConfigBean);*/
				
			}
						
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
