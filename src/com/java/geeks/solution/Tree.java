package com.java.geeks.solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Tree {
	
	 class Node{
		int data;
		Node left;
		Node right;
		int ht;
		
		 Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
			this.ht =0;
		}
	}
	
	private Node root;
	static int preOrderIndex = 0;
	static int postOrderIndex = 0;
	static int sum = 0;
	public Tree(){
	}
	
	public Tree(Node root){
		this.root  = root;
	}
	
	class QNode{
		Node node;
		int hd;
		
		public QNode(Node node,int hd) {
			this.node = node;
			this.hd = hd;
		}
	}

	public void insert(int data){
		this.root = insert(this.root,data);
		
	}

	private Node insert(Node root, int data) {
		if(root == null){
			root = new Node(data);
			return root;
		}

		if(data <= root.data){
			root.left = insert(root.left,data);
		}else if(data > root.data){
			root.right = insert(root.right,data);
		}
		return root;
	}
	
	
	public void inOrder(){
		 System.out.println("In Order Traversal");
		 this.root = inOrder(this.root);
		 System.out.println(" ");
	}
	
	private Node inOrder(Node root) {
		if(root == null){
			return null;
		}
		root.left = inOrder(root.left);
		System.out.print(" "+ root.data);
		root.right = inOrder(root.right);
		return root;
	}

	public void postOrder(){
		System.out.println("Post Order");
		this.root = postOrder(this.root);
		System.out.println(" ");
	}
	
	private Node postOrder(Node root) {
		if(root == null){
			return null;
		}
		root.left = postOrder(root.left);
		root.right = postOrder(root.right);
		System.out.print(" " + root.data);
		return root;
	}

	public void preOrder(){
		System.out.println("Pre Order Traversal");
		this.root = preOrder(this.root);
		System.out.println(" ");
	}
	
	private Node preOrder(Node root) {
		if(root == null){
			return null;
		}
		System.out.print(" "+root.data);
		root.left = preOrder(root.left);
		root.right = preOrder(root.right);
		return root;
	}
	
	public void levelOrder(){
		System.out.println("Level Order ");
		levelOrder(this.root);
		System.out.println(" ");
		
	}

	private Node levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		if(root == null){
			return null;
		}
		queue.add(root);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size > 0){
				size--;
				Node node = queue.remove();
				System.out.print(" " + node.data);
				if(node.left!= null)
					queue.add(node.left);
				if(node.right!= null)
					queue.add(node.right);
			}
		}
		return root;
	}

	public int height() {
		System.out.println("Height of the Tree");
		int height = height(this.root);
		return height;
		
	}
	
	private int height(Node root) {
		if(root == null)
			return -1;
		int height = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			height++;
			while(size>0){
				size--;
				Node node = queue.remove();
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}
		}
		return height;
	}
	
	private int height(int data) {
		System.out.println("Height of the Node "+data);
		int height = height(this.root,data);
		return height;
	}

	private int height(Node root, int data) {
		int height = 0;
		if(root==null)
			return height;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			height ++;
			while(size > 0){
				size--;
				Node node = queue.remove();
				if(node.data == data)
					return height;
				if( node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}
		}
		return 0;
	}
	
	private void mirror() {
		this.root = mirror(this.root);
	}

	private Node mirror(Node root) {
		if(root == null){
			return root;
		}
		Node left = mirror(root.left);
		Node right = root.right;mirror(root.right);
		root.left = right;
		root.right = left;
		
		return root;
	}

	private int sumOfTree() {
		System.out.println("Sum of all the Node in the Tree");
		int sum  = sumOfTree(this.root);
		return sum;
	}

	private int sumOfTree(Node root) {
		if(root == null)
			return -1;
		int sum = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size>0){
				size--;
				Node node = queue.remove();
				sum+=node.data;
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}
		}
		return sum;
	}

	private Tree createTreeUsingInOrderPreOrder(int[] inOrder, int[] preOrder) {
		
		System.out.println("Create Tree Using InOrder and PreOrder");
		preOrderIndex = 0;
		Node node = buildTreeInOderPreOrder(inOrder,preOrder,0,preOrder.length-1);
		Tree tree = new Tree(node);
		return tree;
	}

	private Node buildTreeInOderPreOrder(int[] inOrder, int[] preOrder, int start, int end) {
		if(start > end)
			return null;
			Node node = new Node(preOrder[preOrderIndex++]);
			if(start == end)
				return node;
			
			int index = findIndex(inOrder,start,end,node.data);
			
			node.left = buildTreeInOderPreOrder(inOrder, preOrder, start, index-1);
			node.right = buildTreeInOderPreOrder(inOrder, preOrder, index+1, end);
			return node;
	}

	private int findIndex(int[] inOrder, int start, int end,int item) {
		int index = -1;
		for(int i=start;i<=end;i++){
			if(inOrder[i]==item)
				return i;
		}
		return index;
	}

	

	private void leftView() {
		Queue<Node> queue = new LinkedList<>();
		if(this.root == null)
			return;
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			Node lNode = null;
			while(size > 0){
				size--;
				if(lNode==null)
					lNode = queue.peek();
				Node node = queue.remove();
				if(node.right != null)
					queue.add(node.right);
				if(node.left != null)
					queue.add(node.left);
			}
			System.out.print(" " + lNode.data);
		}
		System.out.println(" ");
	}
	
	private void rightView() {
		Queue<Node> queue = new LinkedList<>();
		if(this.root == null)
			return;
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			Node lNode = null;
			while(size > 0){
				size--;
				if(lNode==null)
					lNode = queue.peek();
				Node node = queue.remove();
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}
			System.out.print(" " + lNode.data);
		}
		System.out.println(" ");
	}

	private Tree createTreeUsingInOrderPostOrder(int[] inOrder, int[] postOrder) {
		postOrderIndex = postOrder.length - 1;
		System.out.println("Create Tree Using InOrder and PostOrder");
		Node node = buildTreeInOderPostOrder(inOrder,postOrder,0,postOrder.length-1);
		Tree tree = new Tree(node);
		return tree;
	}

	private Node buildTreeInOderPostOrder(int[] inOrder, int[] postOrder, int start, int end) {
		if(start > end)
			return null;
		Node node = new Node(postOrder[postOrderIndex--]);
		if(start == end)
			return node;
		int index = findIndex(inOrder, start, end, node.data);
		node.right = buildTreeInOderPostOrder(inOrder, postOrder, index+1, end);
		node.left = buildTreeInOderPostOrder(inOrder, postOrder, start, index-1);
		
		
		return node;
	}
	
	private void topview(){
		if(root == null)
			return;
		
		Queue<QNode> queue = new LinkedList<>();
		queue.add(new QNode(root, 0));
		Set<Integer> set = new HashSet<>();
		Set<Integer> treeSet = new TreeSet();
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size > 0){
				size--;
				QNode qNode = queue.remove();
				int hd = qNode.hd;
				Node node = qNode.node;
				
				if(!set.contains(hd)){
					set.add(hd);
					System.out.print(node.data + " ");
					treeSet.add(node.data);
				}
				
				if(node.left!= null)
					queue.add(new QNode(node.left, hd-1));
				if(node.right!= null)
					queue.add(new QNode(node.right, hd+1));
			}
		}
		/*Iterator<Integer> iterator = treeSet.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
		}*/
	}
	
	Node lowestCommomAncestorBinarySearch(Node root,Node root1,Node root2){
		if(root.data > max(root1.data,root2.data ))
			return lowestCommomAncestorBinarySearch(root.right,root1, root2);
		else if( root.data < max(root1.data,root2.data))
			return lowestCommomAncestorBinarySearch(root.left,root1, root2);
		else{
			return root;
		}
	}
	
	Node lowestCommomAncestorBinaryTree(Node root,Node root1,Node root2){
		if(root == null)
			return null;
		if(root.data == root1.data || root.data == root2.data){
			if(root.data == root1.data)
				return root1;
			else
				return root2;
		}
		Node left = lowestCommomAncestorBinaryTree(root.left, root1, root2);
		Node right = lowestCommomAncestorBinaryTree(root.right, root1, root2);
		if(left == null && right == null)
			return null;
		if(left != null && right != null)
			return root;
		if(left!=null)
			return left;
		if(right!=null)
			return right;
		return null;
	}
	
	

	private int max(int data, int data2) {
		if(data > data2){
			return data;
		}
		return data2;
	}

	public static void main(String[] args) {
		
		Tree tree = new Tree();
		tree.insert(10);
		tree.insert(9);
		tree.insert(8);
		tree.insert(7);
		tree.insert(6);
		tree.insert(5);
		tree.insert(4);
		
		/*tree.insert(10);
		tree.insert(5);
		tree.insert(20);
		tree.insert(1);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(15);
		tree.insert(25);
		tree.insert(14);
		tree.insert(24);
		tree.insert(30);*/
		
		
		tree.inOrder();
		tree.postOrder();
		tree.preOrder();
		tree.levelOrder();
		
		System.out.println(tree.height());
		System.out.println(tree.height(25));
		System.out.println(tree.sumOfTree());
		tree.leftLeafSum();
		
		/*Tree tree1 = new Tree();
		tree1.insert(10);
		tree1.insert(5);
		tree1.insert(20);
		tree1.insert(1);
		tree1.insert(7);
		tree1.insert(8);
		tree1.insert(9);
		tree1.insert(15);
		tree1.insert(25);
		tree1.inOrder();
		System.out.println("Mirror Image");
		tree1.mirror();
		tree1.inOrder();
		int inOrder[] = {1,5,7,8,9,10,15,20,25};
		int preOrder[] = {10,5,1,7,8,9,20,15,25};
		int postOrder[] = {1,9,8,7,5,15,25,20,10};
		Tree tree3 = new Tree();
		tree3 =	tree3.createTreeUsingInOrderPreOrder(inOrder,preOrder);
		tree3.inOrder();
		tree3 = tree3.createTreeUsingInOrderPostOrder(inOrder,postOrder);
		tree3.inOrder();
		tree1.leftView();
		tree1.rightView();*/
		
		/*Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		Tree tree4 = new Tree();
		
		while(t-- >0){
			int data = scanner.nextInt();
			tree4.insert(data);
		}
		scanner.close();
		tree4.topview();*/
		/*Tree tree5 = new Tree();
		tree5 = tree5.constructBinaryTree();
		//System.out.println(tree5.lowestCommomAncestorBinaryTree(tree5.root,tree5.getNode(8),tree5.getNode(2)).data);
		
		tree5 = tree5.convertToDLL();
		tree5.printDLL();*/

		Tree tree6 = new Tree();
		tree6.constructBinaryTree();
	}
	//Need more testing
	private void leftLeafSum() {
		if(this.root == null)
			return;
		sum = 0;
		leftLeafSum(this.root);
		System.out.println("Left leaf Sum = "+sum);
		
	}

	private Node leftLeafSum(Node root) {
		if(root==null){
			return null;
		}
		Node left = leftLeafSum(root.left);
		Node right = leftLeafSum(root.right);
		if(left == null &&  right== null)
			return root;
		if(left!=null)
			sum = sum+ left.data;
		if(right!=null)
			return null;
			
		return null;
	}

	private void printDLL() {
		Node temp = this.root;
		while(temp!= null){
			System.out.print(temp.data + " ");
			temp =temp.right;
		}
	}

	private Tree convertToDLL() {
		if(this.root == null)
			return null;
		Node node = binaryTreeToDLL(this.root);
		while(node.left!=null)
			node= node.left;
		Tree tree = new Tree(node);
		return tree;
		
	}

	private Node binaryTreeToDLL(Node root) {
		if(root == null)
			return root;
		if(root.left!= null){
			Node left = binaryTreeToDLL(root.left);
			for(;left.right!=null;left = left.right);
			
			left.right = root;
			root.left = left;
		}
		if(root.right != null){
			Node right = binaryTreeToDLL(root.right);
			for(;right.left!= null; right = right.left);
			right.left = root;
			root.right = right;
		}
		return root;
	}

	private Node getNode(int data){
		return new Node(data);
	}

	private Tree constructBinaryTree() {
		/*Node node3 = new Node(3);
		Node node6 = new Node(6);
		Node node2 = new Node(2);
		Node node11 = new Node(11);
		Node node9 = new Node(9);
		Node node5 = new Node(5);
		Node node8 = new Node(8);
		Node node13 = new Node(13);
		Node node7 = new Node(7);
		
		node3.left = node6;
		node3.right = node8;
		node6.left = node2;
		node6.right = node11;
		node11.left = node9;
		node11.right = node5;
		node8.right = node13;
		node13.left = node7;
		
		Tree tree = new Tree(node3);
		return tree;*/
		/*Node node = new Node(10);
		node.left = new Node(12);
		node.left.left	= new Node(25);
		node.left.right = new Node(30);
		node.right = new Node(15);
		node.right.left = new Node(36);
		Tree tree = new Tree(node);*/
		
		Tree avlTree = new Tree();
		avlTree.insertAVL(10);
		avlTree.insertAVL(5);
		avlTree.insertAVL(20);
		avlTree.insertAVL(4);
		avlTree.insertAVL(25);
		avlTree.insertAVL(19);
		avlTree.insertAVL(15);
		avlTree.insertAVL(17);
		
		return avlTree;
	}

	private void insertAVL(int data) {
		/*this.root = */
		this.root = insertAVL(this.root,data);
	}

	private Node insertAVL(Node root, int data) {
		if(root == null){
			root = new Node(data);
			return root;
		}
		if(data<= root.data){
			//root.height = root.height + 1;
			root.left = insertAVL(root.left,data);
		}else{
			root.right = insertAVL(root.right,data);
		}
		int diff = heightOfNode(root.left) - heightOfNode(root.right);
		if(diff > 1){
			if(heightOfNode(root.left.left) > heightOfNode(root.left.right)){
				return rotateRight(root);
			}else{
				root.left = rotateLeft(root.left);
				return rotateRight(root);
			}
		}
		if(diff < -1){
			if(heightOfNode(root.right.right) > heightOfNode(root.right.left)){
				return rotateLeft(root);
			}else{
				root.right = rotateRight(root.right);
				return rotateLeft(root);
			}
			
		}
		root.ht = 1+ max(root.left, root.right);
		return root;
	}

	private Node rotateRight(Node root) {
		Node newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		root.ht = max(root.left,root.right)+1;
		newRoot.ht = max(newRoot.left,newRoot.right)+1;
		return newRoot;
	}

	private Node rotateLeft(Node root) {
		Node newNode = root.right;
		root.right = newNode.left;
		newNode.left = root;
		root.ht = max(root.left,root.right)+1;
		newNode.ht = max(newNode.left,newNode.right)+1;
		return newNode;
	}

	private int heightOfNode(Node root) {
		if(root == null)
			return -1;
		else
			return root.ht;
	}
		
	private int max(Node left,Node right){
		if(left == null && right == null)
			return -1;
		if(left!=null && right!= null)
			return (left.ht>=right.ht)?left.ht:right.ht;
		else if(left == null && right != null){
			return right.ht;
		}if(right == null && left != null){
			return left.ht;
		}
		return -1;
	}
	
}
