package com.ibm.train.web.action.clinic;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ibm.train.entity.clinic.Message;
import com.ibm.train.entity.clinic.User;
import com.ibm.train.service.clinic.MessageService;
import com.ibm.train.service.clinic.UserService;
import com.ibm.train.util.OutPutStreamUtil;
import com.ibm.train.web.action.AbstractAction;

/**
 * @author HuZhonghua
 * 
 */
@Scope("prototype")
@Controller
@Results(value = { @Result(name = "inbox", location = "/message/inbox.jsp"),
		@Result(name = "sent", location = "/message/sent.jsp") })
public class MessageAction extends AbstractAction<Message> {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;

	private Message message = new Message();

	private String lookType;
	private String accounts;

	public String listInbox() {
		data = messageService.getPageData("from Message where id in ("
				+ messageService.getMessageIdsForReceiver(getLoginUser().getId()) + ")");
		return "inbox";
	}

	public String listSent() {
		data = messageService.getPageData("from Message where sender.id = '" + getLoginUser().getId() + "'");
		return "sent";
	}

	@Override
	public Message getModel() {
		return message;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public String list() {
		// see the sent message
		if (Message.CONSTANT_TYPE_SEND.equals(lookType)) {
			data = messageService.getPageData("from Message where sender.id = '" + getLoginUser().getId() + "'");
			// see the inbox message
		} else if (Message.CONSTANT_TYPE_RECEIVE.equals(lookType)) {
			data = messageService.getPageData("from Message where id in ('" + getLoginUser().getId() + "')");
		}
		return null;
	}

	@Override
	public String create() {
		try {
			List<User> receivers = userService.query("from User where id in ('" + accounts + "')");
			if (receivers == null) {
				OutPutStreamUtil.renderText("receiver not found!");
			} else {
				/*
				 * save the receivers name: when one or more of the receivers
				 * delete the message, the t_message_receiver table will delete
				 * the row, so the receiverNames can save the original receivers
				 * for others to look up
				 */
				StringBuffer receiverNames = new StringBuffer();
				for (User u : receivers) {
					receiverNames.append(u.getName()).append("<" + u.getAccount() + ">, ");
				}
				message.setReceiverNames(receiverNames.deleteCharAt(receiverNames.lastIndexOf(", ")).toString());

				message.setReceivers(receivers);
				message.setSender(getLoginUser());
				message.setSendTime(new Date());
				messageService.create(message);
				OutPutStreamUtil.renderText("true");
			}
		} catch (Exception e) {
			OutPutStreamUtil.renderText(e.getMessage());
		}
		return null;
	}

	@Override
	public String update() {
		return null;
	}

	@Override
	public String delete() {
		try {
			messageService.delete(ids, getLoginUser().getId());
			OutPutStreamUtil.renderText("true");
		} catch (Exception e) {
			OutPutStreamUtil.renderText(e.getMessage());
		}
		return null;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getLookType() {
		return lookType;
	}

	public void setLookType(String lookType) {
		this.lookType = lookType;
	}

}
