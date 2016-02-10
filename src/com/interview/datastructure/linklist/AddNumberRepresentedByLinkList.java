package com.interview.datastructure.linklist;

public class AddNumberRepresentedByLinkList extends LinkList{


	public LinkList addNumbers(Node node1, Node node2) {
		return null;
	}

	/**
	 * Input:
	 *	  First List: 5->6->3  // represents number 365
	 *	  Second List: 8->4->2 //  represents number 248
	 *	Output
	 *	  Resultant list: 3->1->6  // represents number 613
	 *
	 * Input:
	 *	  First List: 7->5->9->4->6  // represents number 64957
	 *	  Second List: 8->4 //  represents number 48
	 *	Output
	 *	  Resultant list: 5->0->0->5->6  // represents number 65005
	 */
	public LinkList addNumbers1(Node node1, Node node2) {
		return addNumbers1Util(node1, node2, 0, new LinkList());
	}
	
	public LinkList addNumbers1Util(Node node1, Node node2, int carry, LinkList result) {
		if(node1==null && node2==null) {
			if(carry==0) {
				return result;				
			} else {
				int resultData = carry%10;
				carry = carry/10;
				Node temp = new Node(resultData);
				result.insertBack(temp);
				return addNumbers1Util(node1, node2, carry, result);
			}
		}
		if(node1==null) {
			int resultData = node2.data + carry;
			carry = resultData/10;
			resultData = resultData%10;
			Node temp = new Node(resultData);
			result.insertBack(temp);
			return addNumbers1Util(node1, node2.next, carry, result);
		}else if(node2==null) {
			int resultData = node1.data + carry;
			carry = resultData/10;
			resultData = resultData%10;
			Node temp = new Node(resultData);
			result.insertBack(temp);			
			return addNumbers1Util(node1.next, node2, carry, result);
		}else {
			int resultData = node1.data + node2.data + carry;
			carry = resultData/10;
			resultData = resultData%10;
			Node temp = new Node(resultData);
			result.insertBack(temp);
			return addNumbers1Util(node1.next, node2.next, carry, result);			
		}
	}

	public static void main(String[] args) {
		AddNumberRepresentedByLinkList linkList1 = new AddNumberRepresentedByLinkList();
		AddNumberRepresentedByLinkList linkList2 = new AddNumberRepresentedByLinkList();
		LinkList linkList3 = new AddNumberRepresentedByLinkList();
		
		linkList1.insertFront(new Node(3));
		linkList1.insertFront(new Node(6));
		linkList1.insertFront(new Node(5));
		
		linkList2.insertFront(new Node(2));
		linkList2.insertFront(new Node(4));
		linkList2.insertFront(new Node(8));
		
//		linkList3 = ((AddNumberRepresentedByLinkList) linkList3).addNumbers(linkList1.head, linkList2.head);	//incomplete
		
//		linkList1.head=null;
//		linkList1.insertFront(new Node(6));
//		linkList1.insertFront(new Node(4));
//		linkList1.insertFront(new Node(9));
//		linkList1.insertFront(new Node(5));
//		linkList1.insertFront(new Node(7));
//
//		linkList2.head=null;
//		linkList2.insertFront(new Node(4));
//		linkList2.insertFront(new Node(8));
			
		linkList3 = ((AddNumberRepresentedByLinkList) linkList3).addNumbers1(linkList1.head, linkList2.head);
		
		linkList3.printLinkedList();
	}
}
