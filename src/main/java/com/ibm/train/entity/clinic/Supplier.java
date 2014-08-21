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
@Table(name = "T_Supplier")
@Inheritance(strategy = InheritanceType.JOINED)
public class Supplier extends User {

	private static final long serialVersionUID = 1L;

	private String company;
	private String title;

	@OneToMany(mappedBy = "receiver")
	private List<Order> orders;

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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
