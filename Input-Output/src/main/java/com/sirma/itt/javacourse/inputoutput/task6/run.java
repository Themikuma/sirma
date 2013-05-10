package com.sirma.itt.javacourse.inputoutput.task6;

public class run {

	public run() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDefinedObject hello = new UserDefinedObject("Mike");
		DataClass objectManipulator = new DataClass();
		objectManipulator.saveObject("hello.usrdo", hello);
		UserDefinedObject goodbye = objectManipulator.getObject("hello.usrdo");
		System.out.println(goodbye.getName());

	}
}
