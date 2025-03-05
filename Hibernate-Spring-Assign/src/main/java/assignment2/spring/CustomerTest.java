	package assignment2.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import assignment2.spring.Customer.AppStatus;
import assignment2.spring.Order.Status;

public class CustomerTest {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("assign.xml");
		CustomerService cs = ctx.getBean(CustomerService.class);
		ItemService is = ctx.getBean(ItemService.class);
		OrderService os = ctx.getBean(OrderService.class);
		LineService ls = ctx.getBean(LineService.class);
		Service s = ctx.getBean(Service.class);
		
		
//		Customer c = new Customer("Lennon",40,"Liverpool","Liverpool");
//		Customer c =(new Customer("Deepak",22,"Ahmeda","Gurgaon"));
//		cs.save(new Customer("Abhi",18,"Ahmedabad","Ahmedabad"));
//		cs.save(c);
		
//		Item i = new Item("Mouth-Organ","Harmonica",1,100,10);
//		is.save (new Item("Ukelele","4-String",50,50,100));
//		is.save (new Item("Piano","Casio",200,200,400));
//	 	is.save (new Item("Guitar","Lot of Strings",200,300,500));

//	  	is.save(i);
//		ctx.close(); 
		
//		Customer c = new Customer("Kargav",28,"baroda","Vadodara");
//		c.setAppStatus(AppStatus.DISABLE);
//		cs.save(c);
	
		Order o = new Order();
		
		LineOrder lo = new LineOrder();
		lo.setItem_id(is.get(4));
		lo.setQuantity(0);	
		o.addLineOrder(lo);
		o.setCustomer(cs.get(5));
		o.setStatus(Status.PROCESSING);
		
		s.saveOrder(o);
//		
//		
//		Order order = os.get(1);
		ctx.close();
		
//		o.setLineOrders(null);
//		cs.save(new Customer("Aarav",19,"Ahmedabad","Ahmedabad"));
//		cs.save(new Customer("Bhavya",14,"Nikol","Nikol"));
		
//		Customer c = new Customer();
//		c.setAddress("Nikol");
//		c.setAge(21);
//		c.setName("Bhavya");
//		c.setPermanent_address("Nikol");
//		cs.save(c);       
		
		
		
		
		
//		System.out.println(cs);
//		Customer cst = new Customer();
//		cs.save(new Customer(2,"Arya",21,"Maninagar","Maninagar"));
//		cs.update(new Customer(1,"Zarana",22,"Satelliate","Satelliate"));
		
//		Customer c = cs.get(2);
//		c.setName("Zarana");
//		c.setAddress("Satelliate");
//		cs.update(c);
		
		
	}
	
}
