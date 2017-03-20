package com.ataybur.future.example1;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.Test;

public class FactorialCalculator implements Callable<Long> {
	 private final int number;

     public FactorialCalculator(int number) {
         this.number = number;
     }

     @Override
     public Long call() {
     	Long output = 0L;
         try {
             output =  factorial(number);
         } catch (InterruptedException ex) {
             Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return output;
     }

     private long factorial(int number) throws InterruptedException {
         if (number < 0) {
             throw new IllegalArgumentException("Number must be greater than zero");
         }
         long result = 1;
         while (number > 0) {
             Thread.sleep(1); // adding delay for example
             result = result * number;
             number--;
         }
         return result;
     }
}
