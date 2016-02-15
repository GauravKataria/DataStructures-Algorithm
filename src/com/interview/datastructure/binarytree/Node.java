package com.interview.datastructure.binarytree;

public class Node<T> {
	T data;
	Node<T> left;
	Node<T> right;

	Node(){	
	}
	
	Node(T data){
		this.data=data;
		left=null;
		right=null;
	}
}
