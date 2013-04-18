package com.sirma.itt.javacourse.objects;

/**
 * A binary tree class - Each node is a number and can have 2 child nodes. The left one is with a
 * value smaller than the parent node, the right one is with a value bigger than the parent node.
 * 
 * @author user
 */
public class BinaryTree {
	private BinaryNode root;

	/**
	 * Binary tree constructor. Sets the root of the tree.
	 * 
	 * @param info
	 *            the value to be passed to the root of the tree
	 */
	public BinaryTree(int info) {
		this.root = new BinaryNode(info);
	}

	/**
	 * Adding integers to the tree. This is just the initial method that compares the node we want
	 * to add with the root node.
	 * 
	 * @param info
	 *            the value of the node we want to add
	 */
	void add(int info) {
		if (info > root.getInfo()) {
			if (root.getRight() != null) {
				add(info, root.getRight());
			} else {
				root.setRight(new BinaryNode(info));
			}
		} else if (info < root.getInfo()) {
			if (root.getLeft() != null) {
				add(info, root.getLeft());
			} else {
				root.setLeft(new BinaryNode(info));
			}
		}
	}

	/**
	 * Override method of the add method. After comparing the node with the root we pass it here and
	 * Recursively pass it to the next level until it finds its place.
	 * 
	 * @param info
	 *            the value of the node we want to add
	 * @param currNode
	 *            the node that we have currently reached
	 */
	private void add(int info, BinaryNode currNode) {
		if (info > currNode.getInfo()) {
			if (currNode.getRight() != null) {
				add(info, currNode.getRight());
			} else {
				currNode.setRight(new BinaryNode(info));
			}
		} else if (info < currNode.getInfo()) {
			if (currNode.getLeft() != null) {
				add(info, currNode.getLeft());
			} else {
				currNode.setLeft(new BinaryNode(info));
			}
		}
	}

	/**
	 * Printing out the tree using the In-order depth-first itteration thus printing it out sorted.
	 */
	void printSorted() {
		if (root.getLeft() != null) {
			printSorted(root.getLeft());
		}
		System.out.print(root.getInfo() + " ");
		if (root.getRight() != null) {
			printSorted(root.getRight());
		}
	}

	/**
	 * Overriding the printSorted method continuing from the root node.
	 * 
	 * @param currNode
	 *            the node that we have currently reached
	 */
	private void printSorted(BinaryNode currNode) {
		if (currNode.getLeft() != null) {
			printSorted(currNode.getLeft());
		}
		System.out.print(currNode.getInfo() + " ");
		if (currNode.getRight() != null) {
			printSorted(currNode.getRight());
		}

	}

	/**
	 * Searching for a given value in the tree. Traversing left or right depending if the value we
	 * are looking for is higher or lower than the current node's value.
	 * 
	 * @param info
	 *            the value we are looking for
	 * @return true if it finds the value, false if it does not
	 */
	boolean searchTree(int info) {
		if (info > root.getInfo() && root.getRight() != null) {
			return searchTree(info, root.getRight());
		} else if (info < root.getInfo() && root.getRight() != null) {
			return searchTree(info, root.getLeft());
		} else
			return info == root.getInfo();

	}

	/**
	 * The overloaded method continuing from the root.
	 * 
	 * @param info
	 *            the value we are looking for
	 * @param currNode
	 *            the node that we have currently reached
	 * @return true if it finds the value, false if it does not
	 */
	private boolean searchTree(int info, BinaryNode currNode) {
		if (info > currNode.getInfo() && currNode.getRight() != null) {
			return searchTree(info, currNode.getRight());
		} else if (info < currNode.getInfo() && currNode.getLeft() != null) {
			return searchTree(info, currNode.getLeft());
		} else
			return info == currNode.getInfo();
	}

	/**
	 * Getter method for root.
	 * 
	 * @return the root
	 */
	public BinaryNode getRoot() {
		return root;
	}

	/**
	 * Setter method for root.
	 * 
	 * @param root
	 *            the root to set
	 */
	public void setRoot(BinaryNode root) {
		this.root = root;
	}

}
