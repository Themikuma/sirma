package com.sirma.itt.javacourse.objects.task4_1;

/**
 * A tree class. The tree is a collection of nodes containing data of the same type. The main node
 * is called a root.
 * 
 * @param <T>
 * @author user
 */
public class Tree<T> {
	private Node<T> root;

	/**
	 * The constructor of the tree. Creates the root.
	 * 
	 * @param info
	 *            the information that the root will contain
	 */
	public Tree(T info) {
		root = new Node<T>(info);
	}

	/**
	 * Getter method for root.
	 * 
	 * @return the root
	 */
	public Node<T> getRoot() {
		return root;
	}

	/**
	 * Setter method for root.
	 * 
	 * @param root
	 *            the root to set
	 */
	public void setRoot(Node<T> root) {
		this.root = root;
	}

}
