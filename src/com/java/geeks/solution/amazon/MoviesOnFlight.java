package com.java.geeks.solution.amazon;

public class MoviesOnFlight {

	public static void main(String[] args) {
		
		int n =15;
		for(int i=1;i<n;i++) {
			boolean multipleOfThree = ((float)i % 3.0 == 0.0) ? true : false;
            boolean multipleOfFive = ((float)i % 5.0 == 0.0) ? true : false; 
            if(multipleOfThree && multipleOfFive){
                System.out.println("FizzBuzz");
            }else if( multipleOfThree && !multipleOfFive ){
                System.out.println("Fizz");
            }else if(!multipleOfThree && multipleOfFive){
                System.out.println("Buzz");
            }else{
                System.out.println(i);
            }
		}
	}
}
