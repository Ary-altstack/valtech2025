package spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ioc.Arithmetic;

class AOPTest {

	@Test
	void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
		Arithmetic arith = (Arithmetic) ctx.getBean("arith");
		System.out.println(arith.getClass().getName());
		System.out.println(arith.add(2, -3));
		System.out.println(arith.add(4, -7));
		System.out.println(arith.sub(-4, -2));
		System.out.println(arith.mul(4, 2));
		System.out.println(arith.div(8, 1));
		ctx.close();
	}

}
