package spring.ioc;

public class PointFactory {
	
	static int i;
	
	public PointFactory() {
		System.out.println("Point Factory...");
	}
	
	public static Point createPoint() {
//		System.out.println("Point Factory..");
		return new Point(i++,i);
	}
	
	public static Point createPoint(int x, int y) {
		System.out.println("X "+x+" Y "+y);
		return new Point(x,y);
	}
	

}
