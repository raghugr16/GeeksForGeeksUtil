package com.java.geeks.solution.geeksforgeeks;

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

//class Node {
//	int data;
//	Node left, right;
//
//	public Node(int d) {
//		data = d;
//		left = right = null;
//	}
//}

class KDistanceFromLeaf {
	 Node buildTree(String str) {
		// Corner Case
		if (str.length() == 0 || str.equals('N'))
			return null;
		String[] s = str.split(" ");

		Node root = new Node(Integer.parseInt(s[0]));
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		// Starting from the second element
		int i = 1;
		while (!q.isEmpty() && i < s.length) {
			// Get and remove the front of the queue
			Node currrNode = q.remove();

			// Get the currrent node's value from the string
			String currrVal = s[i];

			// If the left child is not null
			if (!currrVal.equals("N")) {

				// Create the left child for the currrent node
				currrNode.left = new Node(Integer.parseInt(currrVal));

				// Push it to the queue
				q.add(currrNode.left);
			}

			// For the right child
			i++;
			if (i >= s.length)
				break;
			currrVal = s[i];

			// If the right child is not null
			if (!currrVal.equals("N")) {

				// Create the right child for the currrent node
				currrNode.right = new Node(Integer.parseInt(currrVal));

				// Push it to the queue
				q.add(currrNode.right);
			}

			i++;
		}

		return root;
	}

	public static void main(String args[]) throws IOException {
		KDistanceFromLeaf kDistanceFromLeaf = new KDistanceFromLeaf();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t > 0) {
			String s = br.readLine();
			Node root = kDistanceFromLeaf.buildTree(s);

			int k = Integer.parseInt(br.readLine().trim());

			Solution T = new Solution();
			System.out.println(T.printKDistantfromLeaf(root, k));
			t--;
		}
	}
}

// } Driver Code Ends

//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 

//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution {

	int printKDistantfromLeaf(Node root, int k) {
		// Write your code here
		Set<Node> visitedNode = new HashSet<>();
		Set<Node> kpathNode = new HashSet<>();
		int height = height(root, 0);
		Node path[] = new Node[height + 1];
		// boolean visited[] = new boolean[height+1];

		printKDistantfromLeaf(root, k, visitedNode, path, 0);

		return visitedNode.size();
	}

	void printKDistantfromLeaf(Node root, int k, Set<Node> visitedNode, Node path[], int pathLen) {
		if (root == null) {
			return;
		}

		path[pathLen] = root;
		pathLen++;

		if (root.left == null && root.right == null && pathLen - k - 1 >= 0
				&& !visitedNode.contains(path[pathLen - k - 1])) {
			visitedNode.add(path[pathLen - k - 1]);
			return;
		}

		printKDistantfromLeaf(root.left, k, visitedNode, path, pathLen);
		printKDistantfromLeaf(root.right, k, visitedNode, path, pathLen);

	}
	
	int height(Node root, int k){
        if(root == null){
            return k;
        }
        if(root.left == null && root.right == null){
            return k;
        }
        int left = height(root.left, k+1);
        int right = height(root.right, k+1);
        
        if(left == right){
            return left;
        }
        if(left > right){
            return left;
        }
        return right;
    }

}
