package com.my.practise.heap;

import java.util.PriorityQueue;

// 这个思路要记一下
// 基于 PriorityQueue 构造堆
// 基于快排 找出 top-K  

public class LeastNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 基于优先级队列的堆排
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public int[] getLeastNumbers1(int[] arr, int k) {
		if (k == 0) {
			return new int[0];
		}
		// 使用一个最大堆（大顶堆）
		// Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, (i1, i2) -> Integer.compare(i2, i1));

		for (int e : arr) {
			// 当前数字小于堆顶元素才会入堆
			if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
				heap.offer(e);
			}
			if (heap.size() > k) {
				heap.poll(); // 删除堆顶最大元素
			}
		}

		// 将堆中的元素存入数组
		int[] res = new int[heap.size()];
		int j = 0;
		for (int e : heap) {
			res[j++] = e;
		}
		return res;
	}

	/**
	 * 基于快排的找出 least K numbers
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public int[] getLeastNumbers(int[] arr, int k) {
		if (k == 0) {
			return new int[0];
		} else if (arr.length <= k) {
			return arr;
		}

		// 原地不断划分数组
		partitionArray(arr, 0, arr.length - 1, k);

		// 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	void partitionArray(int[] arr, int lo, int hi, int k) {
		// 做一次 partition 操作
		int m = partition(arr, lo, hi);
		// 此时数组前 m 个数，就是最小的 m 个数
		if (k == m) {
			// 正好找到最小的 k(m) 个数
			return;
		} else if (k < m) {
			// 最小的 k 个数一定在前 m 个数中，递归划分
			partitionArray(arr, lo, m - 1, k);
		} else {
			// 在右侧数组中寻找最小的 k-m 个数
			partitionArray(arr, m + 1, hi, k);
		}
	}

	// partition 函数和快速排序中相同，具体可参考快速排序相关的资料
	// 代码参考 Sedgewick 的《算法4》
	int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int v = a[lo];
		while (true) {
			while (a[++i] < v) {
				if (i == hi) {
					break;
				}
			}
			while (a[--j] > v) {
				if (j == lo) {
					break;
				}
			}

			if (i >= j) {
				break;
			}
			swap(a, i, j);
		}
		swap(a, lo, j);

		// a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}

	void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
