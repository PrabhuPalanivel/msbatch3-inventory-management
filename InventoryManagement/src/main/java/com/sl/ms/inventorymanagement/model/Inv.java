package com.sl.ms.inventorymanagement.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.util.JSONPObject;

@Entity
@Table(name="sl_inv")
public class Inv {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name="id")
	private Integer id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="file")
	private String  file;
	
	
	public Inv() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Inv [id=" + id + ", date=" + date + ", file=" + file + "]";
	}


	public Inv(Integer id, Date date, String file) {
		super();
		this.id = id;
		this.date = date;
		this.file = file;
	}


	

	public Inv(Date date, String file) {
		super();
		this.date = date;
		this.file = file;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}

	

	
	
}
