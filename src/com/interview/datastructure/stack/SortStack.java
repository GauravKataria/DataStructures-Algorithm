package com.interview.datastructure.stack;

public class SortStack {
	Stack<Integer> s = new Stack<Integer>();
		
	public void sortStackRecursion() {
		if(s.linklist.head==null){
			return;
		}
		int temp = s.top();
		s.pop();
		
		sortStackRecursion();
		
		sortedInsert(temp);
	}
	
	public void sortedInsert(int input) {
		if(s.linklist.head==null){
			s.push(input);
			return;
		}
		
		if(s.top()>input) {
			int temp = s.top();
			s.pop();
			sortedInsert(input);
			s.push(temp);
		} else {
			s.push(input);
		}
	}
	
	public static void main(String[] args) {
		SortStack ss = new SortStack();
		
		ss.s.push(5);
		ss.s.push(2);
		ss.s.push(7);
		ss.s.push(1);
		ss.s.push(6);
		
		ss.sortStackRecursion();
		
		ss.s.printStack();
	}
}




