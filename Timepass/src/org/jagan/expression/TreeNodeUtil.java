package org.jagan.expression;

import java.util.Scanner;

public class TreeNodeUtil {

	public static void main(String[] args) {

		/*
		 * 								-
		 * 
		 * 
		 * 
		 * 					+						1
		 * 							
		 * 			-				-
		 *
		 * 		3		2		5		4
		 * 
		 * 
		 * 
		 */
		
		String preFixInput = "- + - 3 2 - 5 4 1";
		//String preFixInput = "- 3 2";
		Scanner scanner = new Scanner(preFixInput);
		scanner.useDelimiter(" ");
		TNode tNode = build(scanner);
		System.out.println(tNode);
		
		/*
		System.out.println("In Order : ");
		traverseInOrder(tNode);
		System.out.println("Pre Order : ");
		traversePreOrder(tNode);
		System.out.println("Post Order : ");
		traversePostOrder(tNode);
		*/
		
		System.out.println("Printing InOrder LNR : " + getInOrder(tNode));
		System.out.println("Printing PreOrder NLR : " + getPreOrder(tNode));
		System.out.println("Printing PostOrder LRN : " + getPostOrder(tNode));

		System.out.println(evaluate(tNode));
	
	}

	private static int evaluate(TNode tNode) {
		int result = 0;
		if(tNode.isLeaf) {
			return Integer.parseInt(tNode.value);
		} else {
			int leftVal = evaluate(tNode.left);
			int rightVal = evaluate(tNode.right);
			if(tNode.value.charAt(0) == '+') result = leftVal + rightVal;
			if(tNode.value.charAt(0) == '-') result = leftVal - rightVal;
			if(tNode.value.charAt(0) == '*') result = leftVal * rightVal;
			if(tNode.value.charAt(0) == '/') result = leftVal / rightVal;
		}
		return result;
	}
	
	private static String getInOrder(TNode tNode) {
		return printInOrder(tNode, new StringBuilder("")).toString();
		
	}
	
	private static StringBuilder printInOrder(TNode tNode, StringBuilder bldr) {
		
		if(tNode != null) {
			printInOrder(tNode.left, bldr);
			bldr.append(tNode.value);
			printInOrder(tNode.right, bldr);
		}
		return bldr;
		/*
		if(tNode.isLeaf) {
			bldr.append(tNode.value);
		} else {
			printInOrder(tNode.left, bldr);	
			bldr.append(tNode.value);
			printInOrder(tNode.right, bldr);
		}
		return bldr;
		*/
	}

	private static String getPreOrder(TNode tNode) {
		return printPreOrder(tNode, new StringBuilder("")).toString();
		
	}
	
	private static StringBuilder printPreOrder(TNode tNode, StringBuilder bldr) {
		if(tNode != null) {
			bldr.append(tNode.value);
			printPreOrder(tNode.left, bldr);			
			printPreOrder(tNode.right, bldr);
		}
		return bldr;
	}


	private static String getPostOrder(TNode tNode) {
		return printPostOrder(tNode, new StringBuilder("")).toString();
		
	}
	
	private static StringBuilder printPostOrder(TNode tNode, StringBuilder bldr) {
		if(tNode != null) {
			printPostOrder(tNode.left, bldr);			
			printPostOrder(tNode.right, bldr);
			bldr.append(tNode.value);			
		}
		return bldr;
	}

	@SuppressWarnings("unused")
	private static void traverseInOrder(TNode tNode) {
		inOrder(tNode);
	}
	
	private static void inOrder(TNode tNode) {
		if(tNode != null) {
			inOrder(tNode.left);
			System.out.println(tNode.value);
			inOrder(tNode.right);
		}
		
	}
	
	@SuppressWarnings("unused")
	private static void traversePreOrder(TNode tNode) {
		preOrder(tNode);
	}
	
	private static void preOrder(TNode tNode) {
		if(tNode != null) {
			System.out.println(tNode.value);
			preOrder(tNode.left);
			preOrder(tNode.right);
		}
	}
	
	@SuppressWarnings("unused")
	private static void traversePostOrder(TNode tNode) {
		postOrder(tNode);
	}
	
	private static void postOrder(TNode tNode) {
		if(tNode != null) {
			postOrder(tNode.left);			
			postOrder(tNode.right);
			System.out.println(tNode.value);
		}
	}
	private static TNode build(Scanner scanner) {
		TNode tNode = null;
		if(scanner.hasNextInt()) {
			int nextInt = scanner.nextInt();
			return new TNode(nextInt+"", true);
		} else {
			String next = scanner.next();
			tNode = new TNode(next, false);
			tNode.left = build(scanner);
			tNode.right = build(scanner);
		}
		return tNode;
	}
	
	static class TNode {
		TNode left;
		TNode right;
		String value;
		boolean isLeaf;

		public TNode(String value, boolean isLeaf) {
			this.value = value;
			this.isLeaf = isLeaf;
		}

		public void addNode(String value, TNode left, TNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

	}
}


	
