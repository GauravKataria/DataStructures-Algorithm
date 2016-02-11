package com.interview.datastructure.stack;

public class InfixToPostfixConversion {
	public static void infixtopostfix(String input){

		int inputLength = input.length();
		Stack stack = new Stack();
		
		for(int i=0; i<inputLength; i++) {
			char c = input.charAt(i);
			
			if((int)c>=97&&(int)c<=122) {
				System.out.print(c+" ");
			}else {
				if(stack.linklist.head==null){stack.push((int)c);}
				else{
					if(c=='('){
						stack.push(c);
					}else if(c==')'){
						while(stack.top()!='('){
							System.out.print((char)stack.top()+" ");
							stack.pop();
						}
						stack.pop();
					}else if(pres(c)<pres((char)stack.top())){
						do{
							System.out.print((char)stack.top()+" ");
							stack.pop();
						}while(pres(c)<pres((char)stack.top()));
						stack.push(c);
					}else {
						stack.push(c);
					}
				}
				
			}
			
		}
	}
	
	static int pres(char c){
	    switch (c)
	    {
		    case '+':
		    case '-':
		        return 1;
		 
		    case '*':
		    case '/':
		        return 2;
		 
		    case '^':
		        return 3;
	    }
	    return -1;
	}
	
	public static void main(String[] args) {
		InfixToPostfixConversion.infixtopostfix("a+b*(c^d-e)^(f+g*h)-i");
	}
}
