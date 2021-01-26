package com.sl.ms.inventorymanagement.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sl.ms.inventorymanagement.model.Inv;
import com.sl.ms.inventorymanagement.model.Prodt;
import com.sl.ms.inventorymanagement.model.Product;
import com.sl.ms.inventorymanagement.service.InvService;
import com.sl.ms.inventorymanagement.service.ProductService;

@RestController
@CrossOrigin()
public class ProductController {
	Calendar calendar = Calendar.getInstance();
	java.util.Date currentDate = calendar.getTime();
	java.sql.Date idate = new java.sql.Date(currentDate.getTime());
	Inv inventoryinput = new Inv();
	List<Product> supportedproducts;
	
	

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService service;

	@Autowired
	private InvService invservice;

	// to test the function to fetching product data from csv
	@GetMapping("/inventorydetails")
	public List<Inv> listInv() {
		logger.info("executing getmapping /inventorydetails");
		return invservice.listAll();
	}

	// Fetch the list of product inventory in system.
	@GetMapping("/products")
	public List<Product> list() {
		logger.info("executing getmapping /products");
		return service.listAll();
	}

	// Fetch the specific details of product details by passing product_id
	@GetMapping("/products/{id}")
	public Product get(@PathVariable Integer id) {
		logger.info("executing getmapping /products/{id}");
		return service.get(id);
	}

	// Insert a new inventory for s specific product via Rest end point.
	@PostMapping("/products/{id}")
	public void add(@RequestBody Product product, @PathVariable Integer id) {
		logger.info("executing postmapping /products/{id}");
		service.save(product);
	}

	// Post data for more than one product at a time.
	@PostMapping("/products")
	public void add(@RequestBody List<Product> product) {
		for (Product temp : product) {
			logger.info("executing postmapping /products");
			service.save(temp);
		}
	}

	// Post data for inventory update as a file. (simple csv)
	/*
	 * @PostMapping("/products/file") public void uploadFile() {
	 * logger.info("inside Postmapping for inv");
	 * System.out.println("inside Postmapping for inv"); String inputjsonString =
	 * ReadInputfile.readfile(); inventoryinput.setDate(idate);
	 * inventoryinput.setFile(inputjsonString.toString());
	 * System.out.println("inventoryinput" + inventoryinput);
	 * invservice.save(inventoryinput);
	 * 
	 * List<Product> readValue = ReadInputfile.jsonProductasObject(); for (Product
	 * temp : readValue) { System.out.println(temp); service.save(temp); } }
	 */

	// Update specific product inventory
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product order, @PathVariable Integer id) {
		try {
			logger.info("executing putmapping /products/{id}");
			service.save(order);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete a specific product from system

	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
		logger.info("executing deletemapping /products/{id}");
		service.delete(id);
	}

	// Fetch the unique list of products supported by system
		@GetMapping("/supported-products")
		@Cacheable(value="supportedproducts")
		public List<Prodt> listproducts() {
			logger.info("executing getmapping /supported-products");
			 List<Prodt> supportedlist =  service.listSupAll();
			 return supportedlist;
		}
	
	
}
