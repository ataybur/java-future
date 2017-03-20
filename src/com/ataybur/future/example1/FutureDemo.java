package com.ataybur.future.example1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Java program to show how to use Future in Java. Future allows to write
 * asynchronous code in Java, where Future promises result to be available in
 * future
 *
 * @author Javin
 */
public class FutureDemo {

    private static final ExecutorService threadpool = Executors.newFixedThreadPool(3);

    public static void main(String args[]) throws InterruptedException, ExecutionException {
    	int factNum = 10;
        FactorialCalculator task = new FactorialCalculator(factNum);
        System.out.println("Submitting Task ...");

        Future<Long> future = threadpool.submit(task);

        System.out.println("Task is submitted");

        while (!future.isDone()) {
            System.out.println("Task is not completed yet....");
            Thread.sleep(1); //sleep for 1 millisecond before checking again
        }

        System.out.println("Task is completed, let's check result");
        Long factorial = future.get();
        System.out.printf("Factorial of %d is : %d",factNum, factorial);

        threadpool.shutdown();
    }

}
