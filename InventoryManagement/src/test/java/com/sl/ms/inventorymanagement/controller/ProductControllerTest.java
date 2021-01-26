
package com.sl.ms.inventorymanagement.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.sl.ms.inventorymanagement.model.Product;
import com.sl.ms.inventorymanagement.service.ProductRepository;
import com.sl.ms.inventorymanagement.service.ProductService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

	private String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwcmFiaHV0ZXN0IiwiZXhwIjoxNjExNzAyOTMzLCJpYXQiOjE2MTE2ODQ5MzN9.-KbY8NKl6TqoqqvIL4HZf2YLruh23svL1Q9CVMi4G4BkTFZ98XVViHP_MTG2oPdLB2rXWIMHGYdVfr_gbMQkWw";
	ObjectMapper objectMapper = new ObjectMapper();
	List<Product> listproducts = new ArrayList<>();

	@Autowired
	private ProductController productController;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@MockBean
	private ProductRepository productRepository;

	@Test
	public void getProductAllTest() throws Exception {
		List<Product> listproducts = new ArrayList<>();
		listproducts.add(new Product(301, "Product301", 21, 10));
		listproducts.add(new Product(302, "Product302", 22, 12));
		listproducts.add(new Product(303, "Product303", 23, 15));
		listproducts.add(new Product(304, "Product304", 24, 17));
		listproducts.add(new Product(305, "Product305", 25, 20));

		when(productService.listAll()).thenReturn(listproducts);

		String url = "/products"; //
		// MvcResult mvcResult =
		// mockMvc.perform(MockMvcRequestBuilders.get(url).header("Authorization",token)).andExpect(status().isOk()).andReturn();
		MvcResult mvcResult = mockMvc.perform(get(url).header("Authorization", token)).andExpect(status().isOk())
				.andReturn();
		System.out.println("mvcResult" + mvcResult.toString());
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		// actualJsonResponse=
		// "[{\"id\":301,\"name\":\"Product301\",\"price\":21,\"quantity\":10},{\"id\":302,\"name\":\"Product302\",\"price\":22,\"quantity\":12},{\"id\":303,\"name\":\"Product303\",\"price\":23,\"quantity\":15},{\"id\":304,\"name\":\"Product304\",\"price\":24,\"quantity\":17},{\"id\":305,\"name\":\"Product305\",\"price\":25,\"quantity\":20}]";
		System.out.println("actualJsonResponse" + actualJsonResponse);

		String ExpectedJsonResponse = objectMapper.writeValueAsString(listproducts);

		System.out.println("ExpectedJsonResponse" + ExpectedJsonResponse);
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(ExpectedJsonResponse);
	}

	/*
	 * @Test public void saveProduct() throws Exception { Product p1 = new
	 * Product(301, "Product301", 21, 10); String jsonString =
	 * "[{\"id\":301,\"name\":\"Product301\",\"price\":21,\"quantity\":10}]";
	 * 
	 * ProductService productservice = mock(ProductService.class);
	 * doNothing().when(productservice).save(p1); listproducts.add(p1);
	 * verify(listproducts, times(6)).add(p1);
	 * 
	 * Mockito.doNothing().when(productService).save(p1); String url =
	 * "/products/301"; mockMvc.perform(
	 * post(url).content(jsonString).contentType(MediaType.APPLICATION_JSON).header(
	 * "Authorization", token)) .andExpect(status().isOk());
	 * Mockito.verify(productService, times(1)).save(p1); }
	 */

	@Test
	public void saveOneProduct() throws Exception {
		Product existp1 = new Product(301, "Product301", 21, 10);
		Product updatep1 = new Product(301, "Product301", 16, 10);
		// Mockito.when(productService.save(existp1)).thenReturn(updatep1);
		String url = "/products/301";
		mockMvc.perform(MockMvcRequestBuilders.post(url).header("Authorization", token).contentType("application/json")
				.content(objectMapper.writeValueAsString(updatep1))).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void saveAllProduct() throws Exception {
		// Product existp1 = new Product(301, "Product301", 21, 10);
		// Product updatep1 = new Product(301,"Product301", 16, 10); List<Product>
		// listproducts = new ArrayList<>();
		listproducts.add(new Product(301, "Product301", 21, 10));
		listproducts.add(new Product(302, "Product302", 22, 12));
		listproducts.add(new Product(303, "Product303", 23, 15));
		listproducts.add(new Product(304, "Product304", 24, 17));
		listproducts.add(new Product(305, "Product305", 25, 20));

		// Mockito.when(productService.save(existp1)).thenReturn(updatep1);
		String url = "/products";
		mockMvc.perform(MockMvcRequestBuilders.post(url).header("Authorization", token).contentType("application/json")
				.content(objectMapper.writeValueAsString(listproducts))).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void updateProduct() throws Exception {
		Product existp1 = new Product(301, "Product301", 21, 10);
		Product updatep1 = new Product(301, "Product301", 16, 10);
		// Mockito.when(productService.save(existp1)).thenReturn(updatep1);

		String url = "/products/301";
		mockMvc.perform(MockMvcRequestBuilders.put(url).header("Authorization", token).contentType("application/json")
				.content(objectMapper.writeValueAsString(updatep1))).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testDeleteProduct() throws Exception {

		Integer productid = 17;
		Mockito.doNothing().when(productService).delete(productid);
		String url = "/products/" + productid;
		mockMvc.perform(delete(url).header("Authorization", token)).andExpect(status().isOk());
		Mockito.verify(productService, times(1)).delete(productid);
	}

	@Test
	public void getProductByIdTest() throws Exception {
		Product product = new Product();
		product.setId(201);
		product.setName("Product201");
		product.setPrice(120);
		product.setQuantity(12);

		when(productService.get(anyInt())).thenReturn(product);
		mockMvc.perform(MockMvcRequestBuilders.get("/products/201").header("Authorization", token))
				// mockMvc.perform((RequestBuilder)
				// ((ResultActions)MockMvcRequestBuilders.get("/products/201").header("Authorization",
				// // token)))
				.andDo(print()).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(201))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Product201"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(120))
				.andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(12)).andExpect(status().isOk());
	}
	
	@Test
	public void getProducts() throws Exception {
		Product product = new Product();
		product.setId(201);
		product.setName("Product201");
		product.setPrice(120);
		product.setQuantity(12);

		when(productService.get(anyInt())).thenReturn(product);
		mockMvc.perform(MockMvcRequestBuilders.get("/products/201").header("Authorization", token))
				// mockMvc.perform((RequestBuilder)
				// ((ResultActions)MockMvcRequestBuilders.get("/products/201").header("Authorization",
				// // token)))
				.andDo(print()).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(201))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Product201"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(120))
				.andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(12)).andExpect(status().isOk());
	}
	
	

}
