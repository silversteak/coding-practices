package com.amazon;

import java.util.Stack;

public class InfixToPrefix {

	static boolean isOperator(char ch){
		return (!(ch >= 'a' && ch <= 'z') && !(ch >= 'A' && ch <= 'Z') && !(ch >= '0' && ch <= '9')); 
	}

	static int getPriority(char ch){
		if(ch == '+' || ch == '-')
			return 1;
		else if(ch == '*' || ch =='/')
			return 2;
		else if (ch =='^')
			return 3;
		return 0;
	}

	static String infixtoprefix(String str){
		Stack<String> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();

		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);

					if(ch == '('){
						operators.push(ch);	
					}else if(ch == ')'){
						while(!operators.isEmpty() && operators.peek() != '(' ){
							String op1 = operands.pop();
							String op2 = operands.pop();
							char op = operators.pop();
							String temp = op+op2+op1;
							operands.push(temp);
						}
						operators.pop();
					}else if(!isOperator(ch)){
						operands.push(String.valueOf(ch));	
					}else{
						while(!operators.isEmpty() && getPriority(operators.peek()) >= getPriority(ch)){
							String op1 = operands.pop();
							String op2 = operands.pop();
							char op = operators.pop();
							String temp = op+op2+op1;
							operands.push(temp);
						}
						operators.push(ch);
					}
		}
		while(!operators.isEmpty()){
			String op1 = operands.pop();
			String op2 = operands.pop();
			char op = operators.pop();
			String temp = op+op2+op1;
			operands.push(temp);
		}

		return operands.peek();
	}



	public static void main(String[] args) {

		String test1 = "(A+B)*(C+D)";
		String test2 = "(A-B/C)*(A/K-L)";
		
		System.out.println(infixtoprefix(test1));
		System.out.println(infixtoprefix(test2));
		
		
	}

}
