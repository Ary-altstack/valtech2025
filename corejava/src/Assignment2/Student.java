package Assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Student {
	
	private long id;
	private String name;
	private double grade;
	private String department;
	
	public Student() {}

	public Student(long id, String name, double grade, String department) {
//		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.department = department;
	}
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
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	@Override
	public String toString() {
		return  id +" id " + name +" name " + grade + " grade " + department + " department " ;
	}
	
	public class Kids{
		public void random(){
			List<Student> students = Arrays.asList(new Student(21,"Arya",78.9,"IT"),new Student(41,"Mayank",77,"CS"),new Student(13,"Hena",98.2,"IT"));
					
			
	
			List<Student> sortedbyAlphabets = students.stream().sorted(Comparator.comparing(Student::getName))
					.collect(Collectors.toList());
			System.out.println("Sorting by Name" + sortedbyAlphabets);
			
			List<Student> sortedbyID = students.stream().sorted(Comparator.comparingLong(Student::getId))
					.collect(Collectors.toList());
			System.out.println("Sorting by Id" + sortedbyID);
			
			List<Student> searchingByname = students.stream().filter(student->student.getName().contains("ay")).toList();
			System.out.println("Searching By Name" + searchingByname);
			
		}
		
		
		
	}
	
		public static void main(String[] args) {
			Student myStudent = new Student();
			Student.Kids myKids = myStudent.new Kids();
			myKids.random();
//			System.out.print(myKids.random());
//			System.out.println(myKids  myStudent);
			
		}
	
	
	
	

}


