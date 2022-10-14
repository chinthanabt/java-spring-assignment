package com.neurogine.assesment.domain.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Chinthana
 *
 */
@Entity
@Setter
@Getter
public class Merchant extends BaseEntity {
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true)
	private UUID id;
	
	private String name;
	
	private String email;
	
	private String primaryContactNo;
	
	// etc
	
}
