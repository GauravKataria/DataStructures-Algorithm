package com.interview.datastructure.stack;

import java.util.HashMap;
import java.util.Map;

public class StockSpanProblem {
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	//use of map can be avoided with simple array
	
	public static void calculateStockSpan(int []input){
		Stack s = new Stack();
		
		s.push(input[0]);
		System.out.println(s.top()+ " --> 1");
		for(int i=1; i<input.length; i++) {
			int count = 1;
			while(s.linklist.head!=null && input[i]>s.top()) {
				count=count+getCount(s.top());
				s.pop();
			}
			setCount(input[i], count);
			System.out.println(input[i]+ " --> " + count);
			s.push(input[i]);
		}
	}
	
	private static void setCount(int i, int count) {
		map.put(i, count);
	}

	private static int getCount(int key) {
		return (int) map.get(key);
	}

	public static void main(String[] args) {
		int[] array = {100, 80, 60, 70, 60, 75, 85};
		calculateStockSpan(array);
	}
}
