package com.java.geeks.solution.course.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AdjacentList {

	/*
	 * 6 11 0 1 0 4 0 5 1 2 1 3 1 4 2 3 2 4 2 5 3 5 4 5
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//		adj.add(new ArrayList<>(Arrays.asList(5,7)));
//		adj.add(new ArrayList<>(Arrays.asList(0,1)));
//		adj.add(new ArrayList<>(Arrays.asList(0,4)));
//		adj.add(new ArrayList<>(Arrays.asList(1,2)));
//		adj.add(new ArrayList<>(Arrays.asList(1,3)));
//		adj.add(new ArrayList<>(Arrays.asList(1,4)));
//		adj.add(new ArrayList<>(Arrays.asList(2,3)));
//		adj.add(new ArrayList<>(Arrays.asList(3,4)));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		System.out.println("line" + line);
		int T = Integer.parseInt(line);
		while (T-- > 0) {
			String[] s = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
			for (int i = 0; i < V; i++)
				adj.add(i, new ArrayList<Integer>());
			for (int i = 0; i < E; i++) {
				String[] S = br.readLine().trim().split(" ");
				int u = Integer.parseInt(S[0]);
				int v = Integer.parseInt(S[1]);
				adj.get(u).add(v);
				adj.get(v).add(u);
			}
			AdjacentList obj = new AdjacentList();
			ArrayList<ArrayList<Integer>> ans = obj.printGraph(V, adj);
			for (int i = 0; i < ans.size(); i++) {
				for (int j = 0; j < ans.get(i).size() - 1; j++) {
					System.out.print(ans.get(i).get(j) + "-> ");
				}
				System.out.print(ans.get(i).get(ans.get(i).size() - 1));
				System.out.println();
			}
		}
		// System.out.println(printGraph(7, adj));
		System.out.println(T);
	}

	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	public static ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj) {

		// Code here
		System.out.println(adj);
		ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V; i++) {
			finalList.add(new ArrayList<>());
		}
		for (int i = 0; i < V; i++) {
			ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				list.addAll(adj.get(i));
				finalList.get(i).addAll(list);
		}

		return finalList;
	}

}
