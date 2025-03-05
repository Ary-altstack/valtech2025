package assignment2.spring;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class LineOrder {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineOrderSeq")
	@SequenceGenerator(name="lineOrderSeq",sequenceName="line_Order_Seq",allocationSize = 1)
	private int id;
	
	@ManyToOne(targetEntity = Item.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="item_id",referencedColumnName="id")
	private Item item_id;
	private int quantity;
	
	
	@ManyToOne(targetEntity = Order.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="order_id",referencedColumnName="id")
	private Order order_id;
	
	
	public LineOrder() {}


	public LineOrder(Item item_id, int quantity,Order order_id) {
		this.item_id = item_id;
		this.quantity = quantity;
		this.order_id = order_id;
	}


	public Item getItem_id() {
		return item_id;
	}


	public void setItem_id(Item item_id) {
		this.item_id = item_id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Order getOrder_id() {
		return order_id;
	}


	public void setOrder_id(Order order_id) {
		this.order_id = order_id;
	}
	
	
	
	
	
	

}
