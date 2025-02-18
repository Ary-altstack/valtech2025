package Inheritance;

public class Box {
	double l;
	double w;
	double h;
	
	
	static void greeting() {
		System.out.println("Hey I am in Box Class. Greetings!");
	}
	
	Box(){
		this.l = -1;
		this.h=  -1;
		this.w=  -1;
	}
	
	
	//cube 
	
	
	Box(double side) {
		
		
		this.w = side;
		this.h = side ;
		this.l = side; 
		
	}


	Box(double l, double w, double h) {
		super();
		this.l = l;
		this.w = w;
		this.h = h;
	}
	
	Box(Box old) {
		this.l = old.l;
		this.h = old.h;
		this.w = old.w;
		
	}
	
	public void information ( ) {
		System.out.println("Running the box ");
		
	}

}
