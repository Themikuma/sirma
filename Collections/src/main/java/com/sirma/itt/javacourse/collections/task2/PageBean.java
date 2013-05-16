package com.sirma.itt.javacourse.collections.task2;

import java.util.List;

/**
 * A class that splits a list of elements into pages with a given number of elements per page.
 * 
 * @param <E>
 * @author user
 */
public class PageBean<E> {
	private List<E> contentList;
	private int pageSize;
	private int currentPage = -1;

	/**
	 * Sets the elements and the number of elements per page.
	 * 
	 * @param contentList
	 *            a list containing all the elements
	 * @param pageSize
	 *            number of elements per page
	 */
	public PageBean(List<E> contentList, int pageSize) {
		this.contentList = contentList;
		this.pageSize = pageSize;
	}

	/**
	 * Iterates to the next page if there is one.
	 * 
	 * @return the elements in the current page
	 */
	public List<E> next() {
		if (!hasNext()) {
			throw new IndexOutOfBoundsException("You have reached the last page");
		}
		currentPage++;
		return getCurrentPageContent();
	}

	/**
	 * Iterates to the previous page if there is one.
	 * 
	 * @return the elements in the current page
	 */
	public List<E> previous() {
		if (!hasPrevious()) {
			throw new IndexOutOfBoundsException("The index can't be smaller than 0");
		}
		currentPage--;
		return getCurrentPageContent();
	}

	/**
	 * Checks if there is next page.
	 * 
	 * @return false if there isn't, true if there is
	 */
	public boolean hasNext() {
		return ((currentPage * pageSize) + pageSize > contentList.size()) ? false : true;
	}

	/**
	 * Checks if there is previous page.
	 * 
	 * @return false if there isn't, true if there is
	 */
	public boolean hasPrevious() {
		return (currentPage <= 0) ? false : true;
	}

	/**
	 * Iterates to the first page.
	 * 
	 * @return the elements in the current page
	 */
	public List<E> firstPage() {
		currentPage = 0;
		return getCurrentPageContent();
	}

	/**
	 * Iterates to the last page.
	 * 
	 * @return the elements in the current page
	 */
	public List<E> lastPage() {
		if (contentList.size() % pageSize == 0) {
			currentPage = contentList.size() / pageSize - 1;

		} else {
			currentPage = contentList.size() / pageSize;
		}
		return getCurrentPageContent();
	}

	/**
	 * The elements in the current page. If the elements count is less than the specified page size,
	 * display only as many elements as there are left.
	 * 
	 * @return the elements in the current page
	 */
	public List<E> getCurrentPageContent() {
		if ((currentPage * pageSize + pageSize) > contentList.size())
			return contentList.subList(currentPage * pageSize, contentList.size());
		else
			return contentList.subList(currentPage * pageSize, (currentPage * pageSize) + pageSize);
	}

	/**
	 * Getter method for contentList.
	 * 
	 * @return the contentList
	 */
	public List<E> getContentList() {
		return contentList;
	}

	/**
	 * Setter method for contentList.
	 * 
	 * @param contentList
	 *            the contentList to set
	 */
	public void setContentList(List<E> contentList) {
		this.contentList = contentList;
	}

	/**
	 * Getter method for pageSize.
	 * 
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * Setter method for pageSize.
	 * 
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Getter method for currentPage.
	 * 
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * Setter method for currentPage.
	 * 
	 * @param currentPage
	 *            the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
