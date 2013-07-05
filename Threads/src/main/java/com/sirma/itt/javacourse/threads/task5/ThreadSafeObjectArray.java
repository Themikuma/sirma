package com.sirma.itt.javacourse.threads.task5;

/**
 * A child of the {@link ObjectArray}, adding some additional methods for creating an
 * {@link ElementAdder} and {@link ElementRemover} runnables to be executed from different threads.
 * 
 * @author user
 */
public class ThreadSafeObjectArray extends ObjectArray {
	/**
	 * Constructing the object array with the given length.
	 * 
	 * @param length
	 *            the length of the object array
	 */
	public ThreadSafeObjectArray(int length) {
		super(length);
	}

	/**
	 * Creates a new {@link ElementAdder} runnable which adds elements to be object array.
	 * 
	 * @param count
	 *            the number of elements to be added
	 * @return the {@link ElementAdder}
	 */
	public Runnable addElements(int count) {
		return new ElementAdder(count);
	}

	/**
	 * Creates a new {@link ElementRemover} runnable which removes elements from the object array.
	 * 
	 * @param count
	 *            the number of elements to be removed
	 * @return the {@link ElementRemover}
	 */
	public Runnable removeElements(int count) {
		return new ElementRemover(count);
	}

	/**
	 * Runnable object that removes elements from the object array.
	 * 
	 * @author user
	 */
	private final class ElementRemover implements Runnable {
		private final int count;

		/**
		 * Setting up count.
		 * 
		 * @param count
		 *            the number of elements to be removed.
		 */
		private ElementRemover(int count) {
			this.count = count;
		}

		@Override
		public void run() {
			for (int i = 0; i < count; i++)
				remove();

		}
	}

	/**
	 * Runnable object that adds elements to the object array.
	 * 
	 * @author user
	 */
	private final class ElementAdder implements Runnable {

		private final int count;

		/**
		 * Setting up the count.
		 * 
		 * @param count
		 *            the number of elements to be removed from the object array
		 */
		private ElementAdder(int count) {
			this.count = count;
		}

		@Override
		public void run() {

			for (int i = 0; i < count; i++)
				add(1);

		}

	}

}
