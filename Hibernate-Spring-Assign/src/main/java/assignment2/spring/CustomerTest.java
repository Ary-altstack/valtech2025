package assignment2.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerTest {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("assign.xml");
		CustomerService cs = ctx.getBean(CustomerService.class);
//		cs.save(new Customer("Arya",21,"Gurgaon","Gurgaon"));
		
		ctx.close();
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
