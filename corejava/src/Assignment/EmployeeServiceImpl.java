package Assignment;

import java.util.Comparator;
import java.util.List;

import Assignment.Employee.Gender;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void sortEmployeeById() {
		
	}

	@Override
		public double sumOfSalaryByLevel(List<Employee> employees,int exp) {
		return employees.stream().filter(employee->employee.getLevel()==exp).mapToDouble(Employee::getSalary).sum();		
		
	}

	@Override
	public double sumOfSalaryByGender(List<Employee> employees,Gender gender) {
		return employees.stream().filter(employee->employee.getGender()== gender).mapToDouble(Employee::getSalary).sum();		
	}

//	@Override
//	public List<Employee> sumOfSalaryByExp() {
//	return	SumOfSalaryByExp = employees.stream().filter(employee->employee.getExp()==4).mapToDouble(Employee::getSalary).sum();
//		
//	}

	@Override
	public double employeeNameContains(List<Employee>employees,String name) {
		return employees.stream().filter(employee->employee.getName().contains(name)).mapToDouble(Employee::getSalary).sum();

	}

	@Override
	public double sumOfSalaryByExp(List<Employee> employees,int exp) {
		return employees.stream().filter(employee->employee.getExp()==exp).mapToDouble(Employee::getSalary).sum();		
	}
	
	

}
