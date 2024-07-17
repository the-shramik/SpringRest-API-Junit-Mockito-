package com.springunittesting.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springunittesting.model.Employee;
import com.springunittesting.service.IEmployeeService;

@WebMvcTest(EmployeeController.class)
class TestEmployeeController {
  
	@MockBean
     private IEmployeeService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testwishEmp() throws Exception {
		 //Mocking
		 Mockito.when(service.wishEmp()).thenReturn("Wishing...!");
		 
		// RequestObject(Only for API testing)
		 MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/wishEmp");
		 ResultActions perform = mockMvc.perform(requestBuilder);
		 
		 MvcResult mvcResult = perform.andReturn();
		 
		 MockHttpServletResponse response = mvcResult.getResponse();
		 
		 int statusCode = response.getStatus();
		 
		 assertEquals(200, statusCode);
	}
	
	@Test
	public void testaddEmp() throws Exception {
		
		//Mocking
		Mockito.when(service.addEmp(ArgumentMatchers.any())).thenReturn(true);
		
		Employee employee=new Employee(111L,"Shramik",89373.43);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(employee);
	
		// RequestObject(Only for API testing)
		MockHttpServletRequestBuilder requestBuilder=
				MockMvcRequestBuilders.post("/employee/addEmp").contentType(MediaType.APPLICATION_JSON).content(json);
		ResultActions perform = mockMvc.perform(requestBuilder);
		
		MvcResult mvcResult = perform.andReturn();
		
		MockHttpServletResponse response = mvcResult.getResponse();
		
		int statusCode = response.getStatus();
		
		assertEquals(200, statusCode);
	}
}
