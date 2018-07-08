package com.java.geeks.solution;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class DynamicArray {

    /*
     * Complete the dynamicArray function below.
     */
    static int[] dynamicArray(int n, int[][] queries) {
        /*
         * Write your code here.
         */
        LinkedList<Integer> seqList[] = new LinkedList[n];
        int lastAnswer = 0;
        
        for(int i=0;i<3;i++){
            int index;
            if(queries[i][0] == 1){
               index = ((queries[i][1] ^ lastAnswer) % n);
                LinkedList<Integer> linkedList = seqList[index];
                linkedList.addLast(queries[i][2]); 
                
            }else{
                index = ((queries[i][1] ^ lastAnswer) % n);
                lastAnswer =  queries[i][2] % seqList[index].size();
                System.out.println(lastAnswer);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int j=0;j<seqList.length;j++){
            ListIterator<Integer> listIterator = seqList[j].listIterator();
                while(listIterator.hasNext()){
                    list.add(listIterator.next());    
                }
            }    
        int seq[] = new int[list.size()];
        for(int j=0;j<list.size();j++){
        	seq[j] = list.get(j);
        }
        return  seq;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[][] queries = new int[q][3];

        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = dynamicArray(n, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
