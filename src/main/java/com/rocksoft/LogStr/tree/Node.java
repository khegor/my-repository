package com.rocksoft.LogStr.tree;

public class Node {

	private double data;
	private Node left;
	private Node right;

	public Node(double point) {
		this.setData(point);
	}

	public Node() {

	}
	
	public boolean hasNext() {
		return this.getRight() != null;
	}

	public Node getRight() {
		return this.right;
	}
	
	public double getData() {
		return this.data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setData(double data) {
		this.data = data;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
