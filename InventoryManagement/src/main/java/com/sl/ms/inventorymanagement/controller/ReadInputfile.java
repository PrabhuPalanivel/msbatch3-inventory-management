package com.sl.ms.inventorymanagement.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sl.ms.inventorymanagement.model.Product;


public class ReadInputfile 
{
	/*
	 * 
	 * private final static Logger logger =
	 * LoggerFactory.getLogger(ReadInputfile.class); public static String
	 * jsonString;
	 * 
	 * public static String readfile() { List<Product> products = readCsvFile(
	 * "c://Users/prabh/eclipse-workspace/SuperLeague/Input/ProductInventory.csv");
	 * return jsonString = convertJavaObject2JsonString(products);
	 * 
	 * }
	 * 
	 * public static List<Product> jsonProductasObject() { List<Product> products =
	 * readCsvFile(
	 * "c://Users/prabh/eclipse-workspace/SuperLeague/Input/ProductInventory.csv");
	 * return products;
	 * 
	 * }
	 * 
	 * private static List<Product> readCsvFile(String filePath) {
	 * 
	 * logger.info("inside read CSV file"); BufferedReader fileReader = null;
	 * CSVParser csvParser = null;
	 * 
	 * List<Product> products = new ArrayList<Product>();
	 * 
	 * try { fileReader = new BufferedReader(new FileReader(filePath)); csvParser =
	 * new CSVParser(fileReader,
	 * CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
	 * );
	 * 
	 * Iterable<CSVRecord> csvRecords = csvParser.getRecords();
	 * 
	 * for (CSVRecord csvRecord : csvRecords) { Product product = new Product(
	 * Integer.parseInt(csvRecord.get("id")) , csvRecord.get("name"),
	 * Integer.parseInt(csvRecord.get("price")) ,
	 * Integer.parseInt(csvRecord.get("quantity")) );
	 * 
	 * products.add(product); }
	 * 
	 * } catch (Exception e) { System.out.println("Reading CSV Error!");
	 * e.printStackTrace(); } finally { try { fileReader.close(); csvParser.close();
	 * } catch (IOException e) {
	 * System.out.println("Closing fileReader/csvParser Error!");
	 * e.printStackTrace(); } }
	 * 
	 * return products; }
	 * 
	 * 
	 * 
	 * private static String convertJavaObject2JsonString(List<Product> products) {
	 * ObjectMapper mapper = new ObjectMapper(); String jsonString = "";
	 * 
	 * try { mapper.configure(SerializationFeature.INDENT_OUTPUT, true); jsonString
	 * = mapper.writeValueAsString(products); } catch (JsonProcessingException e) {
	 * e.printStackTrace(); } System.out.println(jsonString); return jsonString; }
	 * 
	 */
	
}
