package com.java.geeks.solution.linkedlist;

public class DoubleLinkedList {
	
	private class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left = right= null;
		}
	}
	
	private Node head;
	private Node tail;
	
	public DoubleLinkedList() {
	}

	public void insertFirst(int data){
		Node node = new Node(data);
		if(head == null){
			head = new Node(data);
			tail = head;
		}else{
			node.right = head;
			head.left = node;
			head = node;
		}
	}
	
	public void insertLast(int data){
		Node node = new Node(data);
		if(head == null){
			head = node;
			tail = head;
		}else{
			tail.right = node;
			node.left = tail;
			tail = tail.right;
		}
	}

	public int remove(){
		if(head==null){
			return -1;
		}
		Node node = tail;
		if(head == tail){
			head = tail = null;
		}else{
			tail = tail.left;
			tail.right = null;
		}
		
		return node.data;
	}
	
	public boolean remove(Node node){
		if(head==null){
			return false;
		}
		if(head.data == node.data && head == tail){
			head = tail = null;
		}else if(head.data == node.data){
			head = head.right;
			head.left = null;
		}else if(tail.data == node.data){
			tail = tail.left;
			tail.right = null;
		}else{
			Node temp = head;
			while(temp!=null && temp.data != node.data){
				temp = temp.right;
			}
			if(temp == null){
				return false;
			}
			temp.left.right = temp.right;
			temp.right.left = temp.left;
		}
		
		return true;
	}
	
	public void display(){
		if(head == null){
			return;
		}else{
			Node temp = head;
			System.out.println();
			while(temp!= null){
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
			System.out.println();
		}
	}
	
	public Node getNode(int data){
		return new Node(data);
	}
	
	public static void main(String[] args) {
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.insertFirst(10);
		doubleLinkedList.insertFirst(20);
		doubleLinkedList.insertFirst(30);
		doubleLinkedList.insertFirst(40);
		doubleLinkedList.insertLast(50);
		doubleLinkedList.insertLast(60);
		doubleLinkedList.insertLast(70);
		doubleLinkedList.insertLast(80);
		doubleLinkedList.display();
		doubleLinkedList.remove();
		doubleLinkedList.remove();
		doubleLinkedList.remove();
		doubleLinkedList.display();
		System.out.println(doubleLinkedList.remove(doubleLinkedList.getNode(60)));
		doubleLinkedList.remove(doubleLinkedList.getNode(50));
		doubleLinkedList.display();
		doubleLinkedList.remove(doubleLinkedList.getNode(40));
		doubleLinkedList.display();
		
	}
}
