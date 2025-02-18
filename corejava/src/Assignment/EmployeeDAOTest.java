package Assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Assignment.Employee.Gender;
import dao.EmployeeDAO;

class EmployeeDAOTest {

	@Test
	void testInsert() {
		EmployeeDAO dao = new EmployeeDAOImpl();
//dao.save(new Employee(201,"Test",23,12000,5,2,Gender.MALE));
		//dao.save(new Employee(2,"Working",23,12000,5,2,Gender.FEMALE));
//		Employee e = new Employee(50,"ABC",23,12500,5,6,Gender.MALE);
//		dao.update(e);
//		e = dao.get(1);
//		assertEquals(1,e.gextId());
//		assertEquals("DEF",e.getName());
//		assertEquals(23,e.getAge());
//		assertEquals(12500,e.getSalary());
//		assertEquals(6,e.getExp());
//		assertEquals(5,e.getLevel());
//		assertEquals(Gender.MALE,e.getGender());
//		
//		assertTrue(dao.getAll().size() > 1);
dao.delete(201);

	}

}
