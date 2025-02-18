package access;

public class ObjectDemo {
	
	
	 int num ;
	 Float gpa;
	 
	 public ObjectDemo(int num,float gpa) {
		
		this.num = num;
		this.gpa =  gpa; 
	}

	@Override // Gives String representation
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override // Called when garbage collection hits
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	

	@Override //  A unique representation of the objects via number  
	public int hashCode() {
		return num;
	}

	@Override
	public boolean equals(Object obj) {
		return this.num == ((ObjectDemo)obj).num ;
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public static void main(String[] args) {
		ObjectDemo obj = new ObjectDemo(21,78.8f);
		ObjectDemo obj2 = new ObjectDemo(21,78.8f);
		
		
//		if (obj == obj2) {
//			System.out.println("obj is equal to obj 2");
//		}
//		

		if (obj.equals(obj2)) {
			System.out.println("obj is equal to obj 2");
		}

			System.out.println(obj.getClass());
		
//		System.out.println(obj.hashCode()== obj2.hashCode());
//		System.out.println('c' == 'c');
//		System.out.println("Dog" == "Dog");

//		System.out.println(obj.hashCode());
//		System.out.println(obj2.hashCode());

	}
	
	
}
