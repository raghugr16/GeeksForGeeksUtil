package com.java.geeks.solution.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/*
 * 
 * {
  "competitions": [
    ["HTML", "Java"],
    ["Java", "Python"],
    ["Python", "HTML"],
    ["C#", "Python"],
    ["Java", "C#"],
    ["C#", "HTML"],
    ["SQL", "C#"],
    ["HTML", "SQL"],
    ["SQL", "Python"],
    ["SQL", "Java"]
  ],
  "results": [0, 1, 1, 1, 0, 1, 0, 1, 1, 0]
}
 */
public class TournamentWinner {
	
	public String tournamentWinner(
		      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
		    // Write your code here.
			Map<String,Integer> map = new HashMap<>();
			int count = 0;
			for(ArrayList<String> arrayList : competitions) {
				String homeTeam = arrayList.get(0);
				String awayTeam = arrayList.get(1);
				
				if(results.get(count) == 1) {
					if(!map.containsKey(homeTeam)) {
						map.put(homeTeam, 3);
					}else {
						map.put(homeTeam, map.get(homeTeam)+3);
					}
					
				}else {
					if(!map.containsKey(awayTeam)) {
						map.put(awayTeam, 3);
					}else {
						map.put(awayTeam, map.get(homeTeam)+3);
					}
				}
				count++;
			}
			Map.Entry<String, Integer> winner = null;
			for(Map.Entry<String, Integer> entry: map.entrySet()) {
				if(winner == null) {
					winner = entry;
				}else {
					if(entry.getValue() > winner.getValue()) {
						winner = entry;
					}
				}
			}
			return winner.getKey();
		  }
	
	public static void main(String[] args) {
		ArrayList<ArrayList<String>>  competitions = new ArrayList<>();
		ArrayList<String> s1 = new ArrayList<>();
		s1.add("HTML");
		s1.add("HTML");
		ArrayList<String> s2 = new ArrayList<>();
		ArrayList<String> s3 = new ArrayList<>();
		
	}

}
