package com.java.geeks.solution.Arrays;

public class PrintTripletInArray {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		int n = arr.length;
		for(int i=0;i<n-2;i++){
			for(int j=i+1;j<=n-2;j++){
				for(int k=j+1;k<n;k++){
					System.out.println(arr[i]+" "+ " " + arr[j] + "  "+ arr[k]);
				}
			}
		}
	}
}
