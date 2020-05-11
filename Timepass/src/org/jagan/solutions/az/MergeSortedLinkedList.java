package org.jagan.solutions.az;

public class MergeSortedLinkedList {

	/*
	 * 
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 * 
	 * Example:
	 * 
	 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
	 * 
	 */
	public static void main(String[] args) {
		LinkedNodeList list1 = new LinkedNodeList();
		list1.addNodes("1", "2", "4");
		System.out.println("LinkedNodeList - 1 : " + list1);
		LinkedNodeList list2 = new LinkedNodeList();
		list2.addNodes("1", "3", "4");
		System.out.println("LinkedNodeList - 2 : " + list2);
		LinkedNode head = recursiveMergeSortedList(list1.head, list2.head);
		LinkedNodeList list = new LinkedNodeList(head);
		System.out.println("LinkedNodeList : " + list);

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
	
	static class LinkedNode {

		String val;
		LinkedNode next;
		
		public LinkedNode(String val) {
			this.val = val;
		}
		
		public LinkedNode(String val, LinkedNode next) {
			this.val = val;
			this.next = next;
		}
		
		public String getVal() {
			return this.val;
		}
		
		public LinkedNode getNext() {
			return this.next;
		}
		
		public void setVal(String val) {
			this.val = val;
		}
		
		public void setNext(LinkedNode next) {
			this.next = next;
		}
		
		public String toString() {
			return val;
		}
		
	}
	
	static class LinkedNodeList {

		LinkedNode head;
		LinkedNode tail;
		
		public LinkedNodeList() {
			this.head = this.tail = null;
		}
		
		public LinkedNodeList(LinkedNode head) {
			this.head = head;
		}
		
		public void addNode(String value) {
			addNode(new LinkedNode(value));
		}
		
		public void addNodes(String...values) {
			LinkedNode[] nodes = new LinkedNode[values.length];
			int i = 0;
			for(String value : values) {
				nodes[i++] = new LinkedNode(value);
			}
			addNodes(nodes);
		}
		
		public void addNode(LinkedNode linkedNode) {
			if(head == null) {
				head = tail = linkedNode;
			} else {
				tail.next = linkedNode;
				tail = tail.next;
			}
		}
		
		public void addNodes(LinkedNode...linkedNodes) {
			for(LinkedNode linkedNode : linkedNodes) addNode(linkedNode);
		}
		
		public void deleteNode(LinkedNode listNode) {
			LinkedNode next = listNode.next;
			listNode.val = next.val;
			listNode.next = next.next;
		}
		
		public void deleteNodeFromEndAt(int n) {
			LinkedNode currentNode = head;
			LinkedNode advancedNode = head;
			while(n > 0) {
				if(advancedNode == null) return;
				advancedNode = advancedNode.next;
				n--;
			}
			if(advancedNode == null) {
				head = head.next;
				return;
			}
			while(advancedNode.next != null) {
				currentNode = currentNode.next;
				advancedNode = advancedNode.next;
			}
			currentNode.next = currentNode.next.next;
		}
		
		public String toString() {
			LinkedNode current = head;
			StringBuilder value = new StringBuilder("[");
			while(current != null) {
				value.append(current.val);
				value.append(" -> ");
				current = current.next;
			}
			if(value.length() > 2) value = value.delete(value.length() - 4, value.length());
			value.append("]");
			return value.toString();
		}
		
	}

}
