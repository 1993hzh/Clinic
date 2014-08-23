package com.ibm.train.exception;

/**
 * @author HuZhonghua
 *
 */
public class LoginException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String msg;

	public LoginException(String msg) {
		super(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
