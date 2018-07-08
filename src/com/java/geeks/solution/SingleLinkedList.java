package com.java.geeks.solution;

import java.util.Scanner;

public class SingleLinkedList {

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node root;

	public void insertFirst(int data) {
		Node node = new Node(data);
		if (this.root == null) {
			root = node;
			return;
		} else {
			node.next = root;
			root = node;
		}
	}

	public void insertLast(int data) {
		Node node = new Node(data);
		if (this.root == null) {
			root = node;
			return;
		} else {
			Node temp = this.root;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	public void printLL() {
		if (this.root == null) {
			return;
		} else {
			Node node = this.root;
			System.out.println("");
			while (node != null) {
				System.out.print(" " + node.data + " ");
				node = node.next;
			}
		}
	}

	

	private void printLL(SingleLinkedList singleLinkedList) {
		if (singleLinkedList.root == null) {
			return;
		} else {
			Node node = singleLinkedList.root;
			System.out.println("");
			while (node != null) {
				System.out.print(" " + node.data + " ");
				node = node.next;
			}
		}
	}

	private SingleLinkedList mergeLL(SingleLinkedList head1, SingleLinkedList head2) {
		if (head1.root == null && head2.root == null)
			return null;
		if (head1.root == null)
			return head2;
		if (head2.root == null)
			return head1;
		Node curr1 = head1.root;
		Node curr2 = head2.root;
		Node prev = null;
		while (curr1 != null && curr2 != null) {
			if(curr1.data <= curr2.data){
				while(curr1 != null && curr1.data <= curr2.data){
					/*if(prev == curr2){
						prev.next = curr1;
					}*/
					prev = curr1;
					curr1 = curr1.next;
				}
				if(curr1 == null){
					prev.next = curr2;
					if(head1.root.data<=head2.root.data){
						return head1;
					}else{
						return head2;
					}
				}else{
					prev.next = curr2;
					int data = prev.data;
					while(curr2!= null && curr2.data == data ){
						prev = curr2;
						curr2 = curr2.next;
					}
					if(curr2 == null){
						prev.next = curr1;
						if(head1.root.data<=head2.root.data){
							return head1;
						}else{
							return head2;
						}
					}else{
							if(curr1.data < curr2.data)
							{
								prev.next = curr1;
							}else if(curr1.data > curr2.data){
								prev.next = curr2;
							}else{
								prev.next = curr1;
							}
					}
					
				}
				
			}else{
				while(curr2!= null && curr2.data<=curr1.data){
					prev = curr2;
					curr2 = curr2.next;
				}
				if(curr2 == null){
					prev.next = curr1;
					if(head1.root.data<=head2.root.data){
						return head1;
					}else{
						return head2;
					}
				}else{
					prev.next = curr1;
					int data = prev.data;
					while(curr1!= null && curr1.data == data){
						prev = curr1;
						curr1 = curr1.next;
					}
					if(curr1 == null){
						prev.next = curr2;
						if(head1.root.data<=head2.root.data){
							return head1;
						}else{
							return head2;
						}
					}else{
							if(curr1.data < curr2.data)
							{
								prev.next = curr1;
							}else if(curr1.data > curr2.data){
								prev.next = curr2;
							}else{
								prev.next = curr1;
							}
						
					}
				}
				
				
			}
		}	
		return null;
			
	}
	
	static int getNode(SingleLinkedList head, int positionFromTail) {
        Node fastNode = head.root;
        Node slowNode = head.root;
        
        if(head == null){
            return 0;
        }
        else{
            int llLength = -1;
            while(fastNode!=null && slowNode != null){
                slowNode = slowNode.next;
                fastNode = fastNode.next;
                if(fastNode == null){
                    llLength++;
                    break;
                }
                fastNode = fastNode.next;
                llLength+=2;    
            }
            llLength = llLength - positionFromTail;
            slowNode = head.root;
            if(llLength < 0){
                return 0;
            }
            while(llLength > 0 && slowNode!=null){
                slowNode = slowNode.next;
                llLength--;
            }
            return slowNode.data;
        }
        
    }
    
	public static void main(String[] args) {
	SingleLinkedList singleLinkedList2 = new SingleLinkedList();
	SingleLinkedList singleLinkedList3 = new SingleLinkedList();
	SingleLinkedList singleLinkedList = new SingleLinkedList();
	Scanner scanner = new Scanner(System.in);
	int t = scanner.nextInt();
	/*
	* This is for merging two linked list
     for(int i=0;i<t;i++)
	{
		 singleLinkedList2 = new SingleLinkedList();
	    singleLinkedList3 = new SingleLinkedList();
		int size1 = scanner.nextInt();
		for(int j=0;j<size1;j++){
			singleLinkedList2.insertLast(scanner.nextInt());
		}
		singleLinkedList.printLL(singleLinkedList2);
		int size2 = scanner.nextInt();
		for(int j=0;j<size2;j++){
			singleLinkedList3.insertLast(scanner.nextInt());
		}
		singleLinkedList.printLL(singleLinkedList3);
		System.out.println("");
		System.out.println("*************");
		singleLinkedList.printLL(singleLinkedList.mergeLL(singleLinkedList2,singleLinkedList3));
		System.out.println("");
		System.out.println("***Finished************");
		
	}*/
	
	/*
	*
	*    This is Get Node Value from tail postion
	*/

	for(int i=0;i<t;i++)
	{
		 singleLinkedList2 = new SingleLinkedList();
	    singleLinkedList3 = new SingleLinkedList();
		int n = scanner.nextInt();
		for(int j=0;j<n;j++){
			singleLinkedList2.insertLast(scanner.nextInt());
		}
		singleLinkedList.printLL(singleLinkedList2);
		int position = scanner.nextInt();
		System.out.println(singleLinkedList.getNode(singleLinkedList2, position));
		
	}
	
		scanner.close();
		/*singleLinkedList.insertFirst(10);
		singleLinkedList.insertFirst(20);
		singleLinkedList.insertFirst(30);
		singleLinkedList.insertFirst(40);
		singleLinkedList.insertFirst(50);
		// singleLinkedList.printLL();

		//SingleLinkedList singleLinkedList2 = new SingleLinkedList();
		//singleLinkedList2.insertLast(10);
		//singleLinkedList2.insertLast(20);
		//singleLinkedList2.insertLast(30);
		singleLinkedList2.insertLast(8);
		singleLinkedList2.insertLast(11);
		singleLinkedList2.insertLast(20);
		singleLinkedList2.insertLast(20);
		singleLinkedList2.insertLast(42);
		singleLinkedList2.insertLast(83);
		singleLinkedList2.insertLast(94);
		singleLinkedList2.insertLast(95);
		singleLinkedList2.printLL();

		
		singleLinkedList3.insertLast(1);
		singleLinkedList3.insertLast(20);
		singleLinkedList3.insertLast(30);
		singleLinkedList3.insertLast(40);
		singleLinkedList3.insertLast(50);
		singleLinkedList3.printLL();

		singleLinkedList.printLL(singleLinkedList.mergeLL(singleLinkedList2,singleLinkedList3));*/

	}

}
