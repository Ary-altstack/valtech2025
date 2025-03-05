package Assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import Assignment.Employee.Gender;

class EmployeeTest2 {
	
	private EmployeeService empService;
	
	List<Employee> employees = new ArrayList<>();
	
	@BeforeEach
	void intdata() {
		
		empService = new EmployeeServiceImpl();
		
		employees.add(Employee.builder().id(1).name("Gopal").age(42).salary(100).level(2).exp(2).gender("MALE").build());
		employees.add(Employee.builder().id(2).name("Lucky").age(24).salary(200).level(1).exp(3).gender("MALE").build());
		employees.add(Employee.builder().id(3).name("Rumi").age(22).salary(300).level(2).exp(2).gender("FEMALE").build());
		employees.add(Employee.builder().id(5).name("Hena").age(21).salary(300).level(3).exp(4).gender("FEMALE").build());
		employees.add(Employee.builder().id(4).name("Hena").age(21).salary(300).level(3).exp(4).gender("FEMALE").build());

//		System.out.println(employees);
	
				
	}
	
	
	@Test
	void testHashcode() {
		Employee emp1 = new Employee(4,"Hena",21,300,3,4, Gender.FEMALE);
		Employee emp2 = new Employee(2,"Lucky",24,200,1,3,Gender.MALE);
		assertNotEquals(emp1.hashCode(), emp2.hashCode());
		
		Employee emp3 = new Employee(5,"Hena",21,300,3,4,Gender.FEMALE);
//		assertEquals(emp1.hashCode(), emp3.hashCode());
		
//		int hash = emp1.hashCode();
		
	}
	
//	@Test
//	@Override
//	public void sortEmployee() {
////		List<Employee> sortEmployees = 	new Array
//		employees.sort(Comparator.comparing(Employee::getId));
//		assertEquals(1, employees.get(0).getId());
////		System.out.println(employees);
//		
//	}
	
	
	
	
	
	@Test
	void testEquals() {
		 Employee emp4 = new Employee(4,"Hena",21,300,3,4,Employee.Gender.FEMALE);
//		 Employee emp5 = new Employee(4,"Hena",21,300,3,4,Employee.Gender.FEMALE);
		 Employee emp5 = new Employee(4,"Hena",22,320,2,5,Employee.Gender.FEMALE);
		 assertFalse(emp4.equals(emp5));
		
	}
	
	@Test
	void testToString() {
		 Employee emp4 = new Employee(4,"Hena",21,300,3,4,Employee.Gender.FEMALE);
//		 System.out.println(emp4.toString());
	     String empString = "id: 4 name: Hena age: 21 salary 300.0 level 3 exp 4 gender FEMALE";
	     assertEquals("id: 4 name: Hena age: 21 salary 300.0 level 3 exp 4 gender FEMALE", emp4.toString());
		
	}


	
	
//
//	@ParameterizedTest
	@Test
	void sumOfSalaryByLevel() {
		
//		List<Employee> myNewEmp1 = employees.stream().filter(employee->employee.getLevel()==2).collect(Collectors.toList());
		double SumOfSalaryByLevel = empService.sumOfSalaryByLevel(employees, 2);
		assertEquals(400, SumOfSalaryByLevel);
		
	}
		
//		
////		employees.forEach(e->System.out.println(e.getId()+" "+ e.getName()+" "+ e.getAge()+" "+ e.getSalary()+" "+ e.getGender()+" "
////				+ e.getExp()+" "+ e.getLevel()));
//		
//
////		System.out.println(myNewEmp1);
////		System.out.println(SumOfSalaryByLevel);
//
//	}
//	
//	
	@Test
	void sumOfSalaryByGender() {
//		List<Employee> myNewEmp2 = employees.stream().filter(employee->employee.getGender()==Gender.MALE).collect(Collectors.toList());
		double SumOfSalaryByGender = employees.stream().filter(employee->employee.getGender()== Gender.MALE).mapToDouble(Employee::getSalary).sum();
		assertEquals(300, SumOfSalaryByGender);
////		System.out.println(myNewEmp2);
////		System.out.println(SumOfSalaryByGender);
//			
	}
//	
//	@Test
//	void sortEmployeeByName(List<Employee> employees,Gender gender) {
//		employees.sort(Comparator.comparing(Employee::getName));
//		assertEquals(1, employees.get(1).getName());
//
//		
//	}
	
	
	
//
	@Test
	void sumOfSalaryByExp() {
		double SumOfSalaryByExp = empService.sumOfSalaryByExp(employees, 4);
		assertEquals(600, SumOfSalaryByExp);
//		System.out.println(SumOfSalaryByExp);
	}
//
	@Test
	void employeeNameContains() {
		double SumofSalaryByNameContaining= empService.employeeNameContains(employees, "uck");
		assertEquals(200, SumofSalaryByNameContaining);
//		System.out.println(SumofSalaryByNameContaining);
	}
//
////	@Test
////	@Override
////	public void sortEmployeeById() {
////		employees.sort(Comparator.comparing(Employee::getId));
////		assertEquals(1, employees.get(0).getId());
////		System.out.println(employees);
////
////	}
//	
//	
//

	

	
	

}

	
