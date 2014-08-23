package com.ibm.train.web.action.clinic;

import java.util.ArrayList;
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

	private List<User> receiver = new ArrayList<User>();

	private String lookType;
	private String accounts;

	public String listInbox() {
		data = messageService.getPageData("from Message where id in ("
				+ messageService.getMessageIdsForReceiver(getLoginUser().getId()) + ") order by sendTime desc");
		return "inbox";
	}

	public String listSent() {
		data = messageService.getPageData("from Message where sendStatus = '" + Message.CONSTANT_NORMAL
				+ "' and sender.id = '" + getLoginUser().getId() + "' order by sendTime desc");
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
			/*
			 * save the receivers name: when one or more of the receivers
			 * delete the message, the t_message_receiver table will delete
			 * the row, so the receiverNames can save the original receivers
			 * for others to look up
			 */
			String notfound = getReceiver();
			if (receiver != null && receiver.size() > 0) {
				StringBuffer receiverNames = new StringBuffer();
				for (User u : receiver) {
					receiverNames.append(u.getName()).append("<" + u.getAccount() + ">, ");
				}
				message.setReceiverNames(receiverNames.deleteCharAt(receiverNames.lastIndexOf(", ")).toString());
				message.setSendStatus(Message.CONSTANT_NORMAL);
				message.setReceivers(receiver);
				message.setSender(getLoginUser());
				message.setSendTime(new Date());
				messageService.create(message);
			}
			OutPutStreamUtil.renderText(!isEmpty(notfound) ? "Accounts: " + notfound + " not found!" : "true");
		} catch (Exception e) {
			e.printStackTrace();
			OutPutStreamUtil.renderText(e.getMessage());
		}
		return null;
	}

	private boolean isEmpty(String str) {
		return null == str || str.trim().length() == 0;
	}

	private String getReceiver() {
		StringBuffer sb = new StringBuffer();
		receiver.clear();//for cache
		//query receiver one by one so that we can find they are existed or not
		for (String s : accounts.split(",")) {
			User user = userService.querySingle("from User where account = '" + s + "'");
			if (user == null) {
				sb.append(s + ",");
			} else {
				//id constraint violate
				if (!receiver.contains(user)) {
					receiver.add(user);
				}
			}
		}
		return sb.toString();
	}

	@Override
	public String update() {
		return null;
	}

	@Override
	public String delete() {
		try {
			//receiver delete
			//delete the row in the table T_MESSAGE_RECEIVER
			if (lookType.equals(Message.CONSTANT_TYPE_RECEIVE)) {
				messageService.delete(ids, getLoginUser().getId());
				//sender delete
				//update the sendstatus
				//otherwise the receivers of the message will not see the message
			} else if (lookType.equals(Message.CONSTANT_TYPE_SEND)) {
				for (String id : ids.split(",")) {
					message = messageService.findById(id);
					if (message.getSender().getId().equals(getLoginUser().getId())) {
						message.setSendStatus(Message.CONSTANT_DELETE);
						messageService.update(message);
					}
				}
			}
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
