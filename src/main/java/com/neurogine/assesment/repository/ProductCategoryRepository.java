package com.neurogine.assesment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.neurogine.assesment.domain.entity.ProductCategory;


/**
 * 
 * @author Chinthana
 *
 */
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long>{
	Optional<ProductCategory> findById(long id);
	
	List<ProductCategory> findAll();
}
