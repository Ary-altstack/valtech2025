 package practice;


class Computer{
	
	public void playMusic() {
		System.out.println("Music playing");
	}
	
	public String GetMeAPen(int cost) {
		
		if(cost >= 10)
			return "Pen";
		else
		return "Nothing";
	}
}

public class Demo {


	public static void main(String a[]) {
		
		Computer obj = new Computer();
		obj.playMusic();
		String str = obj.GetMeAPen(1);
		System.out.println(str);
	}

}
