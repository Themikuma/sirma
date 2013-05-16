package com.sirma.itt.javacourse.collections.task2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the PageBean class.
 * 
 * @author user
 */
public class PageBeanTest {

	private List<Integer> content;
	private PageBean<Integer> bean;

	/**
	 * Setting up the list with numbers and the PageBean instance before each method.
	 */
	@Before
	public void setUpBeforeClass() {
		content = new ArrayList<Integer>();
		content.add(1);
		content.add(2);
		content.add(3);
		content.add(4);
		content.add(5);
		content.add(6);
		bean = new PageBean<Integer>(content, 4);
		bean.next();

	}

	/**
	 * Testing the lastPage,firstPage,hasNext,hasPrevious and getCurrentPage methods of the class.
	 */
	@Test
	public void testPageBeanMethods() {

		assertEquals("[5, 6]", bean.lastPage().toString());
		assertEquals("[1, 2, 3, 4]", bean.firstPage().toString());
		bean.lastPage();
		assertFalse(bean.hasNext());
		assertTrue(bean.hasPrevious());
		assertEquals(1, bean.getCurrentPage());
	}

	/**
	 * Trying to go back a page from the first page and expecting an exception.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testPageBeanMethodsFirstPageException() {
		bean.previous();
	}

	/**
	 * Trying to go forth a page from the last page and expectin an exception.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testPageBeanMethodsLastPageException() {
		bean.lastPage();
		bean.next();
	}
}
