package com.sl.ms.inventorymanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;



@SpringBootApplication
@EnableCaching  
public class InventoryManagementApplication {
	private final static  Logger logger = LoggerFactory.getLogger(InventoryManagementApplication.class);
	public static void main(String[] args) {
		logger.info("Starting InventoryManagementApplication ");
		SpringApplication.run(InventoryManagementApplication.class, args);
	}

}
