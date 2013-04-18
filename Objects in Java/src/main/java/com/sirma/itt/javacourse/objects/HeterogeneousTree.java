package com.sirma.itt.javacourse.objects;

/**
 * A heterogeneous Tree- tree that can contain any object.
 * 
 * @author user
 */
public class HeterogeneousTree {
	private HeterogeneousNode root;

	/**
	 * Getter method for root.
	 * 
	 * @return the root
	 */
	public HeterogeneousNode getRoot() {
		return root;
	}

	/**
	 * Setter method for root.
	 * 
	 * @param root
	 *            the root to set
	 */
	public void setRoot(HeterogeneousNode root) {
		this.root = root;
	}

	/**
	 * Constructor of the heterogeneous tree class. Sets the root of the tree.
	 * 
	 * @param info
	 *            the data we are passing to the root's value.
	 */
	public HeterogeneousTree(Object info) {
		this.root = new HeterogeneousNode(info);
	}

	/**
	 * the add method of the tree. Iterates through the root's children and if it finds a node with
	 * the same type, adds itself as a child. Otherwise adds itself as a child to the root.
	 * 
	 * @param info
	 *            the object we are passing to the new node's value.
	 */
	void add(Object info) {
		boolean foundPlace = false;
		for (HeterogeneousNode currNode : root.getChildren()) {
			if (info.getClass() == currNode.getInfo().getClass()) {
				currNode.add(info);
				foundPlace = true;
			}
		}
		if (!foundPlace)
			root.add(info);
	}
}
