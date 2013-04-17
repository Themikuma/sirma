package com.sirma.itt.javacourse.objects;

import java.util.ArrayList;

public class Tree<T> {
	private Node<T> root;

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

	Tree(T info) {
		root = new Node<T>();
		root.setInfo(info);
		root.setChildren(new ArrayList<Node<T>>());
	}

}
