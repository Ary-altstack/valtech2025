package spring.aop.revision;

import org.apache.catalina.core.ApplicationContext;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.Employee;
import spring.tx.Employee.Gender;

public class TxAdviceClient {
	
	public static void main(String[] args) {
//		ApplicationContext appCtx = new ClassPathXmlApplicationContext("tx-advice.xml");
		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("txadvice.xml");
		EmployeeDAO dao =(EmployeeDAO)appCtx.getBean("employeeDAO");
		SessionFactory factory = appCtx.getBean(SessionFactory.class);
		dao.save(factory.openSession(), new Employee(4, "Ramesh",23,1, 30000, 3, Gender.MALE));
		
	}

}
