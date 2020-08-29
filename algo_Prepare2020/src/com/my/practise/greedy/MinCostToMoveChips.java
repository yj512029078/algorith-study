package com.my.practise.greedy;

// 注意理解下思路：既然移动偶数步没代价；那最终代价就是 奇数/偶数 互相移动
// 贪心的一类问题：很多时候是一些策略问题

public class MinCostToMoveChips {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] chips = new int[] { 2, 2, 2, 3, 3 };
		int minCost = minCostToMoveChips(chips);
		System.out.println("minCost: " + minCost);
	}

	// 仔细理解下思路；是不是最终代价就是 even -> old / old -> even 代价
	public static int minCostToMoveChips(int[] position) {
		if ((position == null) || (position.length == 0)) {
			return 0;
		}

		// 偶数
		int even = 0;
		// 奇数
		int old = 0;
		for (int i = 0; i < position.length; i++) {
			if (position[i] % 2 == 0) {
				even++;
			} else {
				old++;
			}
		}

		return Math.min(even, old);
	}

}
