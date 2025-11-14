package com.design.code.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class AsteroidCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int asteroids[] = new int[] { 5, 10, -5 };
		int result[] = asteroidCollision(asteroids);

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		if (result != null) {
			for (int i = 0; i < result.length; i++) {
				arrayList.add(result[i]);
			}
		}
		System.out.println(arrayList);

		asteroids = new int[] { 8, -8 };
		result = asteroidCollision(asteroids);
		arrayList = new ArrayList<Integer>();
		if (result != null) {
			for (int i = 0; i < result.length; i++) {
				arrayList.add(result[i]);
			}
		}
		System.out.println(arrayList);

		asteroids = new int[] { 10, 2, -5 };
		result = asteroidCollision(asteroids);
		arrayList = new ArrayList<Integer>();
		if (result != null) {
			for (int i = 0; i < result.length; i++) {
				arrayList.add(result[i]);
			}
		}
		System.out.println(arrayList);

		asteroids = new int[] { 3, 5, -6, 2, -1, 4 };
		result = asteroidCollision(asteroids);
		arrayList = new ArrayList<Integer>();
		if (result != null) {
			for (int i = 0; i < result.length; i++) {
				arrayList.add(result[i]);
			}
		}
		System.out.println(arrayList);
	}

	public static int[] asteroidCollision(int[] asteroids) {
		int result[] = new int[0];

		if (asteroids == null || asteroids.length == 0) {
			return result;
		}

		ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
		arrayDeque.offer(asteroids[0]);

		for (int i = 1; i < asteroids.length; i++) {
			if (asteroids[i] < 0) {
				int tempCurrentAbsValue = Math.abs(asteroids[i]);

				boolean needToAddStack = true;
				// 这里循环是关键：
				// 如果stack的元素<0，不用继续找了，因为不会碰撞
				// else, 比较大小做对应的逻辑处理
				while (!arrayDeque.isEmpty()) {
					int currentStackValue = arrayDeque.peekLast();
					// 关键判断
					if (currentStackValue < 0) {
						break;
					}

					if (tempCurrentAbsValue > currentStackValue) {
						arrayDeque.pollLast();
					} else if (tempCurrentAbsValue == currentStackValue) {
						// 不用把当前元素加到stack 中
						arrayDeque.pollLast();
						needToAddStack = false;
						break;
					} else {
						// 不用把当前元素加到stack 中
						needToAddStack = false;
						break;
					}
				}

				// 关键判断
				if (needToAddStack) {
					arrayDeque.offer(asteroids[i]);
				}
			} else {
				arrayDeque.offer(asteroids[i]);
			}
		}

		result = new int[arrayDeque.size()];
		int index = 0;
		while (!arrayDeque.isEmpty()) {
			result[index++] = arrayDeque.pop();
		}
		return result;
	}

}
