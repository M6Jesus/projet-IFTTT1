package org.pamela.projet.status.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pamela.projet.ifttt.ApplicationRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationRunner.class)
public class StatusControllerTest {
	
	@Resource
	private WebApplicationContext wac;

	
	private MockMvc mockMvc;
	
	@Before
	public void init() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void should_be_ok_when_get_url_status_with_right_key() throws Exception {
		mockMvc
			.perform(MockMvcRequestBuilders.get("/api/ifttt/v1/status").header("IFTTT-Service-Key", "23VjEuaT7ZzTthcGFaCBiUfsNAeuIlWMzmIaSk5mHQSKjTWT8fjBYGHAz34atJ6A"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void should_be_unavailable__get_url_status_with_wrong_Key() throws Exception {
		mockMvc
			.perform(MockMvcRequestBuilders.get("/api/ifttt/v1/status").header("IFTTT-Service-Key", "faux"))
			.andExpect(MockMvcResultMatchers.status().isServiceUnavailable());
	}

}
