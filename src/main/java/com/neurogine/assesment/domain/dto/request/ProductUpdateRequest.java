package com.neurogine.assesment.domain.dto.request;

import lombok.Data;

@Data
public class ProductUpdateRequest {
	private String name;
	
	private String category;
	
	private double price;
	
	private String condition;
	
	private String description;
}
