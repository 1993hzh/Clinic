package com.ibm.train.test.clinic;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.train.entity.clinic.Message;
import com.ibm.train.entity.clinic.User;
import com.ibm.train.service.clinic.MessageService;
import com.ibm.train.service.clinic.UserService;
import com.ibm.train.test.LoadConfigure;

public class MessageTest extends LoadConfigure {

	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;

	@Test
	public void create() {
		Message message = new Message();
		message.setContent("test");
		Set<User> user = new HashSet<User>();
		user.addAll(userService.query("from User"));
		message.setReceivers(user);
		message.setSender(userService
				.querySingle("from User where name='test1'"));
		message.setSendTime(new Date());
		message.setTheme("test");
		try {
			messageService.create(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void update() {

	}

	@Test
	public void delete() {

	}

	@Test
	public void list() {

	}
}
