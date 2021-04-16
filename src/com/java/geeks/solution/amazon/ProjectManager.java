package com.java.geeks.solution.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class pair{
	int x,y;
	pair(){
		this.x=0;
		this.y=0;
	}
	
	pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class ProjectManager {

	public int minTime(ArrayList<pair> dependency, int[] duration, int n, int m) {
        // code here
        
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for(pair p:dependency){
        	if(map.containsKey(p.x)) {
        		List<Integer> list = map.get(p.x);
        		list.add(p.y);
        		map.put(p.x,list);
        	}else {
        		List<Integer> list = new ArrayList<>();
        		list.add(p.y);
        		map.put(p.x,list);
        	}
        }
        
        Set<Integer> set = new HashSet<>();
        if(dependency.get(0).x == dependency.get(0).y) {
        	System.out.println("There is a loop");
        	return -1;
        }else {
        	set.add(dependency.get(0).x);
        }
        
        for(int i=1;i<dependency.size();i++){
        	int elem = dependency.get(i-1).y;
        	while(map.containsKey(elem)) {
        		List<Integer> list = map.get(elem);
        		for(int module:list) {
        			//elem = map.get(module);
        		}
    			
    			if(!set.contains(elem)){
            		set.add(elem);
            	}else {
            		return -1;
            	}
    		}
        }
        return -1;
	}
	
	
}
