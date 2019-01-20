package org.jagan.expression;

public class ZLinkedListUtil {
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList(new LinkedList.Node("Root"));
		list.addNode(new LinkedList.Node("1"));
		list.addNode(new LinkedList.Node("2"));
		list.addNode(new LinkedList.Node("3"));
		list.addNode(new LinkedList.Node("4"));
		list.addNode(new LinkedList.Node("5"));
		list.addNode(new LinkedList.Node("6"));
		//list.addNode(new LinkedList.Node("7"));
		
		LinkedList.Node middleNode = findMiddle(list);
		System.out.println("Middle Node : " + middleNode.data);
	}
	
	public static LinkedList.Node findMiddle(LinkedList list) {
		LinkedList.Node current = list.head;
		LinkedList.Node middle = list.head;
		int i = 1;
		while(current.next != null) {
			current = current.next;
			if(i % 2 == 0) middle = middle.next;
			i++;
		}
		return middle;
	}
	
	static class LinkedList {
		
		Node head;
		Node tail;
		
		public LinkedList(Node node) {
			this.head = this.tail = node;
		}
		
		public void addNode(Node node) {
			this.tail.next = node;
			this.tail = node;
		}
		
		static class Node {
			String data;
			Node next;
			
			public Node(String data) {
				this.data = data;
			}
		}
	}
}
