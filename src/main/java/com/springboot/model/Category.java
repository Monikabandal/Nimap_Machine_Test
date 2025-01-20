package com.springboot.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cid;
    private String cname;
   

	private String cdesc;
    
    @OneToMany(cascade =CascadeType.ALL )
    private List<Product> products;

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
    public String getCdesc() {
			return cdesc;
		}

	public void setCdesc(String cdesc) {
			this.cdesc = cdesc;
		}
	
	
}
