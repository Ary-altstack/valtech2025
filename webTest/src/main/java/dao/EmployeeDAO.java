package dao;

import java.util.List;

//import Assignment.Employee;

public interface EmployeeDAO {
	
	void save(Employee e);
	
	void update(Employee e);
	
	void delete(int id);
	
	Employee get(int id);
	
	List<Employee> getAll();
	
	List<Employee> sortedEmployeesById();
	
	List<Employee> sortedEmployeesByIdDesc();
	List<Employee> sortedEmployeesByName();
	List<Employee> sortedEmployeesByAge();
	List<Employee> sortedEmployeesBySalary();
	List<Employee> sortedEmployeesByGender();
	List<Employee> sortedEmployeesByExperience();	
	List<Employee> sortedEmployeesByLevel();
	
//	List<Employee> sortedEmployeesByDept_id();
//	List<Employee> sortedEmployeesByDept_idDesc();
	
	List<Employee> sortedEmployeesByNameDesc();
	List<Employee> sortedEmployeesByAgeDesc();
	List<Employee> sortedEmployeesBySalaryDesc();
	List<Employee> sortedEmployeesByGenderDesc();
	List<Employee> sortedEmployeesByExperienceDesc();	
	List<Employee> sortedEmployeesByLevelDesc();
	
	List<Employee> searchEmployeesByName(String name);
	List<Employee> searchEmployeesById(Long id);
	List<Employee> searchEmployeesByAge(int age);
	List<Employee> searchEmployeesBySalary(Double sal);
	List<Employee> searchEmployeesByLevel(int level);
	List<Employee> searchEmployeesByExperience(int exp);
//	List<Employee> searchEmployeesByGender(enum gender);
	
	
	
	
	


	
	

}
