package com.neurogine.assesment.domain.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true)
	private UUID id;

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
