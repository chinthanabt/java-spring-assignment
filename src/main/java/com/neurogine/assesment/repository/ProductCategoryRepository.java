package com.neurogine.assesment.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.neurogine.assesment.domain.entity.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long>{
	Optional<ProductCategory> findById(UUID id);
	
	List<ProductCategory> findAll();
}
