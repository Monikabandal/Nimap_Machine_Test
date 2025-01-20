package com.springboot.prodrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Product;

@Repository
public interface ProdRepository extends JpaRepository<Product,Long> {
   Product  findByProdid(long prodid);
}
