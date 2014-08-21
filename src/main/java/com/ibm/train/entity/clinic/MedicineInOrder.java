package com.ibm.train.entity.clinic;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ibm.train.entity.AbstractEntity;

/**
 * @author HuZhonghua
 * 
 */
@Entity
@Table(name = "T_MedicineInOrder")
public class MedicineInOrder extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Medicine medicine;
	private Integer num;
	private Double totalPrice;
	@ManyToOne
	private Order order;
	

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
