package com.sirma.itt.javacourse.objects.task4_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Testing the binary tree.
 * 
 * @author user
 */
public class BinaryTreeTest {

	private static BinaryTree tree;

	/**
	 * Initializes the tree and sets out the default output stream so we can test the print method
	 * of the tree.
	 * 
	 * @throws Exception
	 *             exception if anything goes wrong
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tree = new BinaryTree(19);
		tree.add(31);
		tree.add(11);
		tree.add(6);
		tree.add(25);
		tree.add(9);
		tree.add(5);
		tree.add(3);
		tree.add(28);
	}

	/**
	 * Testing to see if the node is added correctly.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAdd() {
		assertEquals(31, tree.getRoot().getRight().getInfo());
		assertEquals(11, tree.getRoot().getLeft().getInfo());
	}

	/**
	 * Testing to see if the tree is being printed and sorted correctly.
	 */
	@Test
	public void testPrintSorted() {
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(3, 5, 6, 9, 11, 19, 25, 28,
				31));
		assertEquals(expected, tree.printSorted());
	}

	/**
	 * Testing the search method of the tree.
	 */
	@Test
	public void testSearchTree() {
		assertTrue(tree.searchTree(9));
		assertTrue(tree.searchTree(25));
		assertFalse(tree.searchTree(4));
	}

}
