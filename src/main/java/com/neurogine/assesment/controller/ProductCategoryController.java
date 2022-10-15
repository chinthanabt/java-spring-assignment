package com.neurogine.assesment.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neurogine.assesment.domain.dto.request.ProductCategoryCreateRequest;
import com.neurogine.assesment.domain.dto.response.ProductCategoryListResponse;
import com.neurogine.assesment.service.ProductCategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Chinthana
 *
 */

@Api(value = "Product Category Controller")
@RestController
@RequestMapping(value = "/productCategory", produces = { APPLICATION_JSON_VALUE })
public class ProductCategoryController {
	
	@Autowired
	ProductCategoryService productCategoryService;

	@ApiOperation(value = "Create Product Category")
	@PostMapping
	public ResponseEntity<Void> createCategory(@RequestBody ProductCategoryCreateRequest productCategoryCreateRequest) {
		productCategoryService.createCategory(productCategoryCreateRequest);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "List Product Categories")
	@GetMapping
	public ResponseEntity<List<ProductCategoryListResponse>> ListAllProductCategory() {		
		return ResponseEntity.ok(productCategoryService.ListAllProductCategory());
	}
}
