package org.jagan.expression;

import java.util.LinkedList;
import java.util.Queue;
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
		
	}
	
	public static void traverseLevelOrder(TreeNode root, StringBuilder bldr) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			bldr.append(node.data);
			if(node.left != null) queue.add(node.left);
			if(node.right != null) queue.add(node.right);			
		}
	}

	private static void traversePreOrder(TreeNode node, StringBuilder bldr) {
		if(node.isLeaf) {
			bldr.append(node.data);
		} else {
			bldr.append(node.data);
			traversePreOrder(node.left, bldr);
			traversePreOrder(node.right, bldr);
		}		
	}

	private static void traverseInOrder(TreeNode node, StringBuilder bldr) {
		if(node.isLeaf) {
			bldr.append(node.data);
		} else {
			traverseInOrder(node.left, bldr);
			bldr.append(node.data);
			traverseInOrder(node.right, bldr);
		}
	}

	private static void traversePostOrder(TreeNode node, StringBuilder bldr) {
		if(node.isLeaf) {
			bldr.append(node.data);
		} else {
			traversePostOrder(node.left, bldr);
			traversePostOrder(node.right, bldr);
			bldr.append(node.data);
		}
	}

	public static TreeNode populate(Scanner scanner) {
		 if(scanner.hasNextInt()) {
			return new TreeNode(scanner.next(), true);
		} else {
			String next = scanner.next();
			TreeNode node = new TreeNode(next, false);
			node.left = populate(scanner);
			node.right = populate(scanner);
			return node;
		}
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
