package com.interview.datastructure.linklist;

public class AddNumberRepresentedByLinkList extends LinkList{

	/**
	 * Input:
	 *	  First List: 5->6->3  // represents number 365
	 *	  Second List: 8->4->2 //  represents number 248
	 *	Output
	 *	  Resultant list: 3->1->6  // represents number 613
	 *
	 */
	public void addNumbers(Node ) {
		
	}

	/**
	 * Input:
	 *	  First List: 7->5->9->4->6  // represents number 64957
	 *	  Second List: 8->4 //  represents number 48
	 *	Output
	 *	  Resultant list: 5->0->0->5->6  // represents number 65005
	 */
	public void addNumbers(Node ) {
		
	}

	public static void main(String[] args) {
		AddNumberRepresentedByLinkList linkList1 = new AddNumberRepresentedByLinkList();
		AddNumberRepresentedByLinkList linkList2 = new AddNumberRepresentedByLinkList();
		LinkList linkList3 = new AddNumberRepresentedByLinkList();
		
		linkList1.insertFront(new Node(5));
		linkList1.insertFront(new Node(3));
		linkList1.insertFront(new Node(1));
		
		linkList2.insertFront(new Node(6));
		linkList2.insertFront(new Node(4));
		linkList2.insertFront(new Node(2));
		
		//linkList3 = ((AddNumberRepresentedByLinkList) linkList3).merge(linkList1, linkList2);
		linkList3 = linkList3.addNumbers(linkList1, linkList2);
		
		linkList3.printLinkedList();
	}
}
