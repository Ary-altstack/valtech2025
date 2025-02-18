package Inheritance;

public class Main {
	public static void main(String[] args) {
		
		Box box1 = new Box(4.7,9.0,8.9);
		Box box2 = new Box(box1);
	//	Box box = new Box();
		
//		System.out.println(box.l + " " + box.w + " "+ box.h);
		
//		BoxWeight box3 = new BoxWeight();
//		BoxWeight box4 = new BoxWeight(2,3,4,5);
//		System.out.println(box3.h + " "+ box3.w); 
		
		
//		Box box5 = new BoxWeight(2,3,4,5);
//		System.out.println(box5.w);
//		
//		BoxWeight box6 = new BoxWeight(2,3,4,5);
//		System.out.println(box6);
		
		
		// 					READ THIS
		
		// there are many variables in both parent and child classes
		//you are given access to variables that are in the ref.type i.e BoxWeight
		//hence,you should have access to weight variable 
		//this also means, that the one you are trying to access should be initialized  
		//  but here ,when the object itself is if of type parent class,how will you call the constructor
		// this is why error 
		// BoxWeight box6 = new Box(2,3,4);
		//syso(box6);
		//
		//
		
		
//		BoxPrice  box = new BoxPrice(5,8,200);
		
//		box1.greeting();
		Box box = new BoxWeight();
		box.greeting(); // You can inherit but can't override
		
		
	} 
}
