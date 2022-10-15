package com.neurogine.assesment.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neurogine.assesment.domain.dto.response.AuditListResponse;
import com.neurogine.assesment.service.AuditService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Chinthana
 *
 */

@Api(value = "Audit Contoller")
@RestController
@RequestMapping(value = "/audit", produces = { APPLICATION_JSON_VALUE })
public class AuditController {
	
	@Autowired
	AuditService auditService;
	
	@ApiOperation(value = "List All Audits")
	@GetMapping
	public ResponseEntity<List<AuditListResponse>> listAllAudits() {
		return ResponseEntity.ok(auditService.getAllAudits());
	}


}
