package com.lokesh.hospital;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HospitalServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void addHostpitalTest_ok() throws Exception {
		this.mockMvc.perform(post("/test/hospitals?id=1&name=Ciigma&rating=7.9")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Hospital Added")));
	}
	
	@Test
	public void getHospitalTest_ok() throws Exception {
		addHostpitalTest_ok();
		this.mockMvc.perform(get("/test/hospitals/1")).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.id", is(1)))
		.andExpect(jsonPath("$.name", is("Ciigma")))
		.andExpect(jsonPath("$.rating", is(7.9)));
	}
}
