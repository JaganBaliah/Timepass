package org.jagan.expression;

import java.util.Scanner;

public class ZTreeNodeUtil {

	public static void main(String[] args) {
		TreeNode node = populate(new Scanner("- + - 3 2 - 5 4 1"));
		System.out.println(node);
		StringBuilder bldr = null;
		
		bldr = new StringBuilder();
		traverseLevelOrder(node, bldr);
		System.out.println("Level Order : " + bldr.toString());
		
		bldr = new StringBuilder();
		traversePreOrder(node, bldr);
		System.out.println("Pre Order : " + bldr.toString());
		
		bldr = new StringBuilder();
		traverseInOrder(node, bldr);
		System.out.println("In Order : " + bldr.toString());
		
		bldr = new StringBuilder();
		traversePostOrder(node, bldr);
		System.out.println("Post Order : " + bldr.toString());
		
		System.out.println(evaluate(node));
	}
	
	public static void traverseLevelOrder(TreeNode root, StringBuilder bldr) {
		
	}

	private static void traversePreOrder(TreeNode node, StringBuilder bldr) {
		
	}

	private static void traverseInOrder(TreeNode node, StringBuilder bldr) {
		
	}

	private static void traversePostOrder(TreeNode node, StringBuilder bldr) {
		
	}

	public static TreeNode populate(Scanner scanner) {
		return null;
	}

	public static int evaluate(TreeNode node) {
		return 0;
	}

	static class TreeNode {
		String data;
		TreeNode left;
		TreeNode right;
		boolean isLeaf;
		
		TreeNode(String data, boolean isLeaf) {
			this.data = data;
			this.isLeaf = isLeaf;
		}
	}
}
