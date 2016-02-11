package com.interview.datastructure.stack;

public class QueueMadeFromStack {
	Stack s1 = new Stack();
	Stack s2 = new Stack();
	
	public void enqueue(int data){
		s1.push(data);
	}
	
	public void dequeue(){
		if(s2.linklist.head==null) {
			if(s1.linklist.head==null) {
				return;
			}else {
				while(s1.linklist.head!=null){
					s2.push(s1.top());
					s1.pop();
				}
			}
		}
		System.out.println(s2.top());
		s2.pop();
	}
	
	public static void main(String[] args) {
		QueueMadeFromStack queue = new QueueMadeFromStack();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		queue.dequeue();
	}
}
