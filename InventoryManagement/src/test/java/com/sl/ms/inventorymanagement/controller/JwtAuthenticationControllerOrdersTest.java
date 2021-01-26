package com.sl.ms.inventorymanagement.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.catalina.security.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@Import(SecurityConfig.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JwtAuthenticationControllerOrdersTest {

	
	@Autowired
	private MockMvc mvc;
	
	
	@Autowired
	private JwtAuthenticationControllerOrders jwtAuthenticationControllerOrders;
	
	
	@Test
	public void existentUserCanGetTokenAndAuthentication() throws Exception {
	    String username = "prabhutest";
	    String password = "password";
	    String body = "{\"username\":\"" + username + "\", \"password\":\""+ password + "\"}";
	    System.out.println("body"+body);

	    MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/authenticate").content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	 
	    String response = result.getResponse().getContentAsString();
	    response = response.replace("{\"access_token\": \"", "");
	    String token = response.replace("\"}", "");
	    System.out.println("token generated"+token);

	   // mvc.perform(MockMvcRequestBuilders.get("/products/201")
	     //   .header("Authorization", "Bearer " + token))
	       // .andExpect(status().isOk());
	}
}
