package com.interview.datastructure.queue;

public class VisitAllPetrolPumps {
	public static void visitAllPetrolPump(int []arr){
		Queue q = new Queue();
		int sum=0;
		int start=0;
		
		//push arr to queue
		for(int i : arr) {
			q.enqueue(i);
		}
		
		while(q.front!=null && q.rear!=null) {
			if(q.front==q.rear&&q.front.data<0){
				System.out.println("input not valid");
			}
			
			int val=q.dequeue();
			sum=sum+val;
			if(start==0) start=val;
			
			if(sum<0){
				q.enqueue(sum);
				start=0;
				sum=0;
			}
		}
		System.out.println(start);
		
	}
	
	public static void main(String[] args) {
		int []arr={-2,1,4,-1};
		visitAllPetrolPump(arr);
	}
}
