package com.ibm.train.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.ibm.train.web.action.PageContext;

/**
 * @author HuZhonghua
 * 
 */
public class PageFilter implements Filter {

	private static final int CONSTANT_DEFAULT_PAGESIZE = 10;
	private static final String CONSTANT_PAGE_SIZE_NAME = "pageSize";
	private static final String CONSTANT_PAGE_PARAM_NAME = "page";

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			getOffset((HttpServletRequest) request);
			getPageSize((HttpServletRequest) request);
		} finally {
			PageContext.removeOffset();
			PageContext.removePageSize();
		}
	}

	private int getOffset(HttpServletRequest request) {
		String offSetStr = request.getParameter(CONSTANT_PAGE_PARAM_NAME);
		if (!isEmpty(offSetStr)) {

		}
		return isEmpty(offSetStr) ? 0 : (Integer.parseInt(offSetStr) - 1)
				* PageContext.getPageSize();
	}

	private int getPageSize(HttpServletRequest request) {
		String rp = request.getParameter("rp");
		if (!isEmpty(rp)) {
			try {
				Integer irp = Integer.parseInt(rp);
				request.getSession().setAttribute(CONSTANT_PAGE_SIZE_NAME,
						irp == 0 ? CONSTANT_DEFAULT_PAGESIZE : irp);
			} catch (Exception ignore) {
			}
		}

		Object pageSize = request.getSession().getAttribute(
				CONSTANT_PAGE_SIZE_NAME);
		if (pageSize == null) {
			request.getSession().setAttribute(CONSTANT_PAGE_SIZE_NAME,
					CONSTANT_DEFAULT_PAGESIZE);
			return CONSTANT_DEFAULT_PAGESIZE;
		}
		return (Integer) pageSize;
	}

	private boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
