package org.jagan.solutions.linkedlist;

public class ZRemoveNthNodeFromEnd {

	/*
	 * 
	 * Given a linked list, remove the n-th node from the end of list and return its
	 * head.
	 * 
	 * Example:
	 * 
	 * Given linked list: 1->2->3->4->5, and n = 2.
	 * 
	 * After removing the second node from the end, the linked list becomes
	 * 1->2->3->5.
	 * 
	 */
	public static void main(String[] args) {
		LinkedNodeList list = new LinkedNodeList();
		list.addNodes("1", "2", "3", "4", "5");
		System.out.println("LinkedNodeList : " + list);
		//list.deleteNodeFromEndAt(1);
		deleteNodeFromEndAt(list, 2);
		System.out.println("LinkedNodeList : " + list);
	}

	public static void deleteNodeFromEndAt(LinkedNodeList list, int n) {
		LinkedNode aNode = list.head;
		while(n > 0) {
			if(aNode == null) return;
			aNode = aNode.next;
			n--;
		}
		if(aNode == null) {
			list.head = list.head.next;
			return;
		}
		LinkedNode cNode = list.head;
		while(aNode.next != null) {
			cNode = cNode.next;
			aNode = aNode.next;
		}
		cNode.next = cNode.next.next;
	}
}