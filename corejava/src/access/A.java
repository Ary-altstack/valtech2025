package access;

public class A {
	protected int num;
	public String name;
	protected int[] arr;
	
	
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public A(int num, String name) {
		super();
		this.num = num;
		this.name = name;
		this.arr = new int[num];
	}
	
	

}
