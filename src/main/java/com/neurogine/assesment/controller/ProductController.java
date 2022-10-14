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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neurogine.assesment.domain.dto.request.ProductCreateRequest;
import com.neurogine.assesment.domain.dto.request.ProductUpdateRequest;
import com.neurogine.assesment.domain.dto.response.ProductListResponse;
import com.neurogine.assesment.domain.entity.Product;
import com.neurogine.assesment.service.ProductService;

@RestController
@RequestMapping(value = "/product", produces = { APPLICATION_JSON_VALUE })
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping
	public ResponseEntity<Void> createProduct(@ModelAttribute ProductCreateRequest productCreateRequest) {
		productService.createProduct(productCreateRequest);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ProductListResponse>> listProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable String id) {
		return ResponseEntity.ok(productService.getProductById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable String id) {
		productService.deleteProductById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateProductById(@PathVariable String id, @RequestBody ProductUpdateRequest productUpdateRequest) {
		productService.updateProductById(id, productUpdateRequest);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
