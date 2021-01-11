package com.sl.ms.inventorymanagement.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sl.ms.inventorymanagement.model.Prodt;

public interface ProdtRepository extends JpaRepository<Prodt, Integer> {

	
	 @Query("SELECT DISTINCT new Prodt(p.id,p.name) FROM Product p")
	public List<Prodt> findDistinctProduct();
}
