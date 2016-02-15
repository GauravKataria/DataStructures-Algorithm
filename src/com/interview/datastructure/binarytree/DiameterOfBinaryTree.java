package com.interview.datastructure.binarytree;

public class DiameterOfBinaryTree extends Tree{
	
	//O(n^2)
	public int diameter(Node<Integer> node) {
		if(node==null) return 0;
		
		int heightLeft = height(node.left);		
		int heightRight = height(node.right);
		
		return max(heightLeft+heightRight+1, max(diameter(node.left), diameter(node.right)));
	} 

	//O(n)
	public static void main(String[] args) {
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree(); 

		tree.root = new Node<Integer>(1);
        tree.root.left = new Node<Integer>(2);
        tree.root.right = new Node<Integer>(3);
        tree.root.left.left = new Node<Integer>(4);
        tree.root.left.right = new Node<Integer>(5);
		
		System.out.println("Diameter : " + tree.diameter(tree.root));
	}
}
