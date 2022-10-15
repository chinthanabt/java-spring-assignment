package com.neurogine.assesment.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neurogine.assesment.domain.dto.request.ProductCreateRequest;
import com.neurogine.assesment.domain.dto.request.ProductUpdateRequest;
import com.neurogine.assesment.domain.dto.response.ProductListResponse;
import com.neurogine.assesment.domain.entity.Product;
import com.neurogine.assesment.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Chinthana
 *
 */

@Api(value = "Product Controller")
@RestController
@RequestMapping(value = "/product", produces = { APPLICATION_JSON_VALUE })
public class ProductController {

	@Autowired
	ProductService productService;

	@ApiOperation(value = "Create Product")
	@PostMapping
	public ResponseEntity<Void> createProduct(@ModelAttribute ProductCreateRequest productCreateRequest) {
		productService.createProduct(productCreateRequest);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "List All Products")
	@GetMapping
	public ResponseEntity<List<ProductListResponse>> listProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@ApiOperation(value = "View Product By Id")
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		return ResponseEntity.ok(productService.getProductById(id));
	}
	
	@ApiOperation(value = "Delete Product By Id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable long id) {
		productService.deleteProductById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
		
	@ApiOperation(value = "Update Product By Id")
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateProductById(@PathVariable long id, @ModelAttribute ProductUpdateRequest productUpdateRequest) {
		productService.updateProductById(id, productUpdateRequest);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
