package com.ibm.train.entity.clinic;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ibm.train.entity.AbstractEntity;

/**
 * @author HuZhonghua
 * 
 */
@Entity
@Table(name = "T_Medicine")
public class Medicine extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String component;
	private String advantage;
	private String disadvantage;
	private Float price;
	private String descption;
	// only salesman need to check the stock, supplier thought as have enough
	private Integer stock;
	@ManyToOne
	private User owner;// the medicine belongs to supplier

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getAdvantage() {
		return advantage;
	}

	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}

	public String getDisadvantage() {
		return disadvantage;
	}

	public void setDisadvantage(String disadvantage) {
		this.disadvantage = disadvantage;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescption() {
		return descption;
	}

	public void setDescption(String descption) {
		this.descption = descption;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}
