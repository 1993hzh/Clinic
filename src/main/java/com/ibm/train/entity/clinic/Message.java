package com.ibm.train.entity.clinic;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ibm.train.entity.AbstractEntity;

/**
 * @author HuZhonghua
 * 
 */
@Entity
@Table(name = "T_Message")
public class Message extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	public static final String CONSTANT_TYPE_SEND = "send";
	public static final String CONSTANT_TYPE_RECEIVE = "receive";
	
	public static final byte CONSTANT_DELETE = 0;
	public static final byte CONSTANT_NORMAL = 1;

	@ManyToOne
	private User sender;
	private byte sendStatus;
	private Date sendTime;
	private String theme;
	private String content;

	@ManyToMany
	@JoinTable(name = "T_Message_Receiver", joinColumns = { @JoinColumn(name = "message_id") }, inverseJoinColumns = { @JoinColumn(name = "receiver_id") })
	private List<User> receivers;

	private String receiverNames;

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<User> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<User> receivers) {
		this.receivers = receivers;
	}

	public String getReceiverNames() {
		return receiverNames;
	}

	public void setReceiverNames(String receiverNames) {
		this.receiverNames = receiverNames;
	}

	public byte getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(byte sendStatus) {
		this.sendStatus = sendStatus;
	}

}
