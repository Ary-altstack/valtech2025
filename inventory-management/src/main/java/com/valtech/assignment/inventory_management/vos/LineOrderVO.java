package com.valtech.assignment.inventory_management.vos;

import com.valtech.assignment.inventory_management.entities.Item;
import com.valtech.assignment.inventory_management.entities.LineOrder;
import com.valtech.assignment.inventory_management.entities.Order;

public record LineOrderVO(int id, Item item, int quantity,Order order) {
	
	public LineOrder to() {
		return new LineOrder(item,quantity,order);
	}
	
	public static LineOrderVO from(LineOrder lo) {		
		return new LineOrderVO(lo.getId(),lo.getItem(),lo.getQuantity(),lo.getOrder());
	}

}
