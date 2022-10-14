package com.neurogine.assesment.domain.dto.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ProductListResponse {
	private String id;
	
	private String name;
	
	private String category;
	
	private double price;
	
	private String condition;
	
	private String description;
	
	private List<ProductImageResponse> images = new ArrayList<>();
}
