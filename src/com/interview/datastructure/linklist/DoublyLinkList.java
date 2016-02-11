package com.interview.datastructure.linklist;


class DoublyNode {
	int data;
	DoublyNode next;
	DoublyNode previous;
		
	DoublyNode(){}
	
	DoublyNode(int data){
		this.data = data;
		this.next = null;
		this.previous = null;
	}
}

public class DoublyLinkList {
	DoublyNode head = null;
	
	public void insertBack(DoublyNode node) {
		if(node==null) {
			System.out.println("cannot insert null node");
			return;
		} else if(head==null) {
			head=node;
			head.next=head;
			head.previous=head;
			return;
		} else {
			DoublyNode temp = head;
			node.next=temp;
			node.previous=temp.previous;
			temp.previous=node;
			node.previous.next=node;
		}
	}
	
	public void insertFront(DoublyNode node) {
		if(node==null) {
			System.out.println("cannot insert null node");
			return;
		} else if(head==null) {
			head=node;
			head.next=head;
			head.previous=head;
			return;
		} else {
			DoublyNode temp = head;
			node.next=temp;
			node.previous=temp.previous;
			temp.previous=node;
			node.previous.next=node;
			head=node;
		}
	}
	
	public void insertAfter(DoublyNode node, DoublyNode afterNode) {
		if(node==null) {
			System.out.println("cannot insert null node");
			return;
		} else if(head==null) {
			head=node;
			head.next=head;
			head.previous=head;
			return;
		} else {
			DoublyNode temp=head;
			do {
				if(temp.data==afterNode.data){
					node.next=temp.next;
					node.previous=temp;
					temp.next=node;
					node.next.previous=node;
					return;
				}
				temp=temp.next;
			}while(temp!=head);
		}
	}
	
	public void insertBefore(DoublyNode node, DoublyNode beforeNode) {
		if(node==null) {
			System.out.println("cannot insert null node");
			return;
		} else if(head==null) {
			head=node;
			head.next=head;
			head.previous=head;
			return;
		} else {
			DoublyNode temp=head;
			do {
				if(temp.data==beforeNode.data){
					node.next=temp;
					node.previous=temp.previous;
					temp.previous=node;
					node.previous.next=node;
					return;
				}
				temp=temp.next;
			} while(temp!=head);
		}
	}
	
	public void delete(DoublyNode node) {
		if(node==null||head==null){return;}
		if(head.next==head) { // single node in list
			if(head==node) {
				head=null; 
				return;
			}
			else {
				return;
			}
		}
		DoublyNode temp=head; 
		do {
			if(temp.data==node.data){ //one is trying to delete head
				if(temp==head){
					head=head.next;
				}
				temp.previous.next=temp.next;
				temp.next.previous=temp.previous;
				temp.next=null;
				temp.previous=null;
				return;
			}
			temp=temp.next;
		}while(temp!=head);
	}
	
	public void reverse() {
		if(head==null){
			return;
		}
		DoublyNode temp = head;
		do {
			DoublyNode nextNodetemp = temp.next;
			temp.next=temp.previous;
			temp.previous=nextNodetemp;
			temp=nextNodetemp;
		}while(temp!=head);
		head=head.next;
	}
	
	public void print() {
		DoublyNode temp = head;
		
		if(head==null){
			System.out.println("list is empty");
			return;
		}
		do {
			System.out.print(temp.data + " ");
			temp=temp.next;
		}while(temp.data!=head.data);	
	}
	
	public static void main(String[] args) {
		DoublyLinkList doublyLinkList = new DoublyLinkList();
		doublyLinkList.insertFront(new DoublyNode(1));
		doublyLinkList.insertFront(new DoublyNode(2));
		doublyLinkList.insertFront(new DoublyNode(3));
		doublyLinkList.insertFront(new DoublyNode(4));
		
		doublyLinkList.insertBack(new DoublyNode(5));
		
		doublyLinkList.insertBefore(new DoublyNode(6), new DoublyNode(3));
		
		doublyLinkList.insertAfter(new DoublyNode(7), new DoublyNode(6));

		doublyLinkList.reverse();
		
		doublyLinkList.delete(new DoublyNode(7));
		
		doublyLinkList.print();
	}
}
