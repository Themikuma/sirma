package com.sirma.itt.javacourse.designpatterns.task1;

/**
 * Interface of the operations that create {@link MyClass}.
 * 
 * @author user
 */
public interface AbstractFactory {
	/**
	 * Creates an instance of a subclass of the {@link MyClass}.
	 * 
	 * @return the instance
	 */
	MyClass createInstance();
}
