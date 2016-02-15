package com.interview.datastructure.queue;

import com.interview.datastructure.linklist.LinkList;
import com.interview.datastructure.linklist.NodeList;

public class QueueIneffecientImpl {
	LinkList linklist = new LinkList();
	
	public void enqueue(int data){
		linklist.insertFront(new NodeList(data));
	}
	
	public void dequeue(){
		linklist.deleteNode(new NodeList(front()));
	}
	
	public void print(){
		linklist.printLinkedList();
	}
	
	public int rear(){
		return (int) linklist.head.data;
	}
	
	public int front(){
		if(linklist.head==null){
			return -1;
		} else {
			NodeList<Integer> temp = linklist.head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			return temp.data;
		}
	}
	public static void main(String[] args) {
		
	}
}
