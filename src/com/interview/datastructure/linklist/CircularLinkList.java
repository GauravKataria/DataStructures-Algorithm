package com.interview.datastructure.linklist;

public class CircularLinkList {
	NodeList head = null;
	
	public void insertLast(NodeList node){
		if(node==null){ return; }
		
		if(head==null){ 
			head=node;
			head.next=head;
		}
		NodeList temp=head;
		while(temp.next.data!=head.data){
			temp=temp.next;
		}
		temp.next = node;
		node.next=head;
	}
	
	public void printList(){
		NodeList temp = head;
		
		if(head==null){
			System.out.println("list is empty");
			return;
		}
		do {
			System.out.print(temp.data + " ");
			temp=temp.next;
		}while(temp.data!=head.data);	
	}
	
	public void printList(NodeList node){
		NodeList temp = node;
		
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
		circularLinkList.insertLast(new NodeList(1));
		circularLinkList.insertLast(new NodeList(2));
		circularLinkList.insertLast(new NodeList(3));
		circularLinkList.insertLast(new NodeList(4));
		circularLinkList.insertLast(new NodeList(5));

		circularLinkList.printList();
	}
}
