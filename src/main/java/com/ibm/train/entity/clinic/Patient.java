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
@Table(name = "T_Patient")
@Inheritance(strategy = InheritanceType.JOINED)
public class Patient extends User {

	private static final long serialVersionUID = 1L;

	private String occupation;
	private String marry;
	private String spouseName;
	private String spouseTele;

	@OneToMany(mappedBy = "patient")
	private List<Order> orders;

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getSpouseTele() {
		return spouseTele;
	}

	public void setSpouseTele(String spouseTele) {
		this.spouseTele = spouseTele;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
