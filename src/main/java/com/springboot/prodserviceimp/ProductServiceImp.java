package com.springboot.prodserviceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.springboot.model.Product;
import com.springboot.prodrepository.ProdRepository;
import com.springboot.prodservicei.ProdServiceI;

@Service
public class ProductServiceImp implements ProdServiceI {
@Autowired
 ProdRepository pr;

@Override
public Product save(Product p) {
	return pr.save(p);
	
}

@Override
public Page<Product> findAll(Pageable pageable) {
    return pr.findAll(pageable);
}

@Override
public void delete(Product p) {
	pr.delete(p);
	
}

@Override
public Product singledata(long prodid) {

	return pr.findByProdid(prodid)  ;
	
	
}


}
