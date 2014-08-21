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
@Table(name = "T_Doctor")
@Inheritance(strategy = InheritanceType.JOINED)
public class Doctor extends User {

	private static final long serialVersionUID = 1L;

	private String specility;
	private String experience;
	private String qualification;

	@OneToMany(mappedBy = "creator")
	private List<Order> order;

	public String getSpecility() {
		return specility;
	}

	public void setSpecility(String specility) {
		this.specility = specility;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
}
