package com.neurogine.assesment.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neurogine.assesment.common.Constant;
import com.neurogine.assesment.domain.dto.request.ProductCreateRequest;
import com.neurogine.assesment.domain.dto.request.ProductUpdateRequest;
import com.neurogine.assesment.domain.dto.response.ProductImageResponse;
import com.neurogine.assesment.domain.dto.response.ProductListResponse;
import com.neurogine.assesment.domain.entity.Product;
import com.neurogine.assesment.domain.entity.ProductCategory;
import com.neurogine.assesment.domain.entity.ProductImage;
import com.neurogine.assesment.exception.ResourceNotFoundException;
import com.neurogine.assesment.repository.ProductCategoryRepository;
import com.neurogine.assesment.repository.ProductImageRepository;
import com.neurogine.assesment.repository.ProductRepository;

/**
 * 
 * @author Chinthana
 *
 */

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductImageRepository productImageRepository;

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	public void createProduct(ProductCreateRequest productCreateRequest) {
		Product product = new Product();
		BeanUtils.copyProperties(productCreateRequest, product);

		ProductCategory category = productCategoryRepository.findById(productCreateRequest.getCategory())
				.orElseThrow(() -> new ResourceNotFoundException(Constant.Responsecode.CATEGORY_NOT_FOUND.getMessage(),
						Constant.Responsecode.CATEGORY_NOT_FOUND.getCode()));
		
		product.setCategory(category);
		productRepository.save(product);
		
		// save Images
		productCreateRequest.getImages().forEach(s -> {
			try {
				String imageStr = Base64.getEncoder().encodeToString(s.getBytes());
				ProductImage image = new ProductImage();
				image.setContent(imageStr);
				image.setName(s.getOriginalFilename());
				image.setProduct(product);
				productImageRepository.save(image);
			} catch (IOException e) {
				e.printStackTrace();
			}

		});

	}
	
	@Transactional
	public List<ProductListResponse> getAllProducts() {
		List<ProductListResponse> list = new ArrayList<>();		
		productRepository.findAll().forEach(s -> {
			List<ProductImageResponse> imageList = new ArrayList<>();
			ProductListResponse product = new ProductListResponse();
			BeanUtils.copyProperties(s, product);
			product.setId(s.getId());
			product.setCategory(s.getCategory().getName());	
			
			s.getImages().forEach( image -> {			
				ProductImageResponse imageRes = new ProductImageResponse();
				BeanUtils.copyProperties(image, imageRes);
				imageRes.setId(image.getId());
				imageList.add(imageRes);
			});
			
			product.setImages(imageList);			
			list.add(product);
		});
		
		return list;
	}
	
	public Product getProductById(long id) {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constant.Responsecode.PRODUCT_NOT_FOUND.getMessage(),
				Constant.Responsecode.PRODUCT_NOT_FOUND.getCode()));
	}
	
	@Transactional
	public void deleteProductById(long id) {	
		
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constant.Responsecode.PRODUCT_NOT_FOUND.getMessage(),
				Constant.Responsecode.PRODUCT_NOT_FOUND.getCode()));
		
		//Delete previous images
		productImageRepository.deleteByProduct(product);
		//Delete product
		productRepository.delete(product);
	}
	
	@Transactional
	public void updateProductById(long id, ProductUpdateRequest productUpdateRequest) {		
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constant.Responsecode.PRODUCT_NOT_FOUND.getMessage(),
				Constant.Responsecode.PRODUCT_NOT_FOUND.getCode()));
		
		BeanUtils.copyProperties(productUpdateRequest, product);	
		productRepository.save(product);
		
		//Delete previous images
		productImageRepository.deleteByProduct(product);
		// save Images
		productUpdateRequest.getImages().forEach(s -> {
			try {
				String imageStr = Base64.getEncoder().encodeToString(s.getBytes());
				ProductImage image = new ProductImage();
				image.setContent(imageStr);
				image.setName(s.getOriginalFilename());
				image.setProduct(product);
				productImageRepository.save(image);
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
	}	

}
