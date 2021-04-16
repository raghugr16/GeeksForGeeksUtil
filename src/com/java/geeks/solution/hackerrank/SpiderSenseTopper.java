package com.java.geeks.solution.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
    
    int x,y;
    Pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class SpiderSenseTopper
{
    public static void main(String args[])
    {
//        Scanner sc = new Scanner(System.in);
//        int t = Integer.parseInt(sc.next());
//        while(t-- > 0)
//        {
//            int m = Integer.parseInt(sc.next());
//            int n = Integer.parseInt(sc.next());
//            char mat[][] = new char[m][n];
//            for(int i=0;i<m;i++)
//            {
//                for(int j=0;j<n;j++)
//                {
//                    mat[i][j] = sc.next().charAt(0);
//                }
//            }
//            
//           
//            Solution1212 T = new Solution1212();
//            int ans[][] = T.findDistance(mat, m, n);
//            
//            for(int i=0;i<m;i++)
//            {
//                for(int j=0;j<n;j++)
//                {
//                    System.out.print(ans[i][j] + " ");
//                }
//                System.out.println();
//            }
//        }
        char mat[][] = { { 'W', 'B', 'W', 'B', 'O', 'O', 'O', 'W', 'B' },
				{ 'O', 'B', 'O', 'O', 'O', 'B', 'O', 'W', 'O' }, { 'B', 'B', 'B', 'W', 'B', 'B', 'B', 'O', 'B' },
				{ 'B', 'O', 'O', 'W', 'B', 'O', 'B', 'W', 'W' }, { 'B', 'B', 'W', 'O', 'B', 'B', 'B', 'W', 'O' } };

		// 5 9

		int m = 5;// rows
		int n = 9;// cols
		
		Solution1212 T = new Solution1212();
	      int ans[][] = T.findDistance(mat, m, n);
	      
	      for(int i=0;i<m;i++)
	      {
	          for(int j=0;j<n;j++)
	          {
	              System.out.print(ans[i][j] + " ");
	          }
	          System.out.println();
	      }
    }
}
// } Driver Code Ends



class Solution1212
{
    public static int[][] findDistance(char mat[][], int m,int n)
    {
         int ans[][] = new int[m][n];
        Queue <Pair> q = new LinkedList<Pair>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j] == 'B')
                {
                    ans[i][j] = 0;
                    q.add(new Pair(i,j));
                }
                else 
                    ans[i][j] = -1;
            }
        }
        
        while(q.size() > 0)
        {
            int size = q.size();
            while(size-- > 0)
            {
                Pair p = q.peek();
                int i = p.x;
                int j = p.y;
                q.remove();
                
                if(i + 1 < m && mat[i+1][j] == 'O' && ans[i+1][j] == -1)
                {
                    ans[i+1][j] = 1+ ans[i][j];
                    q.add(new Pair(i+1,j));
                }
                
                if(i - 1 >= 0 && ans[i-1][j] == -1 && mat[i-1][j] == 'O')
                {
                    ans[i-1][j] = 1 + ans[i][j];
                    q.add(new Pair(i-1,j));
                }
                
                if(j + 1 < n && ans[i][j + 1] == -1 && mat[i][j + 1] == 'O')
                {
                    ans[i][j + 1] = 1+ ans[i][j];
                    q.add(new Pair(i,j + 1));
                }
                
                if(j - 1 >= 0 && mat[i][j - 1] == 'O' && ans[i][j-1] == -1)
                {
                    ans[i][j - 1] = 1+ ans[i][j];
                    q.add(new Pair(i,j - 1));
                }
            }
        }
        
        return ans;
    }
}
