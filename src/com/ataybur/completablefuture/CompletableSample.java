package com.ataybur.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableSample {
	public static void main(String[] args) {
		final CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> doSomethingAndReturnA())
                .thenApply(a -> convertToB(a));

        try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}
	
	private static int convertToB(final String a) {
        System.out.println("convertToB: " + Thread.currentThread().getName());
        return Integer.parseInt(a);
    }

    private static String doSomethingAndReturnA() {
        System.out.println("doSomethingAndReturnA: " + Thread.currentThread().getName());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return "1";
    }
}
