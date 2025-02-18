package practice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class StringExampleTest {

	@Test
	void test() {
		StringBuilder builder = new StringBuilder();
		for(int i =0;i<26;i++) {
			char ch = (char)('a' + i);
			builder.append(ch);
		}
		
		System.out.println(builder.toString());
		String name = "Arya Shah";
		System.out.println(Arrays.toString(name.toCharArray()));
		System.out.println(name.toLowerCase());		
		System.out.println(name.indexOf('y'));
		System.out.println(name.length());
		System.out.println(name.toUpperCase());
		
		
	}
	

}
