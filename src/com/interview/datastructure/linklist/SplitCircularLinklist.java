package com.interview.datastructure.linklist;

public class SplitCircularLinklist extends CircularLinkList {
		NodeList head1, head2;
		
		public void split(){
			if(head==null){
				System.out.println("list is empty");
				return;
			}
			else if(head.next==head){
				System.out.println("list contains one element cant be split");
				return;
			}
			else {
				NodeList slowPtr=head, fastPtr=head;
				do{
					slowPtr=slowPtr.next;
					fastPtr=fastPtr.next.next;
				}while(fastPtr!=head&&fastPtr.next!=head&&fastPtr.next.next!=head	);
				head1=head;
				head2=slowPtr.next;
				slowPtr.next=head;
				//look here is 2 elements are ther
				while(fastPtr.next!=head){
					fastPtr=fastPtr.next;
				}
				fastPtr.next=head2;
			}
		}
		
		public static void main(String[] args) {
			SplitCircularLinklist circularLinkList = new SplitCircularLinklist();
			circularLinkList.insertLast(new NodeList(1));
			circularLinkList.insertLast(new NodeList(2));
			circularLinkList.insertLast(new NodeList(3));
			circularLinkList.insertLast(new NodeList(4));
			circularLinkList.insertLast(new NodeList(5));

			circularLinkList.printList();
			System.out.println();
			
			circularLinkList.split();
			
			circularLinkList.printList(circularLinkList.head1);
			System.out.println();
			circularLinkList.printList(circularLinkList.head2);
		}
}
