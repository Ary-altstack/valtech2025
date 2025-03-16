package assignment2.spring;
 
import org.apache.catalina.Container;
import org.apache.catalina.Engine;
import org.apache.catalina.Executor;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.mapper.Mapper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import assignment2.spring.Customer.AppStatus;
import assignment2.spring.Order.Status;
 
public class ServiceImpl implements assignment2.spring.Service {
	private javax.sql.DataSource dataSource;
 
 
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Autowired
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	@Autowired
	private LineService lineService;
	
	@Override
	public void setLineService(LineService lineService) {
		this.lineService = lineService;
	}
	
	
	@Autowired
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	
	@Autowired
	private InventoryService inventoryService;
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
 
	
	@Override
	public void saveOrder(Order o) {
 
		boolean valid = true;
 
		for (LineOrder lineService : o.getLineOrders()) {
			if(lineService.getQuantity() > lineService.getItem_id().getQuantity()|| o.getCustomer().getAppStatus() == AppStatus.DISABLE) {
				valid = false;
				o.setStatus(Status.PENDING);
				
				orderService.save(o);
				break;	
			}
		}
		if(valid) {
			o.setStatus(Status.DELIVERED);
			orderService.save(o);
			inventoryService.updateInventory(o);

		}
	}
	@Override
	public void saveLineOrder(LineOrder lo) {
		if(lo.getQuantity() > lo.getItem_id().getQuantity()) {
		}
		else{
			lineService.save(lo);
		}
	}



	
	
 
}