package dao;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;


public class Employee implements Comparable<Employee>{
	
	private long id;
	private String name;
	private int age;
	private float salary;
	private int level;
	private int exp;
	private int dept_id;
	
	public enum Gender {
		MALE,FEMALE,OTHERS
	}
	
	private Gender gender;
	
	
	public Employee (long id,String name,int age,float salary,int level,int exp,Gender gender,int dept_id) {
		this.id = id;
		this.name = name;
		this.age=age;
		this.salary = salary;
		this.level=level;
		this.exp = exp;
		this.gender=gender;
		this.dept_id = dept_id;
	
	}
	
	public Employee() {}

	public static EmployeeBuilder builder() {
		return new EmployeeBuilder(new Employee());
	}
	
	
	//getters and setters
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && exp == other.exp && gender == other.gender && id == other.id && level == other.level
				&& Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();

	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new StringBuilder()
				.append(" id: "+id)
				.append("")
				.append(" name: "+name)
				.append("")
				.append(" age: "+age)
				.append("")
				.append(" salary "+salary)
				.append("")
				.append(" level "+level)
				.append("")
				.append(" exp "+exp)
				.append("")
				.append(" gender "+gender)
				.append("dept_id " +dept_id)
				.append("").toString();
		
	}	
		
		
		public static class EmployeeBuilder{
			private Employee employee;
			
			public EmployeeBuilder(Employee emp) {
				this.employee=emp;
				
			}
			public Employee build() {
				return employee;
			}
			public EmployeeBuilder id(long id) {
				employee.setId(id);
				return this;
			}
			
			public EmployeeBuilder name(String name) {
				employee.setName(name);
				return this;
			}
			public EmployeeBuilder age(int age) {
				employee.setAge(age);
				return this;
			}
			public EmployeeBuilder salary (float salary) {
				employee.setSalary(salary);
				return this;
			}
			public EmployeeBuilder level(int level) {
				employee.setLevel(level);
				return this;
			}
			public EmployeeBuilder exp (int exp) {
				employee.setExp(exp);
				return this;
			}
			
			public EmployeeBuilder gender (String gender) {
				employee.setGender(Gender.valueOf(gender));
				return this;
			}
			public EmployeeBuilder dept_id(int dept_id) {
				employee.setDept_id(dept_id);
				return this;
			}
			
			
		
		}
	
		
		@Override
		public int compareTo(Employee o) {
			int compareLevel=Integer.compare(this.level, o.level);
			if (compareLevel!=0) {
				return compareLevel;
			}
			int compareExp=Integer.compare(this.exp, o.exp);
			if (compareExp!=0) {
				return compareLevel;
			}
			int genderCompare=o.gender.compareTo(this.gender);
			if (genderCompare!=0) {
				return genderCompare;
			}
			int compareSalary=Float.compare(this.salary, o.salary);
			return compareSalary;
		}
		
		
}
	