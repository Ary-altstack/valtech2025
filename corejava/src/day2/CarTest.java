package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

//	private void testClone() throws Exception {
//		Car car = new Car("Honda","City","VX",2024,7);
//		Car car1 = (Car)car.clone();
//		assertEquals(car,car1);
//		assertNotSame(car,car1);
//		
//
//	}
	
	@Test
	void testhehashcode() {
		Car car = new Car("Honda","City","VX",2024,7);
		int hash = car.hashCode();
		System.out.println(car + " "+ car.hashCode());
		
		assertEquals(hash,car.hashCode());
		assertEquals(hash, new Car("Honda","City","VX",2024,7).hashCode());
		car.setVariant("ZX");
		System.out.println(car.toString());
		System.out.println(car+" "+car.hashCode());
		
		assertNotEquals(hash,car.hashCode());
		car.setVersion(6);
		System.out.println(car+" "+ car.hashCode());
		
		assertNotEquals(hash,car.hashCode());
		car.setModel("Jazz");
		System.out.println(car+" "+ car.hashCode());
		assertNotEquals(hash,car.hashCode());
		
		
	}

}
