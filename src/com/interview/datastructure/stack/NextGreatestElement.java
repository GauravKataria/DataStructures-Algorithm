package com.interview.datastructure.stack;

public class NextGreatestElement {
	public static void nextGreatestElement(int[] arrayInput){
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(arrayInput[0]);
		for(int i=1; i<arrayInput.length; i++) {
			while(s.linklist.head!=null && arrayInput[i]>s.top()) {
				System.out.println(s.top()+ " --> " +arrayInput[i]);		//print directly or store in 'array' or 'map'
				s.pop();
			}
			s.push(arrayInput[i]);
		}

		while(s.linklist.head!=null){
			System.out.println(s.top()+ " --> -1");
			s.pop();
		}
	}
	
	public static void main(String[] args) {
		//int[] array = {7, 1, 2, 9, 5};
		//int[] array = {4, 5, 2, 25};
		int[] array = {13, 7, 6, 12};
		nextGreatestElement(array);
	}
}