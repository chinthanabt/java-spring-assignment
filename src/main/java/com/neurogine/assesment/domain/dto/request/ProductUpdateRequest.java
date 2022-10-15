package com.neurogine.assesment.domain.dto.request;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductUpdateRequest {
	private String name;
	
	private String category;
	
	private double price;
	
	private String condition;
	
	private String description;
	
	private List<MultipartFile> images = new ArrayList<>();
}
