package assignment2.spring;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MyCustomer")
public class Customer {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customerSeq")
	@SequenceGenerator(name="customerSeq",sequenceName="customer_seq",allocationSize = 1)
	private int id;
	private String name;
	private int age;
	private String address;
	private String permanent_address;
	
	public Customer () {}
	
//	
//	public Customer(String name, int age, String address, String permanent_address) {
////		this.id = id;
//		this.name = name;
//		this.age = age;
//		this.address = address;
//		this.permanent_address = permanent_address;
//		
//	}
	

	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Customer> customers;
	
	
	
	public Customer(int id, String name, int age, String address, String permanent_address, List<Customer> customers) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.address = address;
	this.permanent_address = permanent_address;
	this.customers = customers;
}


	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", address=" + address
				+ ", permanent_address=" + permanent_address + "]";
	}


//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPermanent_address() {
		return permanent_address;
	}
	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	
	

	

	
	

}
