package com.interview.datastructure.linklist;

/**
 *  - Create Linklist
 *	- Insert Linklist
 *		- at front
 *		- at back
 *		- at location
 *	- Delete Linklist
 *		- given key
 *		- given position
 *	- Length of Linklist
 *		- recursion 
 *		- iterative
 *	- Swap Linklist node without changing data
 * 
 * @author gkataria
 *
 */

public class LinkList {
	public Node head = null;
	
	public void printLinkedList(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public Node insertFront(Node node) {
		if(head==null){
			head=node;
			return node;
		}
		
		Node temp = head;
		head = node;
		head.next = temp;
		
		return node;
	}
	
	public void insertBack(Node node) {
		Node temp = head;
		if(head==null) {
			head = node;
			return;
		}
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}
	
	public void insertAfter(Node preNode, Node node) {
		Node temp = head;
		if(head==null) {
			head = node;
			return;
		}
		while(temp.next==null) {
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
		
	}
	
	public void deleteNode(Node node) {
		if(head==null) {
			System.out.println("linklist is empty delete aborted");
			return;
		}
		if(head.data==node.data) {
			head = head.next;
			//System.out.println("Successful!");
			return;
		}
		
		Node temp = head;
		do {
			if(temp.next.data==node.data) {
				if(temp.next.data==head.data) {
					head=head.next;
				}
				temp.next=temp.next.next;
				System.out.println("Successful!");
				return;
			}
			temp=temp.next;
		} while(temp!=null);
		
		System.out.println("Node not present, deletion failed!");
	}
	
	public int linkListLength() {
		int length=0;
		Node temp = head;
		while(temp!=null) {
			length+=1;
			temp=temp.next;
		}
		return length;
	}
	
	public int linkListLengthRecursive(Node node) {
		if(node==null) {
			return 0;
		}
		return 1 + linkListLengthRecursive(node.next);
	}
	
	/**
	 * swap node not data
	 * 
	 * This may look a simple problem, but is interesting question as it has following cases to be handled.
	 *	1) x and y may or may not be adjacent.
	 *	2) Either x or y may be a head node.
	 *	3) Either x or y may be last node.
	 *	4) x and/or y may not be present in linked list.
	 * 
	 * @param node1
	 * @param node2
	 */
	public void swapNode(Node node1, Node node2){
		Node temp=head;
		if(temp==null || node1==node2) {
			return;
		}
		
		//find node1
		temp=head;
		Node node1ll=null, preNode1ll=null;
		while(temp!=null) {
			if(temp.data==node1.data){
				node1ll=temp;
				break;
			}
			preNode1ll=temp;
			temp=temp.next;
		}
		
		//find node2
		temp=head;
		Node node2ll=null, preNode2ll=null;
		while(temp!=null) {
			if(temp.data==node2.data){
				node2ll=temp;
				break;
			}
			preNode2ll=temp;
			temp=temp.next;
		}
		
		//anyone of them not present
		if(node1ll==null || node2ll==null) {
			return;
		}
		
		//anyone one of them is head
		if(node1ll==head){
			head=node2ll;
		}
		else {
			preNode1ll.next=node2ll;
		}
		
		if(node2ll==head) {
			head=node1ll;
		} else {
			preNode2ll.next=node1ll;
		}
		
		//swap
		Node temp1 = node1ll.next;
		node1ll.next = node2ll.next;
		node2ll.next = temp1;
		
	}
	
	public static void main(String[] args) {
		LinkList linkList = new LinkList();
		
		//BasicStart
//		linkList.head = new Node(1);
//		Node second = new Node(2);
//		Node third = new Node(3);		
//		linkList.head.next = second;
//		second.next = third;
		
		//Insert
//		linkList.insertFront(new Node(1));
//		linkList.insertFront(new Node(2));
//		linkList.insertFront(new Node(3));
//		linkList.insertBack(new Node(4));
//		linkList.insertBack(new Node(5));
//		linkList.insertBack(new Node(6));
//		linkList.insertAfter(new Node(2), new Node(7));
//		linkList.insertAfter(new Node(3), new Node(8));		
//		linkList.insertAfter(new Node(4), new Node(9));		

		//Delete
		linkList.insertFront(new Node(6));
		linkList.insertFront(new Node(5));
		linkList.insertFront(new Node(4));
		linkList.insertFront(new Node(3));
		linkList.insertFront(new Node(2));
		linkList.insertFront(new Node(1));
//		linkList.deleteNode(new Node(1));

		//Length
//		System.out.println("length: " + linkList.linkListLength());
//		System.out.println("length: " + linkList.linkListLengthRecursive(linkList.head));

		//Swap
//		linkList.swapNode(new Node(2), new Node(2));
		
		linkList.printLinkedList();
	}
}
