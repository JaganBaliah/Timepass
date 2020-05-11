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
			Trie current = root;
			for(char ch : key.toCharArray()) {
				int index = ch - 'a';
				if(current.childrens[index] == null) {
					current.childrens[index] = new Trie();
				}
				current = current.childrens[index];
			}
			current.isEow = true;
		}
	}

	private static boolean search(Trie root, String string) {
		Trie current = root;
		for(char ch : string.toCharArray()) {
			int index = ch - 'a';
			if(current.childrens[index] == null) return false;
			current = current.childrens[index];
		}
		if(current.isEow) return true;
		return false;
	}
	
	static class Trie {
		int childCount = 26;
		Trie[] childrens;
		boolean isEow;
		
		Trie() {
			childrens = new Trie[childCount];
		}
	}
	
}
