package com.ibm.train.entity.clinic;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author HuZhonghua
 * 
 */
@Entity
@Table(name = "T_Salesman")
@Inheritance(strategy = InheritanceType.JOINED)
public class Salesman extends User {

	private static final long serialVersionUID = 1L;

	private String company;
	private String title;
	@OneToMany(mappedBy = "receiver")
	private List<Order> ordersReceive;

	@OneToMany(mappedBy = "creator")
	private List<Order> ordersCreate;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Order> getOrdersReceive() {
		return ordersReceive;
	}

	public void setOrdersReceive(List<Order> ordersReceive) {
		this.ordersReceive = ordersReceive;
	}

	public List<Order> getOrdersCreate() {
		return ordersCreate;
	}

	public void setOrdersCreate(List<Order> ordersCreate) {
		this.ordersCreate = ordersCreate;
	}

}
