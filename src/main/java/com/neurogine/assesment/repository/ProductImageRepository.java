package com.neurogine.assesment.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neurogine.assesment.domain.entity.ProductImage;


@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage, Long>{
	
	Optional<ProductImage> findById(UUID id);

}
