package com.sirma.itt.javacourse.designpatterns.task1;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the abstract factory.
 * 
 * @author user
 */
public class ConcreteMyClassFactoryTest {

	private ConcreteMyClassFactory factory;

	/**
	 * Setting up a {@link ConcreteMyClassFactory} before each test.
	 * 
	 * @throws Exception
	 *             if something goes wrong
	 */
	@Before
	public void setUp() throws Exception {
		factory = new ConcreteMyClassFactory();
	}

	/**
	 * Testing the factory method of the class.
	 */
	@Test
	public void testFactoryMethod() {
		MyClass someClass = factory.createInstance();
		assertTrue("ConcreteMyClass".equals(someClass.getClass().getSimpleName()));
	}

	/**
	 * Testing the reflection method of the class.
	 * 
	 * @throws ClassNotFoundException
	 *             if the class with the specified name doesn't exist
	 */
	@Test
	public void testReflectionMethod() throws ClassNotFoundException {
		MyClass someClass = (MyClass) factory
				.createInstance("com.sirma.itt.javacourse.designpatterns.task1.ConcreteMyClass");
		assertTrue("ConcreteMyClass".equals(someClass.getClass().getSimpleName()));
	}

	/**
	 * Testing the reflection method of the class with an invalid class name.
	 * 
	 * @throws ClassNotFoundException
	 *             the exception we are expecting
	 */
	@Test(expected = ClassNotFoundException.class)
	public void testReflectionMethodException() throws ClassNotFoundException {
		factory.createInstance("ConcreteMyClass");
	}
}
