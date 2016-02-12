package com.interview.datastructure.queue;

import com.interview.datastructure.linklist.Node;

public class Queue {
	Node front = null, rear = null;
	
	public void enqueue(int data){
		if(front==null && rear==null) {
			rear=new Node(data);
			front=rear;		// silly mistake if you assign with new node here assign rear as they will point to same memory location
		} else{
			rear.next=new Node(data);
			rear=rear.next;
		}
	}
	
	public int dequeue(){
		if(front==null && rear==null) {
			return -1;
		}else if(front==rear) {
			front=rear=null;
			return -1;
		}else {
			Node temp = front.next;
			front.next=null;
			int frontData = front.data; 
			front=temp;
			return frontData;
		}
	}
	
	public void print(){
		Node temp = front;
		while(temp!=rear){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print(temp.data + " \n");
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		queue.dequeue();
		
		queue.print();
	}
}
