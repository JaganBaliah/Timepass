package org.jagan.datastructures;

public class TrieUtil {

	public static void main(String[] args) {
		String[] input = new String[] {"ant", "ball", "bat"};
		TrieNode root = populate(input);
		System.out.println("ant exist : " + search("ant", root));
		System.out.println("ball exist : " + search("ball", root));
		System.out.println("bat exist : " + search("bat", root));
		System.out.println("bal exist : " + search("bal", root));
	}
	
	public static TrieNode populate(String[] input) {
		TrieNode root = new TrieNode();
		for(String str : input) {
			char[] chars = str.toCharArray();
			TrieNode current = root;
			for(char ch : chars) {
				int index = ch - 'a';
				if(current.childrens[index] == null) {
					current.childrens[index] = new TrieNode();					
				}
				current = current.childrens[index];
			}
			if(current != root) current.isEOW = true;
		}
		return root;
	}
	
	public static boolean search(String str, TrieNode root) {
		char[] chars = str.toCharArray();
		TrieNode current = root;
		for(char ch : chars) {
			int index = ch - 'a';			
			if(current.childrens[index] == null) return false;
			current = current.childrens[index];
		}
		if(current.isEOW) return true;
		return false;
	}
	
	static class TrieNode {
		static int SIZE = 26;
		TrieNode[] childrens;
		boolean isEOW;
		
		public TrieNode() {
			childrens = new TrieNode[SIZE];
		}
	}
}
