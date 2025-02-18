package polymorphism;

public class Numbers {
	
	double sum(double  a , int b) {
		return a+b;
	}
	
	int sum (int a, int b, int c) {
		return a+b+c;
	}
	
	
	public static void main(String[] args) {
		Numbers num = new Numbers();
		num.sum(1, 2);
		num.sum(1, 2, 8);
	}
}
