package org.jagan.datastructures;

public class ZTrieUtil {

	public static void main(String[] args) {
		//String[] keys = new String[] {"apple", "ball", "cat", "apply", "bat", "batch"};
		String[] keys = new String[] {"ball", "bat"};
		Trie root = new Trie();
		insert(root, keys);
		System.out.println(root);
		boolean found = false;
		
		found = search(root, "bat");
		System.out.println("bat :" + found);
		found = search(root, "ball");
		System.out.println("ball :" + found);
		found = search(root, "bal");
		System.out.println("bal :" + found);
		
	}
	
	public static void insert(Trie root, String[] keys) {
		for(String key : keys) {
			//key.chars().forEach();
			Trie current = root;
			for(int i = 0 ; i < key.length(); i++) {
				char ch = key.charAt(i);
				int index = ch - 'a';
				if(current.childrens[index] == null) {
					current.childrens[index] = new Trie();					
				}
				current = current.childrens[index];
			}
			current.isEOW = true;
		}
	}
	
	public static boolean search(Trie root, String str) {
		Trie current = root;
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int index = ch - 'a';
			Trie trie = current.childrens[index];
			if(trie == null) return false;
			current = trie; 
		}
		if(!current.isEOW) return false;		
		return true;
	}
	
	static class Trie {
		static int CHARACTER_SIZE = 26;
		Trie[] childrens = new Trie[CHARACTER_SIZE];
		boolean isEOW;
		
		public Trie() {	
					}
	}
	
}
