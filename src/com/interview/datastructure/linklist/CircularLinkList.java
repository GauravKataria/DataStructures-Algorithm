package com.interview.datastructure.linklist;

public class CircularLinkList {
	Node head = null;
	
	public void insertLast(Node node){
		if(node==null){ return; }
		
		if(head==null){ 
			head=node;
			head.next=head;
		}
		Node temp=head;
		while(temp.next.data!=head.data){
			temp=temp.next;
		}
		temp.next = node;
		node.next=head;
	}
	
	public void printList(){
		Node temp = head;
		
		if(head==null){
			System.out.println("list is empty");
			return;
		}
		do {
			System.out.print(temp.data + " ");
			temp=temp.next;
		}while(temp.data!=head.data);	
	}
	
	public void printList(Node node){
		Node temp = node;
		
		if(node==null){
			System.out.println("list is empty");
			return;
		}
		do {
			System.out.print(temp.data + " ");
			temp=temp.next;
		}while(temp.data!=node.data);	
	}
	
	public static void main(String[] args) {
		CircularLinkList circularLinkList = new CircularLinkList();
		circularLinkList.insertLast(new Node(1));
		circularLinkList.insertLast(new Node(2));
		circularLinkList.insertLast(new Node(3));
		circularLinkList.insertLast(new Node(4));
		circularLinkList.insertLast(new Node(5));

		circularLinkList.printList();
	}
}
