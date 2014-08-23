package com.ibm.train.web.action.clinic;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ibm.train.entity.clinic.Order;
import com.ibm.train.service.clinic.MedicineService;
import com.ibm.train.service.clinic.OrderService;
import com.ibm.train.web.action.AbstractAction;

/**
 * @author HuZhonghua
 *
 */
@Controller
@Scope("prototype")
@Results(value = { @Result(name = "fail", location = "/index.jsp"), @Result(name = "doctor", location = "/doctor.jsp") })
public class OrderAction extends AbstractAction<Order> {

	private static final long serialVersionUID = 1L;

	private Order order = new Order();
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private MedicineService medicineService;
	
	@Override
	public Order getModel() {
		return order;
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

}
