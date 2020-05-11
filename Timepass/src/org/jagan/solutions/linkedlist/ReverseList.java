package org.jagan.solutions.linkedlist;

public class ReverseList {

	/*
	 * 
	 * Reverse a singly linked list.
	 * 
	 * Example:
	 * 
	 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
	 * 
	 */
	public static void main(String[] args) {
		LinkedNodeList list = new LinkedNodeList();
		list.addNodes("1", "2", "3", "4", "5");
		System.out.println("LinkedNodeList : " + list);
		reverseList(list);
		System.out.println("LinkedNodeList : " + list);
		list = new LinkedNodeList();
		list.addNodes("1", "2", "3", "4", "5");
		LinkedNode head = recursiveReverseList(list.head);
		list.head = head;
		System.out.println("LinkedNodeList : " + list);
	}

	public static void reverseList(LinkedNodeList list) {
		LinkedNode current = list.head;
		LinkedNode prev = null;
		while(current != null) {
			LinkedNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		list.head = prev;
	}
	
	public static LinkedNode recursiveReverseList(LinkedNode head) {
		if (head == null || head.next == null) return head;
	    LinkedNode p = recursiveReverseList(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
	}
}
