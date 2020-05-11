package org.jagan.solutions.linkedlist;

public class DeepCopyListWithRandomPointer {

	/*
	 * 
	 * A linked list is given such that each node contains an additional random
	 * pointer which could point to any node in the list or null.
	 * 
	 * Return a deep copy of the list.
	 * 
	 * The Linked List is represented in the input/output as a list of n nodes. Each
	 * node is represented as a pair of [val, random_index] where:
	 * 
	 * val: an integer representing Node.val random_index: the index of the node
	 * (range from 0 to n-1) where random pointer points to, or null if it does not
	 * point to any node.
	 * 
	 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]] 
	 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
	 *
	 */
	public static void main(String[] args) {
		Node n0 = new Node(7);
		Node n1 = new Node(13);
		Node n2 = new Node(11);
		Node n3 = new Node(10);
		Node n4 = new Node(1);
		
		n0.random = null;
		n1.random = n0;
		n2.random = n4;
		n3.random = n2;
		n4.random = n0;
		
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		
		printLinkedList(n0);
		Node output = copyRandomList(n0);
		printLinkedList(output);
	}
	
	public static Node copyRandomList(Node head) {
        Node curr = head;
        while(curr != null) {
        	Node next = curr.next;
        	curr.next = new Node(curr.val);
        	//curr.next.random = curr.random;
        	curr.next.next = next;
        	curr = next;
        }
        curr = head;
        while(curr != null) {
        	if(curr.random != null) curr.next.random = curr.random.next;
        	curr = curr.next.next;
        }
        curr = head;
        Node output = new Node(-1);
        Node copyCurr = output;
        while(curr != null) {
        	copyCurr.next = curr.next;
        	copyCurr = copyCurr.next;
        	curr.next = curr.next.next;
        	curr = curr.next;
        }
        return output.next;
    }
	
	static class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	public static void printLinkedList(Node head) {
		Node curr = head;
		while(curr != null) {
			int cHashCode = curr.hashCode();
			int cRandomHashCode = -1;
			if(curr.random != null) cRandomHashCode = curr.random.hashCode();
			System.out.print(curr.val + "[" + cHashCode + "/" + cRandomHashCode + "] -> ");
			curr = curr.next;
		}
		System.out.println();
	}

}
