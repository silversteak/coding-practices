package com.system.design.threding;


public class Printer {
	
	private boolean isOdd = false;
		
	synchronized void printEven(int number) {
		while(!isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
			}
		}
		System.out.println(Thread.currentThread().getName() + " : " + number);
		isOdd = false;
		notifyAll();
	}
	
	synchronized void printOdd(int number) {
		while(isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
			}
		}
		System.out.println(Thread.currentThread().getName() + " : " + number);
		isOdd = true;
		notifyAll();
	}
	
}
