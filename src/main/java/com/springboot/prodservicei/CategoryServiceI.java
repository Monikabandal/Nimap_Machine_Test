package com.springboot.prodservicei;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.model.Category;

public interface CategoryServiceI {
  Category save(Category c);
 Page<Category>findall(Pageable pageable) ;
  
  void delete(Category c);
  Category singledata(long cid);
  
}
