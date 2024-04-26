package com.petrolpump.admin.model;

public class EmployeeModel {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSal() {
		return salary;
	}
	public void setSal(int salary) {
		this.salary = salary;
	}
	private String name;
	private String email;
	private String contact;
	private String address;
	private int salary;

}
