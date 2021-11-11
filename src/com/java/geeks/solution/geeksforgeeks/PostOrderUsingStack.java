package com.java.geeks.solution.geeksforgeeks;

//A java program for iterative postorder traversal using stack

import java.util.ArrayList;
import java.util.Stack;

//A binary tree node


class PostOrderUsingStack
{
	Node root;
	ArrayList<Integer> list = new ArrayList<Integer>();

	// An iterative function to do postorder traversal
	// of a given binary tree
	ArrayList<Integer> postOrderIterative(Node node)
	{
		Stack<Node> S = new Stack<Node>();
		
		// Check for empty tree
		if (node == null)
			return list;
		S.push(node);
		Node prev = null;
		while (!S.isEmpty())
		{
			Node current = S.peek();

			/* go down the tree in search of a leaf an if so process it
			and pop stack otherwise move down */
			if (prev == null || prev.left == current ||
										prev.right == current)
			{
				if (current.left != null)
					S.push(current.left);
				else if (current.right != null)
					S.push(current.right);
				else
				{
					S.pop();
					list.add(current.data);
				}

				/* go up the tree from left node, if the child is right
				push it onto stack otherwise process parent and pop
				stack */
			}
			else if (current.left == prev)
			{
				if (current.right != null)
					S.push(current.right);
				else
				{
					S.pop();
					list.add(current.data);
				}
				
				/* go up the tree from right node and after coming back
				from right node process parent and pop stack */
			}
			else if (current.right == prev)
			{
				S.pop();
				list.add(current.data);
			}

			prev = current;
		}

		return list;
	}
	
	Node getNode(int data) {
		return new Node(data);
	}
	// Driver program to test above functions
	public static void main(String args[])
	{
		PostOrderUsingStack tree = new PostOrderUsingStack();

		// Let us create trees shown in above diagram
		tree.root = tree.getNode(1);
		tree.root.left = tree.getNode(2);
		tree.root.right = tree.getNode(3);
		tree.root.left.left = tree.getNode(4);
		tree.root.left.right = tree.getNode(5);
		tree.root.right.left = tree.getNode(6);
		tree.root.right.right = tree.getNode(7);

		ArrayList<Integer> mylist = tree.postOrderIterative(tree.root);
		
		System.out.println("Post order traversal of binary tree is :");
		System.out.println(mylist);
	}
	
	private class Node
	{
		int data;
		Node left, right;

		Node(int item)
		{
			data = item;
			left = right;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}
}


//This code has been contributed by Mayank Jaiswal

