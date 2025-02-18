package day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimalTest {

	@Test
	void testDog() {
		Dog dog = new Dog();
		showBehaviour(dog);
		fail("should fail....");
	}

	@Test
	void testcat() {
		showBehaviour(new cat());
	}

	@Test
	void testTiger() {
		showBehaviour(new Tiger());
		
	}
	
	private void showBehaviour(Animal a) {
		a.makeSound();
		a.eat();
		a.sleep();
	}

}
