package com.sl.ms.inventorymanagement.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sl.ms.inventorymanagement.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
		public List<Product> findDistinctNameBy();
	}
