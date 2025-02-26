package hibernate;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;


@Embeddable
public class StudentId implements Serializable {
	
	private int roll_no;
	private int year;
	
	public StudentId() {}
	
	
	
	public StudentId(int roll_no, int year) {
		super();
		this.roll_no = roll_no;
		this.year = year;
	}


	@Override
	public int hashCode() {
		return Objects.hash(roll_no, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentId other = (StudentId) obj;
		return roll_no == other.roll_no && year == other.year;
	}



	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	

}
