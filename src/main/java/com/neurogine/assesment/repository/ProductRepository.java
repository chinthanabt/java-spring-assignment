package com.neurogine.assesment.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neurogine.assesment.domain.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {	
	Optional<Product> findById(long id);
	
	List<Product> findAll();
}
