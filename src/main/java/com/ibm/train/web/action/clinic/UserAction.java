package com.ibm.train.web.action.clinic;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ibm.train.entity.AbstractEntity;
import com.ibm.train.entity.clinic.User;
import com.ibm.train.service.clinic.UserService;
import com.opensymphony.xwork2.inject.Inject;

/**
 * @author HuZhonghua
 * 
 */
@Controller
@Scope("prototype")
public class UserAction extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserService userService;

	private String account;
	private String pwd;

	public String login() {
		User user = userService.login(account, pwd);
		if (user == null) {
			
		}
		return "";
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

}
