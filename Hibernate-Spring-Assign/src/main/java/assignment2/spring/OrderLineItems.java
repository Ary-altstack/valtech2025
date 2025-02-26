package assignment2.spring;

public class OrderLineItems {
	
	private int id;
	private int item_id;
	private int quantity;
	private int order_id;
	

	
	public OrderLineItems () {}
	
	
	public OrderLineItems(int id, int item_id, int quantity, int order_id) {
		this.id = id;
		this.item_id = item_id;
		this.quantity = quantity;
		this.order_id = order_id;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	
	

}
