package com.ibm.train.test.clinic;

import java.util.Date;

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
		for (int i = 0; i < 5; i++) {
			Message message = new Message();
			message.setContent("test");
			message.setReceivers(userService
					.query("from User where name='test2'"));
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
	}

	@Test
	public void update() {

	}

	// @Test
	public void delete() {
		Message m = messageService
				.querySingle("from Message where sender.name='test1'");
		User u = userService.querySingle("from User where name='test1'");
		messageService.delete(m.getId(), u.getId());
	}

	@Test
	public void list() {
		User u = userService.querySingle("from User where name='test2'");
		System.out.println(messageService.getMessageIdsForReceiver(u.getId()));
	}
}
