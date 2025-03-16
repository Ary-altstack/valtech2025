package com.valtech.assignment.inventory_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.inventory_management.entities.Customer.AppStatus;
import com.valtech.assignment.inventory_management.entities.LineOrder;
import com.valtech.assignment.inventory_management.entities.Order;
import com.valtech.assignment.inventory_management.entities.Order.Status;
import com.valtech.assignment.inventory_management.repo.ItemRepo;
import com.valtech.assignment.inventory_management.repo.LineOrderRepo;
import com.valtech.assignment.inventory_management.repo.OrderRepo;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
//	public void setOrderRepo(OrderRepo orderRepo) {
//		this.orderRepo = orderRepo;
//	}
	
	
	@Autowired
	private LineOrderRepo lineOrderRepo;
	@Autowired
	private ItemRepo itemRepo;
	
//	public void setItemRepo(ItemRepo itemRepo) {
//		this.itemRepo = itemRepo;
//	}
	
	
	@Override
	public void saveOrder(Order o) {
 
		boolean valid = true;
 
		for (LineOrder lineOrderRepo : o.getLineOrders()) {
			if(lineOrderRepo.getQuantity() > lineOrderRepo.getItemId().getQuantity()|| o.getCustomer().getAppStatus() == AppStatus.DISABLE) {
				valid = false;
				o.setStatus(Status.PENDING);
				
				orderRepo.save(o);
				break;	
			}
		}
		if(valid) {
			o.setStatus(Status.DELIVERED);
			orderRepo.save(o);//
//			updateInventory(o);

		}
	}
	
	@Override
	public void saveLineOrder(LineOrder lo) {
		if(lo.getQuantity() > lo.getItemId().getQuantity()) {
		}
		else{
			lineOrderRepo.save(lo);
		}
	}



	
	
	

}
