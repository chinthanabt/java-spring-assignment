package com.neurogine.assesment.domain.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@ManyToOne
	@JoinColumn(name="category_id")
	private ProductCategory category;

	@OneToMany(mappedBy = "product")
	private List<ProductImage> images;
	
	private double price;

	private String condition;

	private String description;

}
