package com.java.geeks.solution;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ReverseFirstWithSecondHalfString {
    public static String reverseWordPring(String word){
    	StringBuffer stringBuffer = new StringBuffer(word);
        String firstHalf = null;
        String secondHalf = null;
        int m;
        if(stringBuffer.length() % 2 == 0){
            m =  stringBuffer.length()/2;
            firstHalf = stringBuffer.substring(0,m);
            secondHalf = stringBuffer.substring(m,stringBuffer.length());
            stringBuffer = new StringBuffer();
            stringBuffer.append(secondHalf);
            stringBuffer.append(firstHalf);
        }else{
            m= stringBuffer.length()/2;
            firstHalf = stringBuffer.substring(0,m);
            secondHalf = stringBuffer.substring(m+1,stringBuffer.length());
            stringBuffer = new StringBuffer();
            stringBuffer.append(secondHalf);
            stringBuffer.append(word.charAt(m));
            stringBuffer.append(firstHalf);
        }
        
        
        return stringBuffer.toString();
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String str = "it";
        System.out.println(str.substring(0,1));
        System.out.println(str.substring(1,2));
       
        
    	/*Scanner input = new Scanner(System.in);
        String sentence = input.nextLine();
        String words[] = sentence.split(" ");
        for(int i=0;i< words.length;i++){
            if(words[i].lastIndexOf('t') > -1){
                System.out.println(reverseWordPring(words[i]));
            }
        }*/
        
        
    }
}