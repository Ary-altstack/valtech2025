package com.valtech.assignment.inventory_management.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="MyOrder")
public class Order {
	
	public enum Status{
		PENDING,PROCESSING,DELIVERED;
	}
	
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="OrderSequence")
	@SequenceGenerator(name="OrderSequence",sequenceName="Order_Seq",allocationSize = 1)
	private int id;
	
	@ManyToOne (targetEntity = Customer.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="customerId",referencedColumnName = "id")
	private Customer customer;
	
	
	@OneToMany(targetEntity = LineOrder.class,mappedBy="orderId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private List<LineOrder> lineOrders;
	private List<LineOrder> lineOrders = new ArrayList<>();

	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	public void addLineOrder(LineOrder lo) {
		if(lineOrders==null) lineOrders = new ArrayList<LineOrder>();
		lineOrders.add(lo);
		lo.setOrderId(this);
		
	}
	public void removeLineOrder(LineOrder lo) {
		lineOrders.remove(lo);
		lo.setOrderId(null);
	}
	
	
	public Order () {}
	
	
	

//	public Order(Customer customer, List<LineOrder> lineOrders, Status status) {
////		this.id = id;
//		this.customer = customer;
//		this.lineOrders = lineOrders;
//		this.status = status;
//	}
//	
//	public Order(Customer customer) {
//		this.customer = customer;
//	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	

	public Order(Status status) {
		this.status = status;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<LineOrder> getLineOrders() {
		return lineOrders;
	}
	
	public void setLineOrders(List<LineOrder> lineOrders) {
		this.lineOrders = lineOrders;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
			
	
	

}
	
	
	
	
	
