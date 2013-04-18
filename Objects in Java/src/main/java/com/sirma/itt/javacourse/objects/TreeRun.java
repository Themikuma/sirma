package com.sirma.itt.javacourse.objects;

/**
 * An example class with a method, constructing a tree.
 * 
 * @author user
 */
final class TreeRun {

	/**
	 * Private constructor, throwing an error, preventing anyone from instantiating this class.
	 */
	private TreeRun() {
		throw new AssertionError("Can't instantiate utility class");
	}

	/**
	 * An example method for for the construction of a tree.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		Tree<String> tree = new Tree<String>("root");
		tree.getRoot().add(new Node<String>("child one"));
		tree.getRoot().getChildAt(0).add(new Node<String>("subchild one"));
		tree.getRoot().getChildAt(0).add(new Node<String>("subchild two"));
		tree.getRoot().getChildAt(0).getChildAt(1)
				.add(new Node<String>("subchild of subchild two"));
	}
}
