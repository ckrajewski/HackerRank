package com.CrackingTheCodingInterview;

import java.util.HashMap;
import java.util.Scanner;

public class TrieProblem {

	public class TrieNode {
		char c;
		public int longestWordLengthFromHere = 0;
		public int wordCount = 0;
		public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		public boolean isLeaf;

		public TrieNode(Character c) {
			this.c = c;
			this.wordCount = 1;
		}

		public TrieNode() {
		}

	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insertWord(String word) {
			HashMap<Character, TrieNode> children = root.children;

			for (int i = 0; i < word.length(); i++) {
				TrieNode t;

				if (children.containsKey(word.charAt(i))) {
					t = children.get(word.charAt(i));
					t.wordCount++;
					if (t.longestWordLengthFromHere < word.length() - i) {
						t.longestWordLengthFromHere = word.length() - i;
					}
					children.put(word.charAt(i), t);
				} else {
					t = new TrieNode(word.charAt(i));
					if (t.longestWordLengthFromHere < word.length() - i) {
						t.longestWordLengthFromHere = word.length() - i;
					}
					children.put(word.charAt(i), t);
				}
				children = t.children;
				if (i == word.length() - 1) {
					t.isLeaf = true;
				}

			}
		}

		public void findWord(String word) {
			HashMap<Character, TrieNode> children = root.children;
			TrieNode tn = null;
			for (int i = 0; i < word.length(); i++) {
				if (children.containsKey(word.charAt(i))) {
					tn = children.get(word.charAt(i));
					if (tn.longestWordLengthFromHere < word.length() - i) {
						System.out.println(0);
						return;
					}
					children = children.get(word.charAt(i)).children;
				} else {
					System.out.println(0);
					return;
				}
			}
			System.out.println(tn.wordCount);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Trie trie = new TrieProblem().new Trie();
		int n = in.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();

			if (op.equals("add")) {
				trie.insertWord(contact);
			} else if (op.equals("find")) {
				trie.findWord(contact);
			}
		}
	}
}
