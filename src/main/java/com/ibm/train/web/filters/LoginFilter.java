package com.ibm.train.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.train.entity.clinic.User;

/**
 * @author HuZhonghua
 * 
 */
public class LoginFilter implements Filter {

	public static final String CONSTANT_LOGIN = "login";
	public static final String CONSTANT_LOGIN_PATH = "login.jsp";

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request.getAttribute(User.CONSTANT_LOGIN_USER) == null
				&& !((HttpServletRequest) request).getRequestURI().contains(
						CONSTANT_LOGIN)) {
			((HttpServletResponse) response).sendRedirect(CONSTANT_LOGIN_PATH);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}