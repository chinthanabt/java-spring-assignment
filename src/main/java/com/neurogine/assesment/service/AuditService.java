package com.neurogine.assesment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neurogine.assesment.domain.entity.Audit;
import com.neurogine.assesment.repository.AuditRepository;

@Service
public class AuditService {
	
	@Autowired
	private AuditRepository auditRepository;
	
	public void createAudit(Audit audit) {
		auditRepository.save(audit);
	}
}
