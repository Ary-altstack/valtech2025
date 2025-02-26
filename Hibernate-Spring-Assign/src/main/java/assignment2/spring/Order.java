package assignment2.spring;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class Order {
	
	private enum status{
		PENDING,PROCESSING,DELIVERED;
	}
	
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="OrderSequence")
	@SequenceGenerator(name="OrderSequence",sequenceName="Order_Seq",allocationSize = 1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	private int line_id;
	
	public Order () {}

	public Order(Customer customer, int line_id) {
		this.customer = customer;
		this.line_id = line_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getLine_id() {
		return line_id;
	}

	public void setLine_id(int line_id) {
		this.line_id = line_id;
	}
	
	
	
	
	
	
	
	
	
}
