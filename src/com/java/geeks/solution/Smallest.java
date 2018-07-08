package com.java.geeks.solution;

public class Smallest {
	
	
		public static void main(String[] args) {
			int a[] = {0,1,1,2,3,4,5};
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int i=0;i<a.length;i++){
				if(max < a[i])
					max = a[i];
				if(a[i] > 1){
					if(min>a[i] )
						min = a[i];
				}
			}
			
			System.out.println("Max = "+max);
			System.out.println("Min = "+min);
				
		}
}
