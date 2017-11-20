package tree;

import java.util.ArrayList;

public class Node {
	private Node left;
	private Node right;
	private int data;
	private boolean visited;
	
	public Node()
	{
		data = 0;
		left = null;
		right = null;
		visited = false;
	}
	
	public Node(int inputData)
	{
		data = inputData;
		left = null;
		right = null;
	}
	
	public void setVisited(boolean v) {
		this.visited = v;
	}
	
	public boolean isVisited() {
		return this.visited;
	}
	
	public void setLeft(Node l) {
		this.left = l;
	}
	
	public void setRight(Node r) {
		this.right = r;
	}
	
	public Node getLeft(){
		return this.left;
	}
	
	public Node getRight(){
		return this.right;
	}
	
	public void setData(int new_data) {
		this.data = new_data;
	}
	
	public int getData() {
		return this.data;
	}
	
	
	public void inOrderRecursive(ArrayList<Integer> path) {
		if(this.left != null) {
			this.left.inOrderRecursive(path);
		}
		path.add(new Integer(this.data));
		if(this.right != null) {
			this.right.inOrderRecursive(path);
		}
	}

	public void preOrderRecursive(ArrayList<Integer> preorder) {
		preorder.add(new Integer(this.data));
		if(this.left != null) {
			this.left.preOrderRecursive(preorder);
		}
		if(this.right != null) {
			this.right.preOrderRecursive(preorder);
		}
	}
	
	public void postOrderRecursive(ArrayList<Integer> postOrder) {
		if(this.left != null) {
			this.left.postOrderRecursive(postOrder);
		}
		if(this.right != null) {
			this.right.postOrderRecursive(postOrder);
		}
		postOrder.add(new Integer(this.data));
	}
	
	
}

