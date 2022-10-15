package com.neurogine.assesment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neurogine.assesment.domain.dto.request.ProductCategoryCreateRequest;
import com.neurogine.assesment.domain.dto.response.ProductCategoryListResponse;
import com.neurogine.assesment.domain.entity.ProductCategory;
import com.neurogine.assesment.repository.ProductCategoryRepository;


/**
 * 
 * @author Chinthana
 *
 */

@Service
public class ProductCategoryService {
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	public void createCategory(ProductCategoryCreateRequest productCategoryCreateRequest) {		
		ProductCategory category = new ProductCategory();
		BeanUtils.copyProperties(productCategoryCreateRequest, category);
		productCategoryRepository.save(category);
	}
	
	public List<ProductCategoryListResponse> ListAllProductCategory() {		
		List<ProductCategoryListResponse> list = new ArrayList<>();
		
		productCategoryRepository.findAll().forEach( s -> {
			ProductCategoryListResponse category = new ProductCategoryListResponse();	
			BeanUtils.copyProperties(s, category);
			category.setId(s.getId());
			list.add(category);
			
		});
		
		return list;
	}

}
