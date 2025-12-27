package com.design.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SuggestedProducts {

	// 字典树节点
	private class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<>();
		boolean isEnd = false;
		String word = "";  // 存储完整单词（方便收集）
	}

	private TrieNode root = new TrieNode();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 实现有点复杂，理解清楚大概的搜索字符串的逻辑
	// 1，首先很自然的想到，字符串的存储可以基于字典树
	// 2，字典树的查找是比较容易的，就是基于node 的children 做遍历就好了
	// 3，找到了字典树的最后一个匹配节点后，关键怎么找到所有的单词，依赖dfs
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		// 第1步：将所有产品插入字典树
		for (String product : products) {
			insert(product);
		}

		List<List<String>> result = new ArrayList<>();

		// 第2步：对每个前缀进行搜索
		for (int i = 0; i < searchWord.length(); i++) {
			String prefix = searchWord.substring(0, i + 1);
			List<String> suggestions = search(prefix);
			result.add(suggestions);
		}

		return result;
	}

	// 插入单词到字典树
	private void insert(String word) {
		TrieNode node = root;

		for (char c : word.toCharArray()) {
			node.children.putIfAbsent(c, new TrieNode());
			node = node.children.get(c);
		}

		node.isEnd = true;
		node.word = word;  // 存储完整单词
	}

	// 搜索以 prefix 开头的所有单词
	private List<String> search(String prefix) {
	        List<String> result = new ArrayList<String>();
	        TrieNode node = root;
	        
	        // 第1步：找到前缀对应的节点
	        for (char c : prefix.toCharArray()) {
	            if (!node.children.containsKey(c)) {
	                return result;  // 前缀不存在，返回空
	            }
	            node = node.children.get(c);
	        }
	        
	        // 第2步：从这个节点开始，收集所有单词
	        dfs(node, result);
	        
	        // 第3步：排序并取前3个
	        Collections.sort(result);
	        return result.subList(0, Math.min(3, result.size()));
	    }

	// DFS 收集所有单词
	private void dfs(TrieNode node, List<String> result) {
		if (node.isEnd) {
			result.add(node.word);
		}

		for (TrieNode child : node.children.values()) {
			dfs(child, result);
		}
	}

}
