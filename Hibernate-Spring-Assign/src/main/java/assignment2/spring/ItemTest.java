package assignment2.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemTest {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("assign.xml");
		ItemService is = ctx.getBean(ItemService.class);
//		is.save(new Item("Protein-Powder","Muscle building",500,12,450));
		Item i = is.get(1);
//		is.update(new Item("Creatine","Muscle-gain",700,21,670));
		i.setName("Arya");
		is.update(i);
	}

}
