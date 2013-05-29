package com.sirma.itt.javacourse.designpatterns.task1;

/**
 * Creates the concrete object with a factory method and with reflection.
 * 
 * @author user
 */
public class ConcreteMyClassFactory implements AbstractFactory {

	@Override
	public MyClass createInstance() {
		return new ConcreteMyClass();
	}

	/**
	 * Creating the concrete class from the name of the class.
	 * 
	 * @param className
	 *            the name of the class
	 * @return an instance of the class
	 * @throws ClassNotFoundException
	 *             if the class with the specified name doesn't exist
	 */
	public Object createInstance(String className) throws ClassNotFoundException {
		try {
			return Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
