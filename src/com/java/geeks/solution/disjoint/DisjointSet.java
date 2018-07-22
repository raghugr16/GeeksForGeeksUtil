package com.java.geeks.solution.disjoint;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//Merging Communities problem in Hacker Rank
public class DisjointSet<V> {
	
	public Map<Integer,Node<V>> map;
	
	public DisjointSet() {
		map = new HashMap<>();
	}
	
	static public class Node<V>{
		int id;
		V data;
		int rank;
		Node<V> parent;
		
		Node(int id,V data){
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
			}else{
				parent1.parent = parent2;
				parent2.rank +=parent1.rank;
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
	
	static int[] componentsInGraph(int[][] gb) {
        /*
         * Write your code here.
         */
        // No of test cases
		DisjointSet solution = new DisjointSet();
        int n = gb.length;
        int row = gb.length;
        int col = gb[0].length;
        
        for(int i=1;i<=n;i++){
            solution.makeSet(i);
            solution.makeSet(i+n);
        }
        for(int i=0;i<row;i++){
            solution.join(gb[i][0],gb[i][1]);
        }

		for(int i=1;i<=n;i++){
			System.out.println(i+"th Parent "+ solution.findSet(i).id);
			System.out.println(i+"th Set total Count "+ solution.findSet(i).rank);
			
			System.out.println((i+n)+"th Parent "+ solution.findSet(i+n).id);
			System.out.println((i+n)+"th Set total Count "+ solution.findSet(i+n).rank);
			
			System.out.println("");
		}
		
        int big = Integer.MIN_VALUE;
        int secondBig = Integer.MIN_VALUE;
        Set<Map.Entry<Integer,Node>> entrySet = solution.map.entrySet();
        for(Map.Entry<Integer,Node> entry :entrySet){
            int rank = entry.getValue().rank;
            if(big < rank){
                secondBig = big;
            	big = rank;
                
            }else if(secondBig < rank ){
            	secondBig = rank;
            }
            /*if(rank > 1){
            	if(secondBig > rank){
                    secondBig = rank;
                }
            }*/
            
        }
        try {
			BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("D:\\Notes\\component_result.txt"));
			entrySet = solution.map.entrySet();
			
	        for(Map.Entry<Integer,Node> entry :entrySet){
	            int rank = entry.getValue().rank;
	            if(rank!=1){
	            	bufferedWriter1.write(String.valueOf(entry.getValue().id)+ "  rank = " + String.valueOf(entry.getValue().rank));
		            bufferedWriter1.newLine();
	            }
	            
	        }
	        bufferedWriter1.flush();
	        bufferedWriter1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        int result[] = new int[2];
        
        if(big >1)
            result[0] = big;
        if(secondBig > 1)
            result[1] = secondBig;
        
        System.out.println("Max = "+ big);
        System.out.println("Min = "+ secondBig);
        
        return result;
            
    }

	
	/*public static void main(String[] args) {
		DisjointSet<Integer> disjointSet = new DisjointSet<>();
		for(int i=0;i<8;i++){
			disjointSet.makeSet(i);
		}
		
		disjointSet.join(0, 1);
		disjointSet.join(2, 3);
		disjointSet.join(4, 5);
		disjointSet.join(6, 7);
		disjointSet.join(0, 2);
		disjointSet.join(5, 7);
		disjointSet.join(2, 5);
		
		for(int i=0;i<8;i++){
			System.out.println(i+"th Parent "+ disjointSet.findSet(i).id);
			System.out.println(i+"th Set total Count "+ disjointSet.findSet(i).rank);
			System.out.println("");
		}
		
		int n = 0;
		int q = 0;
		Scanner inputScanner = new Scanner(System.in);
		String str = inputScanner.nextLine();
		String input1[] = str.split(" ");
		n =  Integer.parseInt(input1[0]);
		q =  Integer.parseInt(input1[1]);
		
        if(n < 1 && n > 100000){
            return;
        }
        if(q < 1 && q > (2 * 100000)){
            return;
        }
		String noOfCases[] = new String[q];
		for(int i=0;i<q;i++){
			noOfCases[i] = inputScanner.nextLine();
		}
        
		DisjointSet solution = new DisjointSet();
        for(int i=1;i<=n;i++){
            solution.makeSet(i);
        }
        for(int i=0;i<q;i++){
            str = noOfCases[i];
            String[] cases = str.split(" ");
            if(cases[0].equals("Q")){
                int person = Integer.parseInt(cases[1]);
                System.out.println(solution.findSet(person).rank);
            }else{
                int data1 = Integer.parseInt(cases[1]);
                int data2 = Integer.parseInt(cases[2]);
                solution.join(data1,data2);
            }
        }
            
    }*/
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Notes\\component.tx"));

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

        System.out.println(result.toString());
        
        for (int SPACEItr = 0; SPACEItr < result.length; SPACEItr++) {
            bufferedWriter.write(String.valueOf(result[SPACEItr]));

            if (SPACEItr != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }
}
