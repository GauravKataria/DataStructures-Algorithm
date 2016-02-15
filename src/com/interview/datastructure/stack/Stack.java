package com.interview.datastructure.stack;

import com.interview.datastructure.linklist.LinkList;
import com.interview.datastructure.linklist.NodeList;

public class Stack<T> {
	LinkList<T> linklist = new LinkList<T>();
	int size=0;
	
	public void push(T node) {
		linklist.insertFront(new NodeList<T>(node));
		size+=1;
	}
	
	public T pop() {
		T top = top();
		linklist.deleteNode(linklist.head);
		size-=1;
		return top;
	}

	public T top() {
		if(linklist.head==null) return null;
		return (T) linklist.head.data;
	}
	
	public int getSize() {
		//System.out.println("Stack size : " + size);
		return size;
	}
	
	public void printStack() {
		linklist.printLinkedList();
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.printStack();
		
		stack.pop();

		stack.printStack();
		
		System.out.println(stack.top());

	}
	
}

