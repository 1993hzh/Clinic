package com.ibm.train.entity.clinic;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ibm.train.entity.AbstractEntity;

/**
 * @author HuZhonghua
 * 
 */
@Entity
@Table(name = "T_User")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	public static final String CONSTANT_GENDER_MALE = "male";
	public static final String CONSTANT_GENDER_FEMALE = "female";

	public static final String CONSTANT_ROLE_ADMIN = "admin";
	public static final String CONSTANT_ROLE_DOCTOR = "doctor";
	public static final String CONSTANT_ROLE_PATIENT = "patient";
	public static final String CONSTANT_ROLE_SALESMAN = "salesman";
	public static final String CONSTANT_ROLE_SUPPLIER = "supplier";

	@Column(nullable = false, unique = true)
	private String account;
	private String password;

	private String name;
	private String address;
	private String description;// description
	private String gender;
	private String email;
	private String tele;

	private String role;

	@OneToMany(mappedBy = "sender", fetch = FetchType.EAGER)
	private List<Message> messageSend;

	@ManyToMany(mappedBy = "receivers", fetch = FetchType.EAGER)
	private Set<Message> messageReceive;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public List<Message> getMessageSend() {
		return messageSend;
	}

	public void setMessageSend(List<Message> messageSend) {
		this.messageSend = messageSend;
	}

	public Set<Message> getMessageReceive() {
		return messageReceive;
	}

	public void setMessageReceive(Set<Message> messageReceive) {
		this.messageReceive = messageReceive;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
