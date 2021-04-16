package com.java.geeks.solution.graph.minimum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class MinimumSwapToArray
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends

//import javafx.util.Pair;
class Pair{
    Integer key;
    Integer value;
    
    public Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
    
    public Integer getKey() { return key; }
    
    public Integer getValue() { return value; }

	@Override
	public String toString() {
		return "Key="+key + ", value=" + value;
	}
}
class Solution
{
    public int minSwaps(int nums[])
    {
        // Code here
        ArrayList<Pair> pairs = new ArrayList<Pair>();
        
        for(int i =0 ; i < nums.length;i++){
            Pair pair = new Pair(nums[i],i);
            pairs.add(pair);
        }
        
        pairs.sort(new Comparator<Pair>() {
            
            @Override
            public int compare(Pair p1, 
                    Pair p2){
                if(p1.getKey() > p2.getKey()){
                    return 1;
                }
                else if(p1.getKey().equals(p2.getKey())){
                    return 0;
                }
                else
                    return -1;
            }
        });
        
        boolean visited[] = new boolean[nums.length];
        Arrays.fill(visited,false);
        
        
        int ans = 0;
        
        for(int i=0;i<nums.length;i++){
            if(visited[i] || pairs.get(i).getValue().equals(i))
                continue;
            
            int j = i;
            int noOfCycles = 0;
            
            while(!visited[j]){
                
                visited[j] = true;
                j = pairs.get(j).getValue();
                noOfCycles++;
            }
            
            if(noOfCycles > 0){
            ans += (noOfCycles-1);
            }
        }
        
        return ans;   
    }
}