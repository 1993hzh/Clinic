package com.ibm.train.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ibm.train.entity.clinic.User;

/**
 * @author HuZhonghua
 * 
 */
public class LoginFilter implements Filter {

	protected static final String CONSTANT_LOGIN_CODE = "login";

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request.getAttribute(User.CONSTANT_LOGIN_USER) == null) {
			//OutPutStreamUtil.renderText(CONSTANT_LOGIN_CODE);
		} else {
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
