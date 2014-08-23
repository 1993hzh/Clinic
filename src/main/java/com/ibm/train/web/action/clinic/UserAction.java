package com.ibm.train.web.action.clinic;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ibm.train.entity.clinic.User;
import com.ibm.train.exception.LoginException;
import com.ibm.train.service.clinic.UserService;
import com.ibm.train.web.action.AbstractAction;

/**
 * @author HuZhonghua
 * 
 */
@Controller
@Scope("prototype")
@Results(value = { @Result(name = "index", type = "redirect", location = "/index.jsp"),
		@Result(name = "fail", location = "/index.jsp") })
public class UserAction extends AbstractAction<User> {

	@Autowired
	private UserService userService;

	private User user = new User();

	public String login() {
		try {
			User loginUser = userService.login(user.getAccount(), user.getPassword());
			if (loginUser != null) {
				getSession().setAttribute(User.CONSTANT_LOGIN_USER, loginUser);
				return "index";
			} else {
				return "index";
			}
		} catch (LoginException le) {// login fail
			getRequest().setAttribute("loginMsg", le.getMessage());
			return "fail";
		}
	}

	public String logoff() {
		Object user = getSession().getAttribute(User.CONSTANT_LOGIN_USER);
		if (user != null) {// 移除session中的属性
			getSession().removeAttribute(User.CONSTANT_LOGIN_USER);
		}
		getSession().invalidate();
		return "index";
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

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
