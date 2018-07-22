package com.java.geeks.solution.stack;

import java.util.Scanner;

public class CustomStack {

	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	static Node root;
	static Node top;
	public static Integer firstMax = Integer.MIN_VALUE+1;
    public static Integer secondMax = Integer.MIN_VALUE;
	
	public void push(int data){
		if(firstMax < data){
            secondMax = firstMax;
            firstMax = data;
        }else if(secondMax < data){
            secondMax = data;
        }
		Node node = new Node(data);
		if(root == null){
			root = node;
			top = root;
		}else{
			top.next = node;
			top = node;
		}
	}
	
	public void pop(){
		if(root == null){
			return;
		}else{
			if(root == top){
				root = top = null;
				firstMax = Integer.MIN_VALUE+1;
				secondMax = Integer.MIN_VALUE;
			}else{
				
				int data = top.data;
				Node temp = root;
				while(temp.next!=top){
					temp = temp.next;
				}
				top = temp;
				temp.next = null;
				if(data == secondMax || data == firstMax){
                    this.findFirstSecondMax();
                }
			}
		}
	}
	
	public int findMax(){
		if(root==null){
			return 0;
		}else{
			Node temp = root;
			Integer max = Integer.MIN_VALUE;
			while(temp!=null){
				if(max<temp.data){
					max = temp.data;
				}
				temp = temp.next;	
			}
		    return max;
		}
	}
	
	public void findFirstSecondMax(){
		firstMax = Integer.MIN_VALUE+1;
		secondMax = Integer.MIN_VALUE;
        if(root==null){
			return;
		}else{
			Node temp = root;
			while(temp!=null){
				if(firstMax < temp.data){
                   secondMax = firstMax;
                   firstMax = temp.data;
                }else if(secondMax < temp.data){
                    secondMax = temp.data;
                }
				temp = temp.next;	
			}
		}
    }
	
	public void printAll(){
		if(root == null){
			System.out.println("Stack Empty");
			return;
		}else{
			Node display = root;
			while(display!= null){
				System.out.println(" "+ display.data +" ");
				display = display.next;
			}
		}
	}
	
	public static void main(String[] args) {
		/*Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.printAll();
		System.out.println(" ");
		System.out.println("Max = "+ stack.maxElement());
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(" ");
		stack.printAll();
		System.out.println("Max = "+ stack.maxElement());
		
		Scanner scanner = new Scanner(System.in);
	    int t = scanner.nextInt();
        if(t < 1 && t > 100000){
            return;
        }*/
		Scanner scanner = new Scanner(System.in);
	    int t = Integer.parseInt(scanner.nextLine());
        if(t < 1 && t > 100000){
            return;
        }
        CustomStack solution = new CustomStack();
        for(int i=0;i<t;i++)
	    {
		  String str = scanner.nextLine();
		  if(!str.isEmpty()){
			  if(str.charAt(0) == '1'){
		            String tokens[] = str.split(" ");    
		            Integer x = Integer.parseInt(tokens[1]);
                    if(x < 1 && x > 1000000000){
                    	System.out.println("x value");
                        return;
                    }
                    solution.push(x);
		          }else if(str.equals("2")){
		              solution.pop();
		          }else if(str.equals("3")){
		        	//System.out.println(solution.findMax());
	                    System.out.println(solution.firstMax);
		          }
		  }
          
        }
        scanner.close();
    }	
}
