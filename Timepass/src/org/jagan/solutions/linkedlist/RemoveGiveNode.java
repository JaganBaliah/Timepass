package org.jagan.solutions.linkedlist;

public class RemoveGiveNode {

	/*
	 * 
	 * Write a function to delete a node (except the tail) in a singly linked list,
	 * given only access to that node.
	 * 
	 * Given linked list -- head = [4,5,1,9], which looks like following: Example 1:
	 * 
	 * Input: head = [4,5,1,9], node = 5 Output: [4,1,9] Explanation: You are given
	 * the second node with value 5, the linked list should become 4 -> 1 -> 9 after
	 * calling your function. Example 2:
	 * 
	 * Input: head = [4,5,1,9], node = 1 Output: [4,5,9] Explanation: You are given
	 * the third node with value 1, the linked list should become 4 -> 5 -> 9 after
	 * calling your function.
	 * 
	 */

	public static void main(String[] args) {
		LinkedNodeList list = new LinkedNodeList();
		list.addNodes("1", "2", "3", "4", "5");
		LinkedNode linkedNode = new LinkedNode("6");
		list.addNode(linkedNode);
		list.addNodes("7", "8", "9");
		System.out.println("LinkedNodeList : " + list);
		deleteNode(linkedNode);
		System.out.println("LinkedNodeList : " + list);
	}
	
	public static void deleteNode(LinkedNode linkedNode) {
		LinkedNode next = linkedNode.next;
		linkedNode.val = next.val;
		linkedNode.next = next.next;
	}

}
