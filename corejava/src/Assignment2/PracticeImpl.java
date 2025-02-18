package Assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PracticeImpl {

//	private Object name;
	
	public static void main(String[] args) {
		List<Practice> student = new ArrayList<>();

	student.add(new Practice(1,"Arya",.9));
	student.add(new Practice(2,"Raj",9.2));
	student.add(new Practice(3,"Vishal",8.1));
	student.add(new Practice(4,"Siddhi",9.1));
	student.add(new Practice(5,"Zarana",8.6));
	student.add(new Practice(6,"Hena",7.7));
	
//	student.forEach(System.out::println);;
	
	System.out.println("-----------------");
	PracticeImpl p1 = new PracticeImpl();
	System.out.println(p1.sortedById(student));
	
	System.out.println(p1.hashCode());
		
	
	}

		
	
;
	
	
	public List<Practice> sortedById(List<Practice> p){
	return p.stream().
			sorted(Comparator.comparing(Practice::getName)).collect(Collectors.toList());
	}
	
	
	
		
	
	
	

	
	
	
}
