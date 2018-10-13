package com.bo.job.core;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;




public class ThreadPoolManager {
	
	private static ThreadPoolManager threadPoolManager=null;
	HashMap<String,ExecutorService> poolMap = new HashMap<String,ExecutorService>();
	
	public static ThreadPoolManager getInstance()throws Exception {

		if(threadPoolManager==null) {
			threadPoolManager = new ThreadPoolManager();
		}
		
		return threadPoolManager;	

	}
	
	public ExecutorService getThreadPool(String key,int poolCount){
		
		ExecutorService threadPool = null;
		BlockingQueue<Runnable> queue = null;
		
		try {
			
			if(poolMap.containsKey(key)){
				threadPool=poolMap.get(key);	
			}else{
				queue = new ArrayBlockingQueue<Runnable>(poolCount);
				System.out.println("Creating Thread Pool for job : "+key);
				//threadPool = Executors.newFixedThreadPool(poolCount);
				threadPool = new ThreadPoolExecutor(poolCount, poolCount, 0L, TimeUnit.MICROSECONDS,queue); 
				poolMap.put(key, threadPool);
			}
									
		} catch (Exception e) {			
			if(threadPool!=null);
			threadPool.shutdown();
			e.printStackTrace();
		}
		
		return threadPool;
	}
	
	public void destroyThreadPool(String key){
		
		ExecutorService threadPool = null;
		
		try {
			
			if(poolMap.containsKey(key)){
				threadPool=poolMap.get(key);
				threadPool.shutdown();
				poolMap.remove(key);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
