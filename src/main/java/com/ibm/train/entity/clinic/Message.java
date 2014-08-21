package com.ibm.train.entity.clinic;

import java.util.Date;
import java.util.Set;

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

	@ManyToOne
	private User sender;
	private Date sendTime;
	private String theme;
	private String content;

	@ManyToMany
	@JoinTable(name = "T_Message_Receiver", joinColumns = { @JoinColumn(name = "message_id") }, inverseJoinColumns = { @JoinColumn(name = "receiver_id") })
	private Set<User> receivers;

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

	public Set<User> getReceivers() {
		return receivers;
	}

	public void setReceivers(Set<User> receivers) {
		this.receivers = receivers;
	}

}
