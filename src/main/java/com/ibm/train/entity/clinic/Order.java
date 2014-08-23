package com.ibm.train.entity.clinic;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ibm.train.entity.AbstractEntity;

/**
 * @author HuZhonghua
 * 
 */
@Entity
@Table(name = "T_Order")
public class Order extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	public static final byte CONSTANT_ORDER_NEW = 0;
	public static final byte CONSTANT_ORDER_CONFIRM = 1;
	public static final byte CONSTANT_ORDER_AVAILABLE = 2;
	public static final byte CONSTANT_ORDER_NOT_AVAILABLE = 3;
	public static final byte CONSTANT_ORDER_FINISH = 4;

	@ManyToOne
	private User creator;// doctor or salesman
	private Date createTime;

	// null when the order is created by salesman and received by supplier
	@ManyToOne
	private User patient;

	@ManyToOne
	private User receiver;// salesman or supplier

	@OneToMany(mappedBy = "order")
	private List<MedicineInOrder> medicineList;

	private byte status;
	private Double cost;

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public List<MedicineInOrder> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(List<MedicineInOrder> medicineList) {
		this.medicineList = medicineList;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}

	public String getStatusDTO() {
		String result = "";
		switch (status) {
		case CONSTANT_ORDER_NEW:
			result = "New";
			break;
		case CONSTANT_ORDER_CONFIRM:
			result = "Confirmed";
			break;
		case CONSTANT_ORDER_AVAILABLE:
			result = "Available";
			break;
		case CONSTANT_ORDER_NOT_AVAILABLE:
			result = "Stock not enough";
			break;
		case CONSTANT_ORDER_FINISH:
			result = "Finished";
			break;
		default:
			result = "Undefined status";
			break;
		}
		return result;
	}

}
