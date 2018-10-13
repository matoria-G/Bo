package com.bo.jobs;

import java.sql.ResultSet;
import java.util.HashMap;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;

import com.bo.database.utils.DBContext;
import com.bo.database.utils.DBUtil;
import com.bo.job.core.QuartzJob;
import com.bo.job.core.QuartzUtil;
import com.bo.thread.MiddlewareContextImpl;
import com.bo.utils.PropertiesUtil;

public class JobManager extends QuartzJob {

	public void executeJob(JobExecutionContext context) {

		DBContext databaseContext = null;
		DBUtil dbUtil = null;
		ResultSet lrs = null;
		String query = "", cronExp = "";
		StringBuffer queryBuff = new StringBuffer("");
		String jobCode = "", jobCronExp = "", jobEnabled = "", jobStatus = "", jobModifiedTime = "", systemCode = "", jobGroup = "";
		JobDetail currentJobDetail = null;
		HashMap jobMap = null;
		QuartzUtil quartzUtil = null;
		int entityNum = 0;
		MiddlewareContextImpl mwContext = null;
		HashMap<String, String> systemMap = new HashMap<String, String>();
		String serverCat = "",logReqd="";
		
		try {

			databaseContext = new DBContext();
			dbUtil = databaseContext.createUtilInstance();
			dbUtil.reset();

			mwContext = new MiddlewareContextImpl();
			mwContext.setDatabaseContext(databaseContext);
			mwContext.init();
			
			systemMap = PropertiesUtil.getInstance().getProperties("SERVER");
			serverCat = systemMap.get("SERVER_CAT");
					
			queryBuff.append("SELECT J.ENTITY_CODE,J.JOB_CODE,J.CRON_EXP,J.JOB_CATEGORY,J.ENABLED,J.STATUS,J.SYSTEM_CODE,J.LOG_REQD,");
			queryBuff.append("TO_CHAR(J.AUTH_ON,'DD-MON-YYYY HH24:MI:SS') LAST_MODIFIED_TIME  FROM CMNJOBMAST J WHERE J.JOB_CATEGORY<>6  AND J.SYSTEM_CODE  IN ('ERCP') ");
			if(serverCat!=null&&!serverCat.equals("")){
				queryBuff.append(" AND J.SERVER_CATEGORY=").append(serverCat);
			}
			
			dbUtil.setMode(DBUtil.PREPARED);
			dbUtil.setSql(queryBuff.toString());

			lrs = dbUtil.executeQuery();
			quartzUtil = quartzUtil.getQuartzUtil();

			while (lrs.next()) {

				jobMap = new HashMap();

				jobCode = lrs.getString("JOB_CODE");
				jobCronExp = lrs.getString("CRON_EXP");
				jobEnabled = lrs.getString("ENABLED");
				jobStatus = lrs.getString("STATUS");
				jobModifiedTime = lrs.getString("LAST_MODIFIED_TIME");
				systemCode = lrs.getString("SYSTEM_CODE");
				entityNum = lrs.getInt("ENTITY_CODE");
				logReqd = lrs.getString("LOG_REQD");
				jobGroup = systemCode + "JOBS";
				if(serverCat!=null){
					jobGroup = serverCat;
				}else {
					jobGroup="1";
				}
				
				 
				jobMap.put("JOB_CODE", jobCode);
				jobMap.put("CRON_EXP", jobCronExp);
				jobMap.put("SYSTEM_CODE", systemCode);
				jobMap.put("JOB_GROUP", jobGroup);
				jobMap.put("JOB_CATEGORY", lrs.getString("JOB_CATEGORY"));
				jobMap.put("ENTITY_NUM", entityNum);
				jobMap.put("LOG_REQD", logReqd);
				
				String str = quartzUtil.getLastUpdate(jobCode);
				if (str != null && str.equalsIgnoreCase(jobModifiedTime)) {
					// System.out.println("No change in configuration of "+jobCode);
				} else {

					// System.out.println("Change in configuration of "+jobCode);
					quartzUtil.setLastUpdate(jobCode, jobModifiedTime);

					// Enabling and Disabling of job
					if (jobEnabled.equalsIgnoreCase("1")) {
						currentJobDetail = quartzUtil.getJobDetail(jobCode, jobGroup);
						if (currentJobDetail == null) {
							quartzUtil.enableJob(jobCode, jobGroup);
							// System.out.println(jobCode+" enabled");
						} else {
							// System.out.println(jobCode+" already enabled");
						}
					} else if (jobEnabled.equalsIgnoreCase("0")) {
						currentJobDetail = quartzUtil.getJobDetail(jobCode, jobGroup);
						if (currentJobDetail == null) {
							// System.out.println(jobCode+" already disabled");
						} else {
							quartzUtil.disableJob(jobCode, jobGroup);
							// System.out.println(jobCode+" disabled");
						}
					}

					// Starting and stopping of jobs
					if (jobEnabled.equalsIgnoreCase("1")) {
						cronExp = quartzUtil.getCronExpression(jobCode, jobGroup);
						if (jobStatus.equals("1")) {
							if (cronExp == null) {
								quartzUtil.scheduleJob(jobMap);
							} else if (!jobCronExp.equalsIgnoreCase(cronExp)) {
								// System.out.println(jobCode+" rescheduling");
								quartzUtil.unscheduleJob(jobCode, jobGroup);
								quartzUtil.scheduleJob(jobMap);
							} else {
								// System.out.println("No change in schedule of the job :"+jobCode);
							}
						} else if (jobStatus.equals("2")) {
							if (cronExp == null) {
								// System.out.println("Job already stopped :"+jobCode);
							} else {
								// System.out.println("Stopping job"+jobCode);
								quartzUtil.unscheduleJob(jobCode, jobGroup);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.reset();
			databaseContext.close();
		}

	}

}
