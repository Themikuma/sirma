package com.sirma.itt.javacourse.designpatterns.task4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing the object pool.
 * 
 * @author user
 */
public class ObjectPoolTest {

	/**
	 * Testing the addition and the acquisition of elements in the pool.
	 */
	@Test
	public void testObjectPoolAdd() {
		ObjectPool pool = new ObjectPool(10);
		String test = pool.acquire();
		assertEquals(1, pool.getNumOfObjects());
		pool.release(test);
		assertEquals(test, pool.getPool().get(0));
	}

	/**
	 * The test should throw an exception if we try to get more objects from the pool than the
	 * specified maximum.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testObjectPoolAddException() {
		ObjectPool pool = new ObjectPool(2);
		pool.acquire();
		pool.acquire();
		pool.acquire();
	}

}
