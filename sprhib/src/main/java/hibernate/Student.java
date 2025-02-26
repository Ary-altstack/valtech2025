package hibernate;
	
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Student {
	
	@EmbeddedId
	private StudentId id;
	private String name;
	private String fathers_name;
	private String stream;
		@Embedded()
		@AttributeOverrides({
			@AttributeOverride(name="street",column=@Column(name="current_street")),
			@AttributeOverride(name="city",column=@Column(name="current_city")),
			@AttributeOverride(name="pinCode",column=@Column(name="current_pincode"))
		})

	private StudentAddress currentAddress;
	@Embedded()
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="home_street")),
		@AttributeOverride(name="city",column=@Column(name="home_city")),
		@AttributeOverride(name="pinCode",column=@Column(name="home_pincode"))
	})
	
	private StudentAddress homeAddress;
	private long mobile;
	
	
	public Student () {}
	
	public Student(StudentId id, String name, String fathers_name, String stream, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.fathers_name = fathers_name;
		this.stream = stream;
		this.mobile = mobile;

	}


	

	public Student(StudentId id, String name, String fathers_name, String stream, StudentAddress currentAddress,
			StudentAddress homeAddress, long mobile) {
		this.id = id;
		this.name = name;
		this.fathers_name = fathers_name;
		this.stream = stream;
		this.currentAddress = currentAddress;
		this.homeAddress = homeAddress;
		this.mobile = mobile;
	}

	public StudentAddress getHomeAddress() {
		return homeAddress;
	}
	
	public void setHomeAddress(StudentAddress homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public StudentAddress getCurrentAddress() {
		return currentAddress;
	}
	
	public void setCurrentAddress(StudentAddress currentAddress) {
		this.currentAddress = currentAddress;
	}
	
	public StudentId getId() {
		return id;
	}
	public void setId(StudentId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFathers_name() {
		return fathers_name;
	}
	public void setFathers_name(String fathers_name) {
		this.fathers_name = fathers_name;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	
	
	

}
