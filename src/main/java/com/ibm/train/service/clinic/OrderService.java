package com.ibm.train.service.clinic;

import org.springframework.stereotype.Service;

import com.ibm.train.entity.clinic.Order;
import com.ibm.train.service.AbstractService;

/**
 * @author HuZhonghua
 *
 */
@Service
public class OrderService extends AbstractService<Order> {

	public OrderService(Class<Order> entity) {
		super(entity);
	}

	public OrderService() {
		this(Order.class);
	}

}
