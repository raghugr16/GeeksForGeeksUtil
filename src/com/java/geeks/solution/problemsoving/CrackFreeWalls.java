package com.java.geeks.solution.problemsoving;
import java.util.Scanner;

public class CrackFreeWalls {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String tokens[] = str.split(" ");
        int w = Integer.parseInt(tokens[0]);
        int h = Integer.parseInt(tokens[1]);
        int m = Integer.parseInt(tokens[2]);
        if( w < 5 && w > 45 && h<2 && h > 100 && m < 1 && m > Math.pow(2,30)){
        	return;
        }
        
        scanner.close();
    }
}