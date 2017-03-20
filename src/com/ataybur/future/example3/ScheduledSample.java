package com.ataybur.future.example3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledSample {

	public static void main(String[] args) {
		ScheduledSample scheduledSample = new ScheduledSample();
		scheduledSample.sample3();

	}
	
	public void sample1(){
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = () -> {
			System.out.println("Scheduling: " + System.nanoTime());
			return;
		};
		ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

		try {
			TimeUnit.MILLISECONDS.sleep(1337);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
		System.out.printf("Remaining Delay: %sms %s", remainingDelay, System.lineSeparator());
	}
	
	public void sample2(){
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());

		int initialDelay = 3;
		int period = 1;
		executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
	}
	
	public void sample3(){
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(2);
		        System.out.println("Scheduling: " + System.nanoTime());
		    }
		    catch (InterruptedException e) {
		        System.err.println("task interrupted");
		    }
		};
		int initialDelay = 0;
		int delay = 1;
		executor.scheduleWithFixedDelay(task, initialDelay, delay, TimeUnit.SECONDS);
	}

}
