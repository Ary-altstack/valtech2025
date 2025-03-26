package com.valtech.training.registerservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterServiceTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testRegisterService() throws Exception {
		mockMvc.perform(get("/api/v1/users/1")).andDo(print()).andExpect(content()
				.json("{'id': 2,'name': null,'mobile': null,'email':'shaha@gmail.com','kid': false, 'subscriptionId': 1}"))
		.andExpectAll(status().isOk());
	}

}
