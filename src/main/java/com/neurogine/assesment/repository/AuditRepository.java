package com.neurogine.assesment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neurogine.assesment.domain.entity.Audit;

@Repository
public interface AuditRepository extends CrudRepository<Audit, Long> {

}
