package it.eforhum.corsojava.ArchiveDocument.view;

import it.eforhum.corsojava.ArchiveDocument.Utils.Util;

public class Pagination {
	
	private int currentPage = 1; // user page
	private int numDocxForPage = 5; // docx for a single page

	private boolean orederedBy = true; // true = asc | false = desc
	private String orderedByField = Util.FIELD_ID; // can be ordered by cod or description of DOCX

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNumDocxForPage() {
		return numDocxForPage;
	}

	public void setNumDocxForPage(int numDocxForPage) {
		this.numDocxForPage = numDocxForPage;
	}

	public String getOrderedByField() {
		return orderedByField;
	}

	public void setOrderedByID() {
		this.orderedByField = Util.FIELD_ID;
	}

	public void setOrderedByCOD() {
		this.orderedByField = Util.FIELD_COD;
	}

	public void setOrderedByDESC() {
		this.orderedByField = Util.FIELD_DESCRIPTION;
	}

	public boolean isOrderedByAscending() {
		return this.orederedBy;
	}

	public boolean isOrderedByDescending() {
		return this.orederedBy;
	}
	
	public void setOrderedByDescending() {
		this.orederedBy = false;
	}
	
	public void setOrderedByAscending() {
		this.orederedBy = true;
	}
}
