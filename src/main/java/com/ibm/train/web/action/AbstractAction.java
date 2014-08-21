package com.ibm.train.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ModelDriven;

/**
 * @author HuZhonghua
 * 
 * @param <T>
 */
public abstract class AbstractAction<T> implements ModelDriven<T>,
		SessionAware, ServletRequestAware, ServletResponseAware {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected HttpServletResponse response;
	protected HttpServletRequest request;
	protected HttpSession session;

	protected String ids;
	protected String sortname;
	protected String sortorder;
	protected String qtype;// query params
	protected String query;// query value

	protected PageJsonData data = new PageJsonData();
	protected ObjectMapper mapper = new ObjectMapper();

	public String execute() throws Exception {
		return list();
	}

	public String list() throws Exception {

		return null;
	}

	public String create() throws Exception {

		return null;
	}

	public String update() throws Exception {

		return null;
	}

	public String delete() throws Exception {

		return null;
	}

	@Override
	public T getModel() {
		return null;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public PageJsonData getData() {
		return data;
	}

	public void setData(PageJsonData data) {
		this.data = data;
	}

}
