package com.ibm.train.web.action.clinic;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ibm.train.entity.clinic.Medicine;
import com.ibm.train.service.clinic.MedicineService;
import com.ibm.train.web.action.AbstractAction;

@Scope("prototype")
@Controller
@Results(value = { @Result(name = "medicine", location = "/medicine.jsp") })
public class MedicineAction extends AbstractAction<Medicine> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private MedicineService medicineService;

	private Medicine medicine = new Medicine();

	@Override
	public Medicine getModel() {
		return medicine;
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

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	@Override
	public String list() {
		data = medicineService.getPageData("from Medicine");
		return "medicine";
	}

}
