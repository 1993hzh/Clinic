package com.ibm.train.test.clinic;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.train.entity.clinic.Message;
import com.ibm.train.entity.clinic.User;
import com.ibm.train.service.clinic.UserService;
import com.ibm.train.test.LoadConfigure;
import com.ibm.train.util.Encryption;

public class UserTest extends LoadConfigure {

	@Autowired
	private UserService userService;

	// @Test
	public void create() {
		String name = "test";
		for (int i = 1; i < 10; i++) {
			User user = new User();
			user.setAccount(name + "" + i);
			user.setAddress(name + "" + i + "_addr");
			user.setDescription("user_" + name + "" + i);
			user.setEmail(name + "" + i + "@cn.ibm.com");
			user.setGender(User.CONSTANT_GENDER_FEMALE);
			user.setName(name + "" + i);
			user.setTele("123456789" + i);
			user.setPassword(Encryption.encoderBySHA1(name + "" + i));
			try {
				userService.create(user);
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
		User user = userService.querySingle("from User");
		try {
			userService.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void list() {
		for (User u : userService.query("from User")) {
			System.out.println(u.getName() + ":");
			System.out.println(u.getMessageSend().size() + "");
			System.out.println(u.getMessageReceive().size() + "");
			for (Message m : u.getMessageReceive()) {
				System.out.println(m.getTheme() + ":" + m.getSendTime());
			}
		}
	}
}
