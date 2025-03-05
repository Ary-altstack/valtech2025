package assignment2.spring;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
public class InventoryServiceImpl implements InventoryService {
	
	private javax.sql.DataSource dataSource;
 
	private SessionFactory sessionFactory;
	
	
	@Autowired
	ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
 
	@Override
	public void resetInventory(Item item) {
		item.setQuantity(item.getMaxQuantity());
		item.setReorderQuantity(0);
		itemService.update(item);
	}
 
	@Override
	public void updateInventory (Order o) {
		Item item;
		for (LineOrder lineOrder : o.getLineOrders()) {
			item = itemService.get(lineOrder.getItem_id().getId());
			item.setQuantity(item.getQuantity()-lineOrder.getQuantity());
			item.setReorderQuantity(item.getReorderQuantity() + lineOrder.getQuantity());
			itemService.update(item);
			if(item.getQuantity() == 0) {
				resetInventory(item);
			}			
		}		
	}
	
	
}