package org.jagan.solutions.linkedlist;

public class RemoveNthNodeFromEnd {

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
		deleteNodeFromEndAt(list, 1);
		System.out.println("LinkedNodeList : " + list);
	}

	public static void deleteNodeFromEndAt(LinkedNodeList list, int n) {
		LinkedNode advNode = list.head;
		while(n > 0) {
			if(advNode == null) return;
			advNode = advNode.next;
			n--;
		}
		if(advNode ==  null) {
			list.head = list.head.next;
			return;
		}
		LinkedNode currNode = list.head;
		while(advNode.next != null) {
			advNode = advNode.next;
			currNode = currNode.next;
		}
		currNode.next = currNode.next.next;
	}
}
