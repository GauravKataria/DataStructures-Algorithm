package com.interview.datastructure.linklist;

public class LoopInLinklist extends LinkList {
	public void detectloopAndRemove(NodeList head){
		if(head==null) {
			return;
		}
			
		NodeList slowPtr=head, fastPtr=head;
		
		while(slowPtr.next!=null && fastPtr.next.next!=null) {
			
			slowPtr=slowPtr.next;
			fastPtr=fastPtr.next.next;
			
			if(slowPtr.data==fastPtr.data) {
				System.out.println("Loop Detected");
				removeLoop(fastPtr);
				return;
			}
		}
		System.out.println("Loop is not present");
		
	}
	
	public void removeLoop(NodeList<Integer> fastPtr){
		NodeList<Integer> slowPtr=head;
		int intersectionPoint=0;
		
		while(slowPtr.next!=null && fastPtr.next!=null) {
			slowPtr=slowPtr.next;
			fastPtr=fastPtr.next;
			
			if(slowPtr.data==fastPtr.data) {
				intersectionPoint = fastPtr.data;
				System.out.println("Intersection point : " + intersectionPoint);
				break;
			}
		}
		
		while(slowPtr.next.data!=intersectionPoint) {
			slowPtr=slowPtr.next;
		}
		slowPtr.next=null;
		System.out.println("Loop Removed!");
	}
	
	public static void main(String[] args) {
		LoopInLinklist linkList = new LoopInLinklist();
		
		NodeList last = linkList.insertFront(new NodeList(5));
		linkList.insertFront(new NodeList(4));
		linkList.insertFront(new NodeList(3));
		linkList.insertFront(new NodeList(2));
		linkList.insertFront(new NodeList(1));
		
		last.next = linkList.head.next; //loop created		
		
		linkList.detectloopAndRemove(linkList.head);
		
		linkList.printLinkedList();
	}
}
