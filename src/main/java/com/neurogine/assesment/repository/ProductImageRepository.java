package com.neurogine.assesment.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neurogine.assesment.domain.entity.Product;
import com.neurogine.assesment.domain.entity.ProductImage;


@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage, Long>{
	
	Optional<ProductImage> findById(long id);
	
	void deleteByProduct(Product product);

}
