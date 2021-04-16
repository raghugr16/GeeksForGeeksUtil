package com.java.geeks.solution.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution
{
    ArrayList<Integer>TopK(ArrayList<Integer> array, int k)
    {
        // code here
        ArrayList<Integer> result = new ArrayList<>();

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.size(); i++) {
			if (map.containsKey(array.get(i))) {
				map.put(array.get(i), map.get(array.get(i)) + 1);
			} else {
				map.put(array.get(i), 1);
			}
		}

		List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if (o1.getValue() == o2.getValue()) {
					if (o1.getKey() < o2.getKey()) {
						return +1;
					}
					if (o1.getKey() > o2.getKey()) {
						return -1;
					}
					return 0;
				} else {

					if (o1.getValue() < o2.getValue()) {
						return +1;
					}
					if (o1.getValue() > o2.getValue()) {
						return -1;
					}
					return 0;
				}
			}
		});

		for (int i = 0; i < k; i++) {
			result.add(list.get(i).getKey());
		}

		return result;
    }
}

