package com.java.geeks.solution.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Stack;


/*
 * In Doraland, people have unique Identity Numbers called D-id. Doraemon 
 * owns the most popular gadget shop in Doraland. Since his gadgets are in 
 * high demand and he has only K gadgets left he has decided to sell his gadgets 
 * to his most frequent customers only. N customers visit his shop and D-id of 
 * each customer is given in an array array[ ]. In case two or more people have 
 * visited his shop the same number of time he gives priority to the customer 
 * with higher D-id. Find the D-ids of people he sells his K gadgets to.
 */

class TreeMapSortByValue implements Comparator<java.util.Map.Entry<Integer, Integer>> {

	@Override
	public int compare(java.util.Map.Entry<Integer, Integer> o1, java.util.Map.Entry<Integer, Integer> o2) {
		if (o1.getValue() == o2.getValue()) {
			if (o1.getKey() > o2.getKey()) {
				return +1;
			}
			if (o1.getKey() < o2.getKey()) {
				return -1;
			}
			return 0;
		} else {

			if (o1.getValue() > o2.getValue()) {
				return +1;
			}
			if (o1.getValue() < o2.getValue()) {
				return -1;
			}
			return 0;
		}
	}

}



public class SellGadget {

	ArrayList<Integer> TopK(ArrayList<Integer> array, int k) {

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

		PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<Map.Entry<Integer, Integer>>(k,
				new TreeMapSortByValue());
		
		for (int i = 0; i < k; i++) {
			priorityQueue.add(list.get(i));
		}

		for (int i = k; i < list.size(); i++) {
			if (priorityQueue.peek().getValue() > list.get(i).getValue())
				continue;
			
			if (priorityQueue.peek().getValue() == list.get(i).getValue()) {
				if (priorityQueue.peek().getKey() > list.get(i).getKey()) {
					continue;
				}
			}
			
			priorityQueue.poll();
			priorityQueue.add(list.get(i));

		}

		Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
		while (!priorityQueue.isEmpty()) {
			stack.add(priorityQueue.poll());
		}
		while(!stack.isEmpty()) {
			result.add(stack.pop().getKey());
		}

		return result;
	}

	ArrayList<Integer> TopK1(ArrayList<Integer> array, int k) {

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
		Collections.sort(list, new MapSortByValue());
		for (int i = 0; i < k; i++) {
			result.add(list.get(i).getKey());
		}

		return result;
	}

	public static void main(String[] args) {
//		int k = 2;
//		int arr[] = { 1, 1, 2, 2, 3, 3, 3, 4 };

//		int k = 4;
//		int arr[] = { 4, 3, 4, 4, 2, 1, 4, 5, 1, 5 };
		
//		int k = 1;
//		int arr[] = { 5, 1, 2, 3 };
		
		int n=8;
		int k =1;
		int arr[] = {4, 3, 5, 4, 3, 5, 4, 3};

		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			array.add(arr[i]);
		}
		SellGadget gadget = new SellGadget();

		ArrayList<Integer> result = gadget.TopKSolution(array, k);
		System.out.println(result);
	}
	
	ArrayList<Integer>TopKSolution(ArrayList<Integer> array, int k)
	{
	    int i,j=0;
	    int arr[] = new int[10002];
	    for(i=0;i<10002;i++)
	        arr[i] = 0;
	        
	    for(i=0;i<array.size();i++)
	        arr[array.get(i)]++;
	    
	    
	    ArrayList<Integer>res[] = new ArrayList[100002];
	    for(i=0;i<100002;i++)
	        {
	            ArrayList<Integer>temp = new ArrayList<Integer>();
	            res[i]=temp;
	        }
	    for(i=0;i<10002;i++)
	        {
	            if(arr[i]!=0)
	                {
	                    res[arr[i]].add(i);
	                }
	                
	        }
	        
	    ArrayList<Integer>ans = new ArrayList<Integer>();
	    for(i=100001;i>=0;i--)
	        {
	            for(int p = res[i].size()-1;p>=0;p--)
	                {
	                    if(j!=k)
	                        ans.add(res[i].get(p));
	                    else
	                        break;
	                    j++;
	                }
	        }
	    return ans;
	}
}



class MapSortByValue implements Comparator<Map.Entry<Integer, Integer>> {

	@Override
	public int compare(java.util.Map.Entry<Integer, Integer> o1, java.util.Map.Entry<Integer, Integer> o2) {
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
}
