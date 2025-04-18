package assignment2.spring.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "entity_seq_generator")
	@SequenceGenerator(name="entity_seq_generator", sequenceName="hibernate_sequence",allocationSize = 1)
	private int id;
	private String name;
	private String description;
	private int quantity;
	private int reorderQuantity;
	private int maxQuantity;
	
	
	@OneToMany(targetEntity = LineOrder.class, mappedBy="item_id",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<LineOrder> lineOrders;
	
	public Item () {}


	public Item( String name, String description, int quantity, int reorder_quantity, int max_quantity) {
//		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.reorderQuantity = reorder_quantity;
		this.maxQuantity = max_quantity;
	}
	
	@Override
	public String toString() {
		return "Item [name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", reorderQuantity=" + reorderQuantity + ", maxQuantity=" + maxQuantity + "]";
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getReorderQuantity() {
		return reorderQuantity;
	}


	public void setReorderQuantity(int reorder_quantity) {
		this.reorderQuantity = reorder_quantity;
	}


	public int getMaxQuantity() {
		return maxQuantity;
	}


	public void setMaxQuantity(int max_quantity) {
		this.maxQuantity = max_quantity;
	}
	
	public List<LineOrder> getLineOrders() {
		return lineOrders;
	}
	
	public void setLineOrders(List<LineOrder> lineOrders) {
		this.lineOrders = lineOrders;
	}
	
	
	
	

}
