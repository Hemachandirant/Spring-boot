package com.simplilearn.webservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_data")
public class Order {
	// id, label, address, phone , email, details, etc.
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private int id;
	
	@Column(name="order_label")
	private String label;
	
	@Column(name="order_address")
	private String address;
	
	@Column(name="order_phone")
	private int phone;
	
	@Column(name="order_email")
	private String email;
	
	@Column(name="order_details")
	private String details;
	
	public Order() {}
	
	public Order(int id, String label, String address, int phone, String email, String details) {
		super();
		this.id = id;
		this.label = label;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.details = details;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", label=" + label + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", details=" + details + "]";
	}
	
	
	
}