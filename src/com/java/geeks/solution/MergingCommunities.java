package com.java.geeks.solution;
import java.io.*;
import java.util.*;
/**
 * 
 * @author rgurru
 *Output Format
	
	The output of the queries.
	
	Sample Input
	
	3 6
	Q 1
	M 1 2
	Q 2
	M 2 3
	Q 3
	Q 2
	Sample Output
	
	1
	2
	3
	3
 */
public class MergingCommunities {
    
    public Map<Integer,Node> map;
	
	public MergingCommunities() {
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
        if(!map.containsKey(data)){
            Node node = new Node(data,data);
		    node.parent = node;
		    map.put(data, node);
        }
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

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
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
        
        MergingCommunities solution = new MergingCommunities();
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
            
    }
}