package com.sirma.itt.javacourse.refanreg;

public class RandomClassUserByName {

	public void printClassInfo(String name) {
		Class randomClass = null;
		try {
			randomClass = Class.forName(name);
			Object classByName = randomClass.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Printing implemented interfaces");
		for (Class randomObjectInterface : randomClass.getInterfaces()) {
			System.out.println(randomObjectInterface);
		}
		System.out.println("Printing parent");
		System.out.println(randomClass.getSuperclass());
	}
}
