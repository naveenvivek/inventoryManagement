package com.inventory.catalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.inventory.catalog.controller.GroupByController;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private GroupByController groupByController;

	@Test
	void contextLoads() {
	}

	@Test
	void testGroupByBrand() throws Exception {
		// TODO: Mock the dependencies of GroupByController (repositories)
		// to ensure the test is isolated and repeatable.

		// Perform the request
		mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/groupByBrand"))
				.andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.status().isOk())
				.andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.model().attributeExists("type"))
				.andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.model().attribute("type", "groupByBrand"))
				.andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.model().attributeExists("groupBy"))
				.andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.view().name("display"));
	}
}