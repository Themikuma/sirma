package com.sirma.itt.javacourse.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Heterogeneous node class - it an undefined number of children nodes and some data.
 * 
 * @author user
 */
public class HeterogeneousNode {
	private Object info;
	private List<HeterogeneousNode> children;

	/**
	 * The constructor of the node. Sets the info and creates a list of children for the node.
	 * 
	 * @param info
	 *            the data to be passed to the node
	 */
	public HeterogeneousNode(Object info) {
		if (info == null) {
			throw new IllegalArgumentException();
		}
		this.info = info;
		this.setChildren(new ArrayList<HeterogeneousNode>());
	}

	/**
	 * A method providing easier access to the add function of the list.
	 * 
	 * @param child
	 *            the object to be added to the list;
	 */
	void add(Object child) {
		children.add(new HeterogeneousNode(child));

	}

	/**
	 * A method providing easier access to the get function of the list.
	 * 
	 * @param index
	 *            the index at which the object is
	 * @return the object at position index
	 */
	HeterogeneousNode getChildAt(int index) {
		return children.get(index);
	}

	/**
	 * Getter method for info.
	 * 
	 * @return the info
	 */
	public Object getInfo() {
		return info;
	}

	/**
	 * Setter method for info.
	 * 
	 * @param info
	 *            the info to set
	 */
	public void setInfo(Object info) {
		this.info = info;
	}

	/**
	 * Getter method for children.
	 * 
	 * @return the children
	 */
	public List<HeterogeneousNode> getChildren() {
		return children;
	}

	/**
	 * Setter method for children.
	 * 
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<HeterogeneousNode> children) {
		this.children = children;
	}
}
