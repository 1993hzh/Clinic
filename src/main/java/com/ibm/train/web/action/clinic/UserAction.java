package com.ibm.train.web.action.clinic;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ibm.train.entity.clinic.User;
import com.ibm.train.service.clinic.UserService;
import com.ibm.train.util.OutPutStreamUtil;
import com.ibm.train.web.action.AbstractAction;
import com.opensymphony.xwork2.inject.Inject;

/**
 * @author HuZhonghua
 * 
 */
@Controller
@Scope("prototype")
public class UserAction extends AbstractAction<User> {


	public static final String CONSTANT_LOGIN_SUCCESS = "login_success";
	public static final String CONSTANT_LOGIN_FAIL = "login_fail";

	@Inject
	private UserService userService;

	private User user = new User();

	private String account;
	private String pwd;

	public String login() {
		User user = userService.login(account, pwd);
		if (user == null) {// login fail
			OutPutStreamUtil.renderText(CONSTANT_LOGIN_FAIL);
			return null;
		} else {
			ServletActionContext.getRequest().getSession().setAttribute(User.CONSTANT_LOGIN_USER, user);
			OutPutStreamUtil.renderText(CONSTANT_LOGIN_SUCCESS);
			return null;
		}
	}

	public void logoff() {
		Object user = ServletActionContext.getRequest().getSession().getAttribute(User.CONSTANT_LOGIN_USER);
		if (user != null) {// 移除session中的属性
			ServletActionContext.getRequest().getSession().removeAttribute(User.CONSTANT_LOGIN_USER);
		}
		ServletActionContext.getRequest().getSession().invalidate();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		return user;
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

}
