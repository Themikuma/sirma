package com.sirma.itt.javacourse.objects;

import java.util.List;

public class Node<T> {
	private T info;
	private Node<T> parent;
	private List<Node<T>> children;

	void add(Node<T> child) {
		children.add(child);
	}

	/**
	 * Getter method for info.
	 * 
	 * @return the info
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * Setter method for info.
	 * 
	 * @param info
	 *            the info to set
	 */
	public void setInfo(T info) {
		this.info = info;
	}

	/**
	 * Getter method for parent.
	 * 
	 * @return the parent
	 */
	public Node<T> getParent() {
		return parent;
	}

	/**
	 * Setter method for parent.
	 * 
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	/**
	 * Getter method for children.
	 * 
	 * @return the children
	 */
	public List<Node<T>> getChildren() {
		return children;
	}

	/**
	 * Setter method for children.
	 * 
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<Node<T>> children) {
		this.children = children;
	}

}
