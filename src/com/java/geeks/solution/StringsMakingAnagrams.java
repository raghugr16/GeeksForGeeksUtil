package com.java.geeks.solution;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringsMakingAnagrams {
	
	// Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        
    	char arr[] = a.toCharArray();
        char brr[] = b.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(brr);
        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();
        for(int i =0 ;i <arr.length;i++){
        	if(!aMap.containsKey(arr[i])){
        		aMap.put(arr[i], 1);
        	}else{
        		aMap.put(arr[i], aMap.get(arr[i])+1);
        	}
        }
        for(int i =0 ;i <brr.length;i++){
        	if(!bMap.containsKey(brr[i])){
        		bMap.put(brr[i], 1);
        	}else{
        		bMap.put(brr[i], bMap.get(brr[i])+1);
        	}
        }
        int removeCharCount = 0;
        
        for(char ch = 'a'; ch<='z';ch++){
        	if(aMap.containsKey(ch) && bMap.containsKey(ch)){
        		if(aMap.get(ch) > bMap.get(ch)){
        			int count  = aMap.get(ch) - bMap.get(ch);
        			removeCharCount+=count;
        			aMap.put(ch, aMap.get(ch) - count);
        		}else if(aMap.get(ch) < bMap.get(ch)){
        			int count  = bMap.get(ch) - aMap.get(ch);
        			removeCharCount+=count;
        			aMap.put(ch, bMap.get(ch) - count);
        		}
        	}else if(aMap.containsKey(ch) && !bMap.containsKey(ch)){
        		int count = aMap.get(ch);
        		removeCharCount+=count;
        		aMap.remove(ch);
        	}else if(!aMap.containsKey(ch) && bMap.containsKey(ch)){
        		int count = bMap.get(ch);
        		removeCharCount+=count;
        		bMap.remove(ch);
        	}
        }
       /* if(removeCharCount == Math.min(arr.length, brr.length)){
        	return 0;
        }*/
        return removeCharCount;
    }

    
    private static StringBuffer removeChar(StringBuffer aBuf, int index) {
    	StringBuffer str = new StringBuffer(aBuf.subSequence(0, index));
    	for(int i=index+1;i<aBuf.length();i++){
    		str.append(aBuf.charAt(i));
    	}
    	aBuf =str;
    	return str;
	}

    
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	//System.out.println(removeChar(new StringBuffer("abcd"), 2));
    	 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
