package org.jagan.solutions.linkedlist;

public class LinkedNodeList {

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