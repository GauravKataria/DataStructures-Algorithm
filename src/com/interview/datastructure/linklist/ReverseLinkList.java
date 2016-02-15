package com.interview.datastructure.linklist;

public class ReverseLinkList extends LinkList {
	
	public void reverse() {
		if(head==null) {
			return;
		}
		NodeList current = head, prev = null, next = null;
		
		while(current!=null) {
			next = current.next;
			current.next=prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	//modify this.head does't return actual head
	public NodeList reverseRecursive(NodeList current) {
		if(current==null){
			return null;
		}
		if(current.next==null){
			head = current;
			return current;
		}		
		NodeList next = current.next;
		current.next=null;
		NodeList last = reverseRecursive(next);
		last.next = current;
		return current;
	}

	//return head
	public NodeList reverseRecursive1(NodeList current) {
		if(current==null){
			return null;
		}
		if(current.next==null){
			return current;
		}		
		NodeList next = current.next;
		current.next=null;
		NodeList last = reverseRecursive1(next);
		next.next = current;
		return last;
	}
	
	public static void main(String[] args) {
		ReverseLinkList linkList = new ReverseLinkList();
		
		linkList.insertFront(new NodeList(6));
		linkList.insertFront(new NodeList(5));
		linkList.insertFront(new NodeList(4));
		linkList.insertFront(new NodeList(3));
		linkList.insertFront(new NodeList(2));
		linkList.insertFront(new NodeList(1));
		
		//linkList.reverse();
		//linkList.reverseRecursive(linkList.head);
		linkList.head=linkList.reverseRecursive1(linkList.head);
		
		linkList.printLinkedList();
	}
}
