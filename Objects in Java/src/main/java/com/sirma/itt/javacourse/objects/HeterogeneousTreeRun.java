package com.sirma.itt.javacourse.objects;


/**
 * An example class using the Heterogeneous tree.
 * 
 * @author user
 */
public final class HeterogeneousTreeRun {
	/**
	 * Private constructor, throwing an error, preventing anyone from instantiating this class.
	 */
	private HeterogeneousTreeRun() {
		throw new AssertionError("Can't instantiate utility class");
	}

	/**
	 * An example method for the construction of a tree.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		HeterogeneousTree tree = new HeterogeneousTree("hello");
		tree.add(12);
		tree.add(true);
		tree.add(false);
		tree.add(25);
		tree.add(1);
		tree.add("stringone");
		tree.add("stringtwo");
	}
}
