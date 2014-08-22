package com.ibm.train.web.action;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.train.entity.clinic.User;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author HuZhonghua
 * 
 * @param <T>
 */
public abstract class AbstractAction<T> implements ModelDriven<T> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected String ids;
	protected String sortname;
	protected String sortorder;
	protected String qtype;// query params
	protected String query;// query value

	protected PageJsonData data = new PageJsonData();
	protected ObjectMapper mapper = new ObjectMapper();

	public String execute() {
		return list();
	}

	public abstract String list();

	public abstract String create();

	public abstract String update();

	public abstract String delete();

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

	/**
	 * get the current user who is online
	 * @return
	 */
	public User getLoginUser() {
		Object user = ServletActionContext.getRequest().getSession()
				.getAttribute(User.CONSTANT_LOGIN_USER);
		return user == null ? null : (User) user;

	}

}
