package com.valtech.assignment.inventory_management.vos;

import com.valtech.assignment.inventory_management.entities.Item;

public record ItemVO(int id,String name,String description, int quantity, int reorderQuantity, int maxQuantity  ) {

public Item to() {
	return new Item (name,description,quantity,reorderQuantity,maxQuantity);
}

public static ItemVO from(Item i) {
	return new ItemVO(i.getId(),i.getName(), i.getDescription(), i.getQuantity(), i.getReorderQuantity(), i.getMaxQuantity());
}




}
