package com.design.code.other;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DeckRevealedIncreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// LeetCode 950 - Reveal Cards In Increasing Order 解题思路
	public int[] deckRevealedIncreasing(int[] deck) {
		Arrays.sort(deck); // 排序得到目标序列

		Deque<Integer> deque = new ArrayDeque<Integer>();

		// 从最大的数开始逆向构造
		for (int i = deck.length - 1; i >= 0; i--) {
			// 如果队列不为空，将队尾元素移到队首（逆向操作）
			if (!deque.isEmpty()) {
				deque.addFirst(deque.removeLast());
			}
			// 将当前元素加到队首
			deque.addFirst(deck[i]);
		}

		return deque.stream().mapToInt(i -> i).toArray();
	}

}
