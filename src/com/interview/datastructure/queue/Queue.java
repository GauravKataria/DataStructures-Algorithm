package com.interview.datastructure.queue;

import com.interview.datastructure.linklist.NodeList;

public class Queue<T> {
	NodeList<T> front = null, rear = null;
	int size=0;
	
	public void enqueue(T data){
		if(front==null && rear==null) {
			rear=new NodeList<T>(data);
			front=rear;		// silly mistake if you assign with new node here assign rear as they will point to same memory location
		} else{
			rear.next=new NodeList<T>(data);
			rear=rear.next;
		}
		size+=1;
	}
	
	public T dequeue(){
		if(front==null && rear==null) {
			return null;
		}else if(front==rear) {
			T temp=front.data;
			front=rear=null;
			size-=1;
			return temp;
		}else {
			NodeList<T> temp = front.next;
			front.next=null;
			T frontData = front.data; 
			front=temp;
			size-=1;
			return frontData;
		}
	}
	
	public int size() {
		return size;
	}
	
	
	public boolean isEmpty() {
		if(front==null&&rear==null){
			return true;
		}else {
			return false;
		}
	}
	
	public void print(){
		NodeList<T> temp = front;
		while(temp!=rear){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print(temp.data + " \n");
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		queue.dequeue();
		
		queue.print();
	}
}
