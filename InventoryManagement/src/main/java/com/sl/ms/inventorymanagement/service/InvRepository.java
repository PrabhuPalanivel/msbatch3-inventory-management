package com.sl.ms.inventorymanagement.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sl.ms.inventorymanagement.model.Inv;


public interface InvRepository extends JpaRepository<Inv, Integer> {

}
