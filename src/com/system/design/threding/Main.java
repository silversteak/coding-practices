package com.system.design.threding;

public class Main {

	public static void main(String[] args) {

		Printer printer = new Printer();
		Thread t1 = new Thread(new OddEvenTask(20, printer, false));
		Thread t2 = new Thread(new OddEvenTask(20, printer, true));
		
		t2.start();
		t1.start();
		
	}

}
