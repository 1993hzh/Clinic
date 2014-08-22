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

	/**
	 * delete the table which saves the message and receiver info
	 * 
	 * @param messageId
	 * @param userId
	 */
	public void delete(String messageId, String userId) {
		for (String id : messageId.split(",")) {
			this.em.createNativeQuery(
					"delete from T_Message_Receiver where message_id='" + id + "' and receiver_id = '" + userId + "'")
					.executeUpdate();
		}
	}

	public String getMessageIdsForReceiver(String userId) {
		Object result = this.em.createNativeQuery(
				"select message_id from T_Message_Receiver where receiver_id = '" + userId + "'").getResultList();
		return result.toString().substring(1, result.toString().length() - 1);
	}
}
