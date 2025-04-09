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
	private Item item;
	private int quantity;
	
	
	@ManyToOne(targetEntity = Order.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="orderId",referencedColumnName="id")
	private Order order;
	
	
	public LineOrder() {}


//	public LineOrder( int quanti) {
//		this.itemId = itemId;
//		this.quantity = quantity;
//		this.orderId = orderId;
//	}
	
	

	
	public int getId() {
		return id;
	}
	
	public LineOrder(Item item, int quantity, Order orderId) {
	this.item = item;
	this.quantity = quantity;
	this.order = order;
}


	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}


	public void setItemId(Item item) {
		this.item = item;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Order getOrder() {
		return order;
	}
	
	public void setOrderId(Order order) {
		this.order = order;
	}
	
	
	
	
	
	

}
