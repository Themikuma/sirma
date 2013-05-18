package com.sirma.itt.javacourse.objects.task4_2;

import java.util.ArrayList;
import java.util.List;

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
	public void add(int info) {
		add(info, root);
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
	 * * Printing out the tree using the In-order depth-first itteration thus printing it out
	 * sorted.
	 * 
	 * @return an arraylist with the sorted elements
	 */
	public List<Integer> printSorted() {
		return printSorted(root, new ArrayList<Integer>());
	}

	/**
	 * * Overriding the printSorted method continuing from the root node.
	 * 
	 * @param currNode
	 *            the node that we have currently reached
	 * @param path
	 *            a list with the elements we traversed so far
	 * @return the list with the sorted elements
	 */
	private List<Integer> printSorted(BinaryNode currNode, List<Integer> path) {
		if (currNode.getLeft() != null) {
			printSorted(currNode.getLeft(), path);
		}
		path.add(currNode.getInfo());
		if (currNode.getRight() != null) {
			printSorted(currNode.getRight(), path);
		}
		return path;

	}

	/**
	 * Searching for a given value in the tree. Traversing left or right depending if the value we
	 * are looking for is higher or lower than the current node's value.
	 * 
	 * @param info
	 *            the value we are looking for
	 * @return true if it finds the value, false if it does not
	 */
	public boolean searchTree(int info) {
		return searchTree(info, root);

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
