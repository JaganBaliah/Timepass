package org.jagan.solutions.linkedlist;

public class MergeSortedList {

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
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		LinkedNode rtnVal = new LinkedNode("0");
		LinkedNode curr = rtnVal;
		while(l1 != null && l2 != null) {
			if(Integer.parseInt(l1.val) <= Integer.parseInt(l2.val)) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		curr.next = l1 == null ? l2 : l1;
		return rtnVal.next;
	}

	public static LinkedNode recursiveMergeSortedList(LinkedNode l1, LinkedNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(Integer.parseInt(l1.val) <= Integer.parseInt(l2.val)) {
			l1.next = recursiveMergeSortedList(l1.next, l2);
			return l1;
		} else {
			l2.next = recursiveMergeSortedList(l1, l2.next);
			return l2;
		}
	}
	
}
