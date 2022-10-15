package com.neurogine.assesment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neurogine.assesment.domain.entity.Product;
import com.neurogine.assesment.domain.entity.ProductImage;
import com.neurogine.assesment.repository.ProductImageRepository;

/**
 * 
 * @author Chinthana
 *
 */

@Service
public class ProductImageService {

	@Autowired
	ProductImageRepository productImageRepository;
	
	public void createProductImage(ProductImage productImage) {
		productImageRepository.save(productImage);
	}
	
	void deleteByProduct(Product product) {
		productImageRepository.deleteByProduct(product);
	}

}
