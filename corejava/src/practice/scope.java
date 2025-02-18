/**
 *     Scope
 *  Any thing that is initialized outside the block you can use it inside the block but
 * anything that is initialized inside the block can't be used outside the block 
 * 
 * Similarly anything that is initialized outside the block once can't be initialized inside 
 * anything that is initialized inside the block, we can initialized again outside the block 
 * 
 */

package practice;

public class scope {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		
		{
			a = 100;
			System.out.println(a);
			int c = 99;
			System.out.println(c);
		}
		
//		System.out.println(a);
//		System.out.println(c);
		
	}
	
	

}
