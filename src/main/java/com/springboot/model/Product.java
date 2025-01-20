package com.springboot.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long prodid;
	private String prodname;
	private int prodprice;
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	public long getProdid() {
		return prodid;
	}
	public void setProdid(long prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public int getProdprice() {
		return prodprice;
	}
	public void setProdprice(int prodprice) {
		this.prodprice = prodprice;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
