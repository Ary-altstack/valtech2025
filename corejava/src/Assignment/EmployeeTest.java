package Assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import Assignment.Employee.Gender;


class EmployeeTest {

	//private Collection<Employee> employees;

// Sorting 
	
	@Test
	void testSort() { 
			List<Employee> employees = new ArrayList<Employee>();
			
			employees.add(Employee.builder().id(100).name("Abhi").age(22).salary(30000).gender(Gender.MALE).exp(1).level(10).build());
			employees.add(Employee.builder().id(101).name("Abhilash").age(23).salary(40000).gender(Gender.MALE).exp(2).level(9).build());
			employees.add(Employee.builder().id(102).name("Ria").age(20).salary(20000).gender(Gender.FEMALE).exp(1).level(10).build());
			employees.add(Employee.builder().id(103).name("Dia").age(21).salary(31000).gender(Gender.FEMALE).exp(1).level(11).build());
			employees.add(Employee.builder().id(104).name("Jia").age(32).salary(70000).gender(Gender.FEMALE).exp(1).level(12).build());
			employees.add(Employee.builder().id(105).name("Neeti").age(21).salary(30000).gender(Gender.FEMALE).exp(2).level(15).build());
			employees.add(Employee.builder().id(106).name("Juhi").age(20).salary(40000).gender(Gender.FEMALE).exp(3).level(12).build());
			employees.add(Employee.builder().id(107).name("Dhria").age(32).salary(30000).gender(Gender.FEMALE).exp(4).level(10).build());
			employees.add(Employee.builder().id(108).name("Lopa").age(25).salary(38000).gender(Gender.FEMALE).exp(1).level(11).build());
			employees.add(Employee.builder().id(109).name("Krishil").age(26).salary(38000).gender(Gender.MALE).exp(6).level(19).build());
			employees.add(Employee.builder().id(110).name("Laxman").age(27).salary(37000).gender(Gender.MALE).exp(7).level(11).build());
			employees.add(Employee.builder().id(111).name("Gopal").age(24).salary(36000).gender(Gender.MALE).exp(8).level(10).build());
			employees.add(Employee.builder().id(112).name("Madhav").age(22).salary(35000).gender(Gender.MALE).exp(9).level(8).build());
			employees.add(Employee.builder().id(113).name("Lucky").age(22).salary(34000).gender(Gender.MALE).exp(2).level(4).build());
			employees.add(Employee.builder().id(114).name("Lakshman").age(22).salary(33000).gender(Gender.MALE).exp(1).level(1).build());
			employees.add(Employee.builder().id(115).name("Adi").age(22).salary(50000).gender(Gender.MALE).exp(4).level(2).build());
			employees.add(Employee.builder().id(116).name("Boman").age(20).salary(70000).gender(Gender.MALE).exp(1).level(3).build());

	
			Collections.sort(employees);
			
			for (Employee e : employees) {
				System.out.println(e);
			}
			
	// Mapping		
			
			Map<Gender, List <Employee>> employeesByGender = employees.stream()
					.collect(Collectors.groupingBy
							(Employee::getGender));
						
				employeesByGender.forEach((gender,emplist)->{
					System.out.println("gender: "+gender);
					emplist.forEach(e->System.out.println(e.getId()+ e.getName()+ e.getAge()+ e.getSalary()+ e.getGender()
							+ e.getExp()+ e.getLevel()));

				});
			
			
			
			List<Employee> myNewEmp1 = employees.stream().filter(employee -> employee.getLevel() == 10).collect(Collectors.toList());
			System.out.println(myNewEmp1);
			double totalSalary = myNewEmp1.stream().mapToDouble(Employee :: getSalary).sum();
			System.out.println(totalSalary);
			
			
			List<Employee> myNewEmp2 = employees.stream().filter(employee -> employee.getGender() == Gender.FEMALE).collect(Collectors.toList());
			System.out.println(myNewEmp2);
			double totalSalary1 = myNewEmp2.stream().mapToDouble(Employee :: getSalary).sum();
			System.out.println(totalSalary1);
			
			List<Employee> myNewEmp3 = employees.stream().filter(employee -> employee.getLevel() == 10  && employee.getGender() == Gender.FEMALE).collect(Collectors.toList());
			System.out.println(myNewEmp3);
			double totalSalary2 = myNewEmp3.stream().mapToDouble(Employee :: getSalary).sum();
			System.out.println(totalSalary2);
			
			List<Employee> myNewEmp4 = employees.stream().filter(employee -> employee.getName().contains("i") ).collect(Collectors.toList());
			System.out.println(myNewEmp4);
			double totalSalary4 = myNewEmp4.stream().mapToDouble(Employee :: getSalary).sum();
			System.out.println(totalSalary4);
	
		
		}	
	
	// Hash Code 
	@Test
	void testHashCode() {
		Employee emp1 = new Employee(100,"Abhi",22,30000,10,1,Employee.Gender.MALE);
		int hash = emp1.hashCode();
		System.out.println(emp1);
		Employee emp2 = new Employee(100,"Abhi",22,30000,10,1,Employee.Gender.MALE);
		int hash2 = emp2.hashCode();
		System.out.println(emp2);
		assertEquals(hash2,hash);
//		assertNotEquals(hash,emp2.hashCode());
		
	}
	
// Stream API 
	
	@Test
	void testStreamApi(){
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(Employee.builder().id(100).name("Abhi").age(22).salary(30000).gender(Gender.MALE).exp(1).level(10).build());
		employees.add(Employee.builder().id(101).name("Abhilash").age(23).salary(40000).gender(Gender.MALE).exp(2).level(9).build());
		employees.add(Employee.builder().id(102).name("Ria").age(20).salary(20000).gender(Gender.FEMALE).exp(1).level(10).build());
		employees.add(Employee.builder().id(103).name("Dia").age(21).salary(31000).gender(Gender.FEMALE).exp(1).level(11).build());
		employees.add(Employee.builder().id(104).name("Jia").age(32).salary(70000).gender(Gender.FEMALE).exp(1).level(12).build());
		employees.add(Employee.builder().id(105).name("Neeti").age(21).salary(30000).gender(Gender.FEMALE).exp(2).level(15).build());
		employees.add(Employee.builder().id(106).name("Juhi").age(20).salary(40000).gender(Gender.FEMALE).exp(3).level(12).build());
		employees.add(Employee.builder().id(107).name("Dhria").age(32).salary(30000).gender(Gender.FEMALE).exp(4).level(10).build());
		employees.add(Employee.builder().id(108).name("Lopa").age(25).salary(38000).gender(Gender.FEMALE).exp(1).level(11).build());
		employees.add(Employee.builder().id(109).name("Krishil").age(26).salary(38000).gender(Gender.MALE).exp(6).level(19).build());
		employees.add(Employee.builder().id(110).name("Laxman").age(27).salary(37000).gender(Gender.MALE).exp(7).level(11).build());
		employees.add(Employee.builder().id(111).name("Gopal").age(24).salary(36000).gender(Gender.MALE).exp(8).level(10).build());
		employees.add(Employee.builder().id(112).name("Madhav").age(22).salary(35000).gender(Gender.MALE).exp(9).level(8).build());
		employees.add(Employee.builder().id(113).name("Lucky").age(22).salary(34000).gender(Gender.MALE).exp(2).level(4).build());
		employees.add(Employee.builder().id(114).name("Lakshman").age(22).salary(33000).gender(Gender.MALE).exp(1).level(1).build());
		employees.add(Employee.builder().id(115).name("Adi").age(22).salary(50000).gender(Gender.MALE).exp(4).level(2).build());
		employees.add(Employee.builder().id(116).name("Boman").age(20).salary(70000).gender(Gender.MALE).exp(1).level(3).build());

// by level
		List<Employee> myNewEmp1 = employees.stream().filter(employee -> employee.getLevel() == 10).collect(Collectors.toList());
		System.out.println(myNewEmp1);
		double totalSalary = myNewEmp1.stream().mapToDouble(Employee :: getSalary).sum();
		System.out.println("Total Salary " + totalSalary);
		
		assertEquals(116000.0, totalSalary);
		assertNotEquals(119000.0, totalSalary);
		
	 // by gender	
		List<Employee> myNewEmp2 = employees.stream().filter(employee -> employee.getGender() == Gender.FEMALE).collect(Collectors.toList());
		System.out.println(myNewEmp2);
		double totalSalary1 = myNewEmp2.stream()
				.mapToDouble(Employee :: getSalary).sum();
		System.out.println(totalSalary1);
		

		assertEquals(259000.0, totalSalary1);
		assertNotEquals(129000.0, totalSalary1);
		
		
	// by name 
		
		List<Employee> myNewEmp4 = employees.stream().filter(employee -> employee.getName().contains("i") ).collect(Collectors.toList());
		System.out.println(myNewEmp4);
		double totalSalary4 = myNewEmp4.stream().mapToDouble(Employee :: getSalary).sum();
		System.out.println(totalSalary4);
		
		assertEquals(379000.0, totalSalary4);
		assertNotEquals(129000.0, totalSalary4);
		
		
		
	}
	
	
	
	
	 void testEquals() {
		 Employee emp1 = new Employee(100,"Abhi",22,30000,10,1,Employee.Gender.MALE);
		 Employee emp2 = new Employee(100,"Abhilash",22,30000,10,1,Employee.Gender.MALE);
		 Employee emp3 = new Employee(100,"Abhi",22,30000,10,1,Employee.Gender.MALE);
		 
		 assertFalse(emp1.equals(emp2));
		 assertTrue(emp1.equals(emp3));
	}
	

	
	
	
	
	
	
	
	
	
	



			
			
		
}

