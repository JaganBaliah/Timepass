package org.jagan.solutions.linkedlist;

public class LinkedNode {

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
