package Assignment2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsDAO {
	
	public class kids{
		public static void main(String[] args) {
			List<Student> students = Arrays.asList(new Student(12,"Arya",78.9,"IT"),new Student(13,"Hena",98.2,"IT"),new Student(14,"Mayank",77,"CS"));
					
		
			List<Student> sortedbyAlphabets = students.stream().collect(Collectors.toList());
			System.out.println(sortedbyAlphabets);
			
		}
		
		
	}

}
