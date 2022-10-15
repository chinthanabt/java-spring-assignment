package com.neurogine.assesment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neurogine.assesment.domain.entity.Audit;

/**
 * 
 * @author Chinthana
 *
 */
@Repository
public interface AuditRepository extends CrudRepository<Audit, Long> {	
	List<Audit> findAll();
}