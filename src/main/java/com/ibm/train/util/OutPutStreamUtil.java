package com.ibm.train.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author HuZhonghua
 *
 */
public class OutPutStreamUtil {

	protected static final String CONSTANT_ENCODING = "utf-8";
	
	protected ObjectMapper mapper = new ObjectMapper();

	public static void renderText(String content) {
		try {
			getResponse().setCharacterEncoding(CONSTANT_ENCODING);
			getResponse().getWriter().write(content);
			getResponse().getWriter().flush();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	protected static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	protected static HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected static HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

}
