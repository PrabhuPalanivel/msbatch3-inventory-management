package com.sl.ms.inventorymanagement.controller;

import java.util.Calendar;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		java.sql.Date date = new java.sql.Date(currentDate.getTime());
		System.out.println("date---"+date);
		
		String jsonString1 = ReadInputfile.readfile();
		System.out.println("jsonString1---"+jsonString1);
	}

}
