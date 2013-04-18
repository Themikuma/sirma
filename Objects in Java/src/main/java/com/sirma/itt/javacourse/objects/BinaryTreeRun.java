package com.sirma.itt.javacourse.objects;

/**
 * An example class using the binary tree.
 * 
 * @author user
 */
public final class BinaryTreeRun {
	/**
	 * Private constructor, throwing an error, preventing anyone from instantiating this class.
	 */
	private BinaryTreeRun() {
		throw new AssertionError("Can't instantiate utility class");
	}

	/**
	 * An example method for the construction, printing and searching of a tree.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(19);
		tree.add(31);
		tree.add(11);
		tree.add(6);
		tree.add(25);
		tree.add(9);
		tree.add(5);
		tree.add(3);
		tree.add(28);
		tree.printSorted();
		System.out.print(tree.searchTree(9));
	}
}
