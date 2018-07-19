package com.java.geeks.solution;

public class Stack {
	
	private static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node top;
	public Node head;
	private int size;
	
	private Node rear;
	private Node front;
	
	public Stack() {
	}

	public void push(int data){
		if(head == null){
			head = new Node(data);
			top = head;
			size++;
			return;
		}
		
		top.next = new Node(data);
		top = top.next;
		size++;
	}
	
	public int pop(){
		if(head == null)
			return -1;
		if(head == top){
			Node temp = head;
			top = head = null;
			size--;
			return temp.data;
		}
		Node temp = head;
		while(temp.next!=top){
			temp = temp.next;
		}
		Node retNode = temp.next;
		temp.next = null;
		top = temp;
		size--;
		return retNode.data;
	}
	
	public boolean isEmpty(){
		return (size <= 0)?true:false;
	}
	
	public void display(){
		if(head==null){
			return;
		}
		System.out.println("");
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	public int poll(){
		if(head == null)
			return 0;
		return top.data;
	}
	
	public int getHead(){
		if(head == null)
			return 0;
		return head.data;
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.display();
		stack.pop();
		stack.display();
		Node node=  new Node(10);
	}
}
