package com.sirma.itt.javacourse.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a Node in the tree. The node has a parent, info and an undefined number of
 * children.
 * 
 * @param <T>
 * @author user
 */
public class Node<T> {
	private T info;
	private Node<T> parent;
	private List<Node<T>> children;

	/**
	 * The constructor of the node. We are not allowing an empty node to be added to the tree.
	 * 
	 * @param info
	 *            the information that is going to be represented in the node(string, integer etc.)
	 */
	Node(T info) {
		if (info == null) {
			throw new IllegalArgumentException();
		}
		this.info = info;
		this.setChildren(new ArrayList<Node<T>>());
	}

	/**
	 * A method providing easier access to the add function of the list of children of the node.
	 * 
	 * @param child
	 *            the child node to be added
	 */
	void add(Node<T> child) {
		if (child.getParent() != null) {
			throw new IllegalArgumentException();
		}
		children.add(child);
		child.setParent(this);
	}

	/**
	 * A method providing easier access to the get function of the list of children of the node.
	 * 
	 * @param index
	 *            the index at which the child node stands
	 * @return the child node at the index position
	 */
	public Node<T> getChildAt(int index) {
		return children.get(index);
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
