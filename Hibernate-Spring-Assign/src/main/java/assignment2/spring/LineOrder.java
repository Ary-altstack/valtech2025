package assignment2.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class LineOrder {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineOrderSeq")
	@SequenceGenerator(name="lineOrderSeq",sequenceName="line_Order_Seq",allocationSize = 1)
	private int id;
	private int item_id;
	private int quantity;
	private int order_id;
	
	
	
	
	public LineOrder() {}


	public LineOrder(int item_id, int quantity, int order_id) {
		this.item_id = item_id;
		this.quantity = quantity;
		this.order_id = order_id;
	}
	
	
	
	

}
