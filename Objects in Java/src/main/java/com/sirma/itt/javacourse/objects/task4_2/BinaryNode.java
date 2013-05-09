package com.sirma.itt.javacourse.objects.task4_2;

/**
 * The binary tree node. It has a value and 2 child nodes.
 * 
 * @author user
 */
public class BinaryNode {
	private int info;
	private BinaryNode left;
	private BinaryNode right;

	/**
	 * The binary node constructor. Set's the current node's value.
	 * 
	 * @param info
	 *            value to be assigned to the current node
	 */
	public BinaryNode(int info) {
		this.info = info;
	}

	/**
	 * Getter method for info.
	 * 
	 * @return the info
	 */
	public int getInfo() {
		return info;
	}

	/**
	 * Setter method for info.
	 * 
	 * @param info
	 *            the info to set
	 */
	public void setInfo(int info) {
		this.info = info;
	}

	/**
	 * Getter method for left.
	 * 
	 * @return the left
	 */
	public BinaryNode getLeft() {
		return left;
	}

	/**
	 * Setter method for left.
	 * 
	 * @param left
	 *            the left to set
	 */
	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	/**
	 * Getter method for right.
	 * 
	 * @return the right
	 */
	public BinaryNode getRight() {
		return right;
	}

	/**
	 * Setter method for right.
	 * 
	 * @param right
	 *            the right to set
	 */
	public void setRight(BinaryNode right) {
		this.right = right;
	}

}