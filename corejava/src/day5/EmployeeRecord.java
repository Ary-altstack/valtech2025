package day5;

import Assignment.Employee.Gender;

public record EmployeeRecord(int id, String name,int age, Gender gender,float salary, int experience,int level) {
	
	public EmployeeRecord() {
		this(0,"",23,Gender.MALE,0,0,0);
	}
	
	public int computeBonus() {
		return experience * 100 + level * 1000;
	}
}
