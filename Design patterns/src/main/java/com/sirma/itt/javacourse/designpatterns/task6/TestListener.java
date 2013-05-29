package com.sirma.itt.javacourse.designpatterns.task6;

/**
 * A test observer used solely for testing purposes in JUnit.
 * 
 * @author user
 */
public class TestListener implements Observer {
	private boolean updated;

	@Override
	public void update(ProductList list) {
		updated = true;
	}

	/**
	 * Getter method for updated.
	 * 
	 * @return the updated
	 */
	public boolean isUpdated() {
		return updated;
	}

	/**
	 * Setter method for updated.
	 * 
	 * @param updated
	 *            the updated to set
	 */
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}

}
