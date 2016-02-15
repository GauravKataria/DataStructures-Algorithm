package com.interview.datastructure.stack;

public class EvaluatePostfix {
	Stack<Integer> stack;
	
	public static void evaluatePostFix(String input){
		int inputLength = input.length();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<inputLength; i++) {
			char c = input.charAt(i);
			
			if((int)c>=48&&(int)c<=57) {
				stack.push(Character.getNumericValue(c)); //stack store int values not ascii values
			} else {
				int int1=stack.top(); stack.pop();
				int int2=stack.top(); stack.pop();
				int int3=0;
				
				if(c=='+'){
					int3 = int1+int2;
				}else if(c=='-'){
					int3 = int1-int2;					
				}else if(c=='*'){
					int3 = int1*int2;					
				}else if(c=='/'){
					int3 = int1/int2;
				}
				stack.push(int3);
				
			}
		}
		
		System.out.println("Result : " + stack.top());
	}
	
	public static void main(String[] args) {
		EvaluatePostfix.evaluatePostFix("231*+9-");
	}
}
