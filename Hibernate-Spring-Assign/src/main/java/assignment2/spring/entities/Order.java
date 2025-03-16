package assignment2.spring.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MyOrder")
public class Order {
	
	public enum Status{
		PENDING,PROCESSING,DELIVERED;
	}
	
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="OrderSequence")
	@SequenceGenerator(name="OrderSequence",sequenceName="Order_Seq",allocationSize = 1)
	private int id;
	
	@ManyToOne (targetEntity = Customer.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id",referencedColumnName = "id")
	private Customer customer;
	
	
	@OneToMany(targetEntity = LineOrder.class,mappedBy="order_id",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private List<LineOrder> lineOrders;
	private List<LineOrder> lineOrders = new ArrayList<>();

	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	public void addLineOrder(LineOrder lo) {
		if(lineOrders==null) lineOrders = new ArrayList<LineOrder>();
		lineOrders.add(lo);
		lo.setOrder_id(this);
		
	}
	public void removeLineOrder(LineOrder lo) {
		lineOrders.remove(lo);
		lo.setOrder_id(null);
	}
	
	
	public Order () {}

	public Order(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<LineOrder> getLineOrders() {
		return lineOrders;
	}
	
	public void setLineOrders(List<LineOrder> lineOrders) {
		this.lineOrders = lineOrders;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
			

}
	
	
	
	
	
