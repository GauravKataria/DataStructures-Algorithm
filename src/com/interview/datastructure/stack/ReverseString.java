package com.interview.datastructure.stack;

public class ReverseString {

	private static void reverse(Stack<Integer> stack) {
		if(stack.linklist.head==null) {
			return;
		}
		int n = stack.top();
		stack.pop();
		reverse(stack);
		
		insertAtBottom(stack, n);
	}
	
	private static void insertAtBottom(Stack<Integer> stack, int n) {
		if(stack.linklist.head==null) {
			stack.push(n);
			return;
		}
		int m = stack.top();
		stack.pop();
		insertAtBottom(stack, n);
		
		stack.push(m);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		stack.printStack();
		
		ReverseString.reverse(stack);
		
		stack.printStack();
	}
}
