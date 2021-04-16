package com.java.geeks.solution.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


/*
 * 
 * 
 * Runtime Error:
Runtime ErrorTime Limit Exceeded

Your program took more time than expected.Time Limit Exceeded
Expected Time Limit 3.27sec
Hint : Please optimize your code and submit again.


 */
public class LucyNeighbours {

	public static void main(String[] args) {
		//System.out.println(diffBetweenHouseNumber(5, 10));
		//System.out.println(diffBetweenHouseNumber(5, -10));
		//System.out.println(diffBetweenHouseNumber(-10, 7));
		//System.out.println(diffBetweenHouseNumber(-1, -9));
		
		  
		int n = 91;
		int x = -6555;
		int k = 10;
		int arr[] = {4007,9880,-4034,6516,5074,9210,2759,-4971,-2506,-1194,6654,-4775,-6374,-217,1943,-4627,-6454,1641,9375,816,-7676,-4211,9343,-5188,6872,6166,3938,-7995,-9898,-6567,5271,-8944,-8506,-348,3095,-1109,-9949,7170,4553,-177,6553,3540,-7620,4011,-7189,6107,-2243,8807,-5208,4347,7695,-210,869,4454,3606,403,17,2915,1917,-4184,-5040,6348,8139,3981,957,3124,-180,-9884,-3938,-6928,-4420,-10,6307,1085,4096,-976,-7331,-9188,-6555,-8740,2412,9318,7887,7722,-1814,5563,-2389,7227,-1099,446,-6939,-7105, -7078, -7076, -7066};
		
//		int n = 6;
//		int x = 5;
//		int k = 3;
//		int arr[] = {10, 2, 14, 4, 7, 6};
		
//		int n = 4;
//		int x = 0;
//		int k = 4;
//		int arr[] = {-21, 21,4,-12, 20};
		
		
		if(-11 < -13) {
			System.out.println(true);
		}
//		int n = 5;
//		int x = -11;
//		int k = 2;
//
//		int arr[] = {-13, -10,-9,-7, -15};
//		
//		int n = 10;
//		int x = 5;
//		int k = 3;
//		int arr[] = {0, 1,2,3, 4,6,7,8,9, 10};
		
//		int n = 1;
//		int x = 89;
//		int k = 1;
//		int arr[] = {3};
		
		
		System.out.println(new LucyNeighbours().KclosestPriorityNew(arr,n,x,k));
		
	}

	
	public static class QNode {
		
		Integer house;
		Integer distance;
		
		public QNode(Integer house, Integer distance) {
			super();
			this.house = house;
			this.distance = distance;
		}
		public Integer getHouse() {
			return house;
		}
		public void setHouse(Integer house) {
			this.house = house;
		}
		public Integer getDistance() {
			return distance;
		}
		public void setDistance(Integer distance) {
			this.distance = distance;
		}
		@Override
		public String toString() {
			return "QNode [house=" + house + ", distance=" + distance + "]";
		}
	}
	
	public static class  QNodeComparator implements Comparator<QNode>{

		@Override
		public int compare(QNode o1, QNode o2) {
			if(o1.getDistance() < o2.getDistance()) {
				return -1;
			}else if(o1.getDistance() == o2.getDistance()) {
				if(o1.getHouse() < o2.getHouse()) {
					return -1;
				}else if(o2.getHouse() == o1.getHouse()) {
					return 0;
				}else {
					return 1;
				}
			}
			return 1;
		}
	}
	// n is the size of the array
	// x is the Lucy House number
	// k is the number of neighbours need to find
	// Boundry array has to be less then arr size | n

	public ArrayList<Integer> KclosestPriorityNew(int arr[], int n, int x, int k) {
		if(k < 1 && k > 100000){
	        return new ArrayList<Integer>();
	    }
	    if(n < 1 && n > 100000){
	        return new ArrayList<Integer>();
	    }
	    if( x < -10000){
	        return new ArrayList<Integer>();
	    }
	    for(int elem =0;elem<arr.length;elem++){
	        if(elem > 10000){
	            return new ArrayList<Integer>();
	        }
	    }
	    
	    PriorityQueue<QNode> priorityQueue = new PriorityQueue<QNode>(k,new QNodeComparator());
	    
		for (int i = 0; i <arr.length; i++) {
		
			QNode qNode = new QNode(arr[i], diffBetweenHouseNumber(x,arr[i]));
			priorityQueue.add(qNode);
		}
		
		if(arr.length ==1) {
			ArrayList<Integer> l1 = new ArrayList<Integer>();
			l1.add(priorityQueue.poll().getHouse());
			return l1;
		}

		ArrayList<Integer> array = new ArrayList<Integer>();
		while(!priorityQueue.isEmpty() && k > 0) {
			k--;
			QNode qNode = priorityQueue.poll();
			array.add(qNode.getHouse());
		}
		
		//Collections.sort(array);
		return array;
	}
	public ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) {
		if(k < 1 && k > 100000){
	        return new ArrayList<Integer>();
	    }
	    if(n < 1 && n > 100000){
	        return new ArrayList<Integer>();
	    }
	    if( x < -10000){
	        return new ArrayList<Integer>();
	    }
	    for(int elem =0;elem<arr.length;elem++){
	        if(elem > 10000){
	            return new ArrayList<Integer>();
	        }
	    }
	    
	    
	    PriorityQueue<QNode> priorityQueue = new PriorityQueue<QNode>(arr.length,new QNodeComparator());
		
	    
		for (int i = 0; i <arr.length; i++) {
		
			QNode qNode = new QNode(arr[i], diffBetweenHouseNumber(x,arr[i]));
			priorityQueue.add(qNode);
		}
		
//		System.out.println(priorityQueue);
//		while(!priorityQueue.isEmpty()) {
//			System.out.println(priorityQueue.poll());
//		}
		//When there is only value in the given array
		if(arr.length ==1) {
			ArrayList<Integer> l1 = new ArrayList<Integer>();
			l1.add(priorityQueue.poll().getHouse());
			return l1;
		}

		
		//Set<QNode> arrayList = new HashSet<QNode>();
		
		
//		while(!priorityQueue.isEmpty() && k >= 0) {
//			k--;
//			QNode temp = priorityQueue.poll();
//			if(qNode.getDistance() != temp.getDistance()) {
//				if(!arrayList.contains(qNode)){
//					arrayList.add(qNode);
//				}
//				qNode = temp;
//			}else if(qNode.getDistance() == temp.getDistance()) {
//				if(arrayList.contains(qNode)){
//					continue;
//				}else {
//					arrayList.add(qNode);
//				}
//			}
//		}
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		while(!priorityQueue.isEmpty() && k > 0) {
			k--;
			QNode qNode = priorityQueue.poll();
			array.add(qNode.getHouse());
		}
		
//		for(QNode qN: arrayList) {
//			array.add(qN.getHouse());
//		}
		Collections.sort(array);
		return array;
	}

	public static int diffBetweenHouseNumber(int x, int y) {
		String SIGN = null;
		int result = Integer.MIN_VALUE;
		if (x < 0 && y < 0) {
			SIGN = "NEG_NEG";
		} else if (x < 0 && y > 0) {
			SIGN = "NEG_POS";
		} else if (x >= 0 && y >= 0) {
			SIGN = "POS_POS";
		} else if (x >= 0 && y < 0) {
			SIGN = "POS_NEG";
		}

		switch (SIGN) {

		case "NEG_NEG":
			if (x > y) {
				y = y * -1;
				result = x + y;
			} else {
				x = x * -1;
				result = y + x;
			}
			break;

		case "NEG_POS":
			x = x * -1;
			result = x + y;
			break;

		case "POS_POS":
			if (x > y) {
				result = x - y;
			} else {
				result = y - x;
			}
			break;

		case "POS_NEG":
			y = y * -1;
			result = x + y;
			break;

		}
		return result;
	}

}
