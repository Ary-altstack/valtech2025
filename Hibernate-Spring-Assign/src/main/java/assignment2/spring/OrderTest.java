package assignment2.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderTest {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("assign.xml");
		OrderService os = ctx.getBean(OrderService.class);
		
		Order o = new Order();
		
		
		
	}

}
