package com.example.Concess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConcessApplicationTests {

	@Test
	void contextLoads() {
		Car car = new Car("AA11BB", "Ferrai", 2000);
		String plateNumber = car.getPlateNumber();
		assertEquals(plateNumber, "AA11BB");
	}

}
