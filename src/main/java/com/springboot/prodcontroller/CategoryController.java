package com.springboot.prodcontroller;

import com.springboot.model.Category;
import com.springboot.prodservicei.CategoryServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
     CategoryServiceI cs;

    
    @GetMapping
    public Page<Category> AllProd(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> prod = cs.findall(pageable);
        return prod;
    }
 
    @PostMapping
    public Category postCategory(@RequestBody Category cate) {
    	cs.save(cate);
        return cate;
    }
 
   
    
    
    @GetMapping("/{id}")
    public Category selectCateById(@PathVariable("id") long id) {
        Category cate =cs.singledata(id);
        
            return cate;
        } 

  

    
    
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable("id") long id, @RequestBody Category cateDetails) {
        Category cate = cs.singledata(id);
        if (cate != null) {
            cate.setCname(cateDetails.getCname());
         
            cs.save(cate);
            return cate;
        }
        return null;
    }

   
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable("id") long id) {
        Category cate = cs.singledata(id);
        if (cate != null) {
        	cs.delete(cate);
            return "Category deleted successfully.";
        }
        return "Category not found.";
    }
}
