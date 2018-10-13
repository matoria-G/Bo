/*
 * Created on Jan 9, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.bo.job.core;

import java.util.Date;
import java.util.HashMap;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.bo.bean.DispatcherConfigBean;
import com.bo.bean.EventsConfigBean;
import com.bo.bean.JobConfigBean;
import com.bo.bean.RecordProcessorConfigBean;
import com.bo.database.utils.DBContext;
import com.bo.managers.JobCfgManager;
import com.bo.thread.MiddlewareContextImpl;

/**
 * 
 * @author admin
 */
public class QuartzUtil {

	private static QuartzUtil quartzScheduler = null;
	private Scheduler scheduler = null;
	private HashMap cronMap = new HashMap();
	private HashMap updMap = new HashMap();

	/** Creates a new instance of QuartzScheduler */
	private QuartzUtil() {

	}

	public void setLastUpdate(String jobName, String lastUpdate) throws Exception {

		updMap.put(jobName, lastUpdate);

	}

	public String getLastUpdate(String jobName) {
		return (String) updMap.get(jobName);
	}

	public static QuartzUtil getQuartzUtil() {

		if (quartzScheduler == null)
			quartzScheduler = new QuartzUtil();

		return quartzScheduler;

	}

	public void destroyScheduler() {
		try {
			
			for (String jobGroup : scheduler.getJobGroupNames()){
				for (String jobName : scheduler.getJobNames(jobGroup)){
					System.out.println("Job Group : "+jobGroup+" Job Name : "+jobName);
					unscheduleJob(jobName, jobGroup);
				}
			}
			
			scheduler.shutdown();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initializeScheduler() {

		try {

			System.out.println("Initialising scheduler");
			SchedulerFactory sf = new StdSchedulerFactory();
			scheduler = sf.getScheduler();
			scheduler.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public JobDetail getJobDetail(String jobName, String jobGroup) {

		JobDetail jobDetail = null;

		try {
			jobDetail = scheduler.getJobDetail(jobName, jobGroup);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jobDetail;

	}

	public void scheduleJob(HashMap jobMap) {

		JobDetail jobDetail = null;
		JobDataMap jobDataMap = null;
		String jobCode = "", jobGroup = "", cronExp = "", jobCategory = "", systemCode = "", jobClass = "";
		DBContext databaseContext = null;
		MiddlewareContextImpl mwContext = null;
		EventsConfigBean eventsConfigBean = null;
		DispatcherConfigBean dispatcherConfigBean = null;
		JobConfigBean jobConfigBean = null;
		RecordProcessorConfigBean recordProcessorConfigBean = null;
		int entityNum = 0,logReqd=0;

		try {

			databaseContext = new DBContext();
			mwContext = new MiddlewareContextImpl();
			mwContext.setDatabaseContext(databaseContext);
			mwContext.init();

			jobCode = (String) jobMap.get("JOB_CODE");
			jobGroup = (String) jobMap.get("JOB_GROUP");
			jobCategory = (String) jobMap.get("JOB_CATEGORY");
			systemCode = (String) jobMap.get("SYSTEM_CODE");
			cronExp = (String) jobMap.get("CRON_EXP");
			entityNum = (Integer) jobMap.get("ENTITY_NUM");
			logReqd = Integer.parseInt((String)jobMap.get("LOG_REQD"));
			

			CronTrigger trigger = new CronTrigger("cTrigger", "cTriggerGroup", cronExp);
			trigger.setName(jobCode + "-trigger");
			trigger.setStartTime(new Date());

			if (jobCategory.equalsIgnoreCase("1")||jobCategory.equalsIgnoreCase("7")) {
				recordProcessorConfigBean = JobCfgManager.getInstance().getRecordProcessorJobConfig(entityNum, jobCode);
				recordProcessorConfigBean.setLogReqd(logReqd);
				jobDataMap = new JobDataMap();
				jobDataMap.put("JOB_CONFIG", recordProcessorConfigBean);
				jobClass = "com.intellect.iqh.jobs.GenericRecordProcessorJob";
			} else if (jobCategory.equalsIgnoreCase("2")) {
				dispatcherConfigBean = JobCfgManager.getInstance().getDispatcherJobConfig(entityNum, jobCode);
				dispatcherConfigBean.setLogReqd(logReqd);
				jobDataMap = new JobDataMap();
				jobDataMap.put("JOB_CONFIG", dispatcherConfigBean);
				jobClass = "com.intellect.iqh.jobs.GenericDispatcherJob";
			} else if (jobCategory.equalsIgnoreCase("3")||jobCategory.equalsIgnoreCase("8")) {
				eventsConfigBean = JobCfgManager.getInstance().getEventsJobConfig(entityNum, jobCode);
				eventsConfigBean.setLogReqd(logReqd);
				jobDataMap = new JobDataMap();
				jobDataMap.put("JOB_CONFIG", eventsConfigBean);
				jobClass = "com.bo.jobs.GenericEventsJob";
			}			
			else if (jobCategory.equalsIgnoreCase("5")) {
				jobConfigBean = JobCfgManager.getInstance().getOtherJobConfig(entityNum, jobCode);
				jobConfigBean.setLogReqd(logReqd);
				jobDataMap = new JobDataMap();
				jobDataMap.put("JOB_CONFIG", jobConfigBean);
				jobClass = "com.intellect.iqh.jobs." + jobConfigBean.getClassName();
			}

			jobDetail = new JobDetail(jobCode, jobGroup, Class.forName(jobClass));
			jobDetail.setJobDataMap(jobDataMap);
			
			scheduler.scheduleJob(jobDetail, trigger);
			cronMap.put(jobCode, cronExp);
			System.out.println("Scheduled Job : "+jobCode);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			databaseContext.close();
		}

	}

	public void unscheduleJob(String jobName, String jobGroup) {

		CronTrigger trigger = null;

		try {

			scheduler.unscheduleJob(jobName + "-trigger", jobGroup);
			scheduler.deleteJob(jobName, jobGroup);
			cronMap.remove(jobName);
			System.out.println("Un Scheduled Job : "+jobName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void disableJob(String jobName, String jobGroup) {

		try {
			scheduler.deleteJob(jobName, jobGroup);
			cronMap.remove(jobName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enableJob(String jobName, String jobGroup) {

		JobDetail jobDetail = null;

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getCronExpression(String jobName, String jobGroup) throws Exception {

		String cronExp = null;

		try {

			cronExp = (String) cronMap.get(jobName);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cronExp;

	}

	public void scheduleJobManager() {

		JobDetail jobDetail = null;

		try {

			CronTrigger trigger = new CronTrigger("cTrigger", "cTriggerGroup", "0/5 * * ? * SUN-SAT");
			trigger.setName("JobManager-trigger");
			trigger.setStartTime(new Date());

			jobDetail = new JobDetail("JobManager", "Manager", Class.forName("com.bo.jobs.JobManager"));
			scheduler.scheduleJob(jobDetail, trigger);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void unscheduleJobManager() {

		CronTrigger trigger = null;

		try {

			scheduler.unscheduleJob("JobManager-trigger", "Manager");
			scheduler.deleteJob("JobManager", "Manager");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
