package com.interview.datastructure.linklist;

public class MergeSortedLinkList extends LinkList{
	
	public LinkList merge(LinkList list1, LinkList list2) {
		ReverseLinkList result = new ReverseLinkList();
		NodeList<Integer> temp1=list1.head, temp2=list2.head;
		
		while(temp1!=null && temp2!=null){
			if(temp1.data < temp2.data) {
				result.insertBack(new NodeList(temp1.data));
				temp1=temp1.next;
			}else {
				result.insertBack(new NodeList(temp2.data));				
				temp2=temp2.next;
			}
		}
		while(temp1!=null){
			result.insertBack(new NodeList(temp1.data));
			temp1=temp1.next;
		}
		while(temp2!=null){
			result.insertBack(new NodeList(temp2.data));				
			temp2=temp2.next;
		}
		return (LinkList) result;
	}
	
	public LinkList mergeRecursion(LinkList list1, LinkList list2) {
		return mergeRecursionUtil(list1.head, list2.head, new LinkList());
	}
	
	public LinkList mergeRecursionUtil(NodeList<Integer> node1, NodeList<Integer> node2, LinkList result) {
		if(node1==null && node2==null) {
			return result;
		}
		if(node1==null) {
			result.insertBack(new NodeList(node2.data));
			return mergeRecursionUtil(node1, node2.next, result);
		}
		if(node2==null) {
			result.insertBack(new NodeList(node1.data));
			return mergeRecursionUtil(node1.next, node2, result);
		}
		if(node1.data<node2.data) {
			result.insertBack(new NodeList(node1.data));
			return mergeRecursionUtil(node1.next, node2, result);
		}else {
			result.insertBack(new NodeList(node2.data));
			return mergeRecursionUtil(node1, node2.next, result);
		}
	}
	
	public static void main(String[] args) {
		MergeSortedLinkList linkList1 = new MergeSortedLinkList();
		MergeSortedLinkList linkList2 = new MergeSortedLinkList();
		LinkList linkList3 = new MergeSortedLinkList();
		
		linkList1.insertFront(new NodeList(5));
		linkList1.insertFront(new NodeList(3));
		linkList1.insertFront(new NodeList(1));
		
		linkList2.insertFront(new NodeList(6));
		linkList2.insertFront(new NodeList(4));
		linkList2.insertFront(new NodeList(2));
		
		//linkList3 = ((MergeSortedLinkList) linkList3).merge(linkList1, linkList2);
		linkList3 = ((MergeSortedLinkList) linkList3).mergeRecursion(linkList1, linkList2);
		
		linkList3.printLinkedList();
	}
}
