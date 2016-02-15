package com.interview.datastructure.linklist;

public class NodeList<T>{
	public T data;
	public NodeList<T> next;
	
	NodeList(){}
	
	public NodeList(T data){
		this.data = data;
		this.next = null;
	}
}