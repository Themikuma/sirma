package com.sirma.itt.javacourse.designpatterns.task3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing the {@link Singleton} class.
 * 
 * @author user
 */
public class SingletonTest {

	/**
	 * Testing to see if the getinstance method will return the same instance twice. The first call
	 * will create the instance and return it, the second call should return the same instance
	 * without creating a new one.
	 */
	@Test
	public void test() {
		Singleton singleton = Singleton.getInstance();
		Singleton secondSingleton = Singleton.getInstance();
		assertEquals(singleton, secondSingleton);
	}

}
