package com.ibm.train.service.clinic;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.train.entity.clinic.User;
import com.ibm.train.service.AbstractService;
import com.ibm.train.util.Encryption;

@Service
public class UserService extends AbstractService<User> {

	public UserService(Class<User> entity) {
		super(entity);
	}

	public UserService() {
		this(User.class);
	}

	public User login(String account, String pwd) {
		@SuppressWarnings("unchecked")
		List<User> user = this.em.createQuery("select u.password from User u where account=?").setParameter(1, account)
				.getResultList();
		if (user != null && Encryption.encoderBySHA1(pwd).equals(user.get(0).getPassword())) {
			return user.get(0);
		} else {
			return null;
		}

	}
}
