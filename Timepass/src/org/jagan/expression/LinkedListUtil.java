package org.jagan.expression;

public class LinkedListUtil {

	public static void main(String[] args) {
		LList llist = new LList();
		llist.add(new LList.Node("1"));
		llist.add(new LList.Node("2"));
		llist.add(new LList.Node("3"));
		llist.add(new LList.Node("4"));
		llist.add(new LList.Node("5"));
		System.out.println(findMiddle(llist));		
	}
	
	public static String findMiddle(LList llist) {
		LList.Node current = llist.head.next;
		LList.Node middle = current;
		int i = 1;
		while(current.next != null) {
			current = current.next;
			if(i++ % 2 == 0) middle = middle.next;
			
		}		
		return middle.getValue();
	}
}

class LList {
	
	Node head;
	Node tail;
	
	public LList() {
		this.head = new Node("HEAD");
		tail = head;
	}
	
	public void add(Node node) {
		tail.next = node;
		tail = node;
	}
	
	public static class Node {
		String value;
		Node next;
		
		public Node(String value) {
			this.value = value;
			this.next = null;
		}
		
		public String getValue() {
			return value;
		}
		
		public void setNext(Node node) {
			next = node;
		}
		
	}
}