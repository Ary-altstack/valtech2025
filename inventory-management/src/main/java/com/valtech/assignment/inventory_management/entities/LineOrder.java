package com.valtech.assignment.inventory_management.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LineOrder {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineOrderSeq")
	@SequenceGenerator(name="lineOrderSeq",sequenceName="line_Order_Seq",allocationSize = 1)
	private int id;
	
	@ManyToOne(targetEntity = Item.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="itemId",referencedColumnName="id")
	private Item itemId;
	private int quantity;
	
	
	@ManyToOne(targetEntity = Order.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="orderId",referencedColumnName="id")
	private Order orderId;
	
	
	public LineOrder() {}


	public LineOrder( int quantity) {
//		this.itemId = itemId;
		this.quantity = quantity;
//		this.orderId = orderId;
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Item getItemId() {
		return itemId;
	}


	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Order getOrderId() {
		return orderId;
	}
	
	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}
	
	
	
	
	
	

}
