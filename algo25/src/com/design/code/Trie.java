package com.design.code;

import java.util.HashMap;

public class Trie {

	// 字典树的原始结构是 26 个字母的数组指针，但是会存在空间浪费，所以 hashmap 是优化版本
	// 字典树的典型使用场景：搜索的前缀匹配，输入法，拼写检查等
	// 理解下这个数据结构
	static class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<>();
		boolean isEnd = false;
	}

	private TrieNode root = new TrieNode();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void insert(String word) {
		TrieNode node = root;  // 从根节点开始

		for (char c : word.toCharArray()) {
			if (!node.children.containsKey(c)) {
				node.children.put(c, new TrieNode());
			}

			node = node.children.get(c);  // ← 移动到子节点
		}

		node.isEnd = true;
	}

	public boolean search(String word) {
		TrieNode node = root;  // 从根节点开始

		for (char c : word.toCharArray()) {
			if (!node.children.containsKey(c)) {
				return false;  // 子节点不存在
			}

			node = node.children.get(c);  // ← 移动到子节点
		}

		return node.isEnd;
	}

}
