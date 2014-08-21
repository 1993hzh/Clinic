package com.ibm.train.web.action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

public class PageJsonData {
	private int page;// current page
	private List<?> data;
	private int total;
	private int pageSize = 10;

	public PageJsonData() {

	}

	public PageJsonData(int page, List<?> data, int total) {
		this.page = page;
		this.data = data;
		this.total = total;
	}

	public PageJsonData(int page, List<?> data, int total, int pageSize) {
		this.page = page;
		this.data = data;
		this.total = total;
		this.pageSize = pageSize;
	}

	@JSON(serialize = false)
	public int getPageSize() {
		return pageSize;
	}

	@JSON(serialize = false)
	public int getTopPage() {
		return 1;
	}

	@JSON(serialize = false)
	public int getPrevPage() {
		return page <= 1 ? 1 : page - 1;
	}

	@JSON(serialize = false)
	public int getNextPage() {
		int totalPages = getTotalPages();
		return page >= totalPages ? totalPages == 0 ? 1 : totalPages : page + 1;
	}

	@JSON(serialize = false)
	public int getBottomPage() {
		int totalPages = getTotalPages();
		return totalPages == 0 ? 1 : totalPages;
	}

	@JSON(serialize = false)
	public int getTotalPages() {
		return (total + pageSize - 1) / pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
