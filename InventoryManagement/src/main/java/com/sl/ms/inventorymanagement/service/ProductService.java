package com.sl.ms.inventorymanagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.ms.inventorymanagement.model.Product;



@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository productrepo;
	
   public List<Product> listAll() {
       return productrepo.findAll();
   }
   
   public List<Product> listSupAll() {
       return productrepo.findDistinctNameBy();
   }
    
   public void save(Product order) {
	   productrepo.save(order);
   }
    
   public Product get(Integer id) {
       return productrepo.findById(id).get();
   }
    
   public void delete(Integer id) {
	   productrepo.deleteById(id);
   }


   

}
