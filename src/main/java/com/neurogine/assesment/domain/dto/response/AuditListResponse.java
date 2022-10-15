package com.neurogine.assesment.domain.dto.response;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.neurogine.assesment.domain.entity.Audit.Action;
import com.neurogine.assesment.domain.entity.Audit.Status;

import lombok.Data;

@Data
public class AuditListResponse {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private Status status;
		
	@Enumerated(EnumType.STRING)
	private Action action;
	
	private String remark;
}
