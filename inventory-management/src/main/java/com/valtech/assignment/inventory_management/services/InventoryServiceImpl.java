package com.valtech.assignment.inventory_management.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.assignment.inventory_management.entities.Item;
import com.valtech.assignment.inventory_management.entities.LineOrder;
import com.valtech.assignment.inventory_management.entities.Order;
import com.valtech.assignment.inventory_management.repo.ItemRepo;
import com.valtech.assignment.inventory_management.vos.ItemVO;

public class InventoryServiceImpl implements InventoryService {
	
	
	@Autowired
	private ItemRepo itemRepo;
	@Override
	public void setItemRepo(ItemRepo itemRepo) {
		this.itemRepo = itemRepo;
		
	}
	
	
	@Override
	public void resetInventory (Item item) {
		item.setQuantity(item.getMaxQuantity());
		item.setReorderQuantity(0);
		itemRepo.save(item);
	}
	
	@Override
	public void updateInventory(Order o) {
		Item item;
		for (LineOrder lineOrder : o.getLineOrders()) {
			item = itemRepo.getReferenceById(lineOrder.getItem().getId());
			item.setQuantity(item.getQuantity()-lineOrder.getQuantity());
			item.setReorderQuantity(item.getReorderQuantity() + lineOrder.getQuantity());
			itemRepo.save(item);
			if(item.getQuantity() == 0) {
				resetInventory(item);
			}

		}
		

	}

	

	

}
