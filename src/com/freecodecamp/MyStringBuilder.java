package com.freecodecamp;

public class MyStringBuilder{
	private static final int DFAULT_BUFFER_SIZE = 16;
	private static final int BUFFER_MULTIPILER = 2;
	
	public char[] str;
	public int size;
	//Number of characters in the string so far
	public int charCount;
	
	public MyStringBuilder() {
		this.size = DFAULT_BUFFER_SIZE;
		this.str = new char[DFAULT_BUFFER_SIZE];
	}
	
	public MyStringBuilder(int size) {
		this.size = size;
		this.str = new char[size];
	}
	
	public MyStringBuilder(char ch[]) {
		this();
		append(ch);
	}
	
	public MyStringBuilder(String ch) {
		this();
		append(ch);
	}
	
	private MyStringBuilder append(char ch[]) {
		while(resizeRequired(ch)) {
			resizeBuffer(ch);
		};
		
		addString(ch);
		updateCharCount(ch.length);
		return this;
	}
	
	private MyStringBuilder append(String newStr) {
		while(resizeRequired(newStr)) {
			resizeBuffer(newStr);
		};
		
		addString(newStr);
		updateCharCount(newStr.length());
		return this;
	}
	
	private void addString(String newInput) {
		System.arraycopy(newInput, 0, this.str,this.charCount, newInput.length());
	}

	private void resizeBuffer(String newInput) {
		int oldSize = this.size;
		char [] newStr = new char[this.size];
		this.size *= BUFFER_MULTIPILER; // Update the BufferSize;
		System.out.println("Resizing the array : increasing the size from "+oldSize+ " to "+ this.size);
		System.arraycopy(this.str, 0, newStr, 0, oldSize); // Copy the old Array
		this.str = newStr; // Set the new Array
	}

	private boolean resizeRequired(String newInput) {
		return this.charCount + newInput.length() > this.size ;
	}
	

	private void updateCharCount(int charCount) {
		this.charCount += charCount;
	}

	private void addString(char[] newInput) {
		System.arraycopy(newInput, 0, this.str,this.charCount, newInput.length);
	}

	private void resizeBuffer(char[] newInput) {
		int oldSize = this.size;
		this.size *= BUFFER_MULTIPILER; // Update the BufferSize;
		char [] newStr = new char[this.size];
		System.out.println("Resizing the array : increasing the size from "+oldSize+ " to "+ this.size);
		System.arraycopy(this.str, 0, newStr, 0, oldSize); // Copy the old Array
		this.str = newStr; // Set the new Array
	}

	private boolean resizeRequired(char[] newInput) {
		return this.charCount + newInput.length > this.size ;
	}

	
	
}
