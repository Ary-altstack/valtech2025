package day2;

public class ControlStatements {
	
	public void testIfElse() {
		
		int a = 4;
		if(a%2==0) {
			System.out.println("A ="+a +"is even");
		} else {
			System.out.println("A ="+a +"is odd");
		}
	}
	
	
	public void testfor (int [] a) {
		for(int i =0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public void testSwitch(int a) {
		switch(a) {
		case 1:
			System.out.println("one");
			break;
		case 2:
			System.out.println("two");
			break;
		default:
			System.out.println("All Others");
			
		}
	}
	
	public int add(int ... a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum +=a[i];
		}
		
		System.out.println("Sum =");
		return sum;
	}
	
	public static void main(String[] args) {
		ControlStatements cs = new ControlStatements();
		//cs.testIfElse(3);
		//cs.testIfElse(4);
		//cs.testIfElse(0);
	//	cs.testIfElse(-3);
		cs.testfor(new int[] {1,2,3});
		cs.testfor(new int[] {1,2,3,4,5});
		cs.testSwitch(1);
		cs.testSwitch(2);
		
		
		cs.add(1,2);
		cs.add(1,2,3);
		cs.add(1,2,3,4,5,6,7);
		
	}

}
