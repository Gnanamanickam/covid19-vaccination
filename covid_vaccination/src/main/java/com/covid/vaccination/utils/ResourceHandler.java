package com.covid.vaccination.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ResourceHandler {
	
	Logger logger = (Logger) LogManager.getLogger(ResourceHandler.class);
	
	static final ExecutorService executorService = Integer.getInteger("thread.count") != null
			? Executors.newCachedThreadPool()
			: Executors.newFixedThreadPool(Integer.getInteger("thread.count", 150));
	
	static List<Future<?>> futures = new ArrayList<Future<?>>();
	
	public static void Shutdown() {
		boolean allDone = true;
		for(Future<?> future : futures) {
			allDone &= future.isDone();
		}
		
		if(allDone == true) {
			executorService.shutdown();
			try {
				while(! executorService.awaitTermination(60, TimeUnit.SECONDS)) {
					Thread.sleep(6000);
					executorService.shutdownNow();
				}
				while(! executorService.awaitTermination(60, TimeUnit.SECONDS)) {
					System.err.println("Pool did not terminate");
				}
			}
			catch(InterruptedException e) {
				executorService.shutdownNow();
				Thread.currentThread().interrupt();
			}
		}
	}
	
	public static void submitJob(List<Callable<Object>> callable) throws InterruptedException, ExecutionException {
		
		List<Future<Object>> futures =executorService.invokeAll(callable); 
		
		for(Future<Object> future : futures) {
			System.out.println("future Get" + future.get());
		}
	}

}
