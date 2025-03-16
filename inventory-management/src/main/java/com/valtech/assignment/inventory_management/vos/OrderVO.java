package com.valtech.assignment.inventory_management.vos;

import com.valtech.assignment.inventory_management.entities.Customer;
import com.valtech.assignment.inventory_management.entities.LineOrder;
import com.valtech.assignment.inventory_management.entities.Order;
import com.valtech.assignment.inventory_management.entities.Order.Status;

public record OrderVO(int id, int customerId, String status) {
	
	
	
	
	public Order to() {
		Status orderStat = Status.valueOf(status);
		return new Order(orderStat);
	}
	
	public static OrderVO from(Order o) {
		String stat = o.getStatus().name();
		return new OrderVO(o.getId(),o.getCustomer().getId(),stat);
	}
}
