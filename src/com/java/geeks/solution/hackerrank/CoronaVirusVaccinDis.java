package com.java.geeks.solution.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class CoronaVirusVaccinDis {

	private static Integer VACCINE_COUNTER = 0;

	class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	class Vaccine {
		Integer id;
		Node node;
	}

	public int supplyVacine(Node node) {
		ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
		Node root = node;
		list = getList(root);
		int height = list.size();
		int mid,low,high;
		mid = low = high = 0;
		
		if(height > 3) {
			ArrayList<Node> row = list.get(height-1);
			
			for(int i=list.size();i>0; i=i-3) {
				high = height -1;
				mid = height - 2;
				low = height - 3;
			}
		}else if(height == 3){
			
		}else if(height == 2){
			
		}else if(height ==1) {
			
		}
		
		return 0;
	}

	private ArrayList<ArrayList<Node>> getList(Node root) {
		ArrayList<ArrayList<Node>> tree = null;
		if (root == null) {
			return null;

		} else {
			tree = new ArrayList<ArrayList<Node>>();
			tree.add((ArrayList<Node>) Arrays.asList(root));
			LinkedList<Node> list = new LinkedList<>();

			// add root node
			list.add(root);
			while (list.size() > 0) {
				ArrayList<Node> row = new ArrayList<>();
				int counter = list.size();

				while (counter > 0) {
					counter--;
					
					Node node = list.pollFirst();
					if (node.left != null) {
						
						list.add(node.left);
						row.add(node.left);
					}
					if (node.right != null) {
						
						list.add(node.right);
						row.add(node.right);
					}
				}
				tree.add(row);
			}
		}
		return tree;
	}
	
	

}
