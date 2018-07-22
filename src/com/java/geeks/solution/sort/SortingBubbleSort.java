package com.java.geeks.solution.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SortingBubbleSort {

	// Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int n = a.length;
        int swapCount = 0;
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n-i-1;j++){
    			if(a[j] < a[j+1]){
    				swapCount++;
	    			int temp = a[j];
	    			a[j] = a[j+1];
	    			a[j+1] = temp;
    			}
    		}
    	}
    	System.out.println("Array is sorted in "+ swapCount + " swaps.");
    	System.out.println("First Element: "+ a[0]);
    	System.out.println("Last Element: "+ a[n-1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);
        	
        scanner.close();
    }
}
