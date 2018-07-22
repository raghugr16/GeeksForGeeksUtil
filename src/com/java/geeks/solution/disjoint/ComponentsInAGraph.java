package com.java.geeks.solution.disjoint;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class ComponentsInAGraph {

    public Map<Integer,Node> map;
	
	public ComponentsInAGraph() {
		map = new HashMap<>();
	}
	
	public class Node{
		int id;
		int data;
		int rank;
		Node parent;
		
		Node(int id,int data){
			this.id = id;
			this.rank = 1;
			this.parent = null;
			this.data = data;
		}
	}

	public void makeSet(int data){
		Node node = new Node(data,data);
		node.parent = node;
		map.put(data, node);
		
	}
	
	public void join(int data1, int data2){
		Node parent1 = findSet(data1);
		Node parent2 = findSet(data2);
		if(parent1 != parent2){
			
			if(parent1.rank >= parent2.rank){
				parent1.rank = 
						(parent1.rank == parent2.rank) ? (parent1.rank+parent1.rank):parent1.rank+parent2.rank;
				parent2.parent = parent1;
                parent2.rank = 1;
			}else{
				parent1.parent = parent2;
				parent2.rank +=parent1.rank;
                parent1.rank = 1;
			}
		}
	}
	
	public Node findSet(int data){
		Node node = map.get(data);
		if(node!=null){
			while(node != node.parent){
				node = node.parent;
			}
		}
		return node;
	}
    /*
     * Complete the componentsInGraph function below.
     */
    static int[] componentsInGraph(int[][] gb) {
        /*
         * Write your code here.
         */
        ComponentsInAGraph solution = new ComponentsInAGraph();
        int n = gb.length;
        if(n<1 && n > 15000){
            int a[] = new int[2];
            return a;
        }
        
        int row = gb.length;
        int col = gb[0].length;
        
        /*for(int i=1;i<=n;i++){
            solution.makeSet(i);
            solution.makeSet(i+n);
        }*/
        
        for(int i=0;i<row;i++){
            if(!solution.map.containsKey(gb[i][0])){
                solution.makeSet(gb[i][0]);
            }
            if(!solution.map.containsKey(gb[i][1])){
                solution.makeSet(gb[i][1]);
            }
            solution.join(gb[i][0],gb[i][1]);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<Map.Entry<Integer,Node>> entrySet = solution.map.entrySet();
        for(Map.Entry<Integer,Node> entry :entrySet){
            int rank = entry.getValue().rank;
            if(max < rank){
                max = rank;
            }
            if(rank > 1){
            	if(min > rank){
                    min = rank;
                }
            }
            
        }
        
        
        int result[] = new int[2];
        
        /*if(big >1)
            result[0] = secondBig;
        if(secondBig > 1)
            result[1] = big;*/
        if(min >1)
            result[0] = min;
        if(max > 1)
            result[1] = max;
        
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] result = componentsInGraph(gb);

        for (int SPACEItr = 0; SPACEItr < result.length; SPACEItr++) {
            bufferedWriter.write(String.valueOf(result[SPACEItr]));

            if (SPACEItr != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}