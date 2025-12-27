package com.algo.practise.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class GoodNotesTest {

	static class DependencyData {
		int pendingToAddValue;
		ArrayList<Integer> dependencyList;

		public DependencyData(int pendingToAddValue, ArrayList<Integer> dependencyList) {
			this.pendingToAddValue = pendingToAddValue;
			this.dependencyList = dependencyList;
		}
	}

	private static LinkedHashSet<Integer> currentStateSet = new LinkedHashSet<Integer>();
	private static LinkedList<DependencyData> pendToAddList = new LinkedList<DependencyData>();
	
	// 5 -> [4, 3]
	// key -> 4, 5
	// key -> 3, 5
	private static LinkedHashMap<Integer, Integer> dependencyMap = new LinkedHashMap<Integer, Integer>();

	// map
//	private static LinkedHashMap<Integer, DependencyData> pendToAddMap = new LinkedHashMap<Integer, DependencyData>();

//	add(1)
//	get_current_state() returns [1]
//	add(2, dependency: [1])
//	get_current_state() returns [1, 2]
//	add(5, dependency: [4, 3])
//	get_current_state() returns [1, 2]
//	add(4, dependency: [1])
//	get_current_state() returns [1, 2, 4]
//	add(3)
//	get_current_state() returns [1, 2, 4, 3, 5]

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = 1;
		ArrayList<Integer> dependencyList = null;
		add(value, dependencyList);
		ArrayList<Integer> resultList = getCurrentState();
		System.out.println(resultList);

		value = 2;
		dependencyList = new ArrayList<Integer>();
		dependencyList.add(1);
		add(value, dependencyList);
		resultList = getCurrentState();
		System.out.println(resultList);

		value = 5;
		dependencyList = new ArrayList<Integer>();
		dependencyList.add(4);
		dependencyList.add(3);
		add(value, dependencyList);
		resultList = getCurrentState();
		System.out.println(resultList);

		value = 4;
		dependencyList = new ArrayList<Integer>();
		dependencyList.add(1);
		add(value, dependencyList);
		resultList = getCurrentState();
		System.out.println(resultList);

		value = 3;
		dependencyList = new ArrayList<Integer>();
		add(value, dependencyList);
		resultList = getCurrentState();
		System.out.println(resultList);
	}

	public static void add(int value, ArrayList<Integer> dependencyList) {
		if (dependencyList == null || dependencyList.size() == 0) {
			currentStateSet.add(value);
			tryToRemovePendingList(value, dependencyList);
			return;
		}

		boolean isCanAdd = true;
		for (int i = 0; i < dependencyList.size(); i++) {
			if (!currentStateSet.contains(dependencyList.get(i))) {
				isCanAdd = false;
				break;
			}
		}

		if (isCanAdd) {
			currentStateSet.add(value);
		} else {
			DependencyData dependencyData = new DependencyData(value, dependencyList);
			pendToAddList.add(dependencyData);
		}

		tryToRemovePendingList(value, dependencyList);
	}

	public static ArrayList<Integer> getCurrentState() {
		Iterator<Integer> iterator = currentStateSet.iterator();

		ArrayList<Integer> currentStateList = new ArrayList<Integer>();
		while (iterator.hasNext()) {
			int value = iterator.next();
			currentStateList.add(value);
		}

		return currentStateList;
	}

	private static void tryToRemovePendingList(int value, ArrayList<Integer> rawDependencyList) {
		LinkedList<DependencyData> toRemoveList = new LinkedList<GoodNotesTest.DependencyData>();

		for (int i = 0; i < pendToAddList.size(); i++) {
			DependencyData dependencyData = pendToAddList.get(i);
			ArrayList<Integer> dependencyList = dependencyData.dependencyList;

			if (dependencyList == null) {
				toRemoveList.add(dependencyData);
				continue;
			}

			boolean canRemove = true;
			for (int k = 0; k < dependencyList.size(); k++) {
				if (!currentStateSet.contains(dependencyList.get(k))) {
					canRemove = false;
				}
			}

			if (canRemove) {
				toRemoveList.add(dependencyData);
			}
		}

		System.out.println(
				"value:" + value + " ; rawDependencyList:" + rawDependencyList + " ; toRemoveList:" + toRemoveList);

		Iterator<DependencyData> iterator = toRemoveList.iterator();
		while (iterator.hasNext()) {
			DependencyData tempData = iterator.next();
			pendToAddList.remove(tempData);
			currentStateSet.add(tempData.pendingToAddValue);
		}
	}

}
