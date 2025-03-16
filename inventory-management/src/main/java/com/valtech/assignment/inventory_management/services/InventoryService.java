package com.valtech.assignment.inventory_management.services;

import com.valtech.assignment.inventory_management.entities.Item;
import com.valtech.assignment.inventory_management.entities.Order;
import com.valtech.assignment.inventory_management.repo.ItemRepo;

public interface InventoryService {

	void setItemRepo(ItemRepo itemRepo);

	void resetInventory(Item item);

	void updateInventory(Order o);

}