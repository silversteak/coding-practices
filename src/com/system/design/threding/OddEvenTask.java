package com.system.design.threding;

public class OddEvenTask implements Runnable {

	private int max;
	private Printer printer;
	private boolean isEvenNumber;
	
	public OddEvenTask(int max, Printer printer, boolean isEvenNumber) {
		super();
		this.max = max;
		this.printer = printer;
		this.isEvenNumber = isEvenNumber;
	}

	@Override
	public void run() {
		int number = isEvenNumber ? 2 : 1;
		while(number <= max) {
			if(isEvenNumber) {
				printer.printEven(number);
			}else {
				printer.printOdd(number);
			}
			number+=2;
		}
		
	}

}
