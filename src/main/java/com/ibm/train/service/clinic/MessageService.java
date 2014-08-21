package com.ibm.train.service.clinic;

import org.springframework.stereotype.Service;

import com.ibm.train.entity.clinic.Message;
import com.ibm.train.service.AbstractService;

@Service
public class MessageService extends AbstractService<Message> {

	public MessageService(Class<Message> entity) {
		super(entity);
	}

	public MessageService() {
		this(Message.class);
	}

}
