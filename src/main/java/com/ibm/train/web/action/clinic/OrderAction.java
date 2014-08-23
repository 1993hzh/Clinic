package com.ibm.train.web.action.clinic;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ibm.train.entity.clinic.Order;
import com.ibm.train.service.clinic.MedicineInOrderService;
import com.ibm.train.service.clinic.MedicineService;
import com.ibm.train.service.clinic.OrderService;
import com.ibm.train.util.OutPutStreamUtil;
import com.ibm.train.web.action.AbstractAction;

/**
 * @author HuZhonghua
 *
 */
@Controller
@Scope("prototype")
@Results(value = { @Result(name = "send", location = "/order/send.jsp"),
		@Result(name = "receive", location = "/order/receive.jsp") })
public class OrderAction extends AbstractAction<Order> {

	private static final long serialVersionUID = 1L;

	private Order order = new Order();

	@Autowired
	private OrderService orderService;
	@Autowired
	private MedicineService medicineService;
	@Autowired
	private MedicineInOrderService medicineInOrderService;

	public String listSend() {
		data = orderService.getPageData("from Order where creator.id='" + getLoginUser().getId()
				+ "' order by createTime desc");
		return "send";
	}

	public String listReceive() {
		data = orderService.getPageData("from Order where receiver.id='" + getLoginUser().getId()
				+ "' order by createTime desc");
		return "receive";
	}

	@Override
	public Order getModel() {
		return order;
	}

	@Override
	public String list() {
		return null;
	}

	@Override
	public String create() {
		
		return null;
	}

	@Override
	public String update() {
		try {
			orderService.update(order);
			OutPutStreamUtil.renderText("true");
		} catch (Exception e) {
			OutPutStreamUtil.renderText(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

}
