package org.jagan.solutions.linkedlist;

public class ZMergeSortedList {

	/*
	 * 
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 * 
	 * Example:
	 * 
	 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		LinkedNodeList list1 = new LinkedNodeList();
		list1.addNodes("1", "2", "4");
		System.out.println("LinkedNodeList - 1 : " + list1);
		LinkedNodeList list2 = new LinkedNodeList();
		list2.addNodes("1", "3", "4");
		System.out.println("LinkedNodeList - 2 : " + list2);
		LinkedNode head = mergeSortedList(list1.head, list2.head);
		LinkedNodeList list = new LinkedNodeList(head);
		System.out.println("LinkedNodeList : " + list);
		
		list1 = new LinkedNodeList();
		list1.addNodes("1", "2", "4");
		System.out.println("LinkedNodeList - 1 : " + list1);
		list2 = new LinkedNodeList();
		list2.addNodes("1", "3", "4");
		System.out.println("LinkedNodeList - 2 : " + list2);
		head = recursiveMergeSortedList(list1.head, list2.head);
		list = new LinkedNodeList(head);
		System.out.println("LinkedNodeList : " + list);
		
	}

	public static LinkedNode mergeSortedList(LinkedNode l1, LinkedNode l2) {
		return null;
	}

	public static LinkedNode recursiveMergeSortedList(LinkedNode l1, LinkedNode l2) {
		return null;
	}
	
}
