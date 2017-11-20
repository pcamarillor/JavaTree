package tree;

import java.util.ArrayList;
import java.util.Stack;

public class Tree {
	private Node root;
	
	public Tree(){
		root = new Node();
	}
	
	public void setRoot(Node r) {
		this.root = r;
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	public ArrayList<Integer> inOrderRecursive(){
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		this.root.inOrderRecursive(inorder);
		return inorder;
	}
	
	public ArrayList<Integer> inOrderIterative() {
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		Stack<Node> S = new Stack<Node>();
		Node current = this.root;
		S.push(current);
		
		while(!S.isEmpty()){
			Node L = current.getLeft();
			Node R = current.getRight();
		
			// Process Left sub-tree
			if(L != null) {
				if(!L.isVisited()) {
					S.push(L);
					current = L;
					continue;
				}
			}
			if(L == null && R != null) {
				if(!R.isVisited()) {
					if(!current.isVisited()) {
						current.setVisited(true);
						inorder.add(current.getData());	
						S.push(R);
					}
					current = R;
					continue;
				}
			}
			if(L == null && R == null) {
				// Insert current data to the inOrder path
				if(!current.isVisited()) {
					current.setVisited(true);
					inorder.add(current.getData());
					current = S.pop();
					if(!S.empty()) {
						current = S.pop();
						if(!current.isVisited()) {
							inorder.add(current.getData());
							current.setVisited(true);
						}
						if(S.empty() && current.getRight() != null) {
							if(!current.getRight().isVisited()) {
								S.push(current);
								current = current.getRight();
								continue;
							}
						}
						
					}
					
				}
			}
			if(R != null) {
				if(!R.isVisited()) {
					S.push(R);
					current = R;
				}
			}
			
		}
		return inorder;
	}
	
	public ArrayList<Integer> preOrderRecursive(){
		ArrayList<Integer> preorder = new ArrayList<Integer>();
		this.root.preOrderRecursive(preorder);
		return preorder;
	}

	public ArrayList<Integer> preOrderIterative() {
		ArrayList<Integer> preorder = new ArrayList<Integer>();
		Stack<Node> S = new Stack<Node>();
		Node current = this.root;
		S.push(current);
		
		while(!S.empty()) {
			current = S.pop();
			preorder.add(current.getData());
			if(current.getRight() != null) {
				S.push(current.getRight());
			}
			while(current.getLeft() != null) {
				current = current.getLeft();
				preorder.add(current.getData());
				if(current.getRight() != null) {
					S.push(current.getRight());
				}
				
			}
		}
		
		return preorder;
	}
	
	public ArrayList<Integer> postOrderRecursive(){
		ArrayList<Integer> postorder = new ArrayList<Integer>();
		this.root.postOrderRecursive(postorder);
		return postorder;
	}
	
	public ArrayList<Integer> postOrderIterative(){
		ArrayList<Integer> postorder = new ArrayList<Integer>();
		Stack<Node> S = new Stack<Node>();
		Node current = this.root;
		S.push(current);
		while(!S.empty()) {
			current = S.peek();
			if(current.getRight() != null) {
				S.push(current.getRight());
				current = current.getRight();
			}
			while(current.getLeft() != null) {
				S.push(current.getLeft());
				current = current.getLeft();
			}
			
			// At the end of the tree, we add the Left son
			postorder.add(current.getData());
			current.setVisited(true);
			
		}
		return postorder;
	}
}
