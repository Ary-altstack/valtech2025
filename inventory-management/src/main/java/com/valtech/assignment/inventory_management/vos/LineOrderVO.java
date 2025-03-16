package com.valtech.assignment.inventory_management.vos;

import com.valtech.assignment.inventory_management.entities.LineOrder;

public record LineOrderVO(int id, int itemId, int quantity,int orderId) {
	
	public LineOrder to() {
		return new LineOrder(quantity);
	}
	
	
	public static LineOrderVO from(LineOrder lo) {
		return new LineOrderVO(lo.getId(),lo.getItemId().getId(), lo.getQuantity(),lo.getOrderId().getId());
		
	}
	

}
