package com.springboot.prodservicei;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.model.Product;

public interface ProdServiceI {

	Product save(Product p);
	 Page<Product> findAll(Pageable pageable) ;
	  void delete(Product p);
	  Product singledata(long prodid);
}
