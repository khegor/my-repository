package com.rocksoft.LogStr.tree;

public class BinaryInsertDeleteTree {

	private Node createNewNode(double point) {
		Node a = new Node(point);
		a.setData(point);
		a.setLeft(null);
		a.setRight(null);
		return a;

	}

	public Node insert(Node node, double val) {
		if (node == null) {
			return createNewNode(val);
		}
		if (val < node.getData()) {
			node.setLeft(insert(node.getLeft(), val));
		} else if (val > node.getData()) {
			node.setRight(insert(node.getRight(), val));
		}
		return node;
	}
	

	public Node delete(Node node, double val) {
		if (node == null) {
			return null;
		}
		if (val < node.getData()) {
			node.setLeft(delete(node.getLeft(), val));
		} else if (val > node.getData()) {
			node.setRight(delete(node.getRight(), val));
		} else {
			if (node.getLeft() == null || node.getRight() == null) {
				Node temp = null;
				temp = node.getLeft() == null ? node.getRight() : node.getLeft();

				if (temp == null) {
					return null;
				} else {
					return temp;
				}
			} else {
				Node change = getChange(node);
				node.setData(change.getData());
				node.setRight(delete(node.getRight(), val));
				return node;
			}
		}
		return node;
	}

	private Node getChange(Node node) {
		if (node == null) {
			return null;
		}
		Node temp = node.getRight();
		while (temp != null) {
			temp = temp.getLeft();
		}
		return temp;
	}
	
	public void printTree(Node node) {
		Node currentNode = getLeftNode(node);
		while(currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getRight();
		}
	}
	
	private Node getLeftNode(Node node) {
		if(node.getLeft() != null) {
			getLeftNode(node.getLeft());
		}
		return node;	
	}
}
