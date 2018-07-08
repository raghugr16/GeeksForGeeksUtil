package com.java.geeks.solution;
import java.util.Scanner;

public class LeftRotationArray {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();
        
        if(n<=100000 && n>=0){
            if(d>=1 && d<=n){
                d = d%n;
                while(d>0){
                    int temp = a[0];
                    for(int i=0;i<a.length-1;i++){
                        a[i] = a[i+1];
                    }
                    a[a.length-1]= temp;
                    d--;
                }
            }
        }
        
        for(int i=0;i<a.length;i++){
        	System.out.print(a[i]);
        }
        
    }
}
