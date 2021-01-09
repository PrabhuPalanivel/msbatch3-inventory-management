package com.sl.ms.inventorymanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.ms.inventorymanagement.model.Inv;


@Service
@Transactional
public class InvService {

	
	@Autowired
	private InvRepository invrepo;
	  public List<Inv> listAll() {
	       return invrepo.findAll();
	   }
	    
	   public void save(Inv inv) {
		   invrepo.save(inv);
	   }
	    
	   public Inv get(Integer id) {
	       return invrepo.findById(id).get();
	   }
	    
	   public void delete(Integer id) {
		   invrepo.deleteById(id);
	   }
}
