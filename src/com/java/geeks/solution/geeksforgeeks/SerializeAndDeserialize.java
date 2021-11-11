package com.java.geeks.solution.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class SerializeAndDeserialize {

	Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	void deletetree(Node root) {
		if (root == null)
			return;
		deletetree(root.left);
		deletetree(root.right);
		root.left = null;
		root.right = null;
	}

	void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		SerializeAndDeserialize serializeAndDeserialize = new SerializeAndDeserialize();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String s = br.readLine();
			Node root = serializeAndDeserialize.buildTree(s);

			Tree tr = serializeAndDeserialize.getTree();
			ArrayList<Integer> A = new ArrayList<Integer>();
			tr.serialize(root, A);
			serializeAndDeserialize.deletetree(root);
			root = null;

			Node getRoot = tr.deSerialize(A);
			serializeAndDeserialize.printInorder(getRoot);
			System.out.println();
		}
	}
	
	public Tree getTree() {
		return new Tree();
	}
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
		
		
	}
	
	class Tree {
		// Function to serialize a tree and return a list containing nodes of tree.
		public void serialize(Node root, ArrayList<Integer> A) {
			// code here
			if (root == null) {
				return;
			}
			Stack<Node> list = new Stack<>();
			list.add(root);

			while (!list.isEmpty()) {
				int size = list.size();

				while (size-- > 0) {
					Node node = list.pop();

					if (node == null) {
						A.add(null);

					} else {
						A.add(node.data);
						list.push(node.right);
						list.push(node.left);
					}
				}
			}

		}

		// Function to deserialize a list and construct the tree.
		public Node deSerialize(ArrayList<Integer> A) {
			// code here
			if (A.size() == 0) {
				return null;
			}
			Index preIndex = new Index(0);
			Node root = deSerialize(A, preIndex);
			return root;
		}

		public Node deSerialize(ArrayList<Integer> A, Index preIndex) {
			if (A.get(preIndex.index) == null) {
				return null;
			}
			Node node = new Node(A.get(preIndex.index));
			preIndex.index++;
			node.left = deSerialize(A, preIndex);
			preIndex.index++;
			node.right = deSerialize(A, preIndex);

			return node;
		}

		class Index {
			int index;

			public Index(int index) {
				this.index = index;
			}
		}
	}
	
	
}// } Driver Code Ends

/*
 * Complete the given function Node is as follows: class Tree{ int data; Tree
 * left,right; Tree(int d){ data=d; left=right=null; } }
 */

