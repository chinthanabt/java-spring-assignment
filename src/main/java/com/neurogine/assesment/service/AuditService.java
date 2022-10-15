package com.neurogine.assesment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neurogine.assesment.domain.dto.response.AuditListResponse;
import com.neurogine.assesment.domain.entity.Audit;
import com.neurogine.assesment.repository.AuditRepository;

/**
 * 
 * @author Chinthana
 *
 */
@Service
public class AuditService {

	@Autowired
	private AuditRepository auditRepository;

	public void createAudit(Audit audit) {
		auditRepository.save(audit);
	}

	public List<AuditListResponse> getAllAudits() {

		List<AuditListResponse> list = new ArrayList<>();

		auditRepository.findAll().forEach(s -> {
			AuditListResponse auditListResponse = new AuditListResponse();
			BeanUtils.copyProperties(s, auditListResponse);
			list.add(auditListResponse);
		});

		return list;
	}
}
