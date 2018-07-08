package com.java.geeks.solution;

public class TwoDArray {
	
	public static void main(String[] args) {
		int n = 3;
		int m = 4;
		int a[][] = new  int [n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				a[i][j] = 1;
			}
		}
		
		
		/*System.out.println(" Row  = "+a.length);
		System.out.println(" Col  = "+a[0].length);
		System.out.println(" Col  = "+a[1].length);
		System.out.println(" Col  = "+a[2].length);*/
		
		int mat[][] = { { 1, 2, 3, 4 },
                		{ 5, 6, 7, 8 },
                		{ 9, 10, 11, 12,34 } };
		
		/*System.out.println(" row  = "+mat.length);
		System.out.println(" Col = "+mat[0].length);
		System.out.println(" Col = "+mat[1].length);
		System.out.println(" Col = "+mat[2].length);
		*/
		int com[][] = {
				{ 1, 6 }, 
				{2, 7 },
				{3, 8},
				{4, 9},
				{2, 6}
					  };
		
		System.out.println(" row " + com.length);
		System.out.println(" Col " + com[0].length);
	}

}
