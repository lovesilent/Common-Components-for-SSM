package com.wyln.common.page;

public interface Paginable {
	
	/**
	 * Number of the total counts
	 * @return
	 */
	public int getTotalCount();
	
	/**
	 * Number of the total pages
	 * @return
	 */
	public int getTotalPage();
	
	/**
	 * Size of per page
	 * @return
	 */
	public int getPageSize();
	
	/**
	 * Current page number
	 * @return
	 */
	public int getPageNo();
	
	/**
	 * Whether is first page
	 * @return
	 */
	public boolean isFirstPage();
	
	/**
	 * Whether is last page
	 * @return
	 */
	public boolean isLastPage();
	
	/**
	 * Turn to next page
	 * @return
	 */
	public int getNextPage();
	
	/**
	 * Turn to previous page
	 * @return
	 */
	public int getPrePage();
	
}
