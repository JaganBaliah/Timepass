package org.jagan.solutions.linkedlist;

public class ZReverseList {

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
		System.out.println("LinkedNodeList : " + list);
		LinkedNode head = recursiveReverseList(list.head);
		list.head = head;
		System.out.println("LinkedNodeList : " + list);
	}

	public static void reverseList(LinkedNodeList list) {
		LinkedNode pNode = null;
		LinkedNode cNode = list.head;
		while(cNode != null) {
			LinkedNode nNode = cNode.next;
			cNode.next = pNode;
			pNode = cNode;
			cNode = nNode;
		}
		list.head = pNode;
	}
	
	public static LinkedNode recursiveReverseList(LinkedNode head) {
		if(head == null || head.next == null) return head;
		LinkedNode p = recursiveReverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
}
