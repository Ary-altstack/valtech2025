package com.valtech.training.employee.vos;

import com.valtech.training.employee.entities.Employee;

public record EmployeeVO(long id,String name,String email,long mobile,long managerId) {
	
	public static EmployeeVO from(Employee e) {
		long manId = e.getManager() == null ? 0 : e.getManager().getId();
		return new EmployeeVO(e.getId(),e.getName(),e.getEmail(),e.getMobile(), manId);
		
	}
	
	public Employee to(Employee manager) {
		Employee e = new Employee(id,name, mobile, email);
		e.setManager(manager);
		return e;
		
	}

}
