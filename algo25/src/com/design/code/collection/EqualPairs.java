package com.design.code.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class EqualPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = new int[][] { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } };
		int result = equalPairs(grid);
		System.out.println(result);
	}

	public static int equalPairs(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		HashMap<Integer, String> rowHashMap = new HashMap<Integer, String>();
		for (int i = 0; i < grid.length; i++) {
			int row[] = grid[i];

			StringBuilder stringBuilder = new StringBuilder();
			for (int j = 0; j < row.length; j++) {
				stringBuilder.append(row[j] + ",");
			}
			rowHashMap.put(i, stringBuilder.toString());
		}

		HashMap<Integer, String> columnHashMap = new HashMap<Integer, String>();
		int columns = grid[0].length;
		for (int i = 0; i < columns; i++) {
			int column[] = getColumn(grid, i);

			StringBuilder stringBuilder = new StringBuilder();
			for (int j = 0; j < column.length; j++) {
				stringBuilder.append(column[j] + ",");
			}
			columnHashMap.put(i, stringBuilder.toString());
		}

		int count = 0;
		Iterator<Entry<Integer, String>> rowIterator = rowHashMap.entrySet().iterator();
		while (rowIterator.hasNext()) {
			Entry<Integer, String> entry = rowIterator.next();

			Iterator<Entry<Integer, String>> columnIterator = columnHashMap.entrySet().iterator();
			while (columnIterator.hasNext()) {
				Entry<Integer, String> tempEntry = columnIterator.next();
				if (tempEntry.getValue().equals(entry.getValue())) {
					count++;
				}
			}
		}

		return count;
	}

	public static int[] getColumn(int[][] matrix, int colIndex) {
		int[] column = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			column[i] = matrix[i][colIndex];
		}
		return column;
	}

}
