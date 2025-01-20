package com.springboot.prodcontroller;

import com.springboot.model.Category;
import com.springboot.model.Product;
import com.springboot.prodservicei.CategoryServiceI;
import com.springboot.prodservicei.ProdServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProdController {

	@Autowired
	ProdServiceI ps;
	@Autowired
	CategoryServiceI cs;

	@GetMapping
	public Page<Product> AllProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> prod = ps.findAll(pageable);
		return prod;
	}

	@PostMapping
	public ResponseEntity<Product> postProd(@RequestBody Product prod) {
		Category category = cs.singledata(prod.getCategory().getCid());
		prod.setCategory(category);
		Product savedProduct = ps.save(prod);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}

	@GetMapping("/{id}")
	public Product selectProdById(@PathVariable("id") long id) {
		return ps.singledata(id);
	}

	@PutMapping("/{id}")
	public Product updateProd(@PathVariable("id") long id, @RequestBody Product prodDetails) {
		Product prod = ps.singledata(id);
		if (prod != null) {
			prod.setProdname(prodDetails.getProdname());
			prod.setProdprice(prodDetails.getProdprice());

			ps.save(prod);
			return prod;
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable("id") long id) {
		Product prod = ps.singledata(id);
		if (prod != null) {
			ps.delete(prod);
			return "Product deleted successfully.";
		}
		return "Product not found.";
	}
}
