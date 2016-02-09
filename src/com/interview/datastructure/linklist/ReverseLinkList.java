package com.interview.datastructure.linklist;

public class ReverseLinkList extends LinkList {
	
	public void reverse() {
		if(head==null) {
			return;
		}
		Node current = head, prev = null, next = null;
		
		while(current!=null) {
			next = current.next;
			current.next=prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	//modify this.head does't return actual head
	public Node reverseRecursive(Node current) {
		if(current==null){
			return null;
		}
		if(current.next==null){
			head = current;
			return current;
		}		
		Node next = current.next;
		current.next=null;
		Node last = reverseRecursive(next);
		last.next = current;
		return current;
	}

	//return head
	public Node reverseRecursive1(Node current) {
		if(current==null){
			return null;
		}
		if(current.next==null){
			return current;
		}		
		Node next = current.next;
		current.next=null;
		Node last = reverseRecursive1(next);
		next.next = current;
		return last;
	}
	
	public static void main(String[] args) {
		ReverseLinkList linkList = new ReverseLinkList();
		
		linkList.insertFront(new Node(6));
		linkList.insertFront(new Node(5));
		linkList.insertFront(new Node(4));
		linkList.insertFront(new Node(3));
		linkList.insertFront(new Node(2));
		linkList.insertFront(new Node(1));
		
		//linkList.reverse();
		//linkList.reverseRecursive(linkList.head);
		linkList.head=linkList.reverseRecursive1(linkList.head);
		
		linkList.printLinkedList();
	}
}
