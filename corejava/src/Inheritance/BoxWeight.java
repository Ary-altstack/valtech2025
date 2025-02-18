package Inheritance;

public class BoxWeight extends Box {
	double weight; 
	
	public BoxWeight() {
		this.weight= -1;
	}
	
	BoxWeight(BoxWeight other) {
		super(other);
		weight = other.weight;
		
	}
	
	BoxWeight (double side,double weight){
		super(side);
		this.weight = weight;
	}

	public BoxWeight(double l, double w, double h,double weight) {
		super(l, w, h);
		
//		System.out.println(super.w); 	
		this.weight = weight;
		
	}
	

}
