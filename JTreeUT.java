package tree;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class JTreeUT {

	@Test
	public void testInOrderIterative() {
		Tree myTree = populateTree();
		
		ArrayList<Integer> pathRecursive = myTree.inOrderRecursive();
		ArrayList<Integer> pathIterative = myTree.inOrderIterative();
		
		
		// Convert list to String and compare to be equals
		StringBuilder sbRecursive = populateSB(pathRecursive);
		StringBuilder sbIterative = populateSB(pathIterative);

		assertEquals(sbRecursive.toString(), sbIterative.toString());
		
	}

	@Test
	public void testPreOrderIterative() {
		Tree preOrderTree = populateTree();
		
		ArrayList<Integer> pathRecursive = preOrderTree.preOrderRecursive();
		ArrayList<Integer> pathIterative = preOrderTree.preOrderIterative();
		
		
		// Convert list to String and compare to be equals
		StringBuilder sbRecursive = populateSB(pathRecursive);
		StringBuilder sbIterative = populateSB(pathIterative);

		assertEquals(sbRecursive.toString(), sbIterative.toString());
		
	}

	
	@Test
	public void testPosrOrderIterative() {
		Tree preOrderTree = populateTree();
		
		ArrayList<Integer> pathRecursive = preOrderTree.postOrderRecursive();
		ArrayList<Integer> pathIterative = preOrderTree.postOrderIterative();
		
		
		// Convert list to String and compare to be equals
		StringBuilder sbRecursive = populateSB(pathRecursive);
		StringBuilder sbIterative = populateSB(pathIterative);

		assertEquals(sbRecursive.toString(), sbIterative.toString());
		
	}
	
	private Tree populateTree() {
		Tree myTree = new Tree();
		Node a1 = new Node(1);
		Node a2 = new Node(2);
		Node a3 = new Node(3);
		Node a4 = new Node(4);
		Node a5 = new Node(5);
		Node a6 = new Node(6);
		Node a7 = new Node(7);
		Node a8 = new Node(8);
		Node a9 = new Node(9);
		Node a10 = new Node(10);
		Node a11 = new Node(11);
		Node a12 = new Node(12);
		
		a2.setLeft(a1);
		a2.setRight(a3);
		
		a5.setLeft(a4);
		a5.setRight(a6);
		
		a11.setLeft(a2);
		a11.setRight(a5);
		
		a9.setRight(a10);
		a9.setLeft(a12);
		
		a8.setRight(a9);
		
		a7.setLeft(a11);
		a7.setRight(a8);
		
		myTree.setRoot(a7);
		return myTree;
	}

	private StringBuilder populateSB(ArrayList<Integer> path) {
		StringBuilder sb = new StringBuilder();
		for(Integer i: path) {
			sb.append(i);
			sb.append("/t");
		}
		
		return sb;
	}

}
