package com.interview.datastructure.stack;

import com.interview.datastructure.linklist.LinkList;
import com.interview.datastructure.linklist.Node;

public class Stack {
	LinkList linklist = new LinkList();
	int size=0;
	
	public void push(int data) {
		linklist.insertFront(new Node(data));
		size+=1;
	}
	
	public void pop() {
		linklist.deleteNode(linklist.head);
		size-=1;
	}

	public int top() {
		if(linklist.head==null) return -1;
		return linklist.head.data;
	}
	
	public void getStackSize() {
		System.out.println("Stack size : " + size);
	}
	
	public void printStack() {
		linklist.printLinkedList();
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.printStack();
		
		stack.pop();

		stack.printStack();
		
		System.out.println(stack.top());

	}
	
}

