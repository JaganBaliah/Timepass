package org.jagan.solutions.az;

public class ZSubtreeOfAnotherTree {

	/*
	 * 
	 * Given two non-empty binary trees s and t, check whether tree t has exactly
	 * the same structure and node values with a subtree of s. A subtree of s is a
	 * tree consists of a node in s and all of this node's descendants. The tree s
	 * could also be considered as a subtree of itself.
	 * 
	 * Example 1: Given tree s:
	 * 
	 *       3
     *		/ \
   	 *	   4   5
  	 *	  / \
 	 *	 1   2
 	 *
 	 * Given tree t:
 	 * 
 	 *    4 
  	 *   / \
 	 *  1   2	
 	 * 	
	 * Return true, because t has the same structure and node values with a subtree of s.
	 * 
	 * 
	 * Example 2: Given tree s:
	 * 
	 *  	3
     *	   / \
   	 *	  4   5
  	 *	 / \
 	 *	1   2
     *	   /
   	 *	  0
	 *
	 * Given tree t:
	 *    4
  	 *	 / \
 	 *  1   2
	 * 
	 * Return false.
	 * 
	 */
	public static void main(String[] args) {
		TreeNode sTNode1 = new TreeNode(3);
		sTNode1.left = new TreeNode(4, new TreeNode(1), new TreeNode(2));
		sTNode1.right = new TreeNode(5);
		TreeNode tTNode1 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
		System.out.println("Is SubTree : " + isSubTree(sTNode1, tTNode1));
		
		sTNode1.left = new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null));
		System.out.println("Is SubTree : " + isSubTree(sTNode1, tTNode1));
		
		System.out.println("Is SubTree : " + isSubTree(null, null));
	}

	public static boolean isSubTree(TreeNode s, TreeNode t) {
		return false;
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode() {
			
		}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		public String toString() {
			return (left != null ? left.val : "") + "/" + this.val + "\\" + (right != null ? right.val : "");
		}
	}
}

