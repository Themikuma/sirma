package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class of the tree.
 * 
 * @author user
 */
public class TreeTest {

	/**
	 * Testing to see if the node is added correctly.
	 */
	@Test
	public void testTreeAddNode() {
		Tree<String> tree = new Tree<String>("root");
		tree.getRoot().add(new Node<String>("child one"));
		assertFalse(tree.getRoot().getChildren().isEmpty());
	}

	/**
	 * Testing to see if the node contains the correct information.
	 */
	@Test
	public void testTreeNodeInfo() {
		Tree<String> tree = new Tree<String>("root");
		tree.getRoot().add(new Node<String>("child one"));
		assertTrue("child one".equals(tree.getRoot().getChildAt(0).getInfo()));
	}

	/**
	 * Testing for empty nodes.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTreeNodeInfoException() {
		Tree<String> tree = new Tree<String>("root");
		tree.getRoot().add(new Node<String>(null));

	}
}
