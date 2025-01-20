package com.springboot.prodserviceimp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.model.Category;

import com.springboot.prodrepository.CategoryRepository;
import com.springboot.prodservicei.CategoryServiceI;


@Service
public class CategoryServiceImp implements CategoryServiceI {

	@Autowired
	CategoryRepository cr;

	@Override
	public Category save(Category c) {
		return cr.save(c);
		
	}

	
	@Override
	public Page<Category> findall(Pageable pageable) {
	    return cr.findAll(pageable);
	}

	@Override
	public void delete(Category c) {
	cr.delete(c);
		
	}

	@Override
	public Category singledata(long cid) {
		return cr.findByCid(cid);
		
		
	}


	
}
