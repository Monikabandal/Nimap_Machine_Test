package com.springboot.prodrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
 Category  findByCid(long cid);
}
