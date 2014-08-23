package com.ibm.train.web.action;

/**
 * page params
 * 
 * @author HuZhonghua
 * 
 */
public class PageContext {
	private static ThreadLocal<Integer> offset = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();

	public static int getOffset() {
		Integer os = offset.get();
		return os == null ? 0 : os;
	}

	public static void setOffset(int _offset) {
		offset.set(_offset);
	}

	public static void removeOffset() {
		offset.remove();
	}

	public static int getPageSize() {
		Integer ps = pageSize.get();
		return ps == null ? 10 : ps;
	}

	public static void setPageSize(int _pageSize) {
		pageSize.set(_pageSize);
	}

	public static void removePageSize() {
		pageSize.remove();
	}
}
