
package com.sl.ms.inventorymanagement.controller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.sl.ms.inventorymanagement.InventoryManagementApplication;
import com.sl.ms.inventorymanagement.model.Prodt;
import com.sl.ms.inventorymanagement.model.Product;
import com.sl.ms.inventorymanagement.service.ProductRepository;
import com.sl.ms.inventorymanagement.service.ProductService;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = {
		InventoryManagementApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIntegrationTest {

	
	 List<Product> listproducts= new ArrayList<>(); 
	 List<Prodt> listsuppproducts= new ArrayList<>(); 
	 
	@Autowired
	private TestRestTemplate restTemplate;

	
    @Autowired
    private ProductService service;

    @MockBean
    private ProductRepository repository;
	
	
	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}
	

	@SuppressWarnings("restriction")
	@Test
	public void testCreateProductwhennotworking() {
		Prodt prodt = new Prodt(601,"Product601");
		Prodt prodt1 = new Prodt(602,"Product602");
		listsuppproducts.add(prodt);
		listsuppproducts.add(prodt1);
		ResponseEntity<String> postResponse = this.restTemplate.postForEntity("http://localhost:" + port + "/supported-products", prodt, String.class);
		System.out.println("postResponse" + postResponse.toString());
		//assertEquals(404, postResponse.getStatusCodeValue());
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());

	}

	@SuppressWarnings("restriction")
	@Test
	public void testGetAllProducts() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/products", HttpMethod.GET, entity,
				String.class);
		assertNotNull(response.getBody());
	}

	
	
	@SuppressWarnings("restriction")
	@Test
	public void testGetAProduct() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/products/601", HttpMethod.GET, entity,
				String.class);
		assertNotNull(response.getBody());
	}

}
