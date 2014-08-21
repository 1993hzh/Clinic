package com.ibm.train.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.train.entity.clinic.User;
import com.ibm.train.service.clinic.UserService;

public class CrudTest extends LoadConfigure{
	
	@Autowired
	private UserService userService;
	
	@Test
	public void create() {
		User user = new User();
		user.setAddress("test");
		user.setName("test");
		user.setPassword("test");
		try {
			userService.create(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
