package com.valtech.assignment.inventory_management.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="MyCustomer")
public class Customer {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customerSeq")
	@SequenceGenerator(name="customerSeq",sequenceName="customer_seq",allocationSize = 1)
	private int id;
	private String name;
	private int age;
	private String address;
	private String permanentAddress;
	
	@Enumerated(EnumType.STRING)
	private AppStatus AppStatus;
	
	
	public enum AppStatus{
		ENABLE,DISABLE;
		
	}
	
	@OneToMany(targetEntity = Order.class, mappedBy = "customer",cascade=CascadeType.ALL,fetch = FetchType.LAZY)	
	private Set<Order> orders  ;
	
	
	public Customer () {}
	

	
	public Customer(String name, int age, String address, String permanentAddress,AppStatus appStatus) {
//		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.permanentAddress = permanentAddress;		
		this.AppStatus = appStatus;
	}
	

//	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
//	private List<Customer> customers;
	
//	
//	public Customer(int id, String name, int age, String address, String permanent_address, List<Customer> customers) {
//	this.id = id;
//	this.name = name;
//	this.age = age;
//	this.address = address;
//	this.permanent_address = permanent_address;
//	this.customers = customers;
//}


	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", address=" + address
				+ ", permanent_address=" + permanentAddress + "]";
	}


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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanent_address) {
		this.permanentAddress = permanent_address;
	}

	
	public Set<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
	public AppStatus getAppStatus() {
		return AppStatus;
	}
	
	public void setAppStatus(AppStatus appStatus) {
		AppStatus = appStatus;
	}
	
	
	

	

	
	

}
