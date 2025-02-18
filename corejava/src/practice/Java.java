package practice;

public class Java {
	
	
	public Java (){  // default constructor
		age = 22;
		name="Arya";
		
	}
	
	public Java(int age,String name) {  // paramterized constructor
		this.age=age;
		this.name=name;
		
	}
	
	
	private int age;
	private String name;
	
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public static void main(String[] args) {
		
		Java obj = new Java();
		Java obj1 = new Java(21,"Nilesh");
//		obj.setAge(21);
//		obj.setName("Arya");
//		
		System.out.println(obj.getName()+ " : "+ obj.getAge());
		System.out.println(obj1.getName()+ " : "+ obj1.getAge());
		
	}

}
