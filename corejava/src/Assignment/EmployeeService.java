package Assignment;

import java.util.List;

import Assignment.Employee.Gender;

public interface EmployeeService {
	
	void sortEmployeeById();
//	void sortEmployeeByName();
//	void sortEmployeeByGender();
//	void sortEmployeeByLevel();
//	void sortEmployeeByExp();
	

	
	double sumOfSalaryByLevel(List<Employee> employees,int level);
	double sumOfSalaryByGender(List<Employee> employees,Gender gender);
	double sumOfSalaryByExp(List<Employee> employees,int exp);
	double employeeNameContains(List<Employee> employees,String name);
	
	
	
	

	

}
