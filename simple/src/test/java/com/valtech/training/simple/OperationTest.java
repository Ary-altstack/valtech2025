package com.valtech.training.simple;

import junit.framework.TestCase;

public class OperationTest extends TestCase {
	
//	Operation add = (a,b) -> a+b;
//	Operation sub = (a,b) -> a-b;
//	Operation mul = (a,b) -> a*b;
//	Operation div = (a,b) -> a/b;

	
	public void testAdd() {
		assertEquals(6, Operation.ADD.perform(4,2));
		assertEquals(2, Operation.SUB.perform(4,2));
		assertEquals(8, Operation.MUL.perform(4,2));
		assertEquals(2, Operation.DIV.perform(4,2));

	}

}
