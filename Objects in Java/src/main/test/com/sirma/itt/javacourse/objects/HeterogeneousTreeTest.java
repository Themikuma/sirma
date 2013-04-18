package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class testing the heterogeneous tree.
 * 
 * @author user
 */
public class HeterogeneousTreeTest {

	/**
	 * Testing to see if the node is added and placed correctly.
	 */
	@Test
	public void test() {
		HeterogeneousTree tree = new HeterogeneousTree("hello");
		tree.add(12);
		tree.add(true);
		tree.add(false);
		tree.add(25);
		tree.add(1);
		tree.add("stringone");
		tree.add("stringtwo");
		assertEquals(false, tree.getRoot().getChildAt(1).getChildAt(0).getInfo());
		assertEquals(true, tree.getRoot().getChildAt(1).getInfo());
		assertEquals("stringone", tree.getRoot().getChildAt(2).getInfo());
	}

}
