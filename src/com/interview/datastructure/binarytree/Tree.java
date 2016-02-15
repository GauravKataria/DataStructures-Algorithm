package com.interview.datastructure.binarytree;
import com.interview.datastructure.queue.Queue;
import com.interview.datastructure.stack.Stack;

public class Tree {
	Node<Integer> root = null;
	
	public void inOrder(Node<Integer> node){
		if(node==null) return;
		
		inOrder(node.left);
		System.out.print(node.data);
		inOrder(node.right);
	}
	
	public void inOrderIterative(Node<Integer> node){
		if(node==null) {return;}
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		stack.push(node);
		
		while(stack.getSize()!=0){
			while(stack.top()!=null){
				stack.push(stack.top().left);
			}
			
			Node<Integer> top=stack.pop();
			if(top==null && stack.getSize()>0) top=stack.pop();
			if(top==null && stack.getSize()==0) return;
			
			System.out.print(top.data);
			stack.push(top.right);
		}
	}
	
	public void preOrder(Node<Integer> node){
		if(node==null) return;
		
		System.out.print(node.data);
		preOrder(node.left);
		preOrder(node.right);		
	}

	public void preOrderIterative(Node<Integer> node){
		
	}

	public void postOrder(Node<Integer> node){
		if(node==null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data);

	}

	public void postOrderIterative(Node<Integer> node){
		
	}
	
	public void levelOrderUsingPrintLevelFun(Node<Integer> node){
		int height = height(node);
		for(int i=0;i<height;i++){
			printLevel(node, i);
			System.out.println();
		}
	}
	
	private void printLevel(Node<Integer> node, int i) {
		if(node==null) {
			return;
		}
		if(i==0){ 
			System.out.print(node.data);
			return;
		}
		printLevel(node.left, i-1);
		printLevel(node.right, i-1);
	}

	public void levelOrderUsingQueue(Node<Integer> node){
		if(node==null) return;
		
		Queue<Node<Integer>> queue = new Queue<Node<Integer>>();
		queue.enqueue(node);
		int levelPrinter=1;
		
		while(!queue.isEmpty()){
			levelPrinter-=1;
			Node<Integer> temp = queue.dequeue();
			System.out.print(temp.data);
			
			if(temp.left!=null){queue.enqueue(temp.left);}
			if(temp.right!=null){queue.enqueue(temp.right);}
			
			if(levelPrinter==0) {
				levelPrinter=queue.size();	//if u want to avoid use of size function with one more variable logic can be build here
				System.out.println();
			}
		}
		
	}
	
	public int height(Node<Integer> node){
		if(node==null){return 0;}
		return 1+max(height(node.left), height(node.right));
	}

	protected int max(int h1, int h2) {
		if(h1>h2) return h1;
		else return h2;
	}
		
	public int width(Node<Integer> node) {
		int height = height(node);
		int width=0;
		for(int i=0;i<height;i++){
			int temp = widthAtLevel(node, i);
			if(width<temp) width=temp;
		}
		return width;
	} 
		
	private int widthAtLevel(Node<Integer> node, int i) {
		if(node==null) {
			return 0;
		}
		if(i==0){ 
			return 1;
		}

		return widthAtLevel(node.left, i-1) + widthAtLevel(node.right, i-1);
	}

	public static boolean sameTree(Node<Integer> root1, Node<Integer> root2){
		if(root1==null && root2 == null) return true;
		if(root1==null && root2 != null || root1!=null && root2 == null) return false;
		if(root1.data!=root2.data) return false;
		
		return sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
	}
	
	public static boolean subTree(Node<Integer> root1, Node<Integer> root2){
		if(root1==null && root2 == null) return true;
		if(root1==null && root2 != null || root1!=null && root2 == null) return false;

		if(root1.data==root2.data) {
			return sameTree(root1, root2);
		}
			
		return subTree(root1.left,root2)||subTree(root1.right,root2);
	}
	
	public void printAnsitor() {
		
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		
		tree.root = new Node<Integer>(1);
		tree.root.left = new Node<Integer>(2);
		tree.root.left.left = new Node<Integer>(4);
		tree.root.left.right = new Node<Integer>(5);
		tree.root.right = new Node<Integer>(3);
		
		tree.inOrder(tree.root);
		System.out.println();
//		tree.preOrder(tree.root);
//		System.out.println();		
//		tree.postOrder(tree.root);
//		System.out.println();				
//		tree.levelOrderUsingQueue(tree.root);
//		System.out.println(tree.height(tree.root));				
//		System.out.println();				
//		tree.levelOrderUsingPrintLevelFun(tree.root);
//		System.out.println();				
//		tree.inOrderIterative(tree.root);
//		System.out.println("\nWidth : "+ tree.width(tree.root));
		
		
		Tree tree2 = new Tree();
		
		tree2.root = new Node<Integer>(9);		
		tree2.root.left = new Node<Integer>(1);
		tree2.root.left.left = new Node<Integer>(2);
		tree2.root.left.left.left = new Node<Integer>(4);
		tree2.root.left.left.right = new Node<Integer>(5);
		tree2.root.left.right = new Node<Integer>(3);
		
		System.out.println("SubTree : " + subTree(tree2.root,tree.root));
		
	}
}
