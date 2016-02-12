package com.interview.datastructure.queue;

import com.interview.datastructure.linklist.LinkList;
import com.interview.datastructure.linklist.Node;

public class QueueIneffecientImpl {
	LinkList linklist = new LinkList();
	
	public void enqueue(int data){
		linklist.insertFront(new Node(data));
	}
	
	public void dequeue(){
		linklist.deleteNode(new Node(front()));
	}
	
	public void print(){
		linklist.printLinkedList();
	}
	
	public int rear(){
		return linklist.head.data;
	}
	
	public int front(){
		if(linklist.head==null){
			return -1;
		} else {
			Node temp = linklist.head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			return temp.data;
		}
	}
	public static void main(String[] args) {
		
	}
}
