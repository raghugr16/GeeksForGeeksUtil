package com.java.geeks.solution.Arrays;

public class MaxSubArraySum {
	public static void main(String[] args) {
		//int arr[] = {-2,-5,6,-2,-3,1,5,-6};
		int arr[] = {-1,-1,-1,-1,-1,-1};
		Integer max = Integer.MIN_VALUE;
		Integer sum = 0;
		
		for(int i=0;i<arr.length;i++){
			sum = arr[i];
			if(max < sum){
				max = sum;
			}
			for(int j=i+1;j<arr.length;j++){
				sum += arr[j];
				if(max < sum)
					max = sum;
			}
		}
		
		System.out.println("Max sum = "+max);
	}
}
