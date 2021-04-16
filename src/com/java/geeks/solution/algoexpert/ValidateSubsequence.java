package com.java.geeks.solution.algoexpert;

import java.util.*;

public class ValidateSubsequence {

	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		// Write your code here.
		Integer sequenceLength = sequence.size();
		for (Integer i = 0; i < array.size(); i++) {
			int counter = 0;
			int k = i;
			for (Integer j = 0; j < sequence.size(); j++) {
				if (array.get(k) == sequence.get(j)) {
					counter++;
					k++;
				} else {
					break;
				}
			}
			if (counter == sequenceLength) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidSubsequence1(List<Integer> array, List<Integer> sequence) {
		// Write your code here.
		Integer sequenceLength = sequence.size();
		int counter = 0;
		for (Integer i = 0; i < array.size(); i++) {
			if (counter == sequenceLength) {
				return true;
			}
			if (array.get(i) == sequence.get(counter)) {
				counter++;
			}
		}
		if (counter == sequenceLength) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 1, 22, 25, 6, -1, 8, 10 };
		int res[] = {1,6,-1,10};
		//int res[] = { 22, 25, 6 };

		List<Integer> array = new ArrayList<>();
		List<Integer> sequence = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			array.add(arr[i]);
		}

		for (int i = 0; i < res.length; i++) {
			sequence.add(res[i]);
		}
		System.out.println(isValidSubsequence1(array, sequence));
	}
}
