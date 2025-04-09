package com.valtech.assignment.inventory_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.inventory_management.entities.Customer.AppStatus;
import com.valtech.assignment.inventory_management.entities.Item;
import com.valtech.assignment.inventory_management.entities.LineOrder;
import com.valtech.assignment.inventory_management.entities.Order;
import com.valtech.assignment.inventory_management.entities.Order.Status;
import com.valtech.assignment.inventory_management.repo.ItemRepo;
import com.valtech.assignment.inventory_management.repo.LineOrderRepo;
import com.valtech.assignment.inventory_management.repo.OrderRepo;
import com.valtech.assignment.inventory_management.vos.OrderVO;


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
			if(lineOrderRepo.getQuantity() > lineOrderRepo.getItem().getQuantity()|| o.getCustomer().getAppStatus() == AppStatus.DISABLE) {
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
		if(lo.getQuantity() > lo.getItem().getQuantity()) {
		}
		else{
			lineOrderRepo.save(lo);
		}
	}
	
    @Override
	public void placeOrder(OrderVO orderVO) {
	Order order = orderVO.to();
	        
	        for(LineOrder lineItem : order.getLineOrders()) {
	            Item item = itemRepo.getReferenceById(lineItem.getItem().getId());
	            if(item == null) {
	                throw new RuntimeException("Item not found" + lineItem.getItem().getId());
	            }
	            
	            int updatedQuantity = item.getQuantity() - lineItem.getQuantity();
	            
	            if(updatedQuantity < 0) {
	                throw new RuntimeException("No Stock" + item.getName());
	            }
	            
	            item.setQuantity(updatedQuantity);
	            itemRepo.save(item);
	        }
	        
	        orderRepo.save(order);
	    }



	
	
	

}
