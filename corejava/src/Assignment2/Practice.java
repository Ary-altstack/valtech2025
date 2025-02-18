package Assignment2;

import java.util.Comparator;
import java.util.Objects;

public class Practice {
	
	private int id;
	private String name;
	private double gpa;
	
	
	public Practice(int id, String name, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}
	
	
//	public static StudentBuilder builder() {
//		return new StudentBuilder(new Student());
//	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	
	
	@Override
	public String toString() {
		return " name " + name  + "  id " + id + "  gpa " + gpa;
		
	}


	@Override
	public int hashCode() {
		
		return toString().hashCode();
		
	}
	



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Practice other = (Practice) obj;
		return Double.doubleToLongBits(gpa) == Double.doubleToLongBits(other.gpa) && id == other.id
				&& Objects.equals(name, other.name);
	}
	
	
	
	
	

	
}
