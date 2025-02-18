package day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Assignment.Employee.Gender;

class EmployeeRecordTest {

	@Test
	void test() {
		
		EmployeeRecord er = new EmployeeRecord(1, "Abc",23, Gender.MALE, 12500, 5, 6);
						System.out.println(er);
		EmployeeRecord er1 = new EmployeeRecord
				(1, "Abc",23, Gender.MALE, 12500, 5, 6);
		assertEquals(er.hashCode(),er1.hashCode());
		assertEquals(er,er1);
		
		EmployeeRecord er2 = new EmployeeRecord
		(1, "Abc1", 23,Gender.MALE, 12500, 5, 6);
		assertFalse(er.hashCode() == er2.hashCode());
		assertNotEquals(er,er2);
						
	}

}
